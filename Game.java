import java.util.*;

public class Game {
	
	private Player pW;
	private Player pB;
	private Board board;
	private boolean whiteTurn;
	
	// constructors
	
	public Game() {
		this.pW = new Player(Player.WHITE_SIDE);
		this.pB = new Player(Player.BLACK_SIDE);
		this.board = new Board();
	}
	
	// getters & setters

	public Player getpW() {
		return pW;
	}

	public void setpW(Player pW) {
		this.pW = pW;
	}

	public Player getpB() {
		return pB;
	}

	public void setpB(Player pB) {
		this.pB = pB;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	// UI methods
	
	public void playGame() {
		
		displayMenu();
		int select = selectOption();
		
		if (select == 1) {
			System.out.println("# Resume");
			playTurn();
		}
		else if (select == 2) {
			System.out.println("# New");
			newGame();
			playTurn();
		}
		else if (select == 3) {
			System.out.println("# Load");
		}
		else if (select == 4) {
			System.out.println("# Save");
		}
		else {
			System.out.println("# Quit");
			System.exit(0);
		}
		
	}
	
	public int selectOption() {
		
		Scanner sc = new Scanner(System.in);
		int select;
		
		do {
			System.out.print("\n> ");
			select = sc.nextInt();
		}
		while ( !(1 <= select) || !(select <= 5));
		
		return select;
		
	}
	
	public void playTurn() {
		
		System.out.println(this.board);
		while (askMove()) {
			System.out.println(this.board);
		}
		playGame();
		
	}
	
	public boolean askMove() {
		
		Scanner sc = new Scanner(System.in);
		String move;
		
		do {
			System.out.print("\n> ");
			move = sc.next();
		}
		while (!isLegalWritting(move));
		
		if (move.charAt(0) != 'M') {
			int x1 = move.charAt(0) - 'a';
			int y1 = Character.getNumericValue(move.charAt(1)) - 1;
			int x2 = move.charAt(2) - 'a';
			int y2 = Character.getNumericValue(move.charAt(3)) - 1;
			
			this.makeMove(x1,y1,x2,y2);
			return true;
		}
		System.out.println("# Menu\n");
		return false;
					
		//sc.close();
		
	}
	
	public boolean isLegalWritting(String move) {
		
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
	
	public void displayMenu() {
		System.out.println("1. Resume");
		System.out.println("2. New");
		System.out.println("3. Load");
		System.out.println("4. Save");
		System.out.println("5. Quit");
	}
	
	// Moving methods
	
	public void makeMove(int x1, int y1, int x2, int y2) {
		
		Piece p1 = null;
		Piece p2;
		
		if (this.isLegalMove(x1,y1,x2,y2)) {
			
			p1 = this.board.takePiece(x1,y1);
			p2 = this.board.takePiece(x2,y2);
			
			if (p2 != null) {
				if (p1.getColor() == "white")
					this.pW.capturePiece(this.board,this.pB,p2,x2,y2);
				else
					this.pB.capturePiece(this.board,this.pW,p2,x2,y2);
			}
			
			this.board.putPiece(p1,x2,y2);
			nextTurn();
			
		}
		
	}
	
	public boolean isLegalMove(int x1, int y1, int x2, int y2) {
		
		Piece p1 = this.board.getTiles().get(x1+y1*Board.DIM).getPiece();
		if ( ( p1.getColor().equals("white") && !isWhiteTurn() ) || ( p1.getColor().equals("black") && isWhiteTurn() ) )
			return false;
		Piece p2 = this.board.getTiles().get(x2+y2*Board.DIM).getPiece();
		
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
	
	// methods
	
	public void newGame() {
		this.pW.resetPlayer();
		this.pB.resetPlayer();
		this.board.resetBoard();
		genSides();
		this.whiteTurn = true;
	}
	
	public void loadGame() {
		// load board & players
	}
	
	public void saveGame() {
		// save board & players
	}
	
	public void isRunning() {
		// test if a game is currently available
	}
	
	public boolean isWhiteTurn() {
		return this.whiteTurn;
	}
	
	public void nextTurn() {
		this.whiteTurn = !this.whiteTurn;
	}
	
	public void genSides() {
		
		this.pW.addPiece(this.board, new Rook(this.pW.getSide()), 0, 7);
		this.pW.addPiece(this.board, new Knight(this.pW.getSide()), 1, 7);
		this.pW.addPiece(this.board, new Bishop(this.pW.getSide()), 2, 7);
		this.pW.addPiece(this.board, new Queen(this.pW.getSide()), 3, 7);
		this.pW.addPiece(this.board, new King(this.pW.getSide()), 4, 7);
		this.pW.addPiece(this.board, new Bishop(this.pW.getSide()), 5, 7);
		this.pW.addPiece(this.board, new Knight(this.pW.getSide()), 6, 7);
		this.pW.addPiece(this.board, new Rook(this.pW.getSide()), 7, 7);
		
		this.pW.addPiece(this.board, new Pawn(this.pW.getSide()), 0, 6);
		this.pW.addPiece(this.board, new Pawn(this.pW.getSide()), 1, 6);
		this.pW.addPiece(this.board, new Pawn(this.pW.getSide()), 2, 6);
		this.pW.addPiece(this.board, new Pawn(this.pW.getSide()), 3, 6);
		this.pW.addPiece(this.board, new Pawn(this.pW.getSide()), 4, 6);
		this.pW.addPiece(this.board, new Pawn(this.pW.getSide()), 5, 6);
		this.pW.addPiece(this.board, new Pawn(this.pW.getSide()), 6, 6);
		this.pW.addPiece(this.board, new Pawn(this.pW.getSide()), 7, 6);
		
		this.pB.addPiece(this.board, new Rook(this.pB.getSide()), 0, 0);
		this.pB.addPiece(this.board, new Knight(this.pB.getSide()), 1, 0);
		this.pB.addPiece(this.board, new Bishop(this.pB.getSide()), 2, 0);
		this.pB.addPiece(this.board, new Queen(this.pB.getSide()), 3, 0);
		this.pB.addPiece(this.board, new King(this.pB.getSide()), 4, 0);
		this.pB.addPiece(this.board, new Bishop(this.pB.getSide()), 5, 0);
		this.pB.addPiece(this.board, new Knight(this.pB.getSide()), 6, 0);
		this.pB.addPiece(this.board, new Rook(this.pB.getSide()), 7, 0);
		
		this.pB.addPiece(this.board, new Pawn(this.pB.getSide()), 0, 1);
		this.pB.addPiece(this.board, new Pawn(this.pB.getSide()), 1, 1);
		this.pB.addPiece(this.board, new Pawn(this.pB.getSide()), 2, 1);
		this.pB.addPiece(this.board, new Pawn(this.pB.getSide()), 3, 1);
		this.pB.addPiece(this.board, new Pawn(this.pB.getSide()), 4, 1);
		this.pB.addPiece(this.board, new Pawn(this.pB.getSide()), 5, 1);
		this.pB.addPiece(this.board, new Pawn(this.pB.getSide()), 6, 1);
		this.pB.addPiece(this.board, new Pawn(this.pB.getSide()), 7, 1);
		
	}
	
}
