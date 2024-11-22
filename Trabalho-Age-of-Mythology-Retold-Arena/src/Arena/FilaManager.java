
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arena;

import Guerreiros.TipoGuerreiro;
import java.util.LinkedList;

public class FilaManager {

    // gerencia as filas de guerreis para cada lado
    // Lista principal de filas
    private LinkedList<FilaManagerDeGuerreiros> filas;

    // Listas separadas para lado 1 e lado 2
    private LinkedList<FilaManagerDeGuerreiros> filasLado1;
    private LinkedList<FilaManagerDeGuerreiros> filasLado2;
    private double pesoLado1;
    private double pesoLado2;
    private int qtdeDeFilas;

    // Construtor da classe FilaManager
    public FilaManager() {
        this.filas = new LinkedList<>();
        this.filasLado1 = new LinkedList<>();
        this.filasLado2 = new LinkedList<>();
        this.pesoLado1 = 0;
        this.pesoLado2 = 0;
        this.qtdeDeFilas = 0;
    }

    //    Getters
    public LinkedList<FilaManagerDeGuerreiros> getFilas() {
        return filas;
    }

    public FilaManagerDeGuerreiros getFila(int filaIndex) {
        return filas.get(filaIndex - 1);  // Ajuste para índice 0 baseado em fila 1
    }

    // Método para retornar a fila do guerreiro, dado um guerreiro específico
    public FilaManagerDeGuerreiros getFilaAtual(TipoGuerreiro guerreiro) {
        // A busca na lista de filas pode ser feita através de algum critério (nome, id, etc.)
        for (FilaManagerDeGuerreiros fila : filas) {
            if (fila.contemGuerreiro(guerreiro)) {  // Verifica se o guerreiro está nesta fila
                return fila;  // Retorna a fila do guerreiro
            }
        }
        return null;  // Retorna null se o guerreiro não estiver em nenhuma fila
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
        filas.add(fila);
        // Dividindo as filas nos lados 1 e 2
        if (filas.size() <= filas.size() / 2) {
            filasLado1.add(fila);  // Lado 1
        } else {
            filasLado2.add(fila);  // Lado 2
        }
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

    // Soma os pesos do lado 1 (primeira metade da lista)
    public double somarPesosLado1() {
        pesoLado1 = 0;
        for (FilaManagerDeGuerreiros fila : filasLado1) {
            pesoLado1 += fila.getPesoTotalDaFila();
        }
        return pesoLado1;
    }

    // Soma os pesos do lado 2 (segunda metade da lista)
    public double somarPesosLado2() {
        pesoLado2 = 0;
        for (FilaManagerDeGuerreiros fila : filasLado2) {
            pesoLado2 += fila.getPesoTotalDaFila();
        }
        return pesoLado2;
    }

    // Métodos para acessar filas específicas
    public FilaManagerDeGuerreiros getFilaDoLado(TipoGuerreiro guerreiro) {
        if (contidoNoLado(filasLado1, guerreiro)) {
            return encontrarFila(filasLado1, guerreiro);
        } else if (contidoNoLado(filasLado2, guerreiro)) {
            return encontrarFila(filasLado2, guerreiro);
        }
        throw new IllegalArgumentException("O guerreiro não está em nenhum lado.");
    }

    public FilaManagerDeGuerreiros getFilaInimiga(TipoGuerreiro guerreiro) {
        // Assume que há duas filas: uma para cada lado
        for (FilaManagerDeGuerreiros fila : filas) {
            if (!fila.contemGuerreiro(guerreiro)) {  // Verifica se a fila não contém o guerreiro
                return fila;  // Retorna a fila inimiga
            }
        }
        return null;  // Retorna null se não encontrar a fila inimiga
    }

    private boolean contidoNoLado(LinkedList<FilaManagerDeGuerreiros> lado, TipoGuerreiro guerreiro) {
        for (FilaManagerDeGuerreiros fila : lado) {
            if (fila.getFila().contains(guerreiro)) {
                return true;
            }
        }
        return false;
    }

    private FilaManagerDeGuerreiros encontrarFila(LinkedList<FilaManagerDeGuerreiros> lado, TipoGuerreiro guerreiro) {
        for (FilaManagerDeGuerreiros fila : lado) {
            if (fila.getFila().contains(guerreiro)) {
                return fila;
            }
        }
        return null;
    }

    // Método para retornar as filas do lado adversário de um guerreiro
    public LinkedList<FilaManagerDeGuerreiros> getFilasAdversarias(TipoGuerreiro guerreiro) {
        // Verifica em qual lado o guerreiro está (lado 1 ou lado 2)
        if (contidoNoLado(filasLado1, guerreiro)) {
            return filasLado2;  // Se o guerreiro está no lado 1, retorna as filas do lado 2
        } else if (contidoNoLado(filasLado2, guerreiro)) {
            return filasLado1;  // Se o guerreiro está no lado 2, retorna as filas do lado 1
        }
        throw new IllegalArgumentException("O guerreiro não está em nenhum lado.");
    }

    // Método para remover guerreiros mortos das filas
    public void removerGuerreirosMortosDasFilas() {
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

    public TipoGuerreiro guerreiroMaisVelho() {
        TipoGuerreiro maisVelhoGlobal = null;

        for (FilaManagerDeGuerreiros filaManager : filas) {
            TipoGuerreiro maisVelhoDaFila = filaManager.guerreiroMaisVelhoDaFila();

            if (maisVelhoGlobal == null
                    || (maisVelhoDaFila != null && maisVelhoDaFila.getIdade() > maisVelhoGlobal.getIdade())) {
                maisVelhoGlobal = maisVelhoDaFila;
            }
        }

        return maisVelhoGlobal;
    }

}
