package tuan5_BTSach;

import java.text.NumberFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class SachGiaoKhoa extends Sach{
	protected boolean tinhTrangSach;

	public boolean isTinhTrangSach() {
		return tinhTrangSach;
	}

	public void setTinhTrangSach(boolean tinhTrangSach) {
		this.tinhTrangSach = tinhTrangSach;
	}

	public SachGiaoKhoa(String maS, String nhaSX, String tenSach, int soLuong, double donGia,
			GregorianCalendar ngayNhap, boolean tinhTrangSach) {
		super(maS, nhaSX, tenSach, soLuong, donGia, ngayNhap);
		this.tinhTrangSach = tinhTrangSach;
	}

	@Override
	double thanhtien() {
		if ( tinhTrangSach == true )
			return donGia*soLuong;
		else
			return donGia*soLuong*0.5;
	}
	@Override
	public String toString() {
		Locale locale = new Locale("vi", "vn");
		NumberFormat format = NumberFormat.getNumberInstance(locale);
		String str ="";
		if ( tinhTrangSach == true)
			str= "mới";
		else
			str = " cũ";
		return super.toString()+ String.format( str + "\t%s", format.format(thanhtien()));
	}
}
