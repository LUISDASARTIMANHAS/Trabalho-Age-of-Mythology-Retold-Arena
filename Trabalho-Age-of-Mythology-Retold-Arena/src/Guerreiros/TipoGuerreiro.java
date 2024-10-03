/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiros;

/**
 *
 * @author LUIS DAS ARTIMANHAS
 */
public abstract class TipoGuerreiro {

    private String nome;
    private int idade;
    private float peso;
    private int energia = 100;
    private int dano = 0;

    public TipoGuerreiro(String nome, int idade, float peso) {
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

    public int getDano() {
        return dano;
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
    
    public abstract void ataque(TipoGuerreiro atacante,TipoGuerreiro vitima); 

}
