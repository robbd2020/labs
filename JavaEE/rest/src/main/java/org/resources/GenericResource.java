package org.resources;

import org.domain.IDaoDB;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public abstract class GenericResource<E> {

    protected IDaoDB<E> dao;

    @GET
    public Response getAll(){
        return Response
                .ok()
                .entity(dao.getAllWithNamedQuery())
                .build();
    }

    @Path("{id}")
    @GET
    public Response getById(@PathParam("id") Long id){
        return Response
                .ok()
                .entity(dao.getById(id))
                .build();
    }

    @POST
    public E post(E entity){
        dao.insert(entity);
        return entity;
    }

    @Path("{id}")
    @DELETE
    public void delete(@PathParam("id") Long id){
        dao.removeById(id);
    }

    @Path("{id}")
    @PUT
    public void update(@PathParam("id") Long id, E entity){
        dao.updateById(id, entity);
    }
}
