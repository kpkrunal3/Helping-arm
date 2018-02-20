package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.undo.StateEditable;

import DAO.CityDAO;
import DAO.StateDAO;
import DAO.PostDAO;
import DAO.StaffDAO;
import VO.CityVO;
import VO.StateVO;
import VO.PostVO;
import VO.StaffVO;

/**
 * Servlet implementation class StaffController
 */
@WebServlet("/StaffController")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffController() {
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
		if(flag.equals("delete")){
			dodelete(request,response);
		}
		if(flag.equals("edit")){
			doedit(request,response);
		}
	}

	private void doedit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List staffList=new ArrayList();
		int staffId=Integer.parseInt(request.getParameter("id"));
		StaffDAO staffDAO=new StaffDAO();
		StaffVO staffVO=new StaffVO();
		staffVO.setStaffId(staffId);
		staffList=staffDAO.edit(staffVO);
		request.getSession().setAttribute("staffList",staffList);
		
		List postList=new ArrayList();
		PostDAO postDAO=new PostDAO();
		postList=postDAO.search();
		request.getSession().setAttribute("postList",postList);
		
		List stateList=new ArrayList();
		StateDAO stateDAO=new StateDAO();
		stateList=stateDAO.search();
		request.getSession().setAttribute("stateList",stateList);
		
		List cityList=new ArrayList();
		CityDAO cityDAO=new CityDAO();
		cityList=cityDAO.search();
		request.getSession().setAttribute("cityList",cityList);
		
		
		response.sendRedirect("admin/editstaff.jsp");
	}

	private void dodelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StaffDAO staffDAO=new StaffDAO();
		StaffVO staffVO=new StaffVO();
		int staffId=Integer.parseInt(request.getParameter("id"));
		staffVO.setStaffId(staffId);
		staffDAO.delete(staffVO);
		if(!staffDAO.delete(staffVO)){
			request.getSession().setAttribute("errorMsg","Please delete child rows first");
		}
		else{
			request.getSession().removeAttribute("errorMsg");
		}
		response.sendRedirect("admin/manage108staff.jsp");
		
	}

	private void dosearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List staff=new ArrayList();
		StaffDAO staffDAO=new StaffDAO();
		staff=staffDAO.search3();
		request.getSession().setAttribute("staff",staff);
		response.sendRedirect("admin/manage108staff.jsp");
		
	}

	private void doloadmenu(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List postList=new ArrayList();
		List stateList=new ArrayList();
		List cityList=new ArrayList();		
		PostDAO d1=new PostDAO();
		StateDAO d2=new StateDAO();
		CityDAO d3=new CityDAO();
		
		
		postList=d1.search();
		
		stateList=d2.search();
		
		cityList=d3.search();
		
		
		request.getSession().setAttribute("Post",postList);
		request.getSession().setAttribute("State",stateList);
		request.getSession().setAttribute("City",cityList);
		
		response.sendRedirect("admin/Add108staff.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if(flag.equals("insert")){
			insert(request,response);
		}
		if(flag.equals("update")){
			doupdate(request,response);
		}

}

	private void doupdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int staffId=Integer.parseInt(request.getParameter("id"));
		int cityId=Integer.parseInt(request.getParameter("city"));
		int stateId=Integer.parseInt(request.getParameter("state"));
		int postId=Integer.parseInt(request.getParameter("post"));
		StaffDAO staffDAO=new StaffDAO();
		StaffVO staffVO=new StaffVO();
		CityVO cityVO=new CityVO();
		StateVO stateVO=new StateVO();
		PostVO postVO=new PostVO();
		staffVO.setStaffId(staffId);
		cityVO.setCityId(cityId);
		stateVO.setStateId(stateId);
		postVO.setPostId(postId);
		staffVO.setPostVO(postVO);
		staffVO.setCityVO(cityVO);
		staffVO.setStateVO(stateVO);
		String firstName=request.getParameter("fname");
		String lastName=request.getParameter("lname");
		String middleName=request.getParameter("midname");
		String mobileNumber=request.getParameter("mobno");
		String email=request.getParameter("email");
		String addressLine1=request.getParameter("add1");
		String addressLine2=request.getParameter("add2");
		String pincode=request.getParameter("pincode");
		staffVO.setFirstName(firstName);
		staffVO.setLastName(lastName);
		staffVO.setMiddleName(middleName);
		staffVO.setMobileNumber(mobileNumber);
		staffVO.setEmail(email);
		staffVO.setAddressLine1(addressLine1);
		staffVO.setAddressLine2(addressLine2);
		staffVO.setPincode(pincode);
		staffDAO.update(staffVO);
		dosearch(request, response);
		
		
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		StaffVO staffVO=new StaffVO();
		StaffDAO staffDAO=new StaffDAO();
		PostVO postVO=new PostVO();
		StateVO addStateVO=new StateVO();
		CityVO addCityVO=new CityVO();
		
		String firstName=request.getParameter("fname");
		String lastName=request.getParameter("lname");
		String middleName=request.getParameter("midname");
		int postId=Integer.parseInt(request.getParameter("post"));
		String mobileNumber=request.getParameter("mobno");
		String email=request.getParameter("email");
		String addressLine1=request.getParameter("add1");
		String addressLine2=request.getParameter("add2");
		int stateId=Integer.parseInt(request.getParameter("state"));
		int cityId=Integer.parseInt(request.getParameter("city"));
		String pincode=request.getParameter("pincode");
		
		staffVO.setFirstName(firstName);
		staffVO.setLastName(lastName);
		staffVO.setMiddleName(middleName);
		staffVO.setMobileNumber(mobileNumber);
		staffVO.setEmail(email);
		staffVO.setAddressLine1(addressLine1);
		staffVO.setAddressLine2(addressLine2);
		staffVO.setPincode(pincode);
		
		postVO.setPostId(postId);
		addStateVO.setStateId(stateId);
		addCityVO.setCityId(cityId);
		
		staffVO.setPostVO(postVO);
		staffVO.setStateVO(addStateVO);
		staffVO.setCityVO(addCityVO);
		
		staffDAO.insert(staffVO);
		response.sendRedirect("admin/Add108staff.jsp");
	}
		
		
	}
