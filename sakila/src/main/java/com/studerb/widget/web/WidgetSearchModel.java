package com.studerb.widget.web;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.joda.time.DateTime;

public class WidgetSearchModel {

	String name;
	Boolean cool;
	DateTime beginInitialTime;
	DateTime endInitialTime;
	BigDecimal beginPrice;
	BigDecimal endPrice;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean isCool() {
		return cool;
	}

	public Boolean getCool() {
		return isCool();
	}

	public void setCool(Boolean cool) {
		this.cool = cool;
	}

	public DateTime getBeginInitialTime() {
		return beginInitialTime;
	}

	public void setBeginInitialTime(DateTime beginDate) {
		beginInitialTime = beginDate;
	}

	public DateTime getEndInitialTime() {
		return endInitialTime;
	}

	public void setEndInitialTime(DateTime endDate) {
		endInitialTime = endDate;
	}

	public BigDecimal getBeginPrice() {
		return beginPrice;
	}

	public void setBeginPrice(BigDecimal beginPrice) {
		this.beginPrice = beginPrice;
	}

	public BigDecimal getEndPrice() {
		return endPrice;
	}

	public void setEndPrice(BigDecimal endPrice) {
		this.endPrice = endPrice;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
