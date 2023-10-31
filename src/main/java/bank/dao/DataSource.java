package bank.dao;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataSource {
	
	static
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection con=null;
		try {
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","123456789");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
/*
 * create table bank
(
	reg_no number(5) primary key,
	first_name varchar2(20) not null,
	acc_bal float,
	user_name varchar2(20),
	user_pass varchar2(20)
);
 * 
 */


