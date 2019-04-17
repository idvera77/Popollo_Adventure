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
public class Heroes extends Personajes{
    private ArrayList<Objetos> objetosArray;
    public int dinero;
    private int reputacion;
    
    public Heroes(String nombre, String descripcion, int saludMaxima, int salud, int fuerza, 
        int magia, int agilidad, int defensa, ArrayList<Habilidades> habilidadesArray, 
        ArrayList<Objetos> objetosArray, int dinero, int reputacion) {
        super(nombre, descripcion, saludMaxima, salud, fuerza, magia, agilidad, defensa, habilidadesArray);
        this.objetosArray = objetosArray;
        this.dinero = dinero;
        this.reputacion = reputacion;
    }

    public ArrayList<Objetos> getObjetosArray() {
        return objetosArray;
    }

    public void setObjetosArray(ArrayList<Objetos> objetosArray) {
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
    
    public void subirReputacion(Heroes heroe, int numero){
        this.reputacion += numero;
    }
    
    public void bajarReputacion(Heroes heroe, int numero){
        this.reputacion -= numero;
    }
}
