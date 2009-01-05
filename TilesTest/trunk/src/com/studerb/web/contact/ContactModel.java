package com.studerb.web.contact;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.web.multipart.MultipartFile;

public class ContactModel {
	public static final int MESSAGE_MAX_LENGTH = 10000;

	public static final int ATTACHMENT_MAX_LENGTH = 10000;

	public static final int NUM_OF_ATTACHMENTS = 3;

	public List<MultipartFile> attachments = new ArrayList<MultipartFile>();
	/*
	 * List<MultipartFile> attachments = LazyList.decorate(new
	 * ArrayList<MultipartFile>(), new Factory() {
	 * 
	 * @Override public Object create() { return new Object(); } });
	 */
	private String subject;
	private String recipientEmail;
	private String senderEmail = "studerb@fastmail.fm";
	private String message;
	private final int maxUploads = NUM_OF_ATTACHMENTS;

	public List<MultipartFile> getAttachments() {
		return attachments;
	}

	public int getMaxUploads() {
		return maxUploads;
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

	public void setAttachments(List<MultipartFile> attachments) {
		this.attachments = attachments;
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

		int count = 0;
		try {
			for (MultipartFile f : attachments) {

				if (f == null) {
					out.append("attachment" + count + ": " + SystemUtils.LINE_SEPARATOR);
				}
				else {
					out.append("file:" + SystemUtils.LINE_SEPARATOR);
					out.append("\toriginal Name: " + f.getOriginalFilename() + SystemUtils.LINE_SEPARATOR);
					out.append("\tname: " + f.getName() + SystemUtils.LINE_SEPARATOR);
					out.append("\tSize: " + f.getSize() + SystemUtils.LINE_SEPARATOR);
					out.append("\tContent type: " + f.getContentType() + SystemUtils.LINE_SEPARATOR);
					/*
					 * out.append("\tContent: " + f.getBytes() +
					 * SystemUtils.LINE_SEPARATOR);
					 */
					out.append(SystemUtils.LINE_SEPARATOR);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			ExceptionUtils.getRootCauseMessage(e);
		}

		return out.toString();
	}
}
