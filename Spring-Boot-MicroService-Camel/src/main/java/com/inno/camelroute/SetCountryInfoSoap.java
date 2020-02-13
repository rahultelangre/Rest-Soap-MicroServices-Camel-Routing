
package com.inno.camelroute;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inno.SpringBootMicroServiceCamelApplication;
import com.inno.entity.CountryDetails;
import com.inno.exception.RecordNotFoundException;
import com.inno.repository.CountryRepo;
import com.inno.utility.Utility;
import com.inno.xml.Country;
import com.inno.xml.GetCountryResponse;

@Component
public class SetCountryInfoSoap {

	@Autowired
	private CountryRepo repo;

	@Handler
	public void process(Exchange exchange) {
	
			GetCountryResponse property = exchange.getProperty("countryInfo", GetCountryResponse.class);
			System.out.println("property::" + property.getCountry());
			Country country = property.getCountry();
			CountryDetails details = new CountryDetails();
			BeanUtils.copyProperties(country, details);
			SpringBootMicroServiceCamelApplication.detail = details;
			saveCountryDetails(details);
			exchange.getIn().setBody(details);
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
