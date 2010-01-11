package com.studerb.hr.model;

import java.util.Calendar;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.FastDateFormat;

public class CalendarAdapter extends XmlAdapter<String, Calendar> {
    private static final FastDateFormat dateFormat = DateFormatUtils.ISO_DATE_FORMAT;

    @Override
    public String marshal(Calendar v) throws Exception {
        Calendar c = DateUtils.truncate(v, Calendar.DAY_OF_MONTH);
        String formatted = dateFormat.format(c);
        return formatted;

    }

    @Override
    public Calendar unmarshal(String v) throws Exception {
        Calendar c = DatatypeConverter.parseDate(v);
        Calendar d = DateUtils.truncate(c, Calendar.DAY_OF_MONTH);
        return d;
    }

}
