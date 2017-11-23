package filters;

import structures.WifiRecord;

public class locationFilter implements Filter{
	float startLon, startLat, endLon, endLat;
	
	public locationFilter(String startLon, String startLat, String endLon, String endLat) {
		this.startLon = Float.parseFloat(startLon);
		this.startLat = Float.parseFloat(startLat);
		this.endLon = Float.parseFloat(endLon);
		this.endLat = Float.parseFloat(endLat);
	}


	public boolean check(WifiRecord rec) {
		if (rec != null) {
			if (((rec.getPoint().getLon() > this.startLon) && (rec.getPoint().getLon() < this.endLon))
					&& ((rec.getPoint().getLat() > this.startLat) && (rec.getPoint().getLat() < this.endLat))){
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return "location";
	}

}
