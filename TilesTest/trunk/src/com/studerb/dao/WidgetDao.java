package com.studerb.dao;

import java.util.List;

import com.studerb.model.Widget;

public interface WidgetDao extends DaoInterface<Widget> {
	public Boolean isNameUsed(String name);

	public List<Widget> search(String name);
}
