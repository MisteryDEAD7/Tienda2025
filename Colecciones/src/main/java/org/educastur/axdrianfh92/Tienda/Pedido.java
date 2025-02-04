/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.educastur.axdrianfh92.Tienda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



/**
 *
 * @author alu07d
 */
public class Pedido implements Serializable {
    private static int contador = 1;

    private static Object stream() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    final String idPedido;
    final String idCliente;
    final List<LineaPedido> cestaCompra;
    private final LocalDateTime fechaCreacion;

    public Pedido(String idCliente) {
        this.idCliente = idCliente;
        this.idPedido = idCliente + "-" + String.format("%04d", contador++) + "/2025";
        this.cestaCompra = new ArrayList<>();
        this.fechaCreacion = LocalDateTime.now();

    }

    
    
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    
    public String getFechaFormateada() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    return fechaCreacion.format(formatter);
    }
    
    public void agregarArticulo(LineaPedido linea) {
        cestaCompra.add(linea);
    }
    

    // En una implementación real se calcularía el total a partir del precio de cada artículo.
    // Aquí simulamos el cálculo (por ejemplo, cada artículo a 10€).
    public double totalPedido() {
        return cestaCompra.stream().mapToDouble(l -> l.getCantidad() * 10).sum();
    }

    @Override
    public String toString() {
           return idPedido + " - Cliente: " + idCliente + 
               " - Fecha: " + getFechaFormateada() +
               " - Artículos: " + cestaCompra + 
               " - Total: " + totalPedido() + "€";
    }
      
}

