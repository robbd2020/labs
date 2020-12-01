package org.resources;

import org.dao.IDaoDB;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

public abstract class GenericResource<E> {

    protected IDaoDB<E> dao;

    @GET
    public List<E> getAll() {
        return dao.getAllWithNamedQuery();
    }

    @Path("{id}")
    @GET
    public Response getById(@PathParam("id") Long id) {
        return Response
                .ok()
                .entity(dao.getById(id))
                .build();
    }

    @POST
    public E post(E entity) {
        dao.insert(entity);
        return entity;
    }

    @Path("{id}")
    @DELETE
    public void delete(@PathParam("id") Long id) {
        dao.removeById(id);
    }

    @Path("{id}")
    @PUT
    public void update(@PathParam("id") Long id, E entity) {
        dao.updateById(id, entity);
    }
}

