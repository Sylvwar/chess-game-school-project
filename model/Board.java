package model;

import pieces.Piece;

/**
 * @author Mallet Maxime & Gavrillas Mara
 */

public class Board implements Constants {
	
	private Tile[][] tiles = new Tile[DIM][DIM];
	
	/**
	 * Constructor for a Board
	 */
	public Board() {
		this.buildBoard();
	}
	
	/**
	 * A function that returns the array including all tiles of the Board
	 * @return tiles, an array of Tile object
	 */
	public Tile[][] getTiles() {
		return tiles;
	}
	
	/**
	 * A function that instantiate a new Tile for each elements of the Board's array
	 */
	private void buildBoard() {
		for (int y = 0; y < DIM; y++) 
			for (int x = 0; x < DIM; x++) 
				tiles[y][x] = new Tile(x,y);
	}
	
	/**
	 * A function that takes a Piece from specified coordinates and returns its reference
	 * @param x, the columns index
	 * @param y, the rows index
	 * @return a Piece reference
	 */
	public Piece takePiece(int x, int y) {
		Piece p = null;
		if (this.tiles[y][x].isOccupied()) {
			p = this.tiles[y][x].getPiece();
			this.tiles[y][x].setPiece(null);
		}
		return p;
	}
	
	/**
	 * A function that puts a Piece to specified coordinate
	 * @param p, a Piece reference
	 * @param x, the columns index
	 * @param y, the rows index
	 */
	public void putPiece(Piece p, int x, int y) {
		if (!this.tiles[y][x].isOccupied()) {
			this.tiles[y][x].setPiece(p);
		}
	}
	
	/**
	 * A function that determines if a vector is a legal path on the current Board
	 * @param x1, the starting x
	 * @param y1, the starting y
	 * @param x2, the ending x
	 * @param y2, the ending y
	 * @return a boolean
	 */
	public boolean isLegalPath(int x1, int y1, int x2, int y2) {
		
		int i = 0;
		int j = 0;
		
		if (Math.abs(x2-x1) != 0)
			i = (x2-x1) / (Math.abs(x2-x1));
		if (Math.abs(y2-y1) != 0)
			j = (y2-y1) / (Math.abs(y2-y1));

		int d;
		if (i == 0) d = Math.abs(y2-y1);
		else if (j == 0) d = Math.abs(x2-x1);
		else d = Math.abs(x2-x1);
		
		int x = x1;
		int y = y1;
		
		do {
			x += i;
			y += j;
			d --;
		} 
		while (d > 0 && !this.tiles[y][x].isOccupied());

		return (d <= 0);
	}
	
	/**
	 * A function that resets the Board by rebuilding the array
	 */
	public void resetBoard() {
		this.tiles = new Tile[DIM][DIM];
		this.buildBoard();
	}
	
}
