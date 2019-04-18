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
public class Heroe extends Personaje{
    private ArrayList<Objeto> objetosArray;
    public int dinero;
    private int reputacion;
    
    public Heroe(String nombre, String descripcion, int saludMaxima, int salud, int fuerza, 
        int magia, int agilidad, int defensa, ArrayList<Habilidad> habilidadesArray, 
        ArrayList<Objeto> objetosArray, int dinero, int reputacion) {
        super(nombre, descripcion, saludMaxima, salud, fuerza, magia, agilidad, defensa, habilidadesArray);
        this.objetosArray = objetosArray;
        this.dinero = dinero;
        this.reputacion = reputacion;
    }

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
    
    public void subirReputacion(Heroe heroe, int numero){
        this.reputacion += numero;
    }
    
    public void bajarReputacion(Heroe heroe, int numero){
        this.reputacion -= numero;
    }
}
