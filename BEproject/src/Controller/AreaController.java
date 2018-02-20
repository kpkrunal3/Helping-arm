
package Controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AreaDAO;
import DAO.CityDAO;
import DAO.StateDAO;
import VO.AreaVO;
import VO.CityVO;
import VO.StateVO;

/**
 * Servlet implementation class AddAreaController
 */
@WebServlet("/AreaController")
public class AreaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AreaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if (flag.equals("LoadState")) {
			LoadState(request, response);

		}
		if (flag.equals("search")) {
			dosearch(request, response);

		}
		if (flag.equals("delete")) {
			dodelete(request, response);

		}
		if (flag.equals("edit")) {
			doedit(request, response);

		}
		else if(flag.equals("loadCity"))
		{
			loadCity(response,request);
		}
	}

	private void loadCity(HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		int stateId=Integer.parseInt(request.getParameter("stateId"));
		System.out.println("dtsasd id"+stateId);
		StateVO stateVO=new StateVO();
		stateVO.setStateId(stateId);
		CityVO cityVO=new CityVO();
		cityVO.setStateVO(stateVO);
		AreaDAO areaDAO=new AreaDAO();
		List List=areaDAO.searchCity(cityVO);
		System.out.println("city sizeee"+List.size());
		
		HttpSession session=request.getSession();
		session.setAttribute("List",List);
		response.sendRedirect("admin/Json/city.jsp");
	}

	private void doedit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List areaList=new ArrayList();
		
		int areaId=Integer.parseInt(request.getParameter("id"));
		System.out.println(areaId);
		AreaVO areaVO=new AreaVO();
		
		AreaDAO areaDAO=new AreaDAO();
		System.out.println(areaVO);	
		areaVO.setAreaId(areaId);
		
		areaList=areaDAO.edit(areaVO);
		
		request.getSession().setAttribute("areaList",areaList);
		System.out.println(areaList);		
		List stateList=new ArrayList();
		StateDAO stateDAO=new StateDAO();
		
		stateList=stateDAO.search();
		
		request.getSession().setAttribute("stateList",stateList);
		
		List cityList=new ArrayList();
		CityDAO cityDAO=new CityDAO();
		
		cityList=cityDAO.search();
		
		request.getSession().setAttribute("cityList",cityList);


		
		response.sendRedirect("admin/areaedit.jsp");
		
	}

	private void dodelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		int areaId=Integer.parseInt(request.getParameter("id"));
		AreaVO areaVO=new AreaVO();
		AreaDAO areaDAO=new AreaDAO();
		areaVO.setAreaId(areaId);
		areaDAO.delete(areaVO);
		if(!areaDAO.delete(areaVO)){
			request.getSession().setAttribute("errorMsg", "Please delete child rows first");
		}
		else{
			request.getSession().removeAttribute("errorMsg");
		}
		response.sendRedirect("admin/managearea.jsp");
	}

	private void dosearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List areaList=new ArrayList();
		AreaDAO areaDAO=new AreaDAO();
		areaList=areaDAO.search();
		request.getSession().setAttribute("areaList",areaList);
		response.sendRedirect("admin/managearea.jsp");
		
	}

	private void LoadState(HttpServletRequest request, HttpServletResponse response) throws IOException {

		List stateList = new ArrayList();

		StateDAO addStateDAO = new StateDAO();
		stateList = addStateDAO.search();
		
		request.getSession().setAttribute("loadState", stateList);

		List cityList = new ArrayList();
		CityDAO addCityDAO = new CityDAO();
		cityList = addCityDAO.search();
		
		request.getSession().setAttribute("loadCity", cityList);
		
		
		response.sendRedirect("admin/AddArea.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if(flag.equals("insert")){
			doinsert(request,response);
		}
		if(flag.equals("update")){
			doupdate(request,response);
		}
	}

	private void doupdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int areaId=Integer.parseInt(request.getParameter("id"));
		int cityId=Integer.parseInt(request.getParameter("city"));
		int stateId=Integer.parseInt(request.getParameter("state"));
		String area=request.getParameter("area");
		String pincode=request.getParameter("pincode");
		String description=request.getParameter("des");
		AreaVO areaVO=new AreaVO();
		StateVO stateVO=new StateVO();
		CityVO cityVO=new CityVO();
		AreaDAO areaDAO=new AreaDAO();
		areaVO.setAreaId(areaId);
		areaVO.setDescription(description);
		areaVO.setPincode(pincode);
		areaVO.setArea(area);
		cityVO.setCityId(cityId);
		stateVO.setStateId(stateId);
		areaVO.setCityVO(cityVO);
		areaVO.setStateVO(stateVO);
		areaDAO.update(areaVO);
		dosearch(request, response);
	}

	private void doinsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AreaVO v=new AreaVO();
		StateVO v1=new StateVO();
		CityVO v2=new CityVO();
		AreaDAO d=new AreaDAO();
		int  stateId=Integer.parseInt(request.getParameter("state"));
		int cityId=Integer.parseInt(request.getParameter("city"));
		String area=request.getParameter("area");
		String pincode=request.getParameter("pincode");
		String description=request.getParameter("des");
		v.setArea(area);
		v.setPincode(pincode);
		v.setDescription(description);
		v1.setStateId(stateId);
		v2.setCityId(cityId);
		v.setStateVO(v1);
		v.setCityVO(v2);
		d.insert(v);
		response.sendRedirect("admin/AddArea.jsp");
		
	}

}
