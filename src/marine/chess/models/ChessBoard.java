package marine.chess.models;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class ChessBoard {
	
	public Case[][] board = new Case[8][8];
//	List<List<Case>> board = new ArrayList<List<Case>>();
	
	public ChessBoard() {

		int nbCase = 0;
		
		for (int rowNum = 0; rowNum < 8; rowNum++) {
			for (int colNum = 0; colNum < 8; colNum++) {
				Case newCase = null;
				// 1ere ligne : les pieces noires
				if (rowNum == 0) {
					if (colNum == 0) {
						newCase = new Case(rowNum, colNum, "tour", "black", 1);
					} else if (colNum == 1) {
						newCase = new Case(rowNum, colNum, "cavalier", "black", 1);
					} else if (colNum == 2) {
						newCase = new Case(rowNum, colNum, "fou", "black", 1);
					} else if (colNum == 3) {
						newCase = new Case(rowNum, colNum, "roi", "black", 0);
					} else if (colNum == 4) {
						newCase = new Case(rowNum, colNum, "reine", "black", 0);
					} else if (colNum == 5) {
						newCase = new Case(rowNum, colNum, "fou", "black", 2);
					} else if (colNum == 6) {
						newCase = new Case(rowNum, colNum, "cavalier", "black", 2);
					} else if (colNum == 7) {
						newCase = new Case(rowNum, colNum, "tour", "black", 2);
					}
				}
				// 2eme ligne : les pions noires
				else if (rowNum == 1) {
					newCase = new Case(rowNum, colNum, "pion", "black", colNum);
				}
				// Ligne de 2 a 5 : cases vides
				else if (rowNum >= 2 && rowNum <= 5) {
					newCase = new Case(rowNum, colNum);
				}
				
				// 6eme ligne : les pions blancs
				else if (rowNum == 6) {
					newCase = new Case(rowNum, colNum, "pion", "white", colNum);
				}
				
				// 7eme ligne : les pieces blanches
				else if (rowNum == 7) {
					if (colNum == 0) {
						newCase = new Case(rowNum, colNum, "tour", "white", 1);
					} else if (colNum == 1) {
						newCase = new Case(rowNum, colNum, "cavalier", "white", 1);
					} else if (colNum == 2) {
						newCase = new Case(rowNum, colNum, "fou", "white", 1);
					} else if (colNum == 3) {
						newCase = new Case(rowNum, colNum, "roi", "white", 0);
					} else if (colNum == 4) {
						newCase = new Case(rowNum, colNum, "reine", "white", 0);
					} else if (colNum == 5) {
						newCase = new Case(rowNum, colNum, "fou", "white", 2);
					} else if (colNum == 6) {
						newCase = new Case(rowNum, colNum, "cavalier", "white", 2);
					} else if (colNum == 7) {
						newCase = new Case(rowNum, colNum, "tour", "white", 2);
					}
				}
				nbCase += 1;
				this.board[rowNum][colNum] = newCase;
			}
		}
	}
	
	public void ChessBoardDebugPosition() {
		System.out.println("\n-------------- Tableau des positions existantes --------------\n");
		System.out.println("nbCases : " + board.length * board[0].length + "\n");
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                System.out.print("(" + board[i][j].getX() + ", " + board[i][j].getY() + ")" +"\t");
            }
            System.out.println("\n");
        }  
        System.out.println("\n");
	}
	
	public void ChessBoardDebugPieces() {
		System.out.println("\n-------------- Tableau des pieces presantes --------------\n");
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
            	if (board[i][j].hasPiece()) {
            		System.out.print(board[i][j].getPiece().getColor().substring(0, 1) + 
            						"[" + board[i][j].getPiece().getName().substring(0, 3) + 
            						"-" + board[i][j].getPiece().getPieceNumber() + "]" +"\t");
				} else {
					System.out.print("[      ]" +"\t");
				}
            }
            System.out.println("\n");
        }  
        System.out.println("\n");
	}

}
