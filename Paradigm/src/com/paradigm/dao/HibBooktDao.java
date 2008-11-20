package com.paradigm.dao;

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

import com.paradigm.model.Book;
import com.paradigm.web.util.DataPage;
import com.paradigm.web.util.DataPageInfo;
import com.paradigm.web.util.BookSearchModel;

@Repository("bookDao")
public class HibBooktDao extends AbstractHibernateDao<Book> implements BookDao {

	private static final String TABLE_NAME = "book";

	/**
	 * @param bookName
	 *            name of book to test for duplicate
	 * @return true if some defined book already has the same name
	 */
	public Boolean isNameUsed(String bookName) {
		logger.debug("checking for book with name: " + bookName);
		Criteria c = getCurrentSession().createCriteria(Book.class).add(Restrictions.eq("bookName", bookName));
		return c.list().size() == 1 ? true : false;
	}

	@Override
	public List<Book> search(BookSearchModel wsm) {
		logger.debug("Searching for book with bookSearchModel: " + wsm.toString());
		Criteria criteria = createSearchModelCriteria(wsm);
		return criteria.list();
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@SuppressWarnings("unused")
	private static final class BookRowMapper implements RowMapper {
		@Override
		public Object mapRow(ResultSet rs, int row) throws SQLException {
			Book book = new Book();
			book.setId(rs.getLong("id"));
			book.setBookName(rs.getString("name"));
			book.setCool(rs.getBoolean("cool"));
			book.setPrice(new BigDecimal(rs.getDouble("price")));
			book.setInitialTime((DateTime) rs.getObject("time"));
			return book;
		}
	}

	@Override
	public DataPage<Book> searchDataPage(BookSearchModel bookSM, DataPageInfo dpi) {
		logger.debug("searching for DataPage using searchModel / dpInfo: " + bookSM.toString() + " / " + dpi.toString());
		Criteria criteria = createSearchModelCriteria(bookSM);
		criteria.setMaxResults(dpi.getPageSize());
		criteria.setFirstResult(dpi.getCurrentRecord());

		if (dpi.isSortDesc()) {
			criteria.addOrder(Property.forName(dpi.getSort()).desc());
		}
		else {
			criteria.addOrder(Property.forName(dpi.getSort()).asc());
		}

		List<Book> data = criteria.list();
		// don't show a datapage with no records
		if (data.isEmpty() && dpi.getCurrentPage() > 1) {
			dpi.prev();
			return getPage(dpi);
		}

		// get the row counts
		Criteria sizeCriteria = getCurrentSession().createCriteria(Book.class);
		sizeCriteria.setProjection(Projections.rowCount());
		Integer total = (Integer) sizeCriteria.uniqueResult();
		return new DataPage<Book>(data, total, dpi);
	}

	private Criteria createSearchModelCriteria(BookSearchModel wsm) {
		Criteria criteria = getCurrentSession().createCriteria(Book.class);

		if (StringUtils.hasText(wsm.getName())) {
			criteria.add(Restrictions.ilike("bookName", wsm.getName(), MatchMode.ANYWHERE));
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
