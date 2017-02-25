package hashcode;

public class Request implements Comparable {
	public int popularity;
	public int videoId;
	public int endId;
	
	public Request(int popularity, int videoId, int endId) {
		this.popularity = popularity;
		this.videoId = videoId;
		this.endId = endId;
	}
	

	@Override
	public int compareTo(Object o) {
		Request otherRequest = (Request) o;
		
		if (popularity < otherRequest.popularity) {
			return 1;
		} 
//		else if (popularity == otherRequest.popularity) {
//			return 0;
//		}
		else {
			return -1;
		}
	}
}
