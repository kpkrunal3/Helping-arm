package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CitizenDAO;
import VO.CitizenVO;

/**
 * Servlet implementation class CitizenController
 */
@WebServlet("/CitizenController")
public class CitizenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CitizenController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if(flag.equals("search")){
			dosearch(request,response);
		}
	}

	private void dosearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List citizenList=new ArrayList();
		CitizenDAO citizenDAO=new CitizenDAO();
		citizenList=citizenDAO.search();
		request.getSession().setAttribute("citizenList",citizenList);
		response.sendRedirect("admin/managecitizen.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
