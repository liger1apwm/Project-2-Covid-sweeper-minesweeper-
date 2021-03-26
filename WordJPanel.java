import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

//import javafx.scene.text.Font;

public class WordJPanel extends JPanel{
			public WordJPanel() {
				setBounds(90,5,300,40);
				JLabel word = new JLabel("COVID-sweeper",JLabel.LEFT);
				word.setBounds(0,0,50,50);
				word.setFont(new Font("Monospaced", Font.BOLD, 27));
				
				word.setForeground(Color.red);
				setBackground(Color.DARK_GRAY);
				add(word);
				setVisible(true);
			}
}
