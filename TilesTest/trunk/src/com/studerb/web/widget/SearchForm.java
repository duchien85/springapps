package com.studerb.web.widget;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import com.studerb.model.Widget;
import com.studerb.service.interfaces.WidgetService;
import com.studerb.web.util.DataPage;
import com.studerb.web.util.DataPageInfo;
import com.studerb.web.util.DateTimeEditor;

@Controller
@RequestMapping("/widget/search/*.htm")
@SessionAttributes("widgetSearchModel")
public class SearchForm {
	Logger logger = Logger.getLogger(SearchForm.class);

	@Autowired
	WidgetService widgetService;

	@Autowired
	@Qualifier("widgetSearchInfo")
	private DataPageInfo datePageInfo;

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		String format = "yyyy-MM-dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		binder.registerCustomEditor(DateTime.class, new DateTimeEditor(format, true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public String defaultGet(Model model) {
		logger.debug("search GET - creating new WidgetSearchModel");
		model.addAttribute("widgetSearchModel", new WidgetSearchModel());
		return "widget/search";
	}

	@RequestMapping(value = "doSearch", method = RequestMethod.POST)
	public String postSearchModel(@ModelAttribute("widgetSearchModel") WidgetSearchModel widgetSearchModel, BindingResult result, Model model) {
		new WidgetSearchModelValidator().validate(widgetSearchModel, result);
		if (result.hasErrors()) {
			logger.debug("Binding/Validation Errors - returning search page");
			return "widget/search";
		}
		// add one day to endTime
		if (widgetSearchModel.getEndInitialTime() != null) {
			widgetSearchModel.setEndInitialTime(widgetSearchModel.getEndInitialTime().plusDays(1));
		}
		this.datePageInfo.setCurrentRecord(0);
		return "redirect:/widget/search/list.htm";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model, HttpSession httpSession) {
		WidgetSearchModel widgetSearchModel = (WidgetSearchModel) httpSession.getAttribute("widgetSearchModel");
		if (widgetSearchModel == null) {
			throw new IllegalStateException("WidgetSearchModel not found within HttpSession");
		}
		logger.debug("WidgetSearchModel (from session): " + widgetSearchModel.toString());

		DataPage<Widget> widgetDP = widgetService.searchDataPage(widgetSearchModel, this.datePageInfo);
		if (widgetDP.getData().isEmpty()) {
			model.addAttribute("searchResultsMessage", "No results were found matching your criteria");
		}

		logger.debug("Found: " + widgetDP.getData().size() + " EPIs to display...");
		model.addAttribute("widgets", widgetDP);
		model.addAttribute("widgetSearchModel", widgetSearchModel);
		if (widgetDP.getData().isEmpty()) {
			model.addAttribute("searchResultsMessage", "There were no widget's found using your criteria");
		}
		return "widget/search";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("widgetId") Long widgetId, Model model) {
		widgetService.delete(widgetId);
		model.addAttribute("flashScope.message", "Deleted widget successfully");
		return "redirect:/widget/search/list.htm";
	}

	@RequestMapping(value = "changePage", method = RequestMethod.GET)
	public String changePage(@RequestParam String viewName, @RequestParam String changeEvent) {
		this.datePageInfo.changePage(changeEvent);
		return "redirect:/widget/search/list.htm";
	}

	@RequestMapping(value = "sort", method = RequestMethod.GET)
	public String sort(@RequestParam String viewName, @RequestParam String column) {
		this.datePageInfo.changeSort(column);
		return "redirect:/widget/search/list.htm";
	}
}
