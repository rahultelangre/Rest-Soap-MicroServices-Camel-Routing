package com.inno.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.inno.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

	Optional<Country> findByName(String name);

}
