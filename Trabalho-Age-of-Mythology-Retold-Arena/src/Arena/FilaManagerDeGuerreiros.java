
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

    public FilaManagerDeGuerreiros() {
        this.pesoTotalDaFila = 0;
        this.fila = new LinkedList<TipoGuerreiro>();
    }

    // Adiciona um guerreiro à fila
    public void adicionarGuerreiro(TipoGuerreiro guerreiro) {
        if (getFila().size() < 4) {
            getFila().add(guerreiro);
        } else {
            System.out.println("Fila cheia.");
        }
    }

    // Exibe todos os guerreiros da fila
    public void exibirFila() {
        for (TipoGuerreiro guerreiro : getFila()) {
            System.out.println(guerreiro);
        }
    }
    
    public void somarPesoDaFila() {
        for (TipoGuerreiro guerreiro : getFila()) {
            pesoTotalDaFila += guerreiro.getPeso();
        }
    }

    // Remover guerreiros mortos
    public void removerGuerreirosMortos() {
        getFila().removeIf(guerreiro -> guerreiro.getEnergia() <= 0);
    }

    // Getter para a fila
    public LinkedList<TipoGuerreiro> getFila() {
        return fila;
    }

    /**
     * @param fila the fila to set
     */
    public void setFila(LinkedList<TipoGuerreiro> fila) {
        this.fila = fila;
    }

    /**
     * @return the pesoTotalDaFila
     */
    public double getPesoTotalDaFila() {
        return pesoTotalDaFila;
    }
}