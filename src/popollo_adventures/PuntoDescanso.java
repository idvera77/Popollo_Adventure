package popollo_adventures;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import clases.Heroe;
import componentes.Botones;
import componentes.Paneles;
import componentes.PanelTexto;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class PuntoDescanso extends Paneles{
	public PuntoDescanso(JFrame ventana, Heroe heroe, Connection connect) {
		Paneles panelDescanso=this;
		
		//Añadiendo botones
		Botones botonCuracion = new Botones("Curacion");
		botonCuracion.setText("Curar heridas - 350");
		botonCuracion.setBounds(374, 326, 262, 23);
		add(botonCuracion);
		
		Botones botonRecargaHabilidades = new Botones("Cargar Partida");
		botonRecargaHabilidades.setText("Recargar habilidades - 750");
		botonRecargaHabilidades.setBounds(374, 360, 262, 23);
		add(botonRecargaHabilidades);
			
		Botones botonRecuperacionCompleta = new Botones("Galeria");
		botonRecuperacionCompleta.setText("Recuperacion completa - 1000");
		botonRecuperacionCompleta.setBounds(374, 395, 262, 23);
		add(botonRecuperacionCompleta);
		
		Botones botonAtras = new Botones("Volver al mapa");
		botonAtras.setBounds(709, 428, 215, 23);
		add(botonAtras);
		
		//Imagen de fondo
		JLabel imagenDescanso = new JLabel("");
		imagenDescanso.setBounds(0, 0, 1008, 536);
		imagenDescanso.setIcon(new ImageIcon("./imagenes/descanso.jpg"));
		add(imagenDescanso);	
		
		PanelTexto panelDinero = new PanelTexto();
		panelDinero.setText(" Oro: "+heroe.getDinero());
		panelDinero.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelDinero.setBounds(815, 107, 109, 25);
		add(panelDinero);
		
		//Eventos de botones
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Mapa panelMapa =new Mapa(ventana, connect);
				ventana.setContentPane(panelMapa);
				panelDescanso.setVisible(false);
			}
		});		
		
	}
}
