package com.studerb.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.studerb.model.Widget;

@Repository("widgetDao")
public class HibWidgetDao extends AbstractHibernateDao<Widget> implements WidgetDao {

	/**
	 * @param widgetName
	 *            name of widget to test for duplicate
	 * @return true if some defined widget already has the same name
	 */
	public Boolean isNameUsed(String widgetName) {
		this.logger.debug("checking for widget with name: " + widgetName);
		Criteria c = getCurrentSession().createCriteria(Widget.class).add(Restrictions.eq("widgetName", widgetName));
		return c.list().size() == 1 ? true : false;
	}

}
