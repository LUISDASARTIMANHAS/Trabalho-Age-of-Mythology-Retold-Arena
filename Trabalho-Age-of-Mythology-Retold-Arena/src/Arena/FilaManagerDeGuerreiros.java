
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
import java.util.Iterator;
import java.util.LinkedList;

public class FilaManagerDeGuerreiros {
//    gerencia a fila que tem algum guerreiro
//    guerreiros estao aqui
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
    public int getLado() {    
        return lado;
    }

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
        this.fila.add(guerreiro);

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
    
    // Método que verifica se um guerreiro está na fila
    public boolean contemGuerreiro(TipoGuerreiro guerreiro) {
        for (TipoGuerreiro g : fila) {
            if (g.equals(guerreiro)) {  // Verifica se o guerreiro na fila é o mesmo
                return true;  // Retorna verdadeiro se encontrar o guerreiro
            }
        }
        return false;  // Retorna falso caso o guerreiro não esteja na fila
    }

    // Remover guerreiros mortos
    public void removerGuerreirosMortos() {
        // Usando o Iterator para evitar problemas de concorrência ao remover elementos
        Iterator<TipoGuerreiro> iterator = fila.iterator();

        while (iterator.hasNext()) {
            TipoGuerreiro guerreiro = iterator.next();
            if (guerreiro.getEnergia() <= 0) {
                iterator.remove();  // Remove o guerreiro morto da fila
                qtdeDeGuerreiros--;  // Atualiza a quantidade de guerreiros na fila
            }
        }
    }

    public TipoGuerreiro guerreiroMaisVelhoDaFila() {
        TipoGuerreiro maisVelho = null;

        for (TipoGuerreiro guerreiro : fila) {
            if (maisVelho == null || guerreiro.getIdade() > maisVelho.getIdade()) {
                maisVelho = guerreiro;
            }
        }

        return maisVelho;
    }

}
