
/**
 * This class allows us to create a versatile array of Point objects 
 * We can add, insert, remove, resize, print elements using methods
 * @author Kush Bhatt
 */
public class ObjectArrayList {
	
	private Point [] pointArray;

////////////////////////////////////////////
// 1. CONSTRUCTORS
	/**
	 * This constructor will create the Point [] with some initial size
	 * @param size Initial size of the Point []
	 */
	public ObjectArrayList (int size){
		
		if (size > 0) {
			pointArray = new Point [size];
		for(int i = 0; i < pointArray.length; i++) {
			pointArray[i] = new Point();
		}
		}
	}
	
	
	/**
	 * This is the default constructor
	 */
	public ObjectArrayList() {
		pointArray = new Point [0];
	}
	

//////////////////////////////////////////
// 2. SETTERS & GETTERS
	public void setPoint(int index, Point pointObject) {
			this.pointArray[index].setX(pointObject.getX());
			this.pointArray[index].setY(pointObject.getY());
			this.pointArray[index].setLabel(pointObject.getLabel());
	}
	

	public Point getPoint(int index) {
		return pointArray[index];
	}
	
	
/////////////////////////////////////////
// 3. INSTANCE METHODS
	/**
	 * This instance method will add a new Point object to the end of the Point []
	 * @param x X coordinate 
	 * @param y Y coordinate
	 * @param Label Indication of the location
	 */
	public void addElement(int x, int y, String Label) {
		Point [] addToArray = new Point [pointArray.length+1];
		for(int i = 0; i < pointArray.length; i++) {
			addToArray[i] = new Point(pointArray[i].getX(), pointArray[i].getY(), pointArray[i].getLabel());
		}
		addToArray[pointArray.length] = new Point(x, y, Label);
		pointArray = addToArray;
	}
	
	
	/**
	 * This instance method will insert a new Point object in the Point [] based on a given index
	 * @param index Index to insert the new element
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @param Label Indication of the location
	 */
	public void insertAt(int index, int x, int y, String Label) {
		Point [] addToArray = new Point [pointArray.length+1];
		for(int i = 0; i < index; i++) {
			addToArray[i] = new Point(pointArray[i].getX(), pointArray[i].getY(), pointArray[i].getLabel());
		}
		addToArray[index] = new Point(x, y, Label);
		for(int i = index; i < pointArray.length; i++) {
			addToArray[i+1] = new Point(pointArray[i].getX(), pointArray[i].getY(), pointArray[i].getLabel());
		}
		pointArray = addToArray;
	}
	
	
	/**
	 * This instance method will remove a Point object from the Point[] based on a given index
	 * @param index Index where to remove the element
	 */
	public void removeAt(int index) {
		Point [] subToArray = new Point [pointArray.length-1];
		for (int i = 0; i < index; i++) {
			subToArray[i] = new Point(pointArray[i].getX(), pointArray[i].getY(), pointArray[i].getLabel());
		}
		for(int j = index+1; j < pointArray.length; j++) {
			subToArray[j-1] = new Point(pointArray[j].getX(), pointArray[j].getY(), pointArray[j].getLabel());
		}
		pointArray = subToArray;
	}
	
	
	/**
	 * This instance method will remove a Point object from the Point [] based on a given index
	 * @param newSize New size of the Point []
	 */
	public void resize(int newSize) {
		Point [] newSizeArray = new Point [newSize];
		if(newSize <= pointArray.length) {
			resizeToSmaller(newSize, newSizeArray);
		}
		else {
			resizeToLarger(newSize, newSizeArray);
		}
		pointArray = newSizeArray;
	}
	
	
	/**
	 * This instance method will print the contents of the Point object at each index of the Point[]
	 */
	public void printElements() {
		for (int i = 0; i < pointArray.length; i++) {
		System.out.println("Point object at index " + i + ":");
		System.out.println("[" + pointArray[i].getX() + ", " + pointArray[i].getY() + ", "
		+ pointArray[i].getLabel() + "]\r\n");	
		}
	}
	
	
//////////////////////////////////////////
// 4. HELPER METHODS
	
	/**
	 * Helper Function: Resizing to an array smaller than the existing Point array
	 * @param newSize
	 * @param newSizeArray
	 */
	private void resizeToSmaller(int newSize, Point[] newSizeArray) {
		for (int i = 0; i < newSize; i++) {
			newSizeArray[i] = new Point(pointArray[i].getX(), pointArray[i].getY(), pointArray[i].getLabel());
		}
	}
	
	
	/**
	 * Helper Function: Resizing to an array larger than the existing Point array
	 * @param newSize
	 * @param newSizeArray
	 */
	private void resizeToLarger(int newSize, Point[] newSizeArray) {
		int i = 0;
		for (; i < pointArray.length; i++) {
			newSizeArray[i] = new Point(pointArray[i].getX(), pointArray[i].getY(), pointArray[i].getLabel());
		}
		for(; i<newSize;i++) {
			newSizeArray[i] = new Point();
		}
	}
	
	
/////////////////////////////////////////
// 5. MAIN
	public static void main (String [] args) {
		
		ObjectArrayList pointAr = new ObjectArrayList ();   // Firstly create an instance of class ObjectArrayList
		Point myPoint = new Point(2,4,"HELLO");
		
		pointAr.addElement (1, 2, "Calgary");               // Next we will add some Point objects to the Point  []
		pointAr.addElement (3, 4,"Toronto");
		pointAr.addElement (5, 6, "Vancouver");
		pointAr.addElement (7, 8, "Montreal");
		
		System.out.println("CHECK 1:\r\n---------------");
		pointAr.printElements();							//CHECK POINT 1: ADD
		
		pointAr.insertAt (2, 9, 10, "Edmonton"); 			// Inserting number 5 at index 2
		
		System.out.println("CHECK 2:\r\n---------------");
		pointAr.printElements();							//CHECK POINT 2: INSERT

		pointAr.removeAt (1); 					 			// Remove the element at index 1
		
		System.out.println("CHECK 3:\r\n---------------");
		pointAr.printElements();							//CHECK POINT 3: REMOVE

		pointAr.resize (2); 					 			// The new size of the array will be 2 elements
		
		System.out.println("CHECK 4:\r\n---------------");
		
		pointAr.printElements();							//CHECK POINT 4: RESIZE
		
		}
	
}
