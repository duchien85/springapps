package com.jbpmDemo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.jbpmDemo.service.DemoService;

public class ShowProcessInstancesController extends AbstractController {

	@Autowired
	private DemoService demoService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		logger.debug("DemoService: " + demoService);
		ModelAndView mav = new ModelAndView("showProcessInstances");
		mav.addObject("processDefinitions", demoService.findLatestProcessDefinitions());
		return mav;
	}

}
