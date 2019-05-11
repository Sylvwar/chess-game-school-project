import java.util.*;

public interface PlayerConstants {
	
	public static final String WHITE_SIDE = "white";
	public static final String BLACK_SIDE = "black";
	
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
