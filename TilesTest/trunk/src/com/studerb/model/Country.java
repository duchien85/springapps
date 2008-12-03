package com.studerb.model;

// Generated Nov 26, 2008 10:41:24 AM by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;

/**
 * Country generated by hbm2java
 */
public class Country extends BaseEntity {
	public static final int MAX_COUNTRY = 50;
	private static final long serialVersionUID = 1L;
	private String country;
	private Set<City> cities = new HashSet<City>();

	public Country() {}

	public Country(String country) {
		this.country = country;
	}

	public Set<City> getCities() {
		return this.cities;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
