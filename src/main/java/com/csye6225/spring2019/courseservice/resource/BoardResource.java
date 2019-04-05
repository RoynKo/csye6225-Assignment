package com.csye6225.spring2019.courseservice.resource;

import com.csye6225.spring2019.courseservice.model.BoardModel;
import com.csye6225.spring2019.courseservice.service.BoardService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("board")
public class BoardResource {
    BoardService bs = new BoardService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BoardModel> getAll() {
        return bs.getAll();
    }

    @GET
    @Path("/{boardId}")
    @Produces(MediaType.APPLICATION_JSON)
    public BoardModel get(@PathParam("boardId") String boardId) {
        return bs.get(boardId);
    }

    @DELETE
    @Path("/{boardId}")
    @Produces(MediaType.APPLICATION_JSON)
    public BoardModel delete(@PathParam("boardId") String boardId) {
        return bs.delete(boardId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public BoardModel add(BoardModel board) {
        return bs.add(board);
    }

    @PUT
    @Path("/{boardId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public BoardModel update(@PathParam("boardId") String boardId, BoardModel board) {
        return bs.update(board);
    }
}