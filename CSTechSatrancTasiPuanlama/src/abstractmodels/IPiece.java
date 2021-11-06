package abstractmodels;

import java.util.ArrayList;

import enums.Colors;
import generals.Board;
import generals.Location;

public interface IPiece {
	public int getX();
	public int getY();
	public Location getLocation();
	public Colors getColor();
	//Bu taþý, rakip taþlardan  biri tarafýndan tehdit edildiðini tespit ediyoruz.
	public boolean isThreated(Board board);
	//ilgili taþýn hareket etki alanlarýnýn koordinatlarý belirliyoruz
	public ArrayList<Location> getThreatLocation();

}
