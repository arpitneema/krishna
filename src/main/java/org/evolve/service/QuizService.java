package org.evolve.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.evolve.model.AnswerSheet;
import org.evolve.model.Devotee;
import org.evolve.model.Question;
import org.evolve.model.Quiz;

public class QuizService {
	private static Question[] questions = {
			new Question("1", "Our body is on constant change from childhood, then who we really are?",
					"Our Nationality.", "Our Mind.", "Soul.", "Nothing.", "Soul"),
			new Question("2", "Spirituality is for____", "Cowards.", "Lazy bums.", "Only those who are interested.",
					"Everyone","Everyone")

	};
	private static final int MARKS_PER_QUESTION=10;
	private static HashMap<String,String> answerSet=new HashMap<String,String>();
	public QuizService() {
		answerSet.put("1","3");
		answerSet.put("2","4");		
	}
	
	public int evaluateAnswers(AnswerSheet answersheet){
		int marksObtained=0;
		for (Map.Entry<String, String> answerEntry : answersheet.answers.entrySet()) {
			
			if (answerSet.get(answerEntry.getKey()).equals(answerEntry.getValue())){
				marksObtained=MARKS_PER_QUESTION+marksObtained;
			}
			System.out.println(answerEntry.getKey() + " = " + answerEntry.getValue());
		}
		return marksObtained;
	}
	
	
	public static Quiz createQuiz(Devotee user) {
		Quiz newquiz=new Quiz(questions,user);
		// randomize the questions
		return newquiz;
	}

}
