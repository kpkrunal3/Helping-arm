package com.avilyne.rest.resource;
 
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Request;
 
import com.avilyne.rest.model.Person;


import DAO.CitizenDAO;
import VO.CitizenVO;
 
@Path("/person")
public class PersonResource {private final static String FIRST_NAME = "firstName";
private final static String LAST_NAME = "lastName";
private final static String EMAIL = "email";
private final static String password = "password";
private final static String mobileNumber = "mobileNumber";



private Person person = new Person(1, "Sample", "Person", "sample_person@jerseyrest.com","1121","7545454");

 
// The @Context annotation allows us to have certain contextual objects
// injected into this class.
// UriInfo object allows us to get URI information (no kidding).
@Context
UriInfo uriInfo;
// Another "injected" object. This allows us to use the information that's
// part of any incoming request.
// We could, for example, get header information, or the requestor's address.

@Context
Request request;
// Basic "is the service running" test
@GET@Produces(MediaType.TEXT_PLAIN)
public String respondAsReady() {
    return "Ready to use Service Krunal....!";
}
@GET
@Path("/sample")
@Produces(MediaType.APPLICATION_JSON)
public Person getSamplePerson() {
     
    System.out.println("Returning sample person: " + person.getFirstName() + " " + person.getLastName());
     
    return person;
}
     
// Use data from the client source to create a new Person object, returned in JSON format.  
@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.APPLICATION_JSON)
public Person postPerson(
        MultivaluedMap<String, String> personParams
        ) {
		System.out.println("asd");
		String firstName = personParams.getFirst(FIRST_NAME);
        String lastName = personParams.getFirst(LAST_NAME);
        String email = personParams.getFirst(EMAIL);
        String Password = personParams.getFirst(password);
        String MobileNumber = personParams.getFirst(mobileNumber);
       
        
        CitizenVO citizenVO=new CitizenVO();
        citizenVO.setFirstName(firstName);
        citizenVO.setLastName(lastName);
        citizenVO.setEmail(email);
        citizenVO.setPassword(Password);
        citizenVO.setMobileNumber(MobileNumber);
        CitizenDAO citizenDAO=new CitizenDAO();
        citizenDAO.insert(citizenVO);
        System.out.println("Storing posted " + firstName + " " + lastName + "  " + email+ "  " + Password+ "  " + MobileNumber);
       
         
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setEmail(email);
        person.setPassword(Password);
        person.setMobileNumber(MobileNumber);
         
        System.out.println("person info: " + person.getFirstName() + " " + person.getLastName() + " " + person.getEmail()+ " " + person.getPassword()+ " " + person.getMobileNumber());
         
        return person;
                         
    }
}