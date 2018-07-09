/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import static Clases.Movimiento_Tubos.velocidad;
import Interfaz.juego;
import Sonido.sonido;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mabel
 */
public class Movimiento_monedas extends Thread {
    private static int puntos;
    static int velocidad;
    
    public Movimiento_monedas(){
        puntos = 0;
        velocidad = 7;
    }
    
    private static synchronized void sumarMonedas(){
        int moneda= juego.jmonedas.getLocation().x;
        int moneda2= juego.monedas2.getLocation().x;
        if(juego.jFlappy.getLocation().x== moneda){
            sonido.puntos();
            puntos = puntos + 1;
            juego.jPuntaje.setText(puntos + "");
            if (puntos == 30 || puntos == 50 || puntos == 130 || puntos == 160 || puntos == 200 || puntos == 300) {
                velocidad = velocidad - 1;
            }
        } else if (moneda2==juego.jFlappy.getLocation().x) {
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
        int posicion2= generarPosicionAleatoria();
        int m = juego.jmonedas.getLocation().x;
        int m2= juego.monedas2.getLocation().x;
        while (true) {
            try{
                Thread.sleep(getVelocidad());
            m--;
            m2--;
            juego.jmonedas.setLocation(m, posicion);
            juego.monedas2.setLocation(m2,posicion2);
            if (m <= -45) {
                posicion = generarPosicionAleatoria();
                m = 400;
            }
            if(m2 <= -45){
                posicion2= generarPosicionAleatoria();
                m2= 400;
            }
            sumarMonedas();
    }       catch (InterruptedException ex) {
               System.out.println("Problema al mover las monedas"+ ex);
            }
    }
    }
        
    private int generarPosicionAleatoria() {
        int numero = (int) (Math.random() * (0 - (-200)) + (-200));
        return numero;
    }

    private long getVelocidad() {
     return velocidad;
    }
}