package com.example.android88;



/**
 * 
 * @author Cliff Grandin
 * @author Kartik Sonavane
 *
 * Bishop class that extends the Pieces class to set Bishop Piece
 * and to check if the piece can be moved to the location 
 * is requested
 */
public class Bishop extends Pieces {
	
	/**
	 * Constructor for Bishop that sets nameAbr
	 * 
	 * @param nameAbr 
	 * name Abbreviation of Bishop bB or wB
	 * 	
	 */
	public Bishop(String nameAbr) {
		super(nameAbr);	
	}

	
	/**
	 * Constructor for Bishop that sets Bishop abbreviation and color
	 * 
	 * @param nameAbr
	 * name Abbreviation of Bishop bB or wB
	 * @param color
	 * color of Bishop Piece bB or wB
	 */
	public Bishop(String nameAbr, String color) {
		super(nameAbr, color);

	}
	
	
	
	
	/**
	 * Checks to see if the Bishop move(Diagonally) is a valid move. 
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
	public boolean isValid(Pieces[][] board,String color, int previousX, int previousY, int nextX, int nextY) {
		
		if(board[nextX][nextY] != null && board[nextX][nextY].color != color) {

			if(previousX < nextX && previousY < nextY ) {
				int j = nextY-1;
				for(int i = nextX-1; i >= previousX; i--) {
					
					if(i == previousX && j == previousY) {
						return true;
					}else if(board[i][j] != null) {
						return false;
					}
					j--;
				}

			}else if(previousX < nextX && previousY > nextY ) {
				int j = nextY+1;
				for(int i = nextX-1; i >= previousX; i--) {
					
					if(i == previousX && j == previousY) {
						return true;
					}else if(board[i][j] != null) {
						return false;
					}
					j++;
				}

			}else if(previousX > nextX && previousY > nextY ) {
				int j = nextY+1;
				for(int i = nextX+1; i <= previousX; i++) {
					
					if(i == previousX && j == previousY) {
						return true;
					}else if(board[i][j] != null) {
						return false;
					}
					j++;
				}

			}else if(previousX > nextX && previousY < nextY ) {
				int j = nextY-1;
				for(int i = nextX+1; i <= previousX; i++) {
					
					if(i == previousX && j == previousY) {
						return true;
					}else if(board[i][j] != null) {
						return false;
					}
					j--;
				}

			}else if(nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
				return false;
			}
			return false;

		}else if(board[nextX][nextY] != null && board[nextX][nextY].color == color) {
			return false;
		}else {

			if(previousX < nextX && previousY < nextY ) {
				int j = nextY;
				for(int i = nextX; i >= previousX; i--) {
					
					if(i == previousX && j == previousY) {

						return true;
					}else if(board[i][j] != null) {
						return false;
					}
					j--;
				}

			}else if(previousX < nextX && previousY > nextY ) {
				int j = nextY;
				for(int i = nextX; i >= previousX; i--) {
					
					if(i == previousX && j == previousY) {

						return true;
					}else if(board[i][j] != null) {
						return false;
					}
					j++;
				}

			}else if(previousX > nextX && previousY > nextY ) {
				int j = nextY;
				for(int i = nextX; i <= previousX; i++) {
					
					if(i == previousX && j == previousY) {

						return true;
					}else if(board[i][j] != null) {
						return false;
					}
					j++;
				}

			}else if(previousX > nextX && previousY < nextY ) {
				int j = nextY;
				for(int i = nextX; i <= previousX; i++) {
					
					if(i == previousX && j == previousY) {

						return true;
					}else if(board[i][j] != null) {
						return false;
					}
					j--;
				}

			}else if(nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) {
				return false;
			}
			
			return false;

		}
	

	}

	//actual path checking method
	public boolean checkPath(Pieces[][] board, String color, int previousX, int previousY, int nextX, int nextY){

		//funky path check for valid pieces, hard to test
		for(int i = 1; i <= Math.abs(nextX - previousX); i++){

			// int k1 = (nextX > previousX) ? previousX + i : previousX - i;
			// int k2 = (nextY > previousY) ? previousY + i : previousY - i;

			if(board[(int)((nextX > previousX) ? previousX + i : previousX - i)][(int)((nextY > previousY) ? previousY + i : previousY - i)] != null){
				return false;
			}
		}

		return true;
	}


	//test version DO NOT USE
	public boolean checkPath1(Pieces[][] board, String color, int previousX, int previousY, int nextX, int nextY){

		if(nextX > previousX){

			if(nextY > previousY){
				
				for(int i = 0; i <= Math.abs(nextY - previousY); i++){
					// if(board.getPiece(previousX + i, previousY + i) != null){
					// 	return false;
					// }
					if(board[previousX + i][previousY + i] != null){
						return false;
					}

					if(board[(nextX > previousX) ? previousX + i : previousX - i][(nextY > previousY) ? previousY + i : previousY - i] != null){
						return false;
					}
				}

			}

		}

		return true;
	}

//	public boolean isValid(String color, int previousX, int previousY, int nextX, int nextY){
//
//		if(	(previousX >= 0 && previousX <= 7) &&
//			(previousY >= 0 && previousY <= 7) &&
//			(nextX >= 0 && nextX <= 7) &&
//			(nextY >= 0 && nextY <= 7)){
//
//				if(Math.abs(nextX - previousX) == Math.abs(nextY - previousY) && Math.abs(nextX - previousX) != 0 && Math.abs(nextY - previousY) != 0){
//					return true;
//				}
//
//		}
//
//		//delete old
//		//no more need to figure out every combination, only rules of bishop movement
//
//		return false;
//
//	}
}
