import java.util.Scanner;

public class Table {
	
	Scanner in = new Scanner(System.in);
	
	private int NumOfRows, NumOfColumns;
	private char[][] table;
	

	
	public Table(int rows, int cols) {
		
		NumOfRows = rows;
		NumOfColumns = cols;
		
		table = new char[NumOfRows][NumOfColumns];
				
		for (int i=0; i<NumOfRows; i++){
			
			for(int j=0; j<NumOfColumns; j++){
					table[i][j] = '-';
			}
		}
			
	}
	
	public void printTable() {
		
		if(NumOfColumns < 9) {
		
			for(int i=0; i<NumOfRows; i++) {
				
				System.out.print("| ");
				
				for(int j=0; j<NumOfColumns; j++) {
					
					System.out.print(table[i][j] + " ");
				}
				
				System.out.print("|\n");
			}
			
			for(int i=-1; i<NumOfColumns; i++) {
				
				System.out.print("--");
			}
			
			System.out.println("-");
			System.out.print("  ");
			
			for(int i=0; i<NumOfColumns; i++) {
					
					System.out.print(i+1 + " ");
			}
		
		}else {
			
			for(int i=0; i<NumOfRows; i++) {
				
				System.out.print("|");
				
				for(int j=0; j<NumOfColumns; j++) {
					
					System.out.print(" " + table[i][j] + " ");
				}
				
				System.out.print("|\n");
			}
			
			for(int i=-1; i<NumOfColumns - 1; i++) {
				
				System.out.print("---");
			}
			
			System.out.println("--");
			System.out.print(" ");
			
			for(int i=1; i<=9; i++) {
				System.out.print(" " + i + " ");
			}
			
			System.out.print(" ");
			
			for(int i=10; i<=NumOfColumns; i++) {
				System.out.print(i + " ");
			}
			
		}
		
		System.out.println("");
	}
	
	public boolean PlayerMove(Player player) {
		
		
		System.out.print(player.getName() + ", your turn. Select a column: ");
		
		int col = in.nextInt();
		in.nextLine();
		
		while (col-1 < 0 && col > NumOfColumns) {
			
			System.out.println("There is not that column.");
			System.out.print("Try again: ");
			col = in.nextInt();
			in.nextLine();
			
		}
		
		boolean error = true;
		
			while(error) {	
		
				for(int i=NumOfRows-1; i>=0; i--) {
					
					if (table[i][col-1] == '-') {
						table[i][col-1] = player.getSymbol();
						error = false;
						break;
					}	
				}
				
				if(error) {
					System.out.println("Error! You can not select this column");
					System.out.print("Try Again: ");
					
					col = in.nextInt();
					in.nextLine();
					
				}
			
			}
		
		this.printTable();
		System.out.println("");
		int result = this.tableCheck(player.getSymbol());
		
		if(result == 1) {
			
			System.out.println("GAME OVER. WE HAVE A DRAW");
			return true;
			
		}else if(result == 2) {
			
			System.out.println("GAME OVER. THE WINNER IS " + player.getName());
			return true;
			
		}else {
			
			System.out.println("continue...");
			return false;
		}
	}
	
	public int tableCheck(char symbol) {
		
		boolean freeSpace = false;
		
		//horizontal check
		for(int i=0; i<NumOfRows; i++) {
			
			int count = 0;
			
			for(int j=0; j<NumOfColumns; j++) {
				
				if(table[i][j]=='-') {
					
					freeSpace = true;
					count = 0;
				}
				else if(table[i][j]==symbol) {
					
					count++;
					if(count==4)
						return 2;
				}
				else
					count=0;
			}
		
		}
		
		//vertical check
		for(int j=0; j<NumOfColumns; j++) {
			
			int count = 0;
			
			for(int i=0; i<NumOfRows; i++) {
				
				if(table[i][j] == symbol) {
				
					count++;
					if(count==4)
						return 2;
				
				}else 
					count=0;
				
			}
		}
		
		//diagonal check
		for(int a=0; a<NumOfRows-3; a++) {
			
			int count = 0;
			int rcount = 0;
			
			for(int i=0; i<NumOfRows; i++) {
				
				for(int j =0; j<NumOfColumns; j++) {
					
					if(i-j==a) {
						
						if(table[i][j]==symbol) {
							
							count++;
							if(count == 4)
								return 2;
						}
						else
							count=0;
					}
					
					if(i+j == NumOfColumns-1-a) {
						
						if(table[i][j]==symbol) {
							
							rcount++;
							if(rcount == 4)
								return 2;
						}
						else
							rcount=0;
					}
				}
			}
		}
		
		for(int a=1; a<NumOfColumns-3; a++) {
			
			int count = 0;
			int rcount = 0;
			
			for(int i=0; i<NumOfRows; i++) {
				
				for(int j =0; j<NumOfColumns; j++) {
					
					if(j-i==a) {
						
						if(table[i][j]==symbol) {
							
							count++;
							if(count == 4)
								return 2;
						}
						else
							count=0;
					}
					
					if(i+j == NumOfColumns-1+a) {
						
						if(table[i][j]==symbol) {
							
							rcount++;
							if(rcount == 4)
								return 2;
						}
						else
							rcount=0;
					}
				}
			}
		}
		
		//draw check
		
		if(!freeSpace)
			return 1;
		else 
			return 0;
		
	}
	
}
