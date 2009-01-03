package com.studerb.web.contact;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.web.multipart.MultipartFile;

public class ContactModel {
	public static final int MESSAGE_MAX_LENGTH = 10000;
	public static final int ATTACHMENT_MAX_LENGTH = 10000;
	public static final int NUM_OF_ATTACHMENTS = 3;

	private MultipartFile attachment0;
	private MultipartFile attachment1;
	private MultipartFile attachment2;

	private String subject;
	private String recipientEmail;
	private String senderEmail;

	private String message;

	public MultipartFile getAttachment0() {
		return attachment0;
	}

	public MultipartFile getAttachment1() {
		return attachment1;
	}

	public MultipartFile getAttachment2() {
		return attachment2;
	}

	public String getMessage() {
		return message;
	}

	public String getRecipientEmail() {
		return recipientEmail;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setAttachment0(MultipartFile attachment0) {
		this.attachment0 = attachment0;
	}

	public void setAttachment1(MultipartFile attachment1) {
		this.attachment1 = attachment1;
	}

	public void setAttachment2(MultipartFile attachment2) {
		this.attachment2 = attachment2;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append(SystemUtils.LINE_SEPARATOR);
		out.append("toContact: " + recipientEmail + SystemUtils.LINE_SEPARATOR);
		out.append("message: " + message + SystemUtils.LINE_SEPARATOR);
		out.append("Subject: " + subject + SystemUtils.LINE_SEPARATOR);
		out.append("senderEmail: " + senderEmail + SystemUtils.LINE_SEPARATOR);
		try {

			if (attachment0 == null) {
				out.append("attachment0: " + attachment0 + SystemUtils.LINE_SEPARATOR);
			}
			else {
				out.append("attachment0 (name / size / text: " + attachment0.getOriginalFilename() + " / " + attachment0.getSize() + " / " + new String(attachment0.getBytes())
						+ SystemUtils.LINE_SEPARATOR);
			}

			if (attachment1 == null) {
				out.append("attachment1: " + attachment1 + SystemUtils.LINE_SEPARATOR);
			}
			else {
				out.append("attachment1 (name / size / text: " + attachment1.getOriginalFilename() + " / " + attachment1.getSize() + " / " + new String(attachment1.getBytes())
						+ SystemUtils.LINE_SEPARATOR);
			}

			if (attachment2 == null) {
				out.append("attachment2: " + attachment0 + SystemUtils.LINE_SEPARATOR);
			}
			else {
				out.append("attachment2 (name / size / text: " + attachment2.getOriginalFilename() + " / " + attachment2.getSize() + " / " + new String(attachment2.getBytes())
						+ SystemUtils.LINE_SEPARATOR);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			ExceptionUtils.getRootCauseMessage(e);
		}

		return out.toString();
	}
}
