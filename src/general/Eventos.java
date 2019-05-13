package general;

import clases.*;
import pantallas.*;
import componentes.BotonesDialogo;
import componentes.LabelTextoOtros;
import componentes.LabelTextoPrincipal;


import java.util.Scanner;

import javax.swing.JOptionPane;
/**
 *
 * @author Ivan Diaz Vera
 */
public class Eventos {
    
    /**
     * Funcion que simila un evento en el cual mediante opciones de dialogo podemos aumentar o disminuir reputacion, conseguir objetos o dinero, etc.
     * @param heroe Indica el personaje que modifica sus parametros generales dependiendo de como se resuelva la situacion.
     */
    public static void vagabundo(Ventana ventana, Heroe heroe, LabelTextoOtros eventoTexto, BotonesDialogo opcion1, BotonesDialogo opcion2, BotonesDialogo opcion3, int opcion){
    	eventoTexto.setText("<html><center>Encuentras un hombre tirado en los caminos.<br>¿Que decides hacer?</center></html>");
    	opcion1.setText("Pasar de largo.");
    	opcion2.setText("Ayudarle");
    	opcion3.setText("Robar sus pocas pertenencias.");
  
        switch(opcion) {
	        case 1:
	        	eventoTexto.setText("<html><center>El hombre te observa tristemente mientras te alejas.</center></html>");
	        	break;
	        case 2:
	        	eventoTexto.setText("<html><center>Te acercas al hombre y le ayudas a levantarse, te comenta que hace días que no ha podido comer.<br>" 
	        			+ "Le ofreces un poco de tu comida y habláis amistosamente durante un rato.<br><br>"
	        			+ "* Restableces todos los puntos de salud *</center></html>");
	        	heroe.regenerarSalud();
	        	heroe.subirReputacion(20);
	        	break;
	        case 3:
	        	eventoTexto.setText("<html><center>Buscas en sus bolsillos mientras intenta defenderse aunque no tiene fuerzas para ello.<br><br>"
	        			+ "* Obtienes 500 monedas de oro y el atributo agilidad mejora un punto *</center></html>");
	        	heroe.setAgilidad(heroe.getAgilidad()+1);
	        	heroe.setDinero(heroe.getDinero()+500);  
                heroe.subirReputacion(-20);
	        	break;  	
        } 
    }
    
    /**
     * Funcion que simila un evento en el cual mediante opciones de dialogo podemos aumentar o disminuir reputacion, conseguir objetos o dinero, etc.
     * @param heroe Indica el personaje que modifica sus parametros generales dependiendo de como se resuelva la situacion.
     * @param enemigo Indica el enemigo que luchara contra el heroe.
     */   
    public static void rescateAldeanos(Ventana v, Heroe heroe, LabelTextoOtros eventoTexto, BotonesDialogo opcion1, BotonesDialogo opcion2, BotonesDialogo opcion3, int opcion){
    	eventoTexto.setText("<html><center>Escuchas a lo lejos el sonido de una multitud gritando, puedes observar como un enorme monstruo se acerca a ellos.</center></html>");
    	opcion1.setText("Pasar de largo.");
    	opcion2.setText("Atacar al monstruo.");
    	opcion3.setText("Aprovechar el momento de confusión y robar a los aldeanos.");
    	
        switch(opcion) {
	        case 1:
	        	eventoTexto.setText("<html><center>Sigues tu camino hasta que los gritos dejan de escucharse.</center></html>");
	        	break;
	        case 2:
	        	eventoTexto.setText("<html><center>Te acercas rápidamente y comienza tu batalla.</center></html>");
	        	Ventana.origenADestino(v, "evento", "lucha", 1);
	        	heroe.setSaludMaxima(heroe.getSaludMaxima()+20);
                heroe.setSalud(heroe.getSalud()+20);
	        	heroe.subirReputacion(20);
	        	break;
	        case 3:
	        	eventoTexto.setText("<html><center>Aprovechas el alboroto causado por el ataque del monstruo y saqueas todo lo que puedes.<br><br>"
	        			+ "* Obtienes 1000 monedas de oro y el atributo agilidad mejora en 2 puntos *</center></html>");
	        	
	        	heroe.setDinero(heroe.getDinero()+1000);  
                heroe.subirReputacion(-20);
	        	break;  	
        }  
    }
    
    /**
     * Funcion que simila un evento en el cual mediante opciones de dialogo podemos aumentar o disminuir reputacion, conseguir objetos o dinero, etc.
     */   
     public static void revistaX(Ventana v, Heroe heroe, LabelTextoOtros eventoTexto, BotonesDialogo opcion1, BotonesDialogo opcion2, BotonesDialogo opcion3, int opcion) {
        	eventoTexto.setText("<html><center>Encuentras una madriguera de crías Poring llena de gemas.<br> Un pequeño poring te mira con entusiasmo.</center></html>");
     	opcion1.setText("Pasar de largo.");
     	opcion2.setText("Te paras y lo acaricias.");
     	opcion3.setText("Saquear el nido.");
   
         switch(opcion) {
 	        case 1:
 	        	eventoTexto.setText("<html><center>Sigues tu camino dejando atras la madriguera.</center></html>");
 	        	break;
 	        case 2:
 	        	eventoTexto.setText("<html><center>El pequeño poring empieza a darte mimitos y notas una gran calidez en tu corazón.<br><br>"
 	        			+ "* El atributo magia aumenta en 2 puntos *</center></html>");
 	        	heroe.setMagia(heroe.getMagia()+2);
 	        	heroe.subirReputacion(20);
 	        	break;
 	        case 3:
 	        	Ventana.origenADestino(v, "evento", "lucha", 4);
 	        	heroe.setDinero(heroe.getDinero()+2500);  
                 heroe.subirReputacion(-20);
 	        	break;  	
         }  
     }
     
     
     
     /**
      * Funcion que simila un evento en el cual mediante opciones de dialogo podemos aumentar o disminuir reputacion, conseguir objetos o dinero, etc.
      * @param heroe Indica el personaje que modifica sus parametros generales dependiendo de como se resuelva la situacion.
      * @param enemigo Indica el enemigo que luchara contra el heroe.
      */   
      public static void criasPopollo(Ventana v, Heroe heroe, LabelTextoOtros eventoTexto, BotonesDialogo opcion1, BotonesDialogo opcion2, BotonesDialogo opcion3, int opcion) {
         	eventoTexto.setText("<html><center>Encuentras una madriguera de crías Poring llena de gemas.<br> Un pequeño poring te mira con entusiasmo.</center></html>");
      	opcion1.setText("Pasar de largo.");
      	opcion2.setText("Te paras y lo acaricias.");
      	opcion3.setText("Saquear el nido.");
    
          switch(opcion) {
  	        case 1:
  	        	eventoTexto.setText("<html><center>Sigues tu camino dejando atras la madriguera.</center></html>");
  	        	break;
  	        case 2:
  	        	eventoTexto.setText("<html><center>El pequeño poring empieza a darte mimitos y notas una gran calidez en tu corazón.<br><br>"
  	        			+ "* El atributo magia aumenta en 2 puntos *</center></html>");
  	        	heroe.setMagia(heroe.getMagia()+2);
  	        	heroe.subirReputacion(20);
  	        	break;
  	        case 3:
  	        	Ventana.origenADestino(v, "evento", "lucha", 4);
  	        	heroe.setDinero(heroe.getDinero()+2500);  
                  heroe.subirReputacion(-20);
  	        	break;  	
          }  
      }
 

    /**
    * Funcion que simila un evento en el cual mediante opciones de dialogo podemos aumentar o disminuir reputacion, conseguir objetos o dinero, etc.
    * @param heroe Indica el personaje que modifica sus parametros generales dependiendo de como se resuelva la situacion.
    * @param enemigo Indica el enemigo que luchara contra el heroe.
    */   
    public static void criasPoring(Ventana v, Heroe heroe, LabelTextoOtros eventoTexto, BotonesDialogo opcion1, BotonesDialogo opcion2, BotonesDialogo opcion3, int opcion) {
       	eventoTexto.setText("<html><center>Encuentras una madriguera de crías Poring llena de gemas.<br> Un pequeño poring te mira con entusiasmo.</center></html>");
    	opcion1.setText("Pasar de largo.");
    	opcion2.setText("Te paras y lo acaricias.");
    	opcion3.setText("Saquear el nido.");
  
        switch(opcion) {
	        case 1:
	        	eventoTexto.setText("<html><center>Sigues tu camino dejando atras la madriguera.</center></html>");
	        	break;
	        case 2:
	        	eventoTexto.setText("<html><center>El pequeño poring empieza a darte mimitos y notas una gran calidez en tu corazón.<br><br>"
	        			+ "* El atributo magia aumenta en 2 puntos *</center></html>");
	        	heroe.setMagia(heroe.getMagia()+2);
	        	heroe.subirReputacion(20);
	        	break;
	        case 3:
	        	Ventana.origenADestino(v, "evento", "lucha", 4);
	        	heroe.setDinero(heroe.getDinero()+2500);  
                heroe.subirReputacion(-20);
	        	break;  	
        }  
    }
}
