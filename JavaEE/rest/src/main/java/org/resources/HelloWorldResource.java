package org.resources;

import javax.ejb.PostActivate;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Path("/helloworld")
public class HelloWorldResource {

    @GET
    public Response helloworld(@QueryParam("name") String n, @QueryParam("age") int age) {
        String text = n!=null ? n : "world";
        String message = age!=0 ? age<34? "Jonge god!" : "Ouwe bok!": "";
        return Response
                .ok() // header: 200 OK
                .entity(String.format("Hello %s!\n%s", text, message)) // content
                .build();
    }

//    @POST
//    public Response post(String requestBody, @Context UriInfo uriInfo){
//        String body = requestBody !=null? requestBody : "";
//        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path("yagshemash");
//        return Response
//                .created(uriBuilder.build())
//                .entity("Wawawiewaaaaa " + body)
//                .build();
//    }
}
