package com.akadatsky;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Hello {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String textHello() {
        return "Hello admin";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String jsonHello() {
        return "{\"result\" : \"Hello admin\"}";
    }


    @GET
    @Produces(MediaType.TEXT_XML)
    public String xmlHello() {
        return "<?xml version=\"1.0\"?>" + "<hello> Hello admin" + "</hello>";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String htmlHello() {
        return "<html> " + "<title>" + "Hello admin" + "</title>"
                + "<body><h1>" + "Hello admin" + "</body></h1>" + "</html> ";
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String add(
            @FormParam("name") String name,
            @FormParam("age") int age) {

        if ("admin".equals(name)) {
            return "{\"result\" : \"Name is ok\"}";
        } else {
            return "{\"result\" : \"Name is NOT ok\"}";
        }

    }

    @POST
    @Path("/json/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addJson(String msg) {
        return msg;
    }


}