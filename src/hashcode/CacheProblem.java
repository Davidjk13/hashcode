package hashcode;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class CacheProblem {
	public static int[] videos;
	public static Request[] requests;
	public static Endpoint[] endpoints;
	public static Cache[] caches;
	public static int cacheSize;
//	public static HashMap<Integer, Integer> allCaches;
	
	public static void main(String[] args) throws IOException {
		
		initialize(args);
		
		Arrays.sort(requests);
		
		for (Request aReq : requests) {
			int size = videos[aReq.videoId];
			int endpointId = aReq.endId;
			
			Endpoint e = endpoints[endpointId];
			
			for (int i = 0; i < e.cacheConnections.size(); i++) {
				if(caches[e.cacheConnections.get(i).x].size >= size && e.dataCentreLatency > e.cacheConnections.get(i).y) {
					caches[e.cacheConnections.get(i).x].addVideo(aReq.videoId, size);
					break;
				}
			}
		}
		
		ArrayList<Cache> fin = new ArrayList<Cache>();
		for (int i = 0; i < caches.length; i++) {
			if(caches[i].size < cacheSize) {
				caches[i].id = i;
				fin.add(caches[i]);
			}
		}
		
		System.out.println(fin.size());
		
		for (int i = 0; i < fin.size(); i++) {
			Cache n = fin.get(i);
			System.out.print(n.id);
			
			Iterator<Integer> iter = n.storedVideos.iterator();
			while (iter.hasNext()) {
				int p = iter.next();
				System.out.print(" " + p);
			}
			System.out.println();
		}
	}
	
	public static void initialize(String[] args) {
		Scanner in = new Scanner(System.in);
		//read basic input data
		
		int numVideos = in.nextInt();
		int numEndpoints = in.nextInt();
		int numRequest = in.nextInt();
		int numCaches = in.nextInt();
		cacheSize = in.nextInt();
		
		requests = new Request[numRequest];
		endpoints = new Endpoint[numEndpoints];
		caches = new Cache[numCaches];
		
		for(int i = 0; i < numCaches; i++) {
			caches[i] = new Cache(cacheSize);
		}
		
//		allCaches = new HashMap<Integer, Integer>();

		videos = new int[numVideos];

		//read in video sizes
		for (int i = 0; i < numVideos; i++) {
			videos[i] = in.nextInt();
		}
		
		for (int i = 0; i < numEndpoints; i++) {
			int latency = in.nextInt();
			int cachesPerEnd = in.nextInt(); 
			Endpoint e = new Endpoint(latency);
				
			for (int j = 0; j < cachesPerEnd; j++) {
				//do something with caches
				int cacheNumber = in.nextInt();
				int cacheLatency = in.nextInt();
				
				e.addCacheConnection(cacheNumber, cacheLatency);
			}
			e.sortConnectionsByLatency();
			endpoints[i] = e;
		}
			
		for (int i = 0; i < numRequest; i++) {
			int vidId = in.nextInt();
			int endId = in.nextInt();
			int numOfRequests = in.nextInt();
			Request req = new Request(numOfRequests, vidId, endId);
			requests[i] = req;
		}		
	}
}
