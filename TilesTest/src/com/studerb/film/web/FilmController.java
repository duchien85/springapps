package com.studerb.film.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jmesa.facade.TableFacade;
import org.jmesa.facade.TableFacadeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.studerb.film.imp.FilmService;
import com.studerb.model.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmService filmService;

	@RequestMapping(value = "/film/list.htm", method = RequestMethod.GET)
	public void list(HttpServletRequest request, Model model) {
		TableFacade tableFacade = TableFacadeFactory.createSpringTableFacade("filmTable", request);
		List<Film> films = filmService.getJmesa(tableFacade);
		model.addAttribute("films", films);
		model.addAttribute("limit", tableFacade.getLimit());
	}
}
