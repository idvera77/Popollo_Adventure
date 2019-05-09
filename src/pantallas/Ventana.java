package pantallas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import clases.Enemigo;
import clases.Habilidad;
import clases.Heroe;
import clases.Npc;
import clases.Objeto;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ventana extends JFrame{
	private Inicio pantallaInicio;	
	private Galeria pantallaGaleria;
	private Principal pantallaPrincipal;
	private Tienda pantallaTienda;
	private Descanso pantallaDescanso;
	private Lucha pantallaLucha;
	private Evento pantallaEvento;
	private Cargar pantallaCarga;
	public JProgressBar barraExploracion;
	public Connection connect;
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
		
		//Barra de progreso que se usa en varios sitios
		this.barraExploracion = new JProgressBar(0,20);
		this.barraExploracion.setString("Comienza tu aventura");
			
		//Nos aseguramos de cerrar el programa correctamente junto a la conexion si existe.
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				int exit = JOptionPane.showConfirmDialog(null, "¿Estas seguro?" , "Cerrar Programa", 
						JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (exit == JOptionPane.YES_OPTION){
					if(getConnect()!=null) {
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
			 setConnect(DriverManager.getConnection("jdbc:mysql://localhost:3306/popollo_adventure","root","admin"));
			 System.out.println("Conexion establecida");
			 cargarPantallaCarga();
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
	        }
	        } catch (SQLException ex) {
	            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
	            ex.getStackTrace();
	            System.err.println("\n!!!Error al conectarse con la base de datos!!!");
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
		this.pantallaInicio.setVisible(false);
		this.setContentPane(this.pantallaCarga);
		this.pantallaCarga.setVisible(true);
		
	}
	
	/**
	 * De carga a principal
	 */
	public void cargarPantallaPrincipal() {
		if(this.pantallaPrincipal==null) {
			this.pantallaPrincipal=new Principal(this);
		}
		this.setTitle("Principal");
		this.pantallaCarga.setVisible(false);
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
	 * @param adversario Entero el indicaremos la posicion del enemigo guardado en un arrayList
	 */
	public void cargarPantallaLucha(int adversario) {
		this.pantallaLucha=new Lucha(this, adversario);
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
/*
 * package pantallas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import componentes.Paneles;


public class Cargar extends Paneles{
	private JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
    private JLabel label = new JLabel("", JLabel.CENTER);
    private Timer timer = new Timer(100, new ActionListener() {

        private int counter = 1;

        @Override
        public void actionPerformed(ActionEvent ae) {
            label.setText(String.valueOf(counter));
            bar.setValue(++counter);
            if (counter > 100) {
                timer.stop();
            }
        }
    });

    Cargar() {
        super.setLayout(new GridLayout(0, 1));
        bar.setValue(0);
        timer.start();
        this.add(bar);
        this.add(label);
        JOptionPane.showMessageDialog(null, this);
    }


    public void run() {
               Cargar cdpb = new Cargar();
    }
}
*/
