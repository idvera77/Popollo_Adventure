/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static general.Combate.NumeroAleatorio;
import java.util.ArrayList;

/**
 *
 * @author Mystra77
 */
public class Personaje extends ElementoIdentificador{
    private int saludMaxima;
    private int salud;
    private int fuerza;
    private int magia;
    private int agilidad;
    private int defensa;
    private ArrayList<Habilidad> habilidadesArray;
    private int dinero;
    private int experiencia;

    /**
     * Constructor de Personaje
     * @param nombre Variable de tipo String para indicar un nombre.
     * @param descripcion Variable de tipo String para escribir una descripcion.
     * @param saludMaxima Variable de tipo entero que indica la salud maxima.
     * @param salud Variable de tipo entero que indica la salud actual.
     * @param fuerza Variable de tipo entero que indica la fuerza actual.
     * @param magia Variable de tipo entero que indica la magia actual.
     * @param agilidad Variable de tipo entero que indica la agilidad actual.
     * @param defensa Variable de tipo entero que indica la defensa actual.
     * @param habilidadesArray Array con las habilidades.
     * @param dinero Variable de tipo entero que indica el dinero actual.
     * @param experiencia Puntos de experiencia.
    */
    public Personaje(String nombre, String descripcion, int saludMaxima, int salud, int fuerza, int magia, int agilidad, int defensa, ArrayList<Habilidad> habilidadesArray, int dinero, int experiencia) {
        super(nombre, descripcion);
        this.saludMaxima = saludMaxima;
        this.salud = salud;
        this.fuerza = fuerza;
        this.magia = magia;
        this.agilidad = agilidad;
        this.defensa = defensa;
        this.habilidadesArray = habilidadesArray;
        this.dinero = dinero;
        this.experiencia = experiencia;
    }
    
    //Getters y Setters
    
    public int getSaludMaxima() {
        return saludMaxima;
    }

    public void setSaludMaxima(int saludMaxima) {
        this.saludMaxima = saludMaxima;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getMagia() {
        return magia;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public ArrayList<Habilidad> getHabilidadesArray() {
        return habilidadesArray;
    }

    public void setHabilidadesArray(ArrayList<Habilidad> habilidadesArray) {
        this.habilidadesArray = habilidadesArray;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    
    //FUNCIONES
    
    /**
     * Funcion para determinar el daño causado al personajeX, su defensa - el daño enemigo.
     * @param personajeX Personaje que recibe daño en su salud
     * @param daño Parametro externo que indica el daño que recibe el personajeX
     */
    public void daño(Personaje personajeX, int daño){ 
        int inflige = defensa-daño;
            if(inflige<=0){
                this.salud -= -inflige;
            }else{
                this.salud -= 0;
        }
    }
    
    /**
     * Funcion para golpear con ataques fisicos. Dependiendo de la agilidad de ambos cambian los resultados.
     * @param personajeX Es el personaje que ataca y hace daño.
     * @param personajeY Es el personaje que recibe el daño.
     */
    public void atacar(Personaje personajeX, Personaje personajeY){
        int dañar;
        int aleatorio = NumeroAleatorio(0, 2);
        if(personajeX.getAgilidad()>personajeY.getAgilidad()){
            System.out.println("!!GOLPE CRITICO!!");
            dañar = personajeX.getFuerza()*2;
            personajeY.daño(personajeY,dañar);
            System.out.println("- "+personajeX.getNombre()+" inflige "+personajeX.getFuerza()*2+" puntos de daño.");
            System.out.println("- "+personajeY.getNombre()+" bloquea "+personajeY.getDefensa()+" puntos de daño.");
        }else if(personajeX.getAgilidad()==personajeY.getAgilidad()){
            dañar = personajeX.getFuerza();
            personajeY.daño(personajeY,dañar);
            System.out.println("- "+personajeX.getNombre()+" inflige "+personajeX.getFuerza()+" puntos de daño.");
            System.out.println("- "+personajeY.getNombre()+" bloquea "+personajeY.getDefensa()+" puntos de daño.");
        }else{
            if(aleatorio==0){
                System.out.println("Ataque fallado");
            }else{
                dañar = personajeX.getFuerza();
                personajeY.daño(personajeY,dañar);
                System.out.println("- "+personajeX.getNombre()+" inflige "+personajeX.getFuerza()+" puntos de daño.");
                System.out.println("- "+personajeY.getNombre()+" bloquea "+personajeY.getDefensa()+" puntos de daño.");
            }
        }
    }
  
    /**
     * Funcion que multiplica en 2 su atributo defensivo.
     * @param personajeX Personaje que utilizada la funcion de bloqueo.
     */
    public void Bloqueo (Personaje personajeX){
        this.defensa= defensa*2;
    }
    
    /**
     * Funcion que divide en 2 su atributo defensivo.
     * @param personajeX Personaje que utilizada la funcion de bloqueoOff.
     */
    public void BloqueoOff (Personaje personajeX){
        this.defensa = defensa/2;
    }   
}
