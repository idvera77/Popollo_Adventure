/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author Mystra77
 */
public class Enemigos extends Personajes{
    private int dropDinero;

    public Enemigos(String nombre, String descripcion, int saludMaxima, 
        int salud, int fuerza, int magia, int agilidad, int defensa, 
        ArrayList<Habilidades> habilidadesArray, int dropDinero) {
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
