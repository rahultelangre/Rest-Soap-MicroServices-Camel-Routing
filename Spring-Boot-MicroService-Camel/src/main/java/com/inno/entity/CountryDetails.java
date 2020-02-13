package com.inno.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "COUNTRY_TAB")
@Data
public class CountryDetails {
	@Id
	@Column(name = "POPULATION")
	private int population;
	@Column(name = "COUNTRY_NAME")
	private String name;
	@Column(name = "CAPITAL")
	private String capital;
	@Column(name = "CURRENCY")
	private String currency;
}
