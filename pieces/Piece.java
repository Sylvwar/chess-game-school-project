package pieces;

import model.Tile;

public abstract class Piece {
	
	private String color;
	private String label;
	private Tile tile;
	
	/**
	 * Constructor for a Piece
	 * @param side, the side/color of the Piece
	 * @param label, the String representation of the Piece
	 */
	public Piece(String side, String label) {
		this.color = side;
		this.label = label;
	}
	
	/**
	 * A function that returns the Tile associated to the Piece
	 * @return a Tile reference
	 */
	public Tile getTile() {
		return tile;
	}
	
	/**
	 * A function that sets the Tile associated to the Piece
	 * @param tile, a Tile reference
	 */
	public void setTile(Tile tile) {
		this.tile = tile;
	}

	/**
	 * A function that returns the color value of the Piece
	 * @return the color String
	 */
	public String getColor() {
		return color;
	}

	/**
	 * A function that returns the String label of the Piece
	 * @return the label String
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * An abstract function which will determines the right movement for each Piece
	 * @param x1, the starting x
	 * @param y1, the starting y
	 * @param x2, the ending x
	 * @param y2, the ending y
	 * @return a boolean
	 */
	public abstract boolean isMovement(int x1, int y1, int x2, int y2);

}
