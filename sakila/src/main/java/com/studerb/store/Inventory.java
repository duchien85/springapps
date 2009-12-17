package com.studerb.store;

// Generated Nov 26, 2008 10:41:24 AM by Hibernate Tools 3.2.2.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.studerb.film.Film;
import com.studerb.model.BaseEntity;

/**
 * Inventory generated by hbm2java
 */
public class Inventory extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private Store store;
	private Film film;
	private Set<Rental> rentals = new HashSet<Rental>(0);

	public Inventory() {}

	public Inventory(Store store, Film film, Date lastUpdate) {
		this.store = store;
		this.film = film;
	}

	public Film getFilm() {
		return this.film;
	}

	public Set<Rental> getRentals() {
		return this.rentals;
	}

	public Store getStore() {
		return this.store;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public void setRentals(Set<Rental> rentals) {
		this.rentals = rentals;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}
