package com.studerb.model;

// Generated Nov 26, 2008 10:41:24 AM by Hibernate Tools 3.2.2.GA

import java.util.Date;

/**
 * FilmCategory generated by hbm2java
 */
public class FilmCategory implements java.io.Serializable {

	private FilmCategoryId id;
	private Film film;
	private Category category;
	private Date lastUpdate;

	public FilmCategory() {}

	public FilmCategory(FilmCategoryId id, Film film, Category category, Date lastUpdate) {
		this.id = id;
		this.film = film;
		this.category = category;
		this.lastUpdate = lastUpdate;
	}

	public FilmCategoryId getId() {
		return this.id;
	}

	public void setId(FilmCategoryId id) {
		this.id = id;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
