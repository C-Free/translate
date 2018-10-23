package tuan3_BTHangThucPham;


import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class HangThucPham implements Comparable<HangThucPham> {
	private int maHang;
	private String tenHang;
	private float donGia;
	private String ngaySanXuat;
	private String ngayHetHan;
	public int getMaHang() {
		return maHang;
	}
	public void setMaHang(int maHang) {
		this.maHang = maHang;
	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	public String getNgaySanXuat() {
		return ngaySanXuat;
	}
	public void setNgaySanXuat(String ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}
	public String getNgayHetHan() {
		return ngayHetHan;
	}
	public void setNgayHetHan(String ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}
	
	public HangThucPham(int maHang, String tenHang, float donGia, String ngaySanXuat,
			String ngayHetHan) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.donGia = donGia;
		this.ngaySanXuat = ngaySanXuat;
		this.ngayHetHan = ngayHetHan;
	}
	public boolean kiemTraDinhDangNgay(String ngaysX,String ngayhH) {
		boolean flag=false;
		try{
			SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
			sf.parse(ngaysX);
			sf.parse(ngayhH);
			flag=true;
		
		}catch(Exception e) {
			flag=false;
		}
		return flag;
	}
	public boolean kiemTraNgayHetHan() {
		boolean flag=false;
		Date date=new Date();
		String x=date.toString();
		if(getNgaySanXuat().compareTo(x)>0) {
			flag=false;
		}else {
			flag=true;
		}
		return flag;
		
	}
	@Override
	public String toString() {
		String str="";
		Locale locateVN=new Locale("vi","VN");
		NumberFormat en=NumberFormat.getInstance(locateVN);
			str+=String.format("%d %13s %13s %13s %13s %13d",getMaHang(),getTenHang(),en.format(this.getDonGia()),getNgaySanXuat(),getNgayHetHan(),thoiHan());	
		return str;
	}
	public long thoiHan(){
		try{
			SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
			Date x=sf.parse(getNgaySanXuat());
			Date x2=sf.parse(getNgayHetHan());
			long t= ((x2.getTime() - x.getTime())/(24*3600*1000));
			if(t<0) {
				t=0;
			}else {
				return t;
			}
			return t;
		}catch(Exception e) {
			return 0;
		}
	}
	public int compareTo(HangThucPham o) {
		if(this.tenHang.compareTo(o.getTenHang())==0){
			if(this.maHang > o.getMaHang()){
				return 1;
			}else if(this.maHang < o.getMaHang()){
				return -1;
			}else
				return 0;
		}else{
			return this.tenHang.compareTo(o.getTenHang());
		}
	}
	
	
	
}
