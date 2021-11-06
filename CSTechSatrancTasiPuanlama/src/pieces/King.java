package pieces;

import java.util.ArrayList;

import abstractmodels.IPiece;
import enums.Colors;
import generals.Board;
import generals.Location;
import utility.Utility;

public class King implements IPiece {
	//at contructor we get color and x,y coordinates.
	private int x,y;
	private Colors color;
	
	public King(Colors c,int pX,int pY)
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
		
		
		for(int i=-1;i<=1;i++)
		{
			for(int j=-1;j<=1;j++)
			{
				if(x+i<=8&&x+i>0&&y+j<=8&&y+j>0)
				{
					utility.addList(lst, new Location(x+i, y+j));
					
				}
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
