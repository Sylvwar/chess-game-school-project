
public class Test {

	public static void main(String[] arg) {
		
		System.out.println("\n Board Display Test");
		
		Board b = new Board();
		System.out.println(b);
		b.getTiles().get(9).setPiece(new Pawn("white"));
		b.getTiles().get(31).setPiece(new Pawn("black"));
		b.getTiles().get(43).setPiece(new Pawn("white"));
		System.out.println(b);
		
		
		Player p = new Player(Player.BLACK_SIDE);
		System.out.println("\n " + p);
		
		for (Piece c : p.getPieces())
			System.out.println(p.getPieces().get(p.getPieces().indexOf(c)).getColor());
		
	}
	
}
