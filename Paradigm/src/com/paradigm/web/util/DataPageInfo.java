package com.paradigm.web.util;

import java.io.Serializable;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;

public class DataPageInfo implements Serializable {
	private static final Logger logger = Logger.getLogger(DataPageInfo.class);
	private int currentRecord;
	private int pageSize;
	private String sort;
	private boolean sortDesc;
	private String viewName;
	private int totalRecords;

	public DataPageInfo() {
		reset();
	}

	public void reset() {
		currentRecord = 0;
		pageSize = 10;
		sort = "id";
		sortDesc = false;
		totalRecords = 0;
	}

	public void first() {
		currentRecord = 0;
	}

	public void last() {
		int max = getMaxPage();
		first();
		currentRecord += (max - 1) * pageSize;
	}

	public void next() {
		currentRecord += pageSize;
	}

	public void prev() {
		currentRecord -= pageSize;
	}

	public boolean isNext() {
		if (getCurrentPage() == getMaxPage()) {
			return false;
		}
		else {
			return true;
		}
	}

	public boolean isPrev() {
		if (getCurrentPage() == 1) {
			return false;
		}
		else {
			return true;
		}
	}

	public int getCurrentPage() {
		return (int) Math.floor((currentRecord * 1.0 / pageSize) + 1);
	}

	public int getMaxPage() {
		int rem = totalRecords % pageSize;
		int max = totalRecords / pageSize;
		if (rem == 0) {
			return max;
		}
		else {
			return max + 1;
		}
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public int getCurrentRecord() {
		return currentRecord;
	}

	public void setCurrentRecord(int currentRecord) {
		this.currentRecord = currentRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public boolean isSortDesc() {
		return sortDesc;
	}

	public void setSortDesc(boolean sortDesc) {
		this.sortDesc = sortDesc;
	}

	public void changeSort(String column) {
		logger.debug("sorting by: " + column);
		if (column.equals(getSort())) {
			setSortDesc(!isSortDesc());
		}
		else {
			setSortDesc(true);
			setSort(column);
		}
	}

	public void changePage(String changeEvent) {
		logger.debug("Got Event: " + changeEvent);
		if ("FIRST".equals(changeEvent)) {
			first();
		}
		else if ("LAST".equals(changeEvent)) {
			last();
		}
		else if ("NEXT".equals(changeEvent)) {
			next();
		}
		else if ("PREV".equals(changeEvent)) {
			prev();
		}
	}

	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this).toString();
	}

}
