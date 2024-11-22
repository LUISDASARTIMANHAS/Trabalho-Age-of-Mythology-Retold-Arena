
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiros.Gregos;

import Arena.Arena;
import Arena.FilaManagerDeGuerreiros;
import Guerreiros.TipoGuerreiro;

/**
 *
 * @author LUIS DAS ARTIMANHAS
 */
public class Ciclope extends TipoGuerreiroGregos {
//    Ciclope: um gigante de um olho só. Promove um ataque que retira 35 pontos de energia e
//depois, se foi o primeiro atacar, “joga” o adversário para o final de sua fila (na prática se foi
//o primeiro a atacar não vai permitir que o adversário ataque, mas recebe o ataque do
//atacante seguinte da fila inimiga).

    public Ciclope(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void ataque(Arena arena,TipoGuerreiro defenders) {
        // Obtém o adversário da fila inimiga
        FilaManagerDeGuerreiros filaInimiga = arena.getGestorDeFilas().getFilaInimiga(this);

        if (filaInimiga == null || filaInimiga.getFila().isEmpty()) {
            System.out.println("Não há adversários para atacar!");
            return;
        }

        // Retira 35 pontos de energia do adversário
        darDano(defenders,35);
        System.out.println(this.getNome() + " atacou " + defenders.getNome() + " e retirou 35 pontos de energia!");

        // Verifica se o Ciclope é o primeiro a atacar na sua fila
        boolean ehPrimeiroNaFila = arena.getGestorDeFilas().getFilaDoLado(this).getFila().peekFirst() == this;

        if (ehPrimeiroNaFila) {
            // Remove o adversário da fila e coloca no final
            filaInimiga.getFila().remove(defenders);
            filaInimiga.getFila().addLast(defenders);

            System.out.println(defenders.getNome() + " foi movido para o final da fila inimiga!");
        }
    }

    @Override
    public void forcarAtaque(Arena arena,TipoGuerreiro defenders) {
        ataque(arena, defenders);
    }
}
