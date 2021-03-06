package com.csye6225.spring2019.courseservice.resource;

import com.csye6225.spring2019.courseservice.model.CourseModel;
import com.csye6225.spring2019.courseservice.service.CourseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("course")
public class CourseResource {
    CourseService cs = new CourseService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CourseModel> getAll() {
        return cs.getAll();
    }

    @GET
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public CourseModel get(@PathParam("courseId") String courseId) {
        return cs.get(courseId);
    }

    @DELETE
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public CourseModel delete(@PathParam("courseId") String courseId) {
        return cs.delete(courseId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CourseModel add(CourseModel course) {
        return cs.add(course);
    }

    @PUT
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CourseModel update(@PathParam("courseId") String courseId, CourseModel course) {
        return cs.update(course);
    }
}
