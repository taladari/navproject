package filters;

import org.joda.time.DateTime;

import structures.WifiRecord;

public class timeFilter implements Filter{
	
	DateTime start, end;
	
	public timeFilter(DateTime start, DateTime end) {
		this.start = start;
		this.end = end;
	}

	public boolean check(WifiRecord rec) {
		if (rec != null) {
			if ((rec.getDateTime().isAfter(start) && rec.getDateTime().isBefore(end))
					|| rec.getDateTime().isEqual(start) || rec.getDateTime().isEqual(end)) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return "time";
	}
	
	

}
