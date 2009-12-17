package com.studerb.security.web;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class WebSecurityModel implements Serializable {
	private static final int MAX_ANSWERS = 3;

	private Long staffId;
	private String username;
	private String questionText;
	private String correctAnswer;
	private String answerText;
	private String password;
	private String confirmPassword;
	private int answerCount = 0;

	public WebSecurityModel() {}

	public String getAnswerText() {
		return answerText;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public String getPassword() {
		return password;
	}

	public String getQuestionText() {
		return questionText;
	}

	public String getUsername() {
		return username;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public int getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}

	public boolean hasFailed() {
		return answerCount >= MAX_ANSWERS;
	}

	public void incrementAnswer() {
		answerCount++;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

}
