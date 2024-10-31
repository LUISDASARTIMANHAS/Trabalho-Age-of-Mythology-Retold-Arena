/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package leituradearquivo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeituraDeArquivo {
    
    public static Scanner fopen(String localFile) {
        try {
            FileInputStream file = new FileInputStream(localFile);
            Scanner scan = new Scanner(file);
            return scan;
        } catch (FileNotFoundException error) {
            System.out.println("Erro: Arquivo Não Encontrado. ERR:" + error);
        }
        return null;
    }

    public static void main(String[] args) {
            var file = fopen("arq.txt");
            int num1 = file.nextInt();
            int num2 = file.nextInt();
            double num3 = file.nextDouble();
            System.out.println(num1 + num2);
            System.out.println(num3);
            file.close();
    }
    
    
}
