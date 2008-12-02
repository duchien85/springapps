package com.studerb.dao;

import org.springframework.stereotype.Repository;

import com.studerb.model.Film;

@Repository("filmDao")
public class HibFilmDao extends AbstractHibernateDao<Film> implements FilmDao {

	private static final String TABLE_NAME = "film";

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

}
