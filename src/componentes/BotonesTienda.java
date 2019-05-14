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

public class BotonesTienda extends JButton {
    public BotonesTienda(String txt) {
        super(txt);

        //cursor para botones
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("./recursos/monedas.png");
        Point point = new Point(0, 0);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        cursor = toolkit.createCustomCursor(img, point, "./recursos/monedas.png");
        setCursor(cursor);

        setFont(new Font("Bahnschrift", Font.PLAIN, 16));	
        setBorder(new LineBorder(new Color(0, 0, 0), 2));

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
