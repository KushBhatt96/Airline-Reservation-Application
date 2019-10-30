/* This class makes a very simple abstraction of an aircraft's cockpit.
 * An objects of this class contains the following information: the current position 
 * of the aircraft, the starting point of the travel (source), the destination,
 * and the total traveled time(elapsed time from point of departure). This
 * class also provides instance methods to calculate the average speed, 
 * the distance between two points, the remaining travel time and a few more 
 * access methods and a constructor, as explained in the given  
 * comments, below.
 */

public class Cockpit {
	
	private Point source;          // a point that represents the source airport 
	private Point destination;     // a point that represents the destination airport
	private Point currentPoint;   // the current position of the aircraft on land 
	                       // or in the sky. 
	private Time elapsedTime;     // total elapsed time since started travel from source
	String flightNumber;  // flight's identification number. 
	
	public Cockpit (Point src, Point dest, String fn) {
		source = new Point (src.getX(), src.getY(), src.getLabel()); //We must ensure we don't do any shallow copying
		destination = new Point (dest.getX(), dest.getY(), dest.getLabel()); //Recall that shallow copying will result in pointers going to the same direction
		flightNumber = fn;
		currentPoint = new Point (src.getX(), src.getY(), src.getLabel()); //Again rememphasize the fact that we don't want any shallow copying, only deep copying, member by member
		elapsedTime = new Time();
		/* REQUIRES: src represents the starting point of travel (source), dest 
		 *           represents the destination, and fn represents the flight number. 
		 *           You may assume that the units for x and y coordinates of these 
		 *           points are in miles.
		 * PROMISES: initializes the private data members, source, destination, and 
		 *           flight_number with the values of arguments src, dest, and fn, 
		 *           respectively. It also initializes the data member current_point
		 *           (the current position of the aircraft) with src, and the 
		 *           elapsed_time with zero.
	   */	
	}
	public void moveForward(double dx, double dy) {
		currentPoint.setX(currentPoint.getX()+dx);
		currentPoint.setY(currentPoint.getY()+dy);
		
	/* PROMISES: changes the current position of the aircraft by dx and dy. Which 
	 *           means the values of x and y coordinates of the current_point
	 *           increases by dx and dy, respectively.
	 */
	}
	public void setElapsedTime(int dt) {
		elapsedTime.increment(dt);
	/* PROMISES: increases the value of elapsed time by dt in (seconds).
	 */
	}

	private double averageSpeedCalculator() {
		double distance = distanceIndicator(source, currentPoint);
		double time = elapsedTime.getHours() + (elapsedTime.getMinutes()/60.0) + (elapsedTime.getSeconds()/3600.0);
		return (distance/time);
	/* PROMISES: returns the average speed in miles per hour. Which is the 
	 *           distance from source divided by the elapsed time. 
	 */	
	}
	private double distanceIndicator(Point p1, Point p2) {
		double distance = Math.sqrt(Math.pow((p2.getX()-p1.getX()), 2) + 
				Math.pow((p2.getY()-p1.getX()), 2));
		return distance;
	/* REQUIRES: p1 and p2 refer to two points on a Cartesian plane 
	 * PROMISES: calculates the distance between p1 and p2 (in miles)
	 */	
	}
	private Time remainingTravelTime() {
		
		double remDistance = distanceIndicator(currentPoint, destination);
		double avgSpeed = averageSpeedCalculator();
		double remSeconds = remDistance/(avgSpeed/3600);
		Time remTime = new Time((int)remSeconds);
		return remTime;
	}
//	/* PROMISES: returns a time object which represents the estimated remaining 
//	 *           travel time. Which is the remaining travel distance divided by 
//	 *           the aircraft's average speed. 
//	 */	
//	}
	public String toString() {
		Time remTime = remainingTravelTime();
		double speed = averageSpeedCalculator();
		return ("Flight number: " + flightNumber 
				+ "\nCurrent Location: "+ currentPoint.toString() 
				+ "\nTraveled Time from Source: "+elapsedTime.getHours() + ":" + elapsedTime.getMinutes() + ":"
				+ elapsedTime.getSeconds()
				+ "\nCurrent Average Speed: "+ (Math.round(speed*100.0)/100.0) +	  
				" miles/hour\nEstimated Remaining Travel Time: "+remTime.getHours()+":"
	    		+remTime.getMinutes() +":"+ remTime.getSeconds()+
				"\n------------------------------------------");
	/* PROMISES: Returns a string containing flight number, and the aircraft's status:
	 *           current location (current point's x and y coordinates), 
	 *           average speed of the aircraft in miles per hour, elapsed time,
	 *           and the estimated remaining time to the destination.
	 */	
	}	
	public void displayMonitor () {
		System.out.println(toString());          //Display monitor must also print the string, not just retrieve it
	}
	public void setCurrentLabel(String new_label) {
		currentPoint.setLabel(new_label);
	/* PROMISES: changes the label (name) of the current_point to a new label,
	 *           by calling the function set_label from class Point.
	 */	
	}


}

