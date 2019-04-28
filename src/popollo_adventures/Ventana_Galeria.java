package popollo_adventures;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import clases.Objeto;

public class Ventana_Galeria extends JFrame{
	public Ventana_Galeria() {		
		
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
}
