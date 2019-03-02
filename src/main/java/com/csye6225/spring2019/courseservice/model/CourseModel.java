package com.csye6225.spring2019.courseservice.model;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CourseModel {
	private String courseId;
    private String title;
    private List<LectureModel> lectures;
    private String board;
    private StudentModel roster;
    private StudentModel ta;
    private ProfessorModel professor;
    private List<StudentModel> students;

    public CourseModel() {}

    public List<LectureModel> getLectures() {
        return lectures;
    }

    public void setLectures(List<LectureModel> lectures) {
        this.lectures = lectures;
    }
    
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public StudentModel getRoster() {
        return roster;
    }

    public void setRoster(StudentModel roster) {
        this.roster = roster;
    }

    public List<StudentModel> getStudents() {
        return students;
    }

    public void setStudents(List<StudentModel> students) {
        this.students = students;
    }

    public ProfessorModel getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorModel professor) {
        this.professor = professor;
    }

    public StudentModel getTa() {
        return ta;
    }

    public void setTa(StudentModel ta) {
        this.ta = ta;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}