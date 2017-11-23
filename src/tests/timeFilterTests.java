package tests;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import filters.Filter;
import filters.timeFilter;
import myData.Point3D;
import structures.WifiRecord;

public class timeFilterTests {

	static DateTimeFormatter format;
	static DateTime start;
	static DateTime end;
	
	@BeforeClass
	public static void setUp() {
		format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		start = format.parseDateTime("2017-10-27 10:00:00");
		end = format.parseDateTime("2017-10-27 20:00:00");
	}
	
	@Test
	public void CheckValidTimeInputShouldReturnTrue() throws Exception {

		WifiRecord toCheck = new WifiRecord("2017-10-27 17:00:00",new Point3D("3","3","3"),"id");
		Filter time = new timeFilter(start,end);
		assertEquals(true,time.check(toCheck));
	}
	
	@Test
	public void CheckInValidTimeInputShouldReturnFalse() throws Exception {
		WifiRecord toCheck = new WifiRecord("2017-10-27 21:00:00",new Point3D("3","3","3"),"id");
		Filter time = new timeFilter(start,end);
		assertEquals(false,time.check(toCheck));
	}

}
