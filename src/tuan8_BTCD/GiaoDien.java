package tuan8_BTCD;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class GiaoDien {
	public static Scanner scan=new Scanner(System.in);
	static QuanLyCD obd=new QuanLyCD();
	public static void NhapCung() {
		Cidi x1=new Cidi(2,"B","hana",256,10000);
		Cidi x2=new Cidi(4,"A","hbhb",56,24500);
		Cidi x3=new Cidi(1,"D","hdhd",6,10489);
		Cidi x4=new Cidi(3,"C","hchc",342,84500);
		obd.them(x1);
		obd.them(x2);
		obd.them(x3);
		obd.them(x4);
	}
	public static void NhapMem() {
		try {
			System.out.println("nhập mã CD:");
			scan.nextLine();
			int maCD=scan.nextInt();
			System.out.println("nhập tựa CD:");
			String tuaCD=scan.nextLine();
			System.out.println("nhập ca sỹ");
			String caSy=scan.nextLine();
			System.out.println("nhập số bài hát:");
			scan.nextLine();
			int soBaiHat=scan.nextInt();
			System.out.println("nhập giá thành:");
			float giatThanh=scan.nextFloat();
			Cidi x=new Cidi(maCD, tuaCD, caSy, soBaiHat, giatThanh);
			obd.them(x);
		}catch(InputMismatchException e) {
			System.out.println("lỗi nhập liệu");
		}catch(Exception e) {
			System.out.println("lỗi");
		}
	}
	public static void XuatToanBo(ArrayList<Cidi> quanLy2) {
		tieuDe();
		for(Cidi i:quanLy2) {
			System.out.println(i);
		}
	}
	public static void soLuongCDTrongDS() {
		System.out.printf("số lượng cd trong danh sách là:%d",obd.soLuongCD());
	}
	public static void soLuongGiaThanhTrongDS() throws Exception {
		System.out.printf("số lượng giá thành trong danh sách là:%d",obd.tongGiaThanh());
	}
	public static void	tieuDe() {
		System.out.printf("%s %16s %14s %20s %14s\n"
				+ "","mã CD","tựa CD","ca sỹ","số bài hát","giá thành");
	}
	public static void menu() {
		System.out.println("---------------------------------------------------");
		System.out.println("1.nhập thêm CD");
		System.out.println("2.xuất toàn bộ CD");
		System.out.println("3.số lượng CD");
		System.out.println("4.tỗng giá thành CD");
		System.out.println("5.sắp xếp giảm dần theo giá thành");
		System.out.println("6.sắp xếp danh sách tăng dần theo tựa CD");
		System.out.println("7.thoát");
		System.out.println("chọn");
	}
	public static void main(String[] args) {
		NhapCung();
		System.out.println("----------------------danh sách CD-----------------------------");
		XuatToanBo(obd.quanLy);
		int chon=-1;
		try {
			while(chon!=7) {
				menu();
				chon=scan.nextInt();
				switch (chon) {
				case 1:
					NhapMem();
					break;
				case 2:
					XuatToanBo(obd.quanLy);
					break;
				case 3:
					soLuongCDTrongDS();
					break;
				case 4:
					soLuongGiaThanhTrongDS();
					break;
				case 5:
					obd.sapXepGiaThanh();
					XuatToanBo(obd.quanLy);
					break;
				case 6:
					obd.sapXepTuaCD();
					XuatToanBo(obd.quanLy);
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

