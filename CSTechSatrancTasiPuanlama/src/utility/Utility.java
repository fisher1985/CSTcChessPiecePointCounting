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

	// dizi i�inde piece nesnesi var m�?
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

	// dizi i�inde piece nesnesi var m�?
	public boolean contains(ArrayList<Location> lst, Location loc) {
		for (Location l : lst) {
			if (l.x == loc.x && l.y == loc.y) {
				return true;
			}
		}
		return false;
	}

	// tas�m�z� ve tas�m�z� tehtid eden ta��n aras�nda baska bir ta� olup olmad�g�n� tespit ediyoruz.
	//burada kale, vezir ve fil i�in bu kontrol� kullan�yoruz.
	public boolean containsInPath(IPiece piece,IPiece pieceTreat,ArrayList<IPiece> lstAllPiece) {
		int indX=piece.getX();
		int indY=piece.getY();
		int difX=0,difY=0;
		//burada while i�inde kullanaca��m�z de�i�im de�erlerini hesapl�yoruz.
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
		// Iki ta� aras�nda kalan lokasyonlar� buluyoruz
		while(indX==pieceTreat.getX()&&indY==pieceTreat.getY())
		{
			indX+=difX;
			indY+=difY;
			//hem ta�m�z�n hemde ta��m�z� tehdit eden tas�n koordinatlar�n� listeye eklemiyoruz
			if(indX!=piece.getX()&&indY!=piece.getY()&&
					indX!=pieceTreat.getX()&&indY!=pieceTreat.getY())
			{
				pathLocations.add(new Location(indX,indY));
			}
			
			
		}
		//Buldu�umuz koordinatlar�n i�inde bulunan ta� olup olmad���na bak�yoruz
		for(IPiece p:lstAllPiece)
		{
			if(contains(pathLocations, p.getLocation()))
			{
				//Herhangi bir renkten ba�ka bir ta� path koordiantlar�nda varsa 
				//iki ta� aras�nda ba�ka bir ta� var demektir.
				return true;
			}
		}
		

		return false;
	}

}
