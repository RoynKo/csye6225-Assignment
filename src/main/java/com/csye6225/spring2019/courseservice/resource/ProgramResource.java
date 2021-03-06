package com.csye6225.spring2019.courseservice.resource;

import com.csye6225.spring2019.courseservice.model.ProgramModel;
import com.csye6225.spring2019.courseservice.service.ProgramService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("program")
public class ProgramResource {

    ProgramService ps = new ProgramService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProgramModel> getAll() {
        return ps.getAll();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProgramModel get(@PathParam("name") String name) {
        return ps.get(name);
    }

    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProgramModel delete(@PathParam("name") String name) {
        return ps.delete(name);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProgramModel add(ProgramModel program) {
        return ps.add(program);
    }

    @PUT
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProgramModel update(@PathParam("name") String name, ProgramModel program) {
        return ps.update(name, program);
    }
}