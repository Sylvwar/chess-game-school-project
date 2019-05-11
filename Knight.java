
public class Knight extends Piece {
	
	// constructors

	public Knight(String side) {
		super(side);
	}
	
	// methods
	
	public boolean isMovement(int x1, int y1, int x2, int y2) {
		return ( (Math.abs(x2-x1) == 1 && Math.abs(y2-y1) == 2) || (Math.abs(x2-x1) == 2 && Math.abs(y2-y1) == 1) );
	}
	
	public String toString() {
		String s = new String();
		if (super.getColor() == "white")
			s += "H";
		else
			s += "H";
		return s;
	}

}
