package tuan4_BTChuyenXe;

public class NgoaiThanh extends ChuyenXe{
	private String noiDen;
	private int songay;
	public String getNoiDen() {
		return noiDen;
	}
	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}
	public int getSongay() {
		return songay;
	}
	public void setSongay(int songay) {
		this.songay = songay;
	}
	
	public NgoaiThanh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NgoaiThanh(String maCX, String tenCX, String soCX, double doanhThu,String noiDen,int songay) {
		super(maCX, tenCX, soCX, doanhThu);
		this.noiDen=noiDen;
		this.songay=songay;
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		String str="";
		str=String.format("%-10s%10d",getNoiDen(),getSongay());
		return super.toString()+str;
		//return super.toString()+"NgoaiThanh [noiDen=" + noiDen + ", songay=" + songay + "]";
	}
	
}
