package componentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class LabelTexto extends JLabel{
	public LabelTexto(){
		setHorizontalAlignment(SwingConstants.CENTER);
		setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		setBackground(new Color(208, 232, 226));
		setOpaque(true);
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
	}
}
