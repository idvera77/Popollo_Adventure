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
        Habilidades golpeFuerte = new Habilidades("Golpe Fuerte","Empleas todas tus fuerzas.",10,5,5);
        Habilidades remolino = new Habilidades("Torbellino","Da un poco de mareo.",15,3,3);

        ArrayList<Habilidades> habilidadesOfensivas= new ArrayList();
        habilidadesOfensivas.add(golpeFuerte);
        habilidadesOfensivas.add(remolino);

        Habilidades helada = new Habilidades("Helada","Frio invernal.",20,5,5);
        Habilidades bolaDeFuego = new Habilidades("Bola de Fuego","Envuelve al enemigo en llamas.",40,3,3);

        ArrayList<Habilidades> hechizosOfensivos= new ArrayList();
        hechizosOfensivos.add(helada);
        hechizosOfensivos.add(bolaDeFuego);

        Habilidades curacionL = new Habilidades("Curar Heridadas Leves","Sana las heridas superficiales.",10,3,3);
        Habilidades curacionG = new Habilidades("Curar Heridas Graves","Sana cualquier tipo de heridas.", 40, 1,1);

        ArrayList<Habilidades> hechizosCurativos = new ArrayList();
        hechizosCurativos.add(curacionL);
        hechizosCurativos.add(curacionG);

        //Ataques Enemigos
        Habilidades Cabezazo = new Habilidades("Cabezazo", "Fuerte embestida con la cabeza.", 15, 3, 5);
        Habilidades Morder = new Habilidades("Morder", "Bocado fuerte.", 30, 1, 2);

        ArrayList<Habilidades> golpesSalvajesE = new ArrayList();
        golpesSalvajesE.add(Cabezazo);
        golpesSalvajesE.add(Morder);

        Habilidades Llamarada = new Habilidades("Llamarada", "Envuelve al objetivo en llamas", 5, 3, 5);
        Habilidades Acido = new Habilidades("Acido", "Puede derretir armaduras.", 10, 1, 2);

        ArrayList<Habilidades> golpesMagicosE = new ArrayList();
        golpesMagicosE.add(Llamarada);
        golpesMagicosE.add(Acido);

        //Objetos
        Objetos bombaP = new Objetos("Bomba Pequeña",30,3,"Pequeño artefacto explosivo, inflige 15 puntos de daño.");
        Objetos bombaG = new Objetos("Bomba Grande",70,1,"Gran artefacto explosivo, inflige 50 puntos de daño.");
        Objetos pocion = new Objetos("Pocion",50,5,"Bebida que restaura 20 puntos de salud.");

        ArrayList<Objetos> objetosArray = new ArrayList();
        objetosArray.add(bombaP);
        objetosArray.add(bombaG);
        objetosArray.add(pocion);

        Heroes popollo = new Heroes("Popollo", "Un adorable Popollito comilon", 100, 100, 20, 5, 20, 10, habilidadesOfensivas, objetosArray);

        //Enemigos
        Enemigos poring = new Enemigos("Poring", "Una gelatina rosa monisima", 60, 60, 20, 5, 10, 10, golpesSalvajesE, 100);
        Enemigos golem = new Enemigos("Golem", "Una mole andante", 120, 120, 20, 10, 10, 15, golpesSalvajesE, 500);
        Enemigos nigromante = new Enemigos ("Nigromante", "No tiene buen aspecto", 80, 80, 15, 5, 20, 10, golpesMagicosE, 1000);

        ArrayList<Enemigos> combateFacil = new ArrayList();
        combateFacil.add(poring);
        combateFacil.add(poring);

        ArrayList<Enemigos> combateDificil = new ArrayList();
        combateDificil.add(poring);
        combateDificil.add(golem);
        combateDificil.add(nigromante);

        int opcion=0;

        String menuInicio="\nPor favor seleccione una opcion:"
            +"\n\t0 - Salir del juego."
            +"\n\t1 - Comenzar partida."
            +"\n\t2 - Ver galeria."
            +"\n\t3 - Combate de prueba."
            +"\n\t4 - Punto de descanso."
            +"\n\t5 - Tienda.";

        do{
            System.out.println(menuInicio);
            opcion=Integer.parseInt(sc.nextLine());
            int Monedas = 500;

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
                    Monedas += nigromante.getDropDinero();
                    System.out.println(Monedas);
                    break;
                case 4:
                    opcion=Integer.parseInt(sc.nextLine());
                        switch(opcion){
                            case 1:
                                System.out.println("Curar la vida y restablecer las habilidades.");
                                popollo.regenerarSaludHabilidades(popollo);
                                break;
                            case 2:
                                System.out.println("Cambiar las Habilidades");
                                for (int i = 0; i < popollo.getHabilidadesArray().size(); i++) {
                                   popollo.getHabilidadesArray().get(i).setUsosRestantes(popollo.getHabilidadesArray().get(i).getUsosMaximos());
                                }           
                                System.out.println("");
                                break;
                        }
                    break;
                case 5:
                    opcion=Integer.parseInt(sc.nextLine());
                        switch(opcion){
                            case 1:
                                
                                System.out.println("Punto de descanso.");
                                break;
                        }
                    break;    
                default:
                    System.out.println("Por favor selecciona una opcion correcta.");
            }
        }while(opcion!=0);
    }
}
