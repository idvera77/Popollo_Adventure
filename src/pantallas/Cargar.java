package pantallas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JProgressBar;
import javax.swing.Timer;

import componentes.LabelTextoPrincipal;
import componentes.Paneles;
import java.awt.Color;
import java.util.Random;
import java.awt.Font;
import java.awt.SystemColor;

public class Cargar extends Paneles{
	private Ventana ventana;
	private JProgressBar barraCarga;
	private LabelTextoPrincipal consejos;
    private Timer timer;

	public Cargar(Ventana ventana) {
		super();
		this.ventana=ventana;

		setBackground(Color.BLACK);
		consejos = new LabelTextoPrincipal();
		consejos.setBackground(SystemColor.controlHighlight);
		consejos.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        consejos.setBounds(10, 217, 988, 63);
        add(consejos);
        
        barraCarga = new JProgressBar();
        barraCarga.setStringPainted(true);
        barraCarga.setFont(new Font("Bahnschrift", Font.BOLD, 25));
        barraCarga.setForeground(SystemColor.inactiveCaption);
        barraCarga.setBackground(Color.BLACK);
        barraCarga.setBounds(10, 318, 988, 63);
        add(barraCarga);
       
        Random r = new Random();
        String [] consejoFrase = {"Intenta descansar cada 45 minutos de juego", "Trata bien al pequeño Popollo"};
        consejos.setText(consejoFrase[r.nextInt(consejoFrase.length)]);
        
        //Esta preparado por si quiero usar mas pantallas de carga.
        ActionListener updateBarraCargar = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            barraCarga.setValue((barraCarga.getValue()+3));  
            if(barraCarga.getValue()==100) {
            	ventana.cargarPantallaPrincipal();
            	timer.stop();
            }
          }  
        };
        
        timer = new Timer(50, updateBarraCargar);
        timer.start(); 
	}
}

