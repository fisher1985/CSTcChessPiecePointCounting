package pieces;

import java.util.ArrayList;

import abstractmodels.IPiece;
import enums.Colors;
import generals.Board;
import generals.Location;
import utility.Utility;

public class Bishop implements IPiece {
	//Bu par�an�n kordinatlar�n� belirliyoruz.
	private int x,y;
	private Colors color;
	private Utility utility;
	
	public Bishop(Colors c,int pX,int pY)
	{
		x=pX;
		y=pY;
		color=c;
		utility=new Utility();
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
		
		//bu ta��n (fil) bulundu�u x ve y ye g�re hareket edebilece�i 
		//�apraz noktalar� belirleyip listeye ekliyoruz.
		//fil i�in 4 caparaz y�ne yiyebildi�i i�in 8 adet int de�i�ken tan�ml�yoruz.
		int x1=0,y1=0,x2=0,y2=0,x3=0,y3=0,x4=0,y4=0;
		while(x1>=-8&&y1>=-8&&x2>=-8&&y2<=16&&x3<=16&&y3<=16&&x4<=16&&y4>=-8)
		{
			//ilk olarak sol alta do�ru caprazlar� belirliyoruz
			if(x+x1<=8&&x+x1>=1&&y+y1<=8&&y+y1>=1)// x ve y de�erlerinin 1 ile 8 aras�nda olmas� sa�lan�r.
			{
				Location l=new Location(x+x1,y+y1);
				lst=utility.addList(lst, l);
				
			}
			x1--;y1--;
			//sol uste do�ru caprazlar� belirliyoruz
			if(x+x2<=8&&x+x2>=1&&y+y2<=8&&y+y2>=1)// x ve y de�erlerinin 1 ile 8 aras�nda olmas� sa�lan�r.
			{
				Location l=new Location(x+x2,y+y2);
				lst=utility.addList(lst, l);
				
			}
			x2--;y2++;
			//sa� uste do�ru caprazlar� belirliyoruz
			if(x+x3<=8&&x+x3>=1&&y+y3<=8&&y+y3>=1)// x ve y de�erlerinin 1 ile 8 aras�nda olmas� sa�lan�r.
			{
				Location l=new Location(x+x3,y+y3);
				lst=utility.addList(lst, l);

			}
			x3++;y3++;
			
			//sa� alta do�ru caprazlar� belirliyoruz
			if(x+x4<=8&&x+x4>=1&&y+y4<=8&&y+y4>=1)// x ve y de�erlerinin 1 ile 8 aras�nda olmas� sa�lan�r.
			{
				Location l=new Location(x+x4,y+y4);
				lst=utility.addList(lst, l);
				
			}
			x4++;y4--;
		}
		
		

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
