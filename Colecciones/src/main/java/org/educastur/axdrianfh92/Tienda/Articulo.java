/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.educastur.axdrianfh92.Tienda;

import java.io.Serializable;

/**
 *
 * @author alu07d
 */
 

 
public class Articulo implements Serializable, Comparable<Articulo> {
    private final String idArticulo;
    private final String nombre;
    private final double precio;
    private int stock;

    public Articulo(String idArticulo, String nombre, double precio, int stock) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void reponerStock(int cantidad) {
        if (cantidad > 0) {
            this.stock += cantidad;
        } else {
            throw new IllegalArgumentException("La cantidad a reponer debe ser positiva.");
        }
    }

    @Override
    public int compareTo(Articulo otro) {
        return this.idArticulo.compareTo(otro.idArticulo);
    }

    @Override
    public String toString() {
        return idArticulo + " - " + nombre + " - Precio: " + precio + "€ - Stock: " + stock;
    }
    
    public void retirarStock(int cantidad) throws UnidadesInsuficientesException {
    if (cantidad <= stock) {
        stock -= cantidad;
    } else {
        throw new UnidadesInsuficientesException("Stock insuficiente para el artículo " + idArticulo);
    }
}

    int getStock() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
