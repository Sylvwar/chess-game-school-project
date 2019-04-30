
public class Rook extends Piece {
	
	// constructors

	public Rook(String side) {
		super(side);
	}
	
	// methods
	
	public String toString() {
		String s = new String();
		if (super.getColor() == "white")
			s += "R";
		else
			s += "R";
		return s;
	}

}