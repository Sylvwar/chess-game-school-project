package view;

import java.util.*;
import model.*;

public class Display implements Constants {

	Board board;
	String mode;
	
	// constructors
	
	public Display(Board board, String mode) {
		this.board = board;
		this.mode = mode;
	}
	
	// methods
	
	public void displayMenu() {
		
		System.out.println("1. Resume");
		System.out.println("2. New");
		System.out.println("3. Load");
		System.out.println("4. Save");
		System.out.println("5. Quit");
		
	}
	
	public void displayTag(int select) {
		
		if (select == 1) {
			System.out.println("# Resume");
		}
		else if (select == 2) {
			System.out.println("# New");
		}
		else if (select == 3) {
			System.out.println("# Load");
		}
		else if (select == 4) {
			System.out.println("# Save");
		}
		else if (select == 5) {
			System.out.println("# Quit");
		}
		else {
			System.out.println("# Menu\n");
		}
		
	}
	
	public String displayInput() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\n> ");
		String input = sc.next();
		
		return input;
	}
	
	public void displayBoard() {
		
		String s = new String("   ");
		
		for (int y = 0; y < DIM; y++) {
			
			s += "\n";
			s += (y+1) + "   ";
			
			for (int x = 0; x < DIM; x++) {
				
				if (board.getTiles()[x][y].getColor() == "white")
					s += TileFormat(x,y);
				else
					s += TileFormat(x,y);
				
			}
			
		}
		
		s += "\n\n    ";
		
		for (int x = 0; x < DIM; x++)
			s += " " + (char)('a'+x) + "  ";
		
		System.out.println(s);
		
	}
	
	public String TileFormat(int x, int y) {
		
		if (board.getTiles()[y][x].getPiece() == null)
			return "[ ] ";
		else
			return "[" + board.getTiles()[y][x].getPiece() + "] ";
		
	}
	
}
