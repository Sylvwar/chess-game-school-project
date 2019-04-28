import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Player implements PlayerConstants {
	
	private ArrayList<Piece> pieces = new ArrayList<Piece>(16);
	private String side;
	
	// constructors 
	
	public Player(String side) {
		this.side = side;
		this.genPieces();
	}
	
	// getters & setters

	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	public String getSide() {
		return side;
	}

	// methods
	
	private void genPieces() {
		for (String type : TYPES.keySet()) {
			for (int i = 0; i < TYPES.get(type); i++) {
				try {
					Class c = Class.forName(type);
					this.pieces.add((Piece)c.getConstructor(String.class).newInstance(side));
				} 
				catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | SecurityException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String toString() {
		String s = new String("(");
		for (Piece p : this.pieces)
			s += p;
		return s+")";
	}
	
	
}
