package clases;

import pantallas.*;
import componentes.BotonesDialogo;
import componentes.LabelCombateEvento;

/**
 *
 * @author Ivan Diaz Vera
 */
public final class Eventos {
    
	/**
	 * Funcion que simula un evento en el cual mediante opciones de dialogo podemos aumentar o disminuir reputacion, conseguir objetos o dinero, etc.
     * @param heroe Indica el personaje que modifica sus parametros generales dependiendo de como se resuelva la situacion.
	 * @param eventoTexto JLabel que guarda y muestra los dialogos del evento.
	 * @param opcion1 Botones que nos ayudan a elegir las opciones, se muestra un mensaje en ellos.
	 * @param opcion2 Botones que nos ayudan a elegir las opciones, se muestra un mensaje en ellos.
	 * @param opcion3 Botones que nos ayudan a elegir las opciones, se muestra un mensaje en ellos.
	 * @param opcion Variable de tipo entero que nos permite indicar la opcion a realizar.
	 */
    public static void vagabundo(Ventana ventana, Heroe heroe, LabelCombateEvento eventoTexto, BotonesDialogo opcion1, BotonesDialogo opcion2, BotonesDialogo opcion3, int opcion){
    	eventoTexto.setText("<html><center>Encuentras un hombre tirado en el camino y por su aspecto no parece que este gozando de buena salud.<br>¿Que decides hacer?</center></html>");
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
                heroe.restablecerSalud();
                heroe.subirReputacion(25);
                break;
            case 3:
                eventoTexto.setText("<html><center>Buscas en sus bolsillos mientras intenta defenderse aunque no tiene fuerzas para ello.<br><br>"
                    + "* Obtienes 500 monedas de oro y el atributo agilidad mejora un punto *</center></html>");
                heroe.setAgilidad(heroe.getAgilidad()+1);
                heroe.setDinero(heroe.getDinero()+500);  
                heroe.subirReputacion(-25);
                break;  	
        } 
    }
    
    /**
	 * Funcion que simula un evento en el cual mediante opciones de dialogo podemos aumentar o disminuir reputacion, conseguir objetos o dinero, etc.
     * @param heroe Indica el personaje que modifica sus parametros generales dependiendo de como se resuelva la situacion.
	 * @param eventoTexto JLabel que guarda y muestra los dialogos del evento.
	 * @param opcion1 Botones que nos ayudan a elegir las opciones, se muestra un mensaje en ellos.
	 * @param opcion2 Botones que nos ayudan a elegir las opciones, se muestra un mensaje en ellos.
	 * @param opcion3 Botones que nos ayudan a elegir las opciones, se muestra un mensaje en ellos.
	 * @param opcion Variable de tipo entero que nos permite indicar la opcion a realizar.
	 */  
    public static void rescateAldeanos(Ventana ventana, Heroe heroe, LabelCombateEvento eventoTexto, BotonesDialogo opcion1, BotonesDialogo opcion2, BotonesDialogo opcion3, int opcion){
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
                Ventana.pararFondo();
                Ventana.origenADestino(ventana, "evento", "lucha", 1);
                heroe.setSaludMaxima(heroe.getSaludMaxima()+20);
                heroe.setSalud(heroe.getSalud()+20);
                heroe.subirReputacion(25);
                break;
            case 3:
                eventoTexto.setText("<html><center>Aprovechas el alboroto causado por el ataque del monstruo y saqueas todo lo que puedes.<br><br>"
                    + "* Obtienes 1000 monedas de oro y el atributo agilidad mejora en 2 puntos *</center></html>");
                heroe.setDinero(heroe.getDinero()+1000);  
                heroe.setAgilidad(heroe.getAgilidad()+2);
                heroe.subirReputacion(-25);
                break;  	
        }  
    }
    
    /**
	 * Funcion que simula un evento en el cual mediante opciones de dialogo podemos aumentar o disminuir reputacion, conseguir objetos o dinero, etc.
     * @param heroe Indica el personaje que modifica sus parametros generales dependiendo de como se resuelva la situacion.
	 * @param eventoTexto JLabel que guarda y muestra los dialogos del evento.
	 * @param opcion1 Botones que nos ayudan a elegir las opciones, se muestra un mensaje en ellos.
	 * @param opcion2 Botones que nos ayudan a elegir las opciones, se muestra un mensaje en ellos.
	 * @param opcion3 Botones que nos ayudan a elegir las opciones, se muestra un mensaje en ellos.
	 * @param opcion Variable de tipo entero que nos permite indicar la opcion a realizar.
	 */   
    public static void golemCofre(Ventana ventana, Heroe heroe, LabelCombateEvento eventoTexto, BotonesDialogo opcion1, BotonesDialogo opcion2, BotonesDialogo opcion3, int opcion) {
        eventoTexto.setText("<html>Cerca de unas ruinas encuentras un Golem persiguiendo a una jovenzuela.<center>Al lado de ambos puedes ver un cofre que llama mucho tu atención.<br></center></html>");
     	opcion1.setText("Pasar de largo.");
     	opcion2.setText("Te enfrentas al Golem para salvar a la joven.");
     	opcion3.setText("Aprovechas para abrir el cofre y largarte de allí.");
   
         switch(opcion) {
            case 1:
                eventoTexto.setText("<html><center>Sigues tu camino dejando atrás a la pobre muchacha.</center></html>");
                break;
            case 2:
            	heroe.subirReputacion(25);
                Ventana.pararFondo();
            	Ventana.origenADestino(ventana, "evento", "lucha", 2);
                heroe.setDinero(heroe.getDinero()+1500);  
                break;
            case 3:
            	eventoTexto.setText("<html><center>Abres el cofre y encuentras una gran cantidad de monedas de oro.<br><br>"
                    + "* Obtienes 3000 monedas de oro*</center></html>");
            	heroe.setDinero(heroe.getDinero()+3000); 
                heroe.subirReputacion(-25);
                break;
         }  
    }
      
    /**
	 * Funcion que simula un evento en el cual mediante opciones de dialogo podemos aumentar o disminuir reputacion, conseguir objetos o dinero, etc.
     * @param heroe Indica el personaje que modifica sus parametros generales dependiendo de como se resuelva la situacion.
	 * @param eventoTexto JLabel que guarda y muestra los dialogos del evento.
	 * @param opcion1 Botones que nos ayudan a elegir las opciones, se muestra un mensaje en ellos.
	 * @param opcion2 Botones que nos ayudan a elegir las opciones, se muestra un mensaje en ellos.
	 * @param opcion3 Botones que nos ayudan a elegir las opciones, se muestra un mensaje en ellos.
	 * @param opcion Variable de tipo entero que nos permite indicar la opcion a realizar.
	 */      
    public static void chuletitas(Ventana ventana, Heroe heroe, LabelCombateEvento eventoTexto, BotonesDialogo opcion1, BotonesDialogo opcion2, BotonesDialogo opcion3, int opcion) {
        eventoTexto.setText("<html><center><br></center></html>");
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
                heroe.subirReputacion(25);
                break;
            case 3:
                Ventana.pararFondo();
                Ventana.origenADestino(ventana, "evento", "lucha", 4);
                heroe.setDinero(heroe.getDinero()+2500);  
                heroe.subirReputacion(-25);
                break;  	
          }  
    }
 
    /**
	 * Funcion que simula un evento en el cual mediante opciones de dialogo podemos aumentar o disminuir reputacion, conseguir objetos o dinero, etc.
     * @param heroe Indica el personaje que modifica sus parametros generales dependiendo de como se resuelva la situacion.
	 * @param eventoTexto JLabel que guarda y muestra los dialogos del evento.
	 * @param opcion1 Botones que nos ayudan a elegir las opciones, se muestra un mensaje en ellos.
	 * @param opcion2 Botones que nos ayudan a elegir las opciones, se muestra un mensaje en ellos.
	 * @param opcion3 Botones que nos ayudan a elegir las opciones, se muestra un mensaje en ellos.
	 * @param opcion Variable de tipo entero que nos permite indicar la opcion a realizar.
	 */     
    public static void criasPoring(Ventana ventana, Heroe heroe, LabelCombateEvento eventoTexto, BotonesDialogo opcion1, BotonesDialogo opcion2, BotonesDialogo opcion3, int opcion) {
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
                heroe.subirReputacion(25);
                break;
            case 3:
            	Ventana.pararFondo();
                Ventana.origenADestino(ventana, "evento", "lucha", 4);
                heroe.setDinero(heroe.getDinero()+2500);  
                heroe.subirReputacion(-25);
                break;  	
        }  
    }
}
