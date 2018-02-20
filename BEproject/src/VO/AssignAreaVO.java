package VO;

import java.io.Serializable;

public class AssignAreaVO implements Serializable{
	private int assignAreaId;
	private AreaVO areaVO;
	private StaffVO staffVO;
	public int getAssignAreaId() {
		return assignAreaId;
	}
	public void setAssignAreaId(int assignAreaId) {
		this.assignAreaId = assignAreaId;
	}
	public AreaVO getAreaVO() {
		return areaVO;
	}
	public void setAreaVO(AreaVO areaVO) {
		this.areaVO = areaVO;
	}
	public StaffVO getStaffVO() {
		return staffVO;
	}
	public void setStaffVO(StaffVO staffVO) {
		this.staffVO = staffVO;
	}

	
	
}
