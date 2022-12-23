package com.example.android88;

/**
 * 
 * @author Cliff Grandin
 * @author Kartik Sonavane
 *
 */

public class Pieces {
	String name;
	String nameAbr;
	String color;
	int x;
	int y;
	
	
	/**
	 * Constructor for nameAbr
	 * @param nameAbr
	 * nameAbr: is abbreviation for chess piece
	 */
	public Pieces(String nameAbr){
		this.nameAbr = nameAbr;
		
		
	}
	
	/**
	 * Constructor for nameAbr, color
	 * @param nameAbr
	 * nameAbr: abbreviation for chess piece
	 * @param color
	 * color: color of pieces instantiated
	 */
	public Pieces(String nameAbr, String color){
		this.nameAbr = nameAbr;
		this.color = color;
		
		
	}
	
	/**
	 * Constructor for name,nameAbr,x,y
	 * @param name
	 * name: name of piece
	 * @param nameAbr
	 * nameAbr: abbreviation for chess piece
	 * @param x
	 * x: x coordinate
	 * @param y
	 * y: y coordinate
	 */
	public Pieces(String name, String nameAbr, int x, int y){
		this.name = name;
		this.nameAbr = nameAbr;
		this.x = x;
		this.y = y;
		
	}
	
	
	/**
	 * gets x coordinate of piece
	 * @return x
	 * x: returns x coordinate
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * gets y coordinate of piece
	 * @return y
	 * y: returns y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the abbreviation of piece
	 * @param nameAbr
	 * name: name abbreviation of piece
	 */
	public void setAbr(String nameAbr) {
		this.nameAbr = nameAbr;
	}
	
	/**
	 * returns the color of the piece
	 * @return color
	 * returns the color of the piece asked about
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * toString method for printing abbreviation on board
	 */
	public String toString() {
		//return "name: " + name + " nameAbr: " + nameAbr + " x: " + x + " y: " + y;  
		return "nameAbr: " + nameAbr;  
	}
}
