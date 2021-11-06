package generals;
import java.io.IOException;
import java.util.ArrayList;

import abstractmodels.IPiece;
import enums.Colors;
import factory.PiecesFactory;
import io.FileOperation;
import points.Points;
import utility.Utility;



public class Board {
	//satranc taþlarýný nesne olarak bu class taki listeye atýyoruz
	public Board(String fileName)
	{
		//objelerimizi init yapýyoruz.
		initObj();
		loadPieces(fileName);
	}
	private void initObj()
	{
		lstPieces=new ArrayList<IPiece>();
		points=new Points();
		uti=new Utility();
	}
	PiecesFactory pFact;
	Utility uti;
	Points points;
	private void loadPieces(String fileName)
	{
		pFact=new PiecesFactory();
		lstPieces=pFact.loadPiecesFromFile(fileName);
	}
	
	private ArrayList<IPiece> lstPieces;
	public ArrayList<IPiece> getPieces()
	{
		return lstPieces;
	}
	public boolean isThreated(IPiece piece)
	{
		for(IPiece p:lstPieces)
		{
			//farklý renkte olan bütün rakip taþlara bakýlýyor
			if(p.getColor()!=piece.getColor())
			{
				//eðer rakip taþlar içinde piece nesnesine ait tehtit varsa true döner 
				//burada at, piyon ve þah için ve diðer taþlar için farklý kontrol kullanmak gerekir.
				//cünkü at diðer taþlarýn üzerinden atlayabilir. piyon ve þah zaten birer kare ilerliyebiliyorlar.
			    if((p.getClass().toString().contains("Knight")||p.getClass().toString().contains("Pawn")||
			    		p.getClass().toString().contains("King")) && uti.contains(p.getThreatLocation(),piece.getLocation()))
			    {
			    	
			    	return true;
			    }
			    //burada hem koordiantalrý içinde olacak hem de bu iki taþýn arasýnda baþka bir taþ olmayacak.
			    //Eðer arada baþka bir taþ olursa zaten iþlem false döner. Tehdit olamdýðý anlasýlýr.
			    else if(uti.contains(p.getThreatLocation(),piece.getLocation())&&uti.containsInPath(piece,p,lstPieces))
			    {
			    	return true;
			    }
			}
		}
		//hiç tehtide bulunmassa false döner
		return false;
	}
	public double calculatePoints(Colors color)
	{
		double totalPoint=0;
		for(IPiece p: lstPieces)
		{
			if(p.getColor()==color)
			{
				//eðer tehdit varsa yarým puan alýr.
				if(p.isThreated(this))
				{
					totalPoint+=(points.getPoint(p)/(double)2);
				}
				else
				{
					//eðer tehtid yoksa tam puan alýr.
					totalPoint+=points.getPoint(p);
				}
			}
		}
		return totalPoint;
	}
	
	
}
