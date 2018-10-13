import java.util.ArrayList;

public class Point {
	private ArrayList<Point> neighbors;
	private int currentState;
	private int nextState;
	private int numStates = 6;
	
	public Point() {
		currentState = 0;
		nextState = 0;
		neighbors = new ArrayList<Point>();
	}

	public void clicked() {
		currentState=(++currentState)%numStates;	
	}
	
	public int getState() {
		return currentState;
	}

	public void setState(int s) {
		currentState = s;
	}

	public void calculateNewState() {
		int activeNei = activeNeighbor();
		if(currentState==1){
			if(activeNei == 2 || activeNei == 3) {
				nextState = 1;
			}
			else {
				nextState = 0;
			}
		}
		else
		{
			if(activeNei == 3) {
				nextState = 1;
			}
			else {
				nextState = 0;
			}
		}
	}

	public void changeState() {
		currentState = nextState;
	}
	
	public void addNeighbor(Point nei) {
		neighbors.add(nei);
	}

	public int activeNeighbor() {
		int active = 0;
		for(Point i : neighbors){
			if (i.getState()==1){
				active ++;
			}
		}
		return active;
	}



}
