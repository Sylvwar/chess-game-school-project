package model;

import java.util.*;
import pieces.*;

public class Player implements Constants {
	
	private ArrayList<Piece> pieces = new ArrayList<Piece>(16);
	private ArrayList<Piece> captures = new ArrayList<Piece>();
	private String side;
	
	// constructors 
	
	public Player(String side) {
		this.side = side;
	}
	
	// getters & setters

	public ArrayList<Piece> getPieces() {
		return pieces;
	}
	
	public ArrayList<Piece> getCaptures() {
		return captures;
	}

	public String getSide() {
		return side;
	}

	public void resetPlayer() {
		this.pieces.clear();
		this.captures.clear();
	}

}
