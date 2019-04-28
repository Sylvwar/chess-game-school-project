
public class Bishop extends Piece {
	
	// constructors
	
	public Bishop(String side) {
		super(side);
	}
	
	// methods
	
	public String toString() {
		String s = new String();
		if (super.getColor() == "white")
			s += "B";
		else
			s += "B";
		return s;
	}

}