package tuan8_BTCD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuanLyCD {
	ArrayList<Cidi> quanLy=new ArrayList<Cidi>();

	public ArrayList<Cidi> getQuanLy() {
		return quanLy;
	}

	public void setQuanLy(ArrayList<Cidi> quanLy) {
		this.quanLy = quanLy;
	}
	//them
	public boolean them(Cidi x) {
		if(quanLy.contains(x)!=true) {
			quanLy.add(x);
			return true;
		}
		return false;
	}
	//so luong cd
	public int soLuongCD() {
		int tong=0;
		for(int i=0;i<quanLy.size();i++) {
			tong++;
		}
		return tong;
	}
	//tong gia thanh cac cd
	public int tongGiaThanh() throws Exception {
		int tong=0;
		for(int i=0;i<quanLy.size();i++) {
			tong+=quanLy.get(i).getGiatThanh();
		}
		return tong;
	}
	//sap xep giam theo gia thanh
	public void sapXepGiaThanh() {
		Collections.sort(quanLy,new Comparator<Cidi>() {

			@Override
			public int compare(Cidi x1, Cidi x2) {
				if(x1.getGiatThanh()>x2.getGiatThanh()) {
					return -1;
				}else if(x1.getGiatThanh()<x2.getGiatThanh()) {
					return 1;
				}else{
					return 0;
				}
			}
		});
	}
	public void sapXepTuaCD() {
		Collections.sort(quanLy,new Comparator<Cidi>() {

			@Override
			public int compare(Cidi arg0, Cidi arg1) {
				int temp=arg0.getTuaCD().compareTo(arg1.getTuaCD());
				return temp;
			}
		});
	}
}
