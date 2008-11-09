package com.studerb.web.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.sun.jersey.spi.resource.Singleton;

@Path("/helloworld.htm")
@Singleton
public class JerseyWebService {
	private static final Logger logger = Logger.getLogger(JerseyWebService.class);

	@GET
	@Produces("text/plain")
	public String doGet() {
		logger.debug("Got GET request");
		return "some text";
	}

	/*
	 * @POST
	 * 
	 * @Produces("text/plain") public String doPost(@FormParam("fileName")
	 * String fileName, String fileList) { logger.debug("FileName: " +
	 * fileName); logger.debug("body: " + fileList); return "0"; }
	 */
}
