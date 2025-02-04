/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.educastur.axdrianfh92.Tienda;

import java.util.Scanner;

/**
 *
 * @author alu07d
 */
public class MetodosAux {
    
    public static int leerEntero(String mensaje) {
    Scanner sc = new Scanner(System.in);
    int valor = 0;
    boolean valido = false;
    do {
        System.out.print(mensaje);
        try {
            valor = Integer.parseInt(sc.nextLine());
            valido = true;
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor, introduce un número entero.");
        }
    } while (!valido);
    return valor;
}

    
}
