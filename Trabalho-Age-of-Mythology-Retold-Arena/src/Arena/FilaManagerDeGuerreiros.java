
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arena;

/**
 *
 * @author LUIS DAS ARTIMANHAS
 */
import Guerreiros.TipoGuerreiro;
import java.util.LinkedList;

public class FilaManagerDeGuerreiros {
//    gerencia a fila que tem algum guerreiro

    private LinkedList<TipoGuerreiro> fila;
    private double pesoTotalDaFila;
    private int qtdeDeGuerreiros;
//    taget do lado onde a fila esta
    private int lado;

    public FilaManagerDeGuerreiros(int lado) {
        this.qtdeDeGuerreiros = 0;
        this.lado = lado;
        this.fila = new LinkedList<TipoGuerreiro>();
    }

    // Getters
    // Getter para a fila
    public LinkedList<TipoGuerreiro> getFila() {
        return fila;
    }

    public double getPesoTotalDaFila() {
        return somarPesoDaFila();
    }

    public int getQtdeDeGuerreiros() {
        return qtdeDeGuerreiros;
    }

    // Funções
    // Adiciona um guerreiro à fila
    public void adicionarGuerreiro(TipoGuerreiro guerreiro) {
        getFila().add(guerreiro);

    }

    public void exibirEstadoFila() {
        System.out.println("Estado da fila (Lado " + lado + "):");
        System.out.println("Quantidade de Guerreiros: " + getQtdeDeGuerreiros());
        System.out.println("Peso Total da Fila: " + somarPesoDaFila());
        exibirFila();  // Exibe os guerreiros na fila
    }

    // Exibe todos os guerreiros da fila
    public void exibirFila() {
        for (TipoGuerreiro guerreiro : getFila()) {
            System.out.println(guerreiro);
        }
    }

    public double somarPesoDaFila() {
        pesoTotalDaFila = 0;
        for (TipoGuerreiro guerreiro : getFila()) {
            pesoTotalDaFila += guerreiro.getPeso();
        }
        return pesoTotalDaFila;
    }

    // Remover guerreiros mortos
    public void removerGuerreirosMortos() {
        getFila().removeIf(guerreiro -> guerreiro.getEnergia() <= 0);
    }
}
