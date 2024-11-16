<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arena;

import Guerreiros.TipoGuerreiro;
import java.util.LinkedList;

public class Arena {

    // Filas de guerreiros que irão lutar na arena
    private LinkedList<FilaManagerDeGuerreiros> filas;
    
    // Variáveis para controlar o turno
    private int turnoAtual;
    private boolean jogoAtivo;

    // Construtor da Arena
    public Arena() {
        this.filas = new LinkedList<>();
        this.turnoAtual = 1;  // Começa o jogo no primeiro turno
        this.jogoAtivo = true;  // O jogo começa ativo
    }

    // Método para adicionar uma fila de guerreiros à arena
    public void adicionarFila(FilaManagerDeGuerreiros fila) {
        filas.add(fila);
    }

    // Exibe todas as filas de guerreiros
    public void exibirFilas() {
        for (int i = 0; i < filas.size(); i++) {
            System.out.println("Fila " + (i + 1) + ":");
            filas.get(i).exibirFila();
            System.out.println();
        }
    }

    // Inicia o combate, alternando entre turnos
    public void iniciarCombate() {
        while (jogoAtivo) {
            System.out.println("Turno " + turnoAtual);
            executarTurno();
            turnoAtual++;
            verificarEstadoJogo();
        }
    }

    // Executa o turno de cada fila
    private void executarTurno() {
        for (FilaManagerDeGuerreiros fila : filas) {
            for (TipoGuerreiro guerreiro : fila.getFila()) {
                if (guerreiro.getEnergia() > 0) {
                    guerreiro.ataque(this);  // Cada guerreiro realiza um ataque
                }
            }
        }
    }

    // Verifica se o jogo deve continuar ou se terminou
    private void verificarEstadoJogo() {
        // Exemplo: se todas as filas estiverem vazias (sem guerreiros vivos), o jogo termina
        boolean jogoConcluido = true;
        for (FilaManagerDeGuerreiros fila : filas) {
            for (TipoGuerreiro guerreiro : fila.getFila()) {
                if (guerreiro.getEnergia() > 0) {
                    jogoConcluido = false;  // Se houver algum guerreiro vivo, o jogo continua
                    break;
                }
            }
        }

        if (jogoConcluido) {
            jogoAtivo = false;  // O jogo terminou
            System.out.println("O jogo terminou!");
        }
    }

    // Método para remover guerreiros mortos das filas
    public void removerGuerreirosMortos() {
        for (FilaManagerDeGuerreiros fila : filas) {
            fila.removerGuerreirosMortos();
        }
    }
    
        // Soma os pesos de todos os guerreiros de um lado
    public float somarPesos(LinkedList<FilaManagerDeGuerreiros> filas) {
        float somaPesos = 0;
        for (FilaManagerDeGuerreiros fila : filas) {
            for (TipoGuerreiro guerreiro : fila.getFila()) {
                somaPesos += guerreiro.getPeso();
            }
        }
        return somaPesos;
    }


    // Getter para as filas
    public LinkedList<FilaManagerDeGuerreiros> getFilas() {
        return filas;
    }

    // Método para exibir o estado da arena (se necessário)
    public void exibirEstado() {
        System.out.println("Estado da Arena: Turno " + turnoAtual);
        exibirFilas();
    }

    public void exibirDados() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public TipoGuerreiro guerreiroMaisVelho() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String determinarVencedor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public TipoGuerreiro ultimoDerrotado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public TipoGuerreiro guerreiroUltimoAtaque() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}