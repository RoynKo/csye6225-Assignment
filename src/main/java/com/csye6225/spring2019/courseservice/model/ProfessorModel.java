package com.csye6225.spring2019.courseservice.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProfessorModel {
	private String professorId;
	private String name;
	private String department;

	public ProfessorModel() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getProfessorId() {
		return professorId;
	}
	
	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}
	
	public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
	
	@Override
	public String toString() { 
		return "ProfId=" + getProfessorId() + ", Name=" + getName();
	}
}