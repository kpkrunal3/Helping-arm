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
import DAO.AssignAreaDAO;
import DAO.StaffDAO;
import VO.AreaVO;
import VO.AssignAreaVO;
import VO.StaffVO;

/**
 * Servlet implementation class AssignArea
 */
@WebServlet("/AssignAreaController")
public class AssignAreaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignAreaController() {
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
		List assignList=new ArrayList();
		int assignAreaId=Integer.parseInt(request.getParameter("id"));
		AssignAreaDAO assignAreaDAO=new AssignAreaDAO();
		AssignAreaVO assignAreaVO=new AssignAreaVO();
		assignAreaVO.setAssignAreaId(assignAreaId);
		assignList=assignAreaDAO.edit(assignAreaVO);
		request.getSession().setAttribute("assignList",assignList);

		
		List staffList=new ArrayList();
		StaffDAO staffDAO=new StaffDAO();
		staffList=staffDAO.search3();
		request.getSession().setAttribute("staffList",staffList);
		
		List areaList=new ArrayList();
		AreaDAO areaDAO=new AreaDAO();
		areaList=areaDAO.search();
		request.getSession().setAttribute("areaList",areaList);
		
		response.sendRedirect("admin/assignedit.jsp");
		
	}

	private void dodelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		AssignAreaDAO assignAreaDAO=new AssignAreaDAO();
		
		AssignAreaVO assignAreaVO=new AssignAreaVO();
	
		int assignAreaId=Integer.parseInt(request.getParameter("id"));
		
		
		assignAreaVO.setAssignAreaId(assignAreaId);
		
		//assignAreaDAO.delete(assignAreaVO);
		
		if(!assignAreaDAO.delete(assignAreaVO)){
			request.getSession().setAttribute("errorMsg", "Please delete child rows first");
		}
		
		else{
			request.getSession().removeAttribute("errorMsg");
		}
		
		dosearch(request, response);
		
		//response.sendRedirect("admin/manageassignarea.jsp");
		
	}

	private void dosearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List assignList=new ArrayList();
		AssignAreaDAO assignAreaDAO=new AssignAreaDAO();
		assignList=assignAreaDAO.search();
		request.getSession().setAttribute("assignList",assignList);
		response.sendRedirect("admin/manageassignarea.jsp");
		
	}

	private void doloadmenu(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List staffList=new ArrayList();
		List areaList=new ArrayList();
		
		
		StaffDAO staffDAO=new StaffDAO();
		AreaDAO areaDAO=new AreaDAO();
		
		staffList=staffDAO.search3();
		areaList=areaDAO.search();
		
		request.getSession().setAttribute("staff",staffList);
		request.getSession().setAttribute("area",areaList);
		
		response.sendRedirect("admin/AssignArea.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if(flag.equals("insert")){
			doinsert(request,response);
		}
		if(flag.equals("update")){
			doupdate(request,response);
		}
	}

	private void doupdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int assignAreaId=Integer.parseInt(request.getParameter("id"));
		int areaId=Integer.parseInt(request.getParameter("area"));
		int staffId=Integer.parseInt(request.getParameter("staff"));
		AssignAreaDAO assignAreaDAO=new AssignAreaDAO();
		AssignAreaVO assignAreaVO=new AssignAreaVO();
		AreaVO areaVO=new AreaVO();
		StaffVO staffVO=new StaffVO();
		areaVO.setAreaId(areaId);
		staffVO.setStaffId(staffId);
		assignAreaVO.setAreaVO(areaVO);
		assignAreaVO.setStaffVO(staffVO);
		assignAreaVO.setAssignAreaId(assignAreaId);
		assignAreaDAO.update(assignAreaVO);
		dosearch(request, response);
		
	}

	private void doinsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
			int staffId=Integer.parseInt(request.getParameter("staff"));
			int areaId=Integer.parseInt(request.getParameter("area"));
			StaffVO staffVO=new StaffVO();
			AreaVO areaVO=new AreaVO();
			staffVO.setStaffId(staffId);
			areaVO.setAreaId(areaId);
			AssignAreaVO assignAreaVO=new AssignAreaVO();
			assignAreaVO.setAreaVO(areaVO);
			assignAreaVO.setStaffVO(staffVO);
			AssignAreaDAO areaDAO=new AssignAreaDAO();
			areaDAO.insert(assignAreaVO);
			response.sendRedirect("admin/AssignArea.jsp");
	}

}
