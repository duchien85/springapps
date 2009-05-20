package com.studerb.web.util;

import java.util.List;

public class DataPage<T> {
	private List<T> data;
	private DataPageInfo info;

	public DataPage(List<T> data, int totalRecords, DataPageInfo info) {
		this.data = data;
		this.info = info;
		info.setTotalRecords(totalRecords);
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public DataPageInfo getInfo() {
		return info;
	}

	public void setInfo(DataPageInfo info) {
		this.info = info;
	}
}
