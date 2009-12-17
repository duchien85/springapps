package com.studerb.film.imp;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studerb.film.Film;
import com.studerb.film.FilmDao;
import com.studerb.web.util.DataPage;
import com.studerb.web.util.DataPageInfo;

@Service("filmService")
public class DefaultFilmService implements FilmService {
	Logger logger = Logger.getLogger(DefaultFilmService.class);

	@Autowired
	private FilmDao filmDao;

	@Transactional(readOnly = true)
	public Film get(Long id) {
		logger.debug("Finding film with id: " + id);
		return filmDao.get(id);
	}

	@Transactional(readOnly = true)
	public List<Film> getAll() {
		List<Film> films = filmDao.getAll();
		logger.debug("fetched " + films.size() + " films");
		return films;
	}

	@Transactional(readOnly = true)
	public DataPage<Film> getDatePage(DataPageInfo info) {
		logger.debug("getting data page of films -> dpInfo: " + info.toString());
		return filmDao.getPage(info);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCount() {
		logger.debug("Getting count of films");
		return filmDao.getCount();
	}
}
