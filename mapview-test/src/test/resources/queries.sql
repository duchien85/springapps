  
set serveroutput on
DECLARE
  wkt VARCHAR2(100);
BEGIN
  FOR i IN 1..10 loop
    SELECT SDO_UTIL.TO_WKTGEOMETRY(SDO_GEOM.SDO_POINTONSURFACE(country.geom, m.diminfo))
    INTO wkt 
    FROM WORLD_COUNTRIES country,
      user_sdo_geom_metadata m
    WHERE m.table_name     = 'WORLD_COUNTRIES'
    AND m.column_name      = 'GEOM'
    AND country.CNTRY_NAME = 'Afghanistan';
    
    DBMS_OUTPUT.PUT_LINE('The text: ' || wkt);
  END LOOP;
END;

set serveroutput on
DECLARE
  wkt VARCHAR2(500);
BEGIN
    SELECT SDO_UTIL.TO_WKTGEOMETRY(SDO_GEOM.SDO_MBR(country.geom, m.diminfo))
    INTO wkt 
    FROM WORLD_COUNTRIES country,
      user_sdo_geom_metadata m
    WHERE m.table_name     = 'WORLD_COUNTRIES'
    AND m.column_name      = 'GEOM'
    AND country.CNTRY_NAME = 'Afhanistan';
    
    DBMS_OUTPUT.PUT_LINE('The text: ' || wkt);
END;
/

select cntry_name, sqmi_cntry, ((sqmi_cntry)/(51842241.875) * 100 ) as percentage
from world_countries 
where cntry_name <> 'Antarctica'
order by sqmi_cntry desc;

select * from world_continents
order by id asc;

select objectid from world_continents wc
where SDO_ANYINTERACT(wc.GEOM, SDO_GEOMETRY('POINT(0 90)', 8307)) = 'TRUE'
union all
select 0 from dual where not exists (select objectid from world_continents wc where SDO_ANYINTERACT(wc.GEOM, SDO_GEOMETRY('POINT(0 90)', 8307)) = 'TRUE');


select min(objectid) from world_continents;

insert into random_points(continent_id, geom) values(61, SDO_GEOMETRY('POINT(-7 53)', 8307));

select count(*) from random_points;
select * from random_points WHERE ROWNUM < 10;
truncate table random_points;
commit;

--Drop sequence

DROP SEQUENCE RANDOM_POINTS_SEQ;

-- Create sequence

create sequence RANDOM_POINTS_SEQ minvalue 1 maxvalue 999999999999999999999 start with 1 increment by 1 cache 20;
commit;

select wc.id, wc.cntry_name, rp.continent_id
from world_countries wc, random_points rp
where SDO_CONTAINS(wc.GEOM, rp.geom, 8307)) = 'TRUE';