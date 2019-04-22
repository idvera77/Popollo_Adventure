/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author Mystra77
 */
public class Enemigo extends Personaje{
    private int dropDinero;
    
    /**
     * Constructor de Enemigo
     * @param nombre Variable de tipo String para indicar un nombre.
     * @param descripcion Variable de tipo String para escribir una descripcion.
     * @param saludMaxima Variable de tipo entero que indica la salud maxima.
     * @param salud Variable de tipo entero que indica la salud actual.
     * @param fuerza Variable de tipo entero que indica la fuerza actual.
     * @param magia Variable de tipo entero que indica la magia actual.
     * @param agilidad Variable de tipo entero que indica la agilidad actual.
     * @param defensa Variable de tipo entero que indica la defensa actual.
     * @param habilidadesArray Array con las habilidades.
     * @param dropDinero Variable de tipo entero que indica el dinero..
     */
    public Enemigo(String nombre, String descripcion, int saludMaxima, 
        int salud, int fuerza, int magia, int agilidad, int defensa, 
        ArrayList<Habilidad> habilidadesArray, int dropDinero) {
        super(nombre, descripcion, saludMaxima, salud, fuerza, magia, agilidad, defensa, habilidadesArray);
        this.dropDinero = dropDinero;
    }

    public int getDropDinero() {
        return dropDinero;
    }

    public void setDropDinero(int dropDinero) {
        this.dropDinero = dropDinero;
    }   
}
