import java.util.*;

public class Player implements PlayerConstants {
	
	private ArrayList<Piece> pieces = new ArrayList<Piece>(16);
	private ArrayList<Piece> captures = new ArrayList<Piece>();
	private String side;
	
	// constructors 
	
	public Player(String side) {
		this.side = side;
		//this.genPieces();
	}
	
	// getters & setters

	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	public String getSide() {
		return side;
	}

	// methods
	
	public void addPiece(Board b, Piece p, int x, int y) {
		b.putPiece(p, x, y);
		this.pieces.add(p);
	}
	
	public void delPiece(Board b, int x, int y) {
		Piece p = b.takePiece(x, y);
		this.pieces.remove(p);
	}
	
	public void capturePiece(Board b, Player oponnent, Piece p, int x, int y) {
		this.captures.add(p);
		oponnent.delPiece(b, x, y);
	}
	
	public void resetPlayer() {
		this.pieces.clear();
		this.captures.clear();
	}
	
	public String toString() {
		String s = new String("( ");
		for (Piece p : this.pieces)
			s += p + " ";
		s +=") ( ";
		for (Piece p : this.captures)
			s += p + " ";
		return s + ")";
	}
	
	
}
