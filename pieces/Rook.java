package pieces;

public class Rook extends Piece {
	
	// constructors

	public Rook(String side) {
		super(side);
	}
	
	// methods
	
	public boolean isMovement(int x1, int y1, int x2, int y2) {
		return ( (x2-x1 == 0 && y2-y1 != 0) || (y2-y1 == 0 && x2-x1 != 0) );
	}
	
	public String toString() {
		String s = new String();
		if (super.getColor() == "white")
			s += "R";
		else
			s += "R";
		return s;
	}

}