package bank.model;

public class Recharge {
	
	private int regNo;
	private String mobno;
	private double rechargeamt;
	private String servicep;
	public Recharge(int regNo, String mobno, double rechargeamt, String servicep) {
		super();
		this.regNo = regNo;
		this.mobno = mobno;
		this.rechargeamt = rechargeamt;
		this.servicep = servicep;
	}
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public double getRechargeamt() {
		return rechargeamt;
	}
	public void setRechargeamt(double rechargeamt) {
		this.rechargeamt = rechargeamt;
	}
	public String getServicep() {
		return servicep;
	}
	public void setServicep(String servicep) {
		this.servicep = servicep;
	}

	
	
}
