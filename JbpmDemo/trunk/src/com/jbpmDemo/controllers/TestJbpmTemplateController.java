package com.jbpmDemo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springmodules.workflow.jbpm31.JbpmTemplate;

public class TestJbpmTemplateController extends AbstractController {

	@Autowired private JbpmTemplate jdpmTemplate;

	@Override protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		logger.debug("JdbcTemplate: " + jdpmTemplate);
		ModelAndView mav = new ModelAndView("testJbpmTemplate");
		mav.addObject("jdbcTemplate", jdpmTemplate);
		return mav;
	}

}
