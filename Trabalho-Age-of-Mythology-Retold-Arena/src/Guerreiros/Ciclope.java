/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiros;

/**
 *
 * @author LUIS DAS ARTIMANHAS
 */
public class Ciclope extends Guerreiro{
    private int dano = 35;

    public Ciclope(String nome, int idade, float peso) {
        super(nome, idade, peso);
    }

    public int getDano() {
        return dano;
    }
    
}
