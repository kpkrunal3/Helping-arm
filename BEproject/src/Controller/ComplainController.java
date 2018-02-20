package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ComplainDAO;
import VO.ComplainVO;

/**
 * Servlet implementation class ComplainController
 */
@WebServlet("/ComplainController")
public class ComplainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainController() {
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
		List complainList=new ArrayList();
		ComplainDAO complainDAO=new ComplainDAO();
		complainList=complainDAO.search();
		request.getSession().setAttribute("complainList",complainList);
		response.sendRedirect("admin/managecomplain.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String title=request.getParameter("title");
		String description=request.getParameter("des");
		ComplainVO complainVO=new ComplainVO();
		complainVO.setEmail(email);
		complainVO.setTitle(title);
		complainVO.setDescription(description);
		ComplainDAO complainDAO=new ComplainDAO();
		complainDAO.insert(complainVO);
		response.sendRedirect("108/Complain.jsp");
	}

}
