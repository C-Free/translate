package tuan7_BTPhongHoc;

public class PhongLyThuyet extends PhongHoc{
	private boolean mayChieu;
	//get va set
	public boolean isMayChieu() {
		return mayChieu;
	}

	public void setMayChieu(boolean mayChieu) {
		this.mayChieu = mayChieu;
	}
	//contructer
	public PhongLyThuyet(String maPhong, String dayNha, float dienTich, float soBongDen,boolean mayChieu) {
		super(maPhong, dayNha, dienTich, soBongDen);
	}
	@Override
	public int PhongDatChuan() {
		if(this.PhongHocDatChuan()==1 && isMayChieu()==true) {
			return 1;
		}
		return 0;		
	}
	//to String

	@Override
	public String toString() {
		String str="";
		int kiemTra=0;
		if(PhongDatChuan()==1) {
			kiemTra=1;
		}
		if(kiemTra==1){
			str+=String.format("%22s","đạt chuẩn");
		}else{
			str+=String.format("%22s","không đạt chuẩn");
		}
		
		return super.toString()+str;
	}
	
	
	

}
