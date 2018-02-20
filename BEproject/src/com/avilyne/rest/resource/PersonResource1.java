
package com.avilyne.rest.resource;
 
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import org.hibernate.Session;

import com.avilyne.rest.model.Person1;
import com.sun.research.ws.wadl.Response;

import DAO.CityDAO;
import DAO.valueDAO;
import VO.valueVO;

import javax.ws.rs.core.Request;


@Path("/person1")
public class PersonResource1 {private final static String lati = "lati";
private final static String longi = "longi";



     
private Person1 person = new Person1(1, "23.45678", "45.25478");

 
// The @Context annotation allows us to have certain contextual objects
// injected into this class.
// UriInfo object allows us to get URI information (no kidding).
@Context
UriInfo uriInfo;
// Another "injected" object. This allows us to use the information that's
// part of any incoming request.
// We could, for example, get header information, or the requestor's address.

@Context
//Request request;
//Response response;
// Basic "is the service running" test
@GET@Produces(MediaType.TEXT_PLAIN)
public String respondAsReady() {
    return "Ready to use Service Krunal....!";
}
@GET
@Path("/sample")
@Produces(MediaType.APPLICATION_JSON)
public Person1 getSamplePerson() {
     
    System.out.println("Returning sample person: " + person.getLati() + " " + person.getLongi());
     
    return person;
}
     
// Use data from the client source to create a new Person object, returned in JSON format.  
@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.APPLICATION_JSON)
public Person1 postPerson(MultivaluedMap<String, String> personParams){

		System.out.println("into gprsssssss");
		
	   String lati1 = personParams.getFirst(lati);
       String longi1 = personParams.getFirst(longi);
		System.out.println("Storing posted " + lati1 + " " + longi1);
        
        
        valueVO vo=new valueVO();
        vo.setLati(lati1);
        vo.setLongi(longi1);
        valueDAO dao=new valueDAO();
        dao.insert(vo);
        return person;    
}
}