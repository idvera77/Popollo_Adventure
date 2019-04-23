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
    
    //Getters y Setters
    
    public int getDropDinero() {
        return dropDinero;
    }

    public void setDropDinero(int dropDinero) {
        this.dropDinero = dropDinero;
    }   
    
    //FUNCIONES
    
    /**
     * La salud se iguala con la saludMaxima, es decir realiza una curacion completa y tambien se restablecen todos los usos de las habilidades.
     */
    public void restablecerEnemigo(){
        this.salud = this.saludMaxima;
        for (int i = 0; i < getHabilidadesArray().size(); i++) {
            getHabilidadesArray().get(i).setUsosRestantes(getHabilidadesArray().get(i).getUsosMaximos());
        }
    } 
    
    /**
     * Funcion para calcular el daño realizado por una habilidad, se multiplica el valor de magia por el valor Especial de una habilidad.
     * @param heroe Indica el heroe que recibe el daño.
     * @param numero Indica la habilidad seleccionada.
     */
    public void dañoHabilidadesEnemigo(Heroe heroe, int numero){
        int dañoHabilidad = getMagia()*getHabilidadesArray().get(numero).getEspecial();
        heroe.salud -= dañoHabilidad;
    }   
    
    /**
     * Funcion que permite utilizar una habilidad del enemigo gastando usos restantes de esta, el heroe recibe el daño de dicha habilidad.
     * @param heroe Personaje que recibe el daño de una habilidad.
     */
    public void usarHabilidadesEnemigos(Heroe heroe){
        int aleatorio = NumeroAleatorio(0, 1);  
        if(getHabilidadesArray().get(aleatorio).getUsosRestantes()>0){
            System.out.println("- "+getNombre()+" usa "+getHabilidadesArray().get(aleatorio).getNombre()
                +" e inflige una cantidad de "+getMagia()*getHabilidadesArray().get(aleatorio).getEspecial()
                    +" puntos de daño.");
            getHabilidadesArray().get(aleatorio).setUsosRestantes(getHabilidadesArray().get(aleatorio).getUsosRestantes()-1);                     
            dañoHabilidadesEnemigo(heroe, aleatorio); 
        }else{    
              System.out.println("- No puede utilizar la habilidad. Pierde el turno.");
        }
    }    
}
