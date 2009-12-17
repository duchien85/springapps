package com.studerb.geo;

// Generated Nov 26, 2008 10:41:24 AM by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;

import com.studerb.film.Film;
import com.studerb.model.BaseEntity;

/**
 * Language generated by hbm2java
 */
public class Language extends BaseEntity {

	private static final long serialVersionUID = 1L;
	public static final int MAX_NAME = 20;
	private String name;
	private Set<Film> originalFilms = new HashSet<Film>(0);
	private Set<Film> dubbedFilms = new HashSet<Film>(0);

	public Language() {}

	public Language(String name) {
		this.name = name;
	}

	public Set<Film> getDubbedFilms() {
		return dubbedFilms;
	}

	public Set<Film> getFilmsForLanguageId() {
		return this.dubbedFilms;
	}

	public Set<Film> getFilmsForOriginalLanguageId() {
		return this.originalFilms;
	}

	public String getName() {
		return this.name;
	}

	public Set<Film> getOriginalFilms() {
		return originalFilms;
	}

	public void setDubbedFilms(Set<Film> dubbedFilms) {
		this.dubbedFilms = dubbedFilms;
	}

	public void setFilmsForLanguageId(Set<Film> filmsForLanguageId) {
		this.dubbedFilms = filmsForLanguageId;
	}

	public void setFilmsForOriginalLanguageId(Set<Film> filmsForOriginalLanguageId) {
		this.originalFilms = filmsForOriginalLanguageId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOriginalFilms(Set<Film> originalFilms) {
		this.originalFilms = originalFilms;
	}

}
