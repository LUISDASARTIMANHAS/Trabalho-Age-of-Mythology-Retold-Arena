
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiros.Egipcios;

import Arena.Arena;
import Guerreiros.TipoGuerreiro;

/**
 *
 * @author 2023122760328
 */
public class Anubita extends TipoGuerreiroEgipicios {
    //    Anubita: possui ataque de 15 pontos de energia, mas ataca 2 vezes. Ataca o primeiro
    //guerreiro e depois salta para o final da fila e ataca o último guerreiro da fila adversária.
    
    public Anubita(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    @Override
    public void ataque(Arena arena,TipoGuerreiro defenders) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void forcarAtaque(Arena arena,TipoGuerreiro defenders) {
        ataque(arena, defenders);
    }
}