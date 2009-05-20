package com.studerb.film.imp;

import java.util.List;

import org.jmesa.facade.TableFacade;

import com.studerb.model.Film;
import com.studerb.web.util.DataPage;
import com.studerb.web.util.DataPageInfo;

public interface FilmService {

	public Film get(Long id);

	public List<Film> getAll();

	public DataPage<Film> getDatePage(DataPageInfo info);

	public List<Film> getJmesa(TableFacade tableFacade);

	public int getCount();

}
