package com.project.Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.model.DAOService;
import com.project.model.DAOServiceImpl;

@WebServlet("/GetRegistration")
public class GetRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GetRegistration() {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		session.setMaxInactiveInterval(10);
		if(session.getAttribute("email")!=null) {
         DAOService service=new DAOServiceImpl();
         service.connectDB();
         ResultSet result=service.getReg();
         request.setAttribute("res", result);
         RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/view/showReg.jsp");
         rd.forward(request,response);
		}else {
			request.setAttribute("LogoutMsg","login again");
			 RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
	         rd.forward(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
