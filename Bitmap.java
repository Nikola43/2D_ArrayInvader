/*
    CLASE Bitmap
    
    PROPIEDADES
        BASICAS
            alto          : tipo entero   : consultable
            ancho         : tipo entero   : consultable
            array2D[][]   : tipo caracter : consultable

        DERIVADAS
            NINGUNA

        COMPARTIDAS
            Bitmap_PANTALLA : tipo array[][]   : consultable 
            Bitmap_JUGADOR  : tipo array[][]   : consultable
            
    RESTRICCIONES
        NINGUNA

    INTERFAZ
        METODOS CONSULTORES
            public int getAlto() 	
	        public int getAncho() 
	        public char[][] getArray2D()

        METODOS MODIFICADORES
            public void setAlto(int Alto) 
	        public void setAncho(int Ancho) 
	        public void setArray2D(char[][] array2D) 
	                  
        METODOS HEREDADOS
            public String toString()
            public int hashCode()
            public Jugador clone()
            public boolean equals(Object object)
            public int compareTo(Jugador jugador)
        
        METODOS AÑADIDOS
	        
*/

public class Bitmap 
{
	//------------------------------- PROPIEDADES -----------------------------------------------//
	    //BASICAS
	    
	        private int alto, ancho;
		    char[][] array2D;

	    //DERIVADAS
	        //NINGUNA

	    //COMPARTIDAS
	    //--------------------- BITMAPS DEL JUGADOR ------------------//
	    public static char[][] BITMAP_JUGADOR_ARRIBA = 
	    {
			{' ',' ',' '},
			{' ','*',' '},
			{'*','*','*'}
		};
		public static char[][] BITMAP_JUGADOR_ABAJO = 
	    {
			{'*','*','*'},
			{' ','*',' '},
			{' ',' ',' '}
		};
		public static char[][] BITMAP_JUGADOR_IZQUIERDA = 
	    {
			{' ','*',' '},
			{'*','*',' '},
			{' ','*',' '}
		};
		public static char[][] BITMAP_JUGADOR_DERECHA = 
	    {
			{' ','*',' '},
			{' ','*','*'},
			{' ','*',' '}
		};
		//------------------ FIN BITMAPS DEL JUGADOR -----------------//
		
		//BITMAP FRUTA
		public static char[][] BITMAP_FRUTA = 
	    {
			{'*','*'},
			{'*','*'}
		};
		
		public static char[][] BITMAP_ASTEROIDE = 
	    {
			{'*',' ','*',' ','*',' '},
			{' ','*','*','*','*','*'},
			{'*','*','*','*','*',' '},
			{' ','*',' ','*',' ','*'}
		};
		
	//------------------------------- FIN PROPIEDADES --------------------------------------------//
		
	//------------------------------- CONSTRUCTORES ----------------------------------------------//
	//CONSTRUCTOR POR DEFECTO
	public Bitmap()
	{
		alto = 1;
		ancho = 1;
		array2D = new char[alto][ancho];
	}
	//CONSTRUCTOR SOBRECARGADO
	public Bitmap(int alto, int ancho, char [][] array2D)
	{
		this.alto     = alto;
		this.ancho    = ancho;
		this.array2D   = array2D;
	}
	//CONSTRUCTOR DE COPIA
	public Bitmap(Bitmap bitmap)
	{
		this.alto     = bitmap.getAlto();
		this.ancho    = bitmap.getAncho();
		this.array2D   = bitmap.getArray2D();
	}
	
	public Bitmap(int alto, int ancho )
	{
		this.alto = alto;
		this.ancho = ancho;
		this.array2D = new char[alto][ancho];
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
		
	public char[][] getArray2D() 
	{
		return array2D;
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
		
	public void setArray2D(char[][] array2D) 
	{
		this.array2D = array2D;
	}

	//------------------------------- FIN METODOS MODIFICADORES ----------------------------------//   

	//------------------------------- METODOS HEREDADOS ------------------------------------------// 
	//------------------------------- FIN METODOS HEREDADOS --------------------------------------// 
	 
	//------------------------------- METODOS AÑADIDOS -------------------------------------------// 
	//------------------------------- FIN METODOS AÑADIDOS ---------------------------------------//

	public void insertarBitmap(Bitmap bitmap, int posicionY, int posicionX)
	{
	    for (int y = 0; y < bitmap.getAlto(); y++) 
	    {
	        for (int x = 0; x <  bitmap.getAncho(); x++)
	        {
	            this.array2D[y + posicionY][x + posicionX] += bitmap.array2D[y][x];
	        }
	    }
	}
	
	public void pintarMiBitmap()
	{
	    for (int y = 0; y < getAlto(); y++) 
	    {
	        for (int x = 0; x <  getAncho(); x++)
	        {
	            System.out.print(array2D[y][x]);
	        }
	        System.out.println();
	    }
	}
	    
	public void limpiarBitmap()
	{
	    for (int y = 0; y < this.getAlto(); y++)  
	    {
	        for (int x = 0; x <  this.getAncho(); x++)
	        {
	            array2D[y][x] = 0;
	        }
	    }
	}
	
	public void rellenarBitmap(char caracter)
	{
		for (int y = 0; y < getAlto(); y++)  
	    {
	        for (int x = 0; x < getAncho(); x++)
	        {
	            array2D[y][x] = caracter;
	        }
	    }
	}
	    
	public void refrescarPantalla()
	{
	    pintarMiBitmap();
	    pausarEjecucion(50);
	    limpiarBitmap();
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
