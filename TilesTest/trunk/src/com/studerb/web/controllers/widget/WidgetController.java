package com.studerb.web.controllers.widget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studerb.model.Widget;
import com.studerb.service.interfaces.WidgetService;
import com.studerb.web.util.DataPage;
import com.studerb.web.util.DataPageInfo;

@Controller
@RequestMapping("/widget/*.htm")
public class WidgetController {

	@Autowired
	@Qualifier("widgetListInfo")
	private DataPageInfo datePageInfo;

	@Autowired
	private WidgetService widgetService;

	@RequestMapping(method = RequestMethod.GET)
	public void list(Model model) {
		DataPage<Widget> widgets = widgetService.getDatePage(datePageInfo);
		model.addAttribute("widgets", widgets);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String delete(@RequestParam("widgetId") Long widgetId, Model model) {
		widgetService.delete(widgetId);
		model.addAttribute("flashScope.message", "Deleted widget successfully");
		return "redirect:/widget/list.htm";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String changePage(@RequestParam String viewName, @RequestParam String changeEvent) {
		this.datePageInfo.changePage(changeEvent);
		return "redirect:/widget/list.htm";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String sort(@RequestParam String viewName, @RequestParam String column) {
		this.datePageInfo.changeSort(column);
		return "redirect:/widget/list.htm";
	}

}
