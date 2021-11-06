package utility;

import java.util.ArrayList;

import abstractmodels.IPiece;
import generals.Location;

public class Utility {

	public ArrayList<Location> addList(ArrayList<Location> lst, Location loc) {
		boolean canAdd = true;
		if (lst.size() == 0) {
			lst.add(loc);
			return lst;
		}
		for (Location p : lst) {
			if (p.x == loc.x && p.y == loc.y) {
				canAdd = false;
				break;
			}
		}
		if (canAdd && loc.x > 0 && loc.x <= 8 && loc.y > 0 && loc.y <= 8) {
			lst.add(loc);
		}
		return lst;
	}

	// dizi içinde piece nesnesi var mý?
	public boolean contains(ArrayList<IPiece> lst, IPiece piece) {
		for (IPiece p : lst) {
			if (p.getX() == piece.getX() && p.getY() == piece.getY()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containLocation(ArrayList<IPiece> lst, Location location) {
		for (IPiece p : lst) {
			if (p.getX() == location.x && p.getY() == location.y) {
				return true;
			}
		}
		return false;
	}

	// dizi içinde piece nesnesi var mý?
	public boolean contains(ArrayList<Location> lst, Location loc) {
		for (Location l : lst) {
			if (l.x == loc.x && l.y == loc.y) {
				return true;
			}
		}
		return false;
	}

	// tasýmýzý ve tasýmýzý tehtid eden taþýn arasýnda baska bir taþ olup olmadýgýný tespit ediyoruz.
	//burada kale, vezir ve fil için bu kontrolü kullanýyoruz.
	public boolean containsInPath(IPiece piece,IPiece pieceTreat,ArrayList<IPiece> lstAllPiece) {
		int indX=piece.getX();
		int indY=piece.getY();
		int difX=0,difY=0;
		//burada while içinde kullanacaðýmýz deðiþim deðerlerini hesaplýyoruz.
		if(indX>pieceTreat.getX())
		{
			difX=-1;
		}
		else if(indX==pieceTreat.getX())
		{
			difX=0;
		}
		else
		{
			difX=1;
		}
		
		if(indY>pieceTreat.getY())
		{
			difY=-1;
		}
		else if(indY==pieceTreat.getY())
		{
			difY=0;
		}
		else
		{
			difY=1;
		}
		ArrayList<Location> pathLocations=new ArrayList<Location>();
		// Iki taþ arasýnda kalan lokasyonlarý buluyoruz
		while(indX==pieceTreat.getX()&&indY==pieceTreat.getY())
		{
			indX+=difX;
			indY+=difY;
			//hem taýmýzýn hemde taþýmýzý tehdit eden tasýn koordinatlarýný listeye eklemiyoruz
			if(indX!=piece.getX()&&indY!=piece.getY()&&
					indX!=pieceTreat.getX()&&indY!=pieceTreat.getY())
			{
				pathLocations.add(new Location(indX,indY));
			}
			
			
		}
		//Bulduðumuz koordinatlarýn içinde bulunan taþ olup olmadýðýna bakýyoruz
		for(IPiece p:lstAllPiece)
		{
			if(contains(pathLocations, p.getLocation()))
			{
				//Herhangi bir renkten baþka bir taþ path koordiantlarýnda varsa 
				//iki taþ arasýnda baþka bir taþ var demektir.
				return true;
			}
		}
		

		return false;
	}

}
