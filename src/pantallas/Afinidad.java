package pantallas;

import componentes.Botones;
import componentes.Paneles;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JButton;

public class Afinidad extends Paneles {
	private Ventana ventana;
	private Timer timer;
    private JProgressBar barraCarga;
    private Botones botonSalir;

	
	public Afinidad(Ventana ventana) {
	super();
    this.ventana=ventana;
    
    //Imagenes
    ArrayList<ImageIcon> imagen = new ArrayList<ImageIcon>();
	    imagen.add(new ImageIcon("./recursos/imagenes/combate/poi.gif"));
	    imagen.add(new ImageIcon("./recursos/imagenes/combate/nigromante.gif"));
	    imagen.add(new ImageIcon("./recursos/imagenes/combate/deviling.gif"));
	    imagen.add(new ImageIcon("./recursos/imagenes/combate/poi.gif"));
    
	botonSalir = new Botones("New button");
    botonSalir.setVisible(false);
    botonSalir.setBounds(440, 448, 89, 23);
    add(botonSalir);
    
    JLabel dialogoNarcyl = new JLabel("New label");
    dialogoNarcyl.setVisible(false);
    dialogoNarcyl.setOpaque(true);
    dialogoNarcyl.setHorizontalAlignment(SwingConstants.CENTER);
    dialogoNarcyl.setBounds(259, 48, 625, 87);
    add(dialogoNarcyl);
    
    JLabel dialogoTomberi = new JLabel("New label");
    dialogoTomberi.setVisible(false);
    dialogoTomberi.setOpaque(true);
    dialogoTomberi.setHorizontalAlignment(SwingConstants.CENTER);
    dialogoTomberi.setBounds(259, 146, 625, 87);
    add(dialogoTomberi);
    
    JLabel dialogoMystra = new JLabel("New label");
    dialogoMystra.setVisible(false);
    dialogoMystra.setOpaque(true);
    dialogoMystra.setHorizontalAlignment(SwingConstants.CENTER);
    dialogoMystra.setBounds(259, 244, 625, 87);
    add(dialogoMystra);
    
    JLabel estadoTomberi = new JLabel("New label");
    estadoTomberi.setBounds(94, 146, 77, 75);
    add(estadoTomberi);
    
    JLabel estadoMystra = new JLabel("New label");
    estadoMystra.setBounds(94, 231, 77, 75);
    add(estadoMystra);
    
    JLabel estadoNarcyl = new JLabel("New label");
    estadoNarcyl.setBounds(94, 54, 77, 75);
    add(estadoNarcyl);
    
    //Imagen de fondo
    JLabel imagenFondo = new JLabel("");
    imagenFondo.setBounds(0, 0, 1008, 536);
    imagenFondo.setIcon(new ImageIcon("./recursos/imagenes/batalla.jpg"));
    add(imagenFondo);	
    
    barraCarga = new JProgressBar();
    add(barraCarga);
   
    //Dependiendo del % mostrara u ocultara los siguientes mensajes.
    ActionListener updateBarraCargar = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            barraCarga.setValue((barraCarga.getValue()+1)); 
            if(ventana.heroe.getReputacion()>=20&&ventana.heroe.getReputacion()<=40) {
            	if(barraCarga.getValue()==2) {
            		dialogoNarcyl.setVisible(true);
                	dialogoNarcyl.setText("Narcyl quiere hablar contigo.");
                }
                if(barraCarga.getValue()==7) {
                	dialogoNarcyl.setText("Sabia que podia confiar en ti, eres justo lo que esperaba de un heroe.");
                }
                if(barraCarga.getValue()==14) {
                	dialogoNarcyl.setText("");
                	dialogoMystra.setVisible(true);
                	dialogoMystra.setText("Lo que me faltaba un heroe aburrido y una santurrona en el grupo.");
                }
                if(barraCarga.getValue()==15) {
                	dialogoNarcyl.setVisible(false);
                }
                if(barraCarga.getValue()==100) {
                	timer.stop();
                	botonSalir.setVisible(true);
                }
            }   
            if(ventana.heroe.getReputacion()<20&&ventana.heroe.getReputacion()>-20) {
            	if(barraCarga.getValue()==2) {
            		dialogoTomberi.setVisible(true);
                	dialogoTomberi.setText("Tomberi quiere hablar contigo.");
                }
                if(barraCarga.getValue()==7) {
                	dialogoTomberi.setText("Iván Díaz Vera");
                }
                if(barraCarga.getValue()==12) {
                	dialogoTomberi.setVisible(false);
                }
                if(barraCarga.getValue()==100) {
                	timer.stop();
                	botonSalir.setVisible(true);
                }
            }    
            if(ventana.heroe.getReputacion()<=-20&&ventana.heroe.getReputacion()>=-40) {
            	if(barraCarga.getValue()==2) {
                	dialogoMystra.setText("Mystra quiere hablar contigo.");
                }
                if(barraCarga.getValue()==7) {
                	dialogoMystra.setText("Iván Díaz Vera");
                }
                if(barraCarga.getValue()==12) {
                	dialogoMystra.setVisible(false);
                }
                if(barraCarga.getValue()==100) {
                	timer.stop();
                	botonSalir.setVisible(true);
                }
            }
        }  
    };
    
    timer = new Timer(500, updateBarraCargar);
    timer.start();  
	}
}
