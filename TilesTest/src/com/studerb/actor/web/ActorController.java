package com.studerb.actor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studerb.actor.imp.DefaultActorService;
import com.studerb.model.Actor;
import com.studerb.web.util.DataPage;
import com.studerb.web.util.DataPageInfo;

@Controller
@RequestMapping("/actor/*.htm")
public class ActorController {

	@Autowired
	private DefaultActorService actorService;

	@Autowired
	@Qualifier("actorListInfo")
	private DataPageInfo datePageInfo;

	@RequestMapping(method = RequestMethod.GET)
	public String changePage(@RequestParam String viewName, @RequestParam String changeEvent) {
		datePageInfo.changePage(changeEvent);
		return "redirect:/actor/list.htm";
	}

	@RequestMapping(method = RequestMethod.GET)
	public void list(Model model) {
		DataPage<Actor> actors = actorService.getDatePage(datePageInfo);
		model.addAttribute("actors", actors);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String sort(@RequestParam String viewName, @RequestParam String column) {
		datePageInfo.changeSort(column);
		return "redirect:/actor/list.htm";
	}

}
