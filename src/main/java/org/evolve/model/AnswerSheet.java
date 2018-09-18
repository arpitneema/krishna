package org.evolve.model;

import java.util.HashMap;

public class AnswerSheet {

	public Devotee user;
	public HashMap<String,String> answers=new HashMap<String,String>();
	
	public AnswerSheet(HashMap answers, Devotee user) {
		this.answers=answers;
		this.user=user;
	}
}
