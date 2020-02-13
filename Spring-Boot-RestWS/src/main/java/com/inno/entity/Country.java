package com.inno.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name ="Country-Info")
@Entity
@Table(name = "TBL_COUNTRIES")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="population")
	protected Integer population;
	@Column(name = "name")
	protected String name;
	@Column(name = "capital")
	protected String capital;
	@Column(name = "currency")
	protected String currency;
}
