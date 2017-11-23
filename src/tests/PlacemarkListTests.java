package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import kmlUtils.Placemark;
import myData.PlacemarkList;
import myData.Point3D;
import structures.Wifi;
import structures.WifiRecord;

public class PlacemarkListTests {

	@Test
	public void Insert2PlacemarksSameMacShouldSaveOnlyHighestSignal() throws Exception {
		WifiRecord rec1 = new WifiRecord("2017/10/29 10:00:00", new Point3D("3.4","3.4","3.4"), "aviad");
		WifiRecord rec2 = new WifiRecord("2017/10/27 10:00:00", new Point3D("5.4","3.4","5.4"), "tal");
		Wifi wifi1 = new Wifi("ssid","mac","6", "8");
		Wifi wifi2 = new Wifi("ssid", "mac", "6", "10");
		Placemark placemark1 = new Placemark(rec2, wifi2);
		Placemark placemark2 = new Placemark(rec1, wifi1);
		PlacemarkList list = new PlacemarkList();
		list.insert(placemark1);
		list.insert(placemark2);
		assertEquals(10, list.get(0).wifi.getSignal());
		assertEquals(1,list.size());
	}

}
