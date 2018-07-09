/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import static Clases.Movimiento_Tubos.velocidad;
import Interfaz.juego;
import Sonido.sonido;

/**
 *
 * @author Mabel
 */
public class Movimiento_monedas extends Thread {
    private static int puntos;
    
    public Movimiento_monedas(){
        puntos = 0;
    }
    
    private static synchronized void sumarMonedas(){
        int moneda1= juego.jmonedas.getLocation().x;
        if(moneda1 == 50){
            sonido.puntos();
            puntos = puntos + 1;
            juego.jPuntaje.setText(puntos + "");
            if (puntos == 30 || puntos == 50 || puntos == 130 || puntos == 160 || puntos == 200 || puntos == 300) {
                velocidad = velocidad - 1;
            }
        }
    }
    
    @Override
    public void run(){
        int posicion = generarPosicionAleatoria();
        int m = juego.jmonedas.getLocation().x;
        int m2= juego.jmonedas.getLocation().x;
        while (true) {
            m--;
            juego.jmonedas.setLocation(m, posicion);
            if (m <= 45) {
                posicion = generarPosicionAleatoria();
                m = 400;
            }
            sumarMonedas();
    }
    }
    private int generarPosicionAleatoria() {
        int numero = (int) (Math.random() * (0 - (-200)) + (-200));
        return numero;
    }
}