<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiros.Gregos;

import Arena.Arena;

public class Manticora extends TipoGuerreiroGregos {
    
//    Mantícora: possui uma cabeça humana e corpo de leão com espinhos em seu rabo. Promove;
//um ataque que acerta inimigos não só na mesma linha, mas também nas proximidades. Se
//estiver numa fila 1, acerta o inimigo da fila 1 e da fila 2. Se estiver na fila 2, acerta o inimigo
//da fila 2 e das filas 1 e 3. Se estiver na fila 3, acerta o inimigo da fila 3 e os inimigos das
//filas 2 e 4. Se estiver na fila 4, acerta o inimigo da fila 4 e da fila 3. O inimigo atacado na
//mesma linha recebe dano de 30, os inimigos das linhas próximas recebem dano de 15
    
    public Manticora(String nome, int idade, float peso) {
        super(nome, idade, peso);
    }

    @Override
    public void ataque(Arena arena) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onEntityDie(Arena arena) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}