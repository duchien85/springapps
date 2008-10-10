package com.studerb.model;

import java.math.BigDecimal;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.joda.time.DateTime;

public class Widget {

	private Long id;
	private String name;
	private DateTime time;
	private BigDecimal price;
	private Boolean cool;

	public final static int MAX_NAME_LENGTH = 50;

	public static Widget createRandomWidget() {
		Widget widget = new Widget();
		widget.setName(RandomStringUtils.randomAlphabetic(20));
		String whole = String.valueOf(RandomUtils.nextInt());
		String fractional = String.valueOf(RandomUtils.nextInt(100));
		widget.setPrice(new BigDecimal(whole + "." + fractional));
		widget.setTime(new DateTime());
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
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		}
		else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public DateTime getTime() {
		return time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (name == null ? 0 : name.hashCode());
		return result;
	}

	public Boolean isCool() {
		return cool;
	}

	public void setCool(Boolean cool) {
		this.cool = cool;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("name: " + name + " longer than max length: " + MAX_NAME_LENGTH);
		}
		this.name = name;
	}

	public void setPrice(BigDecimal price) {
		if (price.doubleValue() < 0) {
			throw new IllegalArgumentException("Tried setting price negative");
		}
		this.price = price.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public void setTime(DateTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return name;
	}

}
