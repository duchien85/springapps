package com.studerb.service;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import com.studerb.service.interfaces.ContactService;
import com.studerb.web.contact.ContactModel;

@Service("contactusService")
public class ContactServiceImp implements ContactService {
	private static final Logger logger = Logger.getLogger(ContactServiceImp.class);

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public Map<String, String> getRecipientEmails() {
		Map emails = new LinkedHashMap<String, String>();
		emails.put("studerb@fastmail.fm" /* "eiligibilityteam@ARAGgroup.com" */, "Member Enrollment Support");
		emails.put("stbill79@sent.com", "Benefit Fair");
		emails.put("stbill79@gmail.com" /* clientServices.@AragGroup.com" */, "Client Services");
		emails.put("bill.studer@araggroup.com", "Plan Administration");

		return emails;
	}

	@Override
	public String sendContactEmail(ContactModel contactModel) throws Exception {
		String resultMessage = "TEST ---- Email successfully sent ---- TEST";
		logger.debug("Sending email with contactModel: " + contactModel);
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setTo(contactModel.getRecipientEmail());
		helper.setText(contactModel.getMessage());
		helper.setSubject(contactModel.getSubject());
		logger.debug("Sending message from: bill.studer@araggroup.com");
		helper.setFrom("bill.studer@araggroup.com");

		/*MultipartFile f0 = contactModel.getAttachment0();
		if (f0 != null && !f0.isEmpty()) {
			logger.debug("Adding attachement0: " + f0.getOriginalFilename());
			DataSource ds = new DataS
			
			ByteArrayDataSource ds0 = new ByteArrayDataSource(f0.getBytes(),
			helper.addAttachment(f0.getOriginalFilename(), ds0);
		}

		MultipartFile f1 = contactModel.getAttachment1();
		if (f1 != null && !f1.isEmpty()) {
			logger.debug("Adding attachement1: " + f0.getOriginalFilename());
			ByteArrayDataSource ds1 = new ByteArrayDataSource(f1.getBytes(), f1.getContentType());
			helper.addAttachment(f1.getOriginalFilename(), ds1);
		}

		MultipartFile f2 = contactModel.getAttachment2();
		if (f2 != null && !f2.isEmpty()) {
			ByteArrayDataSource ds2 = new ByteArrayDataSource(f2.getBytes(), f2.getContentType());
			helper.addAttachment(f2.getOriginalFilename(), ds2);
		}
		*/

		mailSender.send(mimeMessage);
		return resultMessage;
	}
}

