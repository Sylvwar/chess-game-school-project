
public class King extends Piece {
	
	// constructors

	public King(String side) {
		super(side);
	}
	
	// methods
	
	public String toString() {
		String s = new String();
		if (super.getColor() == "white")
			s += "K";
		else
			s += "K";
		return s;
	}

}
