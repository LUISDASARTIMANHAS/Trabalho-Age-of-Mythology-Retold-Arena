
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Start;

import Arena.Arena;
import Arena.FilaManager;

/**
 *
 * @author LUIS DAS ARTIMANHAS
 */
public class Start {
    
    public static void main(String[] args) {
        Arena arena = new Arena();
        FilaManager filaManager = arena.getGestorDeFilas();
        
//        letra A
        // Lê os guerreiros e organiza as filas na arena
        arena.lerArqGuerreiro();
        
//        Letra B
        arena.exibirPesosDasRacas();
//
//        letra C
//        // Exibe os dados dos guerreiros da arena
//        arena.exibirTodasAsFilas();
    }
}