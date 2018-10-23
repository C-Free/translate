package tuan5_BTSach;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public abstract class Sach implements Comparable<Sach> {
	protected String maS,nhaSX, tenSach;
	protected int soLuong;
	protected double donGia;
	abstract double thanhtien();
	GregorianCalendar ngayNhap ;
	//*****************************************************************
	public String getMaS() {
		return maS;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maS == null) ? 0 : maS.hashCode());
		result = prime * result + ((nhaSX == null) ? 0 : nhaSX.hashCode());
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
		Sach other = (Sach) obj;
		if (maS == null) {
			if (other.maS != null)
				return false;
		} else if (!maS.equals(other.maS))
			return false;
		if (nhaSX == null) {
			if (other.nhaSX != null)
				return false;
		} else if (!nhaSX.equals(other.nhaSX))
			return false;
		return true;
	}


	public String getNhaSX() {
		return nhaSX;
	}
	public void setNhaSX(String nhaSX) {
		this.nhaSX = nhaSX;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public GregorianCalendar getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(GregorianCalendar ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public void setMaS(String maS) {
		this.maS = maS;
	}
	//*********************************************************
	public Sach(String maS, String nhaSX, String tenSach, int soLuong, double donGia, GregorianCalendar ngayNhap) {
		this.maS = maS;
		this.nhaSX = nhaSX;
		this.tenSach = tenSach;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.ngayNhap = ngayNhap;
	}

	public Sach() {
		// TODO Auto-generated constructor stub
	}
	//*************************************************************
	@Override
	public String toString() {
		Locale lacale = new Locale("vi", "vn");
		NumberFormat format =  NumberFormat.getCurrencyInstance(lacale);
		SimpleDateFormat fm = new SimpleDateFormat("dd/mm/yyyy");
		return String.format("%4s\t %10s\t %10s\t %5d\t %15s\t %s\t", getMaS(),getNhaSX(),getTenSach(),getSoLuong(),format.format(getDonGia()),fm.format(ngayNhap.getTime()));
	}
	public int compareTo(Sach o) {

		if(this.tenSach.compareTo(o.tenSach)==0)
		{
			if(this.maS.compareTo(o.maS)<1)
				return 1;
			else if(this.maS.equals(o.maS))
				return 0;
			else
				return -1;
		}
		else
			return this.tenSach.compareTo(o.tenSach);
	}

}
