package tuan2_BTVehicle;

import java.util.ArrayList;
import java.util.Scanner;


public class ThucHienVehicle {
	public static Scanner scan=new Scanner(System.in);
	static QuanLyVehicle quanLy=new QuanLyVehicle();
	public static void main(String[] args) {
		NhapCung();
		System.out.println("danh sách đã nhập sẵn");
		System.out.println(TieuDe());
		xuat(quanLy.vehicleList);
		int chon;
		do {
			Show();
			chon=scan.nextInt();
			switch (chon) {
			case 1:
				quanLy.add(Nhap());
				break;
			case 2:
				System.out.println(TieuDe());
				xuat(quanLy.vehicleList);
				break;
			default:
				break;
			}
		}while(chon!=3);

	}
	public static void xuat(ArrayList<Vehicle> quanLy) {
		for(Vehicle xe:quanLy) {
			xe.kiemTra();
			System.out.println(xe);
		}
	}
	public static String TieuDe() {
		String str="";
		str+=String.format("%10s %10s %10s %10s %10s","tên chủ","tên xe","dung tich","giá","thuế");
		return str;
	}
	public static void Show() {
		System.out.println("1.nhập xe");
		System.out.println("2.xuất xe");
		System.out.println("3.thoát");
	}
	public static void NhapCung() {
		Vehicle xe1=new Vehicle("B","SH",10,15,20);
		Vehicle xe2=new Vehicle("C","CH",1,30,50);
		Vehicle xe3=new Vehicle("D","cT",9,5,7);
		quanLy.add(xe1);
		quanLy.add(xe2);
		quanLy.add(xe3);
		
	}
	public static  Vehicle Nhap() {
		scan.nextLine();
		System.out.println("nhập tên chủ xe");
		String a=scan.nextLine();
		System.out.println("nhập loại xe");
		String b=scan.nextLine();
		System.out.println("nhập dung tich");
		float c=Integer.parseInt(scan.nextLine());
		System.out.println("nhập trị giá");
		float d=Integer.parseInt(scan.nextLine());
		float e=0;
		Vehicle xe1=new Vehicle(a,b,c,d,e);
		return xe1;
	}
}
