package com.mnater.learningspringboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {
	private final UUID uuid;
	private final String firstName;
	private final String lastName;
	private final int age;
	private final String email;
	private final Gender gender;
	
	public User(
			@JsonProperty("uuid") UUID uuid,
			@JsonProperty("firstName")String firstName,
			@JsonProperty("lastName")String lastName,
			@JsonProperty("age")int age,
			@JsonProperty("email")String email,
			@JsonProperty("gender")Gender gender) {
		this.uuid = uuid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.gender = gender;
	}
	
	public UUID getUuid() {
		return uuid;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Gender getGender() {
	    return gender;
	}
	
	public enum Gender{
		Female,
	    Male
	}
	
	@Override
	public String toString() {
		return "User[" +
				"uuid: " + uuid +
				", firstName: '" + firstName + '\'' +
				", lastName: '" + lastName + '\'' +
				", age: " + age +
				", email: '" + email + '\'' +
				']';
	}
}
