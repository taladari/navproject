package structures;


public class Wifi {
	private String ssid, mac;
	private int freq, signal;
	
	public Wifi (String ssid, String mac, String freq, String signal) {
		this.ssid = ssid;
		this.mac = mac;
		try {
			this.freq = Integer.parseInt(freq);
			this.signal = Integer.parseInt(signal);
		}
		catch (NumberFormatException e) {
			throw new NumberFormatException();
		}

	}
	
	public Wifi(Wifi copy) {
		this.ssid = copy.ssid;
		this.mac = copy.mac;
		this.freq = copy.freq;
		this.signal = copy.signal;
	}
	
	public int getSignal() {
		return this.signal;
	}
	
	public String getMac() {
		return this.mac;
	}
	
	public String getSSID() {
		return this.ssid;
	}
	
	public int getFreq() {
		return this.freq;
	}
	
	public String toFile() {
		String res = ssid + "," + mac + "," + freq + "," + signal;
		return res;
	}
}
