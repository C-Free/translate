package tuan1_BaiSinhVien;

public class SinhVien {
	private String ma, hoten;
	private float diemLyThuyet,diemThucHanh;
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public float getDiemLyThuyet() {
		return diemLyThuyet;
	}

	public void setDiemLyThuyet(float diemLyThuyet) {
		this.diemLyThuyet = diemLyThuyet;
	}

	public float getDiemThucHanh() {
		return diemThucHanh;
	}

	public void setDiemThucHanh(float diemThucHanh) {
		this.diemThucHanh = diemThucHanh;
	}

	public SinhVien(String ma, String hoten, float diemLyThuyet, float diemThucHanh) {
		super();
		this.ma = ma;
		this.hoten = hoten;
		this.diemLyThuyet = diemLyThuyet;
		this.diemThucHanh = diemThucHanh;
	}
	public SinhVien() {
		super();
	}

	public float diemTrungBinh () {

		float tb = (this.getDiemLyThuyet()+this.getDiemThucHanh() )/2;

		return tb ;

	}
	public String toString() {
		String str = "";
		str = String.format( "%8s%30s%10.2f%10.2f%10.2f", getMa(), getHoten(),getDiemLyThuyet(),getDiemThucHanh(),diemTrungBinh());
		return str;
	}
}
