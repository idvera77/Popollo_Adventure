package pantallas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;

import clases.Enemigo;
import clases.Habilidad;
import clases.Heroe;
import clases.Npc;
import clases.Objeto;
import componentes.Botones;
import componentes.LabelTexto;
import componentes.Paneles;
import exceptions.InvalidMoralException;
import exceptions.InvalidTipoException;

import java.awt.Color;
import java.awt.Font;

public class Principal extends Paneles {
	private Ventana ventana;
	private LabelTexto mostrarAtributos;
	private JProgressBar barraExploracion;
	private JLabel marcadorMapa;
	
	public Principal(Ventana ventana) {
		super();
		this.ventana=ventana;
		this.barraExploracion=ventana.barraExploracion;
		
		//Sonido
		String rutaSonido = "./recursos/sonidos/Guardar.wav";
		
		//CARGANDO DATOS DEL JUEGO
		//Si detecta una conexion entra en la base de datos y recupera los datos del heroe junto sus habilidades de lo contrario no hace nada (evitando un error).
		if(ventana.getConnect()!=null) {
			try {			
				Statement stm = ventana.getConnect().createStatement();
				ResultSet rs;    
           
		        //Habilidades
		        rs=stm.executeQuery("SELECT * FROM habilidad ORDER BY ID ASC");
		        ArrayList<Habilidad> habilidadesHeroe=new ArrayList<Habilidad>();
			       while(rs.next()){
			           habilidadesHeroe.add(new Habilidad(rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("especial"),
			        		   rs.getInt("usosMaximos"),rs.getInt("usosRestantes"), rs.getString("tipo")));
			       }
	           
			      //Objetos
			      rs=stm.executeQuery("SELECT * FROM objeto ORDER BY ID ASC");
			      ArrayList<Objeto> objetosHeroe=new ArrayList<>();
			      while(rs.next()){
			          objetosHeroe.add(new Objeto(rs.getString("nombre"),rs.getString("descripcion"), rs.getInt("poder"), rs.getInt("cantidad"),
			        		  rs.getString("tipo"), rs.getInt("precio")));
			      }
	           
			      //Creando el heroe
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
			      int explorar=rs.getInt("explorar");
		
	           
			      //Constructor del Heroe
			      if(ventana.getHeroe()==null) {
			    	  ventana.setHeroe(new Heroe(nombreHeroe, descripcionHeroe, saludMaxHeroe, saludHeroe, fuerzaHeroe, magiaHeroe, agilidadHeroe,
			    			  defensaHeroe, habilidadesHeroe, objetosHeroe, dineroHeroe, reputacionHeroe, experienciaHeroe, nivelHeroe, explorar));
			       }
				   } catch (SQLException ex) {
					   ex.printStackTrace();
				   } catch (InvalidTipoException ex) {
					   ex.printStackTrace();
					   System.err.println(ex.getMessage());
				   }	
		//Comprobamos si existe un heroe creado (cargar) y si no existe empieza desde una base guardada en el programa.	
		}else if(ventana.getHeroe()==null){
			try {
		        ArrayList<Habilidad> habilidadesHeroe=new ArrayList<Habilidad>();
			        habilidadesHeroe.add(new Habilidad("Proyectil Magico", "Disparas chispas magicas de tus manos.", 7, 5, 5, "ofensivo"));
			        habilidadesHeroe.add(new Habilidad("Flecha Helada", "Lanzas una flecha que congela todo a su paso.", 12, 3, 3, "ofensivo"));
			        habilidadesHeroe.add(new Habilidad("Curar Heridas", "Sana las heridas superficiales.", 8, 3, 3, "curativo"));
			        
			    ArrayList<Objeto> objetosHeroe=new ArrayList<Objeto>();
		        	objetosHeroe.add(new Objeto("Bomba Pequeña", "Inflige 30 puntos de daño.", 30, 3, "ofensivo", 100));
			        objetosHeroe.add(new Objeto("Bomba Grande", "Inflige 100 puntos de daño.", 100, 1, "ofensivo", 500));
			        objetosHeroe.add(new Objeto("Pocion", "Restablece 50 puntos de salud.", 50, 5, "curativo", 250));
		        
			        ventana.setHeroe(new Heroe("Popollo", "Un adorable popollito comilon.", 80, 80, 20, 5, 10, 10, habilidadesHeroe, objetosHeroe, 50000, 0, 0, 1, 0));
		     } catch (InvalidTipoException e1) {
					e1.printStackTrace();
			 }
		}
		
		//Insertando el resto de datos, como no se modifican en ningun momento no los guardo en base de datos.
		try {			
			//Creacion de enemigos y sus habilidades, se comprueba si estan creados para no repetir el proceso.
			if(ventana.enemigosArray==null) {
				ArrayList<Habilidad> habilidadesPoring=new ArrayList<Habilidad>();
		        	habilidadesPoring.add(new Habilidad("Pedo magico", "Flatulencia rosada.", 7, 5, 5, "ofensivo"));
		        	habilidadesPoring.add(new Habilidad("Tirar jellopy", "Mejor no digo de donde sale.", 10, 3, 3, "ofensivo"));           
			
	        	ArrayList<Habilidad> habilidadesNigromante=new ArrayList<Habilidad>();
		        	habilidadesNigromante.add(new Habilidad("Lanzar maldicion", "Dolor intenso en las entrañas.", 5, 5, 5, "ofensivo"));
		        	habilidadesNigromante.add(new Habilidad("Flecha acida", "Derrite armaduras y quema la carne.", 10, 3, 3, "ofensivo"));          
			
	        	ArrayList<Habilidad> habilidadesGolem=new ArrayList<Habilidad>();
	        		habilidadesGolem.add(new Habilidad("Mina magica", "El suelo a tu alrededor explota.", 5, 5, 5, "ofensivo"));
	        		habilidadesGolem.add(new Habilidad("Llamarada", "Quema el aire a su alrededor.", 7, 3, 3, "ofensivo"));     
			
        		ArrayList<Habilidad> habilidadesGoblin=new ArrayList<Habilidad>();
        			habilidadesGoblin.add(new Habilidad("Lanza envenenada", "La punta de lanza brilla con un color extraña.", 10, 5, 5, "ofensivo"));
        			habilidadesGoblin.add(new Habilidad("Flecha venenosa", "Es mejor que no te alcance.", 15, 3, 3, "ofensivo"));     
			
    			ArrayList<Habilidad> habilidadesPulpoi=new ArrayList<Habilidad>();
		        	habilidadesPulpoi.add(new Habilidad("Cosquillas", "Flatulencia rosada.", 10, 5, 5, "ofensivo"));
		        	habilidadesPulpoi.add(new Habilidad("Mirada viciosa", "Te desnuda con la mirada.", 15, 3, 3, "ofensivo"));               
			
			    //Guardo los enemigos en un ArrayList por comodidad.
				ventana.enemigosArray = new ArrayList<Enemigo>();
					ventana.enemigosArray.add(new Enemigo("Poring", "Una pequeña bola rosita", 60, 60, 15, 3, 10, 5, habilidadesPoring, 500, 25));
					ventana.enemigosArray.add(new Enemigo("Nigromante", "Da grima verlo", 80, 80, 20, 5, 15, 15, habilidadesNigromante, 1000, 50));
					ventana.enemigosArray.add(new Enemigo("Golem", "Un muro enorme de piedra.", 150, 150, 30, 5, 15, 25, habilidadesGolem, 1500, 60));
					ventana.enemigosArray.add(new Enemigo("Goblin", "Es muy rapido", 120, 120, 20, 3, 30, 10, habilidadesGoblin, 1500, 60));
					ventana.enemigosArray.add(new Enemigo("Pulpoi", "Pulpo pervertido.", 300, 300, 40, 5, 20, 30, habilidadesPulpoi, 2500, 100));	
		       }
	       
				//Creacion de npcs, se comprueba si estan creados para no repetir el proceso.
		       if(ventana.npcsArray==null) {
				//Npcs
				ventana.npcsArray=new ArrayList<Npc>();	
					ventana.npcsArray.add(new Npc("Narcyl", "Sacerdotisa novata.", "legal"));
					ventana.npcsArray.add(new Npc("Tomberi", "Demasiado gruñon.", "neutral"));
					ventana.npcsArray.add(new Npc("Mystra", "Hechicera demente.", "caotico"));
		       }		
	       } catch (InvalidTipoException | InvalidMoralException ex) {
           ex.printStackTrace();
           System.err.println(ex.getMessage());
           }	
		
		//Barra progreso, se mueve dependiendo del valor Explorar del heroe.
		barraExploracion.setValue(ventana.heroe.getExplorar());
		barraExploracion.setVisible(false);
		barraExploracion.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		barraExploracion.setStringPainted(true);
		barraExploracion.setForeground(new Color(88, 164, 146));
		barraExploracion.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		barraExploracion.setBounds(271, 31, 400, 67);
		add(barraExploracion);
		
		marcadorMapa = new JLabel("");
		//marcadorMapa.setIcon(new ImageIcon("./recursos/marcadorMapa.gif"));
		marcadorMapa.setIcon(new ImageIcon("./recursos/1.png"));
		add(marcadorMapa);
		
		//Eventos	
		
	
        //Añadiendo botones
		
		Botones combatePrueba = new Botones("Combate Prueba");
		combatePrueba.setBounds(518, 419, 218, 23);
		add(combatePrueba);
		
		Botones eventoPrueba = new Botones("Evento Prueba");
		eventoPrueba.setBounds(518, 453, 218, 23);
		add(eventoPrueba);
		
		Botones pruebaAfinidad = new Botones("Afinidad");
		pruebaAfinidad.setBounds(518, 487, 218, 23);
		add(pruebaAfinidad);
        
		Botones botonGuardarPartida = new Botones("Guardar Partida");
		botonGuardarPartida.setBounds(767, 436, 215, 23);
		add(botonGuardarPartida);
		
		Botones botonTienda = new Botones("Tienda");
		botonTienda.setBounds(551, 351, 165, 23);
		add(botonTienda);
		
		Botones botonDescanso = new Botones("Punto de descanso");
		botonDescanso.setBounds(551, 385, 165, 23);
		add(botonDescanso);
		
		Botones botoAvanzar = new Botones("Avanzar");
		botoAvanzar.setBounds(371, 95, 200, 23);
		add(botoAvanzar);
		
		Botones botonSalir = new Botones("Salir del Juego");
		botonSalir.setBounds(767, 487, 215, 23);
		add(botonSalir);

		//Eventos de botones
		
		combatePrueba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.origenADestino(ventana,"principal", "lucha", 0);
				avanzarBarraProgreso();
			}
		});
		
		eventoPrueba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//ventana.cargarPantallaLucha(1);
				ventana.cargarPantallaCarga();
				general.Musica.sonidosBoton(rutaSonido);

			}
		});	
		
		pruebaAfinidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.origenADestino(ventana, "principal", "evento", 2);
			}
		});	
		
		botonGuardarPartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int guardar = JOptionPane.showConfirmDialog(null, "¿Estas seguro?" , " Guardar Partida", 
						JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (guardar == JOptionPane.YES_OPTION){
					ventana.guardarPartida(ventana.heroe.getHabilidadesArray(), ventana.heroe.getObjetosArray()); 
					general.Musica.sonidosBoton(rutaSonido);
				}	
			}
		});
		
		botonTienda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.origenADestino(ventana,"principal", "tienda", 0);
			}
		});	
		
		botonDescanso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.origenADestino(ventana,"principal", "descanso", 0);
			}
		});	
		
		botoAvanzar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				avanzarBarraProgreso();
			}
		});
		
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int exit = JOptionPane.showConfirmDialog(null, "¿Estas seguro?" , " Cerrar Programa", 
						JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (exit == JOptionPane.YES_OPTION){
					if(ventana.getConnect()!=null) {
						try {
							ventana.getConnect().close();
						} catch (SQLException e1) {
						//No importa el error que pueda transmitir en este caso.
						}
					}	
				    System.exit(0);
				}	
			}
		});
		
		mostrarAtributos = new LabelTexto();
		ventana.heroe.pantallaGeneralEstadisticas(mostrarAtributos);
		mostrarAtributos.setBounds(10, 370, 130, 155);
		add(mostrarAtributos);
		
		LabelTexto mostrarHabilidades = new LabelTexto();
		ventana.heroe.mostrarHabilidades(mostrarHabilidades);
		mostrarHabilidades.setBounds(150, 436, 174, 89);
		add(mostrarHabilidades);

		LabelTexto mostrarObjetos = new LabelTexto();
		ventana.heroe.mostrarObjetos(mostrarObjetos);
		mostrarObjetos.setBounds(334, 436, 174, 89);
		add(mostrarObjetos);
		
		LabelTexto mostrarDineroReputacion = new LabelTexto();
		mostrarDineroReputacion.setText("<html><b>Oro: "+Integer.toString(ventana.heroe.getDinero())
				+"<br/>Reputacion: "+Integer.toString(ventana.heroe.getReputacion())	
				+"</b></html>");
		mostrarDineroReputacion.setBounds(10, 29, 130, 51);
		add(mostrarDineroReputacion);
		
		//Imagen de fondo
		JLabel imagenDescanso = new JLabel("");
		imagenDescanso.setBounds(0, 0, 1008, 536);
		imagenDescanso.setIcon(new ImageIcon("./recursos/imagenes/mapa.png"));
		add(imagenDescanso);	        
	}	
	
	/**
	 * Funcion que nos permite avanzar en la barra de progreso paso a paso, aumenta el valor explorar del heroe para saber el punto exacto de la partida.
	 */
	public void avanzarBarraProgreso() {
		ventana.barraExploracion.setValue(ventana.barraExploracion.getValue()+1);
		ventana.heroe.setExplorar(ventana.barraExploracion.getValue());
		if(ventana.barraExploracion.getValue()==0) {
			ventana.barraExploracion.setString("Comienza tu aventura");
		}
		else if(ventana.barraExploracion.getValue()==1) {
			//ventana.origenADestino(ventana,"principal", "lucha", 0);		
			marcadorMapa.setBounds(30, 194, 66, 73);
		}
		else if(ventana.barraExploracion.getValue()==2) {
			//ventana.origenADestino(ventana,"principal", "lucha", 0);		
			marcadorMapa.setBounds(112, 134, 58, 68);
		}
		else if(ventana.barraExploracion.getValue()==3) {
			//ventana.origenADestino(ventana,"principal", "lucha", 0);		
			marcadorMapa.setBounds(184, 86, 56, 62);
		}
		else if(ventana.barraExploracion.getValue()==4) {
			//ventana.origenADestino(ventana,"principal", "lucha", 0);		
			marcadorMapa.setBounds(275, 48, 55, 64);
		}
		else if(ventana.barraExploracion.getValue()==5) {
			//ventana.origenADestino(ventana,"principal", "lucha", 0);		
			marcadorMapa.setBounds(354, 85, 61, 67);
		}
		else if(ventana.barraExploracion.getValue()==6) {
			//ventana.origenADestino(ventana,"principal", "lucha", 0);		
			marcadorMapa.setBounds(352, 182, 54, 57);
		}
		else if(ventana.barraExploracion.getValue()==7) {
			//ventana.origenADestino(ventana,"principal", "lucha", 0);		
			marcadorMapa.setBounds(314, 260, 56, 63);
		}
		else if(ventana.barraExploracion.getValue()==8) {
			//ventana.origenADestino(ventana,"principal", "lucha", 0);		
			marcadorMapa.setBounds(334, 344, 54, 59);
		}
		
		
	}
}
	
