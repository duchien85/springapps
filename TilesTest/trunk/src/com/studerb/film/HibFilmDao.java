package com.studerb.film;

import org.springframework.stereotype.Repository;

import com.studerb.dao.hibernate.AbstractHibernateDao;
import com.studerb.model.Film;

@Repository("filmDao")
public class HibFilmDao extends AbstractHibernateDao<Film> implements FilmDao {

	private static final String TABLE_NAME = "film";

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

}
