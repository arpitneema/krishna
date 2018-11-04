package org.evolve.model;

public class Devotee {
	int id;
	
	String name;
	int age;
	String email;
	String phone;
	String sessionId;		
	String city;
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Devotee()
	{
		super();
	}
	public Devotee(int id,String name, int age, String email, String phone,String sessionid,String city) {
		super();
		this.id=id;
		
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.sessionId=sessionid;
		this.city=city;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
