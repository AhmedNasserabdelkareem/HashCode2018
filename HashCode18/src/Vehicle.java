import java.util.LinkedList;

public class Vehicle {
	int currentX;
	int currentY;
	int nextX;
	int nextY;
	int stepCounter;
	boolean available=true;
	LinkedList <Integer> rides = new LinkedList<Integer>();
	
	
	public void setAvailability (boolean available)
	{
		this.available=available;
	}
	public void decrease() {
		stepCounter--;
		if(stepCounter==0) {
			available=true;
			currentX = nextX;
			currentY = nextY;
		}
	}
	public void assignRide(int minIndex, int total, int finalX, int finalY) {
		available = false;
		stepCounter = total;
		rides.add(minIndex);
		//System.out.print(minIndex+" ");
		nextX = finalX;
		nextY = finalY;
		
	}
}