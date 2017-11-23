package kmlUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import filters.Filter;
import myData.PlacemarkList;
import myData.Point3D;
import structures.Wifi;
import structures.WifiRecord;

public class KMLCreator {
	
	public static PlacemarkList filtered = new PlacemarkList();
	
	private static final String HEADER_LINE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
			"<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle>"
			+ "<Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle>"
			+ "</Style><Style id=\"yellow\"><IconStyle><Icon>"
			+ "<href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href>"
			+ "</Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon>"
			+ "<href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href>"
			+ "</Icon></IconStyle></Style><Folder><name>Wifi Networks</name>";
	
	
	private static final String END_LINE = "</Folder>\n" + "</Document></kml>";
	
	public static void CreateFilteredKML(String fileName, Filter filter) {
		readCsvFile(fileName, filter);
		writeKMLFile(fileName.substring(0, fileName.lastIndexOf("\\")+1)+"filtered_by_" + filter.toString() + ".kml");
	}

	private static void writeKMLFile(String fileName) {
		FileWriter writer = null;
		try
		{
			writer = new FileWriter(fileName);
			writer.append(HEADER_LINE);
			writer.append("\n");
			for (Placemark item:filtered) {
				writer.append(item.toString());
				writer.append("\n");
			}
			writer.append(END_LINE);
			writer.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void readCsvFile(String fileName, Filter filter) {
		String line ="";
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] splittedLine = line.split(",");
				WifiRecord record = new WifiRecord(splittedLine[0], 
						new Point3D(splittedLine[2], splittedLine[3], splittedLine[4]), 
						splittedLine[1]);
				if (filter.check(record)) {
					int numNet = Integer.parseInt(splittedLine[5]);
					for (int i = 6; i < (numNet*4) + 6; i+=4) {
						Wifi newWifi = new Wifi(splittedLine[i], splittedLine[i+1],
								splittedLine[i+2], splittedLine[i+3]);
						Placemark toAdd = new Placemark(record, newWifi);
						filtered.insert(toAdd);
					}
				}
			}
			br.close();
		}
		catch (IllegalArgumentException e) {
			System.out.println("Illegal time format");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	


}
