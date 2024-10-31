/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiros;

import Arena.Arena;

/**
 *
 * @author LUIS DAS ARTIMANHAS
 */
public abstract class TipoGuerreiro {

    protected Arena Arena;
    private String nome;
    private int idade;
    private float peso;
    private int energia = 100;
    private boolean entityEnvenenada = false;
    private boolean entityRegenerar = false;
    private boolean entity = false;

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

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Arena getArena() {
        return Arena;
    }

    public boolean isEntityEnvenenada() {
        return entityEnvenenada;
    }

    public boolean isEntityRegenerar() {
        return entityRegenerar;
    }

    public boolean isEntity() {
        return entity;
    }
    
    
    public abstract void ataque(Arena arena);
    public abstract void onEntityDie(Arena arena);

}
