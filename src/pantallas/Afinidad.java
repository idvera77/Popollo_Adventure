package pantallas;

import componentes.Paneles;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;

public class Afinidad extends Paneles {
	private Ventana ventana;
	
	public Afinidad(Ventana ventana) {
	super();
    this.ventana=ventana;
    
    //Imagenes
    ImageIcon[] imagenEnemigoBatalla = new ImageIcon[6];
    imagenEnemigoBatalla[0] = new ImageIcon("./recursos/imagenes/combate/popollo.gif");
    imagenEnemigoBatalla[1] = new ImageIcon("./recursos/imagenes/combate/poi.gif");
    imagenEnemigoBatalla[2] = new ImageIcon("./recursos/imagenes/combate/nigromante.gif");
    imagenEnemigoBatalla[3] = new ImageIcon("./recursos/imagenes/combate/deviling.gif");
    
    JLabel imagenHeroe = new JLabel("");
    imagenHeroe.setBounds(41, 179, 261, 300);
    imagenHeroe.setIcon(imagenEnemigoBatalla[0]);
    add(imagenHeroe);
    
    JLabel imagenMystra = new JLabel("");
    imagenMystra.setIcon(imagenEnemigoBatalla[1]);
    imagenMystra.setBounds(712, 218, 261, 300);
    add(imagenMystra);
    
    JLabel imagenNarcyl = new JLabel("");
    imagenNarcyl.setBounds(390, 22, 261, 300);
    imagenNarcyl.setIcon(imagenEnemigoBatalla[2]);
    add(imagenNarcyl);
    
    JLabel imagenTomberi = new JLabel("");
    imagenTomberi.setBounds(547, 126, 261, 300);
    imagenTomberi.setIcon(imagenEnemigoBatalla[3]);
    add(imagenTomberi);
    
    JLabel marcoEvento = new JLabel("");
    marcoEvento.setBackground(Color.YELLOW);
    marcoEvento.setOpaque(true);
    marcoEvento.setBounds(21, 22, 969, 496);
    add(marcoEvento);
    
    //Imagen de fondo
    JLabel imagenFondo = new JLabel("");
    imagenFondo.setBounds(0, 0, 1008, 536);
    imagenFondo.setIcon(new ImageIcon("./recursos/imagenes/batalla.jpg"));
    add(imagenFondo);	
    
    
	}
}
