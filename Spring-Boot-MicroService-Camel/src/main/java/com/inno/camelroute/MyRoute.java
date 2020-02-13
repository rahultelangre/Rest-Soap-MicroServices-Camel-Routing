
package com.inno.camelroute;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.inno.rest.client.CountryService;
import com.inno.soap.client.SoapClient;
import com.inno.utility.Utility;
import com.inno.xml.GetCountryRequest;
import com.inno.xml.GetCountryResponse;

@Component
public class MyRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:start")
		.bean(SoapClient.class)
		.choice()
		.when(exchange -> {
			GetCountryResponse response = (GetCountryResponse) exchange.getProperty("countryInfo");
			if (response.getCountry() != null) {
				return true;
			}
			return false;
		}).bean(SetCountryInfoSoap.class).end()
		.choice()
		.when(exchange -> {
			GetCountryResponse response = (GetCountryResponse) exchange.getProperty("countryInfo");
			if (response.getCountry() == null) {
				return true;
			}
			return false;
		}).bean(CountryService.class).end();

	}

}
