package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.loginDAO;
import DAO.registrationDAO;
import VO.loginVO;
import VO.registrationVO;

/**
 * Servlet implementation class registration
 */
@WebServlet("/registration")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if(flag.equals("insert")){
			insert(request,response);
		}
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) {
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String radio=request.getParameter("radi");
		registrationVO rVO=new registrationVO();
		rVO.setFname(fname);
		rVO.setLname(lname);
		rVO.setPass(pass);
		rVO.setRadio(radio);
		rVO.setUname(uname);
		loginVO lVO=new loginVO();
		lVO.setUname(uname);
		lVO.setPass(pass);
		lVO.setRadio(radio);
		registrationDAO regDAO=new registrationDAO();
		loginDAO loDAO=new loginDAO();
		regDAO.insert(rVO);
		loDAO.insert(lVO);
		
		
		
	}

}
