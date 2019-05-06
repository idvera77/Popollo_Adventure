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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		vidaHeroe.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		vidaHeroe.setStringPainted(true);
		vidaHeroe.setForeground(Color.RED);
		vidaHeroe.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		vidaHeroe.setBounds(20, 290, 241, 34);
		vidaHeroe.setValue(ventana.heroe.getSalud());
		add(vidaHeroe);
		
		JProgressBar vidaEnemigo = new JProgressBar(0, ventana.enemigosArray.get(0).getSaludMaxima());
		vidaEnemigo.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		vidaEnemigo.setStringPainted(true);
		vidaEnemigo.setForeground(Color.RED);
		vidaEnemigo.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		vidaEnemigo.setBounds(747, 290, 241, 34);
		vidaEnemigo.setValue(ventana.enemigosArray.get(0).getSalud());
		add(vidaEnemigo);
		
		Botones botonAtacar = new Botones("Atacar");
		botonAtacar.setBounds(145, 367, 165, 23);
		add(botonAtacar);
		
		Botones botonDefender = new Botones("Defensa");
		botonDefender.setBounds(320, 367, 165, 23);
		add(botonDefender);
		
		
		Botones botonHabilidades = new Botones("Habilidades");
		botonHabilidades.setBounds(495, 367, 165, 23);
		add(botonHabilidades);
		
		Botones botonObjetos = new Botones("Objetos");
		botonObjetos.setBounds(670, 367, 165, 23);
		add(botonObjetos);
		
		Botones boton1 = new Botones("1");
		boton1.setVisible(false);
		boton1.setBounds(242, 367, 165, 23);
		add(boton1);
		
		Botones boton2 = new Botones("2");
		boton2.setVisible(false);
		boton2.setBounds(417, 367, 165, 23);
		add(boton2);
		
		Botones boton3 = new Botones("3");
		boton3.setVisible(false);
		boton3.setBounds(592, 367, 165, 23);
		add(boton3);
		
		Botones botonAtras = new Botones("Volver al mapa");
		botonAtras.setBounds(709, 428, 215, 23);
		add(botonAtras);
		
		
		//Eventos de botones
		botonAtacar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.heroe.atacar(ventana.heroe, ventana.enemigosArray.get(0));
				System.out.println(ventana.enemigosArray.get(0).getSalud());
				vidaEnemigo.setValue(ventana.enemigosArray.get(0).getSalud());
			}
		});
		
		botonDefender.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		botonHabilidades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonAtacar.setVisible(false);
				botonDefender.setVisible(false);
				botonHabilidades.setVisible(false);
				botonObjetos.setVisible(false);
				boton1.setVisible(true);
				boton2.setVisible(true);
				boton3.setVisible(true);
			}
		});
		
		botonObjetos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonAtacar.setVisible(false);
				botonDefender.setVisible(false);
				botonHabilidades.setVisible(false);
				botonObjetos.setVisible(false);
				boton1.setVisible(true);
				boton2.setVisible(true);
				boton3.setVisible(true);
			}
		});
		
		boton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boton1.setVisible(false);
				boton2.setVisible(false);
				boton3.setVisible(false);
				botonAtacar.setVisible(true);
				botonDefender.setVisible(true);
				botonHabilidades.setVisible(true);
				botonObjetos.setVisible(true);
			}
		});
		
		boton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boton1.setVisible(false);
				boton2.setVisible(false);
				boton3.setVisible(false);
				botonAtacar.setVisible(true);
				botonDefender.setVisible(true);
				botonHabilidades.setVisible(true);
				botonObjetos.setVisible(true);
			}
		});

		boton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boton1.setVisible(false);
				boton2.setVisible(false);
				boton3.setVisible(false);
				botonAtacar.setVisible(true);
				botonDefender.setVisible(true);
				botonHabilidades.setVisible(true);
				botonObjetos.setVisible(true);
			}
		});
		
		
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.volverPantallaPrincipal("Batalla");
			}
		});
		
		//JLabel donde se muestra las imagenes de la galeria
		JLabel imagenHeroe = new JLabel("");
		imagenHeroe.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		imagenHeroe.setBounds(10, 36, 261, 300);
		imagenHeroe.setIcon(imagenes[0]);
		add(imagenHeroe);
		
		//JLabel donde se muestra las imagenes de la galeria
		JLabel imagenEnemigo = new JLabel("");
		imagenEnemigo.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		imagenEnemigo.setBounds(737, 36, 261, 300);
		imagenEnemigo.setIcon(imagenes[3]);
		add(imagenEnemigo);
	}	
}

