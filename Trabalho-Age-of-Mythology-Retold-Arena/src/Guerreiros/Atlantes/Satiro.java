
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
public class Satiro extends TipoGuerreiroAtlantes{
    //    Sátiro: são guerreiros que utilizam lanças para atacar a distância. Quando atacam tiram
    //apenas 10 pontos de energia, entretanto acertam todos os guerreiros da fila adversária.
    
    public Satiro(String nome, int idade, double peso) {
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