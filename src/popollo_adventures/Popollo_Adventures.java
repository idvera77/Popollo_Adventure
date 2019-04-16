/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popollo_adventures;


import general.Combate;
import classes.Enemigos;
import classes.Habilidades;
import classes.Heroes;
import classes.Objetos;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Mystra77
 */
public class Popollo_Adventures {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Inicio.
        Scanner sc = new Scanner (System.in);
        
        //Declaracion de variables
        //Habilidades
        Habilidades golpeFuerte = new Habilidades("Golpe Fuerte","Empleas todas tus fuerzas.",10,6,6,Habilidades.tipoHechizo.OFENSIVO);
        Habilidades remolino = new Habilidades("Torbellino","Da un poco de mareo.",15,5,5,Habilidades.tipoHechizo.OFENSIVO);
        Habilidades helada = new Habilidades("Helada","Frio invernal.",20,4,4,Habilidades.tipoHechizo.OFENSIVO);
        Habilidades bolaDeFuego = new Habilidades("Bola de Fuego","Envuelve al enemigo en llamas.",25,3,3,Habilidades.tipoHechizo.OFENSIVO);
        Habilidades curacionL = new Habilidades("Curar Heridadas Leves","Sana las heridas superficiales.",15,3,3,Habilidades.tipoHechizo.SANACION);
        Habilidades curacionG = new Habilidades("Curar Heridas Graves","Sana cualquier tipo de heridas.", 40, 1,1,Habilidades.tipoHechizo.SANACION);
        
        ArrayList<Habilidades> habilidadesHeroe = new ArrayList();
        habilidadesHeroe.add(golpeFuerte);
        habilidadesHeroe.add(remolino);
        habilidadesHeroe.add(curacionL);
        
        ArrayList<Habilidades> habilidadesCambio = new ArrayList();
        habilidadesCambio.add(helada);
        habilidadesCambio.add(bolaDeFuego);
        habilidadesCambio.add(curacionG);

        //Ataques Enemigos
        Habilidades Cabezazo = new Habilidades("Cabezazo", "Fuerte embestida con la cabeza.", 15, 3, 5,Habilidades.tipoHechizo.OFENSIVO);
        Habilidades Morder = new Habilidades("Morder", "Bocado fuerte.", 30, 1, 2,Habilidades.tipoHechizo.OFENSIVO);

        ArrayList<Habilidades> golpesSalvajesE = new ArrayList();
        golpesSalvajesE.add(Cabezazo);
        golpesSalvajesE.add(Morder);

        Habilidades Llamarada = new Habilidades("Llamarada", "Envuelve al objetivo en llamas", 5, 3, 5,Habilidades.tipoHechizo.OFENSIVO);
        Habilidades Acido = new Habilidades("Acido", "Puede derretir armaduras.", 10, 1, 2,Habilidades.tipoHechizo.OFENSIVO);

        ArrayList<Habilidades> golpesMagicosE = new ArrayList();
        golpesMagicosE.add(Llamarada);
        golpesMagicosE.add(Acido);

        //Objetos
        Objetos bombaP = new Objetos("Bomba Pequeña",30,3,"Pequeño artefacto explosivo, inflige 30 puntos de daño.",Objetos.tipoObjeto.ATAQUE, 50);
        Objetos bombaG = new Objetos("Bomba Grande",70,1,"Gran artefacto explosivo, inflige 70 puntos de daño.",Objetos.tipoObjeto.ATAQUE, 150);
        Objetos pocion = new Objetos("Pocion",50,5,"Bebida que restaura 50 puntos de salud.",Objetos.tipoObjeto.CURACION, 75);

        ArrayList<Objetos> objetosArray = new ArrayList();
        objetosArray.add(bombaP);
        objetosArray.add(bombaG);
        objetosArray.add(pocion);

        Heroes popollo = new Heroes("Popollo", "Un adorable Popollito comilon", 100, 100, 20, 5, 20, 10, habilidadesHeroe, objetosArray, 500);

        //Enemigos
        Enemigos poring = new Enemigos("Poring", "Una gelatina rosa monisima", 60, 60, 20, 5, 10, 10, golpesSalvajesE, 100);
        Enemigos golem = new Enemigos("Golem", "Una mole andante", 120, 120, 20, 10, 10, 15, golpesSalvajesE, 500);
        Enemigos nigromante = new Enemigos ("Nigromante", "No tiene buen aspecto", 80, 80, 15, 5, 20, 10, golpesMagicosE, 1000);

        int opcion;
        String menuInicio="Por favor seleccione una opcion:"
            +"\n\t0 - Salir del juego."
            +"\n\t1 - Comenzar partida."
            +"\n\t2 - Ver galeria."
            +"\n\t3 - Combate de prueba."
            +"\n\t4 - Punto de descanso."
            +"\n\t5 - Tienda."
            +"\n\t6 - Informacion general del heroe.";
        
        do{        
            System.out.println(menuInicio);
            opcion=Integer.parseInt(sc.nextLine());

            switch(opcion){
                case 0:
                    System.out.println("Vuelve pronto ^_^");
                    break;
                case 1:      
                    break;
                case 2:             
                    break;
                case 3:
                    Combate.Batalla(popollo, nigromante);
                    break;
                case 4:
                    popollo.puntoDescanso(popollo);
                    break;
                case 5:
                    popollo.Tienda(popollo);
                    break;    
                case 6:
                    popollo.pantallaGeneralEstadisticas(popollo);
                    break;   
                default:
                    System.out.println("- Opcion Incorrecta. Parece que no tienes muchas ganas de jugar Y_Y\n");
                    break;
            }
        }while(opcion!=0);
    }
}
