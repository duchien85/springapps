package com.studerb.hr;

import java.math.BigDecimal;
import java.util.Calendar;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

import com.studerb.hr.employee.Department;
import com.studerb.hr.employee.Departments;
import com.studerb.hr.employee.Employee;
import com.studerb.hr.employee.Employees;
import com.studerb.hr.employee.Job;
import com.studerb.hr.employee.Jobs;
import com.studerb.hr.geo.Location;

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

    public static Department createDepartment10() {
        Department d = new Department(10L);
        d.setName("Administration");
        d.setLocation(new Location(1700L));
        d.setManager(new Employee(200L));
        return d;
    }

    public static Job createJobAdPres() {
        Job job = new Job("AD_PRES");
        job.setTitle("President");
        job.setMinSalary(20000L);
        job.setMaxSalary(40000L);
        return job;
    }

    public static Departments createFiveDepartments() {
        Departments departments = new Departments();

        Department d1 = new Department(10L);
        d1.setName("Administration");
        d1.setManager(new Employee(200L));
        d1.setLocation(new Location(1700L));
        departments.getDepartments().add(d1);

        Department d2 = new Department(20L);
        d2.setName("Marketing");
        d2.setManager(new Employee(201L));
        d2.setLocation(new Location(1800L));
        departments.getDepartments().add(d2);

        Department d3 = new Department(30L);
        d3.setName("Purchasing");
        d3.setManager(new Employee(114L));
        d3.setLocation(new Location(1700L));
        departments.getDepartments().add(d3);

        Department d4 = new Department(40L);
        d4.setName("Human Resources");
        d4.setManager(new Employee(203L));
        d4.setLocation(new Location(2400L));
        departments.getDepartments().add(d4);

        Department d5 = new Department(120L);
        d5.setName("Treasury");
        d5.setLocation(new Location(1700L));
        departments.getDepartments().add(d5);

        return departments;
    }

    public static Jobs createFourJobs() {
        Jobs jobs = new Jobs();

        Job j1 = new Job("AD_PRES");
        j1.setTitle("President");
        j1.setMinSalary(20000L);
        j1.setMaxSalary(40000L);
        jobs.getJobs().add(j1);

        Job j2 = new Job("AD_VP");
        j2.setTitle("Administration Vice President");
        j2.setMinSalary(15000L);
        j2.setMaxSalary(30000L);
        jobs.getJobs().add(j2);

        Job j3 = new Job("AD_ASST");
        j3.setTitle("Administration Assistant");
        j3.setMinSalary(3000L);
        j3.setMaxSalary(6000L);
        jobs.getJobs().add(j3);

        Job j4 = new Job("FI_MGR");
        j4.setTitle("Finance Manager");
        j4.setMinSalary(8200L);
        j4.setMaxSalary(16000L);
        jobs.getJobs().add(j4);

        return jobs;
    }

    public static Employees createFourEmployees() {
        Employees employees = new Employees();

        Calendar hireDate = Calendar.getInstance();

        Employee e1 = new Employee(100L);
        e1.setFirstName("Steven");
        e1.setLastName("King");
        e1.setEmail("SKING");
        e1.setPhoneNumber("515.123.4567");
        hireDate.set(1987, Calendar.JUNE, 17);
        hireDate = DateUtils.truncate(hireDate, Calendar.DAY_OF_MONTH);
        e1.setHireDate(hireDate);
        e1.setJob(new Job("AD_PRES"));
        e1.setSalary(new BigDecimal(24000));
        e1.setDepartment(new Department(90L));
        employees.getEmployees().add(e1);

        Employee e2 = new Employee(189L);
        e2.setFirstName("Jennifer");
        e2.setLastName("Dilly");
        e2.setEmail("JDILLY");
        e2.setPhoneNumber("650.505.2786");
        hireDate.set(1997, Calendar.AUGUST, 13);
        hireDate = DateUtils.truncate(hireDate, Calendar.DAY_OF_MONTH);
        e2.setHireDate(hireDate);
        e2.setJob(new Job("SH_CLERK"));
        e2.setSalary(new BigDecimal(3600));
        e2.setManager(new Employee(122L));
        e2.setDepartment(new Department(50L));
        employees.getEmployees().add(e2);

        Employee e3 = new Employee(192L);
        e3.setFirstName("Sarah");
        e3.setLastName("Bell");
        e3.setEmail("SBELL");
        e3.setPhoneNumber("650.501.1876");
        hireDate.set(1996, Calendar.FEBRUARY, 04);
        hireDate = DateUtils.truncate(hireDate, Calendar.DAY_OF_MONTH);
        e3.setHireDate(hireDate);
        e3.setJob(new Job("SH_CLERK"));
        e3.setSalary(new BigDecimal(4000));
        e3.setManager(new Employee(123L));
        e3.setDepartment(new Department(50L));
        employees.getEmployees().add(e3);

        Employee e4 = new Employee(145L);
        e4.setFirstName("John");
        e4.setLastName("Russel");
        e4.setEmail("JRUSSEL");
        e4.setPhoneNumber("011.44.1344.429268");
        hireDate.set(1996, Calendar.OCTOBER, 01);
        hireDate = DateUtils.truncate(hireDate, Calendar.DAY_OF_MONTH);
        e4.setHireDate(hireDate);
        e4.setJob(new Job("SA_MAN"));
        e4.setSalary(new BigDecimal(14000));
        e4.setCommissionPct(new BigDecimal("0.4"));
        e4.setManager(new Employee(100L));
        e4.setDepartment(new Department(80L));
        employees.getEmployees().add(e4);

        return employees;
    }
}
