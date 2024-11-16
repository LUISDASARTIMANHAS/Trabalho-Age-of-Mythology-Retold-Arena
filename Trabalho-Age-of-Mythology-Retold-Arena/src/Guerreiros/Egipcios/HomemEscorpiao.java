<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiros.Egipcios;

import Arena.Arena;


public class HomemEscorpiao extends TipoGuerreiroEgipicios {
//    Homem escorpião: metade homem e metade escorpião. Seu ataque é de 20 pontos,
//entretanto envenena o inimigo. Inimigos envenenados sofrem dano de 5 pontos de energia
//toda vez que promovem um ataque. O veneno do homem escorpião não tem cura, ou seja,
//até que a unidade inimiga morra, toda vez que atacar ela vai perder 5 pontos de energia. Um
//novo envenenamento não gera qualquer efeito sobre uma unidade inimiga, ou seja, o efeito
//de retirar 5 pontos de energia continua até a morte do adversário, mas sem acréscimo de taxa
//de morte.
    
    public HomemEscorpiao(String nome, int idade, float peso) {
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