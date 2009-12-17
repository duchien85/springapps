package com.studerb.actor;

import java.util.List;

import com.studerb.web.util.DataPage;
import com.studerb.web.util.DataPageInfo;

public interface ActorService {
    public Actor get(Long id);

    public List<Actor> getAll();

    public DataPage<Actor> getDatePage(DataPageInfo info);

    public int getCount();

}
