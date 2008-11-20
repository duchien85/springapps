package com.paradigm.model;

import java.math.BigDecimal;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.math.RandomUtils;
import org.joda.time.DateTime;

public class Book {

	private Long id;
	private String bookName;
	private DateTime initialTime;
	private BigDecimal price;
	private Boolean cool;

	public final static int MAX_NAME_LENGTH = 50;

	public static Book createRandomBook() {
		Book book = new Book();
		book.setBookName(RandomStringUtils.randomAlphabetic(20));
		String whole = String.valueOf(RandomUtils.nextInt(10000));
		String fractional = String.valueOf(RandomUtils.nextInt(100));
		book.setPrice(new BigDecimal(whole + "." + fractional));
		book.setInitialTime(new DateTime());
		book.setCool(RandomUtils.nextBoolean());
		return book;
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
		Book other = (Book) obj;
		if (bookName == null) {
			if (other.bookName != null) {
				return false;
			}
		}
		else if (!bookName.equals(other.bookName)) {
			return false;
		}
		return true;
	}

	public Long getId() {
		return id;
	}

	public String getBookName() {
		return bookName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public DateTime getInitialTime() {
		return initialTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (bookName == null ? 0 : bookName.hashCode());
		return result;
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setBookName(String name) {
		bookName = name;
	}

	public void setPrice(BigDecimal price) {
		if (price != null) {
			price = price.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		}
		this.price = price;
	}

	public void setInitialTime(DateTime time) {
		initialTime = time;
	}

	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this).toString();
	}

}
