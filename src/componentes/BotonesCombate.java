package componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class BotonesCombate extends JButton {
		public BotonesCombate(String txt) {
			super(txt);
			setBorder(new LineBorder(new Color(0, 0, 0), 3));
			setBackground(new Color(240,240,240));
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
