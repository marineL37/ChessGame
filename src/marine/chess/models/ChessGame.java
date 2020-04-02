package marine.chess.models;

public class ChessGame {
	// jeu
	private ChessBoard chessBoard;
	private Case[][] board;
	private boolean victory = false;
	private final String[] player = {"black", "white"};
	// un tour
	private Case caseBeforeMove;
	private GamePiece pieceToMove;
	private Case caseTarget;
	private GamePiece pieceLost;
	
	public ChessGame() {
		chessBoard = new ChessBoard();
		board = chessBoard.board;
		chessBoard.ChessBoardDebugPieces();
	}

	private boolean CheckColor(String color) {
		boolean success = false;
		for (int i = 0; i < this.player.length; i++) {
			if (color == this.player[i]) {
				success = true;
				break;
			}
		}
		return success;
	}
	
	/**
	 * Constructeur de GamePiece
	 * 
	 * @param playerTurn
	 * 			couleur du joueur (couleurs autorisees : "black", "white").
	 * @param oldX, oldY
	 * 			position actuel de la piece a deplacer
	 * @param newX, newY
	 * 			destination de la piece    
	 */
	public String play(String playerTurn, int oldX, int oldY, int newX, int newY) {
		String message = "";
		caseBeforeMove = board[oldX][oldY];
		pieceToMove = caseBeforeMove.getPiece();
		caseTarget = board[newX][newY];
		pieceLost = null;
		
		if ( this.CheckColor(playerTurn) ) {
			if ( playerTurn == pieceToMove.getColor() ) {
				// Si la case de destination possede une piece
				if (caseTarget.hasPiece()) {
					// on conserve la piece qui vient de se faire prendre
					pieceLost = caseTarget.getPiece();
				}
				
				// On vide la case de départ
				board[oldX][oldY].setPiece(null);
				
				// On positionne la piece sur la nouvelle case
				board[newX][newY].setPiece(pieceToMove);
				
				if (pieceLost != null && pieceLost.getName() == "roi") {
					victory = true;
				}
			} else {
				message = "Action impossible : Le joueur '" + playerTurn  + 
						"' tente de deplacer un pion du joueur '"+ pieceToMove.getColor() + "'";
			}
			
			
		} else {
			message = "Ce n'est pas un joueur valide (joueur valide : 'black' ou 'white' uniquement).";
		}

		chessBoard.ChessBoardDebugPieces();
		return message;
	}
	
	public void cancel() {
//		System.out.println("case befor : (" + caseBeforeMove.getX() + "," +caseBeforeMove.getY() + ")" +
//						"piece to move : " + pieceToMove.getName() + "," +pieceToMove.getColor() + "," +pieceToMove.getPieceNumber());
		int oldX = caseBeforeMove.getX();
		int oldY = caseBeforeMove.getY();
		board[oldX][oldY].setPiece(pieceToMove);
		
		int newX = caseTarget.getX();
		int newY = caseTarget.getY();
		
		// Si la case de destination possedait une piece
		if (pieceLost != null) {
			// on conserve la piece qui vient de se faire prendre
			board[newX][newY].setPiece(pieceLost);
		} else {
			board[newX][newY].setPiece(null);
		}
		chessBoard.ChessBoardDebugPieces();
	}
}
