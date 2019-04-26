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
    public void subirNivel(int numero){
        experiencia += numero;
        System.out.println("Tu experiencia aumenta en "+numero+".");
        if(experiencia>=100){
            System.out.println("Subes de Nivel!!!");
            this.experiencia = 0;    
            if(nivel % 2 == 0){
                System.out.println("Tus atributos aumentan ^_^\n"
                        +"\tMagia + 1 puntos\n"
                        +"\tAgilidad + 1 puntos\n");
                setMagia(getMagia()+1);
                setAgilidad(getAgilidad()+1);
            }else{
                System.out.println("Tus atributos aumentan ^_^\n"
                        +"\tSalud + 20 puntos\n"
                        +"\tFuerza + 2 puntos\n"
                        +"\tDefensa + 2 puntos\n");
                setSaludMaxima(getSaludMaxima()+20);
                setSalud(getSalud()+20);
                setFuerza(getFuerza()+2);
                setDefensa(getDefensa()+2);
            }
        }else{
            System.out.println("Necesitas "+(100-getExperiencia())+" puntos mas para subir de nivel.");
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
        enemigo.salud -= dañoHabilidad;
    }
    
    /**
     * Funcion para calcular la curacion realizada por una habilidad, se multiplica el valor de magia por el valor Especial de una habilidad.
     * @param numero Indica la habilidad seleccionada
     */
    public void curacionHabilidades (int numero){
        int curacionHabilidad = getMagia()*getHabilidadesArray().get(numero).getEspecial();
        this.salud += curacionHabilidad;
        if(salud>saludMaxima){
            this.salud = this.saludMaxima;
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
        enemigo.salud -= dañoObjeto;
    }
    
        
    /**
     * Funcion para calcular la curacion realizada por un objeto.
     * @param numero Indica el objeto seleccionado.
     */
    public void curacionObjetos (int numero){
        int curacionObjeto = getObjetosArray().get(numero).getPoder();
        this.salud += curacionObjeto;
        if(salud>saludMaxima){
            this.salud = this.saludMaxima;
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
        this.salud = this.saludMaxima;
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
        this.salud = this.saludMaxima;
        for (int i = 0; i < getHabilidadesArray().size(); i++) {
            getHabilidadesArray().get(i).setUsosRestantes(getHabilidadesArray().get(i).getUsosMaximos());
        }
    }  
    
    /**
     * Funcion que reune todas las de regenerar salud o restablecimiento de habilidades a cambio de dinero.
     */
    public void puntoDescanso(){
        Scanner sc = new Scanner (System.in);
        System.out.println("|Total de monedas de oro: *"+getDinero()+"*|");
        String menuPuntoDescanso="- Una luz radiante te llama la atencion."
            +"\n\t0 - Salir."
            +"\n\t1 - Curar todos los daños recibidos - 100 Monedas de oro."
            +"\n\t2 - Restablecer el uso de las habilidades - 200 Monedas de oro."
            +"\n\t3 - Curacion completa y restablecimiento de habilidades - 250 Monedas de oro.";
        System.out.println(menuPuntoDescanso);
        int opcion1=Integer.parseInt(sc.nextLine());
        switch(opcion1){
            case 0:
                System.out.println("- Sientes tristeza al abandonar la luz.\n");
                break;
            case 1:
                if (dinero>=100) {
                    dinero -= 100; 
                    regenerarSalud();
                    System.out.println("- Las heridas comienzan a curarse magicamente.\n");
                    puntoDescanso();
                    break;
                }else{
                    System.out.println("- La luz emite un brillo debil.\n");
                    puntoDescanso();
                }
                break;
            case 2:
                if (dinero>=200) {
                    dinero -= 200;
                    regenerarHabilidades();
                    System.out.println("- Sientes que el cansancio abandona tu cuerpo.\n");
                    puntoDescanso();
                    break;
                }else{
                    System.out.println("- La luz emite un brillo debil.\n");
                    puntoDescanso();
                }
                break;
            case 3:
                if (dinero>=250) {
                dinero -= 250;
                regenerarSaludHabilidades();
                System.out.println("- Nunca te has sentido mejor que ahora.\n");
                puntoDescanso();
                break;
            }else{
                System.out.println("- La luz emite un brillo debil.\n");
                puntoDescanso();
            }
                break;    
            default:
                System.out.println("- No comprendes como comunicarte con la luz.\n");
                puntoDescanso();
            break;
        }    
    } 
    
    //Funciones de compra.
    
    /**
     * Funcion que nos aumenta la cantidad de objetos si tenemos el dinero necesario.
     */
    public void comprarObjetos(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\t0 - Salir.");
        mostrarObjetosTienda();
        int opcion1=Integer.parseInt(sc.nextLine());
        if(opcion1-1>=getObjetosArray().size()){
            System.out.println("- Ese objeto no existe!\n");
            comprarObjetos();
        }else if(opcion1==0){ 
            tienda();
        }else{
            if (dinero>=getObjetosArray().get(opcion1-1).getPrecio()) {
                dinero -= getObjetosArray().get(opcion1-1).getPrecio();
                getObjetosArray().get(opcion1-1).setCantidad(getObjetosArray().get(opcion1-1).getCantidad()+1);
                System.out.println("- Has obtenido 1 "+getObjetosArray().get(opcion1-1).getNombre()+"! Buena compra señor.\n"
                +"|Total de monedas de oro: *"+getDinero()+"*|\n"      
                +"- ¿Desea algo mas?");
                comprarObjetos();
            }else{
                System.out.println("|Total de monedas de oro: *"+getDinero()+"*|");
                System.out.println("- No tienes suficiente dinero. No me hagas perder el tiempo.");
                System.out.println("- ¿Que objeto desea comprar?");
                comprarObjetos();
            }   
        }    
    }
    
    /**
     *  Funcion que nos aumenta los atributos del heroe si tenemos el dinero necesario.
     */
    public void mejorarEstadisticas(){
        Scanner sc = new Scanner(System.in);
        System.out.println("|Total de monedas de oro: *"+getDinero()+"*|");
        String menuEstadisticas ="- ¿Que atributo quiere mejorar?:"
            +"\n\t0 - Salir."
            +"\n\t1 - Aumentar 50 puntos de Vida maxima - 500 Monedas."
            +"\n\t2 - Aumentar 10 puntos de Fuerza - 750 Monedas."
            +"\n\t3 - Aumentar 5 puntos de Magia - 1500 Monedas."
            +"\n\t4 - Aumentar 5 puntos de Defensa - 1000 Monedas."
            +"\n\t5 - Aumentar 5 de Agilidad - 750 Monedas.";   
        System.out.println(menuEstadisticas);
        int opcion1=Integer.parseInt(sc.nextLine());
        switch(opcion1){
            case 0:
                tienda();
                break;
            case 1:
                if(dinero>=500){
                    dinero -= 500;
                    setSaludMaxima(getSaludMaxima()+50);
                    setSalud(getSalud()+50);
                    System.out.println("- La vida maxima aumenta en 50 puntos.");
                }else{
                    System.out.println("- No tienes suficiente dinero. No me hagas perder el tiempo.");
                }
                mejorarEstadisticas();
                break;
            case 2:
                if(dinero>=750){
                    dinero -= 750;
                    setFuerza(getFuerza()+10);
                    System.out.println("- El atributo fuerza aumenta en 10 puntos.");
                }else{
                    System.out.println("- No tienes suficiente dinero. No me hagas perder el tiempo.");         
                }
                mejorarEstadisticas();
                break;
            case 3:
                if(dinero>=1500){
                    dinero -= 1500;
                    setMagia(getMagia()+5); 
                    System.out.println("- El atributo magia aumenta en 5 puntos.");
                }else{
                    System.out.println("- No tienes suficiente dinero. No me hagas perder el tiempo.");
                }
                mejorarEstadisticas();
                break;
            case 4:
                if(dinero>=1000){
                    dinero -= 1000;
                    setDefensa(getDefensa()+5); 
                    System.out.println("- El atributo defensa aumenta en 5 puntos.");
                }else{
                    System.out.println("- No tienes suficiente dinero. No me hagas perder el tiempo.");
                }
                mejorarEstadisticas();
                break;
            case 5:
                if(dinero>=750){
                    dinero -= 750;
                    setAgilidad(getAgilidad()+5);  
                    System.out.println("- El atributo agilidad aumenta en 5 puntos.");
                }else{
                    System.out.println("- No tienes suficiente dinero. No me hagas perder el tiempo.");
                }
                mejorarEstadisticas();
                break;
            default:
                System.out.println("- No entiendo lo que quiere decir, ¿puede repetir por favor?.\n");
                mejorarEstadisticas();
            break;
        }    
    }
    
    /**
     * Funcion para utilizar la Tienda en el juego, incluye varias opciones, menu y otras funciones relacionadas con comprar objetos.
     */
    public void tienda(){
        Scanner sc = new Scanner (System.in);
        System.out.println("|Total de monedas de oro: *"+getDinero()+"*|");
        String menuTienda="- ¿Le interesa algo?:"
            +"\n\t0 - Salir."
            +"\n\t1 - Aumentar atributos."
            +"\n\t2 - Comprar objetos.";
        System.out.println(menuTienda);
        int opcion1=Integer.parseInt(sc.nextLine());
        switch(opcion1){
            case 0:
                System.out.println("- Vuelva pronto, le esperamos con los brazos abiertos ^_^\n");
                break;
            case 1:
                mejorarEstadisticas();
                break;
            case 2:
                System.out.println("|Total de monedas de oro: *"+getDinero()+"*|");
                System.out.println("- ¿Que objeto desea comprar?");
                comprarObjetos();
                break;
            default:
                System.out.println("- No entiendo lo que quiere decir, ¿puede repetir por favor?.\n");
                tienda();
            break;
        }    
    }      
    
    //Funciones de apoyo
    
    /**
     * Muestra todas las estadisticas, objetos y habilidades.
     */
    public void pantallaGeneralEstadisticas(){
        Scanner sc = new Scanner (System.in);  
        System.out.println("\t!!!Atributos!!!");
        System.out.println("\tVida: "+getSalud()+"/"+getSaludMaxima());
        System.out.println("\tFuerza: "+getFuerza());
        System.out.println("\tMagia: "+getMagia());
        System.out.println("\tDefensa: "+getDefensa());
        System.out.println("\tAgilidad: "+getAgilidad()+"\n");
        System.out.println("\tReputacion: "+getReputacion()+" || "+"Monedas de oro: "+getDinero()+"\n");
        System.out.println("\t!!!Habilidades!!!");
        mostrarHabilidadesTotal();
        System.out.println("\t!!!Objetos!!!");
        mostrarObjetosTienda();
        System.out.println("*** Pulse cualquier tecla para salir ***");
        sc.nextLine();
    }  
}
