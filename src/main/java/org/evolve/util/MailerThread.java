package org.evolve.util;

import org.evolve.model.Devotee;
import org.evolve.service.Mailer;

public class MailerThread implements Runnable{
	Devotee newD;
	
	public MailerThread(Devotee d){
		newD=d;
	}
	public void run() {
		try {

			String msg = "Name " + newD.getName() + " age: " + newD.getAge() + " email: "
					+ newD.getEmail() + " contact " + newD.getPhone() + " city " + newD.getCity();

			Mailer.send("evolvetoexcelteam@gmail.com", "Harekrishna108", "radheybhardwaj@gmail.com",
					"New Devotee " + newD.getName() + " registered for " + newD.getSessionId(), msg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
