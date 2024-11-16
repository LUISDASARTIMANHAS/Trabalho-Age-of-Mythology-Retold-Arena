<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arena;


import java.util.LinkedList;

public class FilaManager {

    // Lista principal de filas
    LinkedList<FilaManagerDeGuerreiros> filas;

    // Construtor da classe FilaManager
    public FilaManager() {
        this.filas = new LinkedList<>();
    }

    // Método para adicionar uma fila de guerreiros à lista principal
    public void adicionarFila(FilaManagerDeGuerreiros fila) {
        filas.add(fila);
    }

    // Método para exibir todas as filas de guerreiros
    public void exibirTodasAsFilas() {
        int filaIndex = 1;
        for (FilaManagerDeGuerreiros fila : filas) {
            System.out.println("Fila " + filaIndex + ":");
            fila.exibirFila();
            filaIndex++;
            System.out.println();
        }
    }
}
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arena;


import java.util.LinkedList;

public class FilaManager {

    // Lista principal de filas
    LinkedList<FilaManagerDeGuerreiros> filas;

    // Construtor da classe FilaManager
    public FilaManager() {
        this.filas = new LinkedList<>();
    }

    // Método para adicionar uma fila de guerreiros à lista principal
    public void adicionarFila(FilaManagerDeGuerreiros fila) {
        filas.add(fila);
    }

    // Método para exibir todas as filas de guerreiros
    public void exibirTodasAsFilas() {
        int filaIndex = 1;
        for (FilaManagerDeGuerreiros fila : filas) {
            System.out.println("Fila " + filaIndex + ":");
            fila.exibirFila();
            filaIndex++;
            System.out.println();
        }
    }
}
>>>>>>> f8fcecb64b32e2b460185125e6147179f7afacb4
