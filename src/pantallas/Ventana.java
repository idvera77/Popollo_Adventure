package pantallas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import clases.Enemigo;
import clases.Habilidad;
import clases.Heroe;
import clases.Npc;
import clases.Objeto;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ventana extends JFrame{
	private static Inicio pantallaInicio;	
	private static Galeria pantallaGaleria;
	private static Principal pantallaPrincipal;
	private static Tienda pantallaTienda;
	private static Descanso pantallaDescanso;
	private static Lucha pantallaLucha;
	private static Evento pantallaEvento;
	private Cargar pantallaCarga;
	private Connection connect;
	public Heroe heroe;
	public ArrayList<Enemigo> enemigosArray;
	public ArrayList<Npc> npcsArray;
	
	public Ventana() {
		super();
		setTitle("Popollo Adventure");
		pantallaInicio=new Inicio(this);
		setSize(1024,576);
		setVisible(true);
		setContentPane(pantallaInicio);
		setLocationRelativeTo(null);
		
		//Cursor Personalizado
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("./recursos/normal.png");
		Point point = new Point(0, 0);
		Cursor cursor = toolkit.createCustomCursor(img, point, "./recursos/normal.png");
		setCursor(cursor);
		
		//Nos aseguramos de cerrar el programa correctamente junto a la conexion si existe.
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				int exit = JOptionPane.showConfirmDialog(null, "¿Estas seguro?" , " Cerrar Programa", 
						JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (exit == JOptionPane.YES_OPTION){
					if(connect!=null) {
						try {
							connect.close();
						} catch (SQLException e1) {
						//No importa el error que pueda transmitir en este caso.
						}
					}	
				    System.exit(0);
				}	
			}
		});
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
	
	//Funcion que conecta con la base de base de datos para cargar partida y nos devuelve una conexion si no ocurre ningun error.
	public Connection cargarPartida() {
		try {
			connect = DriverManager.getConnection(
					 "jdbc:mysql://localhost:3306/popollo_adventure"
					 + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","admin");
			 return connect;	 
		} catch (SQLException ex) {
		    ex.printStackTrace();
		    return null;
		}
	}
	
	public void guardarPartida(ArrayList<Habilidad> habilidadesHeroe, ArrayList<Objeto> objetosHeroe) {
		try {
			connect = DriverManager.getConnection(
					 "jdbc:mysql://localhost:3306/popollo_adventure"
					 + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","admin");
		    
		    //Guardando parametros del heroe
		    PreparedStatement smt = connect.prepareStatement("UPDATE heroe "
		        + "SET nombre = ?, descripcion = ?, saludMaxima = ?, salud = ?, fuerza = ?, magia = ?, agilidad = ?"
		            + ", defensa = ?, dinero = ?, reputacion = ?, experiencia = ?, nivel = ?, explorar = ? WHERE ID = 1");
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
	        smt.setInt(13, heroe.getExplorar());
	        smt.executeUpdate();
		    
	        //Solo modificamos la variable que realmente cambia, en este caso los usos restantes
	        for (int i = 0; i < habilidadesHeroe.size(); i++) {
	            smt = connect.prepareStatement("UPDATE habilidad "
	            + "SET usosRestantes = ? WHERE ID = "+(i+1)+"");
	            smt.setInt(1, heroe.getHabilidadesArray().get(i).getUsosRestantes());  
	            smt.executeUpdate();
	        } 
	        
	        //Solo modificamos la variable que realmente cambia, en este caso la cantidad
	        for (int i = 0; i < objetosHeroe.size(); i++) {
	            smt = connect.prepareStatement("UPDATE objeto "
	            + "SET cantidad = ? WHERE ID = "+(i+1)+"");
	            smt.setInt(1, heroe.getObjetosArray().get(i).getCantidad());  
	            smt.executeUpdate();  
	            smt.close();
	        }
	        smt.close();
	        } catch (SQLException ex) {
	            ex.getStackTrace();
	        }      
	} 
	
	//Movimiento entre paneles
	/**
	 * De pantalla de inicio a pantalla de carga
	 */
	public void cargarPantallaCarga() {
		if(this.pantallaCarga==null) {
			this.pantallaCarga=new Cargar(this);
		}
		this.setTitle("Principal");
		Ventana.pantallaInicio.setVisible(false);
		this.setContentPane(this.pantallaCarga);
		this.pantallaCarga.setVisible(true);
	}
	
	/**
	 * De carga a principal
	 */
	public void cargarPantallaPrincipal() {
		if(Ventana.pantallaPrincipal==null) {
			Ventana.pantallaPrincipal=new Principal(this);
		}
		this.setTitle("Principal");
		this.pantallaCarga.setVisible(false);
		this.setContentPane(Ventana.pantallaPrincipal);
		Ventana.pantallaPrincipal.setVisible(true);
	}
	
	/**
	 * Funcion para ir de pantalla origen a pantalla destino
	 * @param origen Indica la pantalla actual
	 * @param destino Indica la pantalla siguiente
	 * @param Variable de tipo entero que nos ayuda a indicar el numero de evento o combate
	 */
	public static void origenADestino(Ventana v, String origen, String destino, int numero) {
		switch(destino) {
			case "inicio":
				Ventana.pantallaInicio=new Inicio(v);
				v.setTitle("Popollo Adventure");
				v.setContentPane(pantallaInicio);
				Ventana.pantallaInicio.setVisible(true);	
				break;
			case "tienda":
				Ventana.pantallaTienda=new Tienda(v);
				v.setTitle("Tienda");
				v.setContentPane(Ventana.pantallaTienda);
				Ventana.pantallaTienda.setVisible(true);	
				break;
			case "descanso":
				Ventana.pantallaDescanso=new Descanso(v);
				v.setTitle("Descanso");
				v.setContentPane(Ventana.pantallaDescanso);
				Ventana.pantallaDescanso.setVisible(true);	
				break;
			case "evento":
				Ventana.pantallaEvento=new Evento(v, numero);
				v.setTitle("Evento");
				v.setContentPane(Ventana.pantallaEvento);
				Ventana.pantallaEvento.setVisible(true);
				break;
			case "lucha":
				Ventana.pantallaLucha=new Lucha(v, numero);
				v.setTitle("Lucha");
				v.setContentPane(Ventana.pantallaLucha);
				Ventana.pantallaLucha.setVisible(true);
				break;
			case "principal":
				Ventana.pantallaPrincipal=new Principal(v);
				v.setTitle("Principal");
				v.setContentPane(Ventana.pantallaPrincipal);
				Ventana.pantallaPrincipal.setVisible(true);
				break;		
			case "galeria":
				Ventana.pantallaGaleria=new Galeria(v);
				v.setTitle("Galeria");
				v.setContentPane(Ventana.pantallaGaleria);
				Ventana.pantallaGaleria.setVisible(true);
				break;
		}
		switch(origen) {
			case "inicio":
				Ventana.pantallaInicio.setVisible(false);
			break;
			case "tienda":
				Ventana.pantallaTienda.setVisible(false);
				break;
			case "descanso":
				Ventana.pantallaDescanso.setVisible(false);
				break;
			case "evento":
				Ventana.pantallaEvento.setVisible(false);
				break;
			case "lucha":
				Ventana.pantallaLucha.setVisible(false);
				break;
			case "principal":
				Ventana.pantallaPrincipal.setVisible(false);
			break;		
		}
	}
}
