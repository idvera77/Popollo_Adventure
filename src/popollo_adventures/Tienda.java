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


public class Tienda extends JPanel{
	
	public Tienda(JFrame ventana, clases.Heroe heroe) {
		JPanel panelTienda=this;
		this.setSize(1008, 536);
		setLayout(null);
		setBackground(new Color(176, 224, 230));
		
		JLabel imagenTienda = new JLabel("");
		imagenTienda.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		imagenTienda.setBounds(108, 63, 784, 279);
		add(imagenTienda);
		
		
		JButton boton2 = new JButton("boton2");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boton2.setBounds(415, 353, 165, 23);
		add(boton2);
		
		JButton boton1 = new JButton("boton1");
		boton1.setBounds(240, 353, 165, 23);
		add(boton1);
		
		JButton boton = new JButton("boton3");
		boton.setBounds(590, 353, 165, 23);
		add(boton);
		
		JButton boton5 = new JButton("boton5");
		boton5.setBounds(502, 387, 165, 23);
		add(boton5);
		
		JButton boton4 = new JButton("boton4");
		boton4.setBounds(327, 387, 165, 23);
		add(boton4);
		
		JButton botonAtras = new JButton("Volver al menu");
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Portada panelPortada=new Portada(ventana);
				ventana.setContentPane(panelPortada);
				panelTienda.setVisible(false);
			}
		});
		botonAtras.setBounds(415, 445, 165, 23);
		add(botonAtras);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(327, 29, 340, 23);
		heroe.getDinero();
		add(textPane);
	

		
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
