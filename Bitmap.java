
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
			BITMAP_JUGADOR_ARRIBA      : tipo array[][] : consultable
			BITMAP_JUGADOR_ABAJO       : tipo array[][] : consultable
			BITMAP_JUGADOR_IZQUIERDA   : tipo array[][] : consultable
			BITMAP_JUGADOR_DERECHA     : tipo array[][] : consultable
			BITMAP_FRUTA               : tipo array[][] : consultable
			BITMAP_FRUTA_NO_COMESTIBLE : tipo array[][] : consultable
			BITMAP_ASTEROIDE           : tipo array[][] : consultable

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
		    private char[][] array2D;

	    //DERIVADAS
	        //NINGUNA

	    //COMPARTIDAS
		//Definimos las dimensiones minimas y maximas de un bitmap
		public static final int ALTO_MINIMO  = 2;
		public static final int ANCHO_MINIMO = 2;
		public static final int ALTO_MAXIMO  = 32;
		public static final int ANCHO_MAXIMO = 40;

	    //--------------------- BITMAPS DEL JUGADOR ------------------//
	    public static final char[][] BITMAP_JUGADOR_ARRIBA = 
	    {
			{' ',' ',' '},
			{' ','*',' '},
			{'*','*','*'}
		};
		public static final char[][] BITMAP_JUGADOR_ABAJO = 
	    {
			{'*','*','*'},
			{' ','*',' '},
			{' ',' ',' '}
		};
		public static final char[][] BITMAP_JUGADOR_IZQUIERDA = 
	    {
			{' ','*',' '},
			{'*','*',' '},
			{' ','*',' '}
		};
		public static final char[][] BITMAP_JUGADOR_DERECHA = 
	    {
			{' ','*',' '},
			{' ','*','*'},
			{' ','*',' '}
		};
		//------------------ FIN BITMAPS DEL JUGADOR -----------------//
		
		//BITMAP FRUTA
		public static final char[][] BITMAP_FRUTA = 
	    {
			{' ','*'},
			{' ',' '}
		};
		public static final char[][] BITMAP_FRUTA_NO_COMESTIBLE = 
	    {
			{' ',' '},
			{' ',' '}
		};
		
		public static final char[][] BITMAP_ASTEROIDE = 
	    {
			{'*','*'},
			{'*','*'}
		};
		
	//------------------------------- FIN PROPIEDADES --------------------------------------------//
		
	//------------------------------- CONSTRUCTORES ----------------------------------------------//
	//CONSTRUCTOR POR DEFECTO
	public Bitmap()
	{
		alto = 0;
		ancho = 0;
		array2D = null;
	}
	//CONSTRUCTOR SOBRECARGADO
	public Bitmap(int alto, int ancho, char [][] array2D)
	{
		if ( alto >= ALTO_MINIMO && alto <= ALTO_MAXIMO )
		{
			this.alto = alto;
		}
		else
		{

		}

		if ( ancho >= ANCHO_MINIMO && ancho <= ANCHO_MAXIMO )
		{
			this.ancho    = ancho;
		}
		else
		{

		}
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
	//------------------------------- FIN METODOS AÑADIDOS ---------------------------------------//
}
