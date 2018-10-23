package tuan1_BTHinhChuNhat;

public class HinhChuNhat {
	public int cDai;
	public int cRong;
	// get dai
	public int getcDai() {
		return cDai;
	}
	public void setcDai(int cDai) {
		this.cDai = cDai;
	}
	
	// get rong
	public int getcRong() {
		return cRong;
	}
	public void setcRong(int cRong) {
		this.cRong = cRong;
	}
	// coustructor
	public HinhChuNhat(int cDai, int cRong) {
	
		this.cDai = cDai;
		this.cRong = cRong;
	}
	public HinhChuNhat() {
		super();
	}
	//cv
	public float cVi ()
	{
		float cv = ( this.getcDai() + this.cRong ) *2 ;
		return cv ;
	}
	public float dTich()
	{
		float dt = ( this.cDai* this.cRong);
		return dt;
	}
	
	public String toString() {
		return  String.format(" %10d%10d%20.1f%10.1f  ",getcDai(), getcRong(), cVi(), dTich() );
	}
}
