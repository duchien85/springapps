package com.studerb.scripts;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import com.studerb.model.Widget;
import com.studerb.widget.WidgetService;

public class CreateWidgets {
	private static final int COUNT = 500;
	private final static Logger logger = Logger.getLogger(CreateWidgets.class);
	static ApplicationContext appContext;
	static WidgetService widgetService;

	public static void main(String[] args) {
		initAppContext();
		widgetService.deleteAllObjects();
		createWidgets();
	}

	private static void createWidgets() {
		List<Widget> widgets = new ArrayList<Widget>(COUNT);
		for (int i = 0; i < COUNT; ++i) {
			Widget widget = Widget.createRandomWidget();
			widget.setWidgetName("Widget_" + i);
			widget.setInitialTime(widget.getInitialTime().minusDays(i));
			widgets.add(widget);
		}
		widgetService.saveOrUpdateAll(widgets);
		logger.debug("created: " + COUNT + " new widgets");

	}

	private static void initAppContext() {
		appContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Assert.notNull(appContext);
		widgetService = (WidgetService) appContext.getBean("widgetService");
		Assert.notNull(widgetService);
	}

}
