package bank.model;

public class Register {
	
	private int rno;
	private String fname;
	private double accbal;
	private String uname;
	private String pass;
	public Register(int rno, String fname, double accbal, String uname, String pass) {
		super();
		this.rno = rno;
		this.fname = fname;
		this.accbal = accbal;
		this.uname = uname;
		this.pass = pass;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public double getAccbal() {
		return accbal;
	}
	public void setAccbal(double accbal) {
		this.accbal = accbal;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
