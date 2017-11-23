package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import myData.Point3D;
import myData.SortedRecordList;
import structures.Wifi;
import structures.WifiRecord;

public class SortedRecordListTests {

	@Test
	public void Insert2RecordsShouldEnterSortedByTime() throws Exception {
		Wifi aviad = new Wifi ("ssid","mac","5","6");
		Wifi tal = new Wifi ("ssid","mdac","5","7");
		WifiRecord rec1 = new WifiRecord("2017/10/29 10:00:00", new Point3D("3.4","3.4","3.4"), "aviad");
		WifiRecord rec2 = new WifiRecord("2017/10/27 10:00:00", new Point3D("5.4","3.4","5.4"), "tal");
		SortedRecordList test = new SortedRecordList();
		test.insert(rec1, aviad);
		test.insert(rec2, tal);
		assertEquals(7,test.get(0).networks.get(0).getSignal());
		assertEquals(6,test.get(1).networks.get(0).getSignal());
		
		
		
	}	

}
