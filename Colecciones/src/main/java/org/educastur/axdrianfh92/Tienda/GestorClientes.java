/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.educastur.axdrianfh92.Tienda;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alu07d
 */
public class GestorClientes {
    private final Map<String, Cliente> clientes = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(GestorClientes.class.getName());
    // ... resto de la clase ...

    public void agregarCliente() {
        System.out.print("Introduce el DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Introduce el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce el teléfono (9 dígitos): ");
        String tel = scanner.nextLine();
        System.out.print("Introduce el email: ");
        String email = scanner.nextLine();
        try {
            Cliente cliente = new Cliente(dni, nombre, tel, email);
            clientes.put(dni, cliente);
            System.out.println("Cliente agregado con éxito.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al agregar cliente: " + e.getMessage());
            logger.log(Level.INFO, "Cliente agregado: {0}", dni);        }
        // ... código de agregar cliente ...
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            clientes.values().stream().sorted().forEach(System.out::println);
        }
    }

    public void modificarCliente() {
        System.out.print("Introduce el DNI del cliente a modificar: ");
        String dni = scanner.nextLine();
        Cliente cliente = clientes.get(dni);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        System.out.print("Introduce el nuevo teléfono (9 dígitos): ");
        String tel = scanner.nextLine();
        System.out.print("Introduce el nuevo email: ");
        String email = scanner.nextLine();
        try {
            cliente.setTelefono(tel);
            cliente.setEmail(email);
            System.out.println("Cliente modificado con éxito.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void eliminarCliente() {
        System.out.print("Introduce el DNI del cliente a eliminar: ");
        String dni = scanner.nextLine();
        if (clientes.remove(dni) != null) {
            System.out.println("Cliente eliminado.");
        } else {
            System.out.println("Cliente no encontrado.");
            logger.log(Level.INFO, "Cliente eliminado: {0}", dni);
                    // ... código de eliminación ...
        }
    }
    
}

