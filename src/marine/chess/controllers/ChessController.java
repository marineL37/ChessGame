package marine.chess.controllers;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import marine.chess.models.Case;
import marine.chess.models.ChessBoard;
import marine.chess.models.ChessGame;
import marine.chess.models.GamePiece;
import javafx.scene.control.Button;

// TODO : voir les methodes qui levent des exceptions pour ajouter les try/catch

public class ChessController implements Initializable{

	private ChessGame game;
	private Case[][] gameBoard;
	private Pane[][] panesBoard;
	
	// TODO : Refacto variable et leur portee
	private int oldX = 0;
	private int oldY = 0;
	private int newX = 0;
	private int newY = 0;
	private int turn = 1;
	private boolean isCancel = false;
	private boolean chessPieceIsSelected = false;
	private Node clic_1;
	private Node clic_2;
	private Pane pane_1;
	private Pane pane_2;
	
	private Image img_w_cavalier;
	private Image img_w_fou;
	private Image img_w_pion;
	private Image img_w_reine;
	private Image img_w_roi;
	private Image img_w_tour;

	private Image img_b_cavalier;
	private Image img_b_fou;
	private Image img_b_pion;
	private Image img_b_reine;
	private Image img_b_roi;
	private Image img_b_tour;
	

	
	@FXML
	private GridPane gp_chessboard;
	
	@FXML
	private Pane c0_0, c0_1, c0_2, c0_3, c0_4, c0_5, c0_6, c0_7;
	@FXML
	private Pane c1_0, c1_1, c1_2, c1_3, c1_4, c1_5, c1_6, c1_7;
	@FXML
	private Pane c2_0, c2_1, c2_2, c2_3, c2_4, c2_5, c2_6, c2_7;
	@FXML
	private Pane c3_0, c3_1, c3_2, c3_3, c3_4, c3_5, c3_6, c3_7;
	@FXML
	private Pane c4_0, c4_1, c4_2, c4_3, c4_4, c4_5, c4_6, c4_7;
	@FXML
	private Pane c5_0, c5_1, c5_2, c5_3, c5_4, c5_5, c5_6, c5_7;
	@FXML
	private Pane c6_0, c6_1, c6_2, c6_3, c6_4, c6_5, c6_6, c6_7;
	@FXML
	private Pane c7_0, c7_1, c7_2, c7_3, c7_4, c7_5, c7_6, c7_7;
	
	@FXML
	private Button btn_new_game, btn_quit, btn_cancel;

	@FXML
	private Label turnof, msg;
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Initialize panesBoard
		// TODO : voir l'introspection
		panesBoard = new Pane[8][8];
		panesBoard[0][0] = c0_0;
		panesBoard[0][1] = c0_1;
		panesBoard[0][2] = c0_2;
		panesBoard[0][3] = c0_3;
		panesBoard[0][4] = c0_4;
		panesBoard[0][5] = c0_5;
		panesBoard[0][6] = c0_6;
		panesBoard[0][7] = c0_7;
		
		panesBoard[1][0] = c1_0;
		panesBoard[1][1] = c1_1;
		panesBoard[1][2] = c1_2;
		panesBoard[1][3] = c1_3;
		panesBoard[1][4] = c1_4;
		panesBoard[1][5] = c1_5;
		panesBoard[1][6] = c1_6;
		panesBoard[1][7] = c1_7;
		
		panesBoard[2][0] = c2_0;
		panesBoard[2][1] = c2_1;
		panesBoard[2][2] = c2_2;
		panesBoard[2][3] = c2_3;
		panesBoard[2][4] = c2_4;
		panesBoard[2][5] = c2_5;
		panesBoard[2][6] = c2_6;
		panesBoard[2][7] = c2_7;
		
		panesBoard[3][0] = c3_0;
		panesBoard[3][1] = c3_1;
		panesBoard[3][2] = c3_2;
		panesBoard[3][3] = c3_3;
		panesBoard[3][4] = c3_4;
		panesBoard[3][5] = c3_5;
		panesBoard[3][6] = c3_6;
		panesBoard[3][7] = c3_7;
		
		panesBoard[4][0] = c4_0;
		panesBoard[4][1] = c4_1;
		panesBoard[4][2] = c4_2;
		panesBoard[4][3] = c4_3;
		panesBoard[4][4] = c4_4;
		panesBoard[4][5] = c4_5;
		panesBoard[4][6] = c4_6;
		panesBoard[4][7] = c4_7;
		
		panesBoard[5][0] = c5_0;
		panesBoard[5][1] = c5_1;
		panesBoard[5][2] = c5_2;
		panesBoard[5][3] = c5_3;
		panesBoard[5][4] = c5_4;
		panesBoard[5][5] = c5_5;
		panesBoard[5][6] = c5_6;
		panesBoard[5][7] = c5_7;
		
		panesBoard[6][0] = c6_0;
		panesBoard[6][1] = c6_1;
		panesBoard[6][2] = c6_2;
		panesBoard[6][3] = c6_3;
		panesBoard[6][4] = c6_4;
		panesBoard[6][5] = c6_5;
		panesBoard[6][6] = c6_6;
		panesBoard[6][7] = c6_7;
		
		panesBoard[7][0] = c7_0;
		panesBoard[7][1] = c7_1;
		panesBoard[7][2] = c7_2;
		panesBoard[7][3] = c7_3;
		panesBoard[7][4] = c7_4;
		panesBoard[7][5] = c7_5;
		panesBoard[7][6] = c7_6;
		panesBoard[7][7] = c7_7;

		// Initialize img
		img_w_cavalier = new Image("file:../../ressources/blanc_cavalier80x80.png");
		img_w_fou = new Image("file:../../ressources/blanc_fou80x80.png");
		img_w_pion = new Image("file:../../ressources/blanc_pion80x80.png");
		img_w_reine = new Image("file:../../ressources/blanc_reine80x80.png");
		img_w_roi = new Image("file:../../ressources/blanc_roi80x80.png");
		img_w_tour = new Image("file:../../ressources/blanc_tour80x80.png");

		img_b_cavalier = new Image("file:../../ressources/noir_cavalier80x80.png");
		img_b_fou = new Image("file:../../ressources/noir_fou80x80.png");
		img_b_pion = new Image("file:../../ressources/noir_pion80x80.png");
		img_b_reine = new Image("file:../../ressources/noir_reine80x80.png");
		img_b_roi = new Image("file:../../ressources/noir_roi80x80.png");
		img_b_tour = new Image("file:../../ressources/noir_tour80x80.png");
		
		
		// Add Black Img in corresponding pane
		panesBoard[0][0].getChildren().add(new ImageView(img_b_tour));
		panesBoard[0][1].getChildren().add(new ImageView(img_b_cavalier));
		panesBoard[0][2].getChildren().add(new ImageView(img_b_fou));
		panesBoard[0][3].getChildren().add(new ImageView(img_b_roi));
		panesBoard[0][4].getChildren().add(new ImageView(img_b_reine));
		panesBoard[0][5].getChildren().add(new ImageView(img_b_fou));
		panesBoard[0][6].getChildren().add(new ImageView(img_b_cavalier));
		panesBoard[0][7].getChildren().add(new ImageView(img_b_tour));
		
		panesBoard[1][0].getChildren().add(new ImageView(img_b_pion));
		panesBoard[1][1].getChildren().add(new ImageView(img_b_pion));
		panesBoard[1][2].getChildren().add(new ImageView(img_b_pion));
		panesBoard[1][3].getChildren().add(new ImageView(img_b_pion));
		panesBoard[1][4].getChildren().add(new ImageView(img_b_pion));
		panesBoard[1][5].getChildren().add(new ImageView(img_b_pion));
		panesBoard[1][6].getChildren().add(new ImageView(img_b_pion));
		panesBoard[1][7].getChildren().add(new ImageView(img_b_pion));
		
		for (int rowNum = 2; rowNum < 5; rowNum++) {
			for (int colNum = 2; colNum < 5; colNum++) {
				if ( !panesBoard[rowNum][colNum].getChildren().isEmpty() ) {
					panesBoard[rowNum][colNum].getChildren().remove(0);
				}
			}
		}
		
		// Add White Img in corresponding pane
		panesBoard[6][0].getChildren().add(new ImageView(img_w_pion));
		panesBoard[6][1].getChildren().add(new ImageView(img_w_pion));
		panesBoard[6][2].getChildren().add(new ImageView(img_w_pion));
		panesBoard[6][3].getChildren().add(new ImageView(img_w_pion));
		panesBoard[6][4].getChildren().add(new ImageView(img_w_pion));
		panesBoard[6][5].getChildren().add(new ImageView(img_w_pion));
		panesBoard[6][6].getChildren().add(new ImageView(img_w_pion));
		panesBoard[6][7].getChildren().add(new ImageView(img_w_pion));
		
		panesBoard[7][0].getChildren().add(new ImageView(img_w_tour));
		panesBoard[7][1].getChildren().add(new ImageView(img_w_cavalier));
		panesBoard[7][2].getChildren().add(new ImageView(img_w_fou));
		panesBoard[7][3].getChildren().add(new ImageView(img_w_roi));
		panesBoard[7][4].getChildren().add(new ImageView(img_w_reine));
		panesBoard[7][5].getChildren().add(new ImageView(img_w_fou));
		panesBoard[7][6].getChildren().add(new ImageView(img_w_cavalier));
		panesBoard[7][7].getChildren().add(new ImageView(img_w_tour));
		
		// Initialize Game and Board
		game = new ChessGame();
		gameBoard = game.GetBoard();
		
		// Manipulation des bouton
		btn_quit.setOnMouseClicked(value -> {
			Platform.exit();
		});
		
		// Manipulation des bouton
		btn_cancel.setOnMouseClicked(value -> {
			if ( msg.getText().length() == 0 && !isCancel ) { // TODO verif pas nouvelle partie
				game.cancel();
				this.updatePanesBoard();
				turn -= 1;
				this.updateTurn();
				isCancel = true;
			}
		});
		
		btn_new_game.setOnMouseClicked(value -> {
			this.initialize(location, resources);
		});
	}
	
	@FXML
	private void selectPane(MouseEvent e) {
		String message = "";
		this.updateTurn();
		
		if ( chessPieceIsSelected == false ) {
			clic_1 = (Node) e.getSource();
			pane_1 = (Pane) clic_1;
			String style = pane_1.getStyle();
			pane_1.setStyle(style + " -fx-border-color: blue; -fx-border-width: 3");
			oldX = GridPane.getRowIndex(pane_1);
			oldY = GridPane.getColumnIndex(pane_1);
			if ( gameBoard[oldX][oldY].hasPiece() ) {
				chessPieceIsSelected = true;
			}
			
		} else {
			
			chessPieceIsSelected = false;
			clic_2 = (Node) e.getSource();
			pane_2 = (Pane) clic_2;
			newX = GridPane.getRowIndex(pane_2);
			newY = GridPane.getColumnIndex(pane_2);
			
			if (turn % 2 != 0) {
				message = game.play("white", oldX, oldY, newX, newY);
				
			} else {
				message = game.play("black", oldX, oldY, newX, newY);
			}
			
			if (message.length() == 0) {
				turn += 1;
			}
			
			msg.setText(message);
			
			this.updatePanesBoard();
			this.updateTurn();
			
			pane_1 = null;
			pane_2 = null;
		}
	}

	private void updateTurn() {
		if (turn % 2 != 0) {
			turnof.setText("Tour des : Blancs");			
		} else {
			turnof.setText("Tour des : Noirs");
		}
	}
	
	private void updatePanesBoard() {
		// Synchronize GameBoard and PanesBoard images
//		System.out.println("------------ debug ------------");
		for (int rowNum = 0; rowNum < gameBoard.length; rowNum++) {
			for (int colNum = 0; colNum < gameBoard.length; colNum++) {
				panesBoard[rowNum][colNum].setStyle("");
				if ( !panesBoard[rowNum][colNum].getChildren().isEmpty() ) {
					panesBoard[rowNum][colNum].getChildren().remove(0); // enlever l'image
				}
				
				if ( gameBoard[rowNum][colNum].hasPiece() ) {
					String piece = gameBoard[rowNum][colNum].getPiece().getName();
					String colorPiece = gameBoard[rowNum][colNum].getPiece().getColor();
					if (colorPiece.equals("black")) {
						if (piece.equals("pion")) {
							panesBoard[rowNum][colNum].getChildren().add(new ImageView(img_b_pion)); // ajouter l'image
						} else if (piece.equals("tour")) {
							panesBoard[rowNum][colNum].getChildren().add(new ImageView(img_b_tour));
						} else if (piece.equals("cavalier")) {
							panesBoard[rowNum][colNum].getChildren().add(new ImageView(img_b_cavalier));
						} else if (piece.equals("fou")) {
							panesBoard[rowNum][colNum].getChildren().add(new ImageView(img_b_fou));
						} else if (piece.equals("roi")) {
							panesBoard[rowNum][colNum].getChildren().add(new ImageView(img_b_roi));
						} else if (piece.equals("reine")) {
							panesBoard[rowNum][colNum].getChildren().add(new ImageView(img_b_reine));
						}
					} else if (colorPiece.equals("white") ){
						if (piece.equals("pion")) {
							panesBoard[rowNum][colNum].getChildren().add(new ImageView(img_w_pion));
						} else if (piece.equals("tour")) {
							panesBoard[rowNum][colNum].getChildren().add(new ImageView(img_w_tour));
						} else if (piece.equals("cavalier")) {
							panesBoard[rowNum][colNum].getChildren().add(new ImageView(img_w_cavalier));
						} else if (piece.equals("fou")) {
							panesBoard[rowNum][colNum].getChildren().add(new ImageView(img_w_fou));
						} else if (piece.equals("roi")) {
							panesBoard[rowNum][colNum].getChildren().add(new ImageView(img_w_roi));
						} else if (piece.equals("reine")) {
							panesBoard[rowNum][colNum].getChildren().add(new ImageView(img_w_reine));
						}
					}
					
				}
			}
		}
		game.GetChessBoard().ChessBoardDebugPieces();
	}


}
