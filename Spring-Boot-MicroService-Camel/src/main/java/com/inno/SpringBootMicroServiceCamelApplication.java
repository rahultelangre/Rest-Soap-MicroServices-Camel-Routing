package com.inno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inno.entity.CountryDetails;
import com.inno.exception.RecordNotFoundException;
import com.inno.service.CountryDetailsService;
import com.inno.xml.GetCountryRequest;

@SpringBootApplication
@RestController
public class SpringBootMicroServiceCamelApplication {

	public static CountryDetails detail;

	@Autowired
	private CountryDetailsService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroServiceCamelApplication.class, args);
	}

	@PostMapping(value = "/getStatus")
	public CountryDetails invokeSoapClientToGetStudentDetails(@RequestBody GetCountryRequest request)
			throws RecordNotFoundException {
		CountryDetails details = service.getDetails(request);
		System.out.println("Main()" + details);
		if (details == null) {
			throw new RecordNotFoundException("Country Not Available with this name..!!");
		}
		return details;
	}
}
