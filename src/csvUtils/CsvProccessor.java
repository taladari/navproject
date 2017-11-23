package csvUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import myData.Point3D;
import myData.SortedRecordList;

import structures.Wifi;
import structures.WifiRecord;

public class CsvProccessor {
	
	private static SortedRecordList records;
	private static final String FILE_HEADER = 
			"Time, ID, Lat, Lon, Alt, #WiFi Networks, "
			+ "SSID1, MAC1, Frequncy1, Signal1, "
			+ "SSID2, MAC2, Frequncy2, Signal2, "
			+ "SSID3, MAC3, Frequncy3, Signal3, "
			+ "SSID4, MAC4, Frequncy4, Signal4, "
			+ "SSID5, MAC5, Frequncy5, Signal5, "
			+ "SSID6, MAC6, Frequncy6, Signal6, "
			+ "SSID7, MAC7, Frequncy7, Signal7, "
			+ "SSID8, MAC8, Frequncy8, Signal8, "
			+ "SSID9, MAC9, Frequncy9, Signal9, "
			+ "SSID10, MAC10, Frequncy10, Signal10";
	
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	public static void Proccess(String folderPath) {
		records = new SortedRecordList();
		try {
			File folder = new File(folderPath);
			File[] files = folder.listFiles();
			String extension = "";
			for (File f:files) {
				int i = f.getName().lastIndexOf('.');
				if (i >= 0) {
				    extension = f.getName().substring(i+1);
				}
				if(extension.equals("csv"))
				{
					ReadSingleFile(folderPath+"\\"+f.getName());
				}
			}
			folder = new File (folderPath + "\\output");
			if (!folder.exists()) {
				folder.mkdir();
			}
			writeCsvFile(folderPath + "\\output\\wifidata.csv");
		}
		catch (Exception e) {
			System.out.println("tal");
		}

	}
	
	private static void ReadSingleFile(String filePath) {
		String line ="";
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			line = br.readLine();
			String[] splittedLine = line.split(",");
			String id = splittedLine[4];
			br.readLine();
			while ((line = br.readLine()) != null) {
				splittedLine = line.split(",");
				WifiRecord record = new WifiRecord(splittedLine[3], 
						new Point3D(splittedLine[6], splittedLine[7], splittedLine[8]), 
						id);
				Wifi network = new Wifi(splittedLine[1], splittedLine[0], splittedLine[4], splittedLine[5]);
				records.insert(record, network);
			}
			br.close();
		}
		catch (NumberFormatException e) {
			System.out.println("Wrong number format");
		}
		catch (IllegalArgumentException e) {
			System.out.println("Wrong date time format");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void writeCsvFile(String fileName) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(fileName);
			writer.append(FILE_HEADER.toString());
			writer.append(NEW_LINE_SEPARATOR);
			for (WifiRecord record:records) {
				if (record.getDateTime() != null) {
					writer.append(record.toFile());
					writer.append(NEW_LINE_SEPARATOR);
				}

			}
			writer.close();
		}


		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
