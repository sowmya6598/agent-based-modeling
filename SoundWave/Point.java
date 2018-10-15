public class Point {

	public Point nNeighbor;
	public Point wNeighbor;
	public Point eNeighbor;
	public Point sNeighbor;
	public float nVel;
	public float eVel;
	public float wVel;
	public float sVel;
	public float pressure;
	public static Integer []types ={0,1,2};
	int type ;
	int  sinInput = 0;

	public Point() {
		Point nNeighbor;
		Point wNeighbor;
		Point eNeighbor;
		Point sNeighbor;
		int type;
	}

	public void clicked() {
		pressure = 1;
	}
	
	public void clear() {
		// TODO: clear velocity and pressure
		nVel = 0;
		sVel = 0;
		eVel = 0;
		wVel = 0;
		pressure = 0;
	}

	public void updateVelocity() {
		if (type == 0) {
			nVel =  nVel - ( nNeighbor.pressure - pressure)  ;
			sVel = sVel - ( sNeighbor.pressure - pressure)   ;
			eVel = eVel - ( eNeighbor.pressure - pressure)  ;
			wVel = wVel - ( wNeighbor.pressure - pressure)  ;
		}

	}

	public void updatePresure() {
		if (type == 0) {
			pressure = (float) (pressure - (0.5 * (nVel + sVel + eVel + wVel)));
		} else if(type ==2) {
			double radians = Math.toRadians(sinInput);
			pressure = (float) (Math.sin(radians));
			sinInput += 20;
		}
	}

	public float getPressure() {
		return pressure;
	}
	}

