package com.gojek.GojekLogic;

import com.gojek.GojekHelper.Action;

public class RoundTripFlightBooking extends Action{
	
	public void roundtripflight(String url,String fromcity , String tocity, String firstname , String lastname)
	{
		openUrl(url);
		click(locator("roundTripCheckbox"));
		type(locator("flightFrom"), fromcity);
		click(locator("flightFromAjax"));
		type(locator("flightTo"), tocity);
		click(locator("flightToAjax"));
		click(locator(orKey));
	}

}
