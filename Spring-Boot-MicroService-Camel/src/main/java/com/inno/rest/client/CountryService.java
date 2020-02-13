package com.inno.rest.client;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inno.entity.CountryDetails;
import com.inno.exception.RecordNotFoundException;
import com.inno.repository.CountryRepo;
import com.inno.service.CountryDetailsService;
import com.inno.utility.Utility;
import com.inno.xml.GetCountryRequest;

/*
 * This class is used to making a call to Rest API.
 * 
 */
@Service
public class CountryService {

	@Autowired
	private CountryRepo repo;

	@Autowired
	private RestTemplate template;

	@Autowired
	CountryDetailsService service;

	@Handler
	public void process(Exchange exchange)throws RecordNotFoundException {
		GetCountryRequest request = exchange.getIn().getBody(GetCountryRequest.class);
		Utility.COUNTRY_NAME = request.getName();
		ResponseEntity<CountryDetails> responseEntity = template.exchange(Utility.CALL_REST_URL, HttpMethod.POST, null,
				CountryDetails.class, Utility.COUNTRY_NAME);
		CountryDetails body = responseEntity.getBody();
		saveCountryDetails(body);
		exchange.getIn().setBody(body);
	}

	public void saveCountryDetails(CountryDetails entity) {

		CountryDetails country = new CountryDetails();
		country.setName(entity.getName());
		country.setCapital(entity.getCapital());
		country.setCurrency(entity.getCurrency());
		country.setPopulation(entity.getPopulation());
		repo.save(country);

	}
}
