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
		// At ýn gidebileceði lokasyonlarý belirliyoruz
		//At L cizeler ilerlediði için  
		int[] lenght= {1,2};//
		int xInc,yInc;//x ve y koordinatlarýnýn artým deðerlerini hesaplýyoruz
		for (int i = 0; i < 4; i++) {
			// burada her iterasyonda biri uzun kenar biri kýsa kenar olacak þekilde ayarlanmasýný saðlýyoruz.
			if(i<2)
			{
				// x artýrýmý 2 kere 1 artýrýlacak 
				xInc=lenght[0];
				// y artýrýmý 2 kere 2 artýrýlacak 
				yInc=lenght[1];
			}
			else
			{
				// x artýrýmý 2 kere 2 artýrýlacak 
				xInc=lenght[1];
				// y artýrýmý 2 kere 1 artýrýlacak 
				yInc=lenght[0];
			}
			
			
			
			for (int j = 0; j < 4; j++) {
				// burada her iterasyonda artým deðerleri - - , - +, +-, + + olacak sekilde belirliyoruz;
				if(j<2)
				{
					xInc=(-1)*Math.abs(xInc);//  i nin deðeri 2 den küçük iterayon xInc deperini  (-) olarak belirliyoruz
				}
				else
				{
					xInc=Math.abs(xInc);//  i nin deðeri 2 den büyük iterayon için xInc deðerini (+) olarak belirliyoruz
				}
				if(j%2==0)
				{
					yInc=(-1)*Math.abs(yInc);//   i cift sayý ise yInc (-) olarak belirliyoruz
				}
				else
				{
					yInc=Math.abs(yInc);//   i tek sayý ise yInc (+) olarak belirliyoruz
				}
				//burada ayný Lokasyonun birden fazla eklenmesini engellemek için utility nesnesinden faydalanoyoruz
				
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
