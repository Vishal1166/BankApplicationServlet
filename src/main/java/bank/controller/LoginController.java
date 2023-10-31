package bank.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bank.dao.RegisterDao;
import bank.model.Login;
import bank.model.Register;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  static int logincnt=0;
	
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("login1...");
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		System.out.println("login2...");
		
		Login lobj=new Login();
		lobj.setUname(uname);
		lobj.setPass(pass);
		System.out.println("login3...");
		List<Login> lstlogin=new ArrayList<Login>();
		lstlogin.add(lobj);
		
		RegisterDao regdao=new RegisterDao();
		System.out.println("login4...");
		List<Register> lstreg=regdao.validateData(lstlogin);
		
		System.out.println("login5...");
		HttpSession session=request.getSession();
		session.setAttribute("cust",lstreg);
		if(lstreg!=null) {
			response.sendRedirect("Dashboard.html");
		}
		else {
			logincnt++;
				if(logincnt<3)
					response.sendRedirect("Login.html");
				else {
					response.sendRedirect("block.html");
				}
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
