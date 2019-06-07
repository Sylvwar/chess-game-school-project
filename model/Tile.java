package model;

import pieces.Piece;

/**
 * @author Mallet Maxime & Gavrillas Mara
 */

public class Tile {
	
	private int x;
	private int y;
	private String color;
	private Piece p;
	
	/**
	 * Constructor for a Tile
	 * @param x, the columns index
	 * @param y, the rows index
	 */
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		if (y%2 == x%2)
			this.color = "white";
		else
			this.color = "black";
	}
	
	/**
	 * A function that returns the x value of the Tile
	 * @return x, the columns index
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * A function that sets the x value of the Tile
	 * @param x, the columns index
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * A function that returns the y value of the Tile
	 * @return y, the rows index
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * A function that sets the y value of the Tile
	 * @param y, the rows index
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * A function that returns the color value of the Tile
	 * @return the color String
	 */
	public String getColor() {
		return color;
	}

	/**
	 * A function that returns the reference of a Piece object associated with the Tile
	 * @return a Piece reference
	 */
	public Piece getPiece() {
		return p;
	}

	/**
	 * A function that sets the reference of a Piece object associated with the Tile
	 * @param p, a Piece reference
	 */
	public void setPiece(Piece p) {
		this.p = p;
		if (p != null)
			p.setTile(this); 
	}
	
	/**
	 * A function that determines if the Tile is occupied or not
	 * @return a boolean
	 */
	public boolean isOccupied() {
		if (p != null)
			return true;
		return false;
	}
	
	public String toString() {
		return new String("( " + this.x + ", " + this.y + " )");
	}
	

}
