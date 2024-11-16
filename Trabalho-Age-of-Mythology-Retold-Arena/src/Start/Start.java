
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Start;

import Arena.Arena;

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
    }
}