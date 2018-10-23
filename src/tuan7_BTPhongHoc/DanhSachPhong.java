package tuan7_BTPhongHoc;
import java.util.ArrayList;

public interface DanhSachPhong {
	public boolean them(PhongHoc o);
	public ArrayList<PhongHoc> getAllPhong();
	public ArrayList<PhongHoc> getQuanLy() ;
	public void setQuanLy(ArrayList<PhongHoc> quanLy) ;
	public int timKiemPhong(String o);
	public void sapXepTheoCotNha();
	public void sapXepTheoDienTich() ;
	public void sapXepTheoBongDen();
	public boolean xoaMaPhong(String maPhong);
	public int  tongSoPhong();
	public int PhongSauMuoiMay();
}
