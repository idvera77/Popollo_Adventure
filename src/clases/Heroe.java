/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mystra77
 */
public class Heroe extends Personaje{
    private ArrayList<Objeto> objetosArray;
    public int dinero;
    private int reputacion;
    
    /**
     * Constructor de Heroe
     * @param nombre Variable de tipo String para indicar un nombre.
     * @param descripcion Variable de tipo String para escribir una descripcion.
     * @param saludMaxima Variable de tipo entero que indica la salud maxima.
     * @param salud Variable de tipo entero que indica la salud actual.
     * @param fuerza Variable de tipo entero que indica la fuerza actual.
     * @param magia Variable de tipo entero que indica la magia actual.
     * @param agilidad Variable de tipo entero que indica la agilidad actual.
     * @param defensa Variable de tipo entero que indica la defensa actual.
     * @param habilidadesArray Array con las habilidades.
     * @param objetosArray Array con los objetos.
     * @param dinero Variable de tipo entero que indica el dinero actual.
     * @param reputacion Variable de tipo entero que indica la reputacion actual.
     */
    public Heroe(String nombre, String descripcion, int saludMaxima, int salud, int fuerza, 
        int magia, int agilidad, int defensa, ArrayList<Habilidad> habilidadesArray, 
        ArrayList<Objeto> objetosArray, int dinero, int reputacion) {
        super(nombre, descripcion, saludMaxima, salud, fuerza, magia, agilidad, defensa, habilidadesArray);
        this.objetosArray = objetosArray;
        this.dinero = dinero;
        this.reputacion = reputacion;
    }
    
    //Getters y Setters
    public ArrayList<Objeto> getObjetosArray() {
        return objetosArray;
    }

    public void setObjetosArray(ArrayList<Objeto> objetosArray) {
        this.objetosArray = objetosArray;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getReputacion() {
        return reputacion;
    }

    public void setReputacion(int reputacion) {
        this.reputacion = reputacion;
    }
    
    //FUNCIONES
    
    //Reputacion
    /**
     * Funcion que nos permite aumentar la reputacion del heroe.
     * @param heroe Heroe del cual aumentara su reputacion.
     * @param numero Numero que subira la reputacion del heroe.
     */
    public void subirReputacion(Heroe heroe, int numero){
        this.reputacion += numero;
    }
    
    /**
     * Funcion que nos permite disminuir la reputacion del heroe.
     * @param heroe Heroe del cual disminuira su reputacion.
     * @param numero Numero que bajara la reputacion del heroe.
     */
    public void bajarReputacion(Heroe heroe, int numero){
        this.reputacion -= numero;
    }
}
