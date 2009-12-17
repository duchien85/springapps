//package com.studerb.security;
//
//import static org.junit.Assert.*;
//
//import org.apache.commons.lang.SystemUtils;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.binding.mapping.impl.DefaultMappingResults;
//import org.springframework.binding.validation.ValidationContext;
//import org.springframework.test.annotation.ExpectedException;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
//import org.springframework.webflow.test.MockRequestContext;
//import org.springframework.webflow.validation.DefaultValidationContext;
//
//import com.studerb.security.InactiveStaffException;
//import com.studerb.security.web.WebSecurityModel;
//import com.studerb.security.web.WebSecurityModelValidator;
//
//@ContextConfiguration(locations = { "classpath:/test-context.xml" })
//public class WebSecurityModelValidatorTest extends AbstractTransactionalJUnit4SpringContextTests {
//
//	private final String path = SystemUtils.USER_DIR + SystemUtils.FILE_SEPARATOR + "db" + SystemUtils.FILE_SEPARATOR;
//	private String resource = "file:" + path + "test-staffData.sql";
//
//	@Autowired
//	protected WebSecurityModelValidator validator;
//
//	private MockRequestContext requestContext;
//	private ValidationContext validationContext;
//	private WebSecurityModel model;
//
//	@Before
//	public void setUp() throws Exception {
//		executeSqlScript(resource, false);
//		requestContext = new MockRequestContext();
//		validationContext = new DefaultValidationContext(requestContext, "continue", new DefaultMappingResults(null, null, null));
//		model = new WebSecurityModel();
//		assertTrue(countRowsInTable("staff") == 7);
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		requestContext = null;
//		validationContext = null;
//	}
//
//	@Test
//	public void validateUsernameGood() {
//		model.setUsername("userguy1");
//		boolean success = validator.validateEnterUsername(model, validationContext);
//		assertTrue(success);
//	}
//
//	@Test
//	public void validateUsernameGoodCase() {
//		model.setUsername("USeRgUY1");
//		boolean success = validator.validateEnterUsername(model, validationContext);
//		assertTrue(success);
//	}
//
//	@Test
//	public void validateUsernameEmpty() {
//		model.setUsername("");
//		boolean success = validator.validateEnterUsername(model, validationContext);
//		assertFalse(success);
//	}
//
//	@Test
//	public void validateUsernameBad() {
//		model.setUsername("no_exists_username");
//		boolean success = validator.validateEnterUsername(model, validationContext);
//		assertFalse(success);
//	}
//
//	@Test
//	@ExpectedException(InactiveStaffException.class)
//	public void validateInactiveStaff() {
//		model.setUsername("emacsuser");
//		boolean success = validator.validateEnterUsername(model, validationContext);
//		fail("should have thrown InactiveStaffException");
//	}
//
//	@Test
//	@ExpectedException(InactiveStaffException.class)
//	public void validateInactiveStaffCase() {
//		model.setUsername("EMacSUseR");
//		boolean success = validator.validateEnterUsername(model, validationContext);
//		fail("should have thrown InactiveStaffException");
//	}
// }
