package com.csye6225.spring2019.courseservice.service;

import com.csye6225.spring2019.courseservice.InMemoryDatabase;
import com.csye6225.spring2019.courseservice.model.ProgramModel;


import java.util.ArrayList;
import java.util.List;

public class ProgramService {

    public List<ProgramModel> getAll() {
        List<ProgramModel> result = new ArrayList<>();
        result.addAll(InMemoryDatabase.programs.values());
        return result;
    }

    public ProgramModel get(String name) {
        return InMemoryDatabase.programs.get(name);
    }

    public ProgramModel delete(String name) {
        return InMemoryDatabase.programs.remove(name);
    }

    public ProgramModel add(ProgramModel program) {
        return InMemoryDatabase.programs.put(program.getName(), program);
    }

    public ProgramModel update(String name, ProgramModel program) {
        return InMemoryDatabase.programs.put(name, program);
    }

}