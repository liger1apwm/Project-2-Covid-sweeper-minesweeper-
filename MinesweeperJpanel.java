import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class MinesweeperJpanel extends JPanel {
	private JLabel jl;
	private JButton [][] JButtons;
	private int counter = 0;
	
	public MinesweeperJpanel(){
		//default flow layout
//		setLayout(new GridLayout(10,10));
		jl = new JLabel();
		jl.setSize(450, 450);
//		jl.setTitle("Minesweeper");
//		jl.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 45));
//
		int x = 20;
		int y = 20;
		
		JButtons = new JButton[10][10];
		for(int i = 0; i < 2; i++) {

			for(int j = 0; j < 2; j++) {

				JButtons[i][j] = new JButton();
				JButtons[i][j].setBounds(x + 5, y + 5, 50, 50);
				add(JButtons[i][j]);
			}
		}
		
//		jbUp = new JButton();
//		jbDown = new JButton();
//
//		jbUp.setForeground(Color.GREEN);
//		jbDown.setForeground(Color.RED);
//
//		jbUp.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
//		jbDown.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
//		
//		jbUp.addActionListener(this);//add listeners to trigger the actionPerformed method 
//		jbDown.addActionListener(this);
//		
		add(jl);
		
//		add(jbUp);
//		add(jbDown);
		
		
		
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
////		String btnText = e.getActionCommand(); //get the face of the button that was clicked
////		if(jbUp.getText().equals(" + ")){
////			jl.setText("votes= "+ ++counter);
////		}
////		else if(jbDown.getText().equals(" - ")){
////			jl.setText("votes= "+ --counter);
////		}
////		else{
////			jl.setText("SCOOBY? what was clicked?");
////		}
//		
//		
////		e.getSource()//get the Object that triggered the event
//		JButton btnClicked = (JButton) e.getSource();
//		
////		if(jbUp.equals(btnClicked)){
////			jl.setText("votes= "+ ++counter);
////		}
////		else if(jbDown.equals(btnClicked)){
////			jl.setText("votes= "+ --counter);
////		}
////		else{
////			jl.setText("SCOOBY? what was clicked?");
////		}
//		
//	}
//	
	
}
