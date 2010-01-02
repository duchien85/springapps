package com.studerb.hr.employee;

import java.util.Calendar;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.FastDateFormat;

public class CalendarAdapter extends XmlAdapter<String, Calendar> {

    @Override
    public String marshal(Calendar v) throws Exception {
        Calendar c = DateUtils.truncate(v, Calendar.DAY_OF_MONTH);
        FastDateFormat f = DateFormatUtils.ISO_DATE_FORMAT;
        return f.format(c);

    }

    @Override
    public Calendar unmarshal(String v) throws Exception {
        Calendar c = DatatypeConverter.parseDate(v);
        c = DateUtils.truncate(c, Calendar.DAY_OF_MONTH);
        return c;
    }

}
