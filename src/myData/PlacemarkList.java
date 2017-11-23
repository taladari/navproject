package myData;

import java.util.ArrayList;

import kmlUtils.Placemark;

@SuppressWarnings("serial")
public class PlacemarkList extends ArrayList<Placemark>{
	public PlacemarkList() {
		super();
	}
	
	public void insert(Placemark add) {
		int ans = exists(add.wifi.getMac());
		if (ans == -1) {
			this.add(add);
		}
		else {
			if (add.wifi.getSignal() > this.get(ans).wifi.getSignal()) {
				this.remove(ans);
				this.add(add);
			}
		}
	}

	private int exists(String mac) {
		int ans = -1;
		for (Placemark item:this) {
			if (item.wifi.getMac().equalsIgnoreCase(mac)) {
				ans = this.indexOf(item);
				break;
			}
		}
		return ans;
	}

}
