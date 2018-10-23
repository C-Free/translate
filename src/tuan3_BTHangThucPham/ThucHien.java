package tuan3_BTHangThucPham;

import java.util.Scanner;

public class ThucHien {
	public static Scanner scan=new Scanner(System.in);
	static HangThucPham hang;
	public static void main(String[] args) {
		QuanLyHangThucPham quanLy=new QuanLyHangThucPham();
		HangThucPham hang1= new HangThucPham(1,"B",100000,"06/09/2016", "09/06/2015");
		HangThucPham hang2= new HangThucPham(2,"A",100000,"07/08/2016", "09/06/2017");
		quanLy.them(hang1);
		quanLy.them(hang2);
		System.out.println("danh sách hàng đã nhập sẵn");
		System.out.println(tieuDe());
		xuat(quanLy);
		int chon=0;
		do {
			menu();
			chon=scan.nextInt();
			switch (chon) {
			case 1:
				hang=nhap();
				if(hang.kiemTraDinhDangNgay(hang.getNgaySanXuat(),hang.getNgayHetHan())==true) {
					quanLy.them(hang);
				}else {
					System.out.println("lỗi");
				}
				break;
			case 2:
				System.out.println(tieuDe());
				xuat(quanLy);
				break;
			case 3:
				System.out.println("nhập mã hàng cần xóa:");
				int maHang=scan.nextInt();
				quanLy.xoa(maHang);
				System.out.println(tieuDe());
				xuat(quanLy);
				break;
			case 4:
				quanLy.sapXep();
				System.out.println(tieuDe());
				xuat(quanLy);
				break;
			default:
				break;
			}
			
		}while(chon!=5);
	}
	public static String tieuDe() {
		String str="";
		str+=String.format("%s %13s %10s %12s %12s %13s","MaHang","TenHang","getDonGia","NgaySanXuat","NgayHetHan","hạn sử dụng");	
		return str;
	}
	public static void menu() {
		System.out.println("--------------------------------------");
		System.out.println("1.nhập thêm mã hàng");
		System.out.println("2.xuất các mặt hàng và hạn sử dụng");
		System.out.println("3.xóa mặt hàng");
		System.out.println("4.sắp xếp lại theo tên hàng");
		System.out.println("5.thoát");
		System.out.println("chọn");
		
	}
	public static HangThucPham nhap() {
		System.out.println("nhập mã hàng (nhập số):");
		int maHang=scan.nextInt();
		scan.nextLine();
		System.out.println("nhập tên hàng:");
		String tenHang=scan.nextLine();
		System.out.println("nhập đơn giá:");
		float donGia=scan.nextFloat();
		scan.nextLine();
		System.out.println("nhập ngày sản xuất(dd/mm/yyyy):");
		String ngaySX=scan.nextLine();
		System.out.println("nhập ngày hết hạn(dd/mm/yyyy):");
		String ngayhH=scan.nextLine();
		hang=new HangThucPham(maHang, tenHang, donGia, ngaySX, ngayhH);
		hang.kiemTraDinhDangNgay(ngaySX,ngayhH);
		return hang;	
	}
	public static void xuat(QuanLyHangThucPham x) {
		for(int i=0;i<x.accountList.size();i++) {
			System.out.println(x.accountList.get(i));
		}	
	}
}
