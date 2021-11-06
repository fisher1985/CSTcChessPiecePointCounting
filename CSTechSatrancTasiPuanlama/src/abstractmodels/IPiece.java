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
	//Bu ta��, rakip ta�lardan  biri taraf�ndan tehdit edildi�ini tespit ediyoruz.
	public boolean isThreated(Board board);
	//ilgili ta��n hareket etki alanlar�n�n koordinatlar� belirliyoruz
	public ArrayList<Location> getThreatLocation();

}
