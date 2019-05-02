package clases;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ivan Diaz Vera
 */
public class Heroe extends Personaje{
    private ArrayList<Objeto> objetosArray;
    private int reputacion;
    private int nivel;
    
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
     * @param reputacion Variable de tipo entero que indica la reputacion actual.
     * @param dinero Variable de tipo entero que indica el dinero actual.
     * @param experiencia Variable de tipo entero que indica la experiencia actual.
     * @param nivel Variable de tipo entero que indica el nivel actual
     */
    public Heroe(String nombre, String descripcion, int saludMaxima, int salud, int fuerza, int magia, int agilidad, 
        int defensa, ArrayList<Habilidad> habilidadesArray, ArrayList<Objeto> objetosArray, int dinero, 
        int reputacion, int experiencia, int nivel) {
        super(nombre, descripcion, saludMaxima, salud, fuerza, magia, agilidad, defensa, habilidadesArray, dinero, experiencia);
        this.objetosArray = objetosArray;
        this.reputacion = reputacion;
        this.nivel = nivel;
    }
    
    //Getters y Setters
    public ArrayList<Objeto> getObjetosArray() {
        return objetosArray;
    }

    public void setObjetosArray(ArrayList<Objeto> objetosArray) {
        this.objetosArray = objetosArray;
    }

    public int getReputacion() {
        return reputacion;
    }

    public void setReputacion(int reputacion) {
        this.reputacion = reputacion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    //FUNCIONES
    
    //Subir de nivel
    /**
     * Funcion que nos permite subir el nivel del heroe si llega a 100 puntos de experiencia.
     * @param numero Numero que subira la experiencia del heroe
     */
    public void subirNivel(int numero){
        setExperiencia(getExperiencia()+numero);
        if(getExperiencia()>=100){
            setExperiencia(getExperiencia()-100);    
            if(nivel % 2 == 0){
                System.out.println("\t\t!!!Subes de nivel!!! Tus atributos aumentan ^_^\n"
                        +"\t\t\tMagia + 1 puntos.\n"
                        +"\t\t\tAgilidad + 1 puntos.");
                setMagia(getMagia()+1);
                setAgilidad(getAgilidad()+1);
                setNivel(getNivel()+1);
            }else{
                System.out.println("\t\t!!!Subes de nivel!!! Tus atributos aumentan ^_^\n"
                        +"\t\t\tSalud + 20 puntos.\n"
                        +"\t\t\tFuerza + 2 puntos.\n"
                        +"\t\t\tDefensa + 2 puntos.");
                setSaludMaxima(getSaludMaxima()+20);
                setSalud(getSalud()+20);
                setFuerza(getFuerza()+2);
                setDefensa(getDefensa()+2);
                setNivel(getNivel()+1);
            }
        }else{
        }
    }
    
    //Reputacion
    /**
     * Funcion que nos permite aumentar la reputacion del heroe.
     * @param numero Numero que subira la reputacion del heroe.
     */
    public void subirReputacion(int numero){
        this.reputacion += numero;
    }
    
    /**
     * Funcion que nos permite disminuir la reputacion del heroe.
     * @param numero Numero que bajara la reputacion del heroe.
     */
    public void bajarReputacion(int numero){
        this.reputacion -= numero;
    }
    
    //Funciones de Habilidades
    /**
     * Muestra un listado de las habilidades y los usos restantes guardados en un ArrayList.
     */
    public void mostrarHabilidades (){
        String listaHabilidades="";
            for (int i = 0; i < getHabilidadesArray().size(); i++) {
                listaHabilidades +="- ("+(i+1)+")"+getHabilidadesArray().get(i).getNombre()
                        +" | Usos: "+getHabilidadesArray().get(i).getUsosRestantes()
                        +"/"+getHabilidadesArray().get(i).getUsosMaximos()+" ";
            }     
        System.out.println(listaHabilidades);      
    }
    
    /**
     * Muestra un listado de las habilidades y los usos restantes guardados en un ArrayList.
     */
    public void mostrarHabilidadesTotal (){
        String listaHabilidades="";
            for (int i = 0; i < getHabilidadesArray().size(); i++) {
                listaHabilidades +="\t"+(i+1)+" - "+getHabilidadesArray().get(i).getNombre()
                        +" | Poder de Habilidad: "+getHabilidadesArray().get(i).getEspecial()
                        +" | Usos: "+getHabilidadesArray().get(i).getUsosRestantes()+"/"+getHabilidadesArray().get(i).getUsosMaximos()
                        +" | Descripcion: "+getHabilidadesArray().get(i).getDescripcion()
                        +"\n";
            }     
        System.out.println(listaHabilidades);      
    } 
    
    /**
     * Funcion para calcular el daño realizado por una habilidad, se multiplica el valor de magia por el valor Especial de una habilidad.
     * @param enemigo Indica el enemigo que recibe el daño.
     * @param numero Indica la habilidad seleccionada.
     */
    public void dañoHabilidadesHeroe (Enemigo enemigo, int numero){
        int dañoHabilidad = getMagia()*getHabilidadesArray().get(numero).getEspecial();
        enemigo.setSalud(enemigo.getSalud()-dañoHabilidad);
    }
    
    /**
     * Funcion para calcular la curacion realizada por una habilidad, se multiplica el valor de magia por el valor Especial de una habilidad.
     * @param numero Indica la habilidad seleccionada
     */
    public void curacionHabilidades (int numero){
        int curacionHabilidad = getMagia()*getHabilidadesArray().get(numero).getEspecial();
        setSalud(getSalud()+curacionHabilidad);
        if(getSalud()>getSaludMaxima()){
            setSalud(getSaludMaxima());
        }
    }
    
    /**
     * Funcion que permite utilizar una habilidad del heroe gastando usos restantes de esta, el enemigo recibe el daño de dicha habilidad.
     * @param enemigo Personaje que recibe el daño de una habilidad.
     */
    public void usarHabilidades(Enemigo enemigo){
        Scanner sc = new Scanner (System.in);
        int opcion = sc.nextInt();
        if(opcion-1>=getHabilidadesArray().size()){
            System.out.println("- No recuerdas usar tus propias habilidades!");
            mostrarHabilidades();
            usarHabilidades(enemigo);
        }else{
            if(getHabilidadesArray().get(opcion-1).getUsosRestantes()>0){
                String tipo = String.valueOf(getHabilidadesArray().get(opcion-1).getTipo());
                if(tipo.equals("OFENSIVO")){
                    System.out.println("- "+getNombre()+" usa "+getHabilidadesArray().get(opcion-1).getNombre()
                        +" e inflige una cantidad de "+getMagia()*getHabilidadesArray().get(opcion-1).getEspecial()
                        +" puntos de daño.");
                    getHabilidadesArray().get(opcion-1).setUsosRestantes(getHabilidadesArray().get(opcion-1).getUsosRestantes()-1);                     
                    dañoHabilidadesHeroe(enemigo, opcion-1);
                }else if(tipo.equals("CURATIVO")){
                    System.out.println("- "+getNombre()+" usa "+getHabilidadesArray().get(opcion-1).getNombre()
                        +" y recibe una curacion de "+getMagia()*getHabilidadesArray().get(opcion-1).getEspecial()
                        +" puntos de salud.");
                    getHabilidadesArray().get(opcion-1).setUsosRestantes(getHabilidadesArray().get(opcion-1).getUsosRestantes()-1);                     
                    curacionHabilidades(opcion-1);
                }    
            }else{
                System.out.println("- No puedes utilizar la habilidad. Pierdes el turno.");  
            }
        }
    }
 
    //Funciones de Objetos
    
    /**
     * Muestra un listado de los objetos del heroe.
     */
    public void mostrarObjetos (){
        String listaObjetos="";
            for (int i = 0; i < getObjetosArray().size(); i++) {
                listaObjetos +="- ("+(i+1)+")"+getObjetosArray().get(i).getNombre()
                        +" | Cantidad: "+getObjetosArray().get(i).getCantidad()+" ";
            }     
        System.out.println(listaObjetos);
    }
    
    /**
     * Muestra un listado completo de los objetos.
     */
    public void mostrarObjetosTienda (){
                String listaObjetos="";
            for (int i = 0; i < getObjetosArray().size(); i++) {
                listaObjetos +="\t"+(i+1)+" - "+getObjetosArray().get(i).getNombre()
                        +" | Cantidad: "+getObjetosArray().get(i).getCantidad()+" | "
                        +"Descripcion: "+getObjetosArray().get(i).getDescripcion()+" | "
                        +"Precio: "+getObjetosArray().get(i).getPrecio()+" Monedas de oro.\n";
            }     
        System.out.println(listaObjetos);
    }
    
    /**
     * Funcion para calcular el daño realizado por un objeto.
     * @param enemigo Indica el enemigo que recibira el daño causado por el objeto
     * @param numero Indica el objeto seleccionado.
     */
    public void dañoObjetos (Enemigo enemigo,int numero){
        int dañoObjeto = getObjetosArray().get(numero).getPoder();
        enemigo.setSalud(enemigo.getSalud()-dañoObjeto);
    }
    
        
    /**
     * Funcion para calcular la curacion realizada por un objeto.
     * @param numero Indica el objeto seleccionado.
     */
    public void curacionObjetos (int numero){
        int curacionObjeto = getObjetosArray().get(numero).getPoder();
        setSalud(getSalud()+curacionObjeto);
        if(getSalud()>getSaludMaxima()){
           setSalud(getSaludMaxima());
        }
    }
    
    /**
     * Funcion que permite utilizar un objeto del heroe restando -1 a la cantidad maxima de este, el enemigo recibe el daño de dicho objeto.
     * @param enemigo Personaje que recibe el daño de un objeto.
     */
    public void usarObjetos (Enemigo enemigo){
        Scanner sc = new Scanner (System.in);
        int opcion=Integer.parseInt(sc.nextLine());
        if(opcion-1>=getObjetosArray().size()){
            System.out.println("- Ten cuidado al coger esos objetos!");
            mostrarObjetos();
            usarObjetos(enemigo);
        }else{
            if(getObjetosArray().get(opcion-1).getCantidad()>0){
                String tipo = String.valueOf(getObjetosArray().get(opcion-1).getTipo());
                if(tipo.equals("OFENSIVO")){
                    System.out.println("- "+getNombre()+" usa "+getObjetosArray().get(opcion-1).getNombre()
                        +" e inflige una cantidad de "+getObjetosArray().get(opcion-1).getPoder()+" puntos de daño.");
                    getObjetosArray().get(opcion-1).setCantidad(getObjetosArray().get(opcion-1).getCantidad()-1);  
                    dañoObjetos(enemigo, opcion-1);
                }else if(tipo.equals("CURATIVO")){
                    System.out.println("- "+getNombre()+" usa "+getObjetosArray().get(opcion-1).getNombre()
                        +" y recibe una curacion de "+getObjetosArray().get(opcion-1).getPoder()+" puntos de salud.");
                    getObjetosArray().get(opcion-1).setCantidad(getObjetosArray().get(opcion-1).getCantidad()-1);
                    curacionObjetos(opcion-1);       
                }    
            }else{    
                System.out.println("- No te quedan objetos. Pierdes el turno.");
            } 
        }     
    }
    
    
    //Funciones de restablecimiento
    
    /**
     * La salud se iguala con la saludMaxima, es decir realiza una curacion completa.
     */
    public void regenerarSalud(){
        setSalud(getSaludMaxima());
    }
    
    /**
     * Las habilidades igualan sus usosRestantes con los usos maximos, es decir se restablecen todos los usos de las habilidades.
     */
    public void regenerarHabilidades(){
        for (int i = 0; i < getHabilidadesArray().size(); i++) {
            getHabilidadesArray().get(i).setUsosRestantes(getHabilidadesArray().get(i).getUsosMaximos());
        }
    }    
    
    /**
     * La salud se iguala con la saludMaxima, es decir realiza una curacion completa y tambien se restablecen todos los usos de las habilidades.
     */
    public void regenerarSaludHabilidades(){
        setSalud(getSaludMaxima());
        for (int i = 0; i < getHabilidadesArray().size(); i++) {
            getHabilidadesArray().get(i).setUsosRestantes(getHabilidadesArray().get(i).getUsosMaximos());
        }
    }  
    
    /**
     * Funcion que reune todas las de regenerar salud o restablecimiento de habilidades a cambio de dinero.
     */
    public void puntoDescanso(int numero){
        switch(numero){ 
            case 0:
                if (getDinero()>=300) {
                    setDinero(getDinero()-300); 
                    regenerarSalud();
                    System.out.println("- Las heridas comienzan a curarse magicamente.\n");
                    break;
                }
                break;
            case 1:
                if (getDinero()>=750) {
                    setDinero(getDinero()-750);
                    regenerarHabilidades();
                    System.out.println("- Sientes que el cansancio abandona tu cuerpo.\n");
                }
                 break;
            case 2:
                if (getDinero()>=1000) {
                setDinero(getDinero()-1000);
                regenerarSaludHabilidades();
                System.out.println("- Nunca te has sentido mejor que ahora.\n");
                }
                break;         
        }    
    } 
    
    //Funciones de compra
    /**
     * Funcion que nos aumenta la cantidad de objetos si tenemos el dinero necesario.
     * @param numero Nos indica el objeto de la tienda.
     */
    public void comprarObjetos(int numero){
        if (getDinero()>=getObjetosArray().get(numero).getPrecio()) {
            setDinero(getDinero()-getObjetosArray().get(numero).getPrecio());
            getObjetosArray().get(numero).setCantidad(getObjetosArray().get(numero).getCantidad()+1); 
        }  
    }
    
    /**
     *  Funcion que nos aumenta los atributos del heroe si tenemos el dinero necesario.
     *  * @param numero Nos indica el atributo.
     */
    public void mejorarEstadisticas(int numero){
        switch(numero){
            case 0:
            	if(getDinero()>=750){
                    setDinero(getDinero()-750);
                    setSaludMaxima(getSaludMaxima()+20);
                    setSalud(getSalud()+20);
            	}
                break;
            case 1:
            	if(getDinero()>=1000){
                    setDinero(getDinero()-1000);
                    setFuerza(getFuerza()+5);
                }
                break;
            case 2:
            	if(getDinero()>=1500){
                    setDinero(getDinero()-1500);
                    setMagia(getMagia()+1); 
                }
                break;
            case 3:
            	if(getDinero()>=1000){
                    setDinero(getDinero()-1000);
                    setDefensa(getDefensa()+2); 
            	}
                break;
            case 4:
            	if(getDinero()>=1000){
                    setDinero(getDinero()-1000);
                    setAgilidad(getAgilidad()+2);  
                }
                break;
        }    
    }
     
    
    //Funciones de apoyo
    
    /**
     * Muestra todas las estadisticas, objetos y habilidades.
     */
    public void pantallaGeneralEstadisticas(){
        Scanner sc = new Scanner (System.in);  
        System.out.println("\tNivel: "+getNivel()+" ("+getExperiencia()+"/100)");;
        System.out.println("\tVida: "+getSalud()+"/"+getSaludMaxima());
        System.out.println("\tFuerza: "+getFuerza());
        System.out.println("\tMagia: "+getMagia());
        System.out.println("\tDefensa: "+getDefensa());
        System.out.println("\tAgilidad: "+getAgilidad());
        System.out.println("\t------------");
        System.out.println("\tReputacion: "+getReputacion());
        System.out.println("\tDinero: "+getDinero()+"\n");
        System.out.println("\t!!!Habilidades!!!");
        mostrarHabilidadesTotal();
        System.out.println("\t!!!Objetos!!!");
        mostrarObjetosTienda();
        System.out.println("*** Pulse cualquier tecla para salir ***");
        sc.nextLine();
    }  
}
