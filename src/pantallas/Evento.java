package pantallas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import clases.Heroe;
import componentes.Botones;
import componentes.BotonesDialogo;
import componentes.LabelTextoOtros;
import componentes.LabelTextoPrincipal;
import componentes.Paneles;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Evento extends Paneles{
	private Ventana ventana;
	public LabelTextoOtros eventoTexto, eventoInicio;
	public Botones botonAtras;
	public BotonesDialogo opcion1, opcion2, opcion3;
	private Heroe heroe;
	private int opcion;
	
	public Evento(Ventana ventana, int evento) {
		super();
		this.ventana=ventana;
		this.heroe=ventana.heroe;
		
		//Añadir Botones
		opcion1 = new BotonesDialogo("");
		opcion1.setBounds(244, 294, 520, 30);
		add(opcion1);
		
		opcion2 = new BotonesDialogo("");
		opcion2.setBounds(244, 333, 520, 30);
		add(opcion2);
		
		opcion3 = new BotonesDialogo("");
		opcion3.setBounds(244, 372, 520, 30);
		add(opcion3);
		
		botonAtras = new Botones ("Volver");
		botonAtras.setVisible(false);
		botonAtras.setBounds(709, 428, 215, 23);
		add(botonAtras);
	
		//Paneles Texto
		eventoTexto = new LabelTextoOtros();
		eventoTexto.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		eventoTexto.setBounds(10, 132, 988, 151);
		add(eventoTexto);
		
		//Imagen de fondo
		JLabel imagenBatalla = new JLabel("");
		imagenBatalla.setBounds(0, 0, 1008, 536);
		imagenBatalla.setIcon(new ImageIcon("./recursos/imagenes/batalla.jpg"));
		add(imagenBatalla);	
		
		elegirEvento(evento, opcion);
		
		//Eventos Botones
		opcion1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				elegirEvento(evento, 1);
				ocultarBotones();
			}
		});
		
		opcion2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				elegirEvento(evento, 2);
				ocultarBotones();
			}
		});
		
		opcion3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				elegirEvento(evento, 3);
				ocultarBotones();
			}
		});	
		
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.origenADestino(ventana, "evento", "principal", 0);
			}
		});
	}
	
	public void ocultarBotones () {
		opcion1.setVisible(false);
		opcion2.setVisible(false);
		opcion3.setVisible(false);
		botonAtras.setVisible(true);
	}
	
	public void elegirEvento(int evento, int opcion) {
		switch(evento) {
			case 0:
				general.Eventos.vagabundo(ventana, ventana.heroe, eventoTexto, opcion1, opcion2, opcion3, opcion);
				break;
			case 1:
				general.Eventos.rescateAldeanos(ventana, heroe, eventoTexto, opcion1, opcion2, opcion3, opcion);
				break;
			case 2:
				general.Eventos.criasPoring(ventana, heroe, eventoTexto, opcion1, opcion2, opcion3, opcion);
				break;
			case 3:
				break;
			case 4:
				break;
		}
	}
}
