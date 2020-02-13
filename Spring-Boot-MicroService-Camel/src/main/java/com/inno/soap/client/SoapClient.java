
package com.inno.soap.client;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.inno.exception.RecordNotFoundException;
import com.inno.utility.Utility;
import com.inno.xml.GetCountryRequest;
import com.inno.xml.GetCountryResponse;

@Component
public class SoapClient {

	@Autowired
	private Jaxb2Marshaller marshaller;

	private WebServiceTemplate template;
	GetCountryResponse details;

	public GetCountryResponse getCountryDetailsFromSoap(GetCountryRequest request) throws RecordNotFoundException {
		template = new WebServiceTemplate(marshaller);

		details = (GetCountryResponse) template.marshalSendAndReceive(Utility.CALL_SOAP_URL, request);
		if (details.equals("null")) {
			throw new RecordNotFoundException("Country Not Available With This Name...!!");
		}
		return details;
	}

	@Handler
	public void process(Exchange exchange) throws RecordNotFoundException {
		GetCountryRequest request = exchange.getIn().getBody(GetCountryRequest.class);
		GetCountryResponse response = getCountryDetailsFromSoap(request);
		exchange.setProperty("countryInfo", response);

	}

}
