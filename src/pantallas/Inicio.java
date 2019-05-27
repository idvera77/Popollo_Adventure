package pantallas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import componentes.Botones;
import componentes.Paneles;

public class Inicio extends Paneles {
    private Ventana ventana;
    public static int dificultad;
	
    public Inicio(Ventana ventana) {
        super();
        this.ventana=ventana;
        
        //Archivo de sonido
        Ventana.comenzarFondo("./recursos/sonidos/menu.wav");
        String sonidoLogin = "./recursos/sonidos/Login.wav";

        //Añadiendo Botones
        Botones botonIniciar = new Botones("Comenzar Partida");
        botonIniciar.setBounds(397, 326, 215, 23);
        add(botonIniciar);

        Botones botonCargar = new Botones("Cargar Partida");
        botonCargar.setBounds(397, 360, 215, 23);
        add(botonCargar);

        Botones botonGaleria = new Botones("Galería");
        botonGaleria.setBounds(397, 395, 215, 23);
        add(botonGaleria);

        Botones botonSalir = new Botones("Salir");
        botonSalir.setBounds(397, 429, 215, 23);
        add(botonSalir);

        //Imagen de fondo
        JLabel imagenPortada = new JLabel("");
        imagenPortada.setBounds(0, 0, 1008, 536);
        imagenPortada.setIcon(new ImageIcon("./recursos/imagenes/pantallaInicio.png"));
        add(imagenPortada);	

        //Eventos de botones. 
        
        //Nos lleva al panel cargar y luego al principal.
        botonIniciar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	String[] opciones = {"Modo Gallina",
                "Modo Hardcore"};
				int iniciar = JOptionPane.showOptionDialog(ventana,
				"¿Seleccione una dificultad?",
				"Modo de juego",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     
				opciones,  //
				opciones[0]); 
                if (iniciar == JOptionPane.YES_OPTION){
                    setDificultad(0);
                    ventana.cargarPantallaCarga();
                    Ventana.pararFondo();
                    Ventana.comenzarSonido(sonidoLogin);
                }
                else if(iniciar == JOptionPane.NO_OPTION) {
                	setDificultad(1);
                	ventana.cargarPantallaCarga();
                    Ventana.pararFondo();
                    Ventana.comenzarSonido(sonidoLogin);
                }else {
                	
                }      
            }
        });
        
        //Realiza la funcion cargar partida antes de llevarnos al panel de carga.
        botonCargar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
	          	ventana.cargarPartida();
	            if(ventana.getConnect()!=null) {
	            	 try {
						Statement stm = ventana.getConnect().createStatement();
						ResultSet rs;
						rs=stm.executeQuery("SELECT explorar FROM Heroe ");
						rs.next();
		                int explorar=rs.getInt("explorar");
		                stm.close();
		                if(explorar==0) {
		                	JOptionPane.showMessageDialog(null, "No tienes partidas guardadas.", "Lo sentimos", 1);
		                	ventana.getConnect().close();
		                }else {
		                	ventana.cargarPantallaCarga();
				            Ventana.pararFondo();
		                }
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            }
        });
        
        //Nos lleva a la galeria.
        botonGaleria.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	Ventana.pararFondo();
                Ventana.origenADestino(ventana, "inicio", "galeria", 0);
            }
        });
        
        //Nos permite salir del juego.
        botonSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(ventana.getConnect()!=null) {
                    try {
                            ventana.getConnect().close();
                    } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                    }
                }	
                System.exit(0);
            }
        });
    }

	public static int getDificultad() {
		return dificultad;
	}

	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}		
}
