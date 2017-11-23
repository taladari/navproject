package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import myData.Point3D;
import structures.Wifi;
import structures.WifiRecord;

public class WifiTests {

	@Test(expected = NumberFormatException.class)
	public void WrongNumberFormatShouldThrowNumberFormatException() throws Exception {
		Wifi wifi = new Wifi("aviad","tal","3db","5");
	}

}
