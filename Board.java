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
	
	public Piece takePiece(int x, int y) {
		Piece p = null;
		if (this.tiles.get(x+y*DIM).getPiece() != null) {
			p = this.tiles.get(x+y*DIM).getPiece();
		}
		this.tiles.get(x+y*DIM).setPiece(null);
		return p;
	}
	
	public void putPiece(Piece p, int x, int y) {
		if (this.tiles.get(x+y*DIM).getPiece() == null) {
			this.tiles.get(x+y*DIM).setPiece(p);
		}
	}
	
	/* printing the board in text display */
	
	public String toString() {
		String s = new String();
		for (int y = 0; y < DIM; y++) {
			s += "\n";
			
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
