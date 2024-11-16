<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Start;

import Arena.Arena;
import Guerreiros.TipoGuerreiro;

/**
 *
 * @author LUIS DAS ARTIMANHAS
 */
public class Start {

    public static void main(String[] args) {
        // Criando uma instância da Arena
        Arena arena = new Arena();
        
        // Simulação de leitura dos guerreiros (leitura de arquivos pode ser simulada ou implementada)
        // Exemplo de leitura de guerreiros:
        // LeituraDeArquivo.lerArqGuerreiro(arena, "1");  // Lê o arquivo lado11.txt e lado12.txt
        
        // Exibe os dados de ambos os lados
        arena.exibirDados();
        
        // Soma dos pesos de ambos os lados
        float pesoLado1 = arena.somarPesos(arena.filasLado1);
        float pesoLado2 = arena.somarPesos(arena.filasLado2);
        System.out.println("\nSoma dos pesos:");
        System.out.println("Gregos e Nórdicos pesam " + pesoLado1 + " kilos");
        System.out.println("Atlantes e Egípcios pesam " + pesoLado2 + " kilos");

        // TipoGuerreiro mais velho
        TipoGuerreiro guerreiroMaisVelho = arena.guerreiroMaisVelho();
        System.out.println("\nO guerreiro mais velho é " + guerreiroMaisVelho.getNome() + " e tem " + guerreiroMaisVelho.getIdade() + " anos.");

        // Determinação do vencedor
        String vencedor = arena.determinarVencedor();
        System.out.println("\nO lado vencedor foi: " + vencedor);
        
        // Dados do último guerreiro derrotado
        TipoGuerreiro ultimoDerrotado = arena.ultimoDerrotado();
        System.out.println("\nO último guerreiro derrotado foi: " + 
                ultimoDerrotado.getNome() + 
                ", " + 
                ultimoDerrotado.getIdade() + 
                " anos, " + 
                ultimoDerrotado.getPeso() + 
                " kilos.");
        
        // Dados do guerreiro que transferiu o último ataque
        TipoGuerreiro guerreiroUltimoAtaque = arena.guerreiroUltimoAtaque();
        System.out.println("\nO guerreiro que transferiu o último ataque foi: " + 
                guerreiroUltimoAtaque.getNome() + 
                ", " + 
                guerreiroUltimoAtaque.getIdade() + 
                " anos, " + 
                guerreiroUltimoAtaque.getPeso() + 
                " kilos.");
    }
    
}