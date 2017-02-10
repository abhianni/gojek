package com.gojek.GojekTest;

import java.io.IOException;
import java.text.ParseException;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gojek.GojekHelper.ExcelReader;
import com.gojek.GojekLogic.RoundTripFlightBooking;

public class RoundTripFlightBookingTest extends RoundTripFlightBooking {
	ExcelReader read = new ExcelReader();
	
  @Test(description="flight Booking Test" , dataProvider="flight")
  public void roundtripbookingtest(String url,String fromcity , String tocity, String firstname , String lastname,String emailid) throws ParseException 
  {
	 roundtripflight(url, fromcity, tocity, firstname, lastname, emailid);
	 
  }
  
  @DataProvider(name = "flight")
 	public Object[][] dataProvideremail() throws IOException {

 		read.testDataFile(File);
 		Object[][] data = new Object[][] {{  read.readFromColumn("Base", 1, 0),read.readFromColumn("Base", 1, 1),read.readFromColumn("Base", 1, 2),read.readFromColumn("Base", 1, 4),read.readFromColumn("Base", 1, 5),read.readFromColumn("Base", 1, 3)} };
 		read.closeFile();
 		return data;
 	}
}
