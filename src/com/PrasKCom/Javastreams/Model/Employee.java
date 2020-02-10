package com.PrasKCom.Javastreams.Model;

public class Employee {
	
	private String name;
	private Integer id;
	private String designation;
	
	public Employee() {
		
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", designation=" + designation + "]";
	}

	public Employee(String name, Integer id, String designation) {
		super();
		this.name = name;
		this.id = id;
		this.designation = designation;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	

}
