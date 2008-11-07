package com.studerb.service;

import java.util.Arrays;
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
	@Transactional(readOnly = true)
	public boolean isNameUsed(String name) {
		boolean used = widgetDao.isNameUsed(name);
		logger.debug("Widget name: " + name + " already used: " + used);
		return used;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		logger.debug("deleting widget: " + id);
		widgetDao.delete(id);
	}

	@Override
	@Transactional
	public int deleteAll(List<Long> widgetIds) {
		Long[] ids = widgetIds.toArray(new Long[0]);
		logger.debug("deleting widgets: " + Arrays.toString(ids));
		int count = 0;
		for (Long id : widgetIds) {
			Widget w = widgetDao.get(id);
			widgetDao.delete(w);
			count++;
		}
		return count;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Widget> search(String name) {
		List<Widget> widgets = widgetDao.search(name);
		logger.debug("found " + widgets.size() + " widgets by name: " + name);
		return widgets;
	}

	@Override
	@Transactional
	public void saveOrUpdateAll(Collection<Widget> widgets) {
		logger.debug("Saving/updating " + widgets.size() + " widgets");
		widgetDao.saveOrUpdateAll(widgets);
	}

}
