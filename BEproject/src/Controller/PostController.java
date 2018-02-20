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
import VO.PostVO;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/PostController")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostController() {
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
		List postList=new ArrayList();
		int postId=Integer.parseInt(request.getParameter("id"));
		PostDAO postDAO=new PostDAO();
		PostVO postVO=new PostVO();
		postVO.setPostId(postId);
		postList=postDAO.edit(postVO);
		request.getSession().setAttribute("postList",postList);
		response.sendRedirect("admin/postedit.jsp");
	}

	private void dodelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PostDAO postDAO=new PostDAO();
		PostVO  postVO=new PostVO();
		int postId=Integer.parseInt(request.getParameter("id"));
		postVO.setPostId(postId);
		postDAO.delete(postVO);
		if(!postDAO.delete(postVO)){
			request.getSession().setAttribute("errorMsg", "Please delete child rows first");
		}
		else{
			request.getSession().removeAttribute("errorMsg");
		}
		response.sendRedirect("admin/managepost.jsp");
		
	}

	private void dosearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List postList=new ArrayList();
		PostDAO  postDAO=new PostDAO();
		postList=postDAO.search();
		request.getSession().setAttribute("postList",postList);
		response.sendRedirect("admin/managepost.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if(flag.equals("insert"))
		{
			doinsert(request,response);
		}
		if(flag.equals("update"))
		{
			doupdate(request,response);
		}
	}

	private void doupdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int postId=Integer.parseInt(request.getParameter("id"));
		String postName=request.getParameter("pname");
		String description=request.getParameter("des");
		PostVO postVO=new PostVO();
		PostDAO postDAO=new PostDAO();
		postVO.setPostId(postId);
		postVO.setPostName(postName);
		postVO.setDescription(description);
		postDAO.update(postVO);
		dosearch(request,response);
		
	}

	private void doinsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
			PostDAO postDAO=new PostDAO();
			PostVO postVO=new PostVO();
			String postName=request.getParameter("Pname");
			String description=request.getParameter("des");
			postVO.setPostName(postName);
			postVO.setDescription(description);
			postDAO.insert(postVO);
			response.sendRedirect("admin/addpost.jsp");
		
	}

}
