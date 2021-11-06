package pieces;

import java.util.ArrayList;

import abstractmodels.IPiece;
import enums.Colors;
import generals.Board;
import generals.Location;
import utility.Utility;

public class Knight implements IPiece {
	//at contructor we get color and x,y coordinates.
	private int x,y;
	private Colors color;
	
	public Knight(Colors c,int pX,int pY)
	{
		x=pX;
		y=pY;
		color=c;
		
	}

	

	@Override
	public boolean isThreated(Board board) {
		return board.isThreated(this);
		
	}

	@Override
	public ArrayList<Location> getThreatLocation() {
		Utility utility=new Utility();
		ArrayList<Location> lst=new ArrayList<Location>();
		// At �n gidebilece�i lokasyonlar� belirliyoruz
		//At L cizeler ilerledi�i i�in  
		int[] lenght= {1,2};//
		int xInc,yInc;//x ve y koordinatlar�n�n art�m de�erlerini hesapl�yoruz
		for (int i = 0; i < 4; i++) {
			// burada her iterasyonda biri uzun kenar biri k�sa kenar olacak �ekilde ayarlanmas�n� sa�l�yoruz.
			if(i<2)
			{
				// x art�r�m� 2 kere 1 art�r�lacak 
				xInc=lenght[0];
				// y art�r�m� 2 kere 2 art�r�lacak 
				yInc=lenght[1];
			}
			else
			{
				// x art�r�m� 2 kere 2 art�r�lacak 
				xInc=lenght[1];
				// y art�r�m� 2 kere 1 art�r�lacak 
				yInc=lenght[0];
			}
			
			
			
			for (int j = 0; j < 4; j++) {
				// burada her iterasyonda art�m de�erleri - - , - +, +-, + + olacak sekilde belirliyoruz;
				if(j<2)
				{
					xInc=(-1)*Math.abs(xInc);//  i nin de�eri 2 den k���k iterayon xInc deperini  (-) olarak belirliyoruz
				}
				else
				{
					xInc=Math.abs(xInc);//  i nin de�eri 2 den b�y�k iterayon i�in xInc de�erini (+) olarak belirliyoruz
				}
				if(j%2==0)
				{
					yInc=(-1)*Math.abs(yInc);//   i cift say� ise yInc (-) olarak belirliyoruz
				}
				else
				{
					yInc=Math.abs(yInc);//   i tek say� ise yInc (+) olarak belirliyoruz
				}
				//burada ayn� Lokasyonun birden fazla eklenmesini engellemek i�in utility nesnesinden faydalanoyoruz
				
				utility.addList(lst, new Location(x+xInc, y+yInc));
				
			}
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
