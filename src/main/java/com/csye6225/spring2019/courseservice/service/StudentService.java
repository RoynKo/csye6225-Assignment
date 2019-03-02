package com.csye6225.spring2019.courseservice.service;

import com.csye6225.spring2019.courseservice.InMemoryDatabase;
import com.csye6225.spring2019.courseservice.model.StudentModel;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    public List<StudentModel> getAll() {
        return new ArrayList<>(InMemoryDatabase.students.values());
    }

    public StudentModel get(String studentId) {
        return InMemoryDatabase.students.get(studentId);
    }

    public StudentModel delete(String studentId) {
        return InMemoryDatabase.students.remove(studentId);
    }

    public StudentModel add(StudentModel student) {
        return InMemoryDatabase.students.put(student.getStudentId(), student);
    }

    public StudentModel update(String studentId, StudentModel student) {
        return InMemoryDatabase.students.put(studentId, student);
    }

}