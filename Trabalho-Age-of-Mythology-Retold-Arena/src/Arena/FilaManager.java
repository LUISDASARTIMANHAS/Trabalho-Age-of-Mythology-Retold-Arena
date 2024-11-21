
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arena;

import Guerreiros.TipoGuerreiro;
import java.util.LinkedList;

public class FilaManager {

    // gerencia as filas de guerreiros para cada lado
    // Lista principal de filas
    private LinkedList<FilaManagerDeGuerreiros> filas;
    private double pesoLado1;
    private double pesoLado2;
    private int qtdeDeFilas;

    // Construtor da classe FilaManager
    public FilaManager() {
        this.filas = new LinkedList<>();
        this.pesoLado1 = 0;
        this.pesoLado2 = 0;
        this.qtdeDeFilas = 0;
    }

    //    Getters
    public LinkedList<FilaManagerDeGuerreiros> getFilas() {
        return filas;
    }

    public int getQtdeDeFilas() {
        return qtdeDeFilas;
    }

    public double getPesoLado1() {
        return pesoLado1;
    }

    public double getPesoLado2() {
        return pesoLado2;
    }

    //Funções
    // Método para adicionar uma fila de guerreiros à lista principal
    public void adicionarFila(FilaManagerDeGuerreiros fila) {
        getFilas().add(fila);
    }

    // Método para exibir todas as filas de guerreiros
    public void exibirTodasAsFilas() {
        int filaIndex = 1;
        for (FilaManagerDeGuerreiros fila : getFilas()) {
            System.out.println("Fila " + filaIndex + ":");
            fila.exibirFila();
            filaIndex++;
            System.out.println();
        }
    }

    // Soma os pesos de todos os guerreiros de todos os lados
    public double somarPesosTotais() {
        double somaPesos = 0;
//        percorre e adiciona fila para cada item em filas
        for (FilaManagerDeGuerreiros fila : filas) {
            somaPesos += fila.getPesoTotalDaFila();
            this.qtdeDeFilas++;
        }
        return somaPesos;
    }

    public double somarPesosLado1() {
        double somaPesosLado1 = 0;
        int metade = filas.size() / 2; // Calcula o ponto médio para dividir os lados

        // Soma os pesos das filas do lado 1
        for (int i = 0; i < metade; i++) {
            somaPesosLado1 += filas.get(i).getPesoTotalDaFila();
        }

        this.pesoLado1 = somaPesosLado1;
        return somaPesosLado1;
    }

    public double somarPesosLado2() {
        double somaPesosLado2 = 0;
        int metade = filas.size() / 2; // Calcula o ponto médio para dividir os lados

        // Soma os pesos das filas do lado 2
        for (int i = metade; i < filas.size(); i++) {
            somaPesosLado2 += filas.get(i).getPesoTotalDaFila();
        }

        this.pesoLado2 = somaPesosLado2;
        return somaPesosLado2;
    }

    // Método para remover guerreiros mortos das filas
    public void removerGuerreirosMortos() {
        for (FilaManagerDeGuerreiros fila : filas) {
            fila.removerGuerreirosMortos();
        }
    }
    
    // Verifica se o jogo deve continuar ou se terminou
    public boolean verificarEstadoJogo() {
        boolean jogoAtivo = true;
        
        // Exemplo: se todas as filas estiverem vazias (sem guerreiros vivos), o jogo termina
        for (FilaManagerDeGuerreiros fila : filas) {
            for (TipoGuerreiro guerreiro : fila.getFila()) {
                if (guerreiro.getEnergia() > 0) {
                    jogoAtivo = true;  // Se houver algum guerreiro vivo, o jogo continua
                    break;
                }
            }
        }

        if (!jogoAtivo) {
            System.out.println("O jogo terminou!");
            jogoAtivo = false;  // O jogo terminou
        }
        return jogoAtivo;
    }

}
