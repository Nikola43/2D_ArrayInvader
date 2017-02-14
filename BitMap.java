/*
    CLASE BitMap
    
    PROPIEDADES
        BASICAS
            alto         : tipo entero   : consultable
            ancho         : tipo entero   : consultable
        	
            bitMap[][] : tipo caracter : consultable

        DERIVADAS
            NINGUNA

        COMPARTIDAS
            BITMAP_PANTALLA : tipo array[][]   : consultable 
            BITMAP_JUGADOR  : tipo array[][]   : consultable
            
    RESTRICCIONES
        NINGUNA

    INTERFAZ
        METODOS CONSULTORES
            public int getAlto() 	
	        public int getAncho() 
	        public char[][] getBitMap()

        METODOS MODIFICADORES
            public void setAlto(int Alto) 
	        public void setAncho(int Ancho) 
	        public void setBitMap(char[][] bitMap) 
	                  
        METODOS HEREDADOS
            public String toString()
            public int hashCode()
            public Jugador clone()
            public boolean equals(Object object)
            public int compareTo(Jugador jugador)
        
        METODOS AÑADIDOS
	        
*/

public class BitMap 
{
	//------------------------------- PROPIEDADES -----------------------------------------------//
	    //BASICAS
	        private int alto, ancho;
		    char bitMap[][];

	    //DERIVADAS
	        //NINGUNA

	    //COMPARTIDAS
	        public static char BITMAP_JUGADOR[][] = 
	        {
				{' ',' ',' ',' ',' ','#',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ','#','#','#',' ',' ',' ',' '},
				{'#',' ',' ','#','#','#','#','#',' ',' ','#'},
				{'#',' ','#','#','#','#','#','#','#',' ','#'},
				{'#','#','#','#','#','#','#','#','#','#','#'}
			};
	//------------------------------- FIN PROPIEDADES --------------------------------------------//
		
	//------------------------------- CONSTRUCTORES ----------------------------------------------//
	//CONSTRUCTOR POR DEFECTO
	public BitMap()
	{
		alto = 1;
		ancho = 1;
		bitMap = new char[alto][ancho];
	}
	//CONSTRUCTOR SOBRECARGADO
	public BitMap(int alto, int ancho, char [][] bitMap)
	{
		this.alto     = alto;
		this.ancho    = ancho;
		this.bitMap   = bitMap;
	}
	//CONSTRUCTOR DE COPIA
	public BitMap(BitMap bitMap)
	{
		this.alto     = bitMap.getAlto();
		this.ancho    = bitMap.getAncho();
		this.bitMap   = bitMap.getBitMap();
	}
	
	public BitMap(int alto, int ancho )
	{
		this.alto = alto;
		this.ancho = ancho;
		this.bitMap = new char[alto][ancho];
	}
	
	//------------------------------- FIN CONSTRUCTORES ------------------------------------------//

	//------------------------------- METODOS CONSULTORES ----------------------------------------//
	public int getAlto() 
	{
		return alto;
	}
		
	public int getAncho() 
	{
		return ancho;
	}
		
	public char[][] getBitMap() 
	{
		return bitMap;
	}
	//------------------------------- FIN METODOS CONSULTORES ------------------------------------//

	//------------------------------- METODOS MODIFICADORES --------------------------------------//
	public void setAlto(int alto) 
	{
		this.alto = alto;
	}

	public void setAncho(int ancho) 
	{
		this.ancho = ancho;
	}
		
	public void setBitMap(char[][] bitMap) 
	{
		this.bitMap = bitMap;
	}

	//------------------------------- FIN METODOS MODIFICADORES ----------------------------------//   

	//------------------------------- METODOS HEREDADOS ------------------------------------------// 
	//------------------------------- FIN METODOS HEREDADOS --------------------------------------// 
	 
	//------------------------------- METODOS AÑADIDOS -------------------------------------------// 
	//------------------------------- FIN METODOS AÑADIDOS ---------------------------------------//

	public void insertarBitMap(BitMap bitMap, int posicionY, int posicionX)
	{
	    for (int y = 0; y < bitMap.getAlto(); y++) 
	    {
	        for (int x = 0; x <  bitMap.getAncho(); x++)
	        {
	            this.bitMap[y + posicionY][x + posicionX] += bitMap.bitMap[y][x];
	        }
	    }
	}
	    
	public void pintarPantalla()
	{
	    for (int y = 0; y < getAlto(); y++) 
	    {
	        for (int x = 0; x <  getAncho(); x++)
	        {
	            System.out.print(bitMap[y][x]);
	        }
	        System.out.println();
	    }
	}
	    
	public void limpiarBitmap()
	{
	    for (int y = 0; y < getAlto(); y++)  
	    {
	        for (int x = 0; x <  getAncho(); x++)
	        {
	            bitMap[y][x] = 0;
	        }
	    }
	}
	
	public void rellenarBitMap(char caracter)
	{
		for (int y = 0; y < getAlto(); y++)  
	    {
	        for (int x = 0; x < getAncho(); x++)
	        {
	            bitMap[y][x] = caracter;
	        }
	    }
	}
	    
	public void refrescarPantalla()
	{
	    pintarPantalla();
	    pausarEjecucion(25);
	    limpiarConsola();
	}
	        
	public void pausarEjecucion(int tiempo)
	{
	    try 
	    {
	        Thread.sleep(tiempo);               
	    } 
	    catch(InterruptedException e) 
	    {
	       Thread.currentThread().interrupt();
	    }
	}
	    
	public final void limpiarConsola()
	{
	    try
	    {
	        final String sistemaOperativoActual = System.getProperty("os.name");

	        if (sistemaOperativoActual.contains("Windows"))
	        {
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        System.out.println("Error: No se pudo limpiar la consola. "+e);
	    }
	}
}
