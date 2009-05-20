package com.studerb.contact;

import com.studerb.contact.web.ContactModel;


public interface ContactService {

	void sendContactEmail(ContactModel contactModel) throws Exception;
}
