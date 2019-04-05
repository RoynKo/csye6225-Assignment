package com.csye6225.spring2019.courseservice.model;

import java.util.List;

public class LectureModel {
    private String lectureId;
    private List<String> associatedMaterials;
    private String content;

    public LectureModel() {}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLectureId() {
        return lectureId;
    }

    public void setLectureId(String lectureId) {
        this.lectureId = lectureId;
    }
    
    public List<String> getAssociatedMaterials() {
        return associatedMaterials;
    }

    public void setAssociatedMaterial(List<String> associatedMaterials) {
        this.associatedMaterials = associatedMaterials;
    }
}
