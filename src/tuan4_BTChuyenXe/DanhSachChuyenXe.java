package tuan4_BTChuyenXe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachChuyenXe implements Comparator<ChuyenXe> {
	ArrayList<ChuyenXe> quanLy=new ArrayList<ChuyenXe>();
	boolean Them(ChuyenXe xe) {
		boolean flag=false;
		if(timCX(xe.getMaCX())) {
			flag=false;
		}else {
			quanLy.add(xe);
			flag=true;
		}
		return flag;
	}
	double TongDoanhThu() {
		double tong=0f;
		for(int i=0;i<quanLy.size();i++) {
			tong+=quanLy.get(i).getDoanhThu();
		}
		return tong;
	}
	public int compare(ChuyenXe xe1,ChuyenXe xe2) {
		int tem=xe1.getTenCX().compareToIgnoreCase(xe2.getTenCX());
		if(tem==0) {//trùng tên
			tem=xe1.getSoCX().compareToIgnoreCase(xe2.getSoCX());
				if(tem==0) {
					tem=xe1.getMaCX().compareToIgnoreCase(xe2.getMaCX());
				}
		}
		return tem;
	}
	public void sapXep() {
		Collections.sort(quanLy,new Comparator<ChuyenXe>() {

			@Override
			public int compare(ChuyenXe xe0, ChuyenXe xe1) {
				int tem=xe0.getMaCX().compareToIgnoreCase(xe1.getMaCX());
				if(tem==0) {
					tem=xe0.getTenCX().compareToIgnoreCase(xe1.getTenCX());
				}
				return tem;
			}
				
		});
	}
	
	boolean timCX(String ma) {
		for(int i=0;i<quanLy.size();i++) {
			if(quanLy.get(i).getMaCX().equals(ma)) {
				return true;
			}
		}
		return false;
	}
	ChuyenXe TimCX2(String ma) {
		for(int i=0;i<quanLy.size();i++) {
			if(quanLy.get(i).getMaCX().equals(ma)) {
				return	quanLy.get(i);
			}
		}
		return null;
	}
	void Xoa(String ma) {
		for(int i=0;i<quanLy.size();i++) {
			if(quanLy.get(i).getMaCX().equals(ma)) {
				quanLy.contains(quanLy.remove(i));
			}
		}
	}
	void SuaThongTin(ChuyenXe xe) {
		int index=quanLy.indexOf(xe);
		quanLy.set(index,xe);
	}
	public ArrayList<ChuyenXe> getQuanLy() {
		return quanLy;
	}
	public void setQuanLy(ArrayList<ChuyenXe> quanLy) {
		this.quanLy = quanLy;
	}
	
	
	
}
