
public class Test {

	public static void main(String[] arg) {
		
		Game game = new Game();
		
		System.out.println(game.getBoard());
		game.genSides();
		game.getpW().delPiece(game.getBoard(), 2, 6);
		System.out.println(game.getBoard());
		
		System.out.println("\nwhite player pieces : " + game.getpW());
		
		System.out.println("black king position : " + game.getpB().getPieces().get(4).getTile());
		
		
		
	}
	
}
