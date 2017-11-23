package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import structures.Wifi;

public class WifiTests {

	@Test(expected = NumberFormatException.class)
	public void WrongNumberFormatShouldThrowNumberFormatException() throws Exception {
		Wifi wifi = new Wifi("aviad","tal","3db","5");
	}

}
