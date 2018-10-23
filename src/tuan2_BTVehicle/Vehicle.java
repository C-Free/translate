package tuan2_BTVehicle;

import java.util.Scanner;

public class Vehicle {
	public static Scanner scn=new Scanner(System.in);
	private String tenChuXe;
	private String loaiXe;
	private float dungTich;
	private float triGia;
	private float thuePhaiNop;
	public String getTenChuXe() {
		return tenChuXe;
	}
	public void setTenChuXe(String tenChuXe) {
		this.tenChuXe = tenChuXe;
	}
	public String getLoaiXe() {
		return loaiXe;
	}
	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}
	public float getDungTich() {
		return dungTich;
	}
	public void setDungTich(float dungTich) {
		this.dungTich = dungTich;
	}
	public float getTriGia() {
		return triGia;
	}
	public void setTriGia(float triGia) {
		this.triGia = triGia;
	}
	public float getThuePhaiNop() {
		return thuePhaiNop;
	}
	public void setThuePhaiNop(float thuePhaiNop) {
		this.thuePhaiNop = thuePhaiNop;
	}
	public Vehicle(String tenChuXe, String loaiXe, float dungTich, float triGia, float thuePhaiNop) {
		super();
		this.tenChuXe = tenChuXe;
		this.loaiXe = loaiXe;
		this.dungTich = dungTich;
		this.triGia = triGia;
		this.thuePhaiNop = thuePhaiNop;
	}
	
	public Vehicle(String tenChuXe, String loaiXe, float dungTich, float triGia) {
		super();
		this.tenChuXe = tenChuXe;
		this.loaiXe = loaiXe;
		this.dungTich = dungTich;
		this.triGia = triGia;
	}
	public Vehicle() {
		super();
	}
	public void kiemTra() {
		if(this.dungTich<100) {
			setThuePhaiNop((this.getTriGia()*1/100));
		}else if(100<this.dungTich && this.dungTich<200) {
			setThuePhaiNop((this.getTriGia()*3/100));
		}else {
			setThuePhaiNop((this.getTriGia()*5/100));
		}
	}
	public String toString() {
		String str="";
		str+=String.format("%10s %10s %10.0f %10.0f %10.0f",getTenChuXe(),getLoaiXe(),getDungTich(),getTriGia(),getThuePhaiNop());
		return str;
	}


}


