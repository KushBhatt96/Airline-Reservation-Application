/**
 * This class allows us to create a versatile array of integers
 * We can add, insert, remove, resize, print elements using methods
 * @author Kush Bhatt
 *
 */
public class IntArrayList {
	
	private int [] array;
	
////////////////////////////////////////////
//1. CONSTRUCTORS
/**
 * This method will create the int [] array with some given size
 * @param size The size to initialize the int [] with
 */
	public IntArrayList (int size){
		
		if (size > 0) {
			array = new int [size];
		}
	}
		
	public IntArrayList () {
			array = new int [0];
	}
	
	
////////////////////////////////////////////
// 2. SETTERS & GETTERS
	public void setInt(int index, int value) {
		array[index] = value;
	}
	
	public int getInt(int index) {
		return array[index];
	}

	
////////////////////////////////////////////
// 3. INSTANCE METHODS
	/**
	 * This method will add a new element to the end of the array
	 * @param x The new integer to be added
	 */
	public void addElement (int x) {
		int [] addToArray = new int [array.length+1];
		for (int i = 0; i < array.length; i++) {
			addToArray[i] = array[i]; 
		}
		addToArray[array.length] = x;
		array = addToArray;
	}
	
	/**
	 * This method inserts a new element in the array based on a given index
	 * @param index Index where you wish to insert
	 * @param num The new integer
	 */
	public void insertAt(int index, int num) {
		int [] addToArray = new int [array.length+1];
		for (int i = 0; i < index; i++) {
			addToArray[i] = array[i]; 
		}
		addToArray[index] = num;
		for (int i = index; i < array.length; i++) {
			addToArray[i+1] = array[i]; 
		}
		array = addToArray;
	}
	
	/**
	 * This method removes a particular element from the array based on a given index
	 * @param index Index where you wish to remove an integer
	 */
	public void removeAt(int index) {
		int [] subToArray = new int [array.length-1];
		for (int i = 0; i < index; i++) {
			subToArray[i] = array[i]; 
		}
		for (int i = index; i < array.length-1; i++) {
			subToArray[i] = array[i+1]; 
		}
		array = subToArray;
	}
	
	/**
	 * This method will resize the array with values of 0
	 * @param size New size of the array
	 */
	public void resize(int size) {
		int [] resizeArray = new int [size];
		if(size <= array.length) {
		resizeToSmaller(size, resizeArray);
		}
		else {
		resizeToLarger(size, resizeArray);
		}
		array = resizeArray;
	}
	
	/**
	 * This method will print the elements of the array
	 */
	public void printElements() {
		System.out.print("{");
		for(int i = 0; i < array.length; i++) {
			if(i == array.length - 1) {
			System.out.print(array[i] + "}\n");
			}
			else {
			System.out.print(array[i] + ", ");
			}
		}
	}
	
////////////////////////////////////////////
// 4. HELPER METHODS
	
	/** 
	 * Resizing if new size is smaller than existing
	 * @param size
	 * @param resizeArray
	 */
	private void resizeToSmaller(int size, int [] resizeArray) {		
			for(int i = 0; i< size; i++) {
				resizeArray[i] = array[i];
			}
	}
	
	
	/**
	 * Resizing if new size is larger than existing
	 * @param size
	 * @param resizeArray
	 */
	private void resizeToLarger(int size, int [] resizeArray) {		
		for(int i = 0; i< array.length; i++) {
			resizeArray[i] = array[i];
		}
	}
	
	
////////////////////////////////////////////
// 5. MAIN
	public static void main (String [] args) {
		
		IntArrayList ar = new IntArrayList ();
		
		ar.addElement (2);
		ar.addElement (4);
		ar.addElement (6);
		ar.addElement (8);
		
		System.out.println("CHECK 1:\r\n---------------");
		ar.printElements(); 
		
		ar.insertAt (2, 5); 				//inserting number 5 at index 2
		
		System.out.println("CHECK 2:\r\n---------------");
		ar.printElements(); 
		
		ar.removeAt (1); 					//remove the element at index 1
		
		System.out.println("CHECK 3:\r\n---------------");
		ar.printElements(); 
		
		ar.resize (2); 						//the new size of the array will be 2 elements
		
		System.out.println("CHECK 4:\r\n---------------");
		ar.printElements(); 				//This should print all elements in the array

		}
	
}