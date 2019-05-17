package pantallas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import componentes.Botones;
import componentes.LabelPrincipal;
import componentes.Paneles;
import clases.Heroe;

import java.awt.Color;
import java.awt.Font;

public class Descanso extends Paneles{
    private Ventana ventana;
    private Heroe heroe;
	
    public Descanso(Ventana ventana) {
        super();
        this.ventana=ventana;
        this.heroe=ventana.heroe;

        //Archivos de sonido
        String sonidoCuracion = "./recursos/sonidos/Curaciones.wav";
        String sonidoNoMoney = "./recursos/sonidos/NoMoney.wav";
        
        Random r = new Random();
        String [] consejoFrase = {"Intenta descansar cada 45 minutos de juego", "Trata bien al pequeño Popollo"};
        
        LabelPrincipal fraseNarcyl = new LabelPrincipal();
        fraseNarcyl.setText(consejoFrase[r.nextInt(consejoFrase.length)]);
        fraseNarcyl.setBounds(207, 215, 305, 40);
        add(fraseNarcyl);
        
        JLabel imagenHeroe = new JLabel("");
        imagenHeroe.setBounds(10, 225, 261, 300);
        imagenHeroe.setIcon(new ImageIcon("./recursos/imagenes/narcylDescanso.png"));
        add(imagenHeroe);

        LabelPrincipal mostrarDinero = new LabelPrincipal();
        mostrarDinero.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        mostrarDinero.setText("<html><center><b>Oro:&ensp;"+Integer.toString(heroe.getDinero())
            +"</b></center></html>");
        mostrarDinero.setBounds(10, 29, 109, 40);
        add(mostrarDinero);

        //Añadiendo botones
        Botones botonCuracion = new Botones("Curar heridas - 350");
        botonCuracion.setBounds(374, 377, 262, 23);
        add(botonCuracion);

        Botones botonRecuperacionCompleta = new Botones("Recuperación completa - 750");
        botonRecuperacionCompleta.setBounds(374, 411, 262, 23);
        add(botonRecuperacionCompleta);

        Botones botonAtras = new Botones("Volver al mapa");
        botonAtras.setBounds(767, 487, 215, 23);
        add(botonAtras);
		
        //Eventos de boton. Llaman a la funcion puntoDescanso de la clase Heroe y una vez realizada vuelve a mostrar el dinero restante.
        botonCuracion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                heroe.puntoDescanso(0, sonidoCuracion, sonidoNoMoney);
                mostrarDinero.setText(" Oro: "+Integer.toString(heroe.getDinero()));
            }
        });

        botonRecuperacionCompleta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	heroe.puntoDescanso(1,sonidoCuracion, sonidoNoMoney);
                mostrarDinero.setText(" Oro: "+Integer.toString(heroe.getDinero()));
            }
        });
        
        //Nos permite ir hacia la pantalla principal.
        botonAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.origenADestino(ventana, "descanso", "principal", 0);
            }
        });
        
        //Imagen de fondo
        JLabel imagenDescanso = new JLabel("");
        imagenDescanso.setBounds(0, 0, 1008, 536);
        imagenDescanso.setIcon(new ImageIcon("./recursos/imagenes/descanso.jpg"));
        add(imagenDescanso);
    }
}
