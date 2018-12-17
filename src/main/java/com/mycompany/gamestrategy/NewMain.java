package com.mycompany.gamestrategy;

/**
 *
 * @author Pardo
 */
public class NewMain {

    public static void main(String[] args) {
        String[] arreglo = new String[2];
        arreglo[0] = "1 b";
        arreglo[1] = "2 ab a";
        GameStrategy game = new GameStrategy();
        game.ingresarTablero(2,arreglo);
        game.mostrarMatriz(game.generarSalida());
    }

}
