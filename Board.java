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
		if (this.tiles.get(x+y*DIM).isOccupied()) {
			p = this.tiles.get(x+y*DIM).getPiece();
			this.tiles.get(x+y*DIM).setPiece(null);
		}
		return p;
	}
	
	public void putPiece(Piece p, int x, int y) {
		if (!this.tiles.get(x+y*DIM).isOccupied()) {
			this.tiles.get(x+y*DIM).setPiece(p);
		}
	}
	
	public boolean isLegalPath(int x1, int y1, int x2, int y2) {
		
		int i = 0;
		int j = 0;
		
		if (Math.abs(x2-x1) != 0)
			i = (x2-x1) / (Math.abs(x2-x1));
		if (Math.abs(y2-y1) != 0)
			j = (y2-y1) / (Math.abs(y2-y1));

		int d;
		if (i == 0) d = Math.abs(y2-y1);
		else if (j == 0) d = Math.abs(x2-x1);
		else d = Math.abs(x2-x1);
		
		int x = x1;
		int y = y1;
		
		do {
			x += i;
			y += j;
			d --;
		} 
		while (d > 0 && !this.tiles.get(x+y*DIM).isOccupied());

		return (d <= 0);
	}
	
	public void resetBoard() {
		this.tiles.clear();
		this.buildBoard();
	}
	
	/* printing the board in text display */
	
	public String toString() {
		
		String s = new String("   ");
		
		for (int y = 0; y < DIM; y++) {
			s += "\n";
			s += (y+1) + "   ";
			
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
		
		s += "\n\n    ";
		for (int x = 0; x < DIM; x++)
			s += " " + (char)('a'+x) + "  ";
		
		return s;
		
	}

	
}
