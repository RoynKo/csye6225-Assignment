package com.csye6225.spring2019.courseservice.service;

import java.util.ArrayList;
import java.util.List;

import com.csye6225.spring2019.courseservice.InMemoryDatabase;
import com.csye6225.spring2019.courseservice.model.CourseModel;

public class CourseService {
    public List<CourseModel> getAll() {
        return new ArrayList<>(InMemoryDatabase.courses.values());
    }
    
    public CourseModel get(String courseId) {
        return InMemoryDatabase.courses.get(courseId);
    }

    public CourseModel delete(String courseId) {
        return InMemoryDatabase.courses.remove(courseId);
    }

    public CourseModel add(CourseModel courseModel) {
        return InMemoryDatabase.courses.put(courseModel.getCourseId(), courseModel);
    }

    public CourseModel update(String courseId, CourseModel courseModel) {
        return InMemoryDatabase.courses.put(courseId, courseModel);
    }
}