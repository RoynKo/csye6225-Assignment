package com.csye6225.spring2019.courseservice.service;

import com.csye6225.spring2019.courseservice.InMemoryDatabase;
import com.csye6225.spring2019.courseservice.model.ProfessorModel;
import java.util.ArrayList;
import java.util.List;

public class ProfessorService {
    public List<ProfessorModel> getAll() {
        return new ArrayList<>(InMemoryDatabase.professors.values());
    }

    public ProfessorModel get(String profId) {
        return InMemoryDatabase.professors.get(profId);
    }

    public ProfessorModel delete(String profId) {
        return InMemoryDatabase.professors.remove(profId);
    }

    public ProfessorModel add(ProfessorModel professorModel) {
        return InMemoryDatabase.professors.put(professorModel.getProfessorId(), professorModel);
    }

    public ProfessorModel update(String profId, ProfessorModel professor) {
        return InMemoryDatabase.professors.put(profId, professor);
    }
}