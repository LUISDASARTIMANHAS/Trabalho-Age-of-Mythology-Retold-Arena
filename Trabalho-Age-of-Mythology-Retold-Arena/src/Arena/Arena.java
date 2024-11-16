
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arena;

import Guerreiros.Atlantes.Argus;
import Guerreiros.Atlantes.Prometeano;
import Guerreiros.Atlantes.Satiro;
import Guerreiros.Egipcios.Anubita;
import Guerreiros.Egipcios.HomemEscorpiao;
import Guerreiros.Egipcios.Mumia;
import Guerreiros.Gregos.Ciclope;
import Guerreiros.Gregos.Hydra;
import Guerreiros.Gregos.Manticora;
import Guerreiros.Nordicos.GiganteDePedra;
import Guerreiros.Nordicos.LoboDeFenris;
import Guerreiros.Nordicos.Valquiria;
import Guerreiros.TipoGuerreiro;
import java.util.LinkedList;
import java.util.Scanner;
import static utils.LeituraDeArquivo.fReadInt;
import static utils.LeituraDeArquivo.fReadString;
import static utils.LeituraDeArquivo.fopen;

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
        System.out.println("LADO 1:");
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

    // Método para ler um guerreiro do arquivo e criar o guerreiro
    public static void lerGuerreiro(int lado, Scanner file, FilaManagerDeGuerreiros fila) {
        // Dados do guerreiro: tipo, nome, idade, peso
        int tipo;
        String nome;
        int idade;
        int peso;

        while (file.hasNext()) {
            tipo = fReadInt(file);
            nome = fReadString(file);
            idade = fReadInt(file);
            peso = fReadInt(file);
            System.out.println(
                    "Guerreiro lido: " + nome
                    + ", Tipo: " + tipo
                    + ", Idade: " + idade
                    + ", Peso: " + peso);
            System.out.println();

            // Criar o guerreiro de acordo com o tipo e adicionar à fila
            try {
                TipoGuerreiro guerreiro = criarGuerreiro(lado, tipo, nome, idade, peso);
                fila.adicionarGuerreiro(guerreiro); // Adiciona o guerreiro na fila
            } catch (RuntimeException e) {
                System.out.println("Erro ao criar guerreiro: " + e.getMessage());
            }

        }
    }

    // Método para criar um guerreiro baseado no tipo (você pode expandir com outros tipos de guerreiros)
    public static TipoGuerreiro criarGuerreiro(int lado, int tipo, String nome, int idade, double peso) {
        // Criação de guerreiros com base no lado e tipo

        switch (lado) {
            case 1:  // Lado 1
                switch (tipo) {
                    case 1:
                        return new Ciclope(nome, idade, peso);  // Guerreiro Ciclope do lado 1
                    case 2:
                        return new Manticora(nome, idade, peso);  // Guerreiro Manticora do lado 1
                    case 3:
                        return new Hydra(nome, idade, peso);  // Guerreiro Hydra do lado 1
                    case 4:
                        return new Valquiria(nome, idade, peso);  // Guerreiro Valquiria do lado 1
                    case 5:
                        return new LoboDeFenris(nome, idade, peso);  // Guerreiro Lobo de Fenris do lado 1
                    case 6:
                        return new GiganteDePedra(nome, idade, peso);  // Guerreiro Gigante de Pedra do lado 1
                    // Adicionar mais tipos de guerreiros conforme necessário
                    default:
                        System.out.println("Tipo de guerreiro desconhecido no Lado 1.");
                        return null;  // Caso o tipo não seja válido
                }
            case 2:  // Lado 2
                switch (tipo) {
                    case 1:
                        return new Prometeano(nome, idade, peso);  // Guerreiro Prometeano do lado 2
                    case 2:
                        return new Satiro(nome, idade, peso);  // Guerreiro Satiro do lado 2
                    case 3:
                        return new Argus(nome, idade, peso);  // Guerreiro Argus do lado 2
                    case 4:
                        return new Anubita(nome, idade, peso);  // Guerreiro Anubita do lado 2
                    case 5:
                        return new HomemEscorpiao(nome, idade, peso);  // Guerreiro Homem Escorpião do lado 2
                    case 6:
                        return new Mumia(nome, idade, peso);  // Guerreiro Mumia do lado 2
                    // Adicionar mais tipos de guerreiros conforme necessário
                    default:
                        System.out.println("Tipo de guerreiro desconhecido no Lado 2.");
                        return null;  // Caso o tipo não seja válido
                }
            // Caso adicione mais lados no futuro:
            // Adicionar mais casos para novos lados aqui
            default:
                System.out.println("Tipo de Lado desconhecido.");
                return null;  // Caso o lado não seja válido
        }
    }

    // Método para ler e processar os arquivos de guerreiros
    public static void lerArqGuerreiro(FilaManager arena) {
        // Definindo as variáveis para os intervalos de lado e fila
        int maxLados = 2;  // Exemplo: máximo de 2 lados
        int maxFilasPorLado = 4;  // 4 filas por lado (pode ser alterado conforme necessário)

        // Loop pelos lados
        for (int lado = 1; lado <= maxLados; lado++) {

            // Loop pelas filas de cada lado
            for (int fila = 1; fila <= maxFilasPorLado; fila++) {
                // Gerar o nome do arquivo baseado no lado e fila
                String arquivo = "lado" + lado + fila + ".txt";
                // Abrir o arquivo
                Scanner file = fopen(arquivo);

                // Se o arquivo não foi encontrado, continuar com o próximo lado/fila
                if (file == null) {
                    continue;  // Não encontrou o arquivo, então pula para o próximo
                }

                // Criar a fila de guerreiros para este arquivo
                FilaManagerDeGuerreiros filaDeGuerreiros = new FilaManagerDeGuerreiros();
                // Ler os guerreiros e adicionar à fila
                lerGuerreiro(lado, file, filaDeGuerreiros);
                // Adicionar a fila à arena
                arena.adicionarFila(filaDeGuerreiros);
                // Fechar o arquivo após a leitura
                file.close();
            }
        }
    }

    // Método main para testar
    public static void main(String[] args) {
        FilaManager arena = new FilaManager();

        // Lê os guerreiros e organiza as filas na arena
        lerArqGuerreiro(arena);

        // Exibe os dados dos guerreiros da arena
        arena.exibirTodasAsFilas();
    }
}
