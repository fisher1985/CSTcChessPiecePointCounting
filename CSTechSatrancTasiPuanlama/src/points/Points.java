package points;

import abstractmodels.IPiece;

public class Points {

	/*
	 * Taþ Ýsmi Kýsaltma Puaný
	Piyon p 1
	At a 3
	Fil f 3
	Kale k 5
	Vezir v 9
	Þah s 100
	 */
	public double getPoint(IPiece piece)
	{
		double pnt=0;
		String className=piece.getClass().toString();
		if(className.contains("Bishop"))
		{
			return 3;
		}
		if(className.contains("King"))
		{
			return 100;
		}
		if(className.contains("Knight"))
		{
			return 3;
		}
		if(className.contains("Pawn"))
		{
			return 1;
		}
		if(className.contains("Queen"))
		{
			return 9;
		}
		if(className.contains("Rook"))
		{
			return 5;
		}
		return pnt;
	}
	
	
}
