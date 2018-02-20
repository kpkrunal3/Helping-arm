package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FeedbackDAO;
import VO.FeedbackVO;

/**
 * Servlet implementation class FeedbackController
 */
@WebServlet("/FeedbackController")
public class FeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackController() {
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
		List feedbackList=new ArrayList();
		FeedbackDAO feedbackDAO=new FeedbackDAO();
		feedbackList=feedbackDAO.search();
		request.getSession().setAttribute("feedbackList",feedbackList);
		response.sendRedirect("admin/managefeedback.jsp");
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
		FeedbackDAO feedbackDAO=new FeedbackDAO();
		FeedbackVO feedbackVO=new FeedbackVO();
		String email=request.getParameter("email");
		String title=request.getParameter("title");
		String description=request.getParameter("des");
		feedbackVO.setEmail(email);
		feedbackVO.setDescription(description);
		feedbackVO.setTitle(title);
		feedbackDAO.insert(feedbackVO);
		response.sendRedirect("108/feedback.jsp");
		
	}

}
