package pieces;

import java.util.ArrayList;

import abstractmodels.IPiece;
import enums.Colors;
import generals.Board;
import generals.Location;
import utility.Utility;

public class Pawn implements IPiece {
	//at contructor we get color and x,y coordinates.
	private int x,y;
	Colors color;
	
	public Pawn(Colors c,int pX,int pY)
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
		
		ArrayList<Location> lst=new ArrayList<Location>();
		Utility utility=new Utility();
		// piyon rengine göre birer çapraz tehdit oluþturuyor.
		if(color==Colors.black)
		{
			//taþ siyah ise sol alt ve sað alta doðru tehdit eder
			if(x-1>0&&y-1>0)
			{
				utility.addList(lst, new Location(x-1,y-1));
			}
			if(x+1<=8&&y-1>0)
			{
				utility.addList(lst, new Location(x+1,y-1));
			}
		}
		else
		{
			//taþ beyaz ise sol yukarý ve sað yukarý doðru tehdit eder
			if(x+1<=8&&y+1<=8)
			{
				utility.addList(lst, new Location(x+1,y+1));
			}
			if(x-1>0&&y+1<=8)
			{
				utility.addList(lst, new Location(x-1,y+1));
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
