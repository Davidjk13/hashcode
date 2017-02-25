package hashcode;

import java.awt.Point;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Endpoint {
	public int dataCentreLatency;
//	HashMap<Integer, Integer> cacheConnections = new HashMap<Integer, Integer>();
	
	public ArrayList<Point> cacheConnections = new ArrayList<Point>();
	
	public Endpoint(int latency) {
		this.dataCentreLatency = latency;
	}
	
	public void addCacheConnection(int id, int latency) {
		//cacheConnections.put(id, latency);
		Point p = new Point(id, latency);
		cacheConnections.add(p);
	}
	
	public void sortConnectionsByLatency() {
		cacheConnections.sort(new Comparator<Point>() {
	        @Override
	        public int compare(Point p1, Point p2)
	        {
	    		if (p1.y < p2.y) {
					return -1;
				} else if (p1.y > p2.y){
					return 1;
				} else {
					return 0;
				}
	        }
	    });
	}
	
	
}
