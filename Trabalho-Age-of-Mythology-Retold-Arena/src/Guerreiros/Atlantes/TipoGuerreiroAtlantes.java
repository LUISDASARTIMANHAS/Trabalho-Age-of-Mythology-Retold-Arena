/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiros.Atlantes;

import Guerreiros.*;

/**
 *
 * @author LUIS DAS ARTIMANHAS
 */
public abstract class TipoGuerreiroAtlantes {

    private String nome;
    private int idade;
    private float peso;
    private int energia = 100;

    public TipoGuerreiroAtlantes(String nome, int idade, float peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
    }

    public int getEnergia() {
        return energia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    
    public abstract void ataque(TipoGuerreiroAtlantes atacante,TipoGuerreiroAtlantes vitima); 

}
