package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import myData.SortedNetworksList;
import structures.Wifi;

public class SortedNetworksListTests {

	@Test
	public void Insert2WifiShouldSortBySignal() {
		Wifi wifi1 = new Wifi("ssid","mac","6", "8");
		Wifi wifi2 = new Wifi("ssid", "mac", "6", "10");
		SortedNetworksList list = new SortedNetworksList();
		list.insert(wifi1);
		list.insert(wifi2);
		assertEquals(10,list.get(0).getSignal());
	}

}
