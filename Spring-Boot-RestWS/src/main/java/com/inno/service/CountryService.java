package com.inno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inno.entity.Country;
import com.inno.exception.RecordNotFoundException;
import com.inno.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	CountryRepository repository;

	public Country getCountryByName(String name) throws RecordNotFoundException {
		Optional<Country> country = repository.findByName(name);
		System.out.println(country.toString());
		if (country.isPresent()) {
			return country.get();
		} else {
			throw new RecordNotFoundException("No Country record exist for given name");
		}
	}

	public List<Country> getAllCountries() {
		List<Country> findAll = repository.findAll();
		return findAll;
	}

}