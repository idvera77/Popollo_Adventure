/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popollo_adventures;


import general.Combate;
import classes.Enemigo;
import classes.Habilidad;
import classes.Heroe;
import classes.Npc;
import classes.Objeto;
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
        
        //Habilidades
        Habilidad golpeFuerte = new Habilidad("Golpe Fuerte","Empleas todas tus fuerzas.",10,6,6,Habilidad.tipoHechizo.OFENSIVO);
        Habilidad remolino = new Habilidad("Torbellino","Da un poco de mareo.",15,5,5,Habilidad.tipoHechizo.OFENSIVO);
        Habilidad helada = new Habilidad("Helada","Frio invernal.",20,4,4,Habilidad.tipoHechizo.OFENSIVO);
        Habilidad bolaDeFuego = new Habilidad("Bola de Fuego","Envuelve al enemigo en llamas.",25,3,3,Habilidad.tipoHechizo.OFENSIVO);
        Habilidad curacionL = new Habilidad("Curar Heridadas Leves","Sana las heridas superficiales.",15,3,3,Habilidad.tipoHechizo.SANACION);
        Habilidad curacionG = new Habilidad("Curar Heridas Graves","Sana cualquier tipo de heridas.", 40, 1,1,Habilidad.tipoHechizo.SANACION);
        
        ArrayList<Habilidad> habilidadesHeroe = new ArrayList();
        habilidadesHeroe.add(golpeFuerte);
        habilidadesHeroe.add(remolino);
        habilidadesHeroe.add(curacionL);
        
        ArrayList<Habilidad> habilidadesCambio = new ArrayList();
        habilidadesCambio.add(helada);
        habilidadesCambio.add(bolaDeFuego);
        habilidadesCambio.add(curacionG);

        //Ataques Enemigo
        Habilidad Cabezazo = new Habilidad("Cabezazo", "Fuerte embestida con la cabeza.", 15, 3, 5,Habilidad.tipoHechizo.OFENSIVO);
        Habilidad Morder = new Habilidad("Morder", "Bocado fuerte.", 30, 1, 2,Habilidad.tipoHechizo.OFENSIVO);

        ArrayList<Habilidad> golpesSalvajesE = new ArrayList();
        golpesSalvajesE.add(Cabezazo);
        golpesSalvajesE.add(Morder);

        Habilidad Llamarada = new Habilidad("Llamarada", "Envuelve al objetivo en llamas", 5, 3, 5,Habilidad.tipoHechizo.OFENSIVO);
        Habilidad Acido = new Habilidad("Acido", "Puede derretir armaduras.", 10, 1, 2,Habilidad.tipoHechizo.OFENSIVO);

        ArrayList<Habilidad> golpesMagicosE = new ArrayList();
        golpesMagicosE.add(Llamarada);
        golpesMagicosE.add(Acido);

        //Objetos
        Objeto bombaP = new Objeto("Bomba Pequeña",30,3,"Pequeño artefacto explosivo, inflige 30 puntos de daño.",Objeto.tipoObjeto.ATAQUE, 50);
        Objeto bombaG = new Objeto("Bomba Grande",70,1,"Gran artefacto explosivo, inflige 70 puntos de daño.",Objeto.tipoObjeto.ATAQUE, 150);
        Objeto pocion = new Objeto("Pocion",50,5,"Bebida que restaura 50 puntos de salud.",Objeto.tipoObjeto.CURACION, 75);

        ArrayList<Objeto> objetosArray = new ArrayList();
        objetosArray.add(bombaP);
        objetosArray.add(bombaG);
        objetosArray.add(pocion);
        
        //Heroe
        Heroe popollo = new Heroe("Popollo", "Un adorable Popollito comilon", 100, 100, 20, 5, 20, 10, habilidadesHeroe, objetosArray, 500, 20);

        //Enemigos
        Enemigo poring = new Enemigo("Poring", "Una gelatina rosa monisima", 60, 60, 20, 5, 10, 10, golpesSalvajesE, 100);
        Enemigo golem = new Enemigo("Golem", "Una mole andante", 120, 120, 20, 10, 10, 15, golpesSalvajesE, 500);
        Enemigo nigromante = new Enemigo ("Nigromante", "No tiene buen aspecto", 80, 80, 15, 5, 20, 10, golpesMagicosE, 1000);
        
        //Npcs
        Npc narcyl = new Npc ("Narcyl", "Sacerdotisa novata.",Npc.tipoMoral.LEGAL);
        Npc tomberi = new Npc("Tomberi", "Demasiado gruñon.", Npc.tipoMoral.NEUTRAL);
        Npc mystra = new Npc("Mystra", "Hechicera demente.", Npc.tipoMoral.CAOTICO);     

        int opcion;
        String menuInicio="Por favor seleccione una opcion:"
            +"\n\t0 - Salir del juego."
            +"\n\t1 - Comenzar partida."
            +"\n\t2 - Ver galeria."
            +"\n\t3 - Combate de prueba."
            +"\n\t4 - Punto de descanso."
            +"\n\t5 - Tienda."
            +"\n\t6 - Informacion general del heroe."
            +"\n\t7 - Eventos.";
        
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
                case 7:
                    Npc.afinidadNpcs(narcyl, popollo);
                    Npc.afinidadNpcs(tomberi, popollo);
                    Npc.afinidadNpcs(mystra, popollo);
                    break;     
                default:
                    System.out.println("- Opcion Incorrecta. Parece que no tienes muchas ganas de jugar Y_Y\n");
                    break;
            }
        }while(opcion!=0);
    }
}
