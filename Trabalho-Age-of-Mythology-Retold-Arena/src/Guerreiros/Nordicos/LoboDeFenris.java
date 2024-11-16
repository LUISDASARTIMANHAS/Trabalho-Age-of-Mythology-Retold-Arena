
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiros.Nordicos;

import Arena.Arena;

/**
 *
 * @author 2023122760328
 */
public class LoboDeFenris extends TipoGuerreiroNordicos {
//    Lobo de Fenris: são lobos gigantes ferozes. Seu ataque é de 40 pontos de energia. Entretanto
//seu ataque aumenta 8 pontos de energia para cada Lobo de Fenris que estiver atrás dele. Ou
//seja, se houverem 2 lobos na sequência na fila, o Lobo atual ganha mais 16 pontos de ataque
//(8 para cada lobo) totalizando 56 pontos de ataque. É importante notar que essa mudança é
//dinâmica, ou seja, se um lobo morre o processo precisa ser recalculado.

    public LoboDeFenris(String nome, int idade, double peso) {
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