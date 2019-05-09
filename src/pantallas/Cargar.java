package pantallas;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import componentes.LabelTexto;
import componentes.Paneles;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class Cargar extends Paneles{
	private Ventana ventana;
	private JProgressBar barraCarga;
	private LabelTexto consejos;
    private JLabel imagenFondo = new JLabel("", JLabel.CENTER);
    private Timer timer;
    
	public Cargar(Ventana v) {
		super();
		this.ventana=v;

		setBackground(Color.BLACK);
		consejos = new LabelTexto();
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
       
        ActionListener updateBarraCargar = new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            barraCarga.setValue((barraCarga.getValue()+2));  
            if(barraCarga.getValue()==100) {
            	ventana.cargarPantallaPrincipal();
            	timer.stop();
            }
          }  
        };
        
        
        
      
        timer = new Timer(50, updateBarraCargar);
        addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				timer.start();
			}
        	@Override
        	public void mouseExited(MouseEvent arg0) {
        		timer.start();
        	}
        });   
        
        String [] consejoFrase = {"Miguel es el Mal en Persona"};
        
        consejos.setText(consejoFrase[0]);
	
}
}
