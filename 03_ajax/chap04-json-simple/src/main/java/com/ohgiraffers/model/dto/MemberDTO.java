package com.ohgiraffers.model.dto;

public class MemberDTO implements java.io.Serializable {
	
	private String name;
	private String mbti;
	private String city;
	private int age;
	
	public MemberDTO() {
		super();
	}

	public MemberDTO(String name, String mbti, String city, int age) {
		super();
		this.name = name;
		this.mbti = mbti;
		this.city = city;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMbti() {
		return mbti;
	}

	public void setMbti(String mbti) {
		this.mbti = mbti;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "MemberDTO [name=" + name + ", mbti=" + mbti + ", city=" + city + ", age=" + age + "]";
	}
	
	

}
