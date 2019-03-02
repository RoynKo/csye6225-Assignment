package com.csye6225.spring2019.courseservice.resource;

import com.csye6225.spring2019.courseservice.model.ProfessorModel;
import com.csye6225.spring2019.courseservice.service.ProfessorService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("professor")
public class ProfessorResource {

    ProfessorService ps = new ProfessorService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProfessorModel> getAll() {
        return ps.getAll();
    }

    @GET
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProfessorModel get(@PathParam("professorId") String profId) {
        return ps.get(profId);
    }

    @DELETE
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProfessorModel delete(@PathParam("professorId") String profId) {
        return ps.delete(profId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProfessorModel add(ProfessorModel professorModel) {
        return ps.add(professorModel);
    }

    @PUT
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProfessorModel update(@PathParam("professorId") String profId, ProfessorModel professorModel) {
        return ps.update(profId, professorModel);
    }
}