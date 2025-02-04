/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.educastur.axdrianfh92.Tienda;

import java.io.IOException;
import java.io.Serializable;
import java.io.FileWriter;


/**
 *
 * @author alu07d
 */
public class Cliente implements Serializable, Comparable<Cliente> {

    static Object values() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private final String idCliente; // DNI
    private final String nombre;
    private String telefono;
    private String email;

    public Cliente(String idCliente, String nombre, String telefono, String email) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        setTelefono(telefono);
        setEmail(email);
    }

    public String getIdCliente() {
        return idCliente;
    }

    public final void setTelefono(String telefono) {
        if (telefono.matches("\\d{9}"))
            this.telefono = telefono;
        else
            throw new IllegalArgumentException("Teléfono no válido (debe tener 9 dígitos)");
    }

    public final void setEmail(String email) {
        if (email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$"))
            this.email = email;
        else
            throw new IllegalArgumentException("Email no válido");
    }

    @Override
    public int compareTo(Cliente otro) {
        return this.nombre.compareTo(otro.nombre);
    }

    @Override
    public String toString() {
        return idCliente + " - " + nombre + " - Tel: " + telefono + " - Email: " + email;
    }

        public void exportarClientesCSV() {
    try (FileWriter fw = new FileWriter("clientes/clientes.csv")) {
        for (Cliente cliente : Clientes.values()) {
            fw.write(cliente.getIdCliente() + "," +
                     cliente.getNombre() + "," +
                     // Asumiendo que tienes getters para teléfono y email:
                     cliente.getTelefono() + "," +
                     cliente.getEmail() + "\n");
        }
        System.out.println("Clientes exportados a CSV correctamente.");
    } catch (IOException e) {
        System.out.println("Error al exportar CSV: " + e.getMessage());
    }
}

    private String getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getTelefono() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class Clientes {

        private static Iterable<Cliente> values() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public Clientes() {
        }
    }

    
    
}

