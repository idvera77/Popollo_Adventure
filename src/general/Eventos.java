package general;

import clases.*;
import componentes.Botones;
import componentes.BotonesDialogo;
import componentes.LabelTexto;


import java.util.Scanner;
/**
 *
 * @author Ivan Diaz Vera
 */
public class Eventos {
    
    /**
     * Funcion que simila un evento en el cual mediante opciones de dialogo podemos aumentar o disminuir reputacion, conseguir objetos o dinero, etc.
     * @param heroe Indica el personaje que modifica sus parametros generales dependiendo de como se resuelva la situacion.
     */
    public static void vagabundo(Heroe heroe, LabelTexto eventoTexto, BotonesDialogo opcion1, BotonesDialogo opcion2, BotonesDialogo opcion3, int opcion){
    	
    	eventoTexto.setText("<html><center>Encuentras un hombre tirado en los caminos.<br>¿Que decides hacer?</center></html>");
    	opcion1.setText("Pasar de largo.");
    	opcion2.setText("Ayudarle");
    	opcion3.setText("Robar sus pocas pertenencias.");
  
        switch(opcion) {
	        case 1:
	        	eventoTexto.setText("<html><center>El hombre te observa tristemente mientras te alejas.<br>¿Que decides hacer?</center></html>");
	        	break;
	        case 2:
	        	eventoTexto.setText("<html><center>Te acercas al hombre y le ayudas a levantarse, te comenta que hace dias que no ha podido comer.<br>" 
	        			+ "Le ofreces un poco de tu comida y hablais amistosamente durante un rato.</center></html>");
	        	heroe.subirReputacion(10);
	        	break;
	        case 3:
	        	eventoTexto.setText("<html><center>Buscas en los bolsillos mientras intenta defenderse aunque no tiene fuerzas para ello.<br>"
	        			+ "Obtienes 100 monedas de oro.</center></html>");
	        	heroe.setDinero(heroe.getDinero()+100);  
                heroe.subirReputacion(-10);
	        	break;  	
        } 
    }
    
    /**
     * Funcion que simila un evento en el cual mediante opciones de dialogo podemos aumentar o disminuir reputacion, conseguir objetos o dinero, etc.
     * @param heroe Indica el personaje que modifica sus parametros generales dependiendo de como se resuelva la situacion.
     * @param enemigo Indica el enemigo que luchara contra el heroe.
     */   
    public static void rescateAldeanos(Heroe heroe, Enemigo enemigo, LabelTexto eventoTexto, BotonesDialogo opcion1, BotonesDialogo opcion2, BotonesDialogo opcion3, int opcion){
    	eventoTexto.setText("<html><center>Escuchas a lo lejos el sonido de una multitud gritando, puedes observar como un enorme monstruo se acerca a ellos.<br>¿Que decides hacer?</center></html>");
    	opcion1.setText("Pasar de largo.");
    	opcion2.setText("Atacar al monstruo.");
    	opcion3.setText("Aprovechar el momento de confusion y robar a los aldeanos.");
  
        switch(opcion) {
	        case 1:
	        	eventoTexto.setText("<html><center>Sigues tu camino hasta que los gritos dejan de escucharse.</center></html>");
	        	break;
	        case 2:
	        	eventoTexto.setText("<html><center>Te acercas rapidamente y comienza tu batalla.</center></html>");
	        	//System.out.println("- Los aldeanos te felicitan por rescatarlos y te ofrecen una tarta con una pinta estupenda.");
	        	heroe.setSaludMaxima(heroe.getSaludMaxima()+20);
                heroe.setSalud(heroe.getSalud()+20);
	        	heroe.subirReputacion(20);
	        	break;
	        case 3:
	        	eventoTexto.setText("<html><center>Aprovechas la confusion de la multitud y saqueas todo lo que puedes.<br>"
	        			+ "Obtienes 1000 monedas de oro.</center></html>");
	        	heroe.setDinero(heroe.getDinero()+1000);  
                heroe.subirReputacion(-20);
	        	break;  	
        }  
    }
    
    /**
    * Funcion que simila un evento en el cual mediante opciones de dialogo podemos aumentar o disminuir reputacion, conseguir objetos o dinero, etc.
    * @param heroe Indica el personaje que modifica sus parametros generales dependiendo de como se resuelva la situacion.
    * @param enemigo Indica el enemigo que luchara contra el heroe.
    */   
    public void criasPoring(Heroe heroe, Enemigo enemigo) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("- Encuentras una madriguera de crias Poring. Un pequeño poring te mira con entusiasmo.");  
        
        System.out.println("- ¿Que decides hacer?"
            +"\n\t1 - Pasar de largo."
            +"\n\t2 - Te paras y lo acaricias."
            +"\n\t3 - Atacarlo.");
        opcion=Integer.parseInt(sc.nextLine());
        switch(opcion){
            case 1:
                System.out.println("- Sigues tu camino dejando atras la madriguera.\n");
                System.out.println("*** Pulse cualquier tecla para continuar ***");
                sc.nextLine();
                break;
            case 2:
                System.out.println("- El pequeño poring empieza a darte mimitos y notas una gran calidez en tu corazon.");
                heroe.setMagia(heroe.getMagia()+1);
                heroe.subirReputacion(10);
                System.out.println("- El atributo magia del heroe aumenta. || La reputacion del heroe aumenta.\n");
                System.out.println("*** Pulse cualquier tecla para continuar ***");
                sc.nextLine();
                break;
            case 3:
                System.out.println("- Golpeas al pequeño poring.");
                //Combate.batalla(heroe, enemigo);
                heroe.setDinero(heroe.getDinero()+1500);  
                System.out.println("- Encuentras en la madriguera un monton de monedas de oro.");
                System.out.println("- Obtienes 1500 monedas de oro || La reputacion del heroe baja.\n");
                System.out.println("*** Pulse cualquier tecla para continuar ***");
                sc.nextLine();
                break;
        }  
    }
}
