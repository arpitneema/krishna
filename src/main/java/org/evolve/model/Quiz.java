package org.evolve.model;

public class Quiz {

	public Question questions[];
	public Devotee quizUser;
	public String result;
	public Quiz(Question questions[],Devotee user) {
		this.questions=questions;
		quizUser=user;
	}
	
	public Question[] getQuestions() {
		return questions;
	}
	public void setQuestions(Question[] questions) {
		this.questions = questions;
	}
	public Devotee getQuizUser() {
		return quizUser;
	}
	public void setQuizUser(Devotee quizUser) {
		this.quizUser = quizUser;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
