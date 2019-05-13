package pantallas;

import clases.Heroe;
import componentes.Botones;
import componentes.Paneles;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.SystemColor;

public class Creditos extends Paneles{
	private Ventana ventana;
	private JLabel mensajeStaff, mensajeNombre;
	private Timer timer;
	JProgressBar barraCarga;
	
	public Creditos (Ventana ventana) {
		super();
		setBackground(Color.BLACK);
		this.ventana=ventana;
		
		//Sonido
		String rutaSonido = "./recursos/sonidos/Katz.wav";
		general.Musica.sonidosBoton(rutaSonido);
				
		mensajeStaff = new JLabel();
		mensajeStaff.setFont(new Font("Bahnschrift", Font.PLAIN, 50));
		mensajeStaff.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeStaff.setForeground(Color.WHITE);
		mensajeStaff.setBounds(101, 121, 790, 104);
		add(mensajeStaff);
		
		mensajeNombre = new JLabel();
		mensajeNombre.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		mensajeNombre.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeNombre.setForeground(Color.WHITE);
		mensajeNombre.setBounds(101, 190, 790, 127);
		add(mensajeNombre);
		
		JButton  botonSalir = new JButton ("Salir del Juego");
		botonSalir.setBounds(767, 487, 215, 23);
		botonSalir.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		add(botonSalir);
		
		barraCarga = new JProgressBar();
        add(barraCarga);
       
        //Esta preparado por si quiero usar mas pantallas de carga.
        ActionListener updateBarraCargar = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            barraCarga.setValue((barraCarga.getValue()+1));  
            if(barraCarga.getValue()==5) {
            	mensajeStaff.setText("Director");
            }
            if(barraCarga.getValue()==7) {
            	mensajeNombre.setText("Iván Díaz Vera");
            }
            if(barraCarga.getValue()==12) {
            	mensajeStaff.setVisible(false);
            	mensajeNombre.setVisible(false);
            }
            if(barraCarga.getValue()==16) {
            	mensajeStaff.setVisible(true);
            	mensajeStaff.setText("Productor");
            }
            if(barraCarga.getValue()==18) {
            	mensajeNombre.setVisible(true);
            	mensajeNombre.setText("Iván Díaz Vera");
            }
            if(barraCarga.getValue()==23) {
            	mensajeStaff.setVisible(false);
            	mensajeNombre.setVisible(false);
            }
            if(barraCarga.getValue()==27) {
            	mensajeStaff.setVisible(true);
            	mensajeStaff.setText("Dirección Artística");
            }
            if(barraCarga.getValue()==29) {
            	mensajeNombre.setVisible(true);
            	mensajeNombre.setText("Ana Belén Molina González");
            }
            if(barraCarga.getValue()==34) {
            	mensajeStaff.setVisible(false);
            	mensajeNombre.setVisible(false);
            }
            if(barraCarga.getValue()==36) {
            	mensajeNombre.setVisible(true);
            	mensajeNombre.setText("Basado en hechos MUY reales.");
            }
            if(barraCarga.getValue()==41) {
            	mensajeNombre.setVisible(false);
            }
            if(barraCarga.getValue()==45) {
            	mensajeNombre.setVisible(true);
            	mensajeNombre.setText("<html>Adaptación de la novela autobiográfica<br> <center>\"Un pollo con mucha hambre\"</center></html>");
            }
            if(barraCarga.getValue()==51) {
            	mensajeNombre.setVisible(false);
            }
            if(barraCarga.getValue()==55) {
            	mensajeNombre.setVisible(true);
            	mensajeNombre.setText("<html>Ningún pollo fue herido durante el desarrollo de este juego.</html>");
            }
            if(barraCarga.getValue()==60) {
            	mensajeNombre.setVisible(false);
            }
            if(barraCarga.getValue()==64) {
            	mensajeNombre.setVisible(true);
            	mensajeNombre.setText("<html><center>Muchas gracias por jugar.</center><br>Nos vemos en el siguiente juego ^_^</html>");
            }
            if(barraCarga.getValue()==100) {
            	
            	timer.stop();
            }
          }  
        };
        
        timer = new Timer(500, updateBarraCargar);
        timer.start(); 
		
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int exit = JOptionPane.showConfirmDialog(null, "¿Estas seguro?" , " Cerrar Programa", 
						JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (exit == JOptionPane.YES_OPTION){
					if(ventana.getConnect()!=null) {
						try {
							ventana.getConnect().close();
						} catch (SQLException e1) {
						//No importa el error que pueda transmitir en este caso.
						}
					}	
				    System.exit(0);
				}	
			}
		});
	}	
}
