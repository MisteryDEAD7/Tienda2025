/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.educastur.axdrianfh92.Tienda;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author alu07d
 */
public class GestorArticulos {
    private final Map<String, Articulo> articulos = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public void agregarArticulo() {
        System.out.print("Introduce el ID del artículo: ");
        String id = scanner.nextLine();
        System.out.print("Introduce el nombre del artículo: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce el precio: ");
        double precio = Double.parseDouble(scanner.nextLine());
        System.out.print("Introduce el stock inicial: ");
        int stock = Integer.parseInt(scanner.nextLine());
        Articulo articulo = new Articulo(id, nombre, precio, stock);
        articulos.put(id, articulo);
        System.out.println("Artículo agregado con éxito.");
    }

    public void listarArticulos() {
        if (articulos.isEmpty()) {
            System.out.println("No hay artículos registrados.");
        } else {
            articulos.values().forEach(System.out::println);
        }
    }
    
    public void listarArticulosAgotados() {
    articulos.values().stream()
             .filter(a -> a.getStock() == 0)
             .forEach(System.out::println);
}

    public void reponerArticulo() {
        System.out.print("Introduce el ID del artículo a reponer: ");
        String id = scanner.nextLine();
        Articulo articulo = articulos.get(id);
        if (articulo == null) {
            System.out.println("Artículo no encontrado.");
            return;
        }
        System.out.print("Introduce la cantidad a reponer: ");
        int cantidad = Integer.parseInt(scanner.nextLine());
        try {
            articulo.reponerStock(cantidad);
            System.out.println("Stock repuesto con éxito.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void eliminarArticulo() {
        System.out.print("Introduce el ID del artículo a eliminar: ");
        String id = scanner.nextLine();
        if (articulos.remove(id) != null) {
            System.out.println("Artículo eliminado.");
        } else {
            System.out.println("Artículo no encontrado.");
        }
    }
    
    public void listarArticulosPorSeccion() {
    System.out.print("Introduce el número de sección (1, 2, 3, ...): ");
    String seccion = scanner.nextLine();
    articulos.values().stream()
            .filter(a -> a.getIdArticulo().startsWith(seccion + "-"))
            .forEach(System.out::println);

    }
}
