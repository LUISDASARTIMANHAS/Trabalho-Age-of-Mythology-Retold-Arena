<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiros.Atlantes;

import Arena.Arena;

/**
 *
 * @author 2023122760328
 */
public class Prometeano extends TipoGuerreiroAtlantes {

//    Prometeano: são guerreiros de barro que se dividem em 2 quando morrem (cada um com
//50% da energia original do prometeano e ambos colocados no final da fila do prometeano
//original). Quando um prometeano chega a 1 ponto de energia, quando morre ele
//efetivamente é eliminado. O ataque de um prometeano é de 10 unidades de energia. Peso e
//idade passam do prometado morto para seus descendentes. Por sua vez, o nome dos
//descentes do prometeano é a concatenação no nome do prometeano que o gerou com o
//número 1 ou 2 (dependendo se ele é o primeiro ou segundo descendente).

    public Prometeano(String nome, int idade, float peso) {
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
