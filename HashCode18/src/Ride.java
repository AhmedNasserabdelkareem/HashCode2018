public class Ride {
private boolean valid ;
private int startX;
private int startY;
private int finalX;
private int finalY;
private int earliest;
private int latest;
public boolean isValid() {
	return valid;
}
public void setValid(boolean valid) {
	this.valid = valid;
}
public int getStartX() {
	return startX;
}
public void setStartX(int startX) {
	this.startX = startX;
}
public int getStartY() {
	return startY;
}
public void setStartY(int startY) {
	this.startY = startY;
}
public int getFinalX() {
	return finalX;
}
public void setFinalX(int finalX) {
	this.finalX = finalX;
}
public int getFinalY() {
	return finalY;
}
public void setFinalY(int finalY) {
	this.finalY = finalY;
}
public int getEarliest() {
	return earliest;
}
public void setEarliest(int earliest) {
	this.earliest = earliest;
}
public int getLatest() {
	return latest;
}
public void setLatest(int latest) {
	this.latest = latest;
}

public int getSteps() {
	return Math.abs(startX-finalX)+Math.abs(startY-finalY);
}
	
	
}




	

