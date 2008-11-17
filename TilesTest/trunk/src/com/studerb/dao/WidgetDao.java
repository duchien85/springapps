package com.studerb.dao;

import java.util.List;

import com.studerb.model.Widget;
import com.studerb.web.util.DataPage;
import com.studerb.web.util.DataPageInfo;
import com.studerb.web.util.WidgetSearchModel;

public interface WidgetDao extends DaoInterface<Widget> {
	public Boolean isNameUsed(String name);

	public List<Widget> search(WidgetSearchModel widgetSearchModel);

	public DataPage<Widget> searchDataPage(WidgetSearchModel widgetSM, DataPageInfo dpi);

}
