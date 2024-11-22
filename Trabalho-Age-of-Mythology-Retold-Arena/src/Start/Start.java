
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

        // Lê os guerreiros e organiza as filas na arena
        arena.lerArqGuerreiro();
        arena.iniciarCombate();
//        letra A
        arena.exibirFilas();
//        Letra B
        arena.exibirPesosDasRacas();
//
//        letra C
        arena.exibirGuerreiroMaisVeio();
//        // Exibe os dados dos guerreiros da arena
//        arena.exibirTodasAsFilas();
    }
}
