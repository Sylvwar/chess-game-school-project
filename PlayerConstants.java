import java.util.*;

public interface PlayerConstants {
	
	public static final String WHITE_SIDE = "white";
	public static final String BLACK_SIDE = "black";
	
	/*
	public static final String[] PIECES = {"PAWN","KNIGHT","BISHOP","TOWER","KING","QWEEN"};
	public static final int nPIECE = 16;
	public static final int nPAWN = 8;
	public static final int nKNIGHT = 2;
	public static final int nBISHOP = 2;
	public static final int nTOWER = 2;
	public static final int nKING = 1;
	public static final int nQWEEN = 1;
	*/
	
	public Map<String, Integer> TYPES = new HashMap<String, Integer>() {
		{
		put("Pawn",8);
		put("Knight",2);
		put("Bishop",2);
		put("Tower",2);
		put("King",1);
		put("Queen",1);
		}
	};

	

}
