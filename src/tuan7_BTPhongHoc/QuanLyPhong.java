package tuan7_BTPhongHoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public  class QuanLyPhong {
	ArrayList<PhongHoc> quanLy=new ArrayList<PhongHoc>();
	public boolean them(PhongHoc o) {
		if(quanLy.contains(o)!=true) {
			quanLy.add(o);
			return true;
		}
		return false;	
	}
	public ArrayList<PhongHoc> getAllPhong(){
		return quanLy;
	}
	public ArrayList<PhongHoc> getQuanLy() {
		return quanLy;
	}
	public void setQuanLy(ArrayList<PhongHoc> quanLy) {
		this.quanLy = quanLy;
	}
	//tim kiem phong tra ve so
	public int timKiemPhong(String o) {
		for(int i=0;i<quanLy.size();i++) {
			if(quanLy.get(i).getMaPhong().equals(o)==true) {
				return i;
			}
		}
		return 0;
		
	}
	//sap xep theo cot day nha
	public void sapXepTheoCotNha() {
		Collections.sort(quanLy,new Comparator<PhongHoc>() {

			public int compare(PhongHoc p1, PhongHoc p2) {
				return p1.getDayNha().compareTo(p2.getDayNha());
			}
		});
	}
	public void sapXepTheoDienTich() {
		Collections.sort(quanLy,new Comparator<PhongHoc>() {

			public int compare(PhongHoc p1, PhongHoc p2) {
				if(p1.getDienTich()>p2.getDienTich()) {
					return 1;
				}else if(p1.getDienTich()<p2.getDienTich()) {
					return -1;
				}else {
					return 0;
				}
			}
		});
	}
	public void sapXepTheoBongDen() {
		Collections.sort(quanLy,new Comparator<PhongHoc>() {

			public int compare(PhongHoc p1, PhongHoc p2) {
				if(p1.getSoBongDen()>p2.getSoBongDen()) {
					return 1;
				}else if(p1.getSoBongDen()<p2.getSoBongDen()) {
					return -1;
				}else {
					return 0;
				}
			}
		});
	}
	public boolean xoaMaPhong(String maPhong) {
		for(int i=0;i<quanLy.size();i++) {
			if(quanLy.get(i).getMaPhong().equals(maPhong)==true) {
				quanLy.remove(quanLy.get(i));
				return true;
			}
		}
		return false;
	}
	public int  tongSoPhong() {
		int tong=0;
		for(int i=0;i<quanLy.size();i++) {
			tong++;
		}
		return tong;
	}
	public int PhongSauMuoiMay() {
		int tong=0;
		for(PhongHoc i:quanLy) {
			if(i instanceof PhongMayTinh) {
				if(((PhongMayTinh) i).getMayTinh()>=60) {
					tong++;
				}
			}
		}
		return tong;
	}
}
