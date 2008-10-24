package com.studerb.service;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studerb.dao.WidgetDao;
import com.studerb.model.Widget;
import com.studerb.service.interfaces.WidgetService;

@Service("widgetService")
public class DefaultWidgetService implements WidgetService {
	Logger logger = Logger.getLogger(DefaultWidgetService.class);

	@Autowired
	WidgetDao widgetDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.studerb.service.WidgetService#delete(com.studerb.model.Widget)
	 */
	@Transactional
	@Override
	public void delete(Widget widget) {
		logger.debug("Deleting widget: " + widget.toString());
		widgetDao.delete(widget);
	}

	@Transactional
	@Override
	public int deleteAll(Collection<Widget> widgets) {
		int deleted = 0;
		for (Widget w : widgets) {
			widgetDao.delete(w);
			deleted++;
		}
		return deleted;
	}

	@Transactional
	@Override
	public int deleteAllObjects() {
		int deleted = widgetDao.deleteAll();
		logger.debug("deleted all: " + deleted + " widgets");
		return deleted;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.studerb.service.WidgetService#find(java.lang.Long)
	 */
	@Transactional(readOnly = true)
	@Override
	public Widget get(Long id) {
		logger.debug("Finding widget with id: " + id);
		return widgetDao.get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.studerb.service.WidgetService#saveOrUpdate(com.studerb.model.Widget)
	 */
	@Transactional
	@Override
	public Long save(Widget widget) {
		logger.debug("Saving widget: " + widget.toString());
		return widgetDao.save(widget);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Widget> getAll() {
		List<Widget> widgets = widgetDao.getAll();
		logger.debug("fetched " + widgets.size() + " widgets");
		return widgets;
	}

	@Transactional
	@Override
	public void update(Widget widget) {
		logger.debug("Updating widget: " + widget.toString());
		widgetDao.update(widget);
	}

	@Override
	public boolean isNameUsed(String name) {
		boolean used = widgetDao.isNameUsed(name);
		logger.debug("Widget name: " + name + " already used: " + used);
		return used;
	}

}
