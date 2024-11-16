
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package utils;

import Arena.Arena;
import Arena.FilaManagerDeGuerreiros;
import Guerreiros.Nordicos.GiganteDePedra;
import Guerreiros.TipoGuerreiro;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeituraDeArquivo {

    // Método para abrir o arquivo
    public static Scanner fopen(String localFile) {
        try {
            FileInputStream file = new FileInputStream(localFile);
            Scanner scan = new Scanner(file);
            Console.log("INFO: Arquivo " + localFile + " aberto. Bom uso!");
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

    public static String fReadString(Scanner file) {
        return file.next();
    }

    // Método para ler um guerreiro do arquivo e criar o guerreiro
    public static void lerGuerreiro(Scanner file, FilaManagerDeGuerreiros fila) {
        // Dados do guerreiro: tipo, nome, idade, peso
        int tipo;
        String nome;
        int idade;
        int peso;

        while (file.hasNext()) {
            tipo = fReadInt(file);
            nome = fReadString(file);
            idade = fReadInt(file);
            peso = fReadInt(file);
            System.out.println("Guerreiro lido: " + nome + ", Tipo: " + tipo + ", Idade: " + idade + ", Peso: " + peso);

            // Criar o guerreiro de acordo com o tipo e adicionar à fila
            TipoGuerreiro guerreiro = criarGuerreiro(tipo, nome, idade, peso);
            if (guerreiro != null) {
                fila.adicionarGuerreiro(guerreiro);  // Adiciona à fila
            }
        }
    }

    // Método para criar um guerreiro baseado no tipo (você pode expandir com outros tipos de guerreiros)
    public static GiganteDePedra criarGuerreiro(int tipo, String nome, int idade, int peso) {
        // Criação de guerreiros baseados no tipo (por exemplo, tipo 1 cria um GuerreiroFísico)
        switch (tipo) {
            case 1:
                return new GiganteDePedra("a", 10, 23.25);
            // Adicionar mais tipos de guerreiros conforme necessário
            default:
                System.out.println("Tipo de guerreiro desconhecido.");
                return null;
        }
    }

    // Método para ler e processar os arquivos de guerreiros
    public static void lerArqGuerreiro(Arena arena) {
        int i = 1;
        while (true) {
            // Tente abrir o arquivo para a fila i
            String arquivo = "lado" + i + ".txt";
            Scanner file = fopen(arquivo);

            if (file == null) {
                System.out.println("Arquivo não encontrado, terminando a leitura.");
                break;  // Se não encontrar o arquivo, sai do loop
            }

            // Criação de uma nova fila de guerreiros para este arquivo
            FilaManagerDeGuerreiros fila = new FilaManagerDeGuerreiros();

            // Lê os guerreiros deste arquivo e os adiciona à fila
            lerGuerreiro(file, fila);

            // Adiciona a fila à arena
            arena.adicionarFila(fila);

            // Fecha o arquivo
            file.close();

            i++;  // Avança para o próximo arquivo (lado2.txt, lado3.txt, ...)
        }
    }

    // Método main para testar
    public static void main(String[] args) {
        // Criação da arena
        Arena arena = new Arena();

        // Lê os guerreiros e adiciona às filas na arena
        lerArqGuerreiro(arena);

        // Exibe o estado atual da arena
        arena.exibirEstado();
    }
}