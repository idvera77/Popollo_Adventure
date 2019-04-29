package popollo_adventures;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Galeria extends JPanel{
	
	public Galeria(JFrame ventana) {
		JPanel panelGaleria=this;
		this.setSize(1008, 536);
		setLayout(null);
		setBackground(new Color(176, 224, 230));
		
		ImageIcon[] imagenes = new ImageIcon[3];
		imagenes[0] = new ImageIcon(".\\imagenes\\Morrigan.png");
		imagenes[1] = new ImageIcon(".\\imagenes\\dancer low.png");	
		imagenes[2] = new ImageIcon(".\\imagenes\\casita.png");
		
		JLabel imagenGaleria = new JLabel("");
		imagenGaleria.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		imagenGaleria.setBounds(69, 33, 406, 466);
		imagenGaleria.setIcon(imagenes[0]);
		add(imagenGaleria);
		
		
		JButton botonPuntoDescanso = new JButton("Punto Descanso");
		botonPuntoDescanso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonPuntoDescanso.setBounds(548, 329, 165, 23);
		add(botonPuntoDescanso);
		
		JButton botonPopollo = new JButton("Popollo");
		botonPopollo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imagenGaleria.setIcon(imagenes[1]);
			}
		});
		botonPopollo.setBounds(548, 100, 165, 23);
		add(botonPopollo);
		
		JButton botonMystra = new JButton("Mystra");
		botonMystra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonMystra.setBounds(548, 176, 165, 23);
		add(botonMystra);
		
		JButton botonNarcyl = new JButton("Narcyl");
		botonNarcyl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonNarcyl.setBounds(548, 255, 165, 23);
		add(botonNarcyl);
		
		JButton botonTomberi = new JButton("Tomberi");
		botonTomberi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonTomberi.setBounds(548, 400, 165, 23);
		add(botonTomberi);
		
		JButton botonPoring = new JButton("Poring");
		botonPoring.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonPoring.setBounds(759, 100, 165, 23);
		add(botonPoring);
		
		JButton botonNigromante = new JButton("Nigromante");
		botonNigromante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonNigromante.setBounds(759, 176, 165, 23);
		add(botonNigromante);
		
		JButton botonGolem = new JButton("Golem");
		botonGolem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonGolem.setBounds(759, 255, 165, 23);
		add(botonGolem);
		
		JButton botonGoblin = new JButton("Goblin");
		botonGoblin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonGoblin.setBounds(759, 329, 165, 23);
		add(botonGoblin);
		
		JButton botonPulpoi = new JButton("Pulpoi");
		botonPulpoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonPulpoi.setBounds(759, 400, 165, 23);
		add(botonPulpoi);
		
		JButton botonAtras = new JButton("Volver al menu");
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Portada panelPortada=new Portada(ventana);
				ventana.setContentPane(panelPortada);
				panelGaleria.setVisible(false);
			}
		});
		botonAtras.setBounds(657, 459, 165, 23);
		add(botonAtras);
	

		
	}		
}
	
	
	
	
	
	
	/**
	 * import javax.swing.JPanel;
import javax.swing.JLabel;


public Galeria() {		
		
		ImageIcon[] imagenes = new ImageIcon[3];
		imagenes[0] = new ImageIcon(".\\imagenes\\Morrigan.png");
		imagenes[1] = new ImageIcon(".\\imagenes\\dancer low.png");	
		imagenes[2] = new ImageIcon(".\\imagenes\\casita.png");
		
		setTitle("Popollo Adventure - Galeria");
		getContentPane().setBackground(new Color(176, 224, 230));
		setSize(new Dimension(1024, 576));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(69, 33, 406, 466);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel imagen1 = new JLabel("");
		imagen1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		imagen1.setIcon(imagenes[0]);
		imagen1.setBounds(0, 0, 406, 466);
		panel.add(imagen1);
		
		JButton botonSiguiente = new JButton("Siguiente");
		botonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imagen1.setIcon(imagenes[1]);
			}
		});
		botonSiguiente.setBounds(530, 355, 215, 23);
		getContentPane().add(botonSiguiente);
		

		JButton botonAtras = new JButton("Atras");
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imagen1.setIcon(imagenes[0]);
			}
		});
		botonAtras.setBounds(530, 390, 215, 23);
		getContentPane().add(botonAtras);
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.setBounds(530, 424, 215, 23);
		getContentPane().add(botonSalir);
		
	}
	 */
