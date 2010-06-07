package com.saic.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saic.model.BatPerson;

@Repository
@Service("geoSearchService")
public class GeoSearchService {
    final static Logger log = Logger.getLogger(GeoSearchService.class);

    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Resource(name = "spatialDataSource")
    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

    @Transactional(readOnly = true)
    public List<BatPerson> searchGuidsByWKT(String wkt) {
        log.debug("Search BAT location matches: " + wkt);
        String sql = "SELECT distinct mt.id, mt.source_tx from message_geo mg, message_text mt " + "WHERE mg.id = mt.id "
                + "AND SDO_ANYINTERACT(mg.shape, SDO_GEOMETRY(?)) = 'TRUE' order by mt.source_tx asc";
        List<BatPerson> batPersons = this.simpleJdbcTemplate.query(sql, new BatPersonMapper(), wkt);
        log.info("matched: " + batPersons.size() + " unique BAT GUIDS");
        return batPersons;
    }

    protected static final class BatPersonMapper implements RowMapper<BatPerson> {
        public BatPerson mapRow(ResultSet rs, int rowNum) throws SQLException {
            BatPerson batPerson = new BatPerson();
            batPerson.setMessageId(rs.getBigDecimal(1));
            batPerson.setBatGuid(rs.getString(2));
            // no need for the actual geom object
            // STRUCT dbObj = (STRUCT) rs.getObject(3);
            // JGeometry sdoGeom = JGeometry.load(dbObj);
            // batPerson.setGeom(sdoGeom);
            return batPerson;
        }
    }

}
