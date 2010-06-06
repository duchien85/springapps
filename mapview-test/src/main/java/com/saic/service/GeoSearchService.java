package com.saic.service;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saic.model.BatPerson;

@Repository
@Service("geoSearchService")
public class GeoSearchService {

    private JdbcTemplate jdbcTemplate;

    @Resource(name = "spatialDataSource")
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Transactional(readOnly = true)
    public Set<BatPerson> searchGuidsByLocation(String wkt) {
        int count = RandomUtils.nextInt(60);
        SortedSet<BatPerson> persons = new TreeSet<BatPerson>();
        for (int i = 0; i < count; ++i) {
            persons.add(new BatPerson(RandomStringUtils.randomAlphanumeric(16)));
        }
        return persons;
    }
}
