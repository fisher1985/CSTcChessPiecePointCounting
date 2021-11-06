package factory;

import java.io.IOException;
import java.util.ArrayList;

import abstractmodels.IPiece;
import enums.Colors;
import generals.Board;
import generals.Location;
import io.FileOperation;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;



public class PiecesFactory {
	
	public PiecesFactory()
	{
		
	}
	public IPiece getPiece(String pieceType,int x,int y){
		
		 IPiece piece = null;
		 // gelen strine göre ng ifadesi tasý belirliyoruz
		 switch (pieceType) {
		 
		 case "fs":
             piece = new Bishop(Colors.black,x,y);
             break;
		 case "ss":
             piece = new King(Colors.black, x,y);
             break;
		 case "as":
             piece = new Knight(Colors.black,x,y);
             break;
		 case "ps":
             piece = new Pawn(Colors.black,x,y);
             break;
		 case "vs":
             piece = new Queen(Colors.black,x,y);
             break;
		 case "ks":
             piece = new Rook(Colors.black,x,y);
             break;
		 case "fb":
             piece = new Bishop(Colors.white, x,y);
             break;
		 case "sb":
             piece = new King(Colors.white, x,y);
             break;
		 case "ab":
             piece = new Knight(Colors.white, x,y);
             break;
		 case "pb":
             piece = new Pawn(Colors.white, x,y);
             break;
		 case "vb":
             piece = new Queen(Colors.white, x,y);
             break;
		 case "kb":
             piece = new Rook(Colors.white,x,y);
             break;
         
		 }
        
        return piece;
         
         
	}
	public ArrayList<IPiece> loadPiecesFromFile(String fileName) 
	{
		ArrayList<IPiece> lst=new ArrayList<IPiece>();
		try {
			ArrayList<String> lstLines= FileOperation.readFromFile(fileName);
			int indexX=1,indexY=1;
			//Burada dosyamýzdan taþlarýmýzý renk ve koordinatlarý ile yüklüyoruz. 
			for(String piece:lstLines)
			{
				//koordinat düzlemini 1 - 8 aralýðý olarak düsündüðümüz için indexX ve indexY bir artýrýyoruz
				IPiece p=getPiece(piece,indexX,9-(indexY));
				if(p!=null)
				lst.add(p);
				if(indexX==8)
				{
					if(indexY<8)//Y deðeri 8 den büyük olamaz
					indexY++;
				}
				++indexX;
				if(indexX>8)//indexX deðeri 0 den büyükse indexX i 1 yapýyoruz.
				{
					indexX=1;
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lst;
	}
	
	
	
}
