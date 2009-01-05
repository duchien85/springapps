package com.studerb.service.interfaces;

import com.studerb.web.contact.ContactModel;

public interface ContactService {

	void sendContactEmail(ContactModel contactModel) throws Exception;
}
