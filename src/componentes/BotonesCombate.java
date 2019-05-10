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

public class BotonesCombate extends JButton {
		public BotonesCombate(String txt) {
			super(txt);
			
			//cursor para botones
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Image img = toolkit.getImage("./recursos/batalla.png");
			Point point = new Point(0, 0);
			Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
			cursor = toolkit.createCustomCursor(img, point, "./recursos/batalla.png");
			setCursor(cursor);
			
			setBorder(new LineBorder(new Color(0, 0, 0), 3));
			setBackground(new Color(240,240,240));
			setCursor(cursor);
			setBorder(new LineBorder(new Color(0, 0, 0), 3));	
			addMouseListener(new MouseAdapter(){
				@Override
				public void mouseEntered(MouseEvent e) {
					setBackground(new Color(204, 255, 255));
					setBorder(new LineBorder(new Color(0, 0, 0), 3));			
				}
				
				@Override
				public void mouseExited(MouseEvent e) {		
					setBackground(null);
					setBorder(new LineBorder(new Color(0, 0, 0), 3));
				}
			});	
		}
}
