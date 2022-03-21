package com.project.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.model.DAOService;
import com.project.model.DAOServiceImpl;


@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		session.setMaxInactiveInterval(10);
		if(session.getAttribute("email")!=null) {
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/view/registration.jsp");
		rd.forward(request,response);
		}
		else {
			request.setAttribute("LogoutMsg","login again");
		 RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
        rd.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		DAOService service=new DAOServiceImpl();
		service.connectDB();
		boolean status=service.verifyLogin(email, password);
		if(status==true) {
			HttpSession session=request.getSession(true);
			session.setAttribute("email", email);
			
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/view/registration.jsp");
			rd.forward(request,response);
		}
		else {
			request.setAttribute("errormsg", "invalid username/password");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request,response);		
		}
	}

}
