package com.studerb.web.util;

import org.jmesa.view.html.toolbar.HtmlToolbar;

public class FullPaginationToolbar extends HtmlToolbar {

	@Override
	public String render() {
		enablePageNumbers(true);
		return super.render();
	}

}
