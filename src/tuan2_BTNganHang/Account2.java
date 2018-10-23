package tuan2_BTNganHang;

import java.text.DecimalFormat;

public class Account2 {
	public int sTK;// so tai khoan
	public String tTK;// ten tai khoan
	public double soDu;//so du
	static final double LAISUAT = 0.035;
	static final double PHIRUT = 100;
	public int getsTK() {
		return sTK;
	}
	public void setsTK(int sTK) {
		this.sTK = sTK;
	}
	public String gettTK() {
		return tTK;
	}
	public void settTK(String tTK) {
		this.tTK = tTK;
	}
	public double getSoDu() {
		return soDu;
	}
	public void setSoDu(double soDu) {
		this.soDu = soDu;
	}
	public Account2(int sTK, String tTK, double soDu) {
		super();
		this.sTK = sTK;
		this.tTK = tTK;
		this.soDu = soDu;
	}
	public Account2() {
		super();
	}
	public Account2(int sTK, String tTK) {
		super();
		this.sTK = sTK;
		this.tTK = tTK;
	}
	public void napTien(double tienNap) {
		this.setSoDu(this.getSoDu()+tienNap);
		System.out.println("giao dịch thành công");
	}
	public void rutTien(double tienRut) {
		if(this.getSoDu()>tienRut+50000+PHIRUT) {
			this.setSoDu(this.getSoDu()-tienRut-PHIRUT);
			System.out.println("giao dịch thành công");
		}else {
			System.out.println("không đủ tiền");
		}
	}
	public void chuyenTien(double tienChuyen,Account2 acc) {
		this.rutTien(tienChuyen);
	    acc.napTien(tienChuyen);
	}
	
	@Override
	public String toString() {
		String str = "";
		DecimalFormat df = new DecimalFormat("###,000");
		//dinh dang so :1,000,000
		str += String.format("%10d%10s%20s", getsTK(), gettTK(), df.format(getSoDu()));
		return str;
	}
	

}
