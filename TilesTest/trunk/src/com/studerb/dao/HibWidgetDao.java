package com.studerb.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.studerb.model.Widget;
import com.studerb.web.util.DataPage;
import com.studerb.web.util.DataPageInfo;
import com.studerb.web.util.WidgetSearchModel;

@Repository("widgetDao")
public class HibWidgetDao extends AbstractHibernateDao<Widget> implements WidgetDao {

	private static final String TABLE_NAME = "widget";

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
		Criteria criteria = createSearchModelCriteria(wsm);
		return criteria.list();
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@SuppressWarnings("unused")
	private static final class WidgetRowMapper implements RowMapper {
		@Override
		public Object mapRow(ResultSet rs, int row) throws SQLException {
			Widget widget = new Widget();
			widget.setId(rs.getLong("id"));
			widget.setWidgetName(rs.getString("name"));
			widget.setCool(rs.getBoolean("cool"));
			widget.setPrice(new BigDecimal(rs.getDouble("price")));
			widget.setInitialTime((DateTime) rs.getObject("time"));
			return widget;
		}
	}

	@Override
	public DataPage<Widget> searchDataPage(WidgetSearchModel widgetSM, DataPageInfo dpi) {
		logger.debug("searching for DataPage using searchModel / dpInfo: " + widgetSM.toString() + " / " + dpi.toString());
		Criteria criteria = createSearchModelCriteria(widgetSM);
		criteria.setMaxResults(dpi.getPageSize());
		criteria.setFirstResult(dpi.getCurrentRecord());

		if (dpi.isSortDesc()) {
			criteria.addOrder(Property.forName(dpi.getSort()).desc());
		}
		else {
			criteria.addOrder(Property.forName(dpi.getSort()).asc());
		}

		List<Widget> data = criteria.list();
		// don't show a datapage with no records
		if (data.isEmpty() && dpi.getCurrentPage() != 1) {
			dpi.prev();
			return getPage(dpi);
		}

		// get the row counts
		Criteria sizeCriteria = getCurrentSession().createCriteria(Widget.class);
		sizeCriteria.setProjection(Projections.rowCount());
		Integer total = (Integer) sizeCriteria.uniqueResult();
		return new DataPage<Widget>(data, total, dpi);
	}

	private Criteria createSearchModelCriteria(WidgetSearchModel wsm) {
		Criteria criteria = getCurrentSession().createCriteria(Widget.class);

		if (StringUtils.hasText(wsm.getName())) {
			criteria.add(Restrictions.ilike("widgetName", wsm.getName(), MatchMode.ANYWHERE));
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
		return criteria;
	}
}
