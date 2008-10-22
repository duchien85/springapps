package com.studerb.service.interfaces;

import java.util.Collection;
import java.util.List;

import com.studerb.model.Widget;

/**
 * @author bstuder
 * 
 */
public interface WidgetService {

	/**
	 * delete the widget
	 * 
	 * @param widget
	 */
	public void delete(Widget widget);

	/**
	 * delete all the widgets
	 * 
	 * @param widget
	 * @return number of widgets deleted
	 */
	int deleteAll(Collection<Widget> widget);

	/**
	 * fetch the widget
	 * 
	 * @param id
	 * @return
	 */
	Widget get(Long id);

	/**
	 * Save or update the widget
	 * 
	 * @param widget
	 */
	void saveOrUpdate(Widget widget) throws Exception;

	/**
	 * @return list of all widgets
	 */
	List<Widget> getAll();

	/**
	 * @param widgetName
	 *            name of widget to test for duplicate
	 * @return true if some defined widget already has the same name
	 */
	Boolean isNameUsed(String widgetName);

}
