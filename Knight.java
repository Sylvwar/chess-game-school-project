
public class Knight extends Piece {
	
	// constructors

	public Knight(String side) {
		super(side);
	}
	
	// methods
	
	public String toString() {
		String s = new String();
		if (super.getColor() == "white")
			s += "H";
		else
			s += "H";
		return s;
	}

}
