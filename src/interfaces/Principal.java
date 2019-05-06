package interfaces;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
	
	public Principal(Ventana v) {
		super();
		this.ventana=v;
		
		//Sonido
		String rutaSonido = "./sonidos/Guardar.wav";
		
		//CARGANDO DATOS DEL JUEGO
		//Si detecta una conexion entra en la base de datos y recupera los datos del heroe junto sus habilidades de lo contrario no hace nada (evitando un error).
		if(ventana.getConnect()!=null) {
			try {			
				Statement stm = ventana.getConnect().createStatement();
				ResultSet rs;    
           
		        //Habilidades
		        rs=stm.executeQuery("SELECT * FROM habilidad ORDER BY ID ASC");
		        ArrayList<Habilidad> habilidadesHeroe=new ArrayList();
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
		        ArrayList<Habilidad> habilidadesHeroe=new ArrayList();
			        habilidadesHeroe.add(new Habilidad("Proyectil Magico", "Disparas chispas magicas de tus manos.", 7, 5, 5, "ofensivo"));
			        habilidadesHeroe.add(new Habilidad("Flecha Helada", "Lanzas una flecha que congela todo a su paso.", 12, 3, 3, "ofensivo"));
			        habilidadesHeroe.add(new Habilidad("Curar Heridas", "Sana las heridas superficiales.", 8, 3, 3, "curativo"));
			        
			    ArrayList<Objeto> objetosHeroe=new ArrayList();
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
				ArrayList<Habilidad> habilidadesPoring=new ArrayList();
		        	habilidadesPoring.add(new Habilidad("Pedo magico", "Flatulencia rosada.", 7, 5, 5, "ofensivo"));
		        	habilidadesPoring.add(new Habilidad("Tirar jellopy", "Mejor no digo de donde sale.", 10, 3, 3, "ofensivo"));           
			
	        	ArrayList<Habilidad> habilidadesNigromante=new ArrayList();
		        	habilidadesNigromante.add(new Habilidad("Lanzar maldicion", "Dolor intenso en las entrañas.", 5, 5, 5, "ofensivo"));
		        	habilidadesNigromante.add(new Habilidad("Flecha acida", "Derrite armaduras y quema la carne.", 10, 3, 3, "ofensivo"));          
			
	        	ArrayList<Habilidad> habilidadesGolem=new ArrayList();
	        		habilidadesGolem.add(new Habilidad("Mina magica", "El suelo a tu alrededor explota.", 5, 5, 5, "ofensivo"));
	        		habilidadesGolem.add(new Habilidad("Llamarada", "Quema el aire a su alrededor.", 7, 3, 3, "ofensivo"));     
			
        		ArrayList<Habilidad> habilidadesGoblin=new ArrayList();
        			habilidadesGoblin.add(new Habilidad("Lanza envenenada", "La punta de lanza brilla con un color extraña.", 10, 5, 5, "ofensivo"));
        			habilidadesGoblin.add(new Habilidad("Flecha venenosa", "Es mejor que no te alcance.", 15, 3, 3, "ofensivo"));     
			
    			ArrayList<Habilidad> habilidadesPulpoi=new ArrayList();
		        	habilidadesPulpoi.add(new Habilidad("Cosquillas", "Flatulencia rosada.", 10, 5, 5, "ofensivo"));
		        	habilidadesPulpoi.add(new Habilidad("Mirada viciosa", "Te desnuda con la mirada.", 15, 3, 3, "ofensivo"));               
			
			    //Guardo los enemigos en un ArrayList por comodidad.
				ventana.enemigosArray = new ArrayList();
					ventana.enemigosArray.add(new Enemigo("Poring", "Una pequeña bola rosita", 60, 60,15, 3, 10, 5, habilidadesPoring, 500, 25));
					ventana.enemigosArray.add(new Enemigo("Nigromante", "Da grima verlo", 80, 80, 20, 5, 15, 15, habilidadesNigromante, 1000, 50));
					ventana.enemigosArray.add(new Enemigo("Golem", "Un muro enorme de piedra.", 150, 150, 30, 5, 15, 25, habilidadesGolem, 1500, 60));
					ventana.enemigosArray.add(new Enemigo("Goblin", "Es muy rapido", 120, 120, 20, 3, 30, 10, habilidadesGoblin, 1500, 60));
					ventana.enemigosArray.add(new Enemigo("Pulpoi", "Pulpo pervertido.", 300, 300, 40, 5, 20, 30, habilidadesPulpoi, 2500, 100));	
		       }
	       
				//Creacion de npcs, se comprueba si estan creados para no repetir el proceso.
		       if(ventana.npcsArray==null) {
				//Npcs
				ventana.npcsArray=new ArrayList();	
					ventana.npcsArray.add(new Npc("Narcyl", "Sacerdotisa novata.", "legal"));
					ventana.npcsArray.add(new Npc("Tomberi", "Demasiado gruñon.", "neutral"));
					ventana.npcsArray.add(new Npc("Mystra", "Hechicera demente.", "caotico"));
		       }		
	       } catch (InvalidTipoException | InvalidMoralException ex) {
           ex.printStackTrace();
           System.err.println(ex.getMessage());
           }	
		
		//Barra progreso, se mueve dependiendo del valor Explorar del heroe.
		ventana.barraExploracion.setString("Comienza tu aventura");
		ventana.barraExploracion.setValue(ventana.heroe.getExplorar());
		ventana.barraExploracion.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		ventana.barraExploracion.setStringPainted(true);
		ventana.barraExploracion.setForeground(new Color(88, 164, 146));
		ventana.barraExploracion.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		ventana.barraExploracion.setBounds(271, 31, 400, 67);
		add(ventana.barraExploracion);
		
		//Eventos	
	
        //Añadiendo botones
		
		Botones combatePrueba = new Botones("Combate Prueba");
		combatePrueba.setBounds(709, 200, 218, 23);
		add(combatePrueba);
		
		Botones eventoPrueba = new Botones("Evento Prueba");
		eventoPrueba.setBounds(709, 234, 218, 23);
		add(eventoPrueba);
		
		Botones pruebaAfinidad = new Botones("Afinidad");
		pruebaAfinidad.setBounds(709, 268, 218, 23);
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
		
		Botones botoAvanzar = new Botones("Avanzar");
		botoAvanzar.setBounds(371, 95, 200, 23);
		add(botoAvanzar);
		
		Botones botonSalir = new Botones("Salir");
		botonSalir.setBounds(709, 428, 215, 23);
		add(botonSalir);

		//Eventos de botones
		
		combatePrueba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cargarPantallaLucha();
				//general.Combate.batalla(ventana.heroe, ventana.enemigosArray.get(0));	
				avanzarBarraProgreso();
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
		
		botonGuardarPartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.guardarPartida(ventana.heroe.getHabilidadesArray(), ventana.heroe.getObjetosArray()); 
				general.Musica.sonidosBoton(rutaSonido);
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
		
		botoAvanzar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				avanzarBarraProgreso();
			}
		});
		
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ventana.getConnect()!=null) {
					try {
						ventana.connect.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
					System.exit(0);  
			}
		});
		

		
		LabelTexto mostrarAtributos = new LabelTexto();
		mostrarAtributos.setText("<html><center><b>Nivel:&ensp;"+Integer.toString(ventana.heroe.getNivel())+"</b></center>"
			+"Salud:&ensp;"+Integer.toString(ventana.heroe.getSalud())+"/"+Integer.toString(ventana.heroe.getSaludMaxima())
			+"<br/>Fuerza:&ensp;"+Integer.toString(ventana.heroe.getFuerza())
			+"<br/>Magia:&ensp;"+Integer.toString(ventana.heroe.getMagia())
			+"<br/>Defensa:&ensp;"+Integer.toString(ventana.heroe.getDefensa())
			+"<br/>Agilidad:&ensp;"+Integer.toString(ventana.heroe.getAgilidad())	
			+"</html>");
		mostrarAtributos.setBounds(10, 370, 130, 155);
		add(mostrarAtributos);
		
		LabelTexto mostrarHabilidades = new LabelTexto();
		mostrarHabilidades.setText("<html><center><b>Habilidades</b></center>"
				+ventana.heroe.getHabilidadesArray().get(0).getNombre()+"&ensp;"
				+Integer.toString(ventana.heroe.getHabilidadesArray().get(0).getUsosRestantes())+"/"
				+Integer.toString(ventana.heroe.getHabilidadesArray().get(0).getUsosMaximos())+"<br/>"
				+ventana.heroe.getHabilidadesArray().get(1).getNombre()+"&ensp;"
				+Integer.toString(ventana.heroe.getHabilidadesArray().get(1).getUsosRestantes())+"/"
				+Integer.toString(ventana.heroe.getHabilidadesArray().get(1).getUsosMaximos())+"<br/>"
				+ventana.heroe.getHabilidadesArray().get(2).getNombre()+"&ensp;"
				+Integer.toString(ventana.heroe.getHabilidadesArray().get(2).getUsosRestantes())+"/"
				+Integer.toString(ventana.heroe.getHabilidadesArray().get(2).getUsosMaximos())+"<br/>"
				+"</html>");
		mostrarHabilidades.setBounds(150, 436, 174, 89);
		add(mostrarHabilidades);

		LabelTexto mostrarObjetos = new LabelTexto();
		mostrarObjetos.setText("<html><center><b>Objetos</b></center>"
				+ventana.heroe.getObjetosArray().get(0).getNombre()+"&ensp;"
				+Integer.toString(ventana.heroe.getObjetosArray().get(0).getCantidad())+"<br/>"
				+ventana.heroe.getObjetosArray().get(1).getNombre()+"&ensp;"
				+Integer.toString(ventana.heroe.getObjetosArray().get(1).getCantidad())+"<br/>"
				+ventana.heroe.getObjetosArray().get(2).getNombre()+"&ensp;"
				+Integer.toString(ventana.heroe.getObjetosArray().get(2).getCantidad())+"<br/>"
				+"</html>");
		mostrarObjetos.setBounds(334, 436, 174, 89);
		add(mostrarObjetos);
		
		LabelTexto mostrarDineroReputacion = new LabelTexto();
		mostrarDineroReputacion.setText("<html><b>Oro:&ensp;"+Integer.toString(ventana.heroe.getDinero())
				+"<br/>Reputacion:&ensp;"+Integer.toString(ventana.heroe.getReputacion())	
				+"</b></html>");
		mostrarDineroReputacion.setBounds(10, 29, 130, 51);
		add(mostrarDineroReputacion);
		
		//Imagen de fondo
		JLabel imagenDescanso = new JLabel("");
		imagenDescanso.setBounds(0, 0, 1008, 536);
		imagenDescanso.setIcon(new ImageIcon("./imagenes/mapa.jpg"));
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
			ventana.barraExploracion.setString("Un pequeño paso para un gran Popollo.");			
		}
		else if(ventana.barraExploracion.getValue()>=2&&ventana.barraExploracion.getValue()<=5) {
			ventana.barraExploracion.setString("Es duro pero solo tu puedes conseguirlo!!!");			
		}
		else if(ventana.barraExploracion.getValue()>=6&&ventana.barraExploracion.getValue()<=9) {
			ventana.barraExploracion.setString("Eres un gran heroe Popollo.");			
		}
		else if(ventana.barraExploracion.getValue()==10) {
			ventana.barraExploracion.setString("Acabas de llegar a la mitad de tu recorrido!!!");			
		}
		else if(ventana.barraExploracion.getValue()>=11&&ventana.barraExploracion.getValue()<=14) {
			ventana.barraExploracion.setString("Todo el mundo empieza a conocerte.");			
		}
		else if(ventana.barraExploracion.getValue()>=15&&ventana.barraExploracion.getValue()<=19) {
			ventana.barraExploracion.setString("Estamos en la recta final, esfuerzate al maximo.");			
		}
		else {
			ventana.barraExploracion.setString("Solo tu puedes derrotar al temible Pulpoi.");			
		}
		ventana.barraExploracion.getString();
	}
	
}
	

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
