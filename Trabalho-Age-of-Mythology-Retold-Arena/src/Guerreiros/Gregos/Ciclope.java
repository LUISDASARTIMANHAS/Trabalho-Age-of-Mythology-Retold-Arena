<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiros.Gregos;

import Guerreiros.TipoGuerreiro;

/**
 *
 * @author LUIS DAS ARTIMANHAS
 */
public class Ciclope extends TipoGuerreiro{
//    Ciclope: um gigante de um olho só. Promove um ataque que retira 35 pontos de energia e
//depois, se foi o primeiro atacar, “joga” o adversário para o final de sua fila (na prática se foi
//o primeiro a atacar não vai permitir que o adversário ataque, mas recebe o ataque do
//atacante seguinte da fila inimiga).

    public Ciclope(String nome, int idade, float peso) {
        super(nome, idade, peso);
    }

    @Override
    public void ataque(Arena.Arena arena) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onEntityDie(Arena.Arena arena) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}