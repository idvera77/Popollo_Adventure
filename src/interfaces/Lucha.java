package interfaces;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import componentes.Botones;
import componentes.PanelTexto;
import componentes.Paneles;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Lucha extends Paneles{
	private Ventana ventana;
	private JTextField textField;
	
	public Lucha(Ventana v) {
		super();
		this.ventana=v;
		ImageIcon[] imagenes = new ImageIcon[4];
		imagenes[0] = new ImageIcon(".\\imagenes\\luchaPopollo.png");
		imagenes[1] = new ImageIcon(".\\imagenes\\Morrigan.png");
		imagenes[2] = new ImageIcon(".\\imagenes\\dancer low.png");	
		imagenes[3] = new ImageIcon(".\\imagenes\\luchaPoring.png");
		
		JProgressBar vidaHeroe = new JProgressBar();
		vidaHeroe.setBounds(20, 262, 241, 34);
		add(vidaHeroe);
		
		JProgressBar vidaEnemigo = new JProgressBar();
		vidaEnemigo.setBounds(746, 262, 241, 34);
		add(vidaEnemigo);
		
		//Añadiendo Botones
		Botones botonAtacar = new Botones("Atacar");
		botonAtacar.setBounds(155, 322, 165, 23);
		add(botonAtacar);
		
		Botones botonDefender = new Botones("Defensa");
		botonDefender.setBounds(334, 322, 165, 23);
		add(botonDefender);
		
		Botones botonHabilidades = new Botones("Habilidades");
		botonHabilidades.setBounds(509, 322, 165, 23);
		add(botonHabilidades);
		
		Botones botonObjetos = new Botones("Objetos");
		botonObjetos.setBounds(684, 322, 165, 23);
		add(botonObjetos);
		
		Botones botonAtras = new Botones("Volver al mapa");
		botonAtras.setBounds(709, 428, 215, 23);
		add(botonAtras);
		
		JTextField  combate = new JTextField ();
		combate.setFont(new Font("Bahnschrift", Font.BOLD | Font.ITALIC, 15));
		combate.setHorizontalAlignment(SwingConstants.CENTER);
		combate.setText(ventana.enemigosArray.get(0).getNombre());
		combate.setBounds(271, 23, 465, 270);
		add(combate);
		
		//JLabel donde se muestra las imagenes de la galeria
		JLabel imagenHeroe = new JLabel("");
		imagenHeroe.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		imagenHeroe.setBounds(10, 11, 261, 300);
		imagenHeroe.setIcon(imagenes[0]);
		add(imagenHeroe);
		
		//JLabel donde se muestra las imagenes de la galeria
		JLabel imagenEnemigo = new JLabel("");
		imagenEnemigo.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		imagenEnemigo.setBounds(737, 11, 261, 300);
		imagenEnemigo.setIcon(imagenes[3]);
		add(imagenEnemigo);
		
		
		//Eventos de botones
		botonAtacar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.heroe.atacar(ventana.heroe, ventana.enemigosArray.get(0));
				System.out.println(ventana.enemigosArray.get(0).getSalud());
			}
		});
		
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.volverPantallaPrincipal("Batalla");
			}
		});
	}	
}

