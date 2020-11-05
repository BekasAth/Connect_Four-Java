import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		Player p1 = new Player();
		Player p2 = new Player();		
		
		System.out.println("\n----------------Welcome to Connect Four----------------\n");
		
		//Players' names and  symbols
		System.out.print("1st Player's Name: ");
		String name = in.nextLine();
		p1.setName(name);
		
		
		System.out.print("\n" + p1.getName() + ", select symbol  1-(X)  2-(O): ");
		int symbol = in.nextInt();
		in.nextLine();
		
		while(true) {
			if(symbol==1 || symbol == 2) 
				break;
			else {
				System.out.println("Please Try Again");
				System.out.print("\n" + p1.getName() + ", select symbol  1-(X)  2-(O): ");
				symbol = in.nextInt();
				in.nextLine();
			}
		}
		
		
		//Symbol selection
		switch (symbol) {
			
			case 1:
					System.out.println(p1.getName() + "'s symbol is \"X\".");
					p1.setSymbol('x');
					break;
			
			case 2:
			
					System.out.println(p1.getName() + "'s symbol is \"O\".");
					p1.setSymbol('o');
					break;
			
			default:
					
				//Ensure correct type of answer
				while(symbol != 1 && symbol != 2) {
					
					System.out.println("Plese select again!");
					System.out.print("Select symbol 1-(X) 2-(O): ");
					
					symbol = in.nextInt();
					in.nextLine();
				}
				
				if(symbol == 1) { 
					
					System.out.println("\n" + p1.getName() + "'s symbol is \"X\".");
					p1.setSymbol('x');
				}
				else {
					
					System.out.println("\n" + p1.getName() + "'s symbol is \"O\".");
					p1.setSymbol('o');
				}
						
		}
		
		System.out.println("");
		
		System.out.print("Player's 2 Name: ");
		name = in.nextLine();
		p2.setName(name);
		
		if(symbol == 1) {
			
			System.out.println(p2.getName() + "'s symbol is \"O\".");
			p2.setSymbol('o');
		}else { 
			
			System.out.println(p2.getName() + "'s symbol is \"X\".");
			p2.setSymbol('x');
		}
		System.out.println("");  
		
		//Table's size
		System.out.println("----Select the size of the table----");
		
		System.out.print("\nNumber of rows (from 4 to 15): ");
		int rows = in.nextInt();
		in.nextLine();
		
		while(rows<4 || rows>15) {
			
			System.out.print("Insert a correct size of rows! (from 4 to 15): ");
			rows = in.nextInt();
			in.nextLine();
		}
		
		System.out.print("Number of columns: ");
		int columns = in.nextInt();
		in.nextLine();
		
		while(columns<4 || columns>15) {
			
			System.out.print("Insert a correct size of columns (from 4 to 15): ");
			columns = in.nextInt();
			in.nextLine();
		}
		
		Table table = new Table(rows, columns);
		
		table.printTable();
		
		//random turn
		int r = new Random().nextInt(2);
		
		//game starts...
		if(r==1) 
			table.PlayerMove(p2);
	
		
		boolean end = false;
		
		//until win or draw
		while(!end) {
			
			end = table.PlayerMove(p1);
			
			if(end)
				break;
			
			end = table.PlayerMove(p2);
			
		}
		
		
		
		
		
		in.close();
	}

}
