
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiros.Nordicos;

import Arena.Arena;
import Arena.FilaManagerDeGuerreiros;
import Guerreiros.TipoGuerreiro;
import java.util.LinkedList;

/**
 *
 * @author 2023122760328
 */
public class LoboDeFenris extends TipoGuerreiroNordicos {

    // Ataque base do Lobo de Fenris
    private int ataqueBase = 40;
    // Aumento de ataque por Lobo de Fenris atrás
    private int aumentoPorLobo = 8;
//    Lobo de Fenris: são lobos gigantes ferozes. Seu ataque é de 40 pontos de energia. Entretanto
//seu ataque aumenta 8 pontos de energia para cada Lobo de Fenris que estiver atrás dele. Ou
//seja, se houverem 2 lobos na sequência na fila, o Lobo atual ganha mais 16 pontos de ataque
//(8 para cada lobo) totalizando 56 pontos de ataque. É importante notar que essa mudança é
//dinâmica, ou seja, se um lobo morre o processo precisa ser recalculado.

    public LoboDeFenris(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    private int calcularAtaque(Arena arena) {
        FilaManagerDeGuerreiros filaAtual = arena.getGestorDeFilas().getFilaAtual(this);
        int ataqueTotal = ataqueBase;
        LinkedList<TipoGuerreiro> fila = filaAtual.getFila();  // Obtém a fila interna de guerreiros
        int posicaoAtual = fila.indexOf(this);  // Encontra a posição do LoboDeFenris na fila

        for (int i = posicaoAtual + 1; i < fila.size(); i++) {  // A partir do próximo guerreiro
            TipoGuerreiro guerreiro = fila.get(i);  // Obtém o guerreiro da posição i
            if (guerreiro instanceof LoboDeFenris) {
                ataqueTotal += aumentoPorLobo;
            }
        }

        return ataqueTotal;
    }

    @Override
    public void ataque(Arena arena, TipoGuerreiro defenders) {
        // para recalcular o ataque com base nos lobos que estão atrás dele
        int ataqueTotal = calcularAtaque(arena);

        darDano(defenders, ataqueTotal);
        // Aqui o lobo ataca com o valor total de ataque calculado
        System.out.println(getNome() + " atacou com " + ataqueTotal + " de dano!");

    }
    
    @Override
    public void forcarAtaque(Arena arena,TipoGuerreiro defenders) {
        ataque(arena, defenders);
    }

}
