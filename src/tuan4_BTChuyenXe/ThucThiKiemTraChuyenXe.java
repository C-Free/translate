package tuan4_BTChuyenXe;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ThucThiKiemTraChuyenXe {
	public static DanhSachChuyenXe ObjD=new DanhSachChuyenXe();
	public static Scanner scan=new Scanner(System.in);
	static String TieuDe() {
		String str="";
		str = String.format("%-10s%-15s%-15s%-20s%-10s%10s","MaCX()","TenCX()", "SoCX()","DoanhThu()","SoTuyen()","SoKm");
		return str;
	}
	
	static void Menu() {
		System.out.println("1.Nhập chuyến xe");
		System.out.println("2.Xuất chuyến xe");
		System.out.println("3.xóa xe");
		System.out.println("4.sửa chuyến xe");
		System.out.println("5.tổng doanh thu ngoại thành và nội thành");
		System.out.println("6.sắp xếp");
		System.out.println("thoát");
	}
	static void sapXep() {
		ObjD.sapXep();
	}
	static void xuatTongDoanhThu() {
		double tong=0;
		double tong2=0;
		for(ChuyenXe xe:ObjD.quanLy) {
			if(xe instanceof NoiThanh) {
				tong+=xe.getDoanhThu();
			}
			if(xe instanceof NgoaiThanh) {
				tong2+=xe.getDoanhThu();
			}
		}
		
		System.out.println("nội thành:"+tong);
		System.out.println("ngoại thành:"+tong2);
	}
	static void XoaXe() {
		String maX;
		String sure;
		System.out.println("nhập mã xe cần xóa");
		scan.nextLine();
		maX=scan.nextLine();
		if(ObjD.timCX(maX)==true) {
			System.out.println("bạn có chắc chắn muốn xóa không:");
			System.out.println("nhập y để xóa");
			sure=scan.nextLine();
			if(sure.equals("y")==true) {
				ObjD.Xoa(maX);
				System.out.println("xóa thành công");
				System.out.println(TieuDe());
				Xuat(ObjD.quanLy);
			}
		}
	}
	static void NhapCung() {
		ChuyenXe xe1=new NoiThanh("B","A","T",86540,"hai",7);
		ChuyenXe xe2=new NoiThanh("A","C","Y",150000,"bay",8);
		ChuyenXe xe3=new NgoaiThanh("16A","B","A",100000,"ca mau",10);
		ChuyenXe xe4=new NgoaiThanh("15A","B","B",100000,"ho chi minh",10);
		ChuyenXe xe5=new NoiThanh("13A","E","C",240000,"vinh ha long",6);
		ChuyenXe xe6=new NoiThanh("12A","E","D",240000,"mien dong",6);
		ObjD.Them(xe1);
		ObjD.Them(xe2);
		ObjD.Them(xe3);
		ObjD.Them(xe4);
		ObjD.Them(xe5);
		ObjD.Them(xe6);
		
	}
	@SuppressWarnings("finally")
	static ChuyenXe NhapMem() {
		ChuyenXe xe=null;
		String MaCX,TenCX,SoCX;
		String noiDen;
		int songay;
		String soTuyen;
		double soKm;
		double DoanhThu;
		int chon=-1;
		scan.nextLine();
		System.out.println("nhập mã chuyến xe:");
		MaCX=scan.nextLine();
		System.out.println("nhập tên chuyến xe:");
		TenCX=scan.nextLine();
		System.out.println("nhập số chuyến xe:");
		SoCX=scan.nextLine();
		System.out.println("nhập doanh thu:");
		DoanhThu=scan.nextDouble();
		try {
			System.out.println("chọn loại xe muốn nhập");
			System.out.println("Nhập 1 nếu muốn thêm xe ngoại thành");
			System.out.println("Nhập 2 nếu muốn thêm xe nội thành");
			chon=scan.nextInt();
			scan.nextLine();
			switch (chon) {
				case 1:
					System.out.println("nhập nơi đến:");
					noiDen=scan.nextLine();
					System.out.println("Nhập số ngày đi được:");
					songay=scan.nextInt();
					scan.nextLine();
					xe=new NgoaiThanh(MaCX,TenCX,SoCX,DoanhThu, noiDen, songay);
					break;
				case 2:
					System.out.println("nhập số tuyến:");
					soTuyen=scan.nextLine();
					System.out.println("Nhập số Km đi được:");
					soKm=scan.nextDouble();
					scan.nextLine();
					xe=new NoiThanh(MaCX, TenCX, SoCX, DoanhThu, soTuyen, soKm);
					break;
				default:
					break;
			}
		}catch(InputMismatchException e){
			System.out.println("lỗi nhập liệu");
		}catch(Exception e) {
			System.out.println("lỗi thông tin");
		}finally {
			return xe;
		}
		
	}
	static void Xuat(ArrayList<ChuyenXe> quanLy) {
		System.out.println("Chuyến xe nội thành:");
		System.out.println(TieuDe());
		for(ChuyenXe xe:quanLy) {
			if(xe instanceof NoiThanh) {
				System.out.println(xe);
			}
		}
		System.out.println("Chuyến xe ngoại thành:");
		System.out.println(TieuDe());
		for(ChuyenXe xe:quanLy) {
			if(xe instanceof NgoaiThanh) {
				System.out.println(xe);
			}
		}
	}
	public static void SuaThongTin() {
		ChuyenXe xe=null;
		String MaCX,SoCX;
		String TenCX="";
		scan.nextLine();
		System.out.println("nhập mã chuyến xe cần sửa:");
		MaCX=scan.nextLine();
		try {
			if(ObjD.TimCX2(MaCX)!=null) {
				xe=ObjD.TimCX2(MaCX);
				System.out.println(TieuDe());
				System.out.println(xe);
				System.out.println("nhập tên chuyến xe:");
				TenCX=scan.nextLine();
				System.out.println("nhập số chuyến xe:");
				SoCX=scan.nextLine();
				xe.setTenCX(TenCX);
				xe.setSoCX(SoCX);
				ObjD.SuaThongTin(xe);
				System.out.println("sửa thành công");
			}else {
				System.out.println("không tìm thấy");
			}
		}catch(InputMismatchException e){
			System.out.println("lỗi nhập liệu");
		}catch(Exception e) {
			System.out.println("lỗi");
		}	
	}
	public static void main(String[] args) {
		int chon=-1;
		NhapCung();
		//System.out.println(TieuDe());
		Xuat(ObjD.quanLy);
		try {
			while(chon!=7) {
				
				Menu();
				chon=scan.nextInt();
				switch (chon) {
				case 1:
					ChuyenXe xe=NhapMem();
					if(xe==null) {
						System.out.println("không thành công");
					}else {
						if(ObjD.Them(xe)==true) {
							System.out.println("thêm thành công");
						}else {
							System.out.println("trùng mã xe");
						}
					}
					break;
				case 2:
					System.out.println(TieuDe());
					Xuat(ObjD.quanLy);
					break;
				case 3:
					XoaXe();
					break;
				case 4:
					SuaThongTin();
					break;
				case 5:
					xuatTongDoanhThu();
					break;
				case 6:
					sapXep();
					Xuat(ObjD.quanLy);
					break;
				default:
					break;
				}
			}		
		}catch(InputMismatchException e) {
			System.out.println("lỗi nhập liệu");
		}catch(Exception e) {
			System.out.println("lỗi");
		}
	}
}
		


