
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiros.Gregos;

import Arena.Arena;
import Arena.FilaManagerDeGuerreiros;
import Guerreiros.TipoGuerreiro;

public class Manticora extends TipoGuerreiroGregos {

//    Mantícora: possui uma cabeça humana e corpo de leão com espinhos em seu rabo. Promove;
//um ataque que acerta inimigos não só na mesma linha, mas também nas proximidades. Se
//estiver numa fila 1, acerta o inimigo da fila 1 e da fila 2. Se estiver na fila 2, acerta o inimigo
//da fila 2 e das filas 1 e 3. Se estiver na fila 3, acerta o inimigo da fila 3 e os inimigos das
//filas 2 e 4. Se estiver na fila 4, acerta o inimigo da fila 4 e da fila 3. O inimigo atacado na
//mesma linha recebe dano de 30, os inimigos das linhas próximas recebem dano de 15
    public Manticora(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void ataque(Arena arena,TipoGuerreiro defenders) {
        // Determina a fila em que a Mantícora está
        FilaManagerDeGuerreiros filaAtual = arena.getGestorDeFilas().getFilaAtual(this);
        int ladoAtual = filaAtual.getLado();  // Pega o lado da fila atual

        // Se o guerreiro está na fila do lado 1, ele ataca o lado 2
        if (ladoAtual == 1) {
            atacarLado2(arena,defenders);  // Ataca as filas do lado 2
        } else if (ladoAtual == 2) {
            atacarLado1(arena, defenders);  // Ataca as filas do lado 1
        }
    }

    private void atacarLado2(Arena arena,TipoGuerreiro defenders) {
        // Ataca as filas do lado 2 (filas com índices maiores que o meio)
        for (int i = arena.getGestorDeFilas().getQtdeDeFilas() / 2; i < arena.getGestorDeFilas().getQtdeDeFilas(); i++) {
            FilaManagerDeGuerreiros filaAtacada = arena.getGestorDeFilas().getFila(i + 1);
            aplicarDano(defenders);  // Aplica dano na fila do lado 2
        }
    }

    private void atacarLado1(Arena arena,TipoGuerreiro defenders) {
        // Ataca as filas do lado 1 (filas com índices menores ou iguais ao meio)
        for (int i = 0; i < arena.getGestorDeFilas().getQtdeDeFilas() / 2; i++) {
            FilaManagerDeGuerreiros filaAtacada = arena.getGestorDeFilas().getFila(i + 1);
            aplicarDano(defenders);  // Aplica dano na fila do lado 1
        }
    }

    private void aplicarDano(TipoGuerreiro defenders) {
            darDano(defenders,30);
            System.out.println(defenders.getNome() + " recebeu " + 30 + " de dano!");
    }

    @Override
    public void forcarAtaque(Arena arena,TipoGuerreiro defenders) {
        ataque(arena, defenders);
    }
}
