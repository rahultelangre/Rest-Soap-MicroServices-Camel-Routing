package com.inno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inno.entity.Country;
import com.inno.exception.RecordNotFoundException;
import com.inno.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {
	@Autowired
	CountryService service;

	@PostMapping("/{name}")
	public ResponseEntity<Country> getCountryByName(@PathVariable("name") String name) throws RecordNotFoundException {
		Country entity = service.getCountryByName(name);
		System.out.println(entity.toString());
		return new ResponseEntity<Country>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/all")
	public List<Country> findAllCountries() {
		return service.getAllCountries();

	}

}