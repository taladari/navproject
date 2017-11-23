package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import myData.Point3D;
import structures.WifiRecord;

public class WifiRecordTests {

	@Test
	public void ComparingTwoWifiRecordsShouldBeEqualDateTime() throws Exception {
		WifiRecord rec1 = new WifiRecord("2017/10/27 10:00:00", new Point3D("3.4","3.4","3.4"), "aviad");
		WifiRecord rec2 = new WifiRecord("2017/10/27 10:00:00", new Point3D("5.4","3.4","5.4"), "tal");
		int equals = rec1.isEqual(rec2);
		assertEquals("Should be equals",0,equals);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void WrongDateFormatShouldThrowIllegalArgumentException() throws Exception {
		WifiRecord rec = new WifiRecord("27/10/2017 10:00:00", new Point3D("3.4","3.4","3.4"), "aviad");
	}

}
