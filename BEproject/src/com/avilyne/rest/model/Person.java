package com.avilyne.rest.model;
 
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Person {
 
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
     
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
     
    public Person() {
         
        id = -1;
        firstName = "";
        lastName = "";
        email = "";
        password = "";
        mobileNumber = "";
       
      
         
    }
 
	public Person(long id, String firstName, String lastName, String email, String password, String mobileNumber) {
 
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
      
    }
    private long id;
	private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String mobileNumber;        
}