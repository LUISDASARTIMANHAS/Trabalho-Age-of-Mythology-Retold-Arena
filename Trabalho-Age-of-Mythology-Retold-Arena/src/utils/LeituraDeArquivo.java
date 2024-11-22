
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeituraDeArquivo {

    // Método para abrir o arquivo
    public static Scanner fopen(String localFile) {
        try {
            FileInputStream file = new FileInputStream(localFile);
            Scanner scan = new Scanner(file);
//            Console.log("INFO: Arquivo " + localFile + " aberto. Bom uso!");
            return scan;
        } catch (FileNotFoundException error) {
            Console.error("Erro: Arquivo não encontrado. ERR:" + error);
        }
        return null;
    }

    // Métodos para ler os tipos de dados
    public static int fReadInt(Scanner file) {
        return file.nextInt();
    }
     public static double fReadDouble(Scanner file) {
        return file.nextDouble();
    }
      public static float fReadFloat(Scanner file) {
        return file.nextFloat();
    }

    public static String fReadString(Scanner file) {
        return file.next();
    }
}