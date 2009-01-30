package com.studerb.film;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jmesa.facade.TableFacade;
import org.jmesa.facade.TableFacadeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.studerb.model.Film;

@Controller
@RequestMapping("/film/*.htm")
public class FilmController {

	@Autowired
	private FilmService filmService;

	@RequestMapping(method = RequestMethod.GET)
	public void list(HttpServletRequest request, Model model) {
		List<Film> films = filmService.getAll();
		model.addAttribute("films", films);
		TableFacade tableFacade = TableFacadeFactory.createSpringTableFacade("filmTable", request);
		tableFacade.setItems(films);
		tableFacade.setTotalRows(films.size());
		tableFacade.setColumnProperties("title", "description", "length");
		String filmTable = tableFacade.render();
		model.addAttribute("filmTable", filmTable);
	}
}
