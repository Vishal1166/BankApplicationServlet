package bank.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import bank.dao.RegisterDao;
import bank.model.Register;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int rno=Integer.parseInt(request.getParameter("rno"));
		String fname=request.getParameter("fname");
		double accbal=Double.parseDouble(request.getParameter("accbal"));
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		System.out.println("register controllet -test1");
		Register regmodel=new Register(rno, fname, accbal, uname, pass);
		List<Register> lstreg=new ArrayList<Register>();
		lstreg.add(regmodel);

		RegisterDao regdao=new RegisterDao();
		System.out.println("register controllet -test2");		
		int i=regdao.create(lstreg);
		System.out.println("register controllet -test3");
		if(i>0) {
			response.sendRedirect("Login.html");
		}
		else {
			response.sendRedirect("Error.html");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
