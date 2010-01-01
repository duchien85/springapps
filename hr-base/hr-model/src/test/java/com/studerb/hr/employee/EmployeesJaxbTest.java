package com.studerb.hr.employee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.StringWriter;
import java.math.BigDecimal;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.JAXBException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.junit.Test;

import com.studerb.hr.AbstractJaxbTest;
import com.studerb.hr.ModelUtils;

public class EmployeesJaxbTest extends AbstractJaxbTest {
    static final Logger logger = Logger.getLogger(EmployeesJaxbTest.class);

    @Test
    public void EmployeesToXml() throws Exception {
        Employees employees = ModelUtils.createFourEmployees();
        StringWriter writer = new StringWriter();
        marshaller.marshal(employees, writer);
        logger.debug("\n-------------\n" + writer.toString());
        Document document = DocumentHelper.parseText(writer.toString());

        Employee e1 = employees.getEmployees().get(0);
        assertEquals(e1.getId(), Long.valueOf(document.valueOf("/employees/employee[1]/@id")));
        assertEquals(e1.getFirstName(), document.valueOf("/employees/employee[1]/first_name"));
        assertEquals(e1.getLastName(), document.valueOf("/employees/employee[1]/last_name"));
        assertEquals(e1.getEmail(), document.valueOf("/employees/employee[1]/email"));
        assertEquals(e1.getPhoneNumber(), document.valueOf("/employees/employee[1]/phone_number"));
        assertTrue(DateUtils.isSameDay(e1.getHireDate(), DatatypeConverter.parseDate(document.valueOf("/employees/employee[1]/hire_date"))));
        assertEquals(e1.getSalary(), new BigDecimal(document.valueOf("/employees/employee[1]/salary")));
        assertTrue(StringUtils.isBlank(document.valueOf("/employees/employee[1]/commission_pct")));
        assertEquals(e1.getJobId(), document.valueOf("/employees/employee[1]/job_id"));
        assertTrue(StringUtils.isBlank(document.valueOf("/employees/employee[1]/manager_id")));
        assertEquals(e1.getDepartmentId(), Long.valueOf(document.valueOf("/employees/employee[1]/department_id")));

        Employee e2 = employees.getEmployees().get(1);
        assertEquals(e2.getId(), Long.valueOf(document.valueOf("/employees/employee[2]/@id")));
        assertEquals(e2.getFirstName(), document.valueOf("/employees/employee[2]/first_name"));
        assertEquals(e2.getLastName(), document.valueOf("/employees/employee[2]/last_name"));
        assertEquals(e2.getEmail(), document.valueOf("/employees/employee[2]/email"));
        assertEquals(e2.getPhoneNumber(), document.valueOf("/employees/employee[2]/phone_number"));
        assertTrue(DateUtils.isSameDay(e2.getHireDate(), DatatypeConverter.parseDate(document.valueOf("/employees/employee[2]/hire_date"))));
        assertEquals(e2.getSalary(), new BigDecimal(document.valueOf("/employees/employee[2]/salary")));
        assertTrue(StringUtils.isBlank(document.valueOf("/employees/employee[2]/commission_pct")));
        assertEquals(e2.getJobId(), document.valueOf("/employees/employee[2]/job_id"));
        assertEquals(e2.getDepartmentId(), Long.valueOf(document.valueOf("/employees/employee[2]/department_id")));
        assertEquals(e2.getManagerId(), Long.valueOf(document.valueOf("/employees/employee[2]/manager_id")));

        Employee e3 = employees.getEmployees().get(2);
        assertEquals(e3.getId(), Long.valueOf(document.valueOf("/employees/employee[3]/@id")));
        assertEquals(e3.getFirstName(), document.valueOf("/employees/employee[3]/first_name"));
        assertEquals(e3.getLastName(), document.valueOf("/employees/employee[3]/last_name"));
        assertEquals(e3.getEmail(), document.valueOf("/employees/employee[3]/email"));
        assertEquals(e3.getPhoneNumber(), document.valueOf("/employees/employee[3]/phone_number"));
        assertTrue(DateUtils.isSameDay(e3.getHireDate(), DatatypeConverter.parseDate(document.valueOf("/employees/employee[3]/hire_date"))));
        assertEquals(e3.getSalary(), new BigDecimal(document.valueOf("/employees/employee[3]/salary")));
        assertTrue(StringUtils.isBlank(document.valueOf("/employees/employee[3]/commission_pct")));
        assertEquals(e3.getJobId(), document.valueOf("/employees/employee[3]/job_id"));
        assertEquals(e3.getDepartmentId(), Long.valueOf(document.valueOf("/employees/employee[3]/department_id")));
        assertEquals(e3.getManagerId(), Long.valueOf(document.valueOf("/employees/employee[3]/manager_id")));

        Employee e4 = employees.getEmployees().get(3);
        assertEquals(e4.getId(), Long.valueOf(document.valueOf("/employees/employee[4]/@id")));
        assertEquals(e4.getFirstName(), document.valueOf("/employees/employee[4]/first_name"));
        assertEquals(e4.getLastName(), document.valueOf("/employees/employee[4]/last_name"));
        assertEquals(e4.getEmail(), document.valueOf("/employees/employee[4]/email"));
        assertEquals(e4.getPhoneNumber(), document.valueOf("/employees/employee[4]/phone_number"));
        assertTrue(DateUtils.isSameDay(e4.getHireDate(), DatatypeConverter.parseDate(document.valueOf("/employees/employee[4]/hire_date"))));
        assertEquals(e4.getSalary(), new BigDecimal(document.valueOf("/employees/employee[4]/salary")));
        assertEquals(e4.getCommissionPct(), new BigDecimal(document.valueOf("/employees/employee[4]/commission_pct")));
        assertEquals(e4.getJobId(), document.valueOf("/employees/employee[4]/job_id"));
        assertEquals(e4.getDepartmentId(), Long.valueOf(document.valueOf("/employees/employee[4]/department_id")));
        assertEquals(e4.getManagerId(), Long.valueOf(document.valueOf("/employees/employee[4]/manager_id")));

    }

    @Test
    public void xmlToEmployees() throws JAXBException {
        File f = getClassPathFile("xml/employees.xml");
        assertTrue(f.exists());
        Employees unmarhalled = (Employees) unmarshaller.unmarshal(f);
        Employees obj = ModelUtils.createFourEmployees();
        logger.debug("from XML\n" + unmarhalled.toString());
        logger.debug("from obj\n: " + obj.toString());
        assertEquals(obj, unmarhalled);
    }
}
