package com.studerb.service.interfaces;

import java.util.Collection;
import java.util.List;

import com.studerb.model.Widget;

public interface WidgetService {

	/**
	 * delete the widget
	 * 
	 * @param widget
	 */

	public void delete(Widget widget);

	/**
	 * delete widget using id
	 * 
	 * @param id
	 */

	public void delete(Long id);

	/**
	 * delete all the widgets
	 * 
	 * @param widget
	 * @return number of widgets deleted
	 */
	int deleteAll(Collection<Widget> widgets);

	/**
	 * Delete collection of widgets using the id
	 * 
	 * @param widgetIds
	 * @return number of widgets deleted
	 */
	int deleteAll(List<Long> widgetIds);

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
	Long save(Widget widget);

	/**
	 * @return list of all widgets
	 */
	List<Widget> getAll();

	/**
	 * Update a widget
	 * 
	 * @param w
	 */
	void update(Widget w);

	/**
	 * Delete all widgets from persistence
	 * 
	 * @return count of rows deleted
	 */
	int deleteAllObjects();

	boolean isNameUsed(String name);

	List<Widget> search(String name);

}
