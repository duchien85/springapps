package com.jsftest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;

public class UserBean implements Serializable {
	private final static Logger logger = Logger.getLogger(UserBean.class);
	private String name;
	private String password;
	private Integer number;
	private AddressBean address;

	public UserBean() {
		address = new AddressBean();
	}

	public AddressBean getAddress() {
		return address;
	}

	public void setAddress(AddressBean address) {
		this.address = address;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	// PROPERTY: name
	public String getName() {
		return name;
	}

	public void setName(String newValue) {
		name = newValue;
	}

	// PROPERTY: password
	public String getPassword() {
		return password;
	}

	public void setPassword(String newValue) {
		password = newValue;
	}

	public String doSomething() {
		logger.debug("DOING SOMETHING");
		if (RandomUtils.nextBoolean()) {
			return "login";
		}
		else {
			return "noLogin";
		}
	}

	public String doSomething(String param) {
		logger.debug("DOING SOMETHING: got parameter: " + param);
		if (RandomUtils.nextBoolean()) {
			return "login";
		}
		else {
			return "noLogin";
		}
	}

	public void onClick(ActionEvent event) {
		logger.debug("Clicked...");
		logger.debug(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public List<UserBean> getAllUsers() {
		int count = RandomUtils.nextInt(50) + 1;
		List<UserBean> users = new ArrayList<UserBean>(count);
		for (int i = 0; i < count; ++i) {
			users.add(createRandom());
		}
		return users;
	}

	private UserBean createRandom() {
		UserBean user = new UserBean();
		user.setName("Name_" + RandomStringUtils.randomAlphabetic(10));
		user.setPassword("Password_" + RandomStringUtils.randomAlphabetic(10));
		user.setNumber(RandomUtils.nextInt(50000));
		AddressBean address = new AddressBean();
		user.setAddress(address);
		address.setCity("City_" + RandomStringUtils.randomAlphabetic(10));
		address.setCountry(RandomStringUtils.randomAlphabetic(10));
		address.setStreet("Street_" + RandomStringUtils.randomAlphanumeric(5));
		address.setZip(RandomStringUtils.randomNumeric(5));

		return user;
	}
}
