package componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Botones extends JButton {
	public Botones(String txt) {
		super(txt);

		setFont(new Font("Bahnschrift", Font.PLAIN, 16));	
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
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
