package com.studerb.widget;

import java.util.Collection;
import java.util.List;

import com.studerb.model.Widget;
import com.studerb.web.util.DataPage;
import com.studerb.web.util.DataPageInfo;
import com.studerb.widget.web.WidgetSearchModel;

public interface WidgetService {

	/**
	 * delete widget using id
	 * 
	 * @param id
	 */

	public void delete(Long id);

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
	int deleteAll(Collection<Widget> widgets);

	/**
	 * Delete collection of widgets using the id
	 * 
	 * @param widgetIds
	 * @return number of widgets deleted
	 */
	int deleteAll(List<Long> widgetIds);

	/**
	 * Delete all widgets from persistence
	 * 
	 * @return count of rows deleted
	 */
	int deleteAllObjects();

	/**
	 * fetch the widget
	 * 
	 * @param id
	 * @return
	 */
	Widget get(Long id);

	/**
	 * @return list of all widgets
	 */
	List<Widget> getAll();

	DataPage<Widget> getDatePage(DataPageInfo info);

	boolean isNameUsed(String name);

	/**
	 * Save or update the widget
	 * 
	 * @param widget
	 */
	Long save(Widget widget);

	void saveOrUpdateAll(Collection<Widget> widgets);

	List<Widget> search(WidgetSearchModel widgetSearchModel);

	DataPage<Widget> searchDataPage(WidgetSearchModel widgetSM, DataPageInfo dpi);

	/**
	 * Update a widget
	 * 
	 * @param w
	 */
	void update(Widget w);

}
