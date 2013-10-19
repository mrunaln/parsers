package com.example.jsonparser;

public class JsonData{

	String name,  department;
	int id , age;

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




	public String getDepartment() {
		return department;
	}




	public void setDepartment(String department) {
		this.department = department;
	}




	@Override
	public String toString() {
		return "Person - [id=" + id + ", name=" + name + ", age=" + age
				+ ", dept = " + department + "]";
	}

	
	}
