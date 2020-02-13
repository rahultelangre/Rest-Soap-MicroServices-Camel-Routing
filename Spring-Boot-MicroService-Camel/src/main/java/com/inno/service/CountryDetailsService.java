package com.inno.service;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Service;

import com.inno.entity.CountryDetails;
import com.inno.exception.RecordNotFoundException;
import com.inno.utility.Utility;
import com.inno.xml.GetCountryRequest;

@Service
public class CountryDetailsService {

	@Produce("direct:start")
	private ProducerTemplate template;

	CountryDetails requestBody;

	public CountryDetails getDetails(GetCountryRequest request)throws RecordNotFoundException {
		Utility.COUNTRY_NAME = request.getName();
		requestBody = template.requestBody(request, CountryDetails.class);
		return requestBody;
	}

}
