package interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

import clases.Enemigo;
import clases.Habilidad;
import clases.Heroe;
import clases.Npc;
import clases.Objeto;
import exceptions.InvalidMoralException;
import exceptions.InvalidTipoException;

public class Ventana extends JFrame{
	private Inicio pantallaInicio;	
	private Galeria pantallaGaleria;
	private Principal pantallaPrincipal;
	private Tienda pantallaTienda;
	private Descanso pantallaDescanso;
	private Lucha pantallaLucha;
	private Evento pantallaEvento;

	Connection connect;
	Heroe heroe;
	ArrayList<Enemigo> enemigosArray;
	ArrayList<Npc> npcsArray;
	
	public Ventana() {
		super();
		this.setTitle("Popollo Adventure");
		pantallaInicio=new Inicio(this);
		setSize(1024,576);
		setVisible(true);
		setContentPane(pantallaInicio);
		setLocationRelativeTo(null);
		
		try {
			 Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/popollo_adventure","root","admin");
			 System.out.println("Conexion establecida"); 
			
		Statement stm = connect.createStatement();
        ResultSet rs;    
            
        //Creando el heroe
        //Habilidades
        rs=stm.executeQuery("SELECT * FROM habilidad WHERE Heroe_ID = 1 ORDER BY posicion ASC");
        ArrayList<Habilidad> habilidadesHeroe=new ArrayList();
        while(rs.next()){
            habilidadesHeroe.add(new Habilidad(rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("especial"),
                rs.getInt("usosMaximos"),rs.getInt("usosRestantes"), rs.getString("tipo")));
        }
            
        //Objetos
        rs=stm.executeQuery("SELECT * FROM objeto WHERE Heroe_ID = 1 ORDER BY posicion ASC");
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
       
        this.heroe= new Heroe(nombreHeroe, descripcionHeroe, saludMaxHeroe, saludHeroe, fuerzaHeroe, magiaHeroe, agilidadHeroe,
            defensaHeroe, habilidadesHeroe, objetosHeroe, dineroHeroe, reputacionHeroe, experienciaHeroe, nivelHeroe); 

		//Enemigos y sus habilidades
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
		
		this.enemigosArray=new ArrayList();
			enemigosArray.add(new Enemigo("Poring", "Una pequeña bola rosita", 60, 60,15, 3, 10, 5, habilidadesPoring, 500, 25));
			enemigosArray.add(new Enemigo("Nigromante", "Da grima verlo", 80, 80, 20, 5, 15, 15, habilidadesNigromante, 1000, 50));
			enemigosArray.add(new Enemigo("Golem", "Un muro enorme de piedra.", 150, 150, 30, 5, 15, 25, habilidadesGolem, 1500, 60));
			enemigosArray.add(new Enemigo("Goblin", "Es muy rapido", 120, 120, 20, 3, 30, 10, habilidadesGoblin, 1500, 60));
			enemigosArray.add(new Enemigo("Pulpoi", "Pulpo pervertido.", 300, 300, 40, 5, 20, 30, habilidadesPulpoi, 2500, 100));	
		
		
		//Npcs
		this.npcsArray=new ArrayList();	
			npcsArray.add(new Npc("Narcyl", "Sacerdotisa novata.", "legal"));
			npcsArray.add(new Npc("Tomberi", "Demasiado gruñon.", "neutral"));
			npcsArray.add(new Npc("Mystra", "Hechicera demente.", "caotico"));
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (InvalidTipoException | InvalidMoralException ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        }	
	}
	
	public Connection getConnect() {
		return connect;
	}
	public void setConnect(Connection connect) {
		this.connect = connect;
	}
	
	public Heroe getHeroe() {
		return heroe;
	}

	public void setHeroe(Heroe heroe) {
		this.heroe = heroe;
	}

	//Funcion que conecta con la base de datos y nos devuelve una conexion si no ocurre ningun error.
	public Connection iniciarPartida() {
		try {
			 Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/popollo_adventure","root","admin");
			 System.out.println("Conexion establecida");
			 return connect;
			 
		} catch (SQLException ex) {
		    System.err.println("La conexion a bd ha fallado");
		    ex.printStackTrace();
		    return null;
		}
	}
	
	//Funcion que conecta con la base de base de datos para cargar partida y nos devuelve una conexion si no ocurre ningun error.
	public Connection cargarPartida() {
		try {
			 Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/popollo_adventure","root","admin");
			 System.out.println("Conexion establecida");
			 return connect;
			 
			 
		} catch (SQLException ex) {
		    System.err.println("La conexion a bd ha fallado");
		    ex.printStackTrace();
		    return null;
		}
	}
	
	public void guardarPartida(ArrayList<Habilidad> habilidadesHeroe, ArrayList<Objeto> objetosHeroe) {
		try {
			Connection connect=(DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/popollo_adventure","root","admin"));
		    
		    //Guardando parametros del heroe
		    PreparedStatement smt = connect.prepareStatement("UPDATE heroe "
		        + "SET nombre = ?, descripcion = ?, saludMaxima = ?, salud = ?, fuerza = ?, magia = ?, agilidad = ?"
		            + ", defensa = ?, dinero = ?, reputacion = ?, experiencia = ?, nivel = ? WHERE ID = '2'");
		        smt.setString(1, heroe.getNombre());
		        smt.setString(2, heroe.getDescripcion());
		        smt.setInt(3, heroe.getSaludMaxima());
		        smt.setInt(4, heroe.getSalud());
		        smt.setInt(5, heroe.getFuerza());
		        smt.setInt(6, heroe.getMagia());
		        smt.setInt(7, heroe.getAgilidad());
		        smt.setInt(8, heroe.getDefensa());
		        smt.setInt(9, heroe.getDinero());
		        smt.setInt(10, heroe.getReputacion());
		        smt.setInt(11, heroe.getExperiencia());
		        smt.setInt(12, heroe.getNivel());  
		        smt.executeUpdate();
		    
	        //Solo modificamos la variable que realmente cambia, en este caso los usos restantes
	        for (int i = 0; i < habilidadesHeroe.size(); i++) {
	            smt = connect.prepareStatement("UPDATE habilidad "
	            + "SET usosRestantes = ? WHERE Heroe_ID = 2 AND posicion = "+(i+1)+"");
	            smt.setInt(1, heroe.getHabilidadesArray().get(i).getUsosRestantes());  
	            smt.executeUpdate();
	        } 
	        
	        //Solo modificamos la variable que realmente cambia, en este caso la cantidad
	        for (int i = 0; i < objetosHeroe.size(); i++) {
	            smt = connect.prepareStatement("UPDATE objeto "
	            + "SET cantidad = ? WHERE Heroe_ID = 2 AND posicion = "+(i+1)+"");
	            smt.setInt(1, heroe.getObjetosArray().get(i).getCantidad());  
	            smt.executeUpdate();
	        }
	        } catch (SQLException ex) {
	            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
	            ex.getStackTrace();
	            System.err.println("\n!!!Error al conectarse con la base de datos!!!");
	        }      
	} 
	
	//Movimiento entre paneles.	
	
	/**
	 * De pantalla de inicio a pantalla principal
	 */
	public void cargarPantallaPrincipal() {
		if(this.pantallaPrincipal==null) {
			this.pantallaPrincipal=new Principal(this);
		}
		this.setTitle("Principal");
		this.pantallaInicio.setVisible(false);
		this.setContentPane(this.pantallaPrincipal);
		this.pantallaPrincipal.setVisible(true);
	}
	
	/**
	 * De pantalla de inicio a pantalla galeria
	 */
	public void cargarPantallaGaleria() {
		if(this.pantallaGaleria==null) {
			this.pantallaGaleria=new Galeria(this);
		}
		this.setTitle("Galeria");
		this.pantallaInicio.setVisible(false);
		this.setContentPane(this.pantallaGaleria);
		this.pantallaGaleria.setVisible(true);
	}
	
	/**
	 * De pantalla galeria a pantalla de inicio
	 */
	public void volverPantallaInicio() {
		if(this.pantallaInicio==null) {
			this.pantallaInicio=new Inicio(this);
		}
		this.setTitle("Popollo Adventure");
		this.pantallaGaleria.setVisible(false);
		this.setContentPane(this.pantallaInicio);
		this.pantallaInicio.setVisible(true);
	}
	
	/**
	 * De pantalla principal a pantalla tienda
	 */
	public void cargarPantallaTienda() {
		this.pantallaTienda=new Tienda(this);
		this.setTitle("Tienda");
		this.pantallaPrincipal.setVisible(false);
		this.setContentPane(this.pantallaTienda);
		this.pantallaTienda.setVisible(true);
	}
	
	/**
	 * De pantalla principal a pantalla descanso
	 */
	public void cargarPantallaDescanso() {
		this.pantallaDescanso=new Descanso(this);
		this.setTitle("Descanso");
		this.pantallaPrincipal.setVisible(false);
		this.setContentPane(this.pantallaDescanso);
		this.pantallaDescanso.setVisible(true);
	}
	
	/**
	 * De pantalla principal a pantalla evento
	 */
	public void cargarPantallaEvento() {
		this.pantallaEvento=new Evento(this);
		this.setTitle("Evento");
		this.pantallaPrincipal.setVisible(false);
		this.setContentPane(this.pantallaEvento);
		this.pantallaEvento.setVisible(true);
	}
	
	/**
	 * De pantalla principal a pantalla combate
	 */
	public void cargarPantallaLucha() {
		this.pantallaLucha=new Lucha(this);
		this.setTitle("Combate");
		this.pantallaPrincipal.setVisible(false);
		this.setContentPane(this.pantallaLucha);
		this.pantallaLucha.setVisible(true);
	}
	
	/**
	 * Volver de cualquier lugar a la pantalla principal
	 */
	public void volverPantallaPrincipal(String cadena) {
		switch(cadena) {
			case "Tienda":
				this.pantallaTienda.setVisible(false);	
				break;
			case "Descanso":
				this.pantallaDescanso.setVisible(false);
				break;
			case "Evento":
				this.pantallaEvento.setVisible(false);
				break;
			case "Lucha":
				this.pantallaLucha.setVisible(false);
				break;		
		}
		this.pantallaPrincipal=new Principal(this);
		this.setTitle("Principal");
		this.setContentPane(this.pantallaPrincipal);
		this.pantallaPrincipal.setVisible(true);
	}
}
