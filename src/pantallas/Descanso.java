package pantallas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import componentes.Botones;
import componentes.LabelTexto;
import componentes.Paneles;
import componentes.PanelTexto;
import javax.swing.border.LineBorder;

import clases.Heroe;

import java.awt.Color;
import java.awt.Font;

public class Descanso extends Paneles{
	private Ventana ventana;
	private Heroe heroe;
	
	public Descanso(Ventana v) {
		super();
		this.ventana=v;
		this.heroe=ventana.heroe;
		
		//Sonido
		String rutaSonido = "./recursos/sonidos/Curaciones.wav";
		
		LabelTexto mostrarDinero = new LabelTexto();
		mostrarDinero.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		mostrarDinero.setText("<html><center><b>Oro:&ensp;"+Integer.toString(heroe.getDinero())
				+"</b></center></html>");
		mostrarDinero.setBounds(10, 29, 109, 40);
		add(mostrarDinero);
		
		//Añadiendo botones
		Botones botonCuracion = new Botones("Curar heridas - 350");
		botonCuracion.setBounds(374, 326, 262, 23);
		add(botonCuracion);
		
		Botones botonRecargaHabilidades = new Botones("Recargar habilidades - 750");
		botonRecargaHabilidades.setBounds(374, 360, 262, 23);
		add(botonRecargaHabilidades);
			
		Botones botonRecuperacionCompleta = new Botones("Recuperacion completa - 1000");
		botonRecuperacionCompleta.setBounds(374, 395, 262, 23);
		add(botonRecuperacionCompleta);
		
		Botones botonAtras = new Botones("Volver al mapa");
		botonAtras.setBounds(709, 428, 215, 23);
		add(botonAtras);
		
		//Imagen de fondo
		JLabel imagenDescanso = new JLabel("");
		imagenDescanso.setBounds(0, 0, 1008, 536);
		imagenDescanso.setIcon(new ImageIcon("./recursos/imagenes/descanso.jpg"));
		add(imagenDescanso);	
	
		
		//Eventos de botones
		botonCuracion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				heroe.puntoDescanso(0, rutaSonido);
				mostrarDinero.setText(" Oro: "+Integer.toString(heroe.getDinero()));
			}
		});
		
		botonRecargaHabilidades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				heroe.puntoDescanso(1,rutaSonido);
				mostrarDinero.setText(" Oro: "+Integer.toString(heroe.getDinero()));
			}
		});
		
		botonRecuperacionCompleta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				heroe.puntoDescanso(2,rutaSonido);
				mostrarDinero.setText(" Oro: "+Integer.toString(heroe.getDinero()));
			}
		});
		
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.volverPantallaPrincipal("Descanso");
			}
		});		
	}
}
