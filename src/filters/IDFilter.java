package filters;

import structures.WifiRecord;

public class IDFilter implements Filter{

	private String id;
	public IDFilter(String id) {
		this.id = id;
	}
	

	public boolean check(WifiRecord rec) {
		if (rec != null) {
			if (this.id.equals(rec.getID())) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return "id";
	}

}
