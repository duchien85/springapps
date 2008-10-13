package com.jbpmDemo.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.commons.lang.SystemUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbpmDemo.service.DemoService;
import com.sun.jersey.spi.resource.Singleton;

@Service
@Singleton
@Path("jerseyTest")
public class JerseyTestController {
	private final static Logger logger = Logger.getLogger(JerseyTestController.class);

	@Autowired
	private DemoService demoService;

	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces("text/plain")
	public String startEpiPost(@FormParam("fileList") String fileList) throws UnsupportedEncodingException, IOException {
		logger.debug("Got to jerseyTestController @POST");
		logger.debug("fileList: " + fileList);
		return "POST Successful";
	}

	private String filterFileList(String original) throws IOException {
		StringBuilder formatted = new StringBuilder();
		BufferedReader reader = new BufferedReader(new StringReader(original));
		String temp;
		while ((temp = reader.readLine()) != null) {
			// logger.debug("filtering: " + temp);
			if (temp.matches("^\\w:\\\\.*$")) {
				formatted.append(temp + SystemUtils.LINE_SEPARATOR);
			}
		}
		return formatted.toString();
	}
	// @POST
	// @Transactional
	// public String startEpi(@QueryParam("eventType") String eventType,
	// @QueryParam("client") String clientCode, @FormParam("status") String
	// status) throws UnsupportedEncodingException {
	// EnrollmentProcessIssueTemplate temp = epiDao.findTemplate(eventType);
	//
	// EnrollmentProcessIssue issue = temp.buildIssue();
	// issue.setClient(clientCode);
	//
	// EnrollmentProcessIssueAttachment at = new
	// EnrollmentProcessIssueAttachment();
	// at.setEpi(issue);
	// at.setFileName("status.txt");
	// at.setMimeType("text/plain");
	// issue.getAttachments().add(at);
	// at.getData().setData(status.getBytes("UTF-8"));
	//
	// epiDao.saveEpi(issue);
	// ProcessInstance pi = epiService.startEpiProcess(issue);
	//
	// return Long.toString(pi.getId());
	// }
}
