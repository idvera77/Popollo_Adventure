package interfaces;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import clases.Enemigo;
import clases.Habilidad;
import clases.Heroe;
import clases.Npc;
import clases.Objeto;
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
import componentes.Botones;
import componentes.PanelTexto;
import componentes.Paneles;
import exceptions.InvalidTipoException;
import exceptions.InvalidMoralException;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.TextArea;


public class Principal extends Paneles {
	private Ventana ventana;

	public Principal(Ventana v) {
		super();
		this.ventana=v;
		
		PanelTexto mostrarDinero = new PanelTexto();
		mostrarDinero.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		mostrarDinero.setBounds(160, 328, 98, 25);
		mostrarDinero.setText(" Oro: "+Integer.toString(ventana.heroe.getDinero()));
		add(mostrarDinero);
		
		PanelTexto cantidadBombaP = new PanelTexto();
		cantidadBombaP.setText("Bomba Pequeña: "+Integer.toString(ventana.heroe.getObjetosArray().get(0).getCantidad()));
		cantidadBombaP.setBounds(179, 371, 165, 25);
		add(cantidadBombaP);
		
		PanelTexto cantidadBombaG = new PanelTexto();
		cantidadBombaG.setText("Bomba Grande: "+Integer.toString(ventana.heroe.getObjetosArray().get(1).getCantidad()));
		cantidadBombaG.setBounds(179, 401, 165, 23);
		add(cantidadBombaG);
		
		PanelTexto cantidadPocion = new PanelTexto();
		cantidadPocion.setText("Pocion: "+Integer.toString(ventana.heroe.getObjetosArray().get(2).getCantidad()));
		cantidadPocion.setBounds(179, 431, 165, 23);
		add(cantidadPocion);

		PanelTexto habilidad1 = new PanelTexto();
		habilidad1.setText(ventana.heroe.getHabilidadesArray().get(0).getNombre()+": "+Integer.toString(ventana.heroe.getHabilidadesArray().get(0).getUsosRestantes())
			+"/"+Integer.toString(ventana.heroe.getHabilidadesArray().get(0).getUsosMaximos()));
		habilidad1.setBounds(344, 371, 175, 23);
		add(habilidad1);
		
		PanelTexto habilidad2 = new PanelTexto();
		habilidad2.setText(ventana.heroe.getHabilidadesArray().get(1).getNombre()+": "+Integer.toString(ventana.heroe.getHabilidadesArray().get(1).getUsosRestantes())
		+"/"+Integer.toString(ventana.heroe.getHabilidadesArray().get(1).getUsosMaximos()));
		habilidad2.setBounds(344, 401, 175, 23);
		add(habilidad2);
		
		PanelTexto habilidad3 = new PanelTexto();
		habilidad3.setText(ventana.heroe.getHabilidadesArray().get(2).getNombre()+": "+Integer.toString(ventana.heroe.getHabilidadesArray().get(2).getUsosRestantes())
		+"/"+Integer.toString(ventana.heroe.getHabilidadesArray().get(2).getUsosMaximos()));
		habilidad3.setBounds(344, 431, 175, 23);
		add(habilidad3);		
		
		PanelTexto saludActual = new PanelTexto();
		saludActual.setText("Salud: "+Integer.toString(ventana.heroe.getSalud())+"/"+Integer.toString(ventana.heroe.getSaludMaxima()));
		saludActual.setBounds(29, 341, 120, 23);
		add(saludActual);
		
		PanelTexto fuerzaActual = new PanelTexto();
		fuerzaActual.setText("Fuerza: "+Integer.toString(ventana.heroe.getFuerza()));
		fuerzaActual.setBounds(29, 371, 120, 23);
		add(fuerzaActual);
		
		PanelTexto magiaActual = new PanelTexto();
		magiaActual.setText("Magia: "+Integer.toString(ventana.heroe.getMagia()));
		magiaActual.setBounds(29, 401, 120, 23);
		add(magiaActual);
		
		PanelTexto defensaActual = new PanelTexto();
		defensaActual.setText("Defensa: "+Integer.toString(ventana.heroe.getDefensa()));
		defensaActual.setBounds(29, 431, 120, 23);
		add(defensaActual);
		
		PanelTexto agilidadActual = new PanelTexto();
		agilidadActual.setText("Agilidad: "+Integer.toString(ventana.heroe.getAgilidad()));
		agilidadActual.setBounds(29, 461, 120, 23);
		add(agilidadActual);
    		
		PanelTexto reputacionActual = new PanelTexto() ;
		reputacionActual.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		reputacionActual.setText(" Reputacion: "+Integer.toString(ventana.heroe.getReputacion()));
		reputacionActual.setBounds(255, 328, 130, 25);
		add(reputacionActual);
		
		PanelTexto experienciaActual = new PanelTexto();
		experienciaActual.setText(" Experiencia: ");
		experienciaActual.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		experienciaActual.setBounds(389, 328, 130, 25);
		add(experienciaActual);
		
        //Añadiendo botones
		
		Botones combatePrueba = new Botones("Combate Prueba");
		combatePrueba.setBounds(255, 186, 218, 23);
		add(combatePrueba);
		
		Botones eventoPrueba = new Botones("Evento Prueba");
		eventoPrueba.setBounds(255, 222, 218, 23);
		add(eventoPrueba);
		
		Botones pruebaAfinidad = new Botones("Afinidad");
		pruebaAfinidad.setBounds(255, 259, 218, 23);
		add(pruebaAfinidad);
        
		Botones botonGuardarPartida = new Botones("Guardar Partida");
		botonGuardarPartida.setBounds(759, 98, 165, 23);
		add(botonGuardarPartida);
		
		Botones botonTienda = new Botones("Tienda");
		botonTienda.setBounds(759, 132, 165, 23);
		add(botonTienda);
		
		Botones botonDescanso = new Botones("Punto de descanso");
		botonDescanso.setBounds(759, 166, 165, 23);
		add(botonDescanso);
		
		Botones botonSalir = new Botones("Salir");
		botonSalir.setBounds(709, 428, 215, 23);
		add(botonSalir);

		//Eventos de botones
		
		combatePrueba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargarPantallaLucha();
				general.Combate.batalla(ventana.heroe, ventana.enemigosArray.get(0));
			}
		});
		
		eventoPrueba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cargarPantallaTienda();
			}
		});	
		
		pruebaAfinidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cargarPantallaDescanso();
			}
		});	
		
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					System.exit(0);  
			}
		});
		
		botonTienda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cargarPantallaTienda();
			}
		});	
		
		botonDescanso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cargarPantallaDescanso();
			}
		});	
		
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					System.exit(0);  
			}
		});
		


		JLabel cuadro1 = new JLabel("");
		cuadro1.setHorizontalAlignment(SwingConstants.CENTER);
		cuadro1.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		cuadro1.setBackground(new Color(204, 204, 204));
		cuadro1.setText("<html>Nivel: "+Integer.toString(ventana.heroe.getNivel())
			+"<br/>Salud: "+Integer.toString(ventana.heroe.getSalud())+"/"+Integer.toString(ventana.heroe.getSaludMaxima())
			+"<br/>Fuerza: "+Integer.toString(ventana.heroe.getFuerza())
			+"<br/>Magia: "+Integer.toString(ventana.heroe.getMagia())
			+"<br/>Defensa: "+Integer.toString(ventana.heroe.getDefensa())
			+"<br/>Agilidad: "+Integer.toString(ventana.heroe.getAgilidad())	
			+"</html>");
		cuadro1.setOpaque(true);
		cuadro1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		cuadro1.setBounds(10, 159, 145, 147);
		add(cuadro1);
		
		JLabel cuadro2 = new JLabel("");
		cuadro2.setOpaque(true);
		cuadro2.setBackground(new Color(204, 204, 204));
		cuadro2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		cuadro2.setBounds(10, 328, 516, 171);
		add(cuadro2);	
		
		//Imagen de fondo
		JLabel imagenDescanso = new JLabel("");
		imagenDescanso.setBounds(0, 0, 1008, 536);
		imagenDescanso.setIcon(new ImageIcon("./imagenes/mapa.jpg"));
		add(imagenDescanso);	

           
	}
}
	

/**
 *         
		
        /**
         * Scanner sc = new Scanner (System.in);
         * int opcion;
      
        
        //Menus
        
        String menuPruebas="\nPor favor seleccione una opcion:"
            +"\n\t0 - Salir del juego."
            +"\n\t1 - Guardar partida."
            +"\n\t2 - Combate de prueba."
            +"\n\t3 - Punto de descanso."
            +"\n\t4 - Tienda."
            +"\n\t5 - Informacion general del heroe."
            +"\n\t6 - Comprobar afinidad con los Npcs."
            +"\n\t7 - Multiples eventos.";

        String menuEvento="Por favor seleccione una opcion:"
            +"\n\t0 - Salir."
            +"\n\t1 - Vagabundo."
            +"\n\t2 - Defensa de aldeanos."
            +"\n\t3 - Crias de porings.";  
            
        //Conectando a la base de datos
       
        try {
            //Importando datos
            Statement stm=connect.createStatement();
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
                            connect.close();
                            System.exit(0);
                            break;
                        case 1:
                            connect=DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/popollo_adventure_cargar"
                                ,"root","");
                            
                            //Guardando parametros del heroe
                            PreparedStatement smt = connect.prepareStatement("UPDATE heroe "
                                + "SET nombre = ?, descripcion = ?, saludMaxima = ?, salud = ?, fuerza = ?, magia = ?, agilidad = ?"
                                    + ", defensa = ?, dinero = ?, reputacion = ?, experiencia = ?, nivel = ? WHERE nombre = 'Popollo'");
                                smt.setString(1, popollo.getNombre());
                                smt.setString(2, popollo.getDescripcion());
                                smt.setInt(3, popollo.getSaludMaxima());
                                smt.setInt(4, popollo.getSalud());
                                smt.setInt(5, popollo.getFuerza());
                                smt.setInt(6, popollo.getMagia());
                                smt.setInt(7, popollo.getAgilidad());
                                smt.setInt(8, popollo.getDefensa());
                                smt.setInt(9, popollo.getDinero());
                                smt.setInt(10, popollo.getReputacion());
                                smt.setInt(11, popollo.getExperiencia());
                                smt.setInt(12, popollo.getNivel());  
                                smt.executeUpdate();
                            
                                //Solo modificamos la variable que realmente cambia, en este caso los usos restantes
                                for (int i = 0; i < habilidadesHeroe.size(); i++) {
                                    smt = connect.prepareStatement("UPDATE habilidad "
                                    + "SET usosRestantes = ? WHERE heroe_nombre = 'Popollo' AND ID = "+(i+1)+"");
                                    smt.setInt(1, popollo.getHabilidadesArray().get(i).getUsosRestantes());  
                                    smt.executeUpdate();
                                } 
                                
                                //Solo modificamos la variable que realmente cambia, en este caso la cantidad
                                for (int i = 0; i < objetosHeroe.size(); i++) {
                                    smt = connect.prepareStatement("UPDATE objeto "
                                    + "SET cantidad = ? WHERE heroe_nombre = 'Popollo' AND ID = "+(i+1)+"");
                                    smt.setInt(1, popollo.getObjetosArray().get(i).getCantidad());  
                                    smt.executeUpdate();
                                } 
                            System.out.println("Partida guardada sin problemas ^^");      
                            break;
                        case 2:
                            Combate.batalla(popollo, nigromante);
                            break;
                        case 3:
                            popollo.puntoDescanso();
                            break;
                        case 4:
                            popollo.tienda();
                            break;
                        case 5:
                            popollo.pantallaGeneralEstadisticas();
                            break;
                        case 6:
                            Npc.afinidadNpcs(narcyl, popollo);
                            Npc.afinidadNpcs(tomberi, popollo);
                            Npc.afinidadNpcs(mystra, popollo);
                            break;
                        case 7:
                            System.out.println(menuEvento);
                            int opcionEvento=Integer.parseInt(sc.nextLine());
                            do{
                            switch(opcionEvento){
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
                            }while(opcionEvento!=0&&opcionEvento!=1&&opcionEvento!=2&&opcionEvento!=3);
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
         */	
