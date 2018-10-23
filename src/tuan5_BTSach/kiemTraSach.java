package tuan5_BTSach;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class kiemTraSach {
	static Scanner input = new Scanner(System.in);
	static DanhSachSach obj = new DanhSachSach();
	public static void xuatDanhSach()
	{

		System.out.println(" >>> Sách Giáo KHoa <<<");
		System.out.println(tieu_de1());
		for ( Sach sachM : obj.ds  )
		{
			if( sachM instanceof SachGiaoKhoa )
			{
				System.out.println(sachM);
			}
		}
		System.out.println(" >>> Sách Tham Khảo <<<");
		System.out.println(tieu_de2());
		for ( Sach sachM : obj.ds  )
		{
			if ( sachM instanceof SachThamKhao)
			{
				System.out.println(sachM);
			}
		}

	}

	public static void nhapcung ()
	{

		GregorianCalendar ngay1= new GregorianCalendar(2017, 6, 2);
		Sach s0 = new SachGiaoKhoa("1", "hoa hong", " lan", 1, 100000, ngay1, true);
		obj.themSach(s0);
		Sach s1 = new SachGiaoKhoa("3", "hoa hong", " cúc", 1, 100000, ngay1, true);
		obj.themSach(s1);
		Sach s2 = new SachGiaoKhoa("2", "hoa hong",  "lan", 1, 100000, ngay1, false);
		obj.themSach(s2);
		Sach s3 = new SachThamKhao("4", "hoa lan", "hong", 2, 100000, ngay1);
		obj.themSach(s3);
		Sach s4 = new SachThamKhao("5", "hoa lan", "canh", 2, 150000, ngay1);
		obj.themSach(s4);
	}
	public static Sach nhapThongTin() throws ParseException{
		String maS,nhaSX, tenSach,ngayNhap, tinhtrangsach,moi="moi";
		int soLuong, chon;
		double donGia;
		Sach sachM = null;
		
		System.out.println(" Nhập mã Sách");
		maS=  input.nextLine();
		System.out.println(" Nhập nhà sản xuất");
		nhaSX = input.nextLine();
		System.out.println(" Nhập Tên Sach");
		tenSach = input.nextLine();
		System.out.println(" Nhập Ngày nhập");
		ngayNhap = input.nextLine();
		System.out.println(" Nhập số lượng");
		soLuong= input.nextInt();
		System.out.println(" NHập Đơn Giá");
		donGia = input.nextDouble();

		GregorianCalendar ngayDN = new GregorianCalendar();
		SimpleDateFormat ff= new SimpleDateFormat("dd/mm/yyyy");
		ngayDN.setTime(ff.parse(ngayNhap));
		System.out.println(" 1.Nhập sách GIáo Khoa");
		System.out.println("2. Nhập sách tham khảo");
		System.out.println(">>> Chosse <<<");
		chon= input.nextInt();
		switch (chon) {
		case 1:
			System.out.println("Nhập tình trạng sách");
			System.out.println("Sách mới---- SÁCH CŨ");
			input.nextLine();
			tinhtrangsach = input.nextLine();
			{
				if ( tinhtrangsach.equalsIgnoreCase(moi) )
					sachM = new SachGiaoKhoa(maS, nhaSX, tenSach, soLuong, donGia, ngayDN, true);
				else 
					sachM = new SachGiaoKhoa(maS, nhaSX, tenSach, soLuong, donGia, ngayDN, false);
			}
			break;
		case 2:
			sachM = new SachThamKhao(maS, nhaSX, tenSach, soLuong, donGia, ngayDN);

		}

		return sachM;



	}

	public static void tinhtong()
	{
		double tong = 0, tong1= 0, tong2=0;
		Locale lacale = new Locale("vi", "vn");
		NumberFormat format =  NumberFormat.getCurrencyInstance(lacale);
		for (Sach sachM: obj.ds) {
			if(sachM instanceof SachGiaoKhoa)
			{
				if(((SachGiaoKhoa) sachM).tinhTrangSach == true)
					tong1 += ((SachGiaoKhoa) sachM).thanhtien();
				else
					tong2+= ((SachGiaoKhoa) sachM).thanhtien();
			}
			else
				tong+=((SachThamKhao) sachM).thanhtien();
		}
		System.out.println(" sách giáo khoa cũ " +"\t"+ format.format(tong1));
		System.out.println(" sách giáo khoa mới" +"\t"+ format.format(tong2));
		System.out.println(" sách tham Khảo " +"\t"+ format.format(tong));

	}
	public static void TbCong()
	{
		double tb = 0, tong=0, dem= 0;
		Locale locale = new Locale("vi", "vn");
		NumberFormat format =  NumberFormat.getNumberInstance(locale);
		for (Sach sachM : obj.ds) {
			if ( sachM instanceof SachThamKhao )
			{
				tong += sachM.donGia;
				dem ++;
			}
			tb= tong/dem;
		} 
		System.out.println(" Trung bình công STK: " + format.format(tb));
	}
	//	public static void  timsach() {
	//		sach sachTim;
	//		String maS,nhaSX;
	//		Scanner input = new Scanner(System.in);
	//		System.out.println("Nhâp mã sách");
	//		input.nextLine();
	//		maS= input.nextLine();
	//		sachTim = obj.timSach(maS);
	//
	//		if( sachTim instanceof sachGiaoKhoa )
	//		{
	//			System.out.println(tieu_de1());
	//			System.out.println(sachTim);
	//			System.out.println("\n");
	//		}
	//		else if ( sachTim instanceof sachThamKhao)
	//		{
	//			System.out.println(tieu_de2());
	//			System.out.println(sachTim);
	//			System.out.println("\n");
	//		}
	//
	//	}

	public static void xoaSach (String maS)
	{
		if( obj.delete(maS)== false )
			System.out.println("Không tìm thấy mã cần xóa");

	}

	public static String tieu_de1()
	{
		return String.format ("%s\t %s\t %s\t %s\t %s\t %s\t %s" , "Mã sách"," Nhà suât bản"," Tên sách","Số Lượng","Dơn gia","Ngay Nhap","Lọai sách Thành tiền" );

	}
	public static String tieu_de2()
	{
		return String.format ("%s\t %s\t %s\t %s\t %s\t %s\t %s" , "Mã sách"," Nhà suât bản"," Tên sách","Số Lượng","Dơn gia","Ngay Nhap","Thành tiền");

	}
	public static void main(String[] args) throws ParseException {
		int a;
		Sach sachTim;
		String maS,nhaSX;
		nhapcung();
		xuatDanhSach();
		do
		{
			System.out.println("******** MENU ********");
			System.out.println("1. Thêm sách mới");
			System.out.println("2. Tìm sách");
			System.out.println("3. Xuất danh sách");
			System.out.println("4. Tính tổng");
			System.out.println("5. xoa sach");
			System.out.println("6. sắp xếp");
			System.out.println("7. Xuất ra các sách giáo khoa của nhà xuất bản X");
			System.out.println("8. Trung bình cộng đơn giá của các sách tham khảo");
			System.out.println(">>> Thực hiên yêu cầu <<<<");
			System.out.println("*******************************************");
			a= input.nextInt();
			switch (a) {
			case 1:
				obj.themSach(nhapThongTin());

				break;
			case 2:
				//timsach();
				System.out.println("Nhâp mã sách");
				input.nextLine();
				maS= input.nextLine();
				sachTim = obj.timSach(maS);

				if( sachTim instanceof SachGiaoKhoa )
				{
					System.out.println(tieu_de1());
					System.out.println(sachTim);
					System.out.println("\n");
				}
				else if ( sachTim instanceof SachThamKhao)
				{
					System.out.println(tieu_de2());
					System.out.println(sachTim);
					System.out.println("\n");
				}
				break;
			case 3:
				xuatDanhSach();
				break;
			case 4:
				tinhtong();
				break;
			case 5:
				int chosse;
				System.out.println(" Nhập mã sach");
				input.nextLine();
				maS = input.nextLine();
				System.out.println(" Bạn có muốn xóa Thông tin sách >>> 1/có >>> 2/Không");
				chosse = input.nextInt();
				if (chosse ==1)
				{
					xoaSach(maS);
					System.out.println(">>>> Xóa Thành Công <<<<");
				}
				else if (chosse == 2)
					System.out.println(">>>> Hẹn Gặp lại <<<<");

				break;
			case 6:
				obj.sapXep();
				break;
			case 7:
				System.out.println("Nhâp tên nhà sả	n xuất cần tìm");
				input.nextLine();
				nhaSX= input.nextLine();

				for (Sach sachTim1 : obj.ds) {
					if( sachTim1 instanceof SachGiaoKhoa )
					{
						if(sachTim1.nhaSX.equals(nhaSX))
						{
							System.out.println(tieu_de1());
							System.out.println(sachTim1);
							System.out.println("\n");
						}
					}
					else if ( sachTim1 instanceof SachThamKhao)
					{
						if(sachTim1.nhaSX.equals(nhaSX))
						{
							System.out.println(tieu_de2());
							System.out.println(sachTim1);
							System.out.println("\n");
						}
					}

				}
				break;
			case 8:
				TbCong();
				break;
			default:
				System.out.println(">>>> Nhập sai<<<<");
				break;
			}

		}while (a!=9);






	}
}
