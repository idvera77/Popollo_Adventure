package clases;

import exceptions.InvalidMoralException;
import java.util.Scanner;

/**
 *
 * @author Ivan Diaz Vera
 */
public final class Npc extends ElementoIdentificador{
    private tipoMoral moral;
    
    /**
     * Constructor de Npc
     * @param nombre Variable de tipo String para indicar un nombre.
     * @param descripcion Variable de tipo String para escribir una descripcion.
     * @param moral Variable tipo que nos permite indicar la moral del npc y asi modificar ciertas funciones.
     */
    public Npc(String nombre, String descripcion, String moral) throws InvalidMoralException {
        super(nombre, descripcion);
        setMoral(moral);
    }
     
    public enum tipoMoral{
        LEGAL,
        NEUTRAL,
        CAOTICO
    }   

    public tipoMoral getMoral() {
        return moral;
    }

    public void setMoral(String moral) throws InvalidMoralException{
        switch(moral.toLowerCase()){
           case "legal":
               this.moral=tipoMoral.LEGAL;
               break;
           case "neutral":
               this.moral=tipoMoral.NEUTRAL;
               break;
           case "caotico":
               this.moral=tipoMoral.CAOTICO;
               break;    
           default:
               throw new InvalidMoralException(moral+" no es valida. Solo puede ser 'legal', 'neutral' o 'caotico'.");
        }  
    }
    
    /**
     * Funcion que compara la reputacion del heroe y la moral del npc para a�adir dialogos o dar recompensas al heroe.
     * @param npcs Del cual conseguiremos beneficios o dialogos dependiendo de su moral.
     * @param heroe Del cual sacaremos una reputacion y obtendra beneficios.
     */
    public static void recompensasNpc(Npc npcs, Heroe heroe){
        String tipo = String.valueOf(npcs.getMoral());
        if(tipo.equals("LEGAL")){
        	if(heroe.getReputacion()==20) {
        		heroe.setSaludMaxima(heroe.getSaludMaxima()+20);
                heroe.setSalud(heroe.getSalud()+20);
                heroe.setDinero(heroe.getDinero()+1000);
        	}
        	if(heroe.getReputacion()==40) {
        		heroe.setSaludMaxima(heroe.getSaludMaxima()+20);
                heroe.setSalud(heroe.getSalud()+20);
                heroe.setDinero(heroe.getDinero()+1000);
        	}
        	if(heroe.getReputacion()==80) {
        		heroe.setSaludMaxima(heroe.getSaludMaxima()+20);
                heroe.setSalud(heroe.getSalud()+20);
                heroe.setDinero(heroe.getDinero()+1000);
        	}
        }	
        if(tipo.equals("NEUTRAL")){
        	if(heroe.getReputacion()==0) {
        		heroe.setSaludMaxima(heroe.getSaludMaxima()+20);
                heroe.setSalud(heroe.getSalud()+20);
                heroe.setDinero(heroe.getDinero()+1000);
        	}
        	if(heroe.getReputacion()==20) {
        		heroe.setSaludMaxima(heroe.getSaludMaxima()+20);
                heroe.setSalud(heroe.getSalud()+20);
                heroe.setDinero(heroe.getDinero()+1000);
        	}
        	if(heroe.getReputacion()==-20) {
        		heroe.setSaludMaxima(heroe.getSaludMaxima()+20);
                heroe.setSalud(heroe.getSalud()+20);
                heroe.setDinero(heroe.getDinero()+1000);
        	}
        }
        if(tipo.equals("CAOTICO")){
        	if(heroe.getReputacion()==-20) {
        		heroe.setSaludMaxima(heroe.getSaludMaxima()+20);
                heroe.setSalud(heroe.getSalud()+20);
                heroe.setDinero(heroe.getDinero()+1000);
        	}
        	if(heroe.getReputacion()==-40) {
        		heroe.setSaludMaxima(heroe.getSaludMaxima()+20);
                heroe.setSalud(heroe.getSalud()+20);
                heroe.setDinero(heroe.getDinero()+1000);
        	}
        	if(heroe.getReputacion()==-80) {
        		heroe.setSaludMaxima(heroe.getSaludMaxima()+20);
                heroe.setSalud(heroe.getSalud()+20);
                heroe.setDinero(heroe.getDinero()+1000);
        	}
        }    
    }
}
