package clases;

import exceptions.InvalidMoralException;
import pantallas.Ventana;

import java.util.Scanner;

import javax.swing.JLabel;

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
    public static void recompensasNpc(Npc npc, Heroe heroe, JLabel registro){
    	//sonido
    	String sonidoPremio = "./recursos/sonidos/Premio.wav";
    	
        String tipo = String.valueOf(npc.getMoral());
        if(tipo.equals("LEGAL")){
        	if(heroe.getReputacion()>25&heroe.getReputacion()<=50) {
        		heroe.setSaludMaxima(heroe.getSaludMaxima()+20);
                heroe.setSalud(heroe.getSalud()+20);
                heroe.setDinero(heroe.getDinero()+1000);
                registro.setText("<html><center>Recibes 1000 monedas de oro.<br>Tu salud maxima ha aumentado 20 puntos.</center></html>");
        	}
        	if(heroe.getReputacion()>50) {
        		heroe.setSaludMaxima(heroe.getSaludMaxima()+50);
                heroe.setSalud(heroe.getSalud()+50);
                heroe.setDinero(heroe.getDinero()+2000);
                heroe.setDefensa(heroe.getDefensa()+5);
                registro.setText("<html><center>Recibes 2000 monedas de oro.<br>Tu salud maxima ha aumentado 50 puntos.<br>Tu defensa maxima aumenta 5 puntos.</center></html>");
        	}
        }	
        if(tipo.equals("NEUTRAL")){
        	if(heroe.getReputacion()<=25&&heroe.getReputacion()>=-25) {
        		heroe.setSaludMaxima(heroe.getSaludMaxima()+20);
                heroe.setSalud(heroe.getSalud()+20);
                heroe.setManaMaximo(heroe.getManaMaximo()+5);
                heroe.setMana(heroe.getMana()+5);
                heroe.setFuerza(heroe.getFuerza()+5);
                registro.setText("<html><center>Tu salud maxima ha aumentado 20 puntos.<br>Tu mana maximo aumenta 5 puntos.<br>Tu fuerza maxima aumenta 5 puntos.</center></html>");
        	}
        }
        if(tipo.equals("CAOTICO")){
        	if(heroe.getReputacion()<-25&&heroe.getReputacion()>=-50) {
        		heroe.setManaMaximo(heroe.getManaMaximo()+5);
                heroe.setMana(heroe.getMana()+5);
                heroe.setDinero(heroe.getDinero()+1000);
                registro.setText("<html><center>Recibes 1000 monedas de oro.<br>Tu mana maximo aumenta 5 puntos.</center></html>");

        	}
        	if(heroe.getReputacion()<-50) {
        		heroe.setManaMaximo(heroe.getManaMaximo()+10);
                heroe.setMana(heroe.getMana()+10);
                heroe.setMagia(heroe.getMagia()+1);
                heroe.setDinero(heroe.getDinero()+1000);
                registro.setText("<html><center>Recibes 1000 monedas de oro.<br>Tu mana maximo aumenta 10 puntos.<br>Tu magia maxima aumenta 1 punto.</center></html>");
        	}
        }  
        Ventana.comenzarSonido(sonidoPremio);
    }
}
