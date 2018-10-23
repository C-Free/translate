package tuan7_BTPhongHoc;

public class PhongMayTinh extends PhongHoc{
	private int mayTinh;
	//get va set

	public int getMayTinh() {
		return mayTinh;
	}

	public void setMayTinh(int mayTinh) {
		this.mayTinh = mayTinh;
	}
	//contructer

	public PhongMayTinh(String maPhong, String dayNha, float dienTich, float soBongDen,int mayTinh) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.mayTinh=mayTinh;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int PhongDatChuan() {
		if(this.PhongHocDatChuan()==1 && (this.getDienTich()/this.getMayTinh())>1.5) {
			return 1;
			
		}
		return 0;
	}
	//to String

	@Override
	public String toString() {
		String str="";
		int kiemTra=0;
		if(this.PhongDatChuan()==1) {
			kiemTra=1;
		}
		if(kiemTra==1){
			str+=String.format("%9d %19s",getMayTinh(),"đạt chuẩn");
		}else{
			str+=String.format("%9d %25s",getMayTinh(),"không đạt chuẩn");
		}
		
		return super.toString()+str;
	}
	
	
	

}
