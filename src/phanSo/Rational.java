package phanSo;

public class Rational {
	public float numerator;
	public float denominator;
	public float getNumerator() {
		return numerator;
	}
	public void setNumerator(float numerator) {
		this.numerator = numerator;
	}
	public float getDenominator() {
		return denominator;
	}
	public void setDenominator(float denominator) {
		this.denominator = denominator;
	}

	public Rational(float denominator, float numerator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	public Rational() {
	}
	public float USC(float a,float b) {
		if (b == 0) return a;
		return USC(b, a % b);
	}
	public boolean reduce() {
		boolean flag=false;
		if(this.getDenominator()==0 && this.getNumerator()==0 || this.getDenominator()!=0 && this.getNumerator()==0) {
			flag=false;
		}else {
			float a=USC(this.getDenominator(),this.getNumerator());
			this.setDenominator(this.getDenominator()/a);
			this.setNumerator(this.getNumerator()/a);
			flag=true;
		}
		return flag;
	}
	//	public boolean kiemTra() {
	//		boolean flag=false;
	//		if(this.denominator==0 && this.numerator==0) {
	//			flag=true;
	//		}
	//		return flag;
	//	}
	public void cong(Rational ps1,Rational ps2) {
		this.setDenominator(ps1.denominator*ps2.numerator+ps2.denominator*ps1.numerator);
		this.setNumerator(ps1.numerator*ps2.numerator);
		if(this.reduce()==true) {
			System.out.println("cộng:"+this.toString());
		}else {
			System.out.println("error");
		}
	}
	public void tru(Rational ps1,Rational ps2) {
		this.setDenominator(ps1.denominator*ps2.numerator-ps2.denominator*ps1.numerator);
		this.setNumerator(ps1.numerator*ps2.numerator);
		if(this.reduce()==true) {
			System.out.println("trừ:"+this.toString());
		}else {
			System.out.println("error");
		}
	}
	public void nhan(Rational ps1,Rational ps2) {
		this.setDenominator(ps1.denominator*ps2.denominator);
		this.setNumerator(ps1.numerator*ps2.numerator);
		if(this.reduce()==true) {
			System.out.println("nhân:"+this.toString());
		}else {
			System.out.println("error");
		}
	}
	public void chia(Rational ps1,Rational ps2) {
		this.setDenominator(ps1.denominator*ps2.numerator);
		this.setNumerator(ps1.numerator*ps2.denominator);
		if(this.reduce()==true) {
			System.out.println("chia:"+this.toString());
		}else {
			System.out.println("error");
		}
	}
	public Rational(Rational ps1,Rational ps2) {
		this.cong(ps1, ps2);
		this.tru(ps1, ps2);
		this.nhan(ps1, ps2);
		this.chia(ps1, ps2);
	}
	@Override
	public String toString() {
		String str="";
		str=String.format("%.0f/%.0f",this.getDenominator(),this.getNumerator());
		return str;
	}
}
