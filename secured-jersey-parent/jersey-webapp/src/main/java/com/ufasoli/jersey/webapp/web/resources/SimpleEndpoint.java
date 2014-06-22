package com.ufasoli.jersey.webapp.web.resources;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * User: Ulises Fasoli
 * Date: 01.05.2014
 * Time: 14:49
 * Project : secure-jersey-parent
 */
@Path("/se")
public class SimpleEndpoint {

    @Path("hello")
    public Response sayHello(){

        return Response.ok("{'msg' : 'Hello World'}").build();
    }
}
