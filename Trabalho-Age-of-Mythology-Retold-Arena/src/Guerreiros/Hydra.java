/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiros;

public class Hydra extends TipoGuerreiro{
    private int dano = 35;

    public Hydra(String nome, int idade, float peso) {
        super(nome, idade, peso);
    }

    @Override
    public void ataque(TipoGuerreiro atacante, TipoGuerreiro vitima) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
