package tuan4_BTChuyenXe;

import java.text.NumberFormat;
import java.util.Locale;

public class ChuyenXe {
	protected String MaCX,TenCX,SoCX;
	protected double DoanhThu;
	//////////////////////////////////////Get and set////////////////////////
	public String getMaCX() {
		return MaCX;
	}
	public void setMaCX(String maCX) {
		MaCX = maCX;
	}
	public String getTenCX() {
		return TenCX;
	}
	public void setTenCX(String tenCX) {
		TenCX = tenCX;
	}
	public String getSoCX() {
		return SoCX;
	}
	public void setSoCX(String soCX) {
		SoCX = soCX;
	}
	public double getDoanhThu() {
		return DoanhThu;
	}
	public void setDoanhThu(double doanhThu) {
		DoanhThu = doanhThu;
	}
	//////////////////////////////////////////Constructor///////////////////
	public ChuyenXe() {
		super();
	}
	public ChuyenXe(String maCX, String tenCX, String soCX, double doanhThu) {
		super();
		MaCX = maCX;
		TenCX = tenCX;
		SoCX = soCX;
		DoanhThu = doanhThu;
	}
	//////////////////////////////////////TO STRING/////////////////////////
	@Override
	public String toString() {
		Locale locale = new Locale("Vi", "VN");
		NumberFormat format = NumberFormat.getCurrencyInstance(locale);
		String str="";
		str = String.format("%-10s%-15s%-15s%-20s", getMaCX(), getTenCX(), getSoCX(), format.format(getDoanhThu()));
		return str;
		//return "ChuyenXe [MaCX=" + MaCX + ", TenCX=" + TenCX + ", SoCX=" + SoCX + ", DoanhThu=" + format.format(DoanhThu) + "]";
	}
	/////////////////////////////////////Hash and Equal//////////////////////
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MaCX == null) ? 0 : MaCX.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChuyenXe other = (ChuyenXe) obj;
		if (MaCX == null) {
			if (other.MaCX != null)
				return false;
		} else if (!MaCX.equals(other.MaCX))
			return false;
		return true;
	}
	
	
	
}
