package com.studerb.staff;

import com.studerb.dao.DaoInterface;
import com.studerb.model.Staff;

public interface StaffDao extends DaoInterface<Staff> {

	/**
	 * Fetch a staff member by username (case insensitive)
	 * 
	 * @param username
	 * @return staff member or null if no staff members exist with
	 */
	Staff findByUsername(String username);
}
