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
public class LineaPedido implements Serializable {
    private final String idArticulo;
    private final int cantidad;

    public LineaPedido(String idArticulo, int cantidad) {
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return idArticulo + " x" + cantidad;
    }
}


