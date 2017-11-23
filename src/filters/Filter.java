package filters;

import structures.WifiRecord;

public interface Filter {

	public boolean check (WifiRecord rec);
}
