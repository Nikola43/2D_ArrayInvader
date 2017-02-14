
public class Pantalla 
{
	//int pantalla[][] = new int[WIDTH][HEIGHT];
	private int  MAX_Y, MAX_X;
	private BitMap pantallaBitMap;

	public Pantalla() 
	{
		MAX_Y = 1;
		MAX_X = 1;
	}
	
	public Pantalla(int MAX_Y, int MAX_X, BitMap pantallaBitMap)
	{
		this.MAX_Y = MAX_Y;
		this.MAX_X = MAX_X;
		this.pantallaBitMap = pantallaBitMap;
	}
	
	public void setMAX_Y(int MAX_Y)
	{
		this.MAX_Y = MAX_Y;
	}
	
	public void setMAX_X(int MAX_X)
	{
		this.MAX_X = MAX_X;
	}
	
	public void setPantallaBitMap(BitMap pantallaBitMap) 
	{
		this.pantallaBitMap = pantallaBitMap;
	}
	
	public int getMAX_Y() 
	{
		return MAX_Y;
	}
	
	public int getMAX_X() 
	{
		return MAX_X;
	}
	
	public BitMap getPantallaBitMap() 
	{
		return pantallaBitMap;
	}
	
	
	public void setBitMap(BitMap bitMap, int posicionY, int posicionX)
	{
		for (int y = 0; y < bitMap.getMAX_Y(); y++) 
		{
			for (int x = 0; x <  bitMap.getMAX_X(); x++)
			{
				pantallaBitMap.myBitMap[y + posicionY][x + posicionX] += bitMap.myBitMap[y][x];
			}
		}
	}
	
	
	public void Mostrar()
	{
		for (int y = 0; y < MAX_Y; y++)  
		{
			for (int x = 0; x < MAX_X; x++)
			{
				System.out.print(pantallaBitMap.myBitMap[y][x]);
			}
			System.out.println();
		}
	}
	
	public void limpiar()
	{
		for (int y = 0; y < MAX_Y; y++)  
		{
			for (int x = 0; x < MAX_X; x++)
			{
				pantallaBitMap.myBitMap[y][x] = 0;
			}
		}
		clearConsole();
	}
	
	public void actualizar()
	{

		Mostrar();
		esperar(25);
		limpiar();
	}
	
	
	
	public void esperar(int delayTime)
	{
		try 
		{
		    Thread.sleep(delayTime);                 //1000 milliseconds is one second.
		} 
		catch(InterruptedException ex) 
		{
		    Thread.currentThread().interrupt();
		}
	}
	
	private final void clearConsole()
	{
		try
		{

	        final String os = System.getProperty("os.name");
	        if (os.contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
}
