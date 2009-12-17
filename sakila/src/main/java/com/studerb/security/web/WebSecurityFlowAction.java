package com.studerb.security.web;

import java.util.ArrayList;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.execution.RequestContext;

import com.google.common.collect.Lists;
import com.studerb.security.LoginService;

@Component("webSecurityFlowAction")
public class WebSecurityFlowAction extends MultiAction {

	@Autowired
	protected LoginService loginService;
	private static final ArrayList<String> questions = Lists.newArrayList("What is your mother's maiden name?", "What is your high school mascot?",
			"What is your favorite color?");

	public void setSecurityData(RequestContext context) {
		WebSecurityModel model = (WebSecurityModel) context.getFlowScope().get("webSecurityModel");
		int random = RandomUtils.nextInt(questions.size());
		model.setQuestionText(questions.get(random));
		model.setCorrectAnswer("correct");
	}

}
