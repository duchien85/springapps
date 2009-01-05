package com.studerb.service;

import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.studerb.service.interfaces.ContactService;
import com.studerb.web.contact.ContactModel;

@Service("contactusService")
public class ContactServiceImp implements ContactService {
	private static final Logger logger = Logger.getLogger(ContactServiceImp.class);

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendContactEmail(ContactModel contactModel) throws Exception {
		// logger.debug("Sending email with contactModel: " + contactModel);

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setTo(contactModel.getRecipientEmail());
		helper.setText(contactModel.getMessage());
		helper.setSubject(contactModel.getSubject());
		helper.setFrom(contactModel.getSenderEmail());

		for (MultipartFile f : contactModel.getAttachments()) {
			if (f != null && !f.isEmpty()) {
				logger.debug("Adding attachement: " + f.getName());
				ByteArrayDataSource ds0 = new ByteArrayDataSource(f.getBytes(), f.getContentType());
				helper.addAttachment(f.getName(), ds0);
			}
		}

		mailSender.send(mimeMessage);
	}
}
