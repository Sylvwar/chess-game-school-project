
public class Tower extends Piece {
	
	// constructors

	public Tower(String side) {
		super(side);
	}
	
	// methods
	
	public String toString() {
		String s = new String();
		if (super.getColor() == "white")
			s += "T";
		else
			s += "T";
		return s;
	}

}