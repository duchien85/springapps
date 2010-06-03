package com.saic.service;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Service;

import com.saic.model.BatPerson;

@Service("geoSearchService")
public class GeoSearchService {

    public Set<BatPerson> searchGuidsByLocation(String wkt) {
        int count = RandomUtils.nextInt(60);
        SortedSet<BatPerson> persons = new TreeSet<BatPerson>();
        for (int i = 0; i < count; ++i) {
            persons.add(new BatPerson(RandomStringUtils.randomAlphanumeric(16)));
        }
        return persons;
    }
}
