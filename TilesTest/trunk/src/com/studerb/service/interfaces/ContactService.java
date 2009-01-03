package com.studerb.service.interfaces;

import java.util.Map;

import com.studerb.web.contact.ContactModel;

public interface ContactService {
	Map<String, String> getRecipientEmails();

	String sendContactEmail(ContactModel contactModel) throws Exception;
}
