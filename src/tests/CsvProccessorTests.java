package tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import csvUtils.CsvProccessor;

public class CsvProccessorTests {

	BufferedReader br;
	
	@Test
	public void WrongTimeFormatShouldCreateEmptyCsvFile() throws IOException {
		CsvProccessor.Proccess(""
				+ "src\\files\\tests files\\csvtocsv\\damaged files\\damaged1");
		br = new BufferedReader(new FileReader(""
				+ "src\\files\\tests files\\csvtocsv\\damaged files\\damaged1\\output\\wifidata.csv"));
		Scanner scan = new Scanner(br.readLine());
		assertEquals(null, br.readLine());
		scan.close();
		br.close();
	}
	
	@Test
	public void WrongSignalFormatShouldCreateEmtpyCsvFile() throws IOException {
		CsvProccessor.Proccess(""
				+ "src\\files\\tests files\\csvtocsv\\damaged files\\damaged2");
		br = new BufferedReader(new FileReader(""
				+ "src\\files\\tests files\\csvtocsv\\damaged files\\damaged2\\output\\wifidata.csv"));
		Scanner scan = new Scanner(br.readLine());
		assertEquals(null, br.readLine());
		scan.close();
		br.close();
	}
	

	@Test
	public void FileSizeShouldBe89Bytes() {
		CsvProccessor.Proccess("src\\files\\tests files\\csvtocsv\\working files");
		File file = new File("src\\files\\tests files\\csvtocsv\\working files\\output\\wifidata.csv");
		assertEquals("Wrong file size",89351, file.length());
	}

}
