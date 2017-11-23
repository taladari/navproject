package myData;

import java.util.ArrayList;

import structures.Wifi;

@SuppressWarnings("serial")
public class SortedNetworksList extends ArrayList<Wifi>{
	
	public SortedNetworksList() {
		super();
	}
	
	public void insert(Wifi toAdd) {
		int counter = 0;
		for (Wifi wifi:this) {
			counter++;
			if (toAdd.getSignal() < wifi.getSignal()) {
				continue;
			}
			else {
				this.add(this.indexOf(wifi), toAdd);
				return;
			}
		}
		if (counter == this.size()) {
			this.add(toAdd);
		}
	}
}
