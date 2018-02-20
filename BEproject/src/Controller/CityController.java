package Controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CityDAO;
import DAO.StateDAO;
import VO.CityVO;
import VO.StateVO;

/**
 * Servlet implementation class AddCityController
 */
@WebServlet("/CityController")
public class CityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if(flag.equals("LoadState")){
			LoadState(request,response);
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
		
		List cityList=new ArrayList();
		int cityId=Integer.parseInt(request.getParameter("id"));
		CityDAO cityDAO=new CityDAO();
		CityVO cityVO=new CityVO();
		cityVO.setCityId(cityId);
		cityList=cityDAO.edit(cityVO);
		request.getSession().setAttribute("cityList",cityList);
		
		List ls=new ArrayList();
		StateDAO d=new StateDAO();
		ls=d.search();
		request.getSession().setAttribute("stateList",ls);

		
		response.sendRedirect("admin/cityedit.jsp");
	}

	private void dodelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int cityId=Integer.parseInt(request.getParameter("id"));
		CityVO cityVO=new CityVO();
		cityVO.setCityId(cityId);
		CityDAO cityDAO=new CityDAO();
		cityDAO.delete(cityVO);
		if(!cityDAO.delete(cityVO)){
			request.getSession().setAttribute("errorMsg", "Please delete child rows first");
		}
		else{
			request.getSession().removeAttribute("errorMsg");
		}
		response.sendRedirect("admin/managecity.jsp");
		
	}

	private void dosearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List cityList=new ArrayList();
		CityDAO  cityDAO=new CityDAO();
		cityList = cityDAO.search();
		
		request.getSession().setAttribute("cityList",cityList);
		response.sendRedirect("admin/managecity.jsp");
		
	}

	private void LoadState(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List ls=new ArrayList();
		StateDAO d=new StateDAO();
		ls=d.search();
		request.getSession().setAttribute("stateList",ls);
		response.sendRedirect("admin/AddCity.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if(flag.equals("insert")){
			insert(request,response);
			response.sendRedirect("admin/AddCity.jsp");
		}
		if(flag.equals("update")){
			doupdate(request,response);
			
		}
	}

	private void doupdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int cityId=Integer.parseInt(request.getParameter("cityId"));
		int stateId=Integer.parseInt(request.getParameter("state"));
		String cityName=request.getParameter("cname");
		String cityDescription=request.getParameter("des");
		CityVO cityVO=new CityVO();
		CityDAO cityDAO=new CityDAO();
		StateVO stateVO=new StateVO();
		stateVO.setStateId(stateId);
		cityVO.setStateVO(stateVO);
		cityVO.setCityId(cityId);
		cityVO.setCityName(cityName);
		cityVO.setCityDescription(cityDescription);
		cityDAO.update(cityVO);
		dosearch(request, response);
		
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) {
		CityVO v=new CityVO();
		StateVO v1=new StateVO();
		CityDAO d=new CityDAO();
		int stateId=Integer.parseInt(request.getParameter("state"));
		String cityName=request.getParameter("cname");
		String cityDescription=request.getParameter("des");
		v.setCityName(cityName);
		v.setCityDescription(cityDescription);
		v1.setStateId(stateId);
		v.setStateVO(v1);
		d.insert(v);
		
		
	}

}
