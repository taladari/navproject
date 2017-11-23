package myData;

import java.util.ArrayList;
import java.util.Iterator;

import structures.Wifi;
import structures.WifiRecord;

@SuppressWarnings("serial")
public class SortedRecordList extends ArrayList<WifiRecord> {
	public SortedRecordList() {
		super();
	}
	
	public void insert(WifiRecord toAdd, Wifi network) {
		try {
			for (WifiRecord record:this) {
				if (toAdd.getDateTime().toLocalDateTime().equals(record.getDateTime().toLocalDateTime())) {
					if (toAdd.getID().equals(record.getID())) {
						record.networks.insert(network);
						return;
					}
				}
				else if (toAdd.getDateTime().toLocalDateTime().isBefore(record.getDateTime().toLocalDateTime())) {
					this.add(this.indexOf(record), toAdd);
					record.networks = new SortedNetworksList();
					record.networks.insert(network);
					return;
				}
				else if (this.indexOf(record) == this.size() - 1) {
					this.add(toAdd);
					this.get(this.indexOf(record) + 1).networks = new SortedNetworksList();
					this.get(this.indexOf(record) + 1).networks.insert(network);
					return;
				}
			}
			this.add(toAdd);
			this.get(0).networks = new SortedNetworksList();
			this.get(0).networks.insert(network);
		}
		catch (NullPointerException e) {
			System.out.println("nullpointer");
		}
			

	}
	
	
	
	public void insertFilterd(WifiRecord rec, Wifi wifi) {
		
		Iterator<WifiRecord> itr= this.iterator();

	}

}
