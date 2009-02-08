package com.studerb.actor.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Component;

import com.studerb.actor.ActorService;

@Component
public class ActorModelValidator {
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	ActorService actorService;

	public boolean validateSomething(ActorModel model, ValidationContext context) {
		MessageContext msgContext = context.getMessageContext();

		if (msgContext.hasErrorMessages()) {
			return false;
		}

		return true;
	}
}
