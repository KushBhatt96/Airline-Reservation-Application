
/**
 * This class will keep track of the time passage as an airplane travels
 * @author Kush Bhatt
 *
 */
public class Time {

	private int hours;
	private int minutes;
	private int seconds;
	
	/**
	 * Default constructor
	 */
	public Time() {} 
	
	/**
	 * This constructor will create a Time object by taking in an integer value of total seconds
	 * @param totalSeconds The total number of seconds
	 */
	public Time(int totalSeconds) {
	seconds = totalSeconds%60;
	totalSeconds -= seconds;
	minutes = (totalSeconds%3600)/60;
	totalSeconds -= (minutes * 60);
	hours = totalSeconds/3600;
	}
	

	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		if(minutes<=59 && minutes >=0) {
			this.minutes = minutes;
		}
		else {
			System.out.println("The value passed for minutes is outside the range of 0-59");
		}
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		if(seconds<=59 && seconds >=0) {
			this.seconds = seconds;
		}
		else {
			System.out.println("The value passed for seconds is outside the range of 0-59");
		}
	}
	
	/**
	 * This function will  increment the instance variables of the Time class by taking in the change in time 
	 * @param dt The passage of time
	 */
	public void increment (int dt) {
	int totSeconds = this.hours*3600 + this.minutes * 60 + this.seconds + dt;	
	this.seconds = totSeconds%60;
	totSeconds -= this.seconds;
	this.minutes = (totSeconds%3600)/60;
	totSeconds -= this.minutes*60;
	this.hours = totSeconds/3600;	
	}
	
}
