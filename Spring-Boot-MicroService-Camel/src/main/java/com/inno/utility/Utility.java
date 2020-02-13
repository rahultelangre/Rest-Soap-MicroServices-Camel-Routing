package com.inno.utility;

import com.inno.xml.GetCountryResponse;

public class Utility {
	
	public static Boolean flag=true;
	
	public static String COUNTRY_NAME;
	
	public static GetCountryResponse response;
	
	public static String CALL_REST_URL = "http://localhost:8080/country/{name}";
	
	public static String CALL_SOAP_URL ="http://localhost:9090/ws";

}
