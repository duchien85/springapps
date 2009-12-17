package com.studerb.actor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.webflow.action.MultiAction;

import com.studerb.actor.ActorService;

@Component("actorEditFlowAction")
public class ActorEditFlowAction extends MultiAction {

	@Autowired
	protected ActorService actorService;
}
