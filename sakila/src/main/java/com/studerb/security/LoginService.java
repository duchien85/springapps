package com.studerb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studerb.staff.Staff;
import com.studerb.staff.StaffDao;

@Service("loginService")
public class LoginService {

	@Autowired
	protected StaffDao staffDao;

	@Transactional(readOnly = true)
	public Staff findStaffByUsername(String username) {
		return staffDao.findByUsername(username);
	}

	@Transactional
	public void inactivateStaff(String username) {
		Staff staff = staffDao.findByUsername(username);
		staff.setActive(false);
		staffDao.update(staff);
	}

	@Transactional
	public void resetStaffPassword(String username, String newPassword) throws Exception {
		Staff staff = staffDao.findByUsername(username);
		staff.setPassword(newPassword);
		staffDao.update(staff);
	}

	@Transactional(readOnly = true)
	public Staff findStaffById(Long id) {
		return staffDao.get(id);
	}

}
