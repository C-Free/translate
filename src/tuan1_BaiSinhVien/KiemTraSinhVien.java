package tuan1_BaiSinhVien;

import java.util.Scanner;

public class KiemTraSinhVien {
	static Scanner sc = new Scanner(System.in);
	static String nhapChuoi( String s ) {
		String m;
		System.out.println(s);
		m = sc.nextLine();
		return m;
	}
	private static String tieuDe() {
		String str = "";
		str = String.format("%8s%30s%10s%10s%10s", "Mã","Họ Tên", "Lý Thuyêt", "Thục Hành", "Điểm trung bình");
		return str;

	}

	public static void main(String[] args) {
		String hoTen = "", ma = "";
		ma =nhapChuoi("Nhập Mã");
		hoTen = nhapChuoi("Nhập vào họ tên");
		System.out.println("nhập điểm lý thuyết:");
		float LT=sc.nextFloat();
		System.out.println("nhập điểm thực hành:");
		float tH=sc.nextFloat();
		SinhVien sv1=new SinhVien(ma, hoTen,LT, tH);
		SinhVien sv2 = new SinhVien("69","quân",8,9);
		SinhVien sv3 = new SinhVien("222", "sơn", 5, 6);
		System.out.println(tieuDe());
		System.out.println(sv1);
		System.out.println(sv2);
		System.out.println(sv3);
	}
}
