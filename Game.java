
public class Game {
	
	private Player pW;
	private Player pB;
	private Board board;
	//private int turn;
	
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
	
	// methods
	
	public void startGame() {
		// new board & players
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
	
	public void isPlayerTurn() {
		// return which player has to make a move
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
