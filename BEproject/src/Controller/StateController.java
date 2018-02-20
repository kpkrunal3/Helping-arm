package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PostDAO;
import DAO.StateDAO;
import VO.StateVO;

/**
 * Servlet implementation class AddState
 */
@WebServlet("/StateController")
public class StateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StateController() {
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
		if(flag.equals("delete")){
			dodelete(request,response);
		}
		if(flag.equals("edit")){
			doedit(request,response);
		}
	}

	

	private void doedit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List stateList=new ArrayList();
		int stateId=Integer.parseInt(request.getParameter("id"));
		StateDAO stateDAO=new StateDAO();
		StateVO stateVO=new StateVO();
		stateVO.setStateId(stateId);
		stateList=stateDAO.edit(stateVO);
		request.getSession().setAttribute("stateList",stateList);
		
	
		
		
	
		response.sendRedirect("admin/stateedit.jsp");
		
	}

	private void dodelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		StateVO stateVO=new StateVO();
		stateVO.setStateId(id);
		StateDAO stateDAO=new StateDAO();
		
		if(!stateDAO.delete(stateVO)){
			request.getSession().setAttribute("errorMsg", "Please delete child rows first");
		}
		else{
			request.getSession().removeAttribute("errorMsg");
		}
		response.sendRedirect("admin/manageState.jsp");
		
		
	}

	private void dosearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List stateList=new ArrayList();
		StateDAO stateDAO=new StateDAO();
		stateList=stateDAO.search();
		request.getSession().setAttribute("state",stateList);
		response.sendRedirect("admin/manageState.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if(flag.equals("insert")){
			insert(request,response);
			response.sendRedirect("admin/AddState.jsp");
		}
		if(flag.equals("update")){
			update(request,response);
			
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int stateId=Integer.parseInt(request.getParameter("id"));
		String stateName=request.getParameter("sname");
		String stateDescription=request.getParameter("des");
		StateVO stateVO=new StateVO();
		StateDAO stateDAO=new StateDAO();
		stateVO.setStateId(stateId);
		stateVO.setStateName(stateName);
		stateVO.setStateDescription(stateDescription);
		stateDAO.update(stateVO);
		dosearch(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) {
		StateVO v=new StateVO();
		StateDAO d=new StateDAO();
		String stateName=request.getParameter("sname");
		String description=request.getParameter("des");
		v.setStateName(stateName);
		v.setStateDescription(description);
		d.insert(v);
	}

}
