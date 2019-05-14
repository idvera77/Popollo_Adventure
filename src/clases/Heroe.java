package clases;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import componentes.LabelCombateEvento;
import componentes.LabelPrincipal;
import pantallas.Ventana;

/**
 *
 * @author Ivan Diaz Vera
 */
public final class Heroe extends Personaje{
    private ArrayList<Objeto> objetosArray;
    private int reputacion;
    private int nivel;
    private int explorar;
    
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
     * @param nivel Variable de tipo entero que indica el nivel actual.
     * @param explorar Variable de tipo entero que indica en que posicion se encuentra popollo.
     */
    public Heroe(String nombre, String descripcion, int saludMaxima, int salud, int fuerza, int magia, int agilidad, 
        int defensa, ArrayList<Habilidad> habilidadesArray, ArrayList<Objeto> objetosArray, int dinero, 
        int reputacion, int experiencia, int nivel, int explorar) {
        super(nombre, descripcion, saludMaxima, salud, fuerza, magia, agilidad, defensa, habilidadesArray, dinero, experiencia);
        this.objetosArray = objetosArray;
        this.reputacion = reputacion;
        this.nivel = nivel;
        this.explorar = explorar;
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
    
    
    public int getExplorar() {
        return explorar;
    }

    public void setExplorar(int explorar) {
        this.explorar = explorar;
    }

    //FUNCIONES
    /**
     * Muestra todas las estadisticas.
     * @param registro JLabelText que guarda la informacion y la muestra.
     */
    public void pantallaGeneralEstadisticas(LabelPrincipal registro){
    	registro.setText("<html><center><b>Nivel: "+getNivel()+"</b></center>"
            +" Salud: "+getSalud()+" / "+getSaludMaxima()
            +"<br/> Fuerza: "+getFuerza()
            +"<br/> Magia: "+getMagia()
            +"<br/> Defensa: "+getDefensa()
            +"<br/> Agilidad: "+getAgilidad()
            +"</html>"); 
    }  
	
    /**
     * Funcion que nos permite subir el nivel del heroe si llega a 100 puntos de experiencia y muestra todo el texto en un JOptionPane.
     * @param numero Variable de tipo entero que aumenta la experiencia del heroe
     */
    public void subirNivel(int numero){
        setExperiencia(getExperiencia()+numero);
        if(getExperiencia()>=100){
            setExperiencia(getExperiencia()-100);    
            if(nivel % 2 == 0){
            	String subirNivel="<html><center><b>!!!Subes de nivel!!!<br>"
                    +getNivel()+" >>> "+(getNivel()+1)+"<br>"
                    +"Tus atributos aumentan ^_^<br>"
                    +"Magia + 1 punto<br>"
                    +"Agilidad + 1 puntos</b></center></html>";
            	JOptionPane.showMessageDialog(null, subirNivel); 
                setMagia(getMagia()+1);
                setAgilidad(getAgilidad()+1);
                setNivel(getNivel()+1);
            }else{
            	String subirNivel="<html><center><b>!!!Subes de nivel!!!<br>"
                    +getNivel()+" >>> "+(getNivel()+1)+"<br>"
                    + "Tus atributos aumentan ^_^<br>"
                    +"Salud + 20 puntos<br>"
                    +"Agilidad + 1 punto<br>"
                    +"Defensa + 2 puntos</b></center></html>";
            	JOptionPane.showMessageDialog(null, subirNivel);  
                setSaludMaxima(getSaludMaxima()+20);
                setSalud(getSalud()+20);
                setFuerza(getFuerza()+2);
                setDefensa(getDefensa()+2);
                setNivel(getNivel()+1);
            }
        }
    }
    
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
    
    //Funciones de HABILIDADES
    /**
     * Muestra un listado de las habilidades.
     * @param registro JLabel que guarda la informacion y la muestra.
     */
    public void mostrarHabilidades(LabelPrincipal registro){
        String listaHabilidades="";
        listaHabilidades +="<html><center><b>Habilidades</b></center>";
        for (int i = 0; i < getHabilidadesArray().size(); i++) {
            listaHabilidades +=getHabilidadesArray().get(i).getNombre()+" "
                +getHabilidadesArray().get(i).getUsosRestantes()
                +"/"+getHabilidadesArray().get(i).getUsosMaximos()+"<br>";
        }     
        listaHabilidades+="</html>";
        registro.setText(listaHabilidades);   
    }
    
    /**
     * Muestra un listado de las habilidades en Combate
     * @param registro JLabel que guarda la informacion y la muestra.
     */
    public void mostrarHabilidadesCombate (LabelCombateEvento registro){
        String listaHabilidades="";
        listaHabilidades +="<html><b>";
        for (int i = 0; i < getHabilidadesArray().size(); i++) {
            listaHabilidades +="("+(i+1)+") "+getHabilidadesArray().get(i).getNombre()
                +" | Usos:\n "+getHabilidadesArray().get(i).getUsosRestantes()
                +"/"+getHabilidadesArray().get(i).getUsosMaximos()+"<br>";
        }     
        listaHabilidades+="</b></html>";
        registro.setText(listaHabilidades);   
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
     * @param registro JLabel encargado de mostrar el texto en la pantalla de Lucha.
     * @param rutaSonido1 String con la ruta del archivo de sonido 1.
     * @param rutaSonido2 String con la ruta del archivo de sonido 2.
     */
    public void usarHabilidades(int numero, Enemigo enemigo, LabelCombateEvento registro, String rutaSonido1, String rutaSonido2){
        if(getHabilidadesArray().get(numero).getUsosRestantes()>0){
            String tipo = String.valueOf(getHabilidadesArray().get(numero).getTipo());
            if(tipo.equals("OFENSIVO")){
            	String resultadoUso="<html><center><b>"+getHabilidadesArray().get(numero).getNombre()
                    +" inflige "+getMagia()*getHabilidadesArray().get(numero).getEspecial()
                    +" puntos de daño.</b></center></html>";
            	registro.setText(resultadoUso);
                getHabilidadesArray().get(numero).setUsosRestantes(getHabilidadesArray().get(numero).getUsosRestantes()-1);                     
                dañoHabilidadesHeroe(enemigo, numero);
                Ventana.comenzarSonido(rutaSonido1);
            }else if(tipo.equals("CURATIVO")){
            	String resultadoUso="<html><center><b>"+getHabilidadesArray().get(numero).getNombre()
                    +" restablece "+getMagia()*getHabilidadesArray().get(numero).getEspecial()
                    +" puntos de salud.</b></center></html>";
                    registro.setText(resultadoUso);
                getHabilidadesArray().get(numero).setUsosRestantes(getHabilidadesArray().get(numero).getUsosRestantes()-1);                     
                curacionHabilidades(numero);
                Ventana.comenzarSonido(rutaSonido2);
            }    
        }else{
            registro.setText("<html><center><b>No tienes suficiente energia.</b></center></html>");  
        }
    }
	    
    //Funciones de OBJETOS
    /**
     * Muestra un listado de los objetos
     * @param registro JLabelText que guarda la informacion y la muestra.
     */
    public void mostrarObjetos (LabelPrincipal registro){
        String listaObjetos="";
        listaObjetos+="<html><center><b>Objetos</b></center>";
        for (int i = 0; i < getObjetosArray().size(); i++) {
            listaObjetos +=getObjetosArray().get(i).getNombre()+" "
            +getObjetosArray().get(i).getCantidad()+"<br>";
        }     
        listaObjetos+="</html>";
        registro.setText(listaObjetos);
    }
		
    /**
     * Muestra un listado de los objetos en Combate
     * @param registro JLabelText que guarda la informacion y la muestra.
     */
    public void mostrarObjetosCombate (LabelCombateEvento registro){
    String listaObjetos="";
    listaObjetos+="<html><b>";
    for (int i = 0; i < getObjetosArray().size(); i++) {
        listaObjetos +=" ("+(i+1)+") "+getObjetosArray().get(i).getNombre()
            +" | Cantidad: "+getObjetosArray().get(i).getCantidad()+"<br>";
    }     
    listaObjetos+="</b></html>";
    registro.setText(listaObjetos);
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
     * @param registro JLabel encargado de mostrar el texto en la pantalla de Lucha.
     * @param rutaSonido1 String con la ruta del archivo de sonido 1.
     * @param rutaSonido2 String con la ruta del archivo de sonido 2.
     */
    public void usarObjetos (int numero, Enemigo enemigo, LabelCombateEvento registro, String rutaSonido1, String rutaSonido2){
        if(getObjetosArray().get(numero).getCantidad()>0){
            String tipo = String.valueOf(getObjetosArray().get(numero).getTipo());
            if(tipo.equals("OFENSIVO")){
            	String resultadoUso="<html><center><b>"+getObjetosArray().get(numero).getNombre()
                    +" inflige "+getObjetosArray().get(numero).getPoder()
                    +" puntos de daño.</b></center></html>";
            	registro.setText(resultadoUso);
                getObjetosArray().get(numero).setCantidad(getObjetosArray().get(numero).getCantidad()-1);  
                dañoObjetos(enemigo, numero);
                Ventana.comenzarSonido(rutaSonido1);
            }else if(tipo.equals("CURATIVO")){
            	String resultadoUso="<html><center><b>"+getObjetosArray().get(numero).getNombre()
                    +" restablece "+getObjetosArray().get(numero).getPoder()
                    +" puntos de salud.</b></center></html>";
            	registro.setText(resultadoUso);
                getObjetosArray().get(numero).setCantidad(getObjetosArray().get(numero).getCantidad()-1);
                curacionObjetos(numero);       
                Ventana.comenzarSonido(rutaSonido2);
            }    
        }else{    
            registro.setText("<html><center><b>No tienes suficientes objetos.</b></center></html>");
        } 
    }
     
    //FUNCIONES DESCANSO y TIENDA
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
     * @param numero Variable de tipo entero que indica la opcion seleccionada.
     * @param rutaSonido1 String con la ruta del archivo de sonido 1.
     * @param rutaSonido2 String con la ruta del archivo de sonido 2.
     */
    public void puntoDescanso(int numero, String rutaSonido, String rutaSonido2){
        switch(numero){ 
            case 0:
                if (getDinero()>=300) {
                    setDinero(getDinero()-300); 
                    regenerarSalud();
                    Ventana.comenzarSonido(rutaSonido);
                    break;
                }else {
                    Ventana.comenzarSonido(rutaSonido2);
                }
                break;
            case 1:
                if (getDinero()>=750) {
                    setDinero(getDinero()-750);
                    regenerarHabilidades();
                    Ventana.comenzarSonido(rutaSonido);
                }else {
                    Ventana.comenzarSonido(rutaSonido2);
                }
                break;
            case 2:
                if (getDinero()>=1000) {
                    setDinero(getDinero()-1000);
                    regenerarSaludHabilidades();
                    Ventana.comenzarSonido(rutaSonido);
                }else {
                    Ventana.comenzarSonido(rutaSonido2);
                }
                break;         
        }    
    } 
    
    /**
     * Funcion que nos aumenta la cantidad de objetos si tenemos el dinero necesario.
     * @param numero Nos indica el objeto de la tienda.
     * @param rutaSonido1 String con la ruta del archivo de sonido 1.
     * @param rutaSonido2 String con la ruta del archivo de sonido 2.
     */
    public void comprarObjetos(int numero, String rutaSonido, String rutaSonido2){
        if (getDinero()>=getObjetosArray().get(numero).getPrecio()) {
            setDinero(getDinero()-getObjetosArray().get(numero).getPrecio());
            getObjetosArray().get(numero).setCantidad(getObjetosArray().get(numero).getCantidad()+1); 
            Ventana.comenzarSonido(rutaSonido);
        }else {
            Ventana.comenzarSonido(rutaSonido2);
        }  
    }
    
    /**
     * Funcion que nos aumenta los atributos del heroe si tenemos el dinero necesario.
     * @param numero Nos indica el atributo.
     * @param rutaSonido1 String con la ruta del archivo de sonido 1.
     * @param rutaSonido2 String con la ruta del archivo de sonido 2.
     */
    public void mejorarEstadisticas(int numero, String rutaSonido, String rutaSonido2){
        switch(numero){
            case 0:
            	if(getDinero()>=750){
                    setDinero(getDinero()-750);
                    setSaludMaxima(getSaludMaxima()+20);
                    setSalud(getSalud()+20);
                    Ventana.comenzarSonido(rutaSonido);
            	}else {
                    Ventana.comenzarSonido(rutaSonido2);
                }
                break;
            case 1:
            	if(getDinero()>=1000){
                    setDinero(getDinero()-1000);
                    setFuerza(getFuerza()+5);
                    Ventana.comenzarSonido(rutaSonido);
                }else {
                    Ventana.comenzarSonido(rutaSonido2);
                }
                break;
            case 2:
            	if(getDinero()>=1500){
                    setDinero(getDinero()-1500);
                    setMagia(getMagia()+1); 
                    Ventana.comenzarSonido(rutaSonido);
                }else {
                    Ventana.comenzarSonido(rutaSonido2);
                }
                break;
            case 3:
            	if(getDinero()>=1000){
                    setDinero(getDinero()-1000);
                    setDefensa(getDefensa()+2); 
                    Ventana.comenzarSonido(rutaSonido);
            	}else {
                    Ventana.comenzarSonido(rutaSonido2);
                }
                break;
            case 4:
            	if(getDinero()>=1000){
                    setDinero(getDinero()-1000);
                    setAgilidad(getAgilidad()+2);  
                    Ventana.comenzarSonido(rutaSonido);
                }else {
                    Ventana.comenzarSonido(rutaSonido2);
                }
                break;
        }    
    }
}
