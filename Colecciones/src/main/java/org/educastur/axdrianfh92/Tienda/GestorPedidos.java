/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.educastur.axdrianfh92.Tienda;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author alu07d
 */
public class GestorPedidos {
    private final List<Pedido> pedidos = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void agregarPedido() {
        System.out.print("Introduce el DNI del cliente: ");
        String dni = scanner.nextLine();
        Pedido pedido = new Pedido(dni);
        String respuesta;
        do {
            System.out.print("Introduce el ID del artículo: ");
            String idArticulo = scanner.nextLine();
            System.out.print("Introduce la cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            LineaPedido linea = new LineaPedido(idArticulo, cantidad);
            pedido.agregarArticulo(linea);
            System.out.print("¿Quieres añadir otro artículo? (s/n): ");
            respuesta = scanner.nextLine();
        } while (respuesta.equalsIgnoreCase("s"));
        pedidos.add(pedido);
        System.out.println("Pedido creado con éxito.");
    }

    public void listarPedidosPorImporte() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            pedidos.stream()
                    .sorted(Comparator.comparingDouble(Pedido::totalPedido).reversed())
                    .forEach(System.out::println);
        }
    }

    public void listarPedidosPorFecha() {
        // Si se tuviera un atributo fecha en Pedido, se podría ordenar. 
        // En este ejemplo se listan en orden de creación.
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            pedidos.forEach(System.out::println);
        }
    }
    
    public void listarPedidosConImporteMayorA() {
    System.out.print("Introduce el importe mínimo: ");
    double importeMin = Double.parseDouble(scanner.nextLine());
    pedidos.stream()
           .filter(p -> p.totalPedido() > importeMin)
           .forEach(System.out::println);
    }
    
    /**
     *
     * @return
     */
    public double totalVentas() {
    return pedidos.stream()
                  .mapToDouble(Pedido::totalPedido)
                  .sum();
}
    
    public void listarPedidosConImporteMayor() {
    System.out.print("Introduce el importe mínimo: ");
    double importeMin = Double.parseDouble(scanner.nextLine());
    pedidos.stream()
           .filter(p -> p.totalPedido() > importeMin)
           .forEach(System.out::println);
}
    
    public void listarPedidosEntreFechas() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    try {
        System.out.print("Introduce la fecha de inicio (dd/MM/yyyy HH:mm): ");
        LocalDateTime inicio = LocalDateTime.parse(scanner.nextLine(), formatter);
        System.out.print("Introduce la fecha de fin (dd/MM/yyyy HH:mm): ");
        LocalDateTime fin = LocalDateTime.parse(scanner.nextLine(), formatter);
        
        pedidos.stream()
               .filter(p -> p.getFechaCreacion().isAfter(inicio) && p.getFechaCreacion().isBefore(fin))
               .forEach(System.out::println);
    } catch (Exception e) {
        System.out.println("Formato de fecha incorrecto. Por favor, utiliza dd/MM/yyyy HH:mm.");
    }
    }
    
    public void agruparPedidosPorCliente() {
    Map<String, List<Pedido>> pedidosPorCliente = pedidos.stream()
            .collect(Collectors.groupingBy(p -> p.idCliente)); // si idCliente es privado, crea un getter en Pedido

    pedidosPorCliente.forEach((cliente, listaPedidos) -> {
        System.out.println("Cliente: " + cliente);
        listaPedidos.forEach(p -> System.out.println("  " + p));
    });
    
    
    }
    
    public void exportarPedidosCSV() {
    try (FileWriter fw = new FileWriter("pedidos/pedidos.csv")) {
        fw.write("ID Pedido,ID Cliente,Fecha,Artículos,Total\n");
        for (Pedido pedido : pedidos) {
            fw.write(pedido.idPedido + "," + pedido.idCliente + "," +
                     pedido.getFechaFormateada() + ",\"" + pedido.cestaCompra + "\"," +
                     pedido.totalPedido() + "\n");
        }
        System.out.println("Pedidos exportados a CSV correctamente.");
    } catch (IOException e) {
        System.out.println("Error al exportar pedidos a CSV: " + e.getMessage());
    }
}
}

