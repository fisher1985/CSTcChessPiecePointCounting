package pieces;

import java.util.ArrayList;

import abstractmodels.IPiece;
import enums.Colors;
import generals.Board;
import generals.Location;
import utility.Utility;

public class Queen implements IPiece {
	//Bu par�an�n kordinatlar�n� belirliyoruz.
	private int x,y;
	private Colors color;
	public Queen(Colors c,int pX,int pY)
	{
		x=pX;
		y=pY;
		color=c;
		
	}

	

	@Override
	public boolean isThreated(Board board) {
		return board.isThreated(this);
		
	}

	//bu fonksiyonda ta�lar�n tehdit etti�i kordinatlar� belirliyoruz.
	@Override
	public ArrayList<Location> getThreatLocation() {
		Utility utility=new Utility();
		ArrayList<Location> lst=new ArrayList<Location>();
		//vezir i�in  �nce sa�a sola ve yukar� a�a�� tehdit noktalar�n� ekliyoruz
		for(int i=1;i<8;i++)
		{
			if(x+i<=8)
			{
				//vezirin tehdit etti�i sa�a do�ru kordinatlar� ekliyoruz
				utility.addList(lst, new Location(x+i,y));
			}
			if(x-i>0)
			{
				//vezirin tehdit etti�i sola do�ru kordinatlar� ekliyoruz
				utility.addList(lst, new Location(x-i,y));
			}
			if(y+i<=8)
			{
				//vezirin tehdit etti�i yukar� do�ru kordinatlar� ekliyoruz
				utility.addList(lst, new Location(x,y+i));
			}
			if(y-i>0)
			{
				//vezirin tehdit etti�i a�a�� do�ru kordinatlar� ekliyoruz
				utility.addList(lst, new Location(x,y-i));
			}
		}
		//Vezir ayn zamanda fil gibi yiyebildi�i i�in filin tehdit lokasyonlar�n� ekliyoruz
		Bishop bisop=new Bishop(color,x,y);
		lst.addAll(bisop.getThreatLocation());
		
		
		

		return lst;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}



	@Override
	public Colors getColor() {
		// TODO Auto-generated method stub
		return color;
	}
	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return new Location(x, y);
	}

}
