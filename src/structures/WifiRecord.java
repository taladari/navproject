package structures;

import org.joda.time.DateTime;
import org.joda.time.format.*;

import myData.Point3D;
import myData.SortedNetworksList;

public class WifiRecord {
	private DateTime time;
	private Point3D coordinates;
	public SortedNetworksList networks;
	private String id;
	private int numOfNetworks;
	private static DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
	
	public WifiRecord(String dateTime, Point3D coordinates, String id) throws Exception {
		try {
			time = format.parseDateTime(dateTime.replaceAll("/", "-"));
		}
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
		
		this.coordinates = new Point3D(coordinates);
		this.id = id;
	}
	
	public WifiRecord(WifiRecord copy) {
		this.time = copy.time;
		this.coordinates = new Point3D(copy.coordinates);
		this.id = copy.id;
	}

	
	public DateTime getDateTime() {
		return this.time;
	}
	
	public String getID() {
		return this.id;
	}
	
	public Point3D getPoint() {
		return this.coordinates;
	}
	
	public int isEqual(WifiRecord record) {
		if (this.getDateTime().toLocalDateTime().isEqual(record.getDateTime().toLocalDateTime())) {
			return 0;
		}
		return 1;
	}
	
	
	private void setNumOfNetworks() {
		numOfNetworks = networks.size() < 10 ? networks.size() : 10;
	}
	
	public String toFile() {
		setNumOfNetworks();
		StringBuilder ans = new StringBuilder(
				time.toString(format) + "," + id + "," + coordinates.toFile() + "," + numOfNetworks);
		for (int i = 0; i < networks.size() && i < 10; i++) {
			ans.append(",");
			ans.append(networks.get(i).toFile());
		}
		return ans.toString();
	}
}
