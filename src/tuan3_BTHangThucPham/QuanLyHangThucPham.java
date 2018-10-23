package tuan3_BTHangThucPham;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuanLyHangThucPham {
	public static Scanner scan=new Scanner(System.in);
	List<HangThucPham>	accountList = new ArrayList<HangThucPham>();
	
	public List<HangThucPham> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<HangThucPham> accountList) {
		this.accountList = accountList;
	}

	public void them(HangThucPham hang) {
		if(kiemTra(hang.getMaHang())==1) {
			System.out.println("trùng mã hàng");
		}else {
			accountList.add(hang);
		}
	}
	public void xoa(int hang) {
		if(kiemTra(hang)==1) {
			for(int i=0;i<accountList.size();i++) {
				if(accountList.get(i).getMaHang()==hang) {
					accountList.contains(accountList.remove(i));
				}
			}
			System.out.println("xóa thành công");
		}else {
			System.out.println("hàng không tồn tại");
		}
	}
	public void sapXep() {
		Collections.sort(accountList);
	}
	public int kiemTra(int maHang) {
		for(HangThucPham hang:accountList) {
			if(hang.getMaHang()==maHang) {
				return 1;
			}
		}
		return 0;
		
	}
}
