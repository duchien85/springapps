package com.studerb.dao;

import java.util.List;

import com.studerb.model.Widget;
import com.studerb.web.util.WidgetSearchModel;

public interface WidgetDao extends DaoInterface<Widget> {
	public Boolean isNameUsed(String name);

	public List<Widget> search(WidgetSearchModel widgetSearchModel);
}
