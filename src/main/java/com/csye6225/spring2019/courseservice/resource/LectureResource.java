package com.csye6225.spring2019.courseservice.resource;

import com.csye6225.spring2019.courseservice.service.LectureService;
import com.csye6225.spring2019.courseservice.model.LectureModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("lecture")
public class LectureResource {

    LectureService ls = new LectureService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LectureModel> getAll() {
        return ls.getAll();
    }

    @GET
    @Path("/{lectureId}")
    @Produces(MediaType.APPLICATION_JSON)
    public LectureModel get(@PathParam("lectureId") String lectureId) {
        return ls.get(lectureId);
    }

    @DELETE
    @Path("/{lectureId}")
    @Produces(MediaType.APPLICATION_JSON)
    public LectureModel delete(@PathParam("lectureId") String lectureId) {
        return ls.delete(lectureId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public LectureModel add(LectureModel lecture) {
        return ls.add(lecture);
    }

    @PUT
    @Path("/{lectureId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public LectureModel update(@PathParam("lectureId") String lectureId, LectureModel lecture) {
        return ls.update(lectureId, lecture);
    }
}