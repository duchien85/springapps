package com.jbpmDemo.service;

//import com.joshlong.userregistrationexample.utils.LoggingUtils;

import java.util.Collection;

import javax.sql.DataSource;

import org.jbpm.JbpmConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springmodules.workflow.jbpm31.JbpmTemplate;

public class BaseService extends HibernateDaoSupport implements ApplicationContextAware {

	protected ApplicationContext appContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.appContext = applicationContext;
	}

	// protected LoggingUtils loggingUtils;
	protected JbpmConfiguration jbpmConfiguration;
	protected JbpmTemplate jbpmTemplate;
	protected DataSource dataSource;
	protected JdbcTemplate jdbcTemplate;

	protected Object firstOrNull(Collection c) {
		if (c == null || c.size() == 0) {
			return null;
		}
		return c.iterator().next();
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JbpmConfiguration getJbpmConfiguration() {
		return jbpmConfiguration;
	}

	public void setJbpmConfiguration(JbpmConfiguration jbpmConfiguration) {
		this.jbpmConfiguration = jbpmConfiguration;
	}

	public JbpmTemplate getJbpmTemplate() {
		return jbpmTemplate;
	}

	public void setJbpmTemplate(JbpmTemplate jbpmTemplate) {
		this.jbpmTemplate = jbpmTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
