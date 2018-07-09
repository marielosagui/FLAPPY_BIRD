/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaz.juego;

/**
 *
 * @author Mabel
 */
public class Movimiento_Tubos extends Thread{
     static int velocidad;

    public Movimiento_Tubos() {
        velocidad = 7;
        ocultarTubos();
    }


    @Override
    public void run() {
        int posicion1 = generarPosicionAleatoria();
        int posicion2 = generarPosicionAleatoria();
        int x1 = juego.jTubo_arriba1.getLocation().x;
        int x2 = juego.jTubo_arriba2.getLocation().x;
        while (true) {
            try {
                Thread.sleep(getVelocidad());
                x1--;
                x2--;
                juego.jTubo_arriba1.setLocation(x1, posicion1);
                juego.jTubo_abajo1.setLocation(x1, (posicion1 + 425));
                juego.jTubo_arriba2.setLocation(x2, posicion2);
                juego.jTubo_abajo2.setLocation(x2, (posicion2 + 425));
                if (x1 <= -51) {
                    posicion1 = generarPosicionAleatoria();
                    x1 = 425;
                }
                if (x2 <= -51) {
                    posicion2 = generarPosicionAleatoria();
                    x2 = 425;
                }
            } catch (InterruptedException ex) {
                System.out.println("problema al mover los tubos " + ex);
            }
        }
    }

    private void ocultarTubos() {
        juego.jTubo_arriba1.setLocation(460, 500);
        juego.jTubo_abajo1.setLocation(460, 1000);
        juego.jTubo_arriba2.setLocation(700, 500);
        juego.jTubo_abajo2.setLocation(700, 1000);
    }

    public int getVelocidad() {
        return velocidad;
    }

    private int generarPosicionAleatoria() {
        int numero = (int) (Math.random() * (0 - (-200)) + (-200));
        return numero;
    }

}
