package tuan5_BTSach;

import java.text.NumberFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class SachThamKhao extends Sach{
	protected final double THUE = 0.5;
	@Override
	double thanhtien() {

		return donGia*soLuong*THUE;
	}
	public SachThamKhao(String maS, String nhaSX, String tenSach, int soLuong, double donGia,
			GregorianCalendar ngayNhap) {
		super(maS, nhaSX, tenSach, soLuong, donGia, ngayNhap);
	}
	@Override
	public String toString() {
		Locale  locale = new Locale("vi", "vn");
		NumberFormat format = NumberFormat.getNumberInstance(locale);
		return super.toString()+ String.format("%s", format.format(thanhtien()));
	}
}
