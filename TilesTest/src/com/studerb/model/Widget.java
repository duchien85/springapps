package com.studerb.model;

import java.math.BigDecimal;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.math.RandomUtils;
import org.joda.time.DateTime;

public class Widget extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private String widgetName;
	private DateTime initialTime;
	private BigDecimal price;
	private Boolean cool;

	public final static int MAX_NAME_LENGTH = 50;

	public static Widget createRandomWidget() {
		Widget widget = new Widget();
		widget.setWidgetName(RandomStringUtils.randomAlphabetic(20));
		String whole = String.valueOf(RandomUtils.nextInt(10000));
		String fractional = String.valueOf(RandomUtils.nextInt(100));
		widget.setPrice(new BigDecimal(whole + "." + fractional));
		widget.setInitialTime(new DateTime());
		widget.setCool(RandomUtils.nextBoolean());
		return widget;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Widget other = (Widget) obj;
		if (widgetName == null) {
			if (other.widgetName != null) {
				return false;
			}
		}
		else if (!widgetName.equals(other.widgetName)) {
			return false;
		}
		return true;
	}

	public Boolean getCool() {
		return isCool();
	}

	public DateTime getInitialTime() {
		return initialTime;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getWidgetName() {
		return widgetName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (widgetName == null ? 0 : widgetName.hashCode());
		return result;
	}

	public Boolean isCool() {
		return cool;
	}

	public void setCool(Boolean cool) {
		this.cool = cool;
	}

	public void setInitialTime(DateTime time) {
		initialTime = time;
	}

	public void setPrice(BigDecimal price) {
		if (price != null) {
			price = price.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		}
		this.price = price;
	}

	public void setWidgetName(String name) {
		widgetName = name;
	}

	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this).toString();
	}

}
