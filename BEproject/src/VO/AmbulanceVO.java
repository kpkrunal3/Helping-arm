package VO;

import java.io.Serializable;

public class AmbulanceVO implements Serializable{
	private int ambulanceId;
	private String number;
	private String addressLine1;
	private String addressLine2;
	private String latitude;
	private String longitude;
	private String status;
	private String pincode;
	private StateVO stateVO;
	private CityVO cityVO;
	private AreaVO areaVO;
	private StaffVO staffVO1;
	private StaffVO staffVO2;
	
	public int getAmbulanceId() {
		return ambulanceId;
	}
	public void setAmbulanceId(int ambulanceId) {
		this.ambulanceId = ambulanceId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public StateVO getStateVO() {
		return stateVO;
	}
	public void setStateVO(StateVO stateVO) {
		this.stateVO = stateVO;
	}
	public CityVO getCityVO() {
		return cityVO;
	}
	public void setCityVO(CityVO cityVO) {
		this.cityVO = cityVO;
	}
	public AreaVO getAreaVO() {
		return areaVO;
	}
	public void setAreaVO(AreaVO areaVO) {
		this.areaVO = areaVO;
	}
	public StaffVO getStaffVO1() {
		return staffVO1;
	}
	public void setStaffVO1(StaffVO staffVO1) {
		this.staffVO1 = staffVO1;
	}
	public StaffVO getStaffVO2() {
		return staffVO2;
	}
	public void setStaffVO2(StaffVO staffVO2) {
		this.staffVO2 = staffVO2;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
