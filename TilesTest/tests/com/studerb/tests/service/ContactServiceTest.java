package com.studerb.tests.service;

import static org.junit.Assert.fail;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.studerb.contact.ContactService;
import com.studerb.contact.web.ContactModel;

@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class ContactServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ContactService contactService;

	private ContactModel model;

	@Before
	public void setUp() {
		model = new ContactModel();
		model.setMessage("Test message");
		model.setSubject("Test Subject");
		model.setRecipientEmail("stbill79@gmail.com");
	}

	@After
	public void tearDown() {
		model = null;
	}

	@Test
	public void testSendEmailNoAttachments() {
		try {
			contactService.sendContactEmail(model);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Email failed: " + ExceptionUtils.getRootCauseMessage(e));
		}
	}

	@Test
	public void testSendEmailOneExcelAttachment() {
		try {
			Resource r = applicationContext.getResource("classpath:testAttachments/testExcel.xls");
			MockMultipartFile textMultipartFile = new MockMultipartFile("testExcel.xls", "C:/Documents and Settings/studerb/Desktop/testExcel.xls", "application/vnd.ms-excel",
					r.getInputStream());
			model.getAttachments().add(textMultipartFile);
			contactService.sendContactEmail(model);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Email failed: " + ExceptionUtils.getRootCauseMessage(e));
		}
	}

	@Test
	public void testSendEmailOneTextAttachment() {
		try {
			Resource r = applicationContext.getResource("classpath:testAttachments/testAttachment.txt");
			MockMultipartFile excelMultipartFile = new MockMultipartFile("testAttachment.txt", "C:/Documents and Settings/studerb/Desktop/testAttachment.txt", "text/plain", r
					.getInputStream());
			model.getAttachments().add(excelMultipartFile);
			contactService.sendContactEmail(model);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Email failed: " + ExceptionUtils.getRootCauseMessage(e));
		}
	}
}
