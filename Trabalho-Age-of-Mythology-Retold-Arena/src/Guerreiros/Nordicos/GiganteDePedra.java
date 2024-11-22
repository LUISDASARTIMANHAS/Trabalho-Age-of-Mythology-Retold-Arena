
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiros.Nordicos;

import Arena.Arena;
import Arena.FilaManagerDeGuerreiros;
import Guerreiros.TipoGuerreiro;

public class GiganteDePedra extends TipoGuerreiroNordicos {

    private static boolean primeiroATacar = true; // Flag para controlar quem é o primeiro a atacar

    //    Gigante de Pedra: são guerreiros de pedra muito resistentes a ataques pois possuem,
    //inicialmente, 300 pontos de energia. Quando atacam promovem o dano de 30 pontos de
    //energia. Quando é o primeiro a atacar força o lado adversário a atacá-lo, independente das
    //filas dos adversários. Se 2 Gigantes de Pedra ativarem a habilidade (em filas diferentes) o
    //último a ativar é o que será atacado.
    public GiganteDePedra(String nome, int idade, double peso) {
        super(nome, idade, peso);
        this.setEnergia(300);
    }

    @Override
    public void ataque(Arena arena, TipoGuerreiro defenders) {
        // Obtém a fila atual do guerreiro
        FilaManagerDeGuerreiros filaAtual = arena.getGestorDeFilas().getFilaAtual(this);

        if (primeiroATacar) {
            primeiroATacar = false; // Apenas o primeiro ataque força os adversários
            // Se for o primeiro a atacar, forçará o lado adversário a atacá-lo
            for (FilaManagerDeGuerreiros filaAdversaria : arena.getGestorDeFilas().getFilasAdversarias(this)) {
                // Itera sobre todos os guerreiros da fila adversária
                for (TipoGuerreiro guerreiroAdversario : filaAdversaria.getFila()) {
                    guerreiroAdversario.forcarAtaque(arena, this); // Força cada guerreiro a atacar este
                }
            }
        }

        // Realiza o ataque no defensor especificado
        darDano(defenders, 30);
    }

    @Override
    public void forcarAtaque(Arena arena, TipoGuerreiro defenders) {
        ataque(arena, defenders);
    }
}
