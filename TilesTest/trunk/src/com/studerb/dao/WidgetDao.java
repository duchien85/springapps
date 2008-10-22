package com.studerb.dao;

import com.studerb.model.Widget;

public interface WidgetDao extends DaoInterface<Widget> {
	public Boolean isNameUsed(String name);
}
