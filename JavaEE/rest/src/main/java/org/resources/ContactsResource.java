package org.resources;

import org.domain.Contact;
import org.domain.ContactDao;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/contacts")
@Produces(MediaType.APPLICATION_JSON) // Always send JSON
public class ContactsResource {

    private static final ContactDao dao = new ContactDao();

    @GET
    public Response getAll(){
        return Response
                .ok()
                .entity(dao.getAll())
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
    public Contact post(Contact contact){
        dao.add(contact);
        return contact;
    }

    @Path("{id}")
    @DELETE
    public void delete(@PathParam("id") Long id){
        dao.remove(id);
    }

    @Path("{id}")
    @PUT
    public void update(@PathParam("id") Long id, Contact contact){
        dao.update(id, contact);
    }

}
