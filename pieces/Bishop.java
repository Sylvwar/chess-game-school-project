package pieces;

import model.Constants;

public class Bishop extends Piece {
	
	// constructors
	
	public Bishop(String side) {
		super(side,Constants.BISHOP);
	}
	
	// methods
	
	public boolean isMovement(int x1, int y1, int x2, int y2) {
		return ( Math.abs(x2-x1) == Math.abs(y2-y1) );
	}

}