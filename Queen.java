
public class Queen extends Piece {
	
	// constructors

	public Queen(String side) {
		super(side);
	}
	
	// methods
	
	public String toString() {
		String s = new String();
		if (super.getColor() == "white")
			s += "Q";
		else
			s += "Q";
		return s;
	}

}
