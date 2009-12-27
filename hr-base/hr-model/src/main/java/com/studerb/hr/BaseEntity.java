package com.studerb.hr;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String guid = UUID.randomUUID().toString();
	protected Date lastUpdate;

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

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
