package com.studerb.actor.web;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Component;

import com.studerb.actor.ActorService;

@Component
public class ActorModelValidator {
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	ActorService actorService;

	public boolean validateEditMain(ActorModel model, ValidationContext context) {
		MessageContext msgContext = context.getMessageContext();

		if (msgContext.hasErrorMessages()) {
			return false;
		}

		if (StringUtils.isBlank(model.getFirstName())) {
			msgContext.addMessage(new MessageBuilder().error().source("firstName").code("username.required").build());
			return false;
		}

		if (StringUtils.isBlank(model.getLastName())) {
			msgContext.addMessage(new MessageBuilder().error().source("lastName").code("username.required").build());
			return false;
		}

		return true;
	}

	public boolean validateAddMain(ActorModel model, ValidationContext context) {
		MessageContext msgContext = context.getMessageContext();

		if (msgContext.hasErrorMessages()) {
			return false;
		}

		if (StringUtils.isBlank(model.getFirstName())) {
			msgContext.addMessage(new MessageBuilder().error().source("firstName").code("username.required").build());
			return false;
		}

		if (StringUtils.isBlank(model.getLastName())) {
			msgContext.addMessage(new MessageBuilder().error().source("lastName").code("username.required").build());
			return false;
		}

		return true;
	}
}
