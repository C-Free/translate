package tuan7_BTPhongHoc;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GiaoDien {
	public static Scanner scan=new Scanner(System.in);
	static QuanLyPhong quanLy1=new QuanLyPhong();
	public static void nhapCung() {
		PhongMayTinh p1=new PhongMayTinh("17B","C",11,8,5);
		PhongMayTinh p2=new PhongMayTinh("17A","A",51,6,60);
		PhongMayTinh p3=new PhongMayTinh("17C","D",9,9,8);
		PhongThiNghiem n1=new PhongThiNghiem("17Y","A",20,80,"Khoa mắt",30,true);
		PhongLyThuyet t1=new PhongLyThuyet("17D","E",80,10,false);
		quanLy1.them(p1);
		quanLy1.them(p2);
		quanLy1.them(p3);
		quanLy1.them(n1);
		quanLy1.them(t1);
	}
	public static void xuatToanBo(ArrayList<PhongHoc> quanLy) {
		System.out.println();
		System.out.println("========================Phòng lý thuyết=========================");
		tieuDePhongLyThuyet();
		for(PhongHoc i:quanLy) {
			if(i instanceof PhongLyThuyet) {
				System.out.println(i);
			}		
		}
		
		System.out.println();
		System.out.println("========================Phòng thí nghiệm========================");
		tieuDePhongThiNghiem();
		for(PhongHoc i:quanLy) {
			if(i instanceof PhongThiNghiem) {
				System.out.println(i);
			}
		}
		
		System.out.println();
		System.out.println("========================Phòng máy tính==========================");
		tieuDePhongMayTinh();
		for(PhongHoc i:quanLy) {
			if(i instanceof PhongMayTinh) {
				System.out.println(i);
			}
		}
	}
	public static void timKiem() {
		System.out.println("nhập mã phòng cần tìm kiếm:");
		String tk=scan.nextLine();
		int so=quanLy1.timKiemPhong(tk);
		if(so!=0) {
			System.out.println("phòng tìm được");
			System.out.println(quanLy1.quanLy.get(so));
		}else {
			System.out.println("không tìm thấy mã phòng nào");
		}
		
	}
	public static void xuatPhongDatChuan(ArrayList<PhongHoc> quanLy) {
		System.out.println();
		System.out.println("Phòng lý thuyết đạt chuẩn");
		tieuDePhongLyThuyet();
		for(PhongHoc i:quanLy) {
			if(i instanceof PhongLyThuyet) {
				if(i.PhongDatChuan()==1) {
					System.out.println(i);
				}
				
			}		
		}
		
		System.out.println("Phòng thí nghiệm đạt chuẩn");
		tieuDePhongThiNghiem();
		for(PhongHoc i:quanLy) {
			if(i instanceof PhongThiNghiem) {
				if(i.PhongDatChuan()==1) {
					System.out.println(i);
				}
			}
		}
		System.out.println("Phòng máy tính đạt chuẩn");
		tieuDePhongMayTinh();
		for(PhongHoc i:quanLy) {
			if(i instanceof PhongMayTinh) {
				if(i.PhongDatChuan()==1) {
					System.out.println(i);
				}
			}
		}
	}
	public static void capNhapSoLuongMayTinh() {
		System.out.println("nhập mã phòng cần tìm kiếm:");
		scan.nextLine();
		String tk=scan.nextLine();
		int so=quanLy1.timKiemPhong(tk);
		if(so!=0) {
			if(quanLy1.quanLy.get(so) instanceof PhongMayTinh) {
				System.out.println("nhập số lượng máy tính mới:");
				int soLuong=scan.nextInt();
				if(quanLy1.quanLy.get(so).getMaPhong().equals(tk)) {
					((PhongMayTinh)quanLy1.quanLy.get(so)).setSoBongDen(soLuong);
				}
			}else{
				System.out.println("không có phòng máy tính nào");
			}
		}else {
			System.out.println("không tìm thấy mã phòng nào");
		}
	}
	public static void soLuongPhong() {
		System.out.printf("số lượng phòng là:%d\n",quanLy1.tongSoPhong());
	}
	public static void xoaPhong() {
		System.out.println("nhập mã phòng cần xóa:");
		scan.nextLine();
		String tk=scan.nextLine();
		int so=quanLy1.timKiemPhong(tk);
		if(so!=0) {
			System.out.println("phòng tìm được");
			if(quanLy1.quanLy.get(so) instanceof PhongLyThuyet){
				tieuDePhongLyThuyet();
				System.out.println(quanLy1.quanLy.get(so));
			}else if(quanLy1.quanLy.get(so) instanceof PhongMayTinh){
				tieuDePhongMayTinh();
				System.out.println(quanLy1.quanLy.get(so));
			}else if(quanLy1.quanLy.get(so) instanceof PhongThiNghiem){
				tieuDePhongThiNghiem();
				System.out.println(quanLy1.quanLy.get(so));
			}
			
			System.out.println("bạn có chắc muốn xóa(nhập y để xóa):");
			String ok=scan.nextLine();
			if(ok.equals("y")==true) {
				quanLy1.xoaMaPhong(tk);
				System.out.println("xóa thành công");
			}else {
				System.out.println("xóa không thành công");
			}
		}else {
			System.out.println("không tìm thấy mã phòng nào");
		}
		
	}
	public static void PhongCoSauMuoiMay2() {
		System.out.printf("Phòng có hơn 60 máy là:%d\n",quanLy1.PhongSauMuoiMay());
	}
	public static void nhapMem() {
		try {
			System.out.println("nhập mã phòng");
			scan.nextLine();
			String maPhong=scan.nextLine();
			System.out.println("nhập dãy nhà:");
			String dayNha=scan.nextLine();
			System.out.println("nhập diện tích:");
			float dienTich=scan.nextFloat();
			System.out.println("nhập bóng đèn:");
			float bongDen=scan.nextInt();
			System.out.println("1.phòng lý thuyết");
			System.out.println("2.phòng máy tính");
			System.out.println("3.thí nghiệm");
			System.out.println("chọn");
			int chon=scan.nextInt();
			scan.nextLine();
			switch(chon) {
				case 1:
					System.out.println("kiểm tra máy chiếu (nhập 1 nếu có)(nhập 0 nếu không có):");
					int x=scan.nextInt();
					if(x==1 || x==0) {
						boolean flag=false;
						if(x==1)
							flag=true;
						PhongHoc x2=new PhongLyThuyet(maPhong, dayNha, dienTich, bongDen,flag);
						quanLy1.them(x2);
					}
					
					break;
				case 2:
					System.out.println("nhập số lượng máy tính:");
					int x2=scan.nextInt();
					PhongHoc x3=new PhongMayTinh(maPhong, dayNha, dienTich,bongDen,x2);
					quanLy1.them(x3);
					break;
				case 3:
					System.out.println("nhập thông tin phòng học:");
					String thongTin=scan.nextLine();
					System.out.println("nhập số lượng sức chứa:");
					int sucChua=scan.nextInt();
					System.out.println("kiểm tra bồn rửa (nhập 1 nếu có)(nhập 0 nếu không có):");
					int x5=scan.nextInt();
					if(x5==1 || x5==0) {
						boolean flag=false;
						if(x5==1) {
							flag=true;
						}
						PhongHoc x4=new PhongThiNghiem(maPhong, dayNha, dienTich,bongDen, thongTin, sucChua,flag);
						quanLy1.them(x4);
					}
				}
		}catch(InputMismatchException e) {
			System.out.println("lỗi nhập liệu");
		}catch(Exception e) {
			System.out.println("lỗi");
		}
	}
	public static void Menu() {
		System.out.println("----------------------------------------");
		System.out.println("1.Nhập thêm phòng học");
		System.out.println("2.Tìm kiếm phòng học");
		System.out.println("3.In toàn bộ các phòng học");
		System.out.println("4.In phòng đạt chuẩn");
		System.out.println("5.Sắp xếp  giảm dần theo dãy nhà");
		System.out.println("6.Sắp xếp tăng dần theo diện tích");
		System.out.println("7.Sắp xếp tăng dần theo bóng đèn");
		System.out.println("8.Cập nhập số máy tính");
		System.out.println("9.Xóa phòng học");
		System.out.println("10.Tổng số các phòng học");
		System.out.println("11.Phòng có 60 máy");
		System.out.println("12.Thoát");
	}
	public static void tieuDePhongMayTinh() {
		System.out.printf("%-10s %-10s %-2s %-2s %-5s %11s\n","MaPhong","DayNha","DT","SoBongDen","SoLuongMay","tieuChuan");
	}
	public static void tieuDePhongLyThuyet() {
		System.out.printf("%-10s %-10s %-2s %-2s %-5s \n","MaPhong","DayNha","DT","SoBongDen","tieuChuan");
	}
	public static void tieuDePhongThiNghiem() {
		System.out.printf("%-10s %-10s %-2s %-2s %12s %5s %5s\n","MaPhong","DayNha","DT","SoBongDen","ThongTin","SucChua","tieuChuan");
	}
	public static void main(String[] args) {
		nhapCung();
		System.out.println("danh sách phòng nhập sẵn");
		xuatToanBo(quanLy1.quanLy);
		int chon=-1;
		try{
			while(chon!=12) {
				Menu();
				chon=scan.nextInt();
				switch (chon) {
					case 1:
						nhapMem();
						break;
					case 2:
						timKiem();
						break;
					case 3:
						xuatToanBo(quanLy1.quanLy);
						break;
					case 4:
						xuatPhongDatChuan(quanLy1.quanLy);
						break;
					case 5:
						quanLy1.sapXepTheoCotNha();
						System.out.println("phòng sau khi sắp");
						xuatToanBo(quanLy1.quanLy);
						break;
					case 6:
						quanLy1.sapXepTheoDienTich();
						System.out.println("phòng sau khi sắp");
						xuatToanBo(quanLy1.quanLy);
						break;
					case 7:
						quanLy1.sapXepTheoBongDen();
						System.out.println("phòng sau khi sắp");
						xuatToanBo(quanLy1.quanLy);
						break;
					case 8:
						capNhapSoLuongMayTinh();
						break;
					case 9:
						xoaPhong();
						break;
					case 10:
						soLuongPhong();
						break;
					case 11:
						PhongCoSauMuoiMay2();
						break;
					default:
						break;
				}
			}
		}catch(InputMismatchException e){
			System.out.println("lỗi nhập liệu");
		}catch(Exception e){
			System.out.println("lỗi nhập");
		}
	}	
}
