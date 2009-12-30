package com.studerb.hr;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

import com.studerb.hr.employee.Department;
import com.studerb.hr.employee.Employee;
import com.studerb.hr.employee.Job;

/**
 * Utilities to create mock model objects used for testing
 */
public class ModelUtils {
    final static Logger log = Logger.getLogger(ModelUtils.class);

    // e.g. 1987-06-17T00:00:00.546-04:00

    /**
     * Create a &apos;shallow&apos; instance of Employee with id #100 from the
     * default HR schema data. Instance entity references (manager, department,
     * etc.) are shallow in the sense that they only contain the ids.
     * 
     * @return
     */
    public static Employee createEmployee100() {
        Employee e = new Employee(100L);
        e.setFirstName("Steven");
        e.setLastName("King");
        e.setEmail("SKING");
        e.setPhoneNumber("515.123.4567");
        Calendar hireDate = Calendar.getInstance();
        hireDate.set(1987, Calendar.JUNE, 17);
        hireDate = DateUtils.truncate(hireDate, Calendar.DAY_OF_MONTH);
        e.setHireDate(hireDate);
        e.setJob(new Job("AD_PRES"));
        e.setSalary(new BigDecimal(24000));
        e.setDepartment(new Department(90L));
        return e;
    }

    public static File getClassPathFile(String filePath) {
        URL xmlUrl = ModelUtils.class.getClassLoader().getResource(filePath);
        File file = new File(xmlUrl.getFile());
        return file;
    }

    public static String classPathFileToString(String filePath) throws IOException {
        File file = getClassPathFile(filePath);
        String s = FileUtils.readFileToString(file);
        return s;
    }

    public static String classPathFileToString(String filePath, String encoding) throws IOException {
        File file = getClassPathFile(filePath);
        String s = FileUtils.readFileToString(file, encoding);
        return s;
    }

}
