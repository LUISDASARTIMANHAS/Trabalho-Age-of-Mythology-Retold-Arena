/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author 2023122760328
 */
public class Console {
    public static void log(String texto) {
        System.out.println(texto);
    }
    public static void error(String texto) {
        System.err.println("Err: " + texto);
    }
}

