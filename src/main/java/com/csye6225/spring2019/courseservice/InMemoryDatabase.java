package com.csye6225.spring2019.courseservice;

import com.csye6225.spring2019.courseservice.model.*;
import java.util.HashMap;

public class InMemoryDatabase {
	public static HashMap<String, ProfessorModel> professors = new HashMap<>();
	public static HashMap<String, CourseModel> courses = new HashMap<>();
	public static HashMap<String, LectureModel> lectures = new HashMap<>();
	public static HashMap<String, ProgramModel> programs = new HashMap<>();
	public static HashMap<String, StudentModel> students = new HashMap<>();

}

