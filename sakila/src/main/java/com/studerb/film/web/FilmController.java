package com.studerb.film.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studerb.film.Film;
import com.studerb.film.imp.FilmService;
import com.studerb.web.util.DataPage;
import com.studerb.web.util.DataPageInfo;

@Controller
@RequestMapping("/film/*.htm")
public class FilmController {

	@Autowired
	private FilmService filmService;

	@Autowired
	@Qualifier("filmListInfo")
	private DataPageInfo datePageInfo;

	@RequestMapping(method = RequestMethod.GET)
	public String changePage(@RequestParam String viewName, @RequestParam String changeEvent) {
		datePageInfo.changePage(changeEvent);
		return "redirect:/film/list.htm";
	}

	@RequestMapping(method = RequestMethod.GET)
	public void list(Model model) {
		DataPage<Film> films = filmService.getDatePage(datePageInfo);
		model.addAttribute("films", films);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String sort(@RequestParam String viewName, @RequestParam String column) {
		datePageInfo.changeSort(column);
		return "redirect:/film/list.htm";
	}
}
