import java.util.Scanner;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import csvUtils.CsvProccessor;
import filters.Filter;
import filters.IDFilter;
import filters.locationFilter;
import filters.timeFilter;
import kmlUtils.KMLCreator;

public class Geographic {

	public static void main(String[] args) {
		CsvProccessor.Proccess("C:\\Users\\Tal Adari\\Documents\\data\\27.10\\OP3T");
/*
		Scanner scanner = new Scanner(System.in);
		System.out.println("What would you like to filter by?\n");
		System.out.println("1. Time\n");
		System.out.println("2. Location\n");
		System.out.println("3. ID\n");
		String input;
		int filterBy = scanner.nextInt();
		
		switch (filterBy) {
		case 1:
			DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
			System.out.println("Please enter start time to filter (yyyy/MM/dd hh:mm:ss):\n");
			input = scanner.next() + " " + scanner.next();
			DateTime start = format.parseDateTime(input.replaceAll("/", "-"));
			System.out.println("Please enter end time to filter (yyyy/MM/dd hh:mm:s):\n");
			input = scanner.next() + " " + scanner.next();
			DateTime end = format.parseDateTime(input.replaceAll("/", "-"));
			Filter time = new timeFilter(start, end);
			KMLCreator.CreateFilteredKML("src\\files\\program files\\output\\wifidata.csv", time);
			break;
		case 2:
			System.out.println("Please enter start coordinates (Lon,Lat):\n");
			input = scanner.next();
			String[] startPoint = input.split(",");
			System.out.println("Please enter end coordinates (Lon,Lat):\n");
			input = scanner.next();
			String[] endPoint = input.split(",");
			Filter loc = new locationFilter(startPoint[0], startPoint[1], endPoint[0], endPoint[1]);
			KMLCreator.CreateFilteredKML("src\\files\\program files\\output\\wifidata.csv", loc);
			break;
		case 3:
			System.out.println("Please enter ID to filter by:\n");
			input = scanner.next();
			Filter id = new IDFilter(input);
			KMLCreator.CreateFilteredKML("src\\files\\program files\\output\\wifidata.csv", id);
			break;
		default:
			break;
		}
		scanner.close();
*/
	}


}
