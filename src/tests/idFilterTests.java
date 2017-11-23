package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import filters.Filter;
import filters.IDFilter;
import myData.Point3D;
import structures.WifiRecord;

public class idFilterTests {

	static Filter filter;
	
	@BeforeClass
	public static void setUp() {
		filter = new IDFilter("aviad");
	}
	
	@Test
	public void CheckValidIDInputShouldReturnTrue() throws Exception {
		WifiRecord toCheck = new WifiRecord("2017-10-27 17:00:00",new Point3D("4","4","4"),"aviad");
		assertEquals(true,filter.check(toCheck));
	}
	
	@Test
	public void CheckInValidIDInputShouldReturnFalse() throws Exception {
		WifiRecord toCheck = new WifiRecord("2017-10-27 17:00:00",new Point3D("4","4","4"),"tal");
		assertEquals(false,filter.check(toCheck));
	}

}
