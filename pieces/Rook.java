package pieces;

import model.Constants;

public class Rook extends Piece {
	
	// constructors

	public Rook(String side) {
		super(side,Constants.ROOK);
	}
	
	// methods
	
	public boolean isMovement(int x1, int y1, int x2, int y2) {
		return ( (x2-x1 == 0 && y2-y1 != 0) || (y2-y1 == 0 && x2-x1 != 0) );
	}

}