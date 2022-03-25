package model;

import java.io.*;
import java.util.*;
import pieces.*;
import view.*;

/**
 * @author Mallet Maxime & Gavrilas Mara
 */

public class Game {
	
	private Player pW;
	private Player pB;
	private Board board;
	private Display display;
	private boolean whiteTurn;
	private boolean run = false;
	
	/**
	 * Constructor for a Game
	 */
	public Game() {
		this.pW = new Player(Player.WHITE_SIDE);
		this.pB = new Player(Player.BLACK_SIDE);
		this.board = new Board();
		this.display = new Display(this);
	}
	
	/**
	 * A function that returns the white Player object of the Game
	 * @return a Player reference
	 */
	public Player getpW() {
		return pW;
	}
	
	/**
	 * A function that sets the white Player object of the Game
	 * @param pW, a Player reference
	 */
	public void setpW(Player pW) {
		this.pW = pW;
	}
	
	/**
	 * A function that returns the black Player object of the Game
	 * @return a Player reference
	 */
	public Player getpB() {
		return pB;
	}
	
	/**
	 * A function that sets the black Player object of the Game
	 * @param pB, a Player reference
	 */
	public void setpB(Player pB) {
		this.pB = pB;
	}

	/**
	 * A function that returns the Board of the Game
	 * @return a Board reference
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * A function that sets the Board of the Game
	 * @param board, a Board reference
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	
	/**
	 * A function that "starts" the Game by displaying menu and asking for select an option
	 */
	public void playGame() {
		
		display.displayMenu();
		int select = selectOption();
		
		if (select == 1) {
			if (isRunning()) {
				display.displayTag(select);
				playTurn();
			}
			else {
				display.displayWarning(1);
				playGame();
			}
		}
		else if (select == 2) {
			display.displayTag(select);
			newGame();
			playTurn();
		}
		else if (select == 3) {
			display.displayTag(select);
			loadGame("Save.data");
			playTurn();
		}
		else if (select == 4) {
			display.displayTag(select);
			saveGame("Save.data");
			playGame();
		}
		else {
			display.displayTag(select);
			System.exit(0);
		}
		
	}
	
	/**
	 * A function that returns the selection value asked in a control loop
	 * @return an integer representing an option
	 */
	public int selectOption() {
		
		int select;
		
		do {
			select = Integer.parseInt(display.displayInput());
		}
		while ( !(1 <= select) || !(select <= 5) );
		
		return select;
		
	}
	
	/**
	 * A function that plays the core loop of the Game, displaying board and asking for moves
	 */
	public void playTurn() {
		
		display.displayBoard();
		while (askMove()) {
			display.displayBoard();
		}
		playGame();
		
	}
	
	/**
	 * A function that supervises move inputs and returns true when a move is legal and done
	 * Otherwise it returns false and go back to menu
	 * @return a boolean
	 */
	public boolean askMove() {
		
		String move;
		
		display.displayWarning(2);
		do {
			move = display.displayInput();
		}
		while (!isLegalWriting(move));
		
		if (move.charAt(0) != 'M') {
			int x1 = move.charAt(0) - 'a';
			int y1 = Character.getNumericValue(move.charAt(1)) - 1;
			int x2 = move.charAt(2) - 'a';
			int y2 = Character.getNumericValue(move.charAt(3)) - 1;
			
			this.makeMove(x1,y1,x2,y2);
			return true;
		}
		display.displayTag(0);
		return false;
		
	}
	
	/**
	 * A function that checks for a move to be writing legally and if it's right, returns true
	 * @param move, a String representing coordinates with 4 char
	 * @return a boolean
	 */
	public boolean isLegalWriting(String move) {
		
		if (move.charAt(0) != 'M') {
			
			if (move.length() != 4)
				return false;
			
			int x1 = move.charAt(0);
			int y1 = Character.getNumericValue(move.charAt(1));
			int x2 = move.charAt(2);
			int y2 = Character.getNumericValue(move.charAt(3));
			int a = 'a';
			int h = 'h';
			
			return ( (1 <= y1 && y1 <= 8) && (1 <= y2 && y2 <= 8) && (a <= x1 && x1 <= h) && (a <= x2 && x2 <= h) );
		}
		return true;
		
	}
	
	/**
	 * A function that manages making a move
	 * @param x1, the starting x
	 * @param y1, the starting y
	 * @param x2, the ending x
	 * @param y2, the ending y
	 */
	public void makeMove(int x1, int y1, int x2, int y2) {
		
		Piece p1 = null;
		Piece p2;
		
		if (this.isLegalMove(x1,y1,x2,y2)) {
			
			p1 = this.board.takePiece(x1,y1);
			p2 = this.board.takePiece(x2,y2);
			
			if (p2 != null) {
				if (p1.getColor() == "white")
					capturePiece(this.pW,p2,x2,y2);
				else
					capturePiece(this.pB,p2,x2,y2);
			}
			
			this.board.putPiece(p1,x2,y2);
			nextTurn();
			
		}
		
	}
	
	/**
	 * A function that checks for a move to be legal, for movement types within the current Board
	 * @param x1, the starting x
	 * @param y1, the starting y
	 * @param x2, the ending x
	 * @param y2, the ending y
	 * @return a boolean
	 */
	public boolean isLegalMove(int x1, int y1, int x2, int y2) {
		
		Piece p1 = this.board.getTiles()[y1][x1].getPiece();
		if ( ( p1.getColor().equals("white") && !isWhiteTurn() ) || ( p1.getColor().equals("black") && isWhiteTurn() ) )
			return false;
		Piece p2 = this.board.getTiles()[y2][x2].getPiece();
		
		if ( !(p1 instanceof Knight) && !(p1 instanceof Pawn) ) {
			return ( p1.isMovement(x1,y1,x2,y2) && this.board.isLegalPath(x1,y1,x2,y2) && (p2 == null || !p2.getColor().equals(p1.getColor())) );
		}
		else if (p1 instanceof Knight) {
			return ( p1.isMovement(x1,y1,x2,y2) && (p2 == null || !p2.getColor().equals(p1.getColor())) );
		}
		else if (p1 instanceof Pawn) {
			return ( ( p1.isMovement(x1,y1,x2,y2) && (p2 == null) ) || ( ((Pawn)p1).isCapturing(x1,y1,x2,y2) && (p2 != null) && !p2.getColor().equals(p1.getColor()) ) );
		}
		return false;
		
	}

	/**
	 * A function that resets the Game before regenerate a new one
	 */
	public void newGame() {
		
		this.pW.resetPlayer();
		this.pB.resetPlayer();
		this.board.resetBoard();
		this.genSides();
		this.whiteTurn = true;
		this.setRunning(true);
	}
	
	/**
	 * A function that loads the Game from a saved file
	 * @param file, a String representing the text file path
	 */
	public void loadGame(String file) {
		
		this.pW.resetPlayer();
		this.pB.resetPlayer();
		this.board.resetBoard();
		this.setRunning(true);
		
		try {
		      BufferedReader in = new BufferedReader(new FileReader(file));
		      
		      this.whiteTurn = Boolean.parseBoolean(in.readLine());
		      
		      String ligne;
		      for (int y = 0; y < Board.DIM; y++) {
		    	  ligne = in.readLine();
		    	  
		    	  StringTokenizer tokenizer = new StringTokenizer(ligne);
		    	  for (int x = 0; x < Board.DIM; x++) {
		    		  
		    		  String token;
		    		  token = tokenizer.nextToken();
		    		  
		    		  token = token.substring(token.indexOf("[") + 1, token.indexOf("]"));
		    		  
		    		  if (!token.equals("")) {

			    		  if (token.substring(1, 2).equals("1")) {
			    			  if (token.substring(0, 1).equals("P"))
			    				  addPiece(this.pW, new Pawn(this.pW.getSide()), x, y);
			    			  else if (token.substring(0, 1).equals("R"))
			    				  addPiece(this.pW, new Rook(this.pW.getSide()), x, y);
			    			  else if (token.substring(0, 1).equals("H"))
			    				  addPiece(this.pW, new Knight(this.pW.getSide()), x, y);
			    			  else if (token.substring(0, 1).equals("B"))
			    				  addPiece(this.pW, new Bishop(this.pW.getSide()), x, y);
			    			  else if (token.substring(0, 1).equals("Q"))
			    				  addPiece(this.pW, new Queen(this.pW.getSide()), x, y);
			    			  else if (token.substring(0, 1).equals("K"))
			    				  addPiece(this.pW, new King(this.pW.getSide()), x, y);
			    		  }
			    		  
			    		  else {
			    			  if (token.substring(0, 1).equals("P"))
			    				  addPiece(this.pB, new Pawn(this.pB.getSide()), x, y);
			    			  else if (token.substring(0, 1).equals("R"))
			    				  addPiece(this.pB, new Rook(this.pB.getSide()), x, y);
			    			  else if (token.substring(0, 1).equals("H"))
			    				  addPiece(this.pB, new Knight(this.pB.getSide()), x, y);
			    			  else if (token.substring(0, 1).equals("B"))
			    				  addPiece(this.pB, new Bishop(this.pB.getSide()), x, y);
			    			  else if (token.substring(0, 1).equals("Q"))
			    				  addPiece(this.pB, new Queen(this.pB.getSide()), x, y);
			    			  else if (token.substring(0, 1).equals("K"))
			    				  addPiece(this.pB, new King(this.pB.getSide()), x, y);
			    		  }
		    		  
		    		  }
		    		  
		    	  }
		    	  
		      }
		      
		      in.close();
		    }

		    catch(IOException e) {
		      System.out.println(e);
		    }
		
	}
	
	/**
	 * A function that saves the game in a saving file
	 * @param file, a String representing the text file path
	 */
	public void saveGame(String file) {

		try {
		      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		      
		      out.println(this.isWhiteTurn());
		      
		      for (int y = 0; y < Board.DIM; y++) {
		    	  
		    	  for (int x = 0; x < Board.DIM; x++) {
		    		  
		    		  if (this.board.getTiles()[y][x].isOccupied()) {
		    			  if (this.board.getTiles()[y][x].getPiece().getColor().equals("white"))
			    			  out.print( "[" + this.board.getTiles()[y][x].getPiece().getLabel() + 1 + "] " );
			    		  else
			    			  out.print( "[" + this.board.getTiles()[y][x].getPiece().getLabel() + 2 + "] " );
		    		  }
		    		  else {
		    			  out.print( "[] " );
		    		  }
  
		    	  }
		    	  out.print("\n");
		    	  
		      }
		      
		      out.close();
		    }

	    catch(IOException e) {
	      System.out.println(e);
	    }
				
	}
	
	
	/**
	 * A function that return if the game is currently running
	 * @return a boolean
	 */
	public boolean isRunning() {
		return this.run;
	}
	
	/**
	 * A function that set the running state of the Game
	 * @param run, a boolean
	 */
	public void setRunning(boolean run) {
		this.run = run;
	}
	
	/**
	 * A function that returns if it's white turn
	 * @return a boolean
	 */
	public boolean isWhiteTurn() {
		return this.whiteTurn;
	}
	
	/**
	 * A function that return the Player's opponent reference
	 * @param player, a Player reference
	 * @return a Player reference
	 */
	public Player getOpponent(Player player) {
		if (player.getSide().equals("white"))
			return pB;
		else
			return pW;
	}
	
	/**
	 * A function that switch turn value
	 */
	public void nextTurn() {
		this.whiteTurn = !this.whiteTurn;
	}
	
	/**
	 * A function that add a Piece on the Board and associates with his Player
	 * @param player, a Player reference
	 * @param p, a Piece reference
	 * @param x, the columns index
	 * @param y, the rows index
	 */
	public void addPiece(Player player, Piece p, int x, int y) {
		this.board.putPiece(p, x, y);
		player.getPieces().add(p);
	}
	
	/**
	 * A function that delete a Piece from the Board and 
	 * @param player, a Player reference
	 * @param x, the columns index
	 * @param y, the rows index
	 */
	public void delPiece(Player player, int x, int y) {
		Piece p = this.board.takePiece(x, y);
		player.getPieces().remove(p);
	}
	
	/**
	 * A function that switch a Piece from his Player list to the Opponent's captures
	 * @param player, a Player reference
	 * @param p, a Piece reference
	 * @param x, the columns index
	 * @param y, the rows index
	 */
	public void capturePiece(Player player, Piece p, int x, int y) {
		player.getCaptures().add(p);
		delPiece(getOpponent(player), x, y);
	}
	
	/**
	 * A function that generate Pieces from both sides
	 */
	public void genSides() {
		genWhite();
		genBlack();
	}
	
	/**
	 * A function that generate Pieces for white Player
	 */
	public void genWhite() {
		
		addPiece(this.pW, new Rook(this.pW.getSide()), 0, 7);
		addPiece(this.pW, new Knight(this.pW.getSide()), 1, 7);
		addPiece(this.pW, new Bishop(this.pW.getSide()), 2, 7);
		addPiece(this.pW, new Queen(this.pW.getSide()), 3, 7);
		addPiece(this.pW, new King(this.pW.getSide()), 4, 7);
		addPiece(this.pW, new Bishop(this.pW.getSide()), 5, 7);
		addPiece(this.pW, new Knight(this.pW.getSide()), 6, 7);
		addPiece(this.pW, new Rook(this.pW.getSide()), 7, 7);
		
		addPiece(this.pW, new Pawn(this.pW.getSide()), 0, 6);
		addPiece(this.pW, new Pawn(this.pW.getSide()), 1, 6);
		addPiece(this.pW, new Pawn(this.pW.getSide()), 2, 6);
		addPiece(this.pW, new Pawn(this.pW.getSide()), 3, 6);
		addPiece(this.pW, new Pawn(this.pW.getSide()), 4, 6);
		addPiece(this.pW, new Pawn(this.pW.getSide()), 5, 6);
		addPiece(this.pW, new Pawn(this.pW.getSide()), 6, 6);
		addPiece(this.pW, new Pawn(this.pW.getSide()), 7, 6);
		
	}
	
	/**
	 * A function that generate Pieces for black Player
	 */
	public void genBlack() {
		
		addPiece(this.pB, new Rook(this.pB.getSide()), 0, 0);
		addPiece(this.pB, new Knight(this.pB.getSide()), 1, 0);
		addPiece(this.pB, new Bishop(this.pB.getSide()), 2, 0);
		addPiece(this.pB, new Queen(this.pB.getSide()), 3, 0);
		addPiece(this.pB, new King(this.pB.getSide()), 4, 0);
		addPiece(this.pB, new Bishop(this.pB.getSide()), 5, 0);
		addPiece(this.pB, new Knight(this.pB.getSide()), 6, 0);
		addPiece(this.pB, new Rook(this.pB.getSide()), 7, 0);
		
		addPiece(this.pB, new Pawn(this.pB.getSide()), 0, 1);
		addPiece(this.pB, new Pawn(this.pB.getSide()), 1, 1);
		addPiece(this.pB, new Pawn(this.pB.getSide()), 2, 1);
		addPiece(this.pB, new Pawn(this.pB.getSide()), 3, 1);
		addPiece(this.pB, new Pawn(this.pB.getSide()), 4, 1);
		addPiece(this.pB, new Pawn(this.pB.getSide()), 5, 1);
		addPiece(this.pB, new Pawn(this.pB.getSide()), 6, 1);
		addPiece(this.pB, new Pawn(this.pB.getSide()), 7, 1);
		
	}
	
}
