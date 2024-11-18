
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arena;


import java.util.LinkedList;

public class FilaManager {
    // gerencia as filas de guerreiros para cada lado
    // Lista principal de filas
    private LinkedList<FilaManagerDeGuerreiros> filas;

    // Construtor da classe FilaManager
    public FilaManager() {
        this.filas = new LinkedList<>();
    }

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

    /**
     * @return the filas
     */
    public LinkedList<FilaManagerDeGuerreiros> getFilas() {
        return filas;
    }

    /**
     * @param filas the filas to set
     */
    public void setFilas(LinkedList<FilaManagerDeGuerreiros> filas) {
        this.filas = filas;
    }
}