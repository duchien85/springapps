package com.studerb.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.text.StrBuilder;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studerb.model.Widget;
import com.studerb.widget.WidgetSearchModel;
import com.studerb.widget.WidgetService;
import com.sun.jersey.spi.resource.Singleton;

@Service
@Singleton
@Path(value = "/")
public class JerseyWebService {
	private static final Logger logger = Logger.getLogger(JerseyWebService.class);
	private WidgetService widgetService;

	@Autowired
	public void setWidgetService(WidgetService widgetService) {
		this.widgetService = widgetService;
	}

	@GET
	@Produces("application/json")
	@Path("/helloworld.htm")
	public String helloWorld() {
		Widget widget = Widget.createRandomWidget();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("widgetName", widget.getWidgetName());
		jsonObj.put("cool", widget.isCool());
		jsonObj.put("price", widget.getPrice());
		jsonObj.put("initialTime", widget.getInitialTime().toString("yyyy-MM-dd"));
		return jsonObj.toString();
	}

	@GET
	@Produces("text/plain")
	@Path("/getWidgetNames.htm")
	public String getWidgetNames(@QueryParam("query") String query) {
		logger.debug("got query: " + query);
		logger.debug("widgetService: " + widgetService);
		WidgetSearchModel wsm = new WidgetSearchModel();
		wsm.setName(query);
		List<Widget> widgets = widgetService.search(wsm);

		StrBuilder bldr = new StrBuilder();
		for (Widget w : widgets) {
			bldr.append(w.getWidgetName() + SystemUtils.LINE_SEPARATOR);
		}
		logger.debug("Returning: " + bldr.toString());
		return bldr.toString();
	}

	/*
	 * @POST
	 * 
	 * @Produces("text/plain") public String doPost(@FormParam("fileName")
	 * String fileName, String fileList) { logger.debug("FileName: " +
	 * fileName); logger.debug("body: " + fileList); return "0"; }
	 */
}
