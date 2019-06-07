package model;

public interface Constants {
	
	// Player sides
	public static final String WHITE_SIDE = "white";
	public static final String BLACK_SIDE = "black";
	
	// Board dimensions
	public static final int DIM = 8;
	public static final int TOTAL_LEN = DIM*DIM;
	
	// terminal colors
	public static final String BG_WHITE = "\u001B[47m";
	public static final String BG_BLACK = "\u001B[40m";
	public static final String WHITE = "\u001B[37m";
	public static final String BLACK = "\u001B[30m";
	
}
