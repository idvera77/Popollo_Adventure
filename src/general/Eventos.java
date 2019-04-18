/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import clases.*;
import java.util.Scanner;
/**
 *
 * @author Mystra77
 */
public class Eventos {
    
    public static void vagabundo(Heroe heroe){
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("- Encuentras un hombre tirado en los caminos.");  
        
        System.out.println("- ¿Que decides hacer?"
            +"\n\t1 - Pasar de largo."
            +"\n\t2 - Ayudarle."
            +"\n\t3 - Robar sus pocas pertenencias.");
        opcion=Integer.parseInt(sc.nextLine());
        switch(opcion){
            case 1:
                System.out.println("- El hombre te observa tristemente mientras te alejas.\n");
                System.out.println("*** Pulse cualquier tecla para continuar ***");
                sc.nextLine();
                break;
            case 2:
                System.out.println("- Te acercas al hombre y le ayudas a levantarse, te comenta que hace dias que no ha podido comer.\n"
                        + "- Le ofreces un poco de tu comida y hablais amistosamente durante un rato.");
                heroe.subirReputacion(heroe, 10);
                System.out.println("- La reputacion del heroe aumenta.\n");
                System.out.println("*** Pulse cualquier tecla para continuar ***");
                sc.nextLine();
                break;
            case 3:
                System.out.println("- Buscas en los bolsillos mientras intenta defenderse aunque no tiene fuerzas para ello.");
                heroe.dinero += 100;
                heroe.subirReputacion(heroe, -10);
                System.out.println("- Obtienes 100 monedas de oro. || La reputacion del heroe baja.\n");
                System.out.println("*** Pulse cualquier tecla para continuar ***");
                sc.nextLine();
                break;
            default:
                System.out.println("- Opcion incorrecta.\n");
                vagabundo(heroe);
                break;
        }  
    }
    
    public static void rescateAldeanos(Heroe heroe, Enemigo enemigo){
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("- Escuchas a lo lejos el sonido de una multitud gritando, puedes observar como un enorme monstruo se acerca a ellos.");  
        
        System.out.println("- ¿Que decides hacer?"
            +"\n\t1 - Pasar de largo."
            +"\n\t2 - Atacar al monstruo."
            +"\n\t3 - Aprovechar el momento de confusion y robar a los aldeanos.");
        opcion=Integer.parseInt(sc.nextLine());
        switch(opcion){
            case 1:
                System.out.println("- Sigues tu camino hasta que los gritos dejan de escucharse.\n");
                System.out.println("*** Pulse cualquier tecla para continuar ***");
                sc.nextLine();
                break;
            case 2:
                System.out.println("- Te acercas rapidamente y comienza tu batalla.");
                Combate.Batalla(heroe, enemigo);
                System.out.println("- Los aldeanos te felicitan por rescatarlos y te ofrecen una tarta con una pinta estupenda.");
                heroe.saludMaxima += 20;
                heroe.salud += 20;
                heroe.subirReputacion(heroe, 20);
                System.out.println("- La salud maxima del heroe aumenta. || La reputacion del heroe aumenta.\n");
                System.out.println("*** Pulse cualquier tecla para continuar ***");
                sc.nextLine();
                break;
            case 3:
                System.out.println("- Aprovechas la confusion de la multitud y saqueas todo lo que puedes.");
                heroe.dinero += 1000;
                heroe.subirReputacion(heroe, -20);
                System.out.println("- Obtienes 1000 monedas de oro || La reputacion del heroe baja.\n");
                System.out.println("*** Pulse cualquier tecla para continuar ***");
                sc.nextLine();
                break;
            default:
                System.out.println("- Opcion incorrecta.\n");
                rescateAldeanos(heroe, enemigo);
                break;
        }  
    }
    
    public static void criasPoring(Heroe heroe, Enemigo enemigo) {
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
                heroe.subirReputacion(heroe, 10);
                System.out.println("- El atributo magia del heroe aumenta. || La reputacion del heroe aumenta.\n");
                System.out.println("*** Pulse cualquier tecla para continuar ***");
                sc.nextLine();
                break;
            case 3:
                System.out.println("- Golpeas al pequeño poring.");
                Combate.Batalla(heroe, enemigo);
                heroe.dinero += 1500;
                System.out.println("- Encuentras en la madriguera un monton de monedas de oro.");
                System.out.println("- Obtienes 1500 monedas de oro || La reputacion del heroe baja.\n");
                System.out.println("*** Pulse cualquier tecla para continuar ***");
                sc.nextLine();
                break;
            default:
                System.out.println("- Opcion incorrecta.\n");
                rescateAldeanos(heroe, enemigo);
                break;
        }  
    }
}
