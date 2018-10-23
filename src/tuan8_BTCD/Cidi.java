package tuan8_BTCD;

public class Cidi {
	private int maCD;
	private String TuaCD;
	private String caSy;
	private int soBaiHat;
	private float GiatThanh;
	//get
	public int getMaCD() {
		return maCD;
	}
	public void setMaCD(int maCD) {
		this.maCD = maCD;
	}
	public String getTuaCD() {
		return TuaCD;
	}
	public void setTuaCD(String tuaCD) {
		TuaCD = tuaCD;
	}
	public String getCaSy() {
		return caSy;
	}
	public void setCaSy(String caSy) {
		this.caSy = caSy;
	}
	public int getSoBaiHat() {
		return soBaiHat;
	}
	public void setSoBaiHat(int soBaiHat) throws Exception {
		if(soBaiHat>0) {
			this.soBaiHat = soBaiHat;
		}else {
			throw new Exception("số bài hát phải lớn hơn 0"); 
		}
		
	}
	public float getGiatThanh() {
		return GiatThanh;
	}
	public void setGiatThanh(float giatThanh) throws Exception {
		if(giatThanh>0) {
			this.GiatThanh = giatThanh;
		}else {
			throw new Exception("số bài hát phải lớn hơn 0"); 
		}
		
	}
	public Cidi(int maCD, String tuaCD, String caSy, int soBaiHat, float giatThanh) {
		super();
		this.maCD = maCD;
		TuaCD = tuaCD;
		this.caSy = caSy;
		this.soBaiHat = soBaiHat;
		GiatThanh = giatThanh;
	}
	public Cidi() {
		super();
	}
	//hash
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maCD;
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
		Cidi other = (Cidi) obj;
		if (maCD != other.maCD)
			return false;
		return true;
	}
	@Override
	public String toString() {
		String str="";
		str+=String.format("%-15d %-15s %-15s %-15d %-15.0f",getMaCD(),getTuaCD(),getCaSy(),getSoBaiHat(),getGiatThanh());
		return str;
	}
	
	
	
	
	
}
