
public abstract class Piece {
	
	private String color;
	private Tile tile;
	
	// constructors

	public Piece(String side) {
		this.color = side;
	}
	
	// getters & setters
	
	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// methods
	
	public String toString() {
		String s = new String();
		if (this.color == "white")
			s += "~";
		else
			s += "~";
		return s;
	}

}
