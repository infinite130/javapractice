package com.ohgiraffers.model.dto;

public class MemberDTO implements java.io.Serializable{
	
	private String type;
	private String firstName;
	private String lastName;
	private int age;
	
	
	public MemberDTO() {
		super();
	}


	public MemberDTO(String type, String firstName, String lastName, int age) {
		super();
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "{ \"type\": " + "\"" + type + "\""
				+ ", \"firstName\": " + "\"" + firstName + "\"" 
				+ ", \"lastName\": " + "\"" + lastName + "\""
				+ ", \"age\": " + age 
				+ " }";
	}
	
	
	
	
	

}
