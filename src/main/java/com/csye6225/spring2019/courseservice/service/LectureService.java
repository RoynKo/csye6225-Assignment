package com.csye6225.spring2019.courseservice.service;

import com.csye6225.spring2019.courseservice.InMemoryDatabase;
import com.csye6225.spring2019.courseservice.model.LectureModel;

import java.util.ArrayList;
import java.util.List;

public class LectureService {
    public List<LectureModel> getAll() {
        return new ArrayList<>(InMemoryDatabase.lectures.values());
    }
    
    public LectureModel get(String lectureId) {
        return InMemoryDatabase.lectures.get(lectureId);
    }

    public LectureModel delete(String lectureId) {
        return InMemoryDatabase.lectures.remove(lectureId);
    }

    public LectureModel add(LectureModel lectureModel) {
        return InMemoryDatabase.lectures.put(lectureModel.getLectureId(), lectureModel);
    }

    public LectureModel update(String lectureId, LectureModel lectureModel) {
        return InMemoryDatabase.lectures.put(lectureId, lectureModel);
    }
}