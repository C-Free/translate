package tuan7_BTPhongHoc;
public class PhongThiNghiem extends PhongHoc{
	private String thongTinChuyenNganh;
	private float sucChua;
	private boolean bonRua;
	
	public String getThongTinChuyenNganh() {
		return thongTinChuyenNganh;
	}

	public void setThongTinChuyenNganh(String thongTinChuyenNganh) {
		this.thongTinChuyenNganh = thongTinChuyenNganh;
	}

	public float getSucChua() {
		return sucChua;
	}

	public void setSucChua(float sucChua) {
		this.sucChua = sucChua;
	}

	public boolean isBonRua() {
		return bonRua;
	}

	public void setBonRua(boolean bonRua) {
		this.bonRua = bonRua;
	}
	
	public PhongThiNghiem(String maPhong, String dayNha, float dienTich, float soBongDen,String thongTin,float sucChua,boolean bonRua) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.thongTinChuyenNganh=thongTin;
		this.sucChua=sucChua;
		this.bonRua=bonRua;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int PhongDatChuan() {
		if(this.PhongHocDatChuan()==1 && isBonRua()==true) {
			return 1;
		}
		return 0;
	}
	//to String
	@Override
	public String toString() {
		int kiemTra=0;
		String str="";
		if(PhongDatChuan()==1) {
			kiemTra=1;
		}
		if(kiemTra==1){
			str+=String.format("%19s %2.0f %14s",getThongTinChuyenNganh(),getSucChua(),"đạt chuẩn");
		}else{
			str+=String.format("%19s %2.0f %14s",getThongTinChuyenNganh(),getSucChua(),"không đạt chuẩn");
		}
		return super.toString()+str;
	}

	
	
}
