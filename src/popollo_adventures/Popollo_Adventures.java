/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popollo_adventures;

import clases.*;
import general.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Mystra77
 */
public class Popollo_Adventures {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Inicio.
            Scanner sc = new Scanner (System.in);
            
            //Conectando a base de datos
            Connection connection=null;
            try {
                connection=DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/popollo"
                        ,"root","admin");
                
                System.out.println("Conexion a base de datos iniciada.\n");
            } catch (SQLException ex) {
                System.err.println("La conexion a la base de datos ha fallado");
            }
            
            //Importando datos
            
            
            Statement stm=connection.createStatement();
            
            ResultSet rs=stm.executeQuery("select * from habilidad");
            rs.next();
            
            Habilidad Habilidad1 = new Habilidad(rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getInt("especial"),
                    rs.getInt("usosMaximos"),
                    rs.getInt("usosRestantes"),
                    rs.getString("tipo"));
                    //rs.getString("Heroe_nombre")    
            
            //Abre ventana
            Ventana Ventana = new Ventana();
            
            //Habilidades
            Habilidad golpeFuerte = new Habilidad("Golpe Fuerte","Empleas todas tus fuerzas.",10,6,6,"ofensivo");
            Habilidad remolino = new Habilidad("Torbellino","Da un poco de mareo.",15,5,5,"ofensivo");
            Habilidad curacionL = new Habilidad("Curar Heridadas Leves","Sana las heridas superficiales.",15,3,3,"sanacion");
            
            ArrayList<Habilidad> habilidadesHeroe = new ArrayList();
            habilidadesHeroe.add(golpeFuerte);
            habilidadesHeroe.add(remolino);
            habilidadesHeroe.add(curacionL);
            
            //Ataques Enemigo
            Habilidad Cabezazo = new Habilidad("Cabezazo", "Fuerte embestida con la cabeza.", 15, 3, 5,"ofensivo");
            Habilidad Morder = new Habilidad("Morder", "Bocado fuerte.", 30, 1, 2,"ofensivo");
            
            ArrayList<Habilidad> golpesSalvajesE = new ArrayList();
            golpesSalvajesE.add(Cabezazo);
            golpesSalvajesE.add(Morder);
            
            Habilidad Llamarada = new Habilidad("Llamarada", "Envuelve al objetivo en llamas", 5, 3, 5,"ofensivo");
            Habilidad Acido = new Habilidad("Acido", "Puede derretir armaduras.", 10, 1, 2,"ofensivo");
            
            ArrayList<Habilidad> golpesMagicosE = new ArrayList();
            golpesMagicosE.add(Llamarada);
            golpesMagicosE.add(Acido);
            
            //Objetos
            Objeto bombaP = new Objeto("Bomba Pequeña",30,3,"Pequeño artefacto explosivo, inflige 30 puntos de daño.", "ataque", 50);
            Objeto bombaG = new Objeto("Bomba Grande",70,1,"Gran artefacto explosivo, inflige 70 puntos de daño.", "ataque", 150);
            Objeto pocion = new Objeto("Pocion",50,5,"Bebida que restaura 50 puntos de salud.", "curacion", 75);
            
            ArrayList<Objeto> objetosArray = new ArrayList();
            objetosArray.add(bombaP);
            objetosArray.add(bombaG);
            objetosArray.add(pocion);
            
            //Heroe
            Heroe popollo = new Heroe("Popollo", "Un adorable Popollito comilon", 100, 100, 20, 5, 20, 10, habilidadesHeroe, objetosArray, 5000, 0);
            
            //Enemigos
            Enemigo poring = new Enemigo("Poring", "Una gelatina rosa monisima", 60, 60, 20, 5, 10, 10, golpesSalvajesE, 100);
            Enemigo golem = new Enemigo("Golem", "Una mole andante", 120, 120, 20, 10, 10, 15, golpesSalvajesE, 500);
            Enemigo nigromante = new Enemigo ("Nigromante", "No tiene buen aspecto", 80, 80, 15, 5, 20, 10, golpesMagicosE, 1000);
            
            //Npcs
            Npc narcyl = new Npc ("Narcyl", "Sacerdotisa novata.","legal");
            Npc tomberi = new Npc("Tomberi", "Demasiado gruñon.", "neutral");
            Npc mystra = new Npc("Mystra", "Hechicera demente.", "caotico");
            
            int opcion;
            
            String menuInicio="Por favor seleccione una opcion:"
                    +"\n\t0 - Salir del juego."
                    +"\n\t1 - Comenzar partida."
                    +"\n\t2 - Ver galeria."
                    +"\n\t3 - Combate de prueba."
                    +"\n\t4 - Punto de descanso."
                    +"\n\t5 - Tienda."
                    +"\n\t6 - Informacion general del heroe."
                    +"\n\t7 - Comprobar afinidad con los Npcs."
                    +"\n\t8 - Multiples eventos.";
            
            String menuEvento="Por favor seleccione una opcion:"
                    +"\n\t0 - Salir."
                    +"\n\t1 - Vagabundo."
                    +"\n\t2 - Defensa de aldeanos."
                    +"\n\t3 - Crias de porings.";
            
            //Menu de pruebas, incluye toda las opciones para ver en un vistazo rapido que todo funciona.
            do{
                System.out.println(menuInicio);
                opcion=Integer.parseInt(sc.nextLine());
                
                switch(opcion){
                    case 0:
                        System.out.println("Vuelve pronto ^_^");
                        try {
                            connection.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(Popollo_Adventures.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.exit(0);
                        break;
                    case 1:
                        //Nada por ahora
                        break;
                    case 2:
                        Ventana.setVisible(true);
                        break;
                    case 3:
                        Combate.batalla(popollo, nigromante);
                        break;
                    case 4:
                        popollo.puntoDescanso();
                        break;
                    case 5:
                        popollo.tienda();
                        break;
                    case 6:
                        popollo.pantallaGeneralEstadisticas();
                        break;
                    case 7:
                        Npc.afinidadNpcs(narcyl, popollo);
                        Npc.afinidadNpcs(tomberi, popollo);
                        Npc.afinidadNpcs(mystra, popollo);
                        break;
                    case 8:
                        System.out.println(menuEvento);
                        opcion=Integer.parseInt(sc.nextLine());
                        switch(opcion){
                            case 1:
                                Eventos.vagabundo(popollo);
                                break;
                            case 2:
                                Eventos.rescateAldeanos(popollo, nigromante);
                                break;
                            case 3:
                                Eventos.criasPoring(popollo, poring);
                                break;
                            default:
                                System.out.println("- Opcion incorrecta.\n");
                                break;
                        }
                        break;
                    default:
                        System.out.println("- Opcion incorrecta. Parece que no tienes muchas ganas de jugar Y_Y\n");
                        break;
                }
            }while(opcion!=0);
        } catch (SQLException ex) {
                    Logger.getLogger(Popollo_Adventures.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
