package com.avilyne.rest.model;
 
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Person1 {
 
   
     
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
   
    public Person1() {
         
        id = -1;
        lati = "";
        longi = "";   
    }
 
	public Person1(long id, String lati, String longi) {
 
        this.id = id;
        this.lati = lati;
        this.longi = longi;
        
    }
    private long id;
	private String lati;
    private String longi;
	public String getLati() {
		return lati;
	}
	public void setLati(String lati) {
		this.lati = lati;
	}
	public String getLongi() {
		return longi;
	}
	public void setLongi(String longi) {
		this.longi = longi;
	}
   
   
   
         
}