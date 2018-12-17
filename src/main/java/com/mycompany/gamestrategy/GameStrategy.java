package com.mycompany.gamestrategy;

import java.util.*;
/**
 *
 * @author Pardo
 */
public class GameStrategy {

    private int n;
    private int[][] respuesta;
    private Grafo grafo;

    public void ingresarTablero(int cantidadNodos, String camino[]) {
        this.n = cantidadNodos;
        grafo = new Grafo(n);
        for (int i = 0; i < n; i++) {
            StringTokenizer tok = new StringTokenizer(camino[i]);
            int size = Integer.parseInt(tok.nextToken());
            this.grafo.crearAdyacencia(i,size);
            for (int j = 0; j < this.grafo.getLength(i); j++) {
                this.grafo.agregarAdyacencias(i, j, convertirString(tok.nextToken()));
            }
        }
    }
    
    public int[][] generarSalida(){
        this.respuesta = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] resultado = this.grafo.bfs(i);
            for (int j = 0; j < n; j++) {
                respuesta[j][i] = resultado[j];
            }
        }
        
        return this.respuesta;
    }
    
    public int[][] mostrarMatriz(int[][] matriz){
        return matriz;
    }

    public int convertirString(String s) {
        int respuesta = 0;
        for (int i = 0; i < s.length(); i++) {
            respuesta = respuesta | (1 << (s.charAt(i) - 'a'));
        }
        return respuesta;
    }
    
    public String leerString(){
        Scanner leer = new Scanner(System.in);
        return leer.next();
    } 
    
    public int leerInt(){
        Scanner leer = new Scanner(System.in);
        return leer.nextInt();
    }

}
