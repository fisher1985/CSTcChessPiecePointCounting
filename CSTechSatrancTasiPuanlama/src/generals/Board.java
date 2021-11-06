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
	//satranc ta�lar�n� nesne olarak bu class taki listeye at�yoruz
	public Board(String fileName)
	{
		//objelerimizi init yap�yoruz.
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
			//farkl� renkte olan b�t�n rakip ta�lara bak�l�yor
			if(p.getColor()!=piece.getColor())
			{
				//e�er rakip ta�lar i�inde piece nesnesine ait tehtit varsa true d�ner 
				//burada at, piyon ve �ah i�in ve di�er ta�lar i�in farkl� kontrol kullanmak gerekir.
				//c�nk� at di�er ta�lar�n �zerinden atlayabilir. piyon ve �ah zaten birer kare ilerliyebiliyorlar.
			    if((p.getClass().toString().contains("Knight")||p.getClass().toString().contains("Pawn")||
			    		p.getClass().toString().contains("King")) && uti.contains(p.getThreatLocation(),piece.getLocation()))
			    {
			    	
			    	return true;
			    }
			    //burada hem koordiantalr� i�inde olacak hem de bu iki ta��n aras�nda ba�ka bir ta� olmayacak.
			    //E�er arada ba�ka bir ta� olursa zaten i�lem false d�ner. Tehdit olamd��� anlas�l�r.
			    else if(uti.contains(p.getThreatLocation(),piece.getLocation())&&uti.containsInPath(piece,p,lstPieces))
			    {
			    	return true;
			    }
			}
		}
		//hi� tehtide bulunmassa false d�ner
		return false;
	}
	public double calculatePoints(Colors color)
	{
		double totalPoint=0;
		for(IPiece p: lstPieces)
		{
			if(p.getColor()==color)
			{
				//e�er tehdit varsa yar�m puan al�r.
				if(p.isThreated(this))
				{
					totalPoint+=(points.getPoint(p)/(double)2);
				}
				else
				{
					//e�er tehtid yoksa tam puan al�r.
					totalPoint+=points.getPoint(p);
				}
			}
		}
		return totalPoint;
	}
	
	
}
