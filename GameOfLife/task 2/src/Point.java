import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

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
		int aliveNeighbours = countAliveNeighbours();
		if ( currentState > 0) {
			nextState = currentState - 1;
		} else if (aliveNeighbours > 0) {
			nextState = 6;
		}
	}

	public void changeState() {
		currentState = nextState;
	}
	
	public void addNeighbor(Point nei) {
		neighbors.add(nei);
	}

	public int countAliveNeighbours() {
		return (int)neighbors.stream().filter( n -> n.getState() > 0).count();
	}

	public void drop() {
		Random rand = new Random();
		int n = rand.nextInt(20);
		if (n == 0) {
			currentState = 6;
		}
	}

}
