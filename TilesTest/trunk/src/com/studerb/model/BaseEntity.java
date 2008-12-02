package com.studerb.model;

import java.io.Serializable;
import java.util.UUID;

import org.joda.time.DateTime;

/**
 * @author Travis Klotz
 */

public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String guid = UUID.randomUUID().toString();
	protected int version;
	protected DateTime lastUpdate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof BaseEntity)) {
			return false;
		}

		BaseEntity that = (BaseEntity) o;

		if (!guid.equals(that.guid)) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return guid.hashCode();
	}
}
