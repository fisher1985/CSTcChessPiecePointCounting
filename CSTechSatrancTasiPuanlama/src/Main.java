import java.io.IOException;
import java.util.ArrayList;

import abstractmodels.IPiece;
import enums.Colors;
import factory.PiecesFactory;
import generals.Board;
import generals.Location;
import io.FileOperation;
import pieces.Rook;

public class Main {

	
	static final String fileName1 = "src/files/board1.txt";
	static final String fileName2 = "src/files/board2.txt";
	static final String fileName3 = "src/files/board3.txt";
	static final String fileNameSonuc = "src/files/sonuclar.txt";
	private static FileOperation fileOp=new FileOperation();
	public static void main(String[] args) {
    	
		addToSonucFileHeader();
		calculatePointsFromFile(fileName1);
		calculatePointsFromFile(fileName2);
		calculatePointsFromFile(fileName3);
        System.out.println("All results have written to  'sonuclar.text' file.");

	}
	public static void addToSonucFileHeader()
	{
		try {
			FileOperation.writeToFile(fileNameSonuc, "Tahta Dosya Adi\t\t\t\tSonuclar\n");
			System.out.println("Tahta Dosya Adi\t\t\t\tSonuclar\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Puan hesaplayan fonksiyona gönderiliyor
	public static void calculatePointsFromFile(String fileName)
	{
		Board board = new Board(fileName);
		double blackPoint= board.calculatePoints(Colors.black);
		double whitePoint= board.calculatePoints(Colors.white);
		
		try {
			FileOperation.writeToFile(fileNameSonuc,fileName +"\t" + "Siyah: " + blackPoint + " " + "Beyaz: " + whitePoint + "\n");
			System.out.println(fileName +"\t" + "Siyah: " + blackPoint + " " + "Beyaz: " + whitePoint + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
