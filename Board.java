import java.util.*;

public class Board implements BoardConstants {

	private ArrayList<Tile> tiles = new ArrayList<Tile>(64);
	
	// constructors
	
	public Board() {
		this.buildBoard();
	}
	
	// getters & setters
	
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	
	// methods
	
	private void buildBoard() {
		for (int y = 0; y <= DIM; y++) 
			for (int x = 0; x <= DIM; x++) 
				tiles.add(new Tile(x,y));
	}
	
	public String toString() {
		String s = new String();
		for (int y = 0; y < DIM; y++) {
			s += "\n ";
			
			for (int x = 0; x < DIM; x++) {
				
				if (tiles.get(x+y*DIM).getColor() == "white") {
					if (tiles.get(x+y*DIM).getPiece() == null)
						s += "[ ] ";
					else
						s += "[" + tiles.get(x+y*DIM).getPiece() + "] ";
				}
				
				else {
					if (tiles.get(x+y*DIM).getPiece() == null)
						s += "[ ] ";
					else
						s += "[" + tiles.get(x+y*DIM).getPiece() + "] ";
				}
				
			}
			
		}
		return s;
	}

	
}
