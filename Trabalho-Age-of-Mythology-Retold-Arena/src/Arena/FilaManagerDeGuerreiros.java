
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

    LinkedList<TipoGuerreiro> fila;

    public FilaManagerDeGuerreiros() {
        this.fila = new LinkedList<>();
    }

    // Adiciona um guerreiro à fila
    public void adicionarGuerreiro(TipoGuerreiro guerreiro) {
        if (fila.size() < 4) {
            fila.add(guerreiro);
        } else {
            System.out.println("Fila cheia.");
        }
    }

    // Exibe todos os guerreiros da fila
    public void exibirFila() {
        for (TipoGuerreiro guerreiro : fila) {
            System.out.println(guerreiro);
        }
    }

    // Remover guerreiros mortos
    public void removerGuerreirosMortos() {
        fila.removeIf(guerreiro -> guerreiro.getEnergia() <= 0);
    }

    // Getter para a fila
    public LinkedList<TipoGuerreiro> getFila() {
        return fila;
    }
}