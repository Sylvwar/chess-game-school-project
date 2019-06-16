package view;

import java.util.*;
import model.*;

public class Display implements Constants {

	Game game;
	
	// constructors
	
	public Display(Game game) {
		this.game = game;
	}
	
	// methods
	
	public void displayMenu() {
		
		System.out.println("1. Resume");
		System.out.println("2. New");
		System.out.println("3. Load");
		System.out.println("4. Save");
		System.out.println("5. Quit\n");
		
	}
	
	public void displayTag(int select) {
		
		if (select == 1) {
			System.out.println("# Resume\n");
		}
		else if (select == 2) {
			System.out.println("# New");
		}
		else if (select == 3) {
			System.out.println("# Load");
		}
		else if (select == 4) {
			System.out.println("# Save\n");
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
		System.out.print("> ");
		String input = sc.next();
		
		return input;
	}
	
	public void displayBoard() {
		
		String s = new String("   ");
		
		for (int y = 0; y < DIM; y++) {
			
			s += "\n";
			s += (y+1) + "   ";
			
			for (int x = 0; x < DIM; x++) {
				
				if (game.getBoard().getTiles()[x][y].getColor() == "white")
					s += tileFormat(x,y);
				else
					s += tileFormat(x,y);
				
			}
			
		}
		
		s += "\n\n    ";
		
		for (int x = 0; x < DIM; x++)
			s += " " + (char)('a'+x) + "  ";
		
		System.out.println(s);
		
	}
	
	public String tileFormat(int x, int y) {
		
		if (game.getBoard().getTiles()[y][x].getPiece() == null)
			return "[ ] ";
		else
			return "[" + game.getBoard().getTiles()[y][x].getPiece().getLabel() + "] ";
		
	}

	public void displayWarning(int type) {
		
		if (type == 1) {
			System.out.println("# No game is currently running\n");
		}
		else if (type == 2) {
			if (game.isWhiteTurn())
				System.out.println("\n~ Player white turn");
			else
				System.out.println("\n~ Player black turn");
		}
		else if (type == 3) {
			System.out.println("# ");
		}
		else if (type == 4) {
			System.out.println("# ");
		}
		else if (type == 5) {
			System.out.println("# ");
		}
		else {
			System.out.println("# ");
		}
		
	}
	
}
