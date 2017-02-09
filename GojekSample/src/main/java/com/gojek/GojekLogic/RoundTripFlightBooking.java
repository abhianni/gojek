package com.gojek.GojekLogic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

import com.gojek.GojekHelper.Action;

public class RoundTripFlightBooking extends Action{
	
	public void roundtripflight(String url,String fromcity , String tocity, String firstname , String lastname,String emailid) throws ParseException
	{
		openUrl(url);
		click(locator("roundTripCheckbox"));
		type(locator("flightFrom"), fromcity);
		click(locator("flightFromAjax"));
		type(locator("flightTo"), tocity);
		click(locator("flightToAjax"));
		click(locator("departDate"));
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date today = new Date();
		Date day = dateFormat.parse(dateFormat.format(today));
		int fromdate=day.getDate()+2;
		click(By.xpath("(//a[text()='"+fromdate+"'])[1]"));
		click(locator("returnDate"));
		int todate = day.getDate()+10;
		click(By.xpath("(//a[text()='"+todate+"'])[1]"));
		dropdown(locator("adultDropdown"), 1);
		dropdown(locator("childrenDropdown"), 1);
		click(locator("SearchButton"));
		click(locator("BookButton"));
		click(locator("insuranceCheckbox"));
		click(locator("continueButton"));
		type(locator("username"), emailid);
		click(locator("loginButton"));
		dropdown(locator("travellerTitle"), 1);
		type(locator("travellerName"), firstname);
		type(locator("travellerLastName"), lastname);
		type(locator("travellerMobileNo"), "1234567890");
		click(locator("continuetoPayment"));
	}

}
