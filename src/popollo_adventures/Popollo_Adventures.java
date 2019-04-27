/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popollo_adventures;

import clases.*;
import exceptions.InvalidTipoException;
import general.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    public static void main(String[] args){
        
        Scanner sc = new Scanner (System.in);
        Connection connection=null;
        int opcion;
              
        //Menus
        String menuInicio="\nPor favor seleccione una opcion:"
            +"\n\t0 - Salir del juego."
            +"\n\t1 - Nueva partida."
            +"\n\t2 - Cargar partida.";
        
        String menuPruebas="\nPor favor seleccione una opcion:"
            +"\n\t0 - Salir del juego."
            +"\n\t1 - Guardar partida."
            +"\n\t2 - Cargar partida."
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
            
        //Conectando a la base de datos
        try{
            do{
                System.out.print(menuInicio);
                opcion=Integer.parseInt(sc.nextLine());
                switch(opcion){
                    case 0:
                        System.out.println("Vuelve pronto ^_^");
                        System.exit(0);
                        break;
                    case 1:
                        connection=DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/popollo_adventure"
                                ,"root","admin");
                        
                        System.out.println("Partida iniciada sin problemas ^_^");
                        break;
                    case 2:
                        connection=DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/popollo_adventure_cargar"
                                ,"root","admin");
                        
                        System.out.println("Partida cargada sin problemas ^_^");
                        break;
                    default:
                        System.out.println("- Opcion incorrecta. Parece que no tienes muchas ganas de jugar Y_Y\n");
                        break;
                }                     
            }while(opcion!=0&&opcion!=1&&opcion!=2);
        
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
            String nombreHeroe=rs.getString("nombre");
            String descripcionHeroe=rs.getString("descripcion");
            int saludMaxHeroe=rs.getInt("saludMaxima");
            int saludHeroe=rs.getInt("salud");
            int fuerzaHeroe=rs.getInt("fuerza");
            int magiaHeroe=rs.getInt("magia");
            int agilidadHeroe=rs.getInt("agilidad");
            int defensaHeroe=rs.getInt("defensa");
            int dineroHeroe=rs.getInt("dinero");
            int reputacionHeroe=rs.getInt("reputacion");
            int experienciaHeroe=rs.getInt("experiencia");
            int nivelHeroe=rs.getInt("nivel");
                
            //Constructor del Heroe
            Heroe popollo = new Heroe(nombreHeroe, descripcionHeroe, saludMaxHeroe, saludHeroe, fuerzaHeroe, magiaHeroe, agilidadHeroe,
                defensaHeroe, habilidadesHeroe, objetosHeroe, dineroHeroe, reputacionHeroe, experienciaHeroe, nivelHeroe); 
            
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
            String nombreEnemigo=rs.getString("nombre");
            String descripcionEnemigo=rs.getString("descripcion");
            int saludMaxEnemigo=rs.getInt("saludMaxima");
            int saludEnemigo=rs.getInt("salud");
            int fuerzaEnemigo=rs.getInt("fuerza");
            int magiaEnemigo=rs.getInt("magia");
            int agilidadEnemigo=rs.getInt("agilidad");
            int defensaEnemigo=rs.getInt("defensa");
            int dineroEnemigo=rs.getInt("dinero");
            int experienciaEnemigo=rs.getInt("experiencia");


            Enemigo poring = new Enemigo(nombreEnemigo, descripcionEnemigo, saludMaxEnemigo, saludEnemigo,
                    fuerzaEnemigo, magiaEnemigo, agilidadEnemigo, defensaEnemigo, habilidadesPoring, 
                    dineroEnemigo, experienciaEnemigo);

            //Nigromante
            rs=stm.executeQuery("SELECT * FROM enemigo WHERE nombre= 'Nigromante'");
            rs.next();
            nombreEnemigo=rs.getString("nombre");
            descripcionEnemigo=rs.getString("descripcion");
            saludMaxEnemigo=rs.getInt("saludMaxima");
            saludEnemigo=rs.getInt("salud");
            fuerzaEnemigo=rs.getInt("fuerza");
            magiaEnemigo=rs.getInt("magia");
            agilidadEnemigo=rs.getInt("agilidad");
            defensaEnemigo=rs.getInt("defensa");
            dineroEnemigo=rs.getInt("dinero");
            experienciaEnemigo=rs.getInt("experiencia");


            Enemigo nigromante = new Enemigo(nombreEnemigo, descripcionEnemigo, saludMaxEnemigo, saludEnemigo,
                    fuerzaEnemigo, magiaEnemigo, agilidadEnemigo, defensaEnemigo, habilidadesNigromante, 
                    dineroEnemigo, experienciaEnemigo);

            //Golem
            rs=stm.executeQuery("SELECT * FROM enemigo WHERE nombre= 'Golem'");
            rs.next();
            nombreEnemigo=rs.getString("nombre");
            descripcionEnemigo=rs.getString("descripcion");
            saludMaxEnemigo=rs.getInt("saludMaxima");
            saludEnemigo=rs.getInt("salud");
            fuerzaEnemigo=rs.getInt("fuerza");
            magiaEnemigo=rs.getInt("magia");
            agilidadEnemigo=rs.getInt("agilidad");
            defensaEnemigo=rs.getInt("defensa");
            dineroEnemigo=rs.getInt("dinero");
            experienciaEnemigo=rs.getInt("experiencia");


            Enemigo golem = new Enemigo(nombreEnemigo, descripcionEnemigo, saludMaxEnemigo, saludEnemigo,
                    fuerzaEnemigo, magiaEnemigo, agilidadEnemigo, defensaEnemigo, habilidadesGolem, 
                    dineroEnemigo, experienciaEnemigo);

            //Goblin
            rs=stm.executeQuery("SELECT * FROM enemigo WHERE nombre= 'Goblin'");
            rs.next();
            nombreEnemigo=rs.getString("nombre");
            descripcionEnemigo=rs.getString("descripcion");
            saludMaxEnemigo=rs.getInt("saludMaxima");
            saludEnemigo=rs.getInt("salud");
            fuerzaEnemigo=rs.getInt("fuerza");
            magiaEnemigo=rs.getInt("magia");
            agilidadEnemigo=rs.getInt("agilidad");
            defensaEnemigo=rs.getInt("defensa");
            dineroEnemigo=rs.getInt("dinero");
            experienciaEnemigo=rs.getInt("experiencia");


            Enemigo goblin = new Enemigo(nombreEnemigo, descripcionEnemigo, saludMaxEnemigo, saludEnemigo,
                    fuerzaEnemigo, magiaEnemigo, agilidadEnemigo, defensaEnemigo, habilidadesGoblin, 
                    dineroEnemigo, experienciaEnemigo);

            //Pulpoi - Jefe Final.
            rs=stm.executeQuery("SELECT * FROM enemigo WHERE nombre= 'Pulpoi'");
            rs.next();
            nombreEnemigo=rs.getString("nombre");
            descripcionEnemigo=rs.getString("descripcion");
            saludMaxEnemigo=rs.getInt("saludMaxima");
            saludEnemigo=rs.getInt("salud");
            fuerzaEnemigo=rs.getInt("fuerza");
            magiaEnemigo=rs.getInt("magia");
            agilidadEnemigo=rs.getInt("agilidad");
            defensaEnemigo=rs.getInt("defensa");
            dineroEnemigo=rs.getInt("dinero");
            experienciaEnemigo=rs.getInt("experiencia");


            Enemigo pulpoi = new Enemigo(nombreEnemigo, descripcionEnemigo, saludMaxEnemigo, saludEnemigo,
                    fuerzaEnemigo, magiaEnemigo, agilidadEnemigo, defensaEnemigo, habilidadesPulpoi, 
                    dineroEnemigo, experienciaEnemigo);

            //Npcs Constructor
            rs=stm.executeQuery("SELECT * FROM npc WHERE nombre= 'Narcyl'");
            rs.next();
            String nombreNpc=rs.getString("nombre");
            String descripcionNpc=rs.getString("descripcion");
            String moralNpc=rs.getString("moral");

            Npc narcyl = new Npc (nombreNpc, descripcionNpc, moralNpc);

            rs=stm.executeQuery("SELECT * FROM npc WHERE nombre= 'Tomberi'");
            rs.next();
            nombreNpc=rs.getString("nombre");
            descripcionNpc=rs.getString("descripcion");
            moralNpc=rs.getString("moral");

            Npc tomberi = new Npc (nombreNpc, descripcionNpc, moralNpc);

            rs=stm.executeQuery("SELECT * FROM npc WHERE nombre= 'Mystra'");
            rs.next();
            nombreNpc=rs.getString("nombre");
            descripcionNpc=rs.getString("descripcion");
            moralNpc=rs.getString("moral");

            Npc mystra = new Npc (nombreNpc, descripcionNpc, moralNpc);
                
            //Fin de importar los registros.            
           
                        
            //Menu de pruebas, incluye toda las opciones para ver en un vistazo rapido que todo funciona.
                do{
                    System.out.println(menuPruebas);
                    opcion=Integer.parseInt(sc.nextLine());
                    
                    switch(opcion){
                        case 0:
                            System.out.println("Vuelve pronto ^_^");
                            stm.close();
                            connection.close();
                            System.exit(0);
                            break;
                        case 1:
                            connection=DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/popollo_adventure_cargar"
                                ,"root","admin");
                            
                            //Guardando parametros del heroe
                            PreparedStatement smt1 = connection.prepareStatement("INSERT INTO heroe "
                                + "(nombre, descripcion, saludMaxima, salud, fuerza, magia, agilidad, defensa, dinero, reputacion, experiencia, nivel) "
                                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                                smt1.setString(1, popollo.getNombre());
                                smt1.setString(2, popollo.getDescripcion());
                                smt1.setInt(3, popollo.getSaludMaxima());
                                smt1.setInt(4, popollo.getSalud());
                                smt1.setInt(5, popollo.getFuerza());
                                smt1.setInt(6, popollo.getMagia());
                                smt1.setInt(7, popollo.getAgilidad());
                                smt1.setInt(8, popollo.getDefensa());
                                smt1.setInt(9, popollo.getDinero());
                                smt1.setInt(10, popollo.getReputacion());
                                smt1.setInt(11, popollo.getExperiencia());
                                smt1.setInt(12, popollo.getNivel());
                                smt1.executeUpdate();      
                            System.out.println("Partida guardada sin problemas ^^");    
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
                ex.getStackTrace();
                System.err.println("\n!!!Error al conectarse con la base de datos!!!");
            } catch (InvalidTipoException | InvalidMoralException ex) {
                ex.printStackTrace();
                System.err.println(ex.getMessage());
            }      
    }
}    

             
              