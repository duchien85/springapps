package com.studerb.web.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.studerb.model.Widget;
import com.sun.jersey.spi.resource.Singleton;

@Path("/helloworld.htm")
@Singleton
public class JerseyWebService {
	private static final Logger logger = Logger.getLogger(JerseyWebService.class);

	@GET
	@Produces("application/json")
	public String doGet() {
		Widget widget = Widget.createRandomWidget();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("widgetName", widget.getWidgetName());
		jsonObj.put("cool", widget.isCool());
		jsonObj.put("price", widget.getPrice());
		jsonObj.put("initialTime", widget.getInitialTime().toString("yyyy-MM-dd"));
		return jsonObj.toString();
	}

	/*
	 * @POST
	 * 
	 * @Produces("text/plain") public String doPost(@FormParam("fileName")
	 * String fileName, String fileList) { logger.debug("FileName: " +
	 * fileName); logger.debug("body: " + fileList); return "0"; }
	 */
}
