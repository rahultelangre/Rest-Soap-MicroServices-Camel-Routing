package com.inno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inno.entity.CountryDetails;

@Repository
public interface CountryRepo extends JpaRepository<CountryDetails, Integer> {

	
}
