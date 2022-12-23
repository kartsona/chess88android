package com.example.android88;

/**
 * 
 * @author Cliff Grandin
 * @author Kartik Sonavane
 *
 * Knight class that extends the Pieces class to set Knight Piece
 * and to check if the piece can be moved to the location 
 * is requested
 */
public class Knight extends Pieces {
	
	/**
	 * Constructor for Knight that sets nameAbr
	 * 
	 * @param nameAbr 
	 * name Abbreviation of Knight wN or bN
	 * 	
	 */
	public Knight(String nameAbr) {
		super(nameAbr);	
	}
	
	
	/**
	 * Constructor for Queen that sets Knight abbreviation and color
	 * 
	 * @param nameAbr
	 * name Abbreviation of Knight wN or bN
	 * @param color
	 * color of Knight wN or bN
	 */
	public Knight(String nameAbr, String color) {
		super(nameAbr, color);
	}
	

	
	/**
	 * Checks to see if the Knight move(up 2 over 1, down 2 over 1 and etc) is a valid move. 
	 * It also checks to see if there is a piece at either the location it
	 * is trying to go. If the piece at the (nextX,nextY) location
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


		//System.out.println("HEJEJEJRJERJERJEJREJRJERJEJ");
		if(board[nextX][nextY] != null && board[nextX][nextY].color != color) {

			if(previousX + 1 == nextX && previousY + 2 == nextY ) {
				return true;
			}else if(previousX - 1  == nextX && previousY + 2 == nextY ) {
				return true;
			}else if(previousX + 1   == nextX && previousY - 2 == nextY ) {
				return true;
			}else if(previousX - 1  == nextX && previousY - 2 == nextY ) {
				return true;
			}else if(previousX - 2  == nextX && previousY + 1 == nextY ) {
				return true;
			}else if(previousX + 2  == nextX && previousY + 1 == nextY ) {
				return true;
			}else if(previousX - 2  == nextX && previousY - 1 == nextY ) {
				return true;
			}else if(previousX + 2  == nextX && previousY - 1 == nextY ) {
				return true;
			}else if(nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
				return false;
			}
			
			return false;
		}else if(board[nextX][nextY] != null && board[nextX][nextY].color == color) {

			return false;
		}else{
			if(previousX + 1 == nextX && previousY + 2 == nextY ) {
				return true;
			}else if(previousX - 1  == nextX && previousY + 2 == nextY ) {
				return true;
			}else if(previousX + 1   == nextX && previousY - 2 == nextY ) {
				return true;
			}else if(previousX - 1  == nextX && previousY - 2 == nextY ) {
				return true;
			}else if(previousX - 2  == nextX && previousY + 1 == nextY ) {
				return true;
			}else if(previousX + 2  == nextX && previousY + 1 == nextY ) {
				return true;
			}else if(previousX - 2  == nextX && previousY - 1 == nextY ) {
				return true;
			}else if(previousX + 2  == nextX && previousY - 1 == nextY ) {
				return true;
			}else if(nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
				return false;
			}
			
			return false;
		}
		
		
	}
	
	
}


