
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiros.Gregos;

import Arena.Arena;
import Guerreiros.TipoGuerreiro;

public class Hydra extends TipoGuerreiroGregos {

    private int numeroDeCabecas;  // Número de cabeças da Hydra
    private int ataqueBase;        // Ataque inicial da Hydra
    //Hidra: parece um dinossauro aquático, ganha uma cabeça para cada inimigo que mata. Seu
    //ataque inicial é de 50 pontos de energia, mas ganha mais 5 pontos de ataque para cada
    //cabeça nova gerada, além de mais 20 pontos de recuperação de energia para si mesmo (se a
    //hidra não tiver sido atacada ainda, ou seja, tiver os 100 pontos de energia, nada acontece).

    public Hydra(String nome, int idade, double peso) {
        super(nome, idade, peso);
        this.numeroDeCabecas = 0;
        this.ataqueBase = 50;
    }

    public int getNumeroDeCabecas() {
        return numeroDeCabecas;
    }

    public void setNumeroDeCabecas(int numeroDeCabecas) {
        this.numeroDeCabecas = numeroDeCabecas;
    }

    public int getAtaqueBase() {
        return ataqueBase;
    }

    public void setAtaqueBase(int ataqueBase) {
        this.ataqueBase = ataqueBase;
    }

    @Override
    public void ataque(Arena arena,TipoGuerreiro defenders) {
        // Lógica do ataque
        // Calculando o dano com base no número de cabeças
        int dano = ataqueBase + (numeroDeCabecas - 1) * 5;  // A cada cabeça, o dano aumenta 5 pontos
        darDano(defenders,dano);
        System.out.println(this.getNome() + " atacou e causou " + dano + " de dano!");

        // A cada inimigo morto, a Hydra ganha uma cabeça e recupera energia
        if (arena.inimigoMorreu(defenders)) {
            numeroDeCabecas++;
            System.out.println(
                    this.getNome()
                    + " ganhou uma cabeça! Número de cabeças: " + numeroDeCabecas
            );

            // Recuperando energia se a Hydra não estiver com energia cheia
            if (this.getEnergia() < super.getEnergia()) {
                int energiaRecuperada = 20;
                int novaEnergia = Math.min(this.getEnergia() + energiaRecuperada, super.getEnergia());  // Garantir que não ultrapasse 100
                this.setEnergia(novaEnergia);
                System.out.println(this.getNome() + " recuperou 20 pontos de energia! Energia atual: " + this.getEnergia());
            }
        }
    }

    @Override
    public void forcarAtaque(Arena arena,TipoGuerreiro defenders) {
        ataque(arena, defenders);
    }
}
