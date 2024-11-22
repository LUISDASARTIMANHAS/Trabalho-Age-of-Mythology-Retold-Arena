
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guerreiros.Atlantes;

import Arena.Arena;
import Arena.FilaManagerDeGuerreiros;
import Guerreiros.TipoGuerreiro;

/**
 *
 * @author 2023122760328
 */
public class Prometeano extends TipoGuerreiroAtlantes {

    private static int geracao = 1;
    private int danoAtual = 10;
//    Prometeano: são guerreiros de barro que se dividem em 2 quando morrem (cada um com
//50% da energia original do prometeano e ambos colocados no final da fila do prometeano
//original). Quando um prometeano chega a 1 ponto de energia, quando morre ele
//efetivamente é eliminado. O ataque de um prometeano é de 10 unidades de energia. Peso e
//idade passam do prometado morto para seus descendentes. Por sua vez, o nome dos
//descentes do prometeano é a concatenação no nome do prometeano que o gerou com o
//número 1 ou 2 (dependendo se ele é o primeiro ou segundo descendente).

    public Prometeano(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    public Prometeano(String nome, int idade, double peso, int dano) {
        super(nome + geracao, idade, peso);
        this.danoAtual = dano;
    }

    @Override
    public void ataque(Arena arena,TipoGuerreiro defenders) {
        dividir(arena);
    }

    private Prometeano gerarDescendente() {
//        dividem em 2 quando morrem (cada um com
//50% da energia original do prometeano
//        Por sua vez, o nome dos
//descentes do prometeano é a concatenação no nome do prometeano que o gerou com o
//número 1 ou 2 (dependendo se ele é o primeiro ou segundo descendente)
        return new Prometeano(
                String.valueOf(this.getNome()),
                this.getIdade(),
                this.getPeso(),
                this.danoAtual / 2
        );
    }

    // Dividir o prometeano em dois novos guerreiros e adicionar na fila
    private void dividir(Arena arena) {
        // Não divide se a energia for 0 ou menor
        if (this.getEnergia() <= 0) {
            return;
        }

        // Criação de dois descendentes com 50% da energia do prometeano
        Prometeano descendente1 = gerarDescendente(); // Primeiro descendente
        Prometeano descendente2 = gerarDescendente(); // Segundo descendente

        // A energia do prometeano original é zerada, pois ele se divide
        this.setEnergia(0);

        // Acessando a fila do Prometeano pai (da arena) e adicionando os descendentes no final
        FilaManagerDeGuerreiros filaAtual = arena.getGestorDeFilas().getFilaAtual(this); // A fila do Prometeano

        // Adicionando os descendentes no final da fila
        filaAtual.adicionarGuerreiro(descendente1); // Adicionando descendente 1
        filaAtual.adicionarGuerreiro(descendente2); // Adicionando descendente 2
    }

    @Override
    public void forcarAtaque(Arena arena,TipoGuerreiro defenders) {
        ataque(arena, defenders);
    }
}
