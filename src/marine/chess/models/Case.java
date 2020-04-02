package marine.chess.models;

public class Case {
	private int x;
	private int y;
	private boolean hasPiece;
	private GamePiece piece;
	
	
	/**
	 * Constructeur de Case possedant une piece
	 * 
	 * @param x
	 *            entier representant la position en x (le numero de la ligne).
	 * @param y
	 *            entier representant la position en y (le numero de la colonne).

	 * @param pieceName
	 *            nom de la piece presente ou "" si pas de piece (noms autorises : "tour", "fou", "cavalier", "roi", "reine", "pion").
	 * @param pieceColor
	 *            couleur de la piece presente ou "" si pas de piece (couleurs autorisees : "black", "white").
	 * @param pieceNumber
	 *            int pour pour differencier des pieces identiques (le jeu contient 2 tours, 2 cavaliers, 2 fous, et 8 pions).
	 */
	public Case(int x, int y, String pieceName, String pieceColor, int pieceNumber) { // TODO: refaire avec l'objet piece
		this.x = x;
		this.y = y;
		this.hasPiece = true;
		this.piece = new GamePiece(pieceName, pieceColor, pieceNumber);
	}
	
	/**
	 * Constructeur de Case vide
	 * 
	 * @param x
	 *            entier representant la position en x (le numero de la ligne).
	 * @param y
	 *            entier representant la position en y (le numero de la colonne).
	 */
	public Case(int x, int y) {
		this.x = x;
		this.y = y;
		this.hasPiece = false;
		this.piece = null;
	}

	
	// GETTERS
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean hasPiece() {
		return hasPiece;
	}

	public GamePiece getPiece() {
		return piece;
	}
	
	
	// SETTERS
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setHasPiece(boolean hasPiece) {
		this.hasPiece = hasPiece;
	}
	
	public void setPiece(GamePiece piece) {
		this.piece = piece;
		if (piece != null) {
			this.hasPiece = true;
		} else {
			this.hasPiece = false;
		}
	}
}
