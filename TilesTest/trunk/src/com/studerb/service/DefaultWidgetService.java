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

@Service
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
	public void delete(Widget widget) {
		logger.debug("Deleting widget: " + widget.toString());
		widgetDao.delete(widget);
	}

	@Override
	public int deleteAll(Collection<Widget> widget) {
		return widgetDao.deleteAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.studerb.service.WidgetService#find(java.lang.Long)
	 */
	@Transactional(readOnly = true)
	public Widget find(Long id) {
		logger.debug("Finding widget with id: " + id);
		return widgetDao.read(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.studerb.service.WidgetService#saveOrUpdate(com.studerb.model.Widget)
	 */
	@Transactional
	public void saveOrUpdate(Widget widget) {
		logger.debug("Saving/Updating widget: " + widget.toString());
		widgetDao.saveOrUpdate(widget);
	}

	@Override
	public List<Widget> findAll() {
		List<Widget> widgets = widgetDao.getAll();
		logger.debug("fetched " + widgets.size() + " widgets");
		return widgets;
	}
}
