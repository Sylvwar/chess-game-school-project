
public class Tile {
	
	private int x;
	private int y;
	private String color;
	private Piece p;
	
	// constructors
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		if (y%2 == x%2)
			this.color = "white";
		else
			this.color = "black";
	}
	
	// getters & setters
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String getColor() {
		return color;
	}

	public Piece getPiece() {
		return p;
	}

	public void setPiece(Piece p) {
		this.p = p;
		p.setTile(this);
	}
	
	// methods

	public boolean isOccupied() {
		if (p == null)
			return false;
		return true;
	}
	

}
