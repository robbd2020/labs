package org.resources;

import org.domain.Contact;
import org.domain.ContactDaoDB;
import org.domain.IDaoDB;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("/contacts")
@Produces(MediaType.APPLICATION_JSON) // Always send JSON
public class ContactsResource extends GenericResource<Contact> {

    @Inject
    public void setDao(ContactDaoDB dao){
        super.dao = dao;
    }

}
