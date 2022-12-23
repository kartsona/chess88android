package com.example.android88;

/**
 * 
 * @author Cliff Grandin
 * @author Kartik Sonavane
 *
 * King class that extends the Pieces class to set King Piece
 * and to check if the piece can be moved to the location 
 * is requested
 */
public class King extends Pieces{
	
	
	public boolean isCastlingAvailable;
	
	
	/**
	 * Constructor for King that sets nameAbr
	 * 
	 * @param nameAbr 
	 * name Abbreviation of King wK or bK
	 * 	
	 */
	public King(String nameAbr) {
		super(nameAbr);	
	}
	
	
	/**
	 * Constructor for King that sets King abbreviation and color
	 * 
	 * @param nameAbr
	 * name Abbreviation of King wK or bK
	 * @param color
	 * color of King  Piece wK or bK 
	 */
	public King(String nameAbr, String color) {
		super(nameAbr, color);
	}
	
	/**
	 * Constructor for King that sets King abbreviation, color, isCastlingAvailable
	 * 
	 * @param nameAbr
	 * name Abbreviation of King wK or bK
	 * @param color
	 * color of King  Piece wK or bK 
	 * @param isCastlingAvailable
	 * isCastlingAvailable checks to see if the King moved and can be Castled with the Rook
	 */
	public King(String nameAbr, String color, boolean isCastlingAvailable) {
		super(nameAbr, color);
		this.isCastlingAvailable = isCastlingAvailable;
	}
	
	
	
	/**
	 * Checks to if the King can be castle if it hasn't moved
	 * 
	 * @param board
	 * the board is passed to check
	 * @param color
	 * color of the piece that is asking to be matched
	 * @param previousX
	 * previous x coordinate of the piece that is being moved
	 * @param previousY
	 * previous y coordinate of the piece that is being moved
	 * @param nextX
	 * next x coordinate of the piece that is being moved
	 * @param nextY
	 * next y coordinate of the piece that is being moved
	 * @return
	 * true or false if it is a valid move
	 */
	public boolean canCastle(Pieces[][] board, String color, int previousX, int previousY, int nextX, int nextY){

		if(color.equals("white")){

			if(previousX == 4 && previousY == 0 && nextX == 6 && nextY == 0){
				if(board[5][0] == null && board[6][0] == null){
					if(board[4][0] instanceof King && ((King) board[4][0]).isCastlingAvailable == true){
						//if(board[7][0] instanceof Rook && ((Rook) board[4][0]).isCastlingAvailable == true){
							return true;
							
						//}
					}
				}
			}

		}

		else if(color.equals("black")){
			if(previousX == 4 && previousY == 7 && nextX == 6 && nextY == 7){
				if(board[5][7] == null && board[6][7] == null){
					if(board[4][7] instanceof King && ((King) board[4][7]).isCastlingAvailable == true){
						//if(board[7][7] instanceof Rook && ((Rook) board[4][7]).isCastlingAvailable == true){
							return true;
						//}
					}
				}
			}
		}

		return false;
	}
	
	


	/**
	 * Checks to see if the King move(1 position top, top right,right, bottom right, bottom, ... ect.) 
	 * is a valid move. 
	 * It also checks to see if there is a piece at either the location it
	 * is trying to go or the path of the movement. If the piece at the (nextX,nextY) location
	 * is opposite the color of the piece asking than it returns that the move is valid
	 * 
	 * @param board
	 * the board is passed to check
	 * @param color
	 * color of the piece that is asking to be matched
	 * @param previousX
	 * previous x coordinate of the piece that is being moved
	 * @param previousY
	 * previous y coordinate of the piece that is being moved
	 * @param nextX
	 * next x coordinate of the piece that is being moved
	 * @param nextY
	 * next y coordinate of the piece that is being moved
	 * @return
	 * true or false if it is a valid move
	 */
	public boolean isValid(Pieces[][] board, String color, int previousX, int previousY, int nextX, int nextY) {
		
		if(board[nextX][nextY] != null && board[nextX][nextY].color != color) {

			if(previousX == nextX && previousY + 1 == nextY ) {
				return true;
			}else if(previousX + 1 == nextX && previousY + 1 == nextY ) {
				return true;
			}else if(previousX + 1 == nextX && previousY == nextY ) {
				return true;
			}else if(previousX + 1 == nextX && previousY - 1 == nextY ) {
				return true;
			}else if(previousX == nextX && previousY - 1 == nextY ) {
				return true;
			}else if(previousX - 1 == nextX && previousY -1 == nextY ) {
				return true;
			}else if(previousX - 1 == nextX && previousY == nextY ) {
				return true;
			}else if(previousX - 1 == nextX && previousY + 1 == nextY ) {
				return true;
			}else if(canCastle(board, color, previousX, previousY, nextX, nextY)) {
				return true;
			} else if(nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
				return false;
			}
		
			return false;
		}else if(board[nextX][nextY] != null && board[nextX][nextY].color == color) {

			return false;
		}else{
			if(previousX == nextX && previousY + 1 == nextY ) {
				return true;
			}else if(previousX + 1 == nextX && previousY + 1 == nextY ) {
				return true;
			}else if(previousX + 1 == nextX && previousY == nextY ) {
				return true;
			}else if(previousX + 1 == nextX && previousY - 1 == nextY ) {
				return true;
			}else if(previousX == nextX && previousY - 1 == nextY ) {
				return true;
			}else if(previousX - 1 == nextX && previousY -1 == nextY ) {
				return true;
			}else if(previousX - 1 == nextX && previousY == nextY ) {
				return true;
			}else if(previousX - 1 == nextX && previousY + 1 == nextY ) {
				return true;
			}else if(canCastle(board, color, previousX, previousY, nextX, nextY)) {
				return true;
			} else if(nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
				return false;
			}
		
			return false;
		}
	
		
	}


	
}


