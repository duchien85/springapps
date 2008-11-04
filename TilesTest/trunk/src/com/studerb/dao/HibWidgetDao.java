package com.studerb.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.studerb.model.Widget;

@Repository("widgetDao")
public class HibWidgetDao extends AbstractHibernateDao<Widget> implements WidgetDao {

	/**
	 * @param widgetName
	 *            name of widget to test for duplicate
	 * @return true if some defined widget already has the same name
	 */
	public Boolean isNameUsed(String widgetName) {
		logger.debug("checking for widget with name: " + widgetName);
		Criteria c = getCurrentSession().createCriteria(Widget.class).add(Restrictions.eq("widgetName", widgetName));
		return c.list().size() == 1 ? true : false;
	}

	@Override
	public List<Widget> search(String name) {
		logger.debug("Searching for widget with name: " + name);
		Criteria criteria = getCurrentSession().createCriteria(Widget.class);
		if (StringUtils.hasText(name)) {
			criteria.add(Restrictions.eq("widgetName", name));
		}
		return criteria.list();
	}

}
