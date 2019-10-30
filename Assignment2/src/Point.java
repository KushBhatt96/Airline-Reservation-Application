
/**
 * This class describes the x,y coordinates of an airplane and a label describing its location
 * @author Kush Bhatt
 *
 */
public class Point {
	private double x;
	private double y;
	private String Label;
	
	/**
	 * This is the default constructor for Point class
	 */
	public Point() {}   
	
	/**
	 * This constructor will create a Point class in memory and initialize its 3 instance variables
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @param Label Indication of Location
	 */
	public Point(double x, double y, String Label) {
	this.x = x;
	this.y = y;
	this.Label = Label;
	}
	

	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setLabel(String Label) {
		this.Label = Label;
	}

	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public String getLabel() {
		return Label;
	}
	
	/**
	 * toString method for nicely printing out the values of the instance variables for a Point object
	 */
	public String toString() {
		return(Label + " ("+ x + ", " + y + ")");
	}
	
}
