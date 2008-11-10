package com.studerb.web.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Captures flashScope attribute from Controllers and puts it in the session for
 * reuse at the next request. Typical usecase: Controller1 returns new
 * ModelAndView("redirect:controller2", "flashScope.error", "message.error") in
 * Controller2's view, you can use ${flashScope.error}
 */
public class FlashScopeInterceptor implements HandlerInterceptor {
	public static final String DEFAULT_ATTRIBUTE_NAME = "flashScope";
	public static final String DEFAULT_SESSION_ATTRIBUTE_NAME = FlashScopeInterceptor.class.getName();
	public static final int DEFAULT_RETENTION_COUNT = 2;

	private final String sessionAttributeName = DEFAULT_SESSION_ATTRIBUTE_NAME;
	private final String attributeName = DEFAULT_ATTRIBUTE_NAME;
	private final int retentionCount = DEFAULT_RETENTION_COUNT;

	public FlashScopeInterceptor() {}

	/**
	 * Unbinds current flashScope from session. Rolls request's flashScope to
	 * the next scope. Binds request's flashScope, if not empty, to the session.
	 * 
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		if (request.getSession(false) != null) {
			request.getSession().removeAttribute(this.sessionAttributeName);
		}
		Object requestAttribute = request.getAttribute(this.attributeName);
		if (requestAttribute instanceof MultiScopeModelMap) {
			MultiScopeModelMap attributes = (MultiScopeModelMap) requestAttribute;
			if (!attributes.isEmpty()) {
				attributes.next();
				if (!attributes.isEmpty()) {
					request.getSession(true).setAttribute(this.sessionAttributeName, attributes);
				}
			}
		}
	}

	/**
	 * merge modelAndView.model['flashScope'] to current flashScope
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
		if (modelAndView != null) {
			Map<String, Object> modelFlashScopeMap = null;
			for (Iterator<Entry<String, Object>> iterator = ((Map<String, Object>) modelAndView.getModel()).entrySet().iterator(); iterator.hasNext();) {
				Entry<String, Object> entry = iterator.next();
				if (this.attributeName.equals(entry.getKey()) && entry.getValue() instanceof Map) {
					if (modelFlashScopeMap == null) {
						modelFlashScopeMap = (Map) entry.getValue();
					}
					else {
						modelFlashScopeMap.putAll((Map) entry.getValue());
					}
					iterator.remove();
				}
				else if (entry.getKey().startsWith(this.attributeName + ".")) {
					String key = entry.getKey().substring(this.attributeName.length() + 1);
					if (modelFlashScopeMap == null) {
						modelFlashScopeMap = new HashMap<String, Object>();
					}
					modelFlashScopeMap.put(key, entry.getValue());
					iterator.remove();
				}
			}
			if (modelFlashScopeMap != null) {
				MultiScopeModelMap flashScopeMap;
				if (request.getAttribute(this.attributeName) instanceof MultiScopeModelMap) {
					flashScopeMap = (MultiScopeModelMap) request.getAttribute(this.attributeName);
				}
				else {
					flashScopeMap = new MultiScopeModelMap(this.retentionCount);
				}
				flashScopeMap.putAll(modelFlashScopeMap);
				request.setAttribute(this.attributeName, flashScopeMap);
			}
		}
	}

	/**
	 * binds session flashScope to current session, if not empty. Otherwise
	 * cleans up empty flashScope
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			Object sessionAttribute = session.getAttribute(this.sessionAttributeName);
			if (sessionAttribute instanceof MultiScopeModelMap) {
				MultiScopeModelMap flashScope = (MultiScopeModelMap) sessionAttribute;
				if (flashScope.isEmpty()) {
					session.removeAttribute(this.sessionAttributeName);
				}
				else {
					request.setAttribute(this.attributeName, flashScope);
				}
			}
		}
		return true;
	}

}
