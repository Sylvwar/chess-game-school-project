package pieces;

public class Queen extends Piece {
	
	// constructors

	public Queen(String side) {
		super(side);
	}
	
	// methods
	
	public boolean isMovement(int x1, int y1, int x2, int y2) {
		return ( (Math.abs(x2-x1) == Math.abs(y2-y1)) || (x2-x1 == 0 && y2-y1 != 0) || (y2-y1 == 0 && x2-x1 != 0) );
	}
	
	public String toString() {
		String s = new String();
		if (super.getColor() == "white")
			s += "Q";
		else
			s += "Q";
		return s;
	}

}
