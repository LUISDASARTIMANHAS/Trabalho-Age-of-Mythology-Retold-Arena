<<<<<<< HEAD
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

//    Primeiramente é necessário definir o que é um Guerreiro.Um Guerreiro é alguém
//    que luta e possui obrigatoriamente
//    :
//• Nome
//    • Idade
//    • Peso
//    • Energia
//    : que deve ser inicializada em 100 no momento da criação do Guerreiro(por padrão os guerreiros possuem energia em 100 unidades) 
//    Guerreiros morrem quando sua energia fica menor ou igual a 0 (nesse caso, por padrão são retirados da sua respectiva fila)

    private String nome;
    private int idade;
    private float peso;
    private int energia = 100;
    private boolean entityEnvenenada = false;
    private boolean entityRegenerar = false;
    private boolean entityDie = false;

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

    public boolean isEntityEnvenenada() {
        return entityEnvenenada;
    }

    public boolean isEntityRegenerar() {
        return entityRegenerar;
    }
    
    public void reduzirEnergia(int valor) {
        energia = energia - valor;
        if (energia <= 0) {
            energia = 0;
        }
    }

    public abstract void ataque(Arena arena);

    public abstract void onEntityDie(Arena arena);

}