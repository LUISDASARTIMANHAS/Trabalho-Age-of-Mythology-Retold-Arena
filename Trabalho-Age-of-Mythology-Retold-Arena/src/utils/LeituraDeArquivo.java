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
    public static String fReadString(Scanner file) {
        String valor = file.next();
        return valor;
    }

    public static void LerGuerreiro(Scanner file) {
//        <tipo 1> <nome 1> <idade 1> <peso 1>
//        1 NitTe 30 70;
        int type = 0;
        String name = null;
        int idade = 0;
        int peso = 0;
        int i = 1;

        while (file.hasNext()) {
            type = fReadInt(file);
            name = fReadString(file);
            idade = fReadInt(file);
            peso = fReadInt(file);
            System.out.println("Guerreiro Lido: " + name + ", Tipo: "+type+", Idade: "+ idade+", Peso: "+peso);
//            crie um guerreiro aqui ou copie esse codigo para a arena;
        }
        file.close();
    }
    
    public static void lerArqGuerreiro() {
        Scanner lado1 = fopen("lado2" + i + ".txt");
        Scanner lado2 = fopen("lado2" + i + ".txt");
    }

    public static void main(String[] args) {
        lerArqGuerreiro();
//        Scanner file = fopen("arq.txt");
//        int num1 = fReadInt(file);
//        System.out.println(num1);
//        file.close();
    }

}
