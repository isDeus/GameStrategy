package com.mycompany.gamestrategy;

import java.util.Arrays;

/**
 *
 * @author Pardo
 */
public class Grafo {

    private final int cantNodos;
    private int[][] listAdy;

    public Grafo(int cantNodos) {
        this.cantNodos = cantNodos;
        this.listAdy = new int[cantNodos][];
    }

    public int[] bfs(int fin) {
        int[] pasos = new int[this.listAdy.length];
        Arrays.fill(pasos, -1);
        pasos[fin] = 0;

        int maskActual = (1 << fin);

        while (true) {
            //cada ciclo del while pasa por un nodo
            int maskNueva = 0;
            for (int i = 0; i < this.listAdy.length; i++) {

                int mejor = 26;
                //se comprueba si ya se visito o no
                if ((maskActual & (1 << i)) == 0) {
                    //desde i se puede llegar a maskActual?
                    for (int j = 0; j < this.listAdy[i].length; j++) {
                                                   
                        if ((this.listAdy[i][j] & maskActual) == this.listAdy[i][j]) { // comrprueba que las letras que representa cada binario sean iguales

                            maskNueva = maskNueva | (1 << i);
                            mejor = getPasos(this.listAdy[i][j], pasos);
                        }
                    }

                    pasos[i] = mejor < 26 ? mejor : -1;

                }

            }

            maskActual = maskActual | maskNueva; // se actualiza con un or para marcar que existe un camino entre maskActual y maskNueva
            if (maskNueva == 0) {
                break;
            }
        }
        return pasos;
    }

    public int getPasos(int mask, int[] pasos) {
        int i = 0, cant = -1;
        while (mask > 0) {

            if ((mask & 1) > 0) {
                cant = cant > pasos[i] ? cant : pasos[i];
            }

            i++; 
            mask = mask >> 1; 
        }
        return cant+1;
    }

    public void crearAdyacencia(int indice, int tamaño) {
        this.listAdy[indice] = new int[tamaño];
    }

    public void agregarAdyacencias(int fila, int columna, int ady) {
        this.listAdy[fila][columna] = ady;
    }

    public int getLength(int fila) {
        return this.listAdy[fila].length;
    }

    public int getLength() {
        return this.listAdy.length;
    }

    public int[][] getListAdy() {
        return this.listAdy;
    }
}
