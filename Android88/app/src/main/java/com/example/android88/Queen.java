package com.example.android88;

/**
 * 
 * @author Cliff Grandin
 * @author Kartik Sonavane
 *
 * Queen class that extends the Pieces class to set Queen Piece
 * and to check if the piece can be moved to the location 
 * is requested
 */
public class Queen extends Pieces {
	
	/**
	 * Constructor for Queen that sets nameAbr
	 * 
	 * @param nameAbr 
	 * name Abbreviation of Queen wQ or bQ
	 * 	
	 */
	public Queen(String nameAbr) {
		super(nameAbr);	
	}
	
	
	/**
	 * Constructor for Queen that sets Queen abbreviation and color
	 * 
	 * @param nameAbr
	 * name Abbreviation of Queen wQ or bQ
	 * @param color
	 * color of Queen wQ or bQ
	 */
	public Queen(String nameAbr, String color) {
		super(nameAbr, color);
	}
	
	/**
	 * Checks to see if the Queen move(Diagonally, Row and Columns) is a valid move. 
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

			if(previousX == nextX && previousY < nextY ) {
				
				for(int i = nextY-1; i >= previousY; i--) {
					if(i == previousY) {

						return true;
					}
					else if(board[nextX][i] != null) {
						return false;
					}
				}
			}else if(previousX == nextX && previousY > nextY ) {
				for(int i = nextY+1; i <= previousY; i++) {
					if(i == previousY) {

						return true;
					}else if(board[nextX][i] != null) {
						return false;
					}
				}

			}else if(previousX < nextX && previousY == nextY ) {
				for(int i = nextX-1; i >= previousX; i--) {
					if(i == previousX) {

						return true;
					}else if(board[i][nextY] != null) {
						return false;
					}
				}

			}else if(previousX > nextX && previousY == nextY ) {
				for(int i = nextX+1; i <= previousX; i++) {
					if(i == previousX) {

						return true;
					}else if(board[i][nextY] != null) {
						return false;
					}
				}

			}else if(previousX < nextX && previousY < nextY ) {
				int j = nextY-1;
				for(int i = nextX-1; i >= previousX; i--) {
					
					if(i == previousX && j == previousY) {
//						System.out.println("This is a good move");
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
//						System.out.println("This is a good move");
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
//						System.out.println("This is a good move");
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
//						System.out.println("This is a good move");
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
			//return true;
		}else if(board[nextX][nextY] != null && board[nextX][nextY].color == color) {
//			System.out.println("PIECE FOUND!!!!");
//			System.out.println("SAME COLOR");
			return false;
		}else {
//			System.out.println("NO PIECE FOUND");
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

			}else if(previousX < nextX && previousY < nextY ) {
				int j = nextY;
				for(int i = nextX; i >= previousX; i--) {
					
					if(i == previousX && j == previousY) {
//						System.out.println("This is a good move");
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
//						System.out.println("This is a good move");
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
//						System.out.println("This is a good move");
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
//						System.out.println("This is a good move");
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

	
}


