package pantallas;

import componentes.Botones;
import componentes.Paneles;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class Afinidad extends Paneles {
	private Ventana ventana;
	private Timer timer;
    private JProgressBar barraCarga;
    private Botones botonSalir;
    private JLabel dialogoNarcyl, dialogoTomberi, dialogoMystra;
    public JLabel recompensaHeroe;
	public Afinidad(Ventana ventana) {
	super();
    this.ventana=ventana;
    
    //Sonido
    Ventana.comenzarFondo("./recursos/sonidos/Afinidad.wav");
    
    //Imagenes
    ArrayList<ImageIcon> imagen = new ArrayList<ImageIcon>();
	    imagen.add(new ImageIcon("./recursos/imagenes/combate/poi.gif"));
	    imagen.add(new ImageIcon("./recursos/imagenes/combate/nigromante.gif"));
	    imagen.add(new ImageIcon("./recursos/imagenes/combate/deviling.gif"));
	    imagen.add(new ImageIcon("./recursos/imagenes/combate/poi.gif"));
    
	//Boton
	botonSalir = new Botones("Volver al mapa");
    botonSalir.setVisible(false);
    botonSalir.setBounds(396, 283, 215, 23);
    add(botonSalir);
    
    recompensaHeroe = new JLabel("New label");
    recompensaHeroe.setBackground(Color.ORANGE);
    recompensaHeroe.setOpaque(true);
    recompensaHeroe.setVisible(false);
    recompensaHeroe.setFont(new Font("Bahnschrift", Font.BOLD, 18));
    recompensaHeroe.setHorizontalAlignment(SwingConstants.CENTER);
    recompensaHeroe.setBounds(191, 103, 614, 226);
    add(recompensaHeroe);
    
    dialogoNarcyl = new JLabel("New label");
    dialogoNarcyl.setVisible(false);
    dialogoNarcyl.setOpaque(true);
    dialogoNarcyl.setHorizontalAlignment(SwingConstants.CENTER);
    dialogoNarcyl.setBounds(181, 60, 625, 75);
    add(dialogoNarcyl);
    
    dialogoTomberi = new JLabel("New label");
    dialogoTomberi.setVisible(false);
    dialogoTomberi.setOpaque(true);
    dialogoTomberi.setHorizontalAlignment(SwingConstants.CENTER);
    dialogoTomberi.setBounds(181, 146, 625, 75);
    add(dialogoTomberi);
    
    dialogoMystra = new JLabel("New label");
    dialogoMystra.setVisible(false);
    dialogoMystra.setOpaque(true);
    dialogoMystra.setHorizontalAlignment(SwingConstants.CENTER);
    dialogoMystra.setBounds(181, 231, 625, 75);
    add(dialogoMystra);
    
    JLabel estadoNarcyl = new JLabel("New label");
    estadoNarcyl.setBounds(94, 60, 77, 75);
    add(estadoNarcyl);
    
    JLabel estadoTomberi = new JLabel("New label");
    estadoTomberi.setBounds(94, 146, 77, 75);
    add(estadoTomberi);
    
    JLabel estadoMystra = new JLabel("New label");
    estadoMystra.setBounds(94, 231, 77, 75);
    add(estadoMystra);
    
    //Imagen de fondo
    JLabel imagenFondo = new JLabel("");
    imagenFondo.setBounds(0, 0, 1008, 536);
    imagenFondo.setIcon(new ImageIcon("./recursos/imagenes/batalla.jpg"));
    add(imagenFondo);	
    
    barraCarga = new JProgressBar();
    add(barraCarga);
   
    //Dependiendo del % mostrara u ocultara los siguientes mensajes.
    //Dependiendo de la reputacion de nuestro heroe llamara a un evento u otro.
    ActionListener updateBarraCargar = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            barraCarga.setValue((barraCarga.getValue()+1)); 
            if(ventana.heroe.getReputacion()>25&&ventana.heroe.getReputacion()<=50) {
            	eventoLegal();
            }   
            else if(ventana.heroe.getReputacion()>50) {
            	eventoLegalMas();
            } 
            else if(ventana.heroe.getReputacion()<=25&&ventana.heroe.getReputacion()>=-25) {
            	eventoNeutral();
            }    
            else if(ventana.heroe.getReputacion()<-25&&ventana.heroe.getReputacion()>=-50) {
            	eventoCaotico();     
            }
            else {
            	eventoCaoticoMas();
            }
        }  
    };
    
    timer = new Timer(400, updateBarraCargar);
    timer.start();  
    
    //Evento Boton
    botonSalir.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			Ventana.pararFondo();
			Ventana.origenADestino(ventana, "afinidad", "principal", 0);
		}
	});
    
	}
	
	public void eventoCaotico() {
		if(barraCarga.getValue()==10) {
    		dialogoMystra.setVisible(true);
        	dialogoMystra.setText("Algo me dice que esto se va a poner interesante.");
        }
        if(barraCarga.getValue()==30) {
        	dialogoMystra.setVisible(false);
        	dialogoTomberi.setVisible(true);
        	dialogoTomberi.setText("Pensaba que a ti solo te importaba la comida, pero parece que también tienes sentimientos. No me gusta.");
        }
        if(barraCarga.getValue()==50) {
        	dialogoTomberi.setVisible(false);
        	dialogoNarcyl.setVisible(true);
        	dialogoNarcyl.setText("Cuando nos conocimos pensaba que eras de otra manera.");
        }
        if(barraCarga.getValue()==70) {
        	dialogoNarcyl.setVisible(false);
        	dialogoMystra.setVisible(true);
        	dialogoMystra.setText("Pasa de estos estúpidos, toma te lo has ganado.");
        }
        if(barraCarga.getValue()==90) {
        	dialogoMystra.setVisible(false);
        	recompensaHeroe.setVisible(true); 	
        	clases.Npc.recompensasNpc(ventana.npcsArray.get(2), ventana.heroe, recompensaHeroe);
        }
        if(barraCarga.getValue()==100) {
        	timer.stop();
        	botonSalir.setVisible(true);
        }
	}
	public void eventoCaoticoMas() {
		if(barraCarga.getValue()==10) {
    		dialogoMystra.setVisible(true);
        	dialogoMystra.setText("¡Ja,Ja,Ja! Me encanta, te dejare ser mi mascota, pollo de granja.");
        }
        if(barraCarga.getValue()==30) {
        	dialogoMystra.setVisible(false);
        	dialogoTomberi.setVisible(true);
        	dialogoTomberi.setText("Tenias potencial, pero lo has echado todo a perder.");
        }
        if(barraCarga.getValue()==50) {
        	dialogoTomberi.setVisible(false);
        	dialogoNarcyl.setVisible(true);
        	dialogoNarcyl.setText("Por favor, no me hagas daño.");
        }
        if(barraCarga.getValue()==70) {
        	dialogoNarcyl.setVisible(false);
        	dialogoMystra.setVisible(true);
        	dialogoMystra.setText("Pasa de estos estúpidos, toma te lo has ganado.");
        }
        if(barraCarga.getValue()==90) {
        	dialogoMystra.setVisible(false);
        	recompensaHeroe.setVisible(true); 	
        	clases.Npc.recompensasNpc(ventana.npcsArray.get(2), ventana.heroe, recompensaHeroe);
        }
        if(barraCarga.getValue()==100) {
        	timer.stop();
        	botonSalir.setVisible(true);
        }
	}
	public void eventoNeutral() {
		if(barraCarga.getValue()==10) {
    		dialogoTomberi.setVisible(true);
        	dialogoTomberi.setText("A mi solo me importa el dinero y a ti solo recuperar la comida. Eres como yo.");
        }
        if(barraCarga.getValue()==30) {
        	dialogoTomberi.setVisible(false);
        	dialogoNarcyl.setVisible(true);
        	dialogoNarcyl.setText("Creo que un héroe debería hacer más por ayudar a los demás.");
        }
        if(barraCarga.getValue()==50) {
        	dialogoNarcyl.setVisible(false);
        	dialogoMystra.setVisible(true);
        	dialogoMystra.setText("¿Te vas de viaje y no aprovechas en buscar algo de diversión? Que aburrido.");
        }
        if(barraCarga.getValue()==70) {
        	dialogoMystra.setVisible(false);
        	dialogoTomberi.setVisible(true);
        	dialogoTomberi.setText("Ni caso, no saben de la vida. Toma esto.");
        }
        if(barraCarga.getValue()==90) {
        	dialogoTomberi.setVisible(false);
        	recompensaHeroe.setVisible(true); 	
        	clases.Npc.recompensasNpc(ventana.npcsArray.get(1),ventana.heroe, recompensaHeroe);
        }
        if(barraCarga.getValue()==100) {
        	timer.stop();
        	botonSalir.setVisible(true);
        }
	}
	public void eventoLegal() {
		if(barraCarga.getValue()==10) {
    		dialogoNarcyl.setVisible(true);
        	dialogoNarcyl.setText("Eres compasivo y leal. Me alegro de haberte seguido.");
        }
        if(barraCarga.getValue()==30) {
        	dialogoNarcyl.setVisible(false);
        	dialogoTomberi.setVisible(true);
        	dialogoTomberi.setText("Pensaba que a ti solo te importaba la comida, pero parece que también tienes sentimientos. No me gusta.");
        }
        if(barraCarga.getValue()==50) {
        	dialogoTomberi.setVisible(false);
        	dialogoMystra.setVisible(true);
        	dialogoMystra.setText("¿Desde cuándo  un pollo de granja se dedica a salvar humanos? Ellos esclavizan a los tuyos.");
        }
        if(barraCarga.getValue()==70) {
        	dialogoMystra.setVisible(false);
        	dialogoNarcyl.setVisible(true);
        	dialogoNarcyl.setText("No les hagas caso, toma te lo has ganado ^_^");
        }
        if(barraCarga.getValue()==90) {
        	dialogoNarcyl.setVisible(false);
        	recompensaHeroe.setVisible(true); 	
        	clases.Npc.recompensasNpc(ventana.npcsArray.get(0),ventana.heroe, recompensaHeroe);
        }
        if(barraCarga.getValue()==100) {
        	timer.stop();
        	botonSalir.setVisible(true);
        }
	}
	
	public void eventoLegalMas() {
		if(barraCarga.getValue()==10) {
    		dialogoNarcyl.setVisible(true);
        	dialogoNarcyl.setText("No sabía que un pollo de granja pudiera ser un héroe. Estoy muy orgullosa.");
        }
        if(barraCarga.getValue()==30) {
        	dialogoNarcyl.setVisible(false);
        	dialogoTomberi.setVisible(true);
        	dialogoTomberi.setText("Tenias potencial, pero lo has echado todo a perder.");
        }
        if(barraCarga.getValue()==50) {
        	dialogoTomberi.setVisible(false);
        	dialogoMystra.setVisible(true);
        	dialogoMystra.setText("Tienes el poder necesario para hacer lo que quieras, pero eliges la senda del bien. Decepcionante.");
        }
        if(barraCarga.getValue()==70) {
        	dialogoMystra.setVisible(false);
        	dialogoNarcyl.setVisible(true);
        	dialogoNarcyl.setText("No les hagas caso, toma te lo has ganado ^_^");
        }
        if(barraCarga.getValue()==90) {
        	dialogoNarcyl.setVisible(false);
        	recompensaHeroe.setVisible(true); 	
        	clases.Npc.recompensasNpc(ventana.npcsArray.get(0), ventana.heroe, recompensaHeroe);
        }
        if(barraCarga.getValue()==100) {
        	timer.stop();
        	botonSalir.setVisible(true);
        }
	}
}
