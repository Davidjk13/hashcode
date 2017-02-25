package hashcode;

import java.util.HashMap;
import java.util.HashSet;

public class Cache {

	public HashSet<Integer> storedVideos = new HashSet<Integer>();
	public int size;
	public int id;
	
	
	public Cache(int size) {
		this.size = size;
	}
	
	public void addVideo(int id, int size) {
		this.size -= size;
		storedVideos.add(id);
	}
	
//	
//	@Override
//	public int compareTo(Object o) {
//		Cache otherRequest = (Cache) o;
//		
//		if (latency < otherRequest.latency) {
//			return -1;
//		} else {
//			return 1;
//		}
//	}
}
