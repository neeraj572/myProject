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

@WebServlet("/Reg")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
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
		
		
		
		String name=request.getParameter("name");
		String city=request.getParameter("city");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		
		HttpSession session=request.getSession(false);
		session.setMaxInactiveInterval(10);
		if(session.getAttribute("email")!=null) {
		DAOService service=new DAOServiceImpl();
		service.connectDB();
		service.insertReg(name,city,email,mobile);
		request.setAttribute("msg","registration done");
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/view/registration.jsp");
		rd.forward(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
