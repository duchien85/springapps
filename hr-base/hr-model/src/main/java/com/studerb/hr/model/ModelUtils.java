package com.studerb.hr.model;

import java.math.BigDecimal;
import java.util.Calendar;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.log4j.Logger;

/**
 * Utilities to create mock model objects used for testing
 */
public class ModelUtils {
    final static Logger log = Logger.getLogger(ModelUtils.class);
    private final static FastDateFormat fdf = DateFormatUtils.ISO_DATE_FORMAT;

    /**
     * @return Create a &apos;shallow&apos; instance of Employee with id #100
     *         from the default HR schema data and also the xml file:
     *         <em>/src/test/resources/xml/employee.xml.</em> Instance entity
     *         references (manager, department, etc.) are shallow in the sense
     *         that they only contain the ids.
     */
    public static Employee createEmployee100() {
        Employee e = new Employee(100L);
        e.setFirstName("Steven");
        e.setLastName("King");
        e.setEmail("SKING");
        e.setPhoneNumber("515.123.4567");
        Calendar hireDate = Calendar.getInstance();
        hireDate.set(1987, Calendar.JUNE, 17);
        e.setHireDate(hireDate);
        e.setJob(new Job("AD_PRES"));
        e.setSalary(new BigDecimal(24000));
        e.setDepartment(new Department(90L));
        return e;
    }

    public static Employee createNewEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Bob");
        employee.setLastName("Alvabcc");
        employee.setEmail("ALVABCC");
        Calendar hireDate = Calendar.getInstance();
        hireDate.set(2010, Calendar.JANUARY, 5);
        employee.setHireDate(hireDate);
        employee.setCommissionPct(new BigDecimal("0.50"));
        employee.setPhoneNumber("123.456.7890");
        employee.setManager(new Employee(100L));
        employee.setDepartment(new Department(30L));
        employee.setJob(new Job("PU_MAN"));
        employee.setSalary(new BigDecimal("11000"));

        return employee;
    }

    /**
     * @return {@link Department Department} instance coorelating to the xml
     *         file <em>jobHistory.xml</em> in <em>src/test/resources/xml</em>
     *         and employee {@code #102} in the hr schema
     */
    public static Department createDepartment10() {
        Department d = new Department(10L);
        d.setName("Administration");
        d.setLocation(new Location(1700L));
        d.setManager(new Employee(200L));
        return d;
    }

    /**
     * @return an instance of {@link Job Job} that refers to job with id of
     *         <em>AD_PRES</em> in the database and also the file @ code
     *         src/test/resources/xml/job.xml} .
     */
    public static Job createJobAdPres() {
        Job job = new Job("AD_PRES");
        job.setTitle("President");
        job.setMinSalary(20000L);
        job.setMaxSalary(40000L);
        return job;
    }

    /**
     * @return {@link Departments Departments} instance which is essentially an
     *         XML wrapper type of a list of {@link Department Departments}.
     *         This list cooresponds to five departments as listed in the file
     *         <em>src/test/resources/xml/departments.xml</em>.
     */
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

    /**
     * @return a {@link Jobs Jobs} instance which is essentially an XML wrapper
     *         around a list of {@link Job Jobs}. This list cooresponds with
     *         four jobs listed in the file <em>src/test/resources/jobs.xml</em>
     *         .
     */
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

    /**
     * @return a {@link Employees Employees} instance which is just an XML
     *         wrapper type for a list of {@link Employee Employees}. This list
     *         cooresponds to the file
     *         <em>src/test/resources/xml/employees.xml</em>.
     */
    public static Employees createFourEmployees() {
        Employees employees = new Employees();

        Calendar hireDate = Calendar.getInstance();

        Employee e1 = new Employee(100L);
        e1.setFirstName("Steven");
        e1.setLastName("King");
        e1.setEmail("SKING");
        e1.setPhoneNumber("515.123.4567");
        hireDate.set(1987, Calendar.JUNE, 17);
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
        e4.setHireDate(hireDate);
        e4.setJob(new Job("SA_MAN"));
        e4.setSalary(new BigDecimal(14000));
        e4.setCommissionPct(new BigDecimal("0.4"));
        e4.setManager(new Employee(100L));
        e4.setDepartment(new Department(80L));
        employees.getEmployees().add(e4);

        return employees;
    }

    /**
     * @return JobHistory instance coorelating to the xml file
     *         <em>jobHistory.xml</em> in <em>src/test/resources/xml</em> and
     *         employee 102 in the hr schema
     */
    public static JobHistory createJobHistory102() {
        JobHistory jh = new JobHistory();
        jh.setEmployee(new Employee(102L));
        Calendar startDate = Calendar.getInstance();
        startDate.set(1993, Calendar.JANUARY, 13);

        jh.setStartDate(startDate);
        Calendar endDate = Calendar.getInstance();
        endDate.set(1998, Calendar.JULY, 24);
        DateUtils.truncate(endDate, Calendar.DAY_OF_MONTH);
        jh.setEndDate(endDate);
        jh.setJob(new Job("AD_PRES"));
        jh.setDepartment(new Department(110L));

        return jh;
    }

    /**
     * @return a {@link JobHistories JobHistories} instance which is just an XML
     *         wrapper type for a list of {@link JobHistory JobHistory}. This
     *         list cooresponds to the file
     *         <em>src/test/resources/xml/jobHistories.xml</em> and the job
     *         histories of employee #101 from the HR schema
     */
    public static JobHistories createJobHistories101() {
        JobHistories jobHistories = new JobHistories();

        JobHistory jh = new JobHistory();
        jh.setEmployee(new Employee(101L));
        Calendar startDate = Calendar.getInstance();
        startDate.set(1989, Calendar.SEPTEMBER, 21);
        DateUtils.truncate(startDate, Calendar.DAY_OF_MONTH);
        jh.setStartDate(startDate);
        Calendar endDate = Calendar.getInstance();
        endDate.set(1993, Calendar.OCTOBER, 27);
        DateUtils.truncate(endDate, Calendar.DAY_OF_MONTH);
        jh.setEndDate(endDate);
        jh.setJob(new Job("AC_ACCOUNT"));
        jh.setDepartment(new Department(110L));
        jobHistories.getJobHistories().add(jh);

        JobHistory jh2 = new JobHistory();
        jh2.setEmployee(new Employee(101L));
        startDate = Calendar.getInstance();
        startDate.set(1993, Calendar.OCTOBER, 28);
        startDate = DateUtils.truncate(startDate, Calendar.DAY_OF_MONTH);
        jh2.setStartDate(startDate);
        endDate = Calendar.getInstance();
        endDate.set(1997, Calendar.MARCH, 15);
        DateUtils.truncate(endDate, Calendar.DAY_OF_MONTH);
        jh2.setEndDate(endDate);
        jh2.setJob(new Job("AC_MGR"));
        jh2.setEndDate(endDate);
        jh2.setDepartment(new Department(110L));
        jobHistories.getJobHistories().add(jh2);

        return jobHistories;
    }
}
