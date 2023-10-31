package bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import bank.model.Recharge;

public class RechargeDao {
	public boolean rechargeData(List<Recharge> lstrech) {
		boolean b=false;
		Recharge robj=lstrech.get(0);
		double bal=0,rbal=0;
		Connection con=DataSource.getConnection();
		int i=0;
		try {
			PreparedStatement pstate = con.prepareStatement("select acc_bal from bank where reg_no=?");
			pstate.setInt(1,robj.getRegNo());
			ResultSet rs = pstate.executeQuery();
			if (rs.next()) {
				bal=rs.getDouble(1);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(bal>=1000) {
			rbal=bal-robj.getRechargeamt();
		}
		//update database
		try {
			PreparedStatement pstate = con.prepareStatement("update bank set acc_bal=? where reg_no=?");
			pstate.setDouble(1,rbal);
			pstate.setInt(2, robj.getRegNo());
			i = pstate.executeUpdate();
			if (i>0) {
				b=true;
				System.out.println("recharge done..");
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}

		return b;

	}


}
