
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
public class Mumia extends TipoGuerreiroEgipicios {
//    Múmia: são antigos faraós mortos. Possuem ataque de 50 pontos de energia. Quando mata
//um adversário gera um morto vivo e acrescenta em sua fila. Esse morto vivo possui ataque
//de 5 pontos de energia e começa com 100 pontos de energia (assim como a maioria dos
//guerreiros). Quando uma Múmia morre ela invoca 4 Anubitas para vinga-la (sendo
//colocadas no final da fila de seus aliados). O morto-vivo “nasce” com o nome, idade e peso
//do guerreiro adversário morto. Já os Anubitas vingadores “nascem” com o nome da múmia
//morta, idade = 0 e peso = 60.

    
    public Mumia(String nome, int idade, double peso) {
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