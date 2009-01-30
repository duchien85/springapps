package com.studerb.film;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studerb.model.Film;
import com.studerb.web.util.DataPage;
import com.studerb.web.util.DataPageInfo;

@Service("filmService")
public class FilmService {
	Logger logger = Logger.getLogger(FilmService.class);

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

}
