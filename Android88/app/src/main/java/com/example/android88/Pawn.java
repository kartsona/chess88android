package com.example.android88;

/**
 * 
 * @author Cliff Grandin
 * @author Kartik Sonavane
 *
 * Pawn class that extends the Pieces class to set Pawn Piece
 * and to check if the piece can be moved to the location 
 * is requested
 */
public class Pawn extends Pieces {

	/**
	 * Constructor for Pawn that sets nameAbr
	 * 
	 * @param nameAbr 
	 * name Abbreviation of Pawn wp or bp
	 * 	
	 */
	public Pawn(String nameAbr) {
		super(nameAbr);
		
	}
	
	/**
	 * Constructor for Pawn that sets Pawn abbreviation and color
	 * 
	 * @param nameAbr
	 * name Abbreviation of Pawn wp or bp
	 * @param color
	 * color of Pawn  Piece wp or bp 
	 */
	public Pawn(String nameAbr, String color) {
		super(nameAbr, color);

	}
	
	
	
	
	/**
	 * /**
	 * Checks to see if the Pawn move(1 position up or 2 position up(at beginning of the game)) 
	 * is a valid move. 
	 * It also checks to see if there is a piece at either the location it
	 * is trying to go or the path of the movement. If there is a  piece at the (nextX,nextY) location
	 * then it fails. It also check to see if the the piece can be promoted to a new piece when it hits
	 * the opposite side
	 * 
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
	public boolean isValid(String color, int previousX, int previousY, int nextX, int nextY) {

		System.out.println("Pawn: isValid method met");
		
		if(color.equals("white")) {
			
//			if(isEnpassant(color,previousX, previousY, nextX, nextY) == true){
//				return true;
//			}else
			if((previousX == 0 && previousY == 1) && (previousX == nextX && previousY +2 == nextY)) {
				return true;
			}else if((previousX == 1 && previousY == 1) && (previousX == nextX && previousY +2 == nextY)) {
				return true;
			}else if((previousX == 2 && previousY == 1) && (previousX == nextX && previousY +2 == nextY)) {
				return true;
			}else if((previousX == 3 && previousY == 1) && (previousX == nextX && previousY +2 == nextY)) {
				return true;
			}else if((previousX == 4 && previousY == 1) && (previousX == nextX && previousY +2 == nextY)) {
				return true;
			}else if((previousX == 5 && previousY == 1) && (previousX == nextX && previousY +2 == nextY)) {
				return true;
			}else if((previousX == 6 && previousY == 1) && (previousX == nextX && previousY +2 == nextY)) {
				return true;
			}else if((previousX == 7 && previousY == 1) && (previousX == nextX && previousY +2 == nextY)) {
				return true;
			}else if(previousX == nextX && previousY+1 == nextY) {
				isPromotedWhite(nextX, nextY);
				return true;
			}else {
				return false;
			}
			
		}else if(color.equals("black")) {
			
			
			if((previousX == 0 && previousY == 6) && (previousX == nextX && previousY -2 == nextY)) {
				return true;
			}else if((previousX == 1 && previousY == 6) && (previousX == nextX && previousY -2 == nextY)) {
				return true;
			}else if((previousX == 2 && previousY == 6) && (previousX == nextX && previousY -2 == nextY)) {
				return true;
			}else if((previousX == 3 && previousY == 6) && (previousX == nextX && previousY -2 == nextY)) {
				return true;
			}else if((previousX == 4 && previousY == 6) && (previousX == nextX && previousY -2 == nextY)) {
				return true;
			}else if((previousX == 5 && previousY == 6) && (previousX == nextX && previousY -2 == nextY)) {
				return true;
			}else if((previousX == 6 && previousY == 6) && (previousX == nextX && previousY -2 == nextY)) {
				return true;
			}else if((previousX == 7 && previousY == 6) && (previousX == nextX && previousY -2 == nextY)) {
				return true;
			}else if(previousX == nextX && previousY-1 == nextY) {
				isPromotedBlack(nextX, nextY);
				return true;
			}else {
				return false;
			}
			
		}
		return false;
		
	}
	
	
	/**
	 * Checks to see if white pawn reaches the end of the board to be promoted
	 * 
	 * @param nextX
	 * x coordinate of end of board for white pawn to be promoted
	 * @param nextY
	 * y coordinate of end of board for white pawn to be promoted
	 * @return
	 * returns true if the position is right and false if the position is wrong
	 */
	public boolean isPromotedWhite(int nextX, int nextY) {
		if(nextX == 0 && nextY == 7) {
			return true;
		}else if(nextX == 1 && nextY == 7) {
			return true;
		}else if(nextX == 2 && nextY == 7) {
			return true;
		}else if(nextX == 3 && nextY == 7) {
			return true;
		}else if(nextX == 4 && nextY == 7) {
			return true;
		}else if(nextX == 5 && nextY == 7) {
			return true;
		}else if(nextX == 6 && nextY == 7) {
			return true;
		}else if(nextX == 7 && nextY == 7) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	
	/**
	 * Checks to see if black pawn reaches the end of the board to be promoted
	 * 
	 * @param nextX
	 * x coordinate of end of board for black pawn to be promoted
	 * @param nextY
	 * y coordinate of end of board for black pawn to be promoted
	 * @return
	 * returns true if the position is right and false if the position is wrong
	 */
	public boolean isPromotedBlack(int nextX, int nextY) {
		if(nextX == 0 && nextY == 0) {
			return true;
		}else if(nextX == 1 && nextY == 0) {
			return true;
		}else if(nextX == 2 && nextY == 0) {
			return true;
		}else if(nextX == 3 && nextY == 0) {
			return true;
		}else if(nextX == 4 && nextY == 0) {
			return true;
		}else if(nextX == 5 && nextY == 0) {
			return true;
		}else if(nextX == 6 && nextY == 0) {
			return true;
		}else if(nextX == 7 && nextY == 0) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	/**
	 * Checks to see the the diagonal capture of pawn can be performed 
	 * 
	 * @param color
	 * color of the piece that is asking to be matched
	 * @param previousX
	 * previous x coordinate of the piece that is being moved
	 * @param previousY
	 * previous y coordinate of the piece that is being moved
	 * @param color2
	 * the opposite color of the piece
	 * @param nextX
	 * next x coordinate of the piece that is being moved
	 * @param nextY
	 * next y coordinate of the piece that is being moved
	 * @return
	 * true or false if it is a valid move
	 * 
	 */
	public boolean isEnpassant(String color, int previousX, int previousY, String color2 ,int nextX, int nextY) {


		if(color.equals("white")) {
			if(color2.equals("black") && (previousX+1 == nextX && previousY+1 == nextY)) {
				return true;
			} else if(color2.equals("black") && (previousX-1 == nextX && previousY+1 == nextY)) {
				return true;
			}
			
			
		}else if (color.equals("black")) {
			if(color2.equals("white") && (previousX+1 == nextX && previousY-1 == nextY)) {
				return true;
			} else if(color2.equals("white") && (previousX-1 == nextX && previousY-1 == nextY)) {
				return true;
			}
		}
		return false;
	}

}
