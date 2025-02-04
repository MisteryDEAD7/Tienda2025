/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.educastur.axdrianfh92.Tienda;

import java.util.Scanner;




/**
 *
 * @author alu07d
 */
 
public class Tienda {
    // Instancias globales de los gestores.
    private static GestorClientes gestorClientes = new GestorClientes();
    private static GestorArticulos gestorArticulos = new GestorArticulos();
    private static GestorPedidos gestorPedidos = new GestorPedidos();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
              // Intentar cargar los gestores desde archivos
        gestorClientes = (GestorClientes) Persistencia.cargar("clientes.dat");
        if (gestorClientes == null) {
            gestorClientes = new GestorClientes();
        }
        
        gestorArticulos = (GestorArticulos) Persistencia.cargar("articulos.dat");
        if (gestorArticulos == null) {
            gestorArticulos = new GestorArticulos();
        }
        
        gestorPedidos = (GestorPedidos) Persistencia.cargar("pedidos.dat");
        if (gestorPedidos == null) {
            gestorPedidos = new GestorPedidos();
        }
        
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN TIENDA ---");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Artículos");
            System.out.println("3. Gestión de Pedidos");
            System.out.println("4. Copia de Seguridad");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> menuClientes();
                case 2 -> menuArticulos();
                case 3 -> menuPedidos();
                case 4 -> guardarDatos();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    private static void menuClientes() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN CLIENTES ---");
            System.out.println("1. Añadir Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Modificar Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("0. Volver");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> gestorClientes.agregarCliente();
                case 2 -> gestorClientes.listarClientes();
                case 3 -> gestorClientes.modificarCliente();
                case 4 -> gestorClientes.eliminarCliente();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    private static void menuArticulos() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN ARTÍCULOS ---");
            System.out.println("1. Añadir Artículo");
            System.out.println("2. Listar Artículos");
            System.out.println("3. Reponer Stock");
            System.out.println("4. Eliminar Artículo");
            System.out.println("0. Volver");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> gestorArticulos.agregarArticulo();
                case 2 -> gestorArticulos.listarArticulos();
                case 3 -> gestorArticulos.reponerArticulo();
                case 4 -> gestorArticulos.eliminarArticulo();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    private static void menuPedidos() {
    int opcion;
    do {
        System.out.println("\n--- GESTIÓN PEDIDOS ---");
        System.out.println("1. Crear Pedido");
        System.out.println("2. Listar Pedidos por Importe");
        System.out.println("3. Listar Pedidos por Fecha");
        System.out.println("4. Listar Pedidos entre Fechas");
        System.out.println("5. Agrupar Pedidos por Cliente");
        System.out.println("6. Exportar Pedidos a CSV");
        System.out.println("7. Mostrar Total de Ventas");
        System.out.println("8. Modificar Pedido");
        System.out.println("9. Cancelar Pedido");
        System.out.println("10. Aplicar Descuento a Pedido");
        System.out.println("0. Volver");
        System.out.print("Elige una opción: ");
        opcion = Integer.parseInt(scanner.nextLine());

        switch (opcion) {
            case 1 -> gestorPedidos.agregarPedido();
            case 2 -> gestorPedidos.listarPedidosPorImporte();
            case 3 -> gestorPedidos.listarPedidosPorFecha();
            case 4 -> gestorPedidos.listarPedidosEntreFechas();
            case 5 -> gestorPedidos.agruparPedidosPorCliente();
            case 6 -> gestorPedidos.exportarPedidosCSV();
            case 7 -> System.out.println("Total de Ventas: " + gestorPedidos.totalVentas() + "€");
            case 8 -> gestorPedidos.modificarPedido();
            case 9 -> gestorPedidos.cancelarPedido();
            case 10 -> gestorPedidos.aplicarDescuentoAPedido();
            case 0 -> System.out.println("Volviendo al menú principal...");
            default -> System.out.println("Opción no válida");
        }
    } while (opcion != 0);
}

    
    private static void guardarDatos() {
        Persistencia.guardar("clientes.dat", gestorClientes);
        Persistencia.guardar("articulos.dat", gestorArticulos);
        Persistencia.guardar("pedidos.dat", gestorPedidos);
        System.out.println("Datos guardados correctamente.");
    }
    
    
    
}



    