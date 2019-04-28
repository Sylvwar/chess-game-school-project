
public class Pawn extends Piece {
	
	// constructors

	public Pawn(String side) {
		super(side);
	}
	
	// methods
	
	public String toString() {
		String s = new String();
		if (super.getColor() == "white")
			s += "P";
		else
			s += "P";
		return s;
	}

}
