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
     * @param args the command line arguments0
     */
    public static void main(String[] args) {
        try {
            //Inicio.
            Scanner sc = new Scanner (System.in);

            //Conectando a base de datos
            Connection connection=null;
            try {
                connection=DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/popollo_adventure"
                        ,"root","admin");

                System.out.println("Conexion a base de datos iniciada.\n");
            } catch (SQLException ex) {
                System.err.println("La conexion a la base de datos ha fallado");
                ex.printStackTrace();
            }

            //Importando datos
            Statement stm=connection.createStatement();
            ResultSet rs;

            //Creando el heroe
            //Habilidades
            rs=stm.executeQuery("SELECT * FROM habilidad WHERE Heroe_nombre= 'Popollo' ORDER BY ID ASC");
            ArrayList<Habilidad> habilidadesHeroe=new ArrayList();
            while(rs.next()){
                habilidadesHeroe.add(new Habilidad(rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("especial"),
                    rs.getInt("usosMaximos"),rs.getInt("usosRestantes"), rs.getString("tipo")));
            }

            //Objetos
            rs=stm.executeQuery("SELECT * FROM objeto WHERE Heroe_nombre= 'Popollo' ORDER BY ID ASC");
            ArrayList<Objeto> objetosHeroe=new ArrayList<>();
            while(rs.next()){
                objetosHeroe.add(new Objeto(rs.getString("nombre"),
                    rs.getString("descripcion"), rs.getInt("poder"), rs.getInt("cantidad"),
                    rs.getString("tipo"), rs.getInt("precio")));
            }

            //Estadisticas
            rs=stm.executeQuery("SELECT * FROM Heroe");
            rs.next();
                String nombre=rs.getString("nombre");
                String descripcion=rs.getString("descripcion");
                int saludMax=rs.getInt("saludMaxima");
                int salud=rs.getInt("salud");
                int fuerza=rs.getInt("fuerza");
                int magia=rs.getInt("magia");
                int agilidad=rs.getInt("agilidad");
                int defensa=rs.getInt("defensa");
                int dinero=rs.getInt("dinero");
                int reputacion=rs.getInt("reputacion");
                int experiencia=rs.getInt("experiencia");
                int nivel=rs.getInt("nivel");

            //Constructor del Heroe
            Heroe popollo = new Heroe(nombre, descripcion, saludMax, salud, fuerza, magia, agilidad,
                defensa, habilidadesHeroe, objetosHeroe, dinero, reputacion, experiencia, nivel);

            //Creando enemigos
            //Habilidades
            rs=stm.executeQuery("SELECT * FROM habilidad_enemigo WHERE Enemigo_nombre= 'Poring' ORDER BY ID ASC");
            ArrayList<Habilidad> habilidadesPoring=new ArrayList();
            while (rs.next()) {
                habilidadesPoring.add(new Habilidad(rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("especial"),
                        rs.getInt("usosMaximos"), rs.getInt("usosRestantes"), rs.getString("tipo")));
            }

            rs=stm.executeQuery("SELECT * FROM habilidad_enemigo WHERE Enemigo_nombre= 'Nigromante' ORDER BY ID ASC");
            ArrayList<Habilidad> habilidadesNigromante=new ArrayList();
            while (rs.next()) {
                habilidadesNigromante.add(new Habilidad(rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("especial"),
                        rs.getInt("usosMaximos"), rs.getInt("usosRestantes"), rs.getString("tipo")));
            }

            rs=stm.executeQuery("SELECT * FROM habilidad_enemigo WHERE Enemigo_nombre= 'Golem' ORDER BY ID ASC");
            ArrayList<Habilidad> habilidadesGolem=new ArrayList();
            while (rs.next()) {
                habilidadesGolem.add(new Habilidad(rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("especial"),
                        rs.getInt("usosMaximos"), rs.getInt("usosRestantes"), rs.getString("tipo")));
            }

            rs=stm.executeQuery("SELECT * FROM habilidad_enemigo WHERE Enemigo_nombre= 'Goblin' ORDER BY ID ASC");
            ArrayList<Habilidad> habilidadesGoblin=new ArrayList();
            while (rs.next()) {
                habilidadesGoblin.add(new Habilidad(rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("especial"),
                        rs.getInt("usosMaximos"), rs.getInt("usosRestantes"), rs.getString("tipo")));
            }

            rs=stm.executeQuery("SELECT * FROM habilidad_enemigo WHERE Enemigo_nombre= 'Pulpoi' ORDER BY ID ASC");
            ArrayList<Habilidad> habilidadesPulpoi=new ArrayList();
            while (rs.next()) {
                habilidadesPulpoi.add(new Habilidad(rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("especial"),
                        rs.getInt("usosMaximos"), rs.getInt("usosRestantes"), rs.getString("tipo")));
            }

            //Estadisticas y constructor.
            //Poring
            rs=stm.executeQuery("SELECT * FROM enemigo WHERE nombre= 'Poring'");
            rs.next();
                nombre=rs.getString("nombre");
                descripcion=rs.getString("descripcion");
                saludMax=rs.getInt("saludMaxima");
                salud=rs.getInt("salud");
                fuerza=rs.getInt("fuerza");
                magia=rs.getInt("magia");
                agilidad=rs.getInt("agilidad");
                defensa=rs.getInt("defensa");
                dinero=rs.getInt("dinero");
                experiencia=rs.getInt("experiencia");


            Enemigo poring = new Enemigo(nombre, descripcion, saludMax, salud,
                    fuerza, magia, agilidad, defensa, habilidadesPoring, dinero, experiencia);

            //Nigromante
            rs=stm.executeQuery("SELECT * FROM enemigo WHERE nombre= 'Nigromante'");
            rs.next();
                nombre=rs.getString("nombre");
                descripcion=rs.getString("descripcion");
                saludMax=rs.getInt("saludMaxima");
                salud=rs.getInt("salud");
                fuerza=rs.getInt("fuerza");
                magia=rs.getInt("magia");
                agilidad=rs.getInt("agilidad");
                defensa=rs.getInt("defensa");
                dinero=rs.getInt("dinero");
                experiencia=rs.getInt("experiencia");


            Enemigo nigromante = new Enemigo(nombre, descripcion, saludMax, salud,
                    fuerza, magia, agilidad, defensa, habilidadesNigromante, dinero, experiencia);

            //Golem
            rs=stm.executeQuery("SELECT * FROM enemigo WHERE nombre= 'Golem'");
            rs.next();
                nombre=rs.getString("nombre");
                descripcion=rs.getString("descripcion");
                saludMax=rs.getInt("saludMaxima");
                salud=rs.getInt("salud");
                fuerza=rs.getInt("fuerza");
                magia=rs.getInt("magia");
                agilidad=rs.getInt("agilidad");
                defensa=rs.getInt("defensa");
                dinero=rs.getInt("dinero");
                experiencia=rs.getInt("experiencia");


            Enemigo golem = new Enemigo(nombre, descripcion, saludMax, salud,
                    fuerza, magia, agilidad, defensa, habilidadesGolem, dinero, experiencia);

            //Goblin
            rs=stm.executeQuery("SELECT * FROM enemigo WHERE nombre= 'Goblin'");
            rs.next();
                nombre=rs.getString("nombre");
                descripcion=rs.getString("descripcion");
                saludMax=rs.getInt("saludMaxima");
                salud=rs.getInt("salud");
                fuerza=rs.getInt("fuerza");
                magia=rs.getInt("magia");
                agilidad=rs.getInt("agilidad");
                defensa=rs.getInt("defensa");
                dinero=rs.getInt("dinero");
                experiencia=rs.getInt("experiencia");


            Enemigo goblin = new Enemigo(nombre, descripcion, saludMax, salud,
                    fuerza, magia, agilidad, defensa, habilidadesGoblin, dinero, experiencia);

            //Pulpoi - Jefe Final.
            rs=stm.executeQuery("SELECT * FROM enemigo WHERE nombre= 'Pulpoi'");
            rs.next();
                nombre=rs.getString("nombre");
                descripcion=rs.getString("descripcion");
                saludMax=rs.getInt("saludMaxima");
                salud=rs.getInt("salud");
                fuerza=rs.getInt("fuerza");
                magia=rs.getInt("magia");
                agilidad=rs.getInt("agilidad");
                defensa=rs.getInt("defensa");
                dinero=rs.getInt("dinero");
                experiencia=rs.getInt("experiencia");


            Enemigo pulpoi = new Enemigo(nombre, descripcion, saludMax, salud,
                    fuerza, magia, agilidad, defensa, habilidadesPulpoi, dinero, experiencia);

            //Npcs Constructor
             rs=stm.executeQuery("SELECT * FROM npc WHERE nombre= 'Narcyl'");
            rs.next();
                nombre=rs.getString("nombre");
                descripcion=rs.getString("descripcion");
                String moral=rs.getString("moral");

            Npc narcyl = new Npc (nombre, descripcion, moral);

            rs=stm.executeQuery("SELECT * FROM npc WHERE nombre= 'Tomberi'");
            rs.next();
                nombre=rs.getString("nombre");
                descripcion=rs.getString("descripcion");
                moral=rs.getString("moral");

            Npc tomberi = new Npc (nombre, descripcion, moral);

            rs=stm.executeQuery("SELECT * FROM npc WHERE nombre= 'Mystra'");
            rs.next();
                nombre=rs.getString("nombre");
                descripcion=rs.getString("descripcion");
                moral=rs.getString("moral");

            Npc mystra = new Npc (nombre, descripcion, moral);

            /**
             * Npc narcyl = new Npc ("Narcyl", "Sacerdotisa novata.", "legal");
             * Npc tomberi = new Npc("Tomberi", "Demasiado gruñon.", "neutral");
             * Npc mystra = new Npc("Mystra", "Hechicera demente.", "caotico");
             */


            //Fin de importar los registros.



            //Abre ventana
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
                            stm.close();
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
                ex.printStackTrace();
        }
    }
}
