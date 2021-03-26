// youtube link: https://youtu.be/1H_sWVvfAnY
//eric aragundi cmp 168 final project	

import java.util.Random;

public class Grid {
	//	bombGrid : boolean [ ][ ]
	//			countGrid : int [ ][ ]
	//			numRows : int
	//			numColumns : int
	//			numBombs : int
	private boolean [][] bombGrid;
	private int [][] countGrid;
	private int  numRows;
	private int  numColumns;
	private int  numBombs;

	public Grid() {
		this.numRows = 10;
		this.numColumns = 10;
		this.numBombs = 25;
		bombGrid = new boolean [numRows][numColumns];
		countGrid = new int [numRows][numColumns];
		createBombGrid();
		createCountGrid();

	}

	public Grid(int rows, int columns) {
		if(rows >= 5) {
			this.numRows = rows;
		}
		if(columns >= 5  ) {
			this.numColumns = columns;
		}
		this.numBombs = 25;
		bombGrid = new boolean [numRows][numColumns];
		countGrid = new int [numRows][numColumns];
		createBombGrid();
		createCountGrid();
		
	}
	public Grid(int rows, int columns,int numBombs) {
		if(rows >= 5) {
			this.numRows = rows;
		}
		if(columns >= 5) {
			this.numColumns = columns;
		}
		this.numBombs = numBombs;
		bombGrid = new boolean [numRows][numColumns];
		countGrid = new int [numRows][numColumns];
		createBombGrid();
		createCountGrid();
	}

	public boolean[][] getBombGrid() {
		boolean [][] bombGrid2;
		bombGrid2 = new boolean [this.numRows][this.numColumns];
		for(int i = 0; i < this.numRows; i++) {

			for(int j = 0; j < this.numColumns; j++) {

				bombGrid2[i][j] = bombGrid[i][j];
			}
		}
		
		return bombGrid2;
	}

	public int[][] getCountGrid() {
		int [][] countGrid2;
		countGrid2 = new int [this.numRows][this.numColumns];
		for(int i = 0; i < this.numRows; i++) {

			for(int j = 0; j < this.numColumns; j++) {

				countGrid2[i][j] = countGrid[i][j];
			}
		}
		
		return countGrid2;
	}

	public int getNumRows() {
		return numRows;
	}

	public int getNumColumns() {
		return numColumns;
	}

	public int getNumBombs() {
		return numBombs;
	}

	public boolean isBombAtLocation(int row, int column) {
		if(row >= 0 && row < this.numRows) {
			if(column >= 0 && column < this.numColumns) {
				if(bombGrid[row][column]) {
					return true;
				}

			}

		}
		return false;
	}

	public int getCountAtLocation(int row, int column) {
		if(row >= 0 && row < this.numRows) {
			if(column >= 0 && column < this.numColumns) {
				return countGrid[row][column];

			}

		}
		return -1;

	}

	private void createBombGrid() {
		
		for(int i = 0; i < this.numRows; i++) {

			for(int j = 0; j < this.numColumns; j++) {

				bombGrid[i][j] = false;
			}
		}


		for (int i = 0; i < this.numBombs; i++) {

			Random rand = new Random();
			int row = rand.nextInt(this.numRows);
			int col = rand.nextInt(this.numColumns);

			while(bombGrid[row][col]) { 

				row = rand.nextInt(this.numRows);
				col = rand.nextInt(this.numColumns);
			}
			bombGrid[row][col] = true; 
		}
	}
	//helper method to print
	public void PrintGridBoo(){
		for(int i = 0; i < this.numRows; i++) {
			System.out.println("");
			for(int j = 0; j < this.numColumns; j++) {
				String s = "";
				if(bombGrid[i][j]) {
					s = "T";
				}
				else {
					s= "F";
				}

				System.out.print(s);
				System.out.print(" ");
			}
		}

	}


	private void createCountGrid() {
		
		for(int i = 0; i < this.numRows; i++) {

			for(int j = 0; j < this.numColumns; j++) {
				int count = 0;

				if(bombGrid[i][j]== true) {
					count += 1;
				}
				if( (i + 1) < numRows) {
					if(bombGrid[i+ 1][j] == true) {
						count += 1;
					}}
				if((i + 1) < numRows && (j + 1) < numColumns) {
					if(bombGrid[i+ 1][j+1] == true ) {
						count += 1;
					}}
				if((i - 1) > -1) {
					if(bombGrid[i-1][j] == true ) {
						count += 1;
					}}
				if((j - 1) > -1) {
					if(bombGrid[i][j - 1] == true) {
						count += 1;
					}
				}
				if((i - 1) > -1 && (j - 1) > -1) {
					if(bombGrid[i-1][j - 1] == true ) {
						count += 1;
					}
				}
				if((i + 1) < numRows && (j - 1) > -1) {
					if(bombGrid[i+ 1][j-1] == true ) {
						count += 1;
					}}
				if( (j + 1) < numColumns) {
					if(bombGrid[i][j+1] == true ) {
						count += 1;
					}}
				if((i - 1) > -1 && (j + 1) < numColumns) {
					if(bombGrid[i- 1][j+1] == true ) {
						count += 1;
					}}

				countGrid[i][j] = count;
				count = 0;

			}
		}
	}
	//helper method to print
	public void PrintGridCount(){
		for(int i = 0; i < this.numRows; i++) {
			System.out.println("");
			for(int j = 0; j < this.numColumns; j++) {

				System.out.print(countGrid[i][j] + " ");
			}
		}

	}

}
