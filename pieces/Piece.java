package pieces;

import model.Tile;

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
	
	public boolean isMovement(int x1, int y1, int x2, int y2) {
		return false;
	}

}
