import java.text.CollationElementIterator;
import java.util.ArrayList;

public class Point {

	public ArrayList<Point> neighbors;
	public static Integer[] types = {0, 1, 2, 3};
	public int type;
	public int staticField;
	public boolean isPedestrian;

	public Point() {
		type = 0;
		staticField = 100000;
		neighbors = new ArrayList<Point>();
	}

	public void clear() {
		staticField = 100000;

	}

	public boolean calcStaticField() {

		int smallest = 100000;

		for (Point n : neighbors) {
			if (n.staticField < smallest) {
				smallest = n.staticField;
			}
		}

		if (smallest + 1 < staticField) {
			staticField = smallest + 1;
			return true;
		} else {
			return false;
		}
	}


	
	public void move(){
		if (isPedestrian) {
			Point min = neighbors.get(0);
			for (Point n : neighbors) {
				if (n.staticField < min.staticField) {
					min = n;
				}
			}
			isPedestrian = false;
			min.isPedestrian = true;
		}
	}

	public void addNeighbor(Point nei) {
		neighbors.add(nei);
	}
}