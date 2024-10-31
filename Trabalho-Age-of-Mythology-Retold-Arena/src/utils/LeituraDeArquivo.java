/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeituraDeArquivo {
    
    public static Scanner fopen(String localFile) {
        try {
            FileInputStream file = new FileInputStream(localFile);
            Scanner scan = new Scanner(file);
            Console.log("INFO: Arquivo " + localFile + "Aberto. Bom Uso!");
            return scan;
        } catch (FileNotFoundException error) {
            Console.error("Erro: Arquivo Não Encontrado. ERR:" + error);
        }
        return null;
    }
    public static int fReadInt(Scanner file) {
            int valor = file.nextInt();
            return valor;
    }
    public static double fReadDouble(Scanner file) {
            double valor = file.nextDouble();
            return valor;
    }

    public static void main(String[] args) {
            Scanner file = fopen("arq.txt");
            int num1 = fReadInt(file);
            System.out.println(num1);
            file.close();
    }
    
    
}
