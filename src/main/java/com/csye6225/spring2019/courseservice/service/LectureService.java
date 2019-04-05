package com.csye6225.spring2019.courseservice.service;

import com.csye6225.spring2019.courseservice.model.Database;
import com.csye6225.spring2019.courseservice.model.LectureModel;
import java.util.ArrayList;
import java.util.List;

public class LectureService {
    public List<LectureModel> getAll() {
        return new ArrayList<>(Database.lectures.values());
    }

    public LectureModel get(String lectureId) {
        return Database.lectures.get(lectureId);
    }

    public LectureModel delete(String lectureId) {
        return Database.lectures.remove(lectureId);
    }

    public LectureModel add(LectureModel lectureModel) {
        return Database.lectures.put(lectureModel.getLectureId(), lectureModel);
    }

    public LectureModel update(String lectureId, LectureModel lectureModel) {
        return Database.lectures.put(lectureId, lectureModel);
    }
}