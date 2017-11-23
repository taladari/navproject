package kmlUtils;

import java.sql.Timestamp;
import java.util.Random;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import myData.Point3D;
import structures.Wifi;
import structures.WifiRecord;

public class Placemark {
	private String name, description, styleUrl;
	private Point3D coordinates;
	public WifiRecord record;
	public Wifi wifi;
	private DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
	
	public Placemark(WifiRecord record, Wifi wifi) {
		this.record = new WifiRecord(record);
		this.wifi = new Wifi(wifi);
		name = "<name><![CDATA[" + wifi.getSSID() + "]]></name>";
		description = "<description><![CDATA[BSSID: <b>" + wifi.getMac() + "</b><br/>Frequency:<b>"
				+ wifi.getFreq()
				+ "</b><br/>Date: <b>" + record.getDateTime().toString(format) + "</b>]]></description>";
		String color = wifi.getSignal() < new Random(-100).nextInt() ? "green" : "red";
		styleUrl = "<styleUrl>#" + color + "</styleUrl>";
		coordinates = new Point3D(record.getPoint());

	}
	
	public String toString() {
		String timestamp = record.getDateTime().toString(format).split(" ")[0] + "T"
				+ record.getDateTime().toString(format).split(" ")[1];
		String ans = "<Placemark>\n" + name + "\n" + description + styleUrl + "\n"
				+ "<TimeStamp>\n<when>" + timestamp + "</when>\n</TimeStamp>\n"
				+ "<Point>\n" + "<coordinates>" + coordinates.getLon() + "," + coordinates.getLat()
				+ "</coordinates>\n</Point>\n</Placemark>";
		return ans;
	}
	
	
}
