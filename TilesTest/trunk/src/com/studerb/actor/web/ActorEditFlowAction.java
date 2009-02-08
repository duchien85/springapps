package com.studerb.actor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.webflow.action.MultiAction;

import com.studerb.login.LoginService;

@Component("actorEditFlowAction")
public class ActorEditFlowAction extends MultiAction {

	@Autowired
	protected LoginService actorService;
}
