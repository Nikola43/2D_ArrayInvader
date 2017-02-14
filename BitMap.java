
public class BitMap 
{
	//Atributos
	private int MAX_Y, MAX_X;
	char myBitMap[][] = new char[MAX_Y][MAX_Y];
	
	public BitMap()
	{
		MAX_Y = 1;
		MAX_X = 1;
		myBitMap[0][0] = 0;
	}
	
	public BitMap(int MAX_Y, int MAX_X, char [][] bitMap)
	{
		this.MAX_Y    = MAX_Y;
		this.MAX_X    = MAX_X;
		this.myBitMap = bitMap;
	}
	
	public BitMap(BitMap bitMap)
	{
		this.MAX_Y    = bitMap.MAX_Y;
		this.MAX_X    = bitMap.MAX_X;
		this.myBitMap = bitMap.myBitMap;
	}
	
	//Metodos Modificadores
	public void setMAX_Y(int MAX_Y) 
	{
		this.MAX_Y = MAX_Y;
	}
	
	public void setMAX_X(int MAX_X) 
	{
		this.MAX_X = MAX_X;
	}
	
	public void setMyBitMap(char[][] myBitMap) 
	{
		this.myBitMap = myBitMap;
	}
	
	//Metodos Consultores
	public int getMAX_Y() 
	{
		return MAX_Y;
	}
	
	public int getMAX_X() 
	{
		return MAX_X;
	}
	
	public char[][] getMyBitMap() 
	{
		return myBitMap;
	}
}
