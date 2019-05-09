package clases;

import java.util.ArrayList;

import componentes.LabelTexto;

/**
 *
 * @author Ivan Diaz Vera
 */
public class Enemigo extends Personaje{
    
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
     * @param dinero Variable de tipo entero que indica el dinero actual.
     */
    public Enemigo(String nombre, String descripcion, int saludMaxima, 
        int salud, int fuerza, int magia, int agilidad, int defensa, 
        ArrayList<Habilidad> habilidadesArray, int dinero, int experiencia) {
        super(nombre, descripcion, saludMaxima, salud, fuerza, magia, agilidad, defensa, habilidadesArray, dinero, experiencia);
    }
    
    //FUNCIONES
    
    /**
     * La salud se iguala con la saludMaxima, es decir realiza una curacion completa y tambien se restablecen todos los usos de las habilidades.
     */
    public void restablecerEnemigo(){
        setSalud(getSaludMaxima());
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
        heroe.setSalud(heroe.getSalud()-dañoHabilidad);
    }   
    
    /**
     * Funcion que permite utilizar una habilidad del enemigo gastando usos restantes de esta, el heroe recibe el daño de dicha habilidad.
     * @param heroe Personaje que recibe el daño de una habilidad.
     */
    public void usarHabilidadesEnemigos(Heroe heroe, LabelTexto registro){
        int aleatorio = NumeroAleatorio(0, 1);  
        String resultadoUso="<html><center><b>"+getNombre()+" utiliza una habilidad!<br>";
	        if(getHabilidadesArray().get(aleatorio).getUsosRestantes()>0){
	        	resultadoUso+=(getHabilidadesArray().get(aleatorio).getNombre()+" inflige "
	        			+getMagia()*getHabilidadesArray().get(aleatorio).getEspecial() +" puntos de daño.");
	        	resultadoUso+="</b></center></html>";
	        	registro.setText(resultadoUso);
	            getHabilidadesArray().get(aleatorio).setUsosRestantes(getHabilidadesArray().get(aleatorio).getUsosRestantes()-1);                     
	            dañoHabilidadesEnemigo(heroe, aleatorio); 
	        }else{    
	        	registro.setText("<html><center><b>"+getNombre()+" falla al intentar utilizar una habilidad!</b></center></html>");
	        }
    }    
    
    /*
	 * Funcion que nos ayuda a generar numeros aleatorios necesarios para calculos de daño.
	 */
    public static int NumeroAleatorio(int minimo,int maximo){
        int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
        return num;
    }
}
