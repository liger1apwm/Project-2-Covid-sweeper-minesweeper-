import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class tester {

	public static void main(String[] args) {
//		Grid mineswep = new Grid();
//		mineswep.PrintGridBoo();
//		System.out.print("\n-------------------");
//		mineswep.PrintGridCount();
		
		
		javax.swing.SwingUtilities.invokeLater( new Runnable(){
			
			@Override
			public void run() {
				String[] options = {"Default 10x10", "Custom grid"};
		        //Integer[] options = {1, 3, 5, 7, 9, 11};
		        //Double[] options = {3.141, 1.618};
		        //Character[] options = {'a', 'b', 'c', 'd'};
				ImageIcon icon2 = new ImageIcon("covid19 image1.jpg");
		        int x = JOptionPane.showOptionDialog(null, "Welcome to the COVID-sweeper, choose your option for the grid:",
		                "Click a button",
		                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,icon2, options, options[0]);
		        //System.out.println(x);
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
					if(ansBomb < 25) {
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
			
		});
		

		

	
	
	
	
	
	}

}
