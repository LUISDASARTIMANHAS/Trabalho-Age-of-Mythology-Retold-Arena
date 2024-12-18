
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiros.Atlantes;

import Arena.Arena;
import Guerreiros.TipoGuerreiro;

/**
 *
 * @author 2023122760328
 */
public class Argus extends TipoGuerreiroAtlantes{
    //    Argus: guerreiro atlante monstruoso, ele ataca com uma bolha de ácido que mata o inimigo
    //imediatamente independente da energia do inimigo. Argus também é frágil e sua energia
    //começa em 60 pontos.
    
    public Argus(String nome, int idade, double peso) {
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