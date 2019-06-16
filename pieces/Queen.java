package pieces;

import model.Constants;

public class Queen extends Piece {
	
	// constructors

	public Queen(String side) {
		super(side,Constants.QUEEN);
	}
	
	// methods
	
	public boolean isMovement(int x1, int y1, int x2, int y2) {
		return ( (Math.abs(x2-x1) == Math.abs(y2-y1)) || (x2-x1 == 0 && y2-y1 != 0) || (y2-y1 == 0 && x2-x1 != 0) );
	}

}
