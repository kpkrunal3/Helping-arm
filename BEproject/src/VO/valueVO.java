package VO;

import java.io.Serializable;

public class valueVO implements Serializable{
	private String lati;
	private int valueid;
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
	public int getValueid() {
		return valueid;
	}
	public void setValueid(int valueid) {
		this.valueid = valueid;
	}
}
