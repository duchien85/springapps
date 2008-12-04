package com.studerb.model;

// Generated Nov 26, 2008 10:41:24 AM by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;

/**
 * Category generated by hbm2java
 */
public class Category extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private String name;
	private Set<Film> films = new HashSet<Film>();

	public Category() {}

	public Category(String name) {
		this.name = name;
	}

	public Set<Film> getFilmCategories() {
		return this.films;
	}

	public Set<Film> getFilms() {
		return films;
	}

	public String getName() {
		return this.name;
	}

	public void setFilmCategories(Set<Film> films) {
		this.films = films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

	public void setName(String name) {
		this.name = name;
	}

}
