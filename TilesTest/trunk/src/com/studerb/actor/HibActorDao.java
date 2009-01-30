package com.studerb.actor;

import org.springframework.stereotype.Repository;

import com.studerb.dao.hibernate.AbstractHibernateDao;
import com.studerb.model.Actor;

@Repository("actorDao")
public class HibActorDao extends AbstractHibernateDao<Actor> implements ActorDao {

	private static final String TABLE_NAME = "actor";

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

}
