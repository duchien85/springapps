package com.studerb.login.web;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Component;

import com.studerb.login.InactiveStaffException;
import com.studerb.login.LoginService;
import com.studerb.model.Staff;

@Component
public class WebSecurityModelValidator {
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	LoginService loginService;

	public boolean validateEnterUsername(WebSecurityModel model, ValidationContext context) {
		String username = model.getUsername();
		MessageContext msgContext = context.getMessageContext();

		if (msgContext.hasErrorMessages()) {
			return false;
		}

		if (StringUtils.isBlank(username)) {
			msgContext.addMessage(new MessageBuilder().error().source("username").code("username.required").build());
			return false;
		}

		Staff staff = loginService.findStaffByUsername(username);
		if (staff == null) {
			msgContext.addMessage(new MessageBuilder().error().source("username").code("username.invalid").build());
			return false;
		}

		if (!staff.isActive()) {
			throw new InactiveStaffException("Staff memeber: " + username + " inactive");
		}

		return true;
	}

	public boolean validateEnterStaffId(WebSecurityModel model, ValidationContext context) {
		String username = model.getUsername();
		MessageContext msgContext = context.getMessageContext();

		if (msgContext.hasErrorMessages()) {
			return false;
		}

		Staff staff = loginService.findStaffById(model.getStaffId());
		if (staff == null) {
			msgContext.addMessage(new MessageBuilder().error().source("staffId").code("staffId.invalid").build());
			return false;
		}

		if (!staff.isActive()) {
			throw new InactiveStaffException("Staff memeber: " + username + " inactive");
		}

		model.setUsername(staff.getUsername());
		return true;
	}

	public boolean validateSecurityQuestion(WebSecurityModel model, ValidationContext context) {

		MessageContext msgContext = context.getMessageContext();

		if (msgContext.hasErrorMessages()) {
			return false;
		}

		if (StringUtils.isBlank(model.getAnswerText())) {
			msgContext.addMessage(new MessageBuilder().error().source("answerText").code("answerText.required").build());
			return false;
		}

		return checkAnswer(model, msgContext);
	}

	public boolean validateNewPassword(WebSecurityModel model, ValidationContext context) {
		MessageContext msgContext = context.getMessageContext();
		if (msgContext.hasErrorMessages()) {
			return false;
		}

		String password = model.getPassword();
		String confirmPassword = model.getConfirmPassword();

		if (StringUtils.isBlank(password)) {
			msgContext.addMessage(new MessageBuilder().error().source("password").code("password.required").build());
			return false;
		}
		else if (StringUtils.isBlank(confirmPassword)) {
			msgContext.addMessage(new MessageBuilder().error().source("confirmPassword").code("confirmPassword.required").build());
			return false;
		}
		else if (!password.equalsIgnoreCase(confirmPassword)) {
			msgContext.addMessage(new MessageBuilder().error().code("passwords.mismatch").build());
			return false;
		}

		return true;
	}

	private boolean checkAnswer(WebSecurityModel model, MessageContext msgContext) {
		model.incrementAnswer();
		if (model.getAnswerText().equalsIgnoreCase(model.getCorrectAnswer())) {
			return true;
		}
		else {
			if (model.hasFailed()) {
				loginService.inactivateStaff(model.getUsername());
				throw new InactiveStaffException("Inactivated user: " + model.getUsername() + " after failing security questions");
			}
			msgContext.addMessage(new MessageBuilder().error().source("answerText").code("answerText.incorrect").build());
			return false;
		}
	}

}
