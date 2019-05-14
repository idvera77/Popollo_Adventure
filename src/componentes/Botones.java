package componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Botones extends JButton {
    public Botones(String txt) {
        super(txt);
    	
        //Usando Toolkit cambiamos el cursor por defecto cuando pulsamos dentro de estos Botones.
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("./recursos/normal.png");
        Point point = new Point(0, 0);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        cursor = toolkit.createCustomCursor(img, point, "./recursos/normal.png");
        setCursor(cursor);
        
        //Indicando la fuente y el borde de los botones.
        setFont(new Font("Bahnschrift", Font.PLAIN, 16));	
        setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
        //Cuando entramos en un boton debe cambiar de color, engordar el borde y al salir debe volver a su estado original.
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                setFont(new Font("Bahnschrift", Font.BOLD, 16));
                setBackground(new Color(204, 255, 255));
                setBorder(new LineBorder(new Color(0, 0, 0), 3));			
            }
            
            @Override
            public void mouseExited(MouseEvent e) {	
                setFont(new Font("Bahnschrift", Font.PLAIN, 16));		
                setBackground(null);
                setBorder(new LineBorder(new Color(0, 0, 0), 2));
            }
        });	
    }
}
