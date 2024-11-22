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
import java.util.Iterator;
import java.util.Scanner;
import static utils.LeituraDeArquivo.fReadInt;
import static utils.LeituraDeArquivo.fReadString;
import static utils.LeituraDeArquivo.fopen;

public class Arena {

    private int maxLados;
    private int maxFilasPorLado;
    private double pesoTotal = 0;
    // Filas de guerreiros que irão lutar na arena
    private FilaManager gestorDeFilas;
    // Variáveis para controlar o turno
    private int turnoAtual;
    private boolean jogoAtivo;

    // Construtor da Arena
    public Arena() {
        // 4 filas por lado (pode ser alterado conforme necessário)
        // Definindo as variáveis para os intervalos de lado e fila
        this.maxFilasPorLado = 4;
        // Exemplo: máximo de 2 lados
        this.maxLados = 2;
        this.gestorDeFilas = new FilaManager();
        this.turnoAtual = 1;  // Começa o jogo no primeiro turno
        this.jogoAtivo = true;  // O jogo começa ativo
    }

    //  Getters
    /**
     * @return the maxLados
     */
    public int getMaxLados() {
        return maxLados;
    }

    /**
     * @return the maxFilasPorLado
     */
    public int getMaxFilasPorLado() {
        return maxFilasPorLado;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public FilaManager getGestorDeFilas() {
        return gestorDeFilas;
    }

    public int getTurnoAtual() {
        return turnoAtual;
    }

    public boolean isJogoAtivo() {
        this.jogoAtivo = gestorDeFilas.verificarEstadoJogo();
        return jogoAtivo;
    }

    //Funções
    // Inicia o combate, alternando entre turnos
    public void iniciarCombate() {

        while (jogoAtivo) {
            System.out.println("Turno " + turnoAtual);
            executarTurno();

            turnoAtual++;
            jogoAtivo = gestorDeFilas.verificarEstadoJogo();
        }
    }

    // Executa o turno de cada fila
    private void executarTurno() {
        int numeroDeFilas = gestorDeFilas.getFilas().size();
        int lado1Turno = 0;  // Índice para lado 1
        int lado2Turno = numeroDeFilas / 2;  // Índice para lado 2

        while (lado1Turno < numeroDeFilas / 2 && lado2Turno < numeroDeFilas) {
            // Primeiro lado
            FilaManagerDeGuerreiros filaLado1 = gestorDeFilas.getFilas().get(lado1Turno);
            // Segundo lado
            FilaManagerDeGuerreiros filaLado2 = gestorDeFilas.getFilas().get(lado2Turno);
            efetuarAtaque(filaLado1,filaLado2);

            // Avança para o próximo turno
            lado1Turno++;
            lado2Turno++;

            // Verifica se o jogo terminou
            if (!isJogoAtivo()) {
                break;
            }
        }
    }

    // Método para efetuar os ataques
    // Método para efetuar os ataques
    private void efetuarAtaque(FilaManagerDeGuerreiros Filamatadores, FilaManagerDeGuerreiros FilaDefenders) {
        // Iterando sobre os matadores
        Iterator<TipoGuerreiro> iteradorAtacante = Filamatadores.getFila().iterator();

        // Iterando sobre os defensores
        Iterator<TipoGuerreiro> iteradorDefensor = FilaDefenders.getFila().iterator();

        // Enquanto houver matadores e defenders
        while (iteradorAtacante.hasNext() && iteradorDefensor.hasNext()) {
            TipoGuerreiro matadores = iteradorAtacante.next();
            TipoGuerreiro defenders = iteradorDefensor.next();

            // Verifica se o matadores e o defenders não estão mortos
            if (matadores.getEnergia() > 0 && defenders.getEnergia() > 0) {
                // O matadores realiza o ataque
                matadores.ataque(this,defenders);
            }
        }
    }

    // Método para verificar se o inimigo morreu
    public boolean inimigoMorreu(TipoGuerreiro guerreiro) {
        if (guerreiro.getEnergia() <= 0) {  // Verifica se a energia do inimigo chegou a 0 ou abaixo
            System.out.println(guerreiro.getNome() + " foi derrotado!");
            return true;  // Retorna verdadeiro se o inimigo morreu
        }
        return false;  // Retorna falso se o inimigo ainda está vivo
    }

    // Método para exibir o estado da arena (se necessário)
    public void exibirEstado() {
        System.out.println("Estado da Arena: Turno " + turnoAtual);
        this.gestorDeFilas.exibirTodasAsFilas();
    }

    public void exibirFilas() {
        int numeroDeFilas = gestorDeFilas.getFilas().size();

        for (int i = 0; i < numeroDeFilas; i++) {
            System.out.println("Fila " + (i + 1) + ":");
            gestorDeFilas.getFilas().get(i).exibirFila();
            System.out.println();
        }
    }

    public void exibirGuerreiroMaisVeio() {
        TipoGuerreiro maisVelho = gestorDeFilas.guerreiroMaisVelho();
//           exemplo
//        O Gigante de Pedra Tonton é o mais velho e tem 200 anos
        System.out.println("O "
                + maisVelho.getClass().getSimpleName()
                + " " + maisVelho.getNome()
                + " é o mais velho e tem "
                + maisVelho.getIdade()
                + " anos"
        );
        System.out.println();
    }

    public void exibirPesosDasRacas() {
//        exemplo
//        Gregos e Nórdicos pesam 15500 kilos
//        Atlantes e Egípcios pesam 20335 kilos
        System.out.println("Gregos e Nórdicos pesam " + gestorDeFilas.somarPesosLado1());
        System.out.println("Atlantes e Egípcios pesam " + gestorDeFilas.somarPesosLado2());
        System.out.println();
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

            // Criar o guerreiro de acordo com o tipo e adicionar à fila
            try {
                TipoGuerreiro guerreiro = criarGuerreiro(lado, tipo, nome, idade, peso);
                fila.adicionarGuerreiro(guerreiro); // Adiciona o guerreiro na fila
            } catch (RuntimeException err) {
                System.out.println("Erro ao criar guerreiro: " + err.getMessage());
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
    public void lerArqGuerreiro() {
        // Loop pelos lados
        for (int lado = 1; lado <= getMaxLados(); lado++) {

            // Loop pelas filas de cada lado
            for (int filaNum = 1; filaNum <= getMaxFilasPorLado(); filaNum++) {
                // Gerar o nome do arquivo baseado no lado e fila
                String arquivo = "lado" + lado + filaNum + ".txt";
                // Abrir o arquivo
                Scanner file = fopen(arquivo);

                // Se o arquivo não foi encontrado, continuar com o próximo lado/fila
                if (file == null) {
                    continue;  // Não encontrou o arquivo, então pula para o próximo
                }

                // Criar a fila de guerreiros para este arquivo
                FilaManagerDeGuerreiros fila = new FilaManagerDeGuerreiros(lado);
                // Ler os guerreiros e adicionar à fila
                lerGuerreiro(lado, file, fila);
                // Adicionar a fila à arena
                this.gestorDeFilas.adicionarFila(fila);
                // Fechar o arquivo após a leitura
                file.close();
            }
        }
    }
}
