package com.studerb.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.studerb.model.Widget;
import com.studerb.web.util.WidgetSearchModel;

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
	public List<Widget> search(WidgetSearchModel wsm) {
		logger.debug("Searching for widget with widgetSearchModel: " + wsm.toString());
		Criteria criteria = getCurrentSession().createCriteria(Widget.class);
		// widgetName
		if (StringUtils.hasText(wsm.getName())) {
			criteria.add(Restrictions.eq("widgetName", wsm.getName()));
		}
		// isCool
		if (wsm.isCool() != null) {
			if (wsm.isCool()) {
				criteria.add(Restrictions.eq("cool", Boolean.TRUE));
			}
			else {
				criteria.add(Restrictions.eq("cool", Boolean.TRUE));
			}
		}
		// price
		if (wsm.getBeginPrice() != null) {
			criteria.add(Restrictions.gt("price", wsm.getBeginPrice()));
		}
		if (wsm.getEndPrice() != null) {
			criteria.add(Restrictions.lt("price", wsm.getEndPrice()));
		}
		// initialTime
		if (wsm.getBeginInitialTime() != null) {
			criteria.add(Restrictions.gt("initialTime", wsm.getBeginInitialTime()));
		}
		if (wsm.getEndInitialTime() != null) {
			criteria.add(Restrictions.lt("initialTime", wsm.getEndInitialTime()));
		}
		return criteria.list();
	}
}
