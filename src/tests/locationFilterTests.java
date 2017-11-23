package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import filters.Filter;
import filters.locationFilter;
import myData.Point3D;
import structures.WifiRecord;

public class locationFilterTests {
	
	static Filter filter;
	
	@BeforeClass
	public static void setUp() {
		filter = new locationFilter("3","3","7","7");
	}

	@Test
	public void CheckValidLocationInputShouldReturnTrue() throws Exception {
		WifiRecord toCheck = new WifiRecord("2017-10-27 17:00:00",new Point3D("4","4","4"),"id");
		assertEquals(true,filter.check(toCheck));
	}
	
	@Test
	public void CheckInValidLocationInputShouldReturnFalse() throws Exception {
		WifiRecord toCheck = new WifiRecord("2017-10-27 17:00:00",new Point3D("2","2","4"),"id");
		assertEquals(false,filter.check(toCheck));
	}

}
