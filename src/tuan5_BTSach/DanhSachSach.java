package tuan5_BTSach;

import java.util.ArrayList;
import java.util.Collections;


public class DanhSachSach{
	public 	ArrayList<Sach> ds=new ArrayList<Sach>();
	public DanhSachSach ()
	{
		ds = new ArrayList<Sach>();
	}
	public boolean themSach(Sach sachmoi){
		if(ds.contains(sachmoi)) 
		{
			return false;
		}
		else
		{
			ds.add(sachmoi);
		}
		return true;
	}

	public Sach timSach (String maS )
	{
		for ( Sach sach :ds )
		{
			if ( sach.getMaS().equals(maS) )
				return sach;
		}
		return null;

	}
	public Sach timSachNSX (String nhaSX )
	{
		for ( Sach sach :ds )
		{
			if ( sach.getNhaSX().equals(nhaSX) )
				return sach;
		}
		return null;

	}
	public boolean delete ( String maS)

	{
		Sach sTim=  timSach(maS);
		if(sTim!=null)
		{
			ds.remove(sTim);
			return true;
			//r
		}
		else
			return false;

	}
	public void sapXep()
	{
		Collections.sort(ds);
	}
}
