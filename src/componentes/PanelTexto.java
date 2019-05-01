package componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class PanelTexto extends JTextPane {
	public PanelTexto() {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setFont(new Font("Bahnschrift", Font.BOLD, 15));
		setBackground(new Color(204, 204, 204));
	}
}
