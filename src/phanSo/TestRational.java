package phanSo;

import java.util.Scanner;

public class TestRational {
	public static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		Rational ps1=new Rational(-5,6);
		Rational ps2=new Rational(7,9);

		Rational ps=new Rational(ps1,ps2);	
	}
}
