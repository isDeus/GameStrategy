/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gamestrategy;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mauricio
 */
public class GameStrategyTest {

    /**
     * Test of ingresarTablero method, of class GameStrategy.
     */
    @Test
    public void testGameStrategy1() {
        String[] arreglo = new String[2];
        arreglo[0] = "1 b";
        arreglo[1] = "2 ab a";

        int[][] resultadoEsperado = new int[2][2];
        resultadoEsperado[0][0] = 0;
        resultadoEsperado[0][1] = 1;
        resultadoEsperado[1][0] = 1;
        resultadoEsperado[1][1] = 0;
        GameStrategy game = new GameStrategy();
        game.ingresarTablero(2, arreglo);
        int[][] resultado = game.mostrarMatriz(game.generarSalida());
        Assert.assertArrayEquals(resultadoEsperado,resultado);
    }
}
