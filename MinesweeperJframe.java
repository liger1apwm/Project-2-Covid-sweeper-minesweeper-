import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MinesweeperJframe extends JFrame{


	public MinesweeperJframe (){
		JPanel mainJP = new JPanel();
		mainJP.setLayout(new GridLayout(10,10));
		this.setTitle("Minesweeper");
		

		MinesweeperJpanel jp1 = new MinesweeperJpanel();//create an instance of our custom jpanel
//		jp1.setBackground(Color.YELLOW);
		

//		MinesweeperJpanel jp2 = new MinesweeperJpanel();//create an instance of our custom jpanel
//		jp2.setBackground(Color.RED);
//		
		

		
		
		//add everything to mainJP....
		mainJP.add(jp1);
//		mainJP.add(jp2);
		
		add(mainJP);//add mainJP to the JFrame
		
		setSize(500,500);
		setVisible(true);//won't show up otherwise :-)
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		
	}
	
}
