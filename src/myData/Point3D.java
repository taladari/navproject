package myData;

public class Point3D {
	private float lat, lon, alt;
	
	public Point3D(String lat, String lon, String alt) {
		this.lat = Float.parseFloat(lat);
		this.lon = Float.parseFloat(lon);
		this.alt = Float.parseFloat(alt);
	}
	
	public Point3D(Point3D duplicate) {
		this.lat = duplicate.lat;
		this.lon = duplicate.lon;
		this.alt = duplicate.alt;
	}
	
	public float getLat() {
		return this.lat;
	}
	
	public float getLon() {
		return this.lon;
	}
	
	public String toFile() {
		String res = lat + "," + lon + "," + alt;
		return res;
	}
}
