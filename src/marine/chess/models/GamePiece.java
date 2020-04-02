package marine.chess.models;

public class GamePiece {
	// TODO: voir enum
	private String name;
	private final String[] namesAllowed = {"tour", "fou", "cavalier", "roi", "reine", "pion"};
	
	private String color;
	private final String[] colorsAllowed = {"black", "white"};
	
	private int pieceNumber;
	
	/**
	 * Constructeur de GamePiece
	 * 
	 * @param name
	 *            nom de la piece (noms autorises : "tour", "fou", "cavalier", "roi", "reine", "pion").
	 * @param color
	 *            couleur de la piece (couleurs autorisees : "black", "white").
 	 * @param pieceNumber
	 *            int pour pour differencier des pieces identiques (le jeu contient 2 tours, 2 cavaliers, 2 fous, et 8 pions).
	 */
	public GamePiece(String name, String color, int pieceNumber) {
		if (this.CheckName(name)) {
			this.name = name;
		} else {
			this.name = "error";
		}
		
		if (this.CheckColor(color)) {
			this.color = color;
		} else {
			this.color = "error";
		}
		this.setPieceNumber(pieceNumber);
	}
	
	// Check Params
	private boolean CheckName(String name) {
		boolean success = false;
		for (int i = 0; i < namesAllowed.length; i++) {
			if (name == namesAllowed[i]) {
				success = true;
				break;
			}
		}
		return success;
	}
	
	private boolean CheckColor(String color) {
		boolean success = false;
		for (int i = 0; i < this.colorsAllowed.length; i++) {
			if (color == this.colorsAllowed[i]) {
				success = true;
				break;
			}
		}
		return success;
	}
	
	// GETTERS
	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}
	
	public int getPieceNumber() {
		return pieceNumber;
	}
	
	// SETTERS
	public void setName(String name) {
		if (this.CheckName(name)) {
			this.name = name;
		} else {
			this.name = "error";
		}
	}

	public void setColor(String color) {
		if (this.CheckColor(color)) {
			this.color = color;
		} else {
			this.color = "error";
		}
	}

	public void setPieceNumber(int pieceNumber) {
		this.pieceNumber = pieceNumber;
	}
	
}
