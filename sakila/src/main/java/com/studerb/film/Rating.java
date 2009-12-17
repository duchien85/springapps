package com.studerb.film;

public enum Rating {
	G("G"), PG("PG"), PG13("PG-13"), R("R"), NC17("NC-17");

	private String description;

	private Rating(String d) {
		this.description = d;
	}

	public String getDescription() {
		return this.description;
	}
}
