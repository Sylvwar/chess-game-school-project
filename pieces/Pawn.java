package pieces;

public class Pawn extends Piece {
	
	private boolean firstMove = true;
	
	// constructors

	public Pawn(String side) {
		super(side);
	}
	
	// methods
	
	public boolean isFirstMove() {
		return this.firstMove;
	}
	
	public void firstMoveDone() {
		this.firstMove = false;
	}
	
	public boolean isMovement(int x1, int y1, int x2, int y2) {
		
		if (this.getColor() == "white") {
			
			if ( (x2-x1 == 0) && (y2-y1 == -1) ) {
				return true;
			}
			else if ( (x2-x1 == 0) && (y2-y1 == -2) && this.isFirstMove() ) {
				firstMoveDone();
				return true;
			}
			return false;
		}
		
		else {
			
			if ( (x2-x1 == 0) && (y2-y1 == 1) ) {
				return true;
			}
			else if ( (x2-x1 == 0) && (y2-y1 == 2) && this.isFirstMove() ) {
				firstMoveDone();
				return true;
			}
			return false;
		}
	}
	
	public boolean isCapturing(int x1, int y1, int x2, int y2) {
		if (this.getColor() == "white")
			return (Math.abs(x2-x1) == 1 && y2-y1 == -1);
		else
			return (Math.abs(x2-x1) == 1 && y2-y1 == 1);
	}
	
	public String toString() {
		String s = new String();
		if (super.getColor() == "white")
			s += "P";
		else
			s += "P";
		return s;
	}

}
