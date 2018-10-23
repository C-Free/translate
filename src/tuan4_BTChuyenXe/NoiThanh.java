package tuan4_BTChuyenXe;

public class NoiThanh extends ChuyenXe{
	private String soTuyen;
	private double soKm;
	public String getSoTuyen() {
		return soTuyen;
	}
	public void setSoTuyen(String soTuyen) {
		this.soTuyen = soTuyen;
	}
	public double getSoKm() {
		return soKm;
	}
	public void setSoKm(double soKm) {
		this.soKm = soKm;
	}
	
	
	public NoiThanh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoiThanh(String maCX, String tenCX, String soCX, double doanhThu,String soTuyen,double soKm) {
		super(maCX, tenCX, soCX, doanhThu);
		this.soTuyen=soTuyen;
		this.soKm=soKm;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		String str="";
		str=String.format("%-10s%10.0f",getSoTuyen(),getSoKm());
		return super.toString()+str;
	}
	
	
}
