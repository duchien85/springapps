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
	Widget find(Long id);

	/**
	 * Save or update the widget
	 * 
	 * @param widget
	 */
	void saveOrUpdate(Widget widget);

	/**
	 * @return list of all widgets
	 */
	List<Widget> findAll();

}
