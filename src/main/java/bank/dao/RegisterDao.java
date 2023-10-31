package bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bank.model.Login;
import bank.model.Register;

public class RegisterDao {

	public int create(List<Register> lstreg) {
		System.out.println("register controllet -test4");
		Register regmodel=lstreg.get(0);
		int i=0;
		Connection con=DataSource.getConnection();
		
		try {
			PreparedStatement pstate=con.prepareStatement("insert into bank values(?,?,?,?,?)");
			pstate.setInt(1,regmodel.getRno());
			pstate.setString(2,regmodel.getFname());
			pstate.setDouble(3,regmodel.getAccbal());
			pstate.setString(4,regmodel.getUname());
			pstate.setString(5,regmodel.getPass());

			i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}
	public List<Register> validateData(List<Login> lstlogin) {
		boolean b=false;
		Login lobj=lstlogin.get(0);		
		List<Register> lstreg=null;
		Connection con=DataSource.getConnection();
		try {
			PreparedStatement pstate = con.prepareStatement("select * from bank where user_name=? and user_pass=?");
			pstate.setString(1, lobj.getUname());
			pstate.setString(2, lobj.getPass());
			ResultSet rs = pstate.executeQuery();			
			if (rs.next()) {
				b = true;
				lstreg=new ArrayList();
				Register r=new Register(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5));
				lstreg.add(r);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lstreg;

	}
}
