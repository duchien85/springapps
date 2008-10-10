package com.studerb.dao;

import org.springframework.stereotype.Repository;

import com.studerb.model.Widget;

@Repository
public class WidgetDao extends AbstractHibernateDao<Widget> implements DaoInterface<Widget> {

}
