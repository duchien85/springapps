package com.studerb.actor;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studerb.model.Actor;
import com.studerb.web.util.DataPage;
import com.studerb.web.util.DataPageInfo;

@Service("actorService")
public class ActorService {
	Logger logger = Logger.getLogger(ActorService.class);

	@Autowired
	private ActorDao actorDao;

	@Transactional(readOnly = true)
	public Actor get(Long id) {
		logger.debug("Finding actor with id: " + id);
		return actorDao.get(id);
	}

	@Transactional(readOnly = true)
	public List<Actor> getAll() {
		List<Actor> actors = actorDao.getAll();
		logger.debug("fetched " + actors.size() + " actors");
		return actors;
	}

	@Transactional(readOnly = true)
	public DataPage<Actor> getDatePage(DataPageInfo info) {
		logger.debug("getting data page of actors -> dpInfo: " + info.toString());
		return actorDao.getPage(info);
	}

}
