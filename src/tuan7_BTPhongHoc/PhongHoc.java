package tuan7_BTPhongHoc;

public abstract class PhongHoc {
	protected String maPhong;
	protected String dayNha;
	protected float dienTich;
	protected float soBongDen;
	//get va set
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getDayNha() {
		return dayNha;
	}
	public void setDayNha(String dayNha) {
		this.dayNha = dayNha;
	}
	public float getDienTich() {
		return dienTich;
	}
	public void setDienTich(float dienTich) {
		this.dienTich = dienTich;
	}
	public float getSoBongDen() {
		return soBongDen;
	}
	public void setSoBongDen(float soBongDen) {
		this.soBongDen = soBongDen;
	}
	//contructer
	public PhongHoc(String maPhong, String dayNha, float dienTich, float soBongDen) {
		super();
		this.maPhong = maPhong;
		this.dayNha = dayNha;
		this.dienTich = dienTich;
		this.soBongDen = soBongDen;
	}
	//hash code and equal
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maPhong == null) ? 0 : maPhong.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongHoc other = (PhongHoc) obj;
		if (maPhong == null) {
			if (other.maPhong != null)
				return false;
		} else if (!maPhong.equals(other.maPhong))
			return false;
		return true;
	}
	//abstract
	public abstract int PhongDatChuan();
	//to String
	@Override
	public String toString() {
		String str="";
		str+=String.format("%-10s %-10s %2.0f %-3.0f",getMaPhong(),getDayNha(),getDienTich(),getSoBongDen());
		return str;
	}
	//dat chuan phong hoc
	public int PhongHocDatChuan() {
		if(this.getDienTich()/this.getSoBongDen()<=10) {
			return 1;
		}
		return 0;
	}
	
	
	
	
	
}
