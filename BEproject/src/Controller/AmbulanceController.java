package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AreaDAO;
import DAO.CityDAO;
import DAO.StateDAO;
import DAO.AmbulanceDAO;
import DAO.PostDAO;
import DAO.StaffDAO;
import VO.AreaVO;
import VO.CityVO;
import VO.StateVO;
import VO.AmbulanceVO;
import VO.StaffVO;

/**
 * Servlet implementation class AmbulanceController
 */
@WebServlet("/AmbulanceController")
public class AmbulanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AmbulanceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if(flag.equals("Loadmenu")){
			doloadmenu(request,response);
		}
		if(flag.equals("search")){
			dosearch(request,response);
		}
	}

private void dosearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List ambulance=new ArrayList();
		AmbulanceDAO ambulanceDAO=new AmbulanceDAO();
		ambulance=ambulanceDAO.search();
		request.getSession().setAttribute("ambulance",ambulance);
		response.sendRedirect("admin/manage108.jsp");
		
	}

private void doloadmenu(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StateDAO addStateDAO=new StateDAO();
		CityDAO addCityDAO=new CityDAO();
		AreaDAO addAreaDAO=new AreaDAO();
		StaffDAO staffDAO=new StaffDAO();
		
		List stateList=new ArrayList();
		List cityList=new ArrayList();
		List areaList=new ArrayList();
		List postListDriver=new ArrayList();
		List postListDoctor=new ArrayList();
		
		stateList=addStateDAO.search();
		cityList=addCityDAO.search();
		areaList=addAreaDAO.search();
		
		postListDoctor=staffDAO.search1();
		postListDriver=staffDAO.search2();
		
		request.getSession().setAttribute("state",stateList);
		request.getSession().setAttribute("city",cityList);
		request.getSession().setAttribute("area",areaList);
		request.getSession().setAttribute("driver",postListDriver);
		request.getSession().setAttribute("doctor",postListDoctor);
		
		response.sendRedirect("admin/Add108.jsp");
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if(flag.equals("insert")){
			doinsert(request,response);
		}
	}

	private void doinsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AmbulanceDAO ambulanceDAO=new AmbulanceDAO();
		AmbulanceVO ambulanceVO=new AmbulanceVO();
		StateVO addStateVO=new StateVO();
		CityVO addCityVO=new CityVO();
		AreaVO addAreaVO=new AreaVO();
		StaffVO staffVO1=new StaffVO();
		StaffVO staffVO2=new StaffVO();
		
		
		String number=request.getParameter("number");
		String addressLine1=request.getParameter("add1");
		String addressLine2=request.getParameter("add2");
		String latitude=request.getParameter("lati");
		String longitude=request.getParameter("longi");
		String status=request.getParameter("status");
		String pincode=request.getParameter("pincode");
		int stateId=Integer.parseInt(request.getParameter("state"));
		int cityId=Integer.parseInt(request.getParameter("city"));
		int areaId=Integer.parseInt(request.getParameter("area"));
		int driverId1=Integer.parseInt(request.getParameter("driver"));
		int doctorId2=Integer.parseInt(request.getParameter("doctor"));
		ambulanceVO.setNumber(number);
		ambulanceVO.setAddressLine1(addressLine1);
		ambulanceVO.setAddressLine2(addressLine2);
		ambulanceVO.setLatitude(latitude);
		ambulanceVO.setLongitude(longitude);
		ambulanceVO.setStatus(status);
		ambulanceVO.setPincode(pincode);
		
		addStateVO.setStateId(stateId);
		addCityVO.setCityId(cityId);
		addAreaVO.setAreaId(areaId);
		staffVO1.setStaffId(driverId1);
		staffVO2.setStaffId(doctorId2);
		
		ambulanceVO.setStateVO(addStateVO);
		ambulanceVO.setCityVO(addCityVO);
		ambulanceVO.setAreaVO(addAreaVO);
		ambulanceVO.setStaffVO1(staffVO1);
		ambulanceVO.setStaffVO2(staffVO2);
		
		ambulanceDAO.insert(ambulanceVO);
		response.sendRedirect("admin/Add108.jsp");
		
		
		
		
	}

}
