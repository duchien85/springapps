package com.studerb.actor.imp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studerb.actor.Actor;
import com.studerb.actor.ActorDao;
import com.studerb.actor.ActorService;
import com.studerb.web.util.DataPage;
import com.studerb.web.util.DataPageInfo;

@Service("actorService")
public class DefaultActorService implements ActorService {
    Logger logger = Logger.getLogger(DefaultActorService.class);

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

    @Override
    @Transactional(readOnly = true)
    public int getCount() {
        logger.debug("Getting count of films");
        return actorDao.getCount();
    }

}
