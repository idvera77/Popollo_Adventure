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
public class Personajes extends ElementoIdentificador{
    private int saludMaxima;
    private int salud;
    private int fuerza;
    private int magia;
    private int agilidad;
    private int defensa;
    private ArrayList<Habilidades> habilidadesArray;

    public Personajes(String nombre, String descripcion, int saludMaxima, int salud, int fuerza, int magia, int agilidad, int defensa, ArrayList<Habilidades> habilidadesArray) {
        super(nombre, descripcion);
        this.saludMaxima = saludMaxima;
        this.salud = salud;
        this.fuerza = fuerza;
        this.magia = magia;
        this.agilidad = agilidad;
        this.defensa = defensa;
        this.habilidadesArray = habilidadesArray;
    }
    
    
}
