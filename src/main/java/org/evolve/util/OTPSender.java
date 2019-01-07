package org.evolve.util;

import java.util.Random;

import org.evolve.model.Devotee;
import org.evolve.service.Mailer;

public class OTPSender implements Runnable{
	Devotee newD;
	
	public OTPSender(Devotee d){
		newD=d;
	}
	char[] generateOTP() {
		 // Using numeric values 
        String numbers = "0123456789"; 
  
        // Using random method 
        Random rndm_method = new Random(); 
        int len=5;
        char[] otp = new char[len]; 
  
        for (int i = 0; i < len; i++) 
        { 
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int 
            otp[i] = 
             numbers.charAt(rndm_method.nextInt(numbers.length())); 
        } 
        return otp; 
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
