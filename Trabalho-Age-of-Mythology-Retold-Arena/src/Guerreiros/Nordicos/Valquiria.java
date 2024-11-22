
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
public class Valquiria extends TipoGuerreiroNordicos {
//     Valquíria: é uma espécie de amazona montada num cavalo branco. Possuem poder de cura e
//seu ataque retira 20 pontos de energia. Após atacar, o aliado que estiver após ela, na fila,
//recupera 20 pontos de energia.

    public Valquiria(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void ataque(Arena arena, TipoGuerreiro defensor) {
        // Ataque: retira 20 pontos de energia do defensor
        darDano(defensor, 20);

        // Recuperação do aliado posterior (se houver)
        FilaManagerDeGuerreiros filaAtual = arena.getGestorDeFilas().getFilaAtual(this);
        LinkedList<TipoGuerreiro> fila = filaAtual.getFila();
        int posicaoAtual = fila.indexOf(this); // Encontrar a posição da Valquíria na fila

        // Se houver um guerreiro depois da Valquíria
        if (posicaoAtual + 1 < fila.size()) {
            TipoGuerreiro aliadoPosterior = fila.get(posicaoAtual + 1); // Guerreiro atrás dela
            regenerar(aliadoPosterior,20); // Recupera 20 pontos de energia
        }
    }

    @Override
    public void forcarAtaque(Arena arena,TipoGuerreiro defenders) {
        ataque(arena, defenders);
    }

}
