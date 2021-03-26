import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Gui extends JFrame{

	private int WinCount = 0;
	
	private boolean visited = false;
	Grid grid2 = new Grid();
	

	public Gui() {
		this.grid2 = new Grid();
		PracticeJpanel pfp = new PracticeJpanel();
		WordJPanel word = new WordJPanel();
		setLayout(null);
		setSize(500,500);
		getContentPane().setBackground(Color.DARK_GRAY);
		
		add(pfp);
		add(word);

		setVisible(true);//won't show up otherwise :-)
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public Gui(int g,int h,int j) {
		this.grid2 = new Grid(g,h,j);
		PracticeJpanel pfp = new PracticeJpanel();
		WordJPanel word = new WordJPanel();
		setLayout(null);
		setSize(500,500);
		getContentPane().setBackground(Color.DARK_GRAY);

		add(pfp);
		add(word);

		setVisible(true);//won't show up otherwise :-)
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void PlayAgain() {
		int input = JOptionPane.showConfirmDialog(null, 
				"Would you like to play again?..." ,"COVID-sweeper" ,JOptionPane.YES_NO_CANCEL_OPTION);
		if(input == 0) {
			String[] options = {"Default 10x10", "Custom grid"};

	        int x = JOptionPane.showOptionDialog(null, "Welcome to the COVID-sweeper, choose your option for the grid:",
	                "Click a button",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

			if(x == 0) {
			Gui gui1 = new Gui();
			gui1.setTitle("COVID-sweeper");
			}
			if(x == 1) {
				int ansRows = 5;
				int ansCol = 5;
				int ansBomb = 25;
				//getting amount of rows from the user
				try {
				ansRows = Integer.parseInt(JOptionPane.showInputDialog(null,
			            "write a number greater than 5 for the amount of rows:","amount of Rows",
			            JOptionPane.INFORMATION_MESSAGE
		            ));
				if(ansRows < 5) {
					JOptionPane.showMessageDialog(null,
					        "Something went wrong, program exiting.");
					System.exit(0);
				}
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,
					        "Something went wrong, program exiting.");
					System.exit(0);
					}
				//getting amount of rows from the user
				try {
				ansCol = Integer.parseInt(JOptionPane.showInputDialog(null,
			            "write a number greater than 5 for the amount of columns:","amount of Columns",
			            JOptionPane.INFORMATION_MESSAGE
		            ));
				if(ansCol < 5) {
					JOptionPane.showMessageDialog(null,
					        "Something went wrong, program exiting.");
					System.exit(0);
				}
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,
					        "Something went wrong, program exiting.");
					System.exit(0);
					}
				
				//getting amount of Bombs from the user
				try {
				ansBomb = Integer.parseInt(JOptionPane.showInputDialog(null,
			            "write a number greater than 25 but less than " + ansRows* ansCol + " for the amount of Bombs:","amount of Bombs",
			            JOptionPane.INFORMATION_MESSAGE
		            ));
				if(ansBomb < 25 || ansBomb > ansRows* ansCol) {
					JOptionPane.showMessageDialog(null,
					        "Something went wrong, program exiting.");
					System.exit(0);
				}
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,
					        "Something went wrong, program exiting.");
					System.exit(0);
					}
				Gui gui3 = new Gui(ansRows,ansCol,ansBomb);
				gui3.setTitle("COVID-sweeper");
			}
			
		}
		else{
			JOptionPane.showMessageDialog(null,
			        "stay home and take care of the corona, BYEE!!!");
			    System.exit(0);
		
		}
	}

	public class PracticeJpanel extends JPanel implements ActionListener{
		public JToggleButton [][] jbarr = new JToggleButton [grid2.getNumRows()][grid2.getNumColumns()];
		public PracticeJpanel() {


			grid2.PrintGridBoo();
			System.out.print("\n-------------------");
			grid2.PrintGridCount();
			setBounds(17,50,450,400);
			setBackground(Color.GRAY);
			setBorder(BorderFactory.createBevelBorder(0));

			setLayout(new GridLayout(grid2.getNumRows(),grid2.getNumColumns(),5,5)
					);
			int count = 1;


			for(int i = 0; i < grid2.getNumRows(); i++) {

				for(int j = 0; j < grid2.getNumColumns(); j++) {
					String s = Integer.toString(count);
					//System.out.println(s);
					jbarr[i][j]= new JToggleButton ();
					jbarr[i][j].setFocusable(false);
					jbarr[i][j].setBorder(null);
					jbarr[i][j].addActionListener(this);
					this.add(jbarr[i][j]);

					count += 1;
				}
			}

			setVisible(true);

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			// code to iterate tru the buttons and know what button was pressed
			
			
			boolean found = false;
			int i = 0;
			int j = 0;
			for(i = 0 ; i < grid2.getNumRows(); i++) {

				for(j = 0 ; j < grid2.getNumColumns(); j++) {
					if(e.getSource() == jbarr[i][j]) {
						found = true;
						break;
					}
				}
				if(found) break;
			}
			
			if(grid2.getCountAtLocation(i ,j) == 0) {
				jbarr[i][j].setText(Integer.toString(grid2.getCountAtLocation(i, j)));
				jbarr[i][j].setSelected(false);
				jbarr[i][j].setEnabled(false);
				jbarr[i][j].setBackground(Color.black);
				// check setEnable function
				// is Enable to check if a button is available
				
				CellRecurssion(i,j);
				
					
			}
			// replace button for the corresponding count in the grid
			if(grid2.getCountAtLocation(i, j) != 0) {
				//WinCount -= 1;
			jbarr[i][j].setText(Integer.toString(grid2.getCountAtLocation(i, j)));
			jbarr[i][j].setSelected(true);
			jbarr[i][j].setEnabled(false);
			jbarr[i][j].setBackground(Color.black);
			}

			//code to show if you press a bomb and reveal the whole grid
			if(grid2.isBombAtLocation(i,j)) {
				jbarr[i][j].setBorder(null);
//				Font size12 = new Font("Arial", Font.BOLD, 10);
//				jbarr[i][j].setText("BOOM!");
//				jbarr[i][j].setFont(size12);
				
				
				ImageIcon icon = new ImageIcon("covid19 image1.jpg");			
				jbarr[i][j].setIcon(icon);
				jbarr[i][j].setDisabledIcon(icon);

				JOptionPane.showMessageDialog(null, "stay 6ft away!!! covid found you!!\n YOU LOSE! ");
				//populate the board
				for(i = 0 ; i < grid2.getNumRows(); i++) {

					for(j = 0 ; j < grid2.getNumColumns(); j++) {
						if(grid2.isBombAtLocation(i,j)) {
							jbarr[i][j].setBorder(null);
							jbarr[i][j].setSelected(true);;
//							Font size13 = new Font("Arial", Font.BOLD, 10);
//							jbarr[i][j].setText("BOOM!");
//							jbarr[i][j].setFont(size13);
							ImageIcon icon2 = new ImageIcon("covid19 image1.jpg");			
							jbarr[i][j].setIcon(icon2);
							jbarr[i][j].setDisabledIcon(icon2);
							jbarr[i][j].setEnabled(false);
							jbarr[i][j].setBackground(Color.black);
						}
						else {
							jbarr[i][j].setText(Integer.toString(grid2.getCountAtLocation(i, j)));
							jbarr[i][j].setSelected(true);;
							jbarr[i][j].setEnabled(false);
							jbarr[i][j].setBackground(Color.black);

						}

					}

				}
				PlayAgain();

			}
			int counter2 = 0;
			for(int p = 0 ; p < grid2.getNumRows(); p++) {

				for(int q = 0 ; q < grid2.getNumColumns(); q++) {
					if(jbarr[p][q].isEnabled()) {
						counter2 += 1;
						//WinCount -= 1;
					}
				}
			}
			WinCount = counter2;
			//code to know if is a winner
			if(WinCount == grid2.getNumBombs()) {
				JOptionPane.showMessageDialog(null, "you used masks and sanitizers, good job!!! \n WIN! ");
				for(i = 0 ; i < grid2.getNumRows(); i++) {

					for(j = 0 ; j < grid2.getNumColumns(); j++) {
						if(grid2.isBombAtLocation(i,j)) {
							jbarr[i][j].setBorder(null);
							jbarr[i][j].setSelected(true);;
//							Font size13 = new Font("Arial", Font.BOLD, 10);
//							jbarr[i][j].setText("BOOM!");
//							jbarr[i][j].setFont(size13);
							ImageIcon icon = new ImageIcon("covid19 image1.jpg");			
							jbarr[i][j].setIcon(icon);
							jbarr[i][j].setDisabledIcon(icon);
							
							jbarr[i][j].setEnabled(false);
							jbarr[i][j].setBackground(Color.black);
						}
						else {
							jbarr[i][j].setText(Integer.toString(grid2.getCountAtLocation(i, j)));
							jbarr[i][j].setSelected(true);
							jbarr[i][j].setEnabled(false);
							jbarr[i][j].setBackground(Color.black);

						}

					}

				}
				PlayAgain();
			}
//			jbarr[i][j].setEnabled(false);
//			jbarr[i][j].removeActionListener(this);
//			System.out.println("Final:" + WinCount);

		}
		
		
		public  void CellRecurssion(int x,int y) {
			
			if(x < 0 || x> grid2.getNumRows() - 1 || y < 0 || y > grid2.getNumColumns() -1) {
				return;
			}
			
			
			if(grid2.getCountAtLocation(x ,y) == 0 && !jbarr[x][y].isSelected() ) {
				
				//WinCount -= 1;
				//System.out.println("x: " + x + " y: " + y + " WinCount =" + WinCount);
				jbarr[x][y].setText(Integer.toString(grid2.getCountAtLocation(x, y)));				
				jbarr[x][y].setSelected(true);
				jbarr[x][y].setEnabled(false);
				jbarr[x][y].setBackground(Color.black);
				CellRecurssion(x+ 1, y);
				//CellRecurssion(x+ 1,  y+1);
				CellRecurssion(x- 1,  y);
				CellRecurssion(x,  y- 1);
				//CellRecurssion(x-1,  y- 1);
				//CellRecurssion(x+1,  y- 1);
				CellRecurssion(x,  y+ 1);
				//CellRecurssion(x -1,  y+ 1);
				
				
			}
			else {
				//WinCount -= 1;
				//System.out.println("x: " + x + " y: " + y + " WinCount =" + WinCount);
				jbarr[x][y].setText(Integer.toString(grid2.getCountAtLocation(x, y)));				
				jbarr[x][y].setSelected(true);
				jbarr[x][y].setEnabled(false);
				jbarr[x][y].setBackground(Color.black);
				return;
			}



		}
		
		
	}

}
