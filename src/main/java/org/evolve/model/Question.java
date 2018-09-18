package org.evolve.model;

public class Question {

	String id;
	String actualQuestion;
	String option1;
	String option2;
	String option3;
	String option4;
	String correctAnswer;

	public Question(String id, String question, String op1, String op2, String op3, String op4, String correct) {
		this.id=id;
		actualQuestion=question;
		option1=op1;
		option2=op2;
		option3=op3;
		option4=op4;
		correctAnswer=correct;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActualQuestion() {
		return actualQuestion;
	}

	public void setActualQuestion(String actualQuestion) {
		this.actualQuestion = actualQuestion;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

}
