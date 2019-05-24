package pantallas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import componentes.Botones;
import componentes.Paneles;

public class Inicio extends Paneles {
    private Ventana ventana;
	
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
                ventana.cargarPantallaCarga();
                Ventana.pararFondo();
                Ventana.comenzarSonido(sonidoLogin);
            }
        });
        
        //Realiza la funcion cargar partida antes de llevarnos al panel de carga.
        botonCargar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
	          	ventana.cargarPartida();
	            if(ventana.getConnect()!=null) {
		            ventana.cargarPantallaCarga();
		            Ventana.pararFondo();
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
}
