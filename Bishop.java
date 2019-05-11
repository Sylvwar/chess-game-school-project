
public class Bishop extends Piece {
	
	// constructors
	
	public Bishop(String side) {
		super(side);
	}
	
	// methods
	
	public boolean isMovement(int x1, int y1, int x2, int y2) {
		return ( Math.abs(x2-x1) == Math.abs(y2-y1) );
	}
	
	public String toString() {
		String s = new String();
		if (super.getColor() == "white")
			s += "B";
		else
			s += "B";
		return s;
	}

}