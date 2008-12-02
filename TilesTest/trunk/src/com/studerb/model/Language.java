package com.studerb.model;

// Generated Nov 26, 2008 10:41:24 AM by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;

/**
 * Language generated by hbm2java
 */
public class Language implements java.io.Serializable {

	private String name;
	private Set<Film> filmsForOriginalLanguageId = new HashSet<Film>(0);
	private Set<Film> filmsForLanguageId = new HashSet<Film>(0);

	public Language() {}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Film> getFilmsForOriginalLanguageId() {
		return this.filmsForOriginalLanguageId;
	}

	public void setFilmsForOriginalLanguageId(Set<Film> filmsForOriginalLanguageId) {
		this.filmsForOriginalLanguageId = filmsForOriginalLanguageId;
	}

	public Set<Film> getFilmsForLanguageId() {
		return this.filmsForLanguageId;
	}

	public void setFilmsForLanguageId(Set<Film> filmsForLanguageId) {
		this.filmsForLanguageId = filmsForLanguageId;
	}

}
