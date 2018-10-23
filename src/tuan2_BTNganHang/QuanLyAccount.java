package tuan2_BTNganHang;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyAccount {
	public static Scanner scan=new Scanner(System.in);
	ArrayList<Account2>	accountList = new ArrayList<Account2>();
	public boolean themAcc(Account2 acc) {
		if(kiemTraAcc(acc.getsTK())==0) {
			accountList.add(acc);
			return true;
		}else {
			System.out.println("số tài khoản đã tồn tại");
			return false;
		}
	}
	public int kiemTraAcc(int a) {
		for(int i=0;i<accountList.size()-1;i++) {
			if(accountList.get(i).getsTK()==a) {
				return i;//neu co tra ve gia tri do
			}
		}
		return 0;//neu khong co
	}
	public ArrayList<Account2> getAccountList() {
		return accountList;
	}
	public void setAccountList(ArrayList<Account2> accountList) {
		this.accountList = accountList;
	}
	
}
	
