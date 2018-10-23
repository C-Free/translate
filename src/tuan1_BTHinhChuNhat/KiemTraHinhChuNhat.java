package tuan1_BTHinhChuNhat;

import java.util.Scanner;

public class KiemTraHinhChuNhat {
	public static Scanner sc = new Scanner(System.in);
	public static int nhap ( String x )
	{
		int y;
		System.out.println(x);
		y = sc.nextInt();
		return y;
	}
	private static String tieuDe ()
	{
		return  String.format("%10s%10s%20s%10s", "   Chiều dài ", "Chiều rộng", " Chu vi", "  Diện tích");
	}
	public static void main(String[] args) {

		int cdai, crong;
		cdai = nhap("Nhập chiều dai của hinh: ");
		crong = nhap ("Nhập chiều rông của hình: ");
		HinhChuNhat hcn = new  HinhChuNhat();
		hcn.setcDai(cdai);
		hcn.setcRong(crong);
		HinhChuNhat hcn1 = new HinhChuNhat(5, 6);
		HinhChuNhat hcn2 = new HinhChuNhat(7, 5);
		System.out.println(tieuDe());
		System.out.println(hcn);
		System.out.println(hcn1);
		System.out.println(hcn2);
	}


}
