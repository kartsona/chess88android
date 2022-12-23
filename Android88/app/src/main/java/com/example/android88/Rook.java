package com.example.android88;


/**
 * 
 * @author Cliff Grandin
 * @author Kartik Sonavane
 *
 * Rook class that extends the Pieces class to set Rook Piece
 * and to check if the piece can be moved to the location 
 * is requested
 */
public class Rook extends Pieces {

	public boolean isCastlingAvailable;

	/**
	 * Constructor for Rook that sets nameAbr
	 * 
	 * @param nameAbr 
	 * name Abbreviation of Rook wR or bR
	 * 	
	 */
	public Rook(String nameAbr) {
		super(nameAbr);	
	}
	
	/**
	 * Constructor for Rook that sets Rook abbreviation, color, isCastlingAvailable
	 * 
	 * @param nameAbr
	 * name Abbreviation of Rook wR or bR
	 * @param color
	 * color of Rook wR or bR
	 * @param isCastlingAvailable
	 * isCastlingAvailable checks to see if the Rook moved and can be Castled with the King
	 */
	public Rook(String nameAbr, String color,boolean isCastlingAvailable) {
		super(nameAbr, color);
		this.isCastlingAvailable = isCastlingAvailable;
	}
	
	/**
	 * Sets the castle to true or false if the rook hasn't moved
	 * @param isCastlingAvailable
	 * for checking if the castling is available
	 * 
	 */
	public void setisCastlingAvailable(boolean isCastlingAvailable) {
		this.isCastlingAvailable = isCastlingAvailable;
	}
	
	/**
	 * Checks to see if the Rook move(Row or Column) is a valid move. 
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
//			System.out.println("PIECE FOUND!!!!");
//			System.out.println("DIFFERENT COLOR");
			if(previousX == nextX && previousY < nextY ) {
				
				for(int i = nextY-1; i >= previousY; i--) {
					if(i == previousY) {
//						System.out.println("This is a good move");
					
						return true;
					}
					else if(board[nextX][i] != null) {
						return false;
					}
				}
			}else if(previousX == nextX && previousY > nextY ) {
				for(int i = nextY+1; i <= previousY; i++) {
					if(i == previousY) {
//						System.out.println("This is a good move");
						return true;
					}else if(board[nextX][i] != null) {
						return false;
					}
				}

			}else if(previousX < nextX && previousY == nextY ) {
				for(int i = nextX-1; i >= previousX; i--) {
					if(i == previousX) {
//						System.out.println("This is a good move");
						return true;
					}else if(board[i][nextY] != null) {
						return false;
					}
				}

			}else if(previousX > nextX && previousY == nextY ) {
				for(int i = nextX+1; i <= previousX; i++) {
					if(i == previousX) {
//						System.out.println("This is a good move");
						return true;
					}else if(board[i][nextY] != null) {
						return false;
					}
				}

			}else if(nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
				return false;
			}
			return false;
		}else if(board[nextX][nextY] != null && board[nextX][nextY].color == color) {
//			System.out.println("PIECE FOUND!!!!");
//			System.out.println("SAME COLOR");
			return false;
		}else{
			if(previousX == nextX && previousY < nextY ) {
				
				for(int i = nextY; i >= previousY; i--) {
					if(i == previousY) {
//						System.out.println("This is a good move");
					
						return true;
					}
					else if(board[nextX][i] != null) {
						return false;
					}
				}
			}else if(previousX == nextX && previousY > nextY ) {
				for(int i = nextY; i <= previousY; i++) {
					if(i == previousY) {
//						System.out.println("This is a good move");
						return true;
					}else if(board[nextX][i] != null) {
						return false;
					}
				}

			}else if(previousX < nextX && previousY == nextY ) {
				for(int i = nextX; i >= previousX; i--) {
					if(i == previousX) {
//						System.out.println("This is a good move");
						return true;
					}else if(board[i][nextY] != null) {
						return false;
					}
				}

			}else if(previousX > nextX && previousY == nextY ) {
				for(int i = nextX; i <= previousX; i++) {
					if(i == previousX) {
//						System.out.println("This is a good move");
						return true;
					}else if(board[i][nextY] != null) {
						return false;
					}
				}

			}else if(nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
				return false;
			}
			
			return false;
		}
		
		
	}



	/** 
	 * Checks if the path is clear to move no jump overs
	 * 
	 * @param board		passes the board to be checke d
	 * @param color 	color of Rook piece being tested
	 * @param previousX	current x position of ROok piece
	 * @param previousY	current y position of Rook piece
	 * @param nextX		target x position of Rook piece
	 * @param nextY		target y position of Rook piece
	 * @return boolean
	 */
	public boolean checkPath(Pieces[][] board, String color, int previousX, int previousY, int nextX, int nextY){

		for(int i = 1; i <= Math.max(Math.abs(nextX - previousX), Math.abs(nextY - previousY)); i++){
			if(Math.abs(nextX - previousX) > 0 || Math.abs(nextY - previousY) > 0){
				if(board[(nextX - previousX > 0) ? previousX + i : previousX][(nextY - previousY > 0) ? previousY + i : previousY] != null){
					return false;
				}
			}
			else{
				if(board[(nextX - previousX < 0) ? previousX - i : previousX][(nextY - previousY < 0) ? previousY - i : previousY] != null){
					return false;
				}
			}
		}

		return true;
	}

	
	/** 
	 * @param color 	color of Rook piece being tested
	 * @param previousX	current x position of ROok piece
	 * @param previousY	current y position of Rook piece
	 * @param nextX		target x position of Rook piece
	 * @param nextY		target y position of Rook piece
	 * @return boolean
	 */
//	public boolean isValid(String color, int previousX, int previousY, int nextX, int nextY){
//
//		if(	(previousX >= 0 && previousX <= 7) &&
//			(previousY >= 0 && previousY <= 7) &&
//			(nextX >= 0 && nextX <= 7) &&
//			(nextY >= 0 && nextY <= 7)){
//
//				if(	(Math.abs(nextX - previousX) == 0 && Math.abs(nextY - previousY) > 0) ||
//					(Math.abs(nextX - previousX) > 0 && Math.abs(nextY - previousY) == 0)){
//
//					return true;
//
//				}
//
//		}
//
//		return false;
//	}


}
