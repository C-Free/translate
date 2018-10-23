package tuan2_BTNganHang;


import java.util.ArrayList;
import java.util.Scanner;

public class ThucThiAccount {
	public static QuanLyAccount quanLy=new QuanLyAccount();
	public static Scanner scan=new Scanner(System.in);
	public static void menu() {
		System.out.println("1.nhập thêm tài khoản");
		System.out.println("2.xuất tài khoản");
		System.out.println("3.nạp tiền");
		System.out.println("4.rút tiền");
		System.out.println("5.chuyển");
		System.out.println("6.thoát");
		System.out.println("chọn");
	}
	public static void main(String[] args) {
		nhapCung();
		System.out.println("danh sách đã nhập sẵn");
		System.out.println(tieuDe());
		xuatTK(quanLy.accountList);
		int chon;
		do {
			System.out.println("----------------------------------------");
			menu();
			chon=scan.nextInt();
			switch (chon) {
			case 1:
				quanLy.themAcc(nhap());
				break;
			case 2:
				System.out.println(tieuDe());
				xuatTK(quanLy.accountList);
				break;
			case 3:
				napTien(nhapTKCanTim());
				break;
			case 4:
				rutTien(nhapTKCanTim());
				break;
			case 5:
				chuyenTien(nhapTKCanTim());
				break;
			default:
				break;
			}
		}while(chon!=6);	
	}
	public static void nhapCung() {
		Account2 acc1= new Account2(1,"B",5);
		Account2 acc2= new Account2(4,"A",10);
		Account2 acc3= new Account2(6,"C",7);
		Account2 acc4= new Account2(7,"D",8);
		quanLy.themAcc(acc1);
		quanLy.themAcc(acc2);
		quanLy.themAcc(acc3);
		quanLy.themAcc(acc4);
	}
	
	public static Account2 nhap() 
	{
		System.out.println("Số tài khoản:");
		int sTK =scan.nextInt();
		scan.nextLine();
		System.out.println("Tên tài khoản: ");
		String tTK = scan.nextLine();
		System.out.println("Số tiền trong tài khoản: ");
		double soDu =scan.nextDouble();
		scan.nextLine();
		Account2 acc= new Account2(sTK, tTK, soDu);
		return acc;
	}
	public static int nhapTKCanTim() {
		int tk;
		System.out.println("nhập số tài khoản cần thực hiện");
		tk=scan.nextInt();
		return tk;
	}
	public static void napTien(int tk) {
		int timKiem=quanLy.kiemTraAcc(tk);
		if(timKiem!=0) {
			System.out.println("nhập số tiền cần nạp:");
			long soTien=scan.nextLong();
			quanLy.accountList.get(timKiem).setSoDu(soTien+quanLy.accountList.get(timKiem).getSoDu());
		}else {
			System.out.println("tài khoản không tồn tại");
		}
	}
	public static void rutTien(int tk) {
		int timKiem=quanLy.kiemTraAcc(tk);
		if(timKiem!=0) {
			System.out.println("nhập số tiền cần rút:");
			long soTien=scan.nextLong();
			if(quanLy.accountList.get(timKiem).getSoDu()<soTien) {
				System.out.println("không đủ tiền");
			}else {
				quanLy.accountList.get(timKiem).setSoDu(quanLy.accountList.get(timKiem).getSoDu()-soTien);
			}
			
		}else {
			System.out.println("tài khoản không tồn tại");
		}
	}
	public static void chuyenTien(int tk){
		int timKiem=quanLy.kiemTraAcc(tk);
		if(timKiem!=0) {
			System.out.println("nhập số tài khoản thứ 2 cần chuyển:");
			int tk2=scan.nextInt();
			int timKiem2=quanLy.kiemTraAcc(tk2);
			if(timKiem2!=0) {
				System.out.println("nhập số tiền cần Chuyển:");
				long soTien=scan.nextLong();
				if(quanLy.accountList.get(timKiem).getSoDu()<soTien) {
					System.out.println("không đủ tiền");
				}else {
					quanLy.accountList.get(timKiem).setSoDu(quanLy.accountList.get(timKiem).getSoDu()-soTien);
					quanLy.accountList.get(timKiem2).setSoDu(quanLy.accountList.get(timKiem2).getSoDu()+soTien);
				}
				
			}else {
				System.out.println("tài khoản không tồn tại");
			}
		}else {
			System.out.println("tài khoản không tồn tại");
		}
		
	}
	public static void xuatTK(ArrayList<Account2> quanLy) {
		for(Account2 acc:quanLy) {
			System.out.println(acc);
		}
		
	}
	public static String tieuDe() {
		String str = "";
		str += String.format("%10s%10s%20s","số tK","tên tK","số tiền");
		return str;
	}
	
}
