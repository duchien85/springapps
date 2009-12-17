package com.studerb.staff.imp;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.studerb.dao.hibernate.AbstractHibernateDao;
import com.studerb.staff.Staff;
import com.studerb.staff.StaffDao;

@Repository("staffDao")
public class HibStaffDao extends AbstractHibernateDao<Staff> implements StaffDao {

	private static final String TABLE_NAME = "staff";

	@Override
	public Staff findByUsername(String username) {
		logger.debug("fetching staff member by username: " + username);
		Criteria criteria = getCurrentSession().createCriteria(Staff.class);
		criteria.add(Restrictions.ilike("username", username, MatchMode.EXACT));
		return (Staff) criteria.uniqueResult();
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}
}
