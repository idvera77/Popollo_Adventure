/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import static general.Combate.NumeroAleatorio;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mystra77
 */
public class Personajes extends ElementoIdentificador{
    public int saludMaxima;
    public int salud;
    private int fuerza;
    private int magia;
    private int agilidad;
    private int defensa;
    private ArrayList<Habilidades> habilidadesArray;

    /**
     * 
     * @param nombre
     * @param descripcion
     * @param saludMaxima
     * @param salud
     * @param fuerza
     * @param magia
     * @param agilidad
     * @param defensa
     * @param habilidadesArray 
     */
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

    public ArrayList<Habilidades> getHabilidadesArray() {
        return habilidadesArray;
    }

    public void setHabilidadesArray(ArrayList<Habilidades> habilidadesArray) {
        this.habilidadesArray = habilidadesArray;
    }
    
    /**
     * Funcion para determinar el daño causado al personajeX, su defensa - el daño enemigo.
     * @param personajeX Personaje que recibe daño en su salud
     * @param daño Parametro externo que indica el daño que recibe el personajeX
     */
    public void daño(Personajes personajeX, int daño){ 
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
    public void atacar(Personajes personajeX, Personajes personajeY){
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
     * Muestra un listado de las habilidades y los usos restantes guardados en un ArrayList.
     * @param personajeX Indicamos el personaje del cual queremos conocer sus habilidades.
     */
    public void MostrarHabilidades (Personajes personajeX){
        String listaHabilidades="";
            for (int i = 0; i < personajeX.getHabilidadesArray().size(); i++) {
                listaHabilidades +="- ("+(i+1)+")"+personajeX.getHabilidadesArray().get(i).getNombre()
                        +" | Usos: "+personajeX.getHabilidadesArray().get(i).getUsosRestantes()
                        +"/"+personajeX.getHabilidadesArray().get(i).getUsosMaximos()+" ";
            }     
        System.out.println(listaHabilidades);      
    }
    
    /**
     * Muestra un listado de las habilidades y los usos restantes guardados en un ArrayList.
     * @param personajeX Indicamos el personaje del cual queremos conocer sus habilidades.
     */
    public void MostrarHabilidadesTotal (Personajes personajeX){
        String listaHabilidades="";
            for (int i = 0; i < personajeX.getHabilidadesArray().size(); i++) {
                listaHabilidades +="\t"+(i+1)+" - "+personajeX.getHabilidadesArray().get(i).getNombre()
                        +" | Poder de Habilidad: "+personajeX.getHabilidadesArray().get(i).getEspecial()
                        +" | Usos: "+personajeX.getHabilidadesArray().get(i).getUsosRestantes()+"/"+personajeX.getHabilidadesArray().get(i).getUsosMaximos()
                        +" | Descripcion: "+personajeX.getHabilidadesArray().get(i).getDescripcion()
                        +"\n";
            }     
        System.out.println(listaHabilidades);      
    }    
    /**
     * Funcion para calcular el daño realizado por una habilidad, se multiplica el valor de magia por el valor Especial de una habilidad.
     * @param personajeX Indica el personaje que utilizara las habilidades.
     * @param numero Indica la habilidad seleccionada.
     */
    public void dañoHabilidades (Personajes personajeX, int numero){
        int dañoHabilidad = personajeX.getMagia()*personajeX.getHabilidadesArray().get(numero).getEspecial();
        this.salud -= dañoHabilidad;
    }
    
    /**
     * Funcion para calcular la curacion realizada por una habilidad, se multiplica el valor de magia por el valor Especial de una habilidad.
     * @param personajeX Indica el personaje que utilizara las habilidades.
     * @param numero Indica la habilidad seleccionada
     */
    public void curacionHabilidades (Personajes personajeX, int numero){
        int curacionHabilidad = personajeX.getMagia()*personajeX.getHabilidadesArray().get(numero).getEspecial();
        this.salud += curacionHabilidad;
        if(personajeX.salud>personajeX.saludMaxima){
            this.salud = this.saludMaxima;
        }
    }
    
    /**
     * Funcion que permite utilizar una habilidad del heroe gastando usos restantes de esta, el enemigo recibe el daño de dicha habilidad.
     * @param heroe Personaje que puede usar una habilidad mediante Scanner.
     * @param enemigo Personaje que recibe el daño de una habilidad.
     */
    public void usarHabilidades(Heroes heroe, Enemigos enemigo){
        Scanner sc = new Scanner (System.in);
        int opcion = sc.nextInt();
        if(opcion-1>=heroe.getHabilidadesArray().size()){
            System.out.println("- No recuerdas usar tus propias habilidades!");
            MostrarHabilidades(heroe);
            usarHabilidades(heroe, enemigo);
        }else{
            if(heroe.getHabilidadesArray().get(opcion-1).getUsosRestantes()>0){
                String tipo = String.valueOf(heroe.getHabilidadesArray().get(opcion-1).getTipo());
                if(tipo.equals("OFENSIVO")){
                    System.out.println("- "+heroe.getNombre()+" usa "+heroe.getHabilidadesArray().get(opcion-1).getNombre()
                        +" e inflige una cantidad de "+heroe.getMagia()*heroe.getHabilidadesArray().get(opcion-1).getEspecial()
                        +" puntos de daño.");
                    heroe.getHabilidadesArray().get(opcion-1).setUsosRestantes(heroe.getHabilidadesArray().get(opcion-1).getUsosRestantes()-1);                     
                    enemigo.dañoHabilidades(heroe, opcion-1);
                }else if(tipo.equals("SANACION")){
                    System.out.println("- "+heroe.getNombre()+" usa "+heroe.getHabilidadesArray().get(opcion-1).getNombre()
                        +" y recibe una curacion de "+heroe.getMagia()*heroe.getHabilidadesArray().get(opcion-1).getEspecial()
                        +" puntos de salud.");
                    heroe.getHabilidadesArray().get(opcion-1).setUsosRestantes(heroe.getHabilidadesArray().get(opcion-1).getUsosRestantes()-1);                     
                    heroe.curacionHabilidades(heroe, opcion-1);
                }    
            }else{
                System.out.println("- No puedes utilizar la habilidad. Pierdes el turno.");  
            }
        }
    }
    
    /**
     * Funcion que permite utilizar una habilidad del enemigo gastando usos restantes de esta, el heroe recibe el daño de dicha habilidad.
     * @param enemigo Personaje que utiliza una habilidad mediante un valor aleatorio.
     * @param heroe Personaje que recibe el daño de una habilidad.
     */
    public void usarHabilidadesEnemigos(Enemigos enemigo, Heroes heroe){
        int aleatorio = NumeroAleatorio(0, 1);  
        if(enemigo.getHabilidadesArray().get(aleatorio).getUsosRestantes()>0){
            System.out.println("- "+enemigo.getNombre()+" usa "+enemigo.getHabilidadesArray().get(aleatorio).getNombre()
                +" e inflige una cantidad de "+enemigo.getMagia()*enemigo.getHabilidadesArray().get(aleatorio).getEspecial()
                    +" puntos de daño.");
            enemigo.getHabilidadesArray().get(aleatorio).setUsosRestantes(enemigo.getHabilidadesArray().get(aleatorio).getUsosRestantes()-1);                     
            heroe.dañoHabilidades(enemigo, aleatorio); 
        }else{    
              System.out.println("- No puede utilizar la habilidad. Pierde el turno.");
        }
    }
    
    /**
     * Muestra un listado de los objetos del heroe.
     * @param heroe Indicamos el heroe del cual queremos conocer sus objetos.
     */
    public void MostrarObjetos (Heroes heroe){
        String listaObjetos="";
            for (int i = 0; i < heroe.getObjetosArray().size(); i++) {
                listaObjetos +="- ("+(i+1)+")"+heroe.getObjetosArray().get(i).getNombre()
                        +" | Cantidad: "+heroe.getObjetosArray().get(i).getCantidad()+" ";
            }     
        System.out.println(listaObjetos);
    }
    
    /**
     * Muestra un listado completo de los objetos.
     * @param heroe 
     */
    public void MostrarObjetosTienda (Heroes heroe){
                String listaObjetos="";
            for (int i = 0; i < heroe.getObjetosArray().size(); i++) {
                listaObjetos +="\t"+(i+1)+" - "+heroe.getObjetosArray().get(i).getNombre()
                        +" | Cantidad: "+heroe.getObjetosArray().get(i).getCantidad()+" | "
                        +"Descripcion: "+heroe.getObjetosArray().get(i).getDescripcion()+" | "
                        +"Precio: "+heroe.getObjetosArray().get(i).getPrecio()+" Monedas de oro.\n";
            }     
        System.out.println(listaObjetos);
    }
    
    /**
     * Funcion para calcular el daño realizado por un objeto.
     * @param heroe Indica el personaje que utilizara el objeto.
     * @param numero Indica el objeto seleccionado.
     */
    public void dañoObjetos (Heroes heroe, int numero){
        int dañoObjeto = heroe.getObjetosArray().get(numero).getPoder();
        this.salud -= dañoObjeto;
    }
    
    /**
     * Funcion para calcular la curacion realizada por un objeto.
     * @param heroe Indica el personaje que utilizara el objeto.
     * @param numero Indica el objeto seleccionado.
     */
    public void curacionObjetos (Heroes heroe, int numero){
        int curacionObjeto = heroe.getObjetosArray().get(numero).getPoder();
        this.salud += curacionObjeto;
        if(heroe.salud>heroe.saludMaxima){
            this.salud = this.saludMaxima;
        }
    }
    
    /**
     * Funcion que permite utilizar un objeto del heroe restando -1 a la cantidad maxima de este, el enemigo recibe el daño de dicho objeto.
     * @param heroe Personaje que puede usar un objeto mediante Scanner.
     * @param enemigo Personaje que recibe el daño de un objeto.
     */
    public void usarObjetos (Heroes heroe, Enemigos enemigo){
        Scanner sc = new Scanner (System.in);
        int opcion=Integer.parseInt(sc.nextLine());
        if(opcion-1>=heroe.getObjetosArray().size()){
            System.out.println("- Ten cuidado al coger esos objetos!");
            MostrarObjetos(heroe);
            usarObjetos(heroe, enemigo);
        }else{
            if(heroe.getObjetosArray().get(opcion-1).getCantidad()>0){
                String tipo = String.valueOf(heroe.getObjetosArray().get(opcion-1).getTipo());
                if(tipo.equals("ATAQUE")){
                    System.out.println("- "+heroe.getNombre()+" usa "+heroe.getObjetosArray().get(opcion-1).getNombre()
                        +" e inflige una cantidad de "+heroe.getObjetosArray().get(opcion-1).getPoder()+" puntos de daño.");
                    heroe.getObjetosArray().get(opcion-1).setCantidad(heroe.getObjetosArray().get(opcion-1).getCantidad()-1);  
                    enemigo.dañoObjetos(heroe, opcion-1);  
                }else if(tipo.equals("CURACION")){
                    System.out.println("- "+heroe.getNombre()+" usa "+heroe.getObjetosArray().get(opcion-1).getNombre()
                        +" y recibe una curacion de "+heroe.getObjetosArray().get(opcion-1).getPoder()+" puntos de salud.");
                    heroe.getObjetosArray().get(opcion-1).setCantidad(heroe.getObjetosArray().get(opcion-1).getCantidad()-1);
                    heroe.curacionObjetos(heroe, opcion-1);       
                }    
            }else{    
                System.out.println("- No te quedan objetos. Pierdes el turno.");
            } 
        }     
    }
    
    /**
     * Funcion que multiplica en 2 su atributo defensivo.
     * @param personajeX Personaje que utilizada la funcion de bloqueo.
     */
    public void Bloqueo (Personajes personajeX){
        this.defensa= defensa*2;
    }
    
    /**
     * Funcion que divide en 2 su atributo defensivo.
     * @param personajeX Personaje que utilizada la funcion de bloqueoOff.
     */
    public void BloqueoOff (Personajes personajeX){
        this.defensa = defensa/2;
    }
    
    /**
     * La salud se iguala con la saludMaxima, es decir realiza una curacion completa.
     * @param personajeX Indica el personaje que realiza la funcion.
     */
    public void regenerarSalud(Personajes personajeX){
        this.salud = this.saludMaxima;
    }
    
    /**
     * Las habilidades igualan sus usosRestantes con los usos maximos, es decir se restablecen todos los usos de las habilidades.
     * @param personajeX Indica el personaje que realiza la funcion.
     */
    public void regenerarHabilidades(Personajes personajeX){
        for (int i = 0; i < getHabilidadesArray().size(); i++) {
            getHabilidadesArray().get(i).setUsosRestantes(getHabilidadesArray().get(i).getUsosMaximos());
        }
    }    
    
    /**
     * La salud se iguala con la saludMaxima, es decir realiza una curacion completa y tambien se restablecen todos los usos de las habilidades.
     * @param personajeX Indica el personaje que realiza la funcion.
     */
    public void regenerarSaludHabilidades(Personajes personajeX){
        this.salud = this.saludMaxima;
        for (int i = 0; i < getHabilidadesArray().size(); i++) {
            getHabilidadesArray().get(i).setUsosRestantes(getHabilidadesArray().get(i).getUsosMaximos());
        }
    } 
    
    /**
     * Funcion que reune todas las de regenerar salud o restablecimiento de habilidades a cambio de dinero.
     * @param heroe Personaje que recibe la regeneracion a cambio de dinero.
     */
    public void puntoDescanso(Heroes heroe){
        Scanner sc = new Scanner (System.in);
        System.out.println("|Total de monedas de oro: *"+heroe.getDinero()+"*|");
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
                if (heroe.dinero>=100) {
                    heroe.dinero -= 100; 
                    heroe.regenerarSalud(heroe);
                    System.out.println("- Las heridas comienzan a curarse magicamente.\n");
                    puntoDescanso(heroe);
                    break;
                }else{
                    System.out.println("- La luz emite un brillo debil.\n");
                    puntoDescanso(heroe);
                }
                break;
            case 2:
                if (heroe.dinero>=200) {
                    heroe.dinero -= 200;
                    heroe.regenerarHabilidades(heroe);
                    System.out.println("- Sientes que el cansancio abandona tu cuerpo.\n");
                    puntoDescanso(heroe);
                    break;
                }else{
                    System.out.println("- La luz emite un brillo debil.\n");
                    puntoDescanso(heroe);
                }
                break;
            case 3:
                if (heroe.dinero>=250) {
                heroe.dinero -= 250;
                heroe.regenerarSaludHabilidades(heroe);
                System.out.println("- Nunca te has sentido mejor que ahora.\n");
                puntoDescanso(heroe);
                break;
            }else{
                System.out.println("- La luz emite un brillo debil.\n");
                puntoDescanso(heroe);
            }
                break;    
            default:
                System.out.println("- No comprendes como comunicarte con la luz.\n");
                puntoDescanso(heroe);
            break;
        }    
    }
    
    /**
     * Funcion que nos aumenta la cantidad de objetos si tenemos el dinero necesario.
     * @param heroe Indica el personaje que comprara los objetos.
     * @param dinero Variable necesaria para comprar objetos, permite hacerlo o no dependiendo de la cantidad.
     */
    public void comprarObjetos(Heroes heroe, int dinero){
        Scanner sc = new Scanner(System.in);
        System.out.println("\t0 - Salir.");
        MostrarObjetosTienda(heroe);
        int opcion1=Integer.parseInt(sc.nextLine());
        if(opcion1-1>=heroe.getObjetosArray().size()){
            System.out.println("- Ese objeto no existe!\n");
            comprarObjetos(heroe, dinero);
        }else if(opcion1==0){ 
            Tienda(heroe);
        }else{
            if (heroe.dinero>=heroe.getObjetosArray().get(opcion1-1).getPrecio()) {
                heroe.dinero -= heroe.getObjetosArray().get(opcion1-1).getPrecio();
                heroe.getObjetosArray().get(opcion1-1).setCantidad(heroe.getObjetosArray().get(opcion1-1).getCantidad()+1);
                System.out.println("- Has obtenido 1 "+heroe.getObjetosArray().get(opcion1-1).getNombre()+"! Buena compra señor.\n"
                +"|Total de monedas de oro: *"+heroe.getDinero()+"*|\n"      
                +"- ¿Desea algo mas?");
                comprarObjetos(heroe, dinero);
            }else{
                System.out.println("|Total de monedas de oro: *"+heroe.getDinero()+"*|");
                System.out.println("- No tienes suficiente dinero. No me hagas perder el tiempo.");
                System.out.println("- ¿Que objeto desea comprar?");
                comprarObjetos(heroe, dinero);
            }   
        }    
    }
    
    public void mejorarEstadisticas(Heroes heroe, int dinero){
        Scanner sc = new Scanner(System.in);
        System.out.println("|Total de monedas de oro: *"+heroe.getDinero()+"*|");
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
                Tienda(heroe);
                break;
            case 1:
                if(heroe.dinero>=500){
                    heroe.dinero -= 500;
                    heroe.setSaludMaxima(heroe.getSaludMaxima()+50);
                    heroe.setSalud(heroe.getSalud()+50);
                    System.out.println("- La vida maxima aumenta en 50 puntos.");
                }else{
                    System.out.println("- No tienes suficiente dinero. No me hagas perder el tiempo.");
                }
                mejorarEstadisticas(heroe, dinero);
                break;
            case 2:
                if(heroe.dinero>=750){
                    heroe.dinero -= 750;
                    heroe.setFuerza(heroe.getFuerza()+10);
                    System.out.println("- El atributo fuerza aumenta en 10 puntos.");
                }else{
                    System.out.println("- No tienes suficiente dinero. No me hagas perder el tiempo.");         
                }
                mejorarEstadisticas(heroe, dinero);
                break;
            case 3:
                if(heroe.dinero>=1500){
                    heroe.dinero -= 1500;
                    heroe.setMagia(heroe.getMagia()+5); 
                    System.out.println("- El atributo magia aumenta en 5 puntos.");
                }else{
                    System.out.println("- No tienes suficiente dinero. No me hagas perder el tiempo.");
                }
                mejorarEstadisticas(heroe, dinero);
                break;
            case 4:
                if(heroe.dinero>=1000){
                    heroe.dinero -= 1000;
                    heroe.setDefensa(heroe.getDefensa()+5); 
                    System.out.println("- El atributo defensa aumenta en 5 puntos.");
                }else{
                    System.out.println("- No tienes suficiente dinero. No me hagas perder el tiempo.");
                }
                mejorarEstadisticas(heroe, dinero);
                break;
            case 5:
                if(heroe.dinero>=750){
                    heroe.dinero -= 750;
                    heroe.setAgilidad(heroe.getAgilidad()+5);  
                    System.out.println("- El atributo agilidad aumenta en 5 puntos.");
                }else{
                    System.out.println("- No tienes suficiente dinero. No me hagas perder el tiempo.");
                }
                mejorarEstadisticas(heroe, dinero);
                break;
            default:
                System.out.println("- No entiendo lo que quiere decir, ¿puede repetir por favor?.\n");
                mejorarEstadisticas(heroe, dinero);
            break;
        }    
    }
    /**
     * Funcion para utilizar la Tienda en el juego, incluye varias opciones, menu y otras funciones relacionadas con comprar objetos.
     * @param heroe Indica el personaje que utilizara la tienda.
     */
    public void Tienda(Heroes heroe){
        Scanner sc = new Scanner (System.in);
        System.out.println("|Total de monedas de oro: *"+heroe.getDinero()+"*|");
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
                mejorarEstadisticas(heroe, heroe.getDinero());
                break;
            case 2:
                System.out.println("|Total de monedas de oro: *"+heroe.getDinero()+"*|");
                System.out.println("- ¿Que objeto desea comprar?");
                comprarObjetos(heroe, heroe.getDinero());
                break;
            default:
                System.out.println("- No entiendo lo que quiere decir, ¿puede repetir por favor?.\n");
                Tienda(heroe);
            break;
        }    
    }
    
    public void pantallaGeneralEstadisticas(Heroes heroe){
        Scanner sc = new Scanner (System.in);  
        System.out.println("\t!!!Atributos!!!");
        System.out.println("\tVida: "+heroe.getSalud()+"/"+heroe.getSaludMaxima());
        System.out.println("\tFuerza: "+heroe.getFuerza());
        System.out.println("\tMagia: "+heroe.getMagia());
        System.out.println("\tDefensa: "+heroe.getDefensa());
        System.out.println("\tAgilidad: "+heroe.getAgilidad()+"\n");
        System.out.println("\t!!!Habilidades!!!");
        MostrarHabilidadesTotal(heroe);
        System.out.println("\t!!!Objetos!!!");
        MostrarObjetosTienda(heroe);
        System.out.println("Pulse cualquier tecla para salir.");
        sc.nextLine();
        
    
}
}
