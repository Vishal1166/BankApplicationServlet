package bank.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import bank.dao.RechargeDao;
import bank.model.Recharge;
import bank.model.Register;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RechargeController")
public class RechargeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RechargeController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String mobno=request.getParameter("mobno");
		double rechargeamt=Double.parseDouble(request.getParameter("rechargeamt"));
		String servicep=request.getParameter("servicep");
	
		HttpSession session=request.getSession();		
		List<Register> lstreg=(List<Register>) session.getAttribute("cust");
		
		Register r=lstreg.get(0);
		Recharge rechargeobj=new Recharge(r.getRno(),mobno,rechargeamt,servicep);
		
		List<Recharge> lstrecharge=new ArrayList<Recharge>();
		lstrecharge.add(rechargeobj);
		
		RechargeDao rechargeDao=new RechargeDao();
		boolean b=rechargeDao.rechargeData(lstrecharge);
		if(b) {
			response.sendRedirect("RechargeOk.jsp");
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
