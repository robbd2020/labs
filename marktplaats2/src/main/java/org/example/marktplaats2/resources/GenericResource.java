package org.example.marktplaats2.resources;

import org.example.marktplaats2.dao.IDaoDB;

import javax.ws.rs.*;
import java.util.List;

public abstract class GenericResource<E> implements JsonResource {

    protected IDaoDB<E> dao;

    @GET
    public List<E> getAll() {
        return dao.getAllWithNamedQuery();
    }

    @Path("{id}")
    @GET
    public E getById(@PathParam("id") Long id) {
        return dao.getById(id);
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

