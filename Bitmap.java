
/*
    CLASE Bitmap
    
    PROPIEDADES
        BASICAS
            array2D[][]   : tipo caracter : consultable y modificable

        DERIVADAS
            alto          : tipo entero   : consultable calculada
            ancho         : tipo entero   : consultable calculada

        COMPARTIDAS
            ALTO_MINIMO  = 2;
			ANCHO_MINIMO = 2;
		    ALTO_MAXIMO  = 32;
		    ANCHO_MAXIMO = 64;
			BITMAP_JUGADOR_ARRIBA      : tipo array[][] : constante consultable
			BITMAP_JUGADOR_ABAJO       : tipo array[][] : constante consultable
			BITMAP_JUGADOR_IZQUIERDA   : tipo array[][] : constante consultable
			BITMAP_JUGADOR_DERECHA     : tipo array[][] : constante consultable
			BITMAP_FRUTA               : tipo array[][] : constante consultable
			BITMAP_FRUTA_NO_COMESTIBLE : tipo array[][] : constante consultable
			BITMAP_ASTEROIDE           : tipo array[][] : constante consultable

    RESTRICCIONES
        NINGUNA

    INTERFAZ
        METODOS CONSULTORES
            public int getAlto() 	
	        public int getAncho() 
	        public char[][] getArray2D()

        METODOS MODIFICADORES
            private void setAlto(int Alto) 
	        private void setAncho(int Ancho) 
	        public  void setArray2D(char[][] array2D) 
	                  
        METODOS HEREDADOS
            public String toString()
            public int hashCode()
            public Jugador clone()
            public boolean equals(Object object)
            public int compareTo(Jugador jugador)
        
        METODOS AÑADIDOS
        	public int devolverLongitudColumnaMasGrande(char[][] array)
        	public void insertarBitmap(Bitmap bitmap, int posicionY, int posicionX)
        	public void pintarMiBitmap()
        	public void limpiarBitmap()
        	public void rellenarBitmap(char caracter)


	        
*/

public class Bitmap 
{
	//------------------------------- PROPIEDADES -----------------------------------------------//
	    //BASICAS
		private char[][] array2D;

	    //DERIVADAS
	    private int alto, ancho;

	    //COMPARTIDAS
		//Definimos las dimensiones minimas y maximas de un bitmap
		public static final int ALTO_MINIMO  = 2;
		public static final int ANCHO_MINIMO = 2;
		public static final int ALTO_MAXIMO  = 32;
		public static final int ANCHO_MAXIMO = 64;

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
	public Bitmap(char [][] array2D)
	{
		if ( array2D.length; >= ALTO_MINIMO && array2D.length; <= ALTO_MAXIMO )
		{
			alto = array2D.length;
		}
		else
		{
			throw new BitmapDimensionNoValidaException("alto debe estar comprendido entre "+ALTO_MINIMO+" y "+ALTO_MAXIMO);
		}
		
		if ( devolverLongitudColumnaMasGrande(array2D) >= ANCHO_MINIMO && devolverLongitudColumnaMasGrande(array2D) <= ANCHO_MAXIMO )
		{
			ancho = devolverLongitudColumnaMasGrande(array2D);
		}	
		else
		{
			throw new BitmapDimensionNoValidaException("ancho debe estar comprendido entre "+ANCHO_MINIMO+" y "+ANCHO_MAXIMO);
		}

		if ( (array2D.length >= ALTO_MINIMO && array2D.length <= ALTO_MAXIMO) &&
		     (devolverLongitudColumnaMasGrande() >= ANCHO_MINIMO && devolverLongitudColumnaMasGrande() <= ANCHO_MAXIMO) )
		{
			this.array2D   = array2D;	
		}
		else
		{
			throw new BitmapDimensionNoValidaException("alto y ancho deben ser acordes con la longitud del array bidimensional");
		}
		
	}
	//CONSTRUCTOR DE COPIA
	public Bitmap(Bitmap bitmap)
	{
		this.alto    = bitmap.getAlto();
		this.ancho   = bitmap.getAncho();
		this.array2D = bitmap.getArray2D();
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
	private void setAlto(int alto)
	{
		if ( alto >= ALTO_MINIMO && alto <= ALTO_MAXIMO )
		{
			this.alto = alto;
		}
		else
		{
			throw new BitmapDimensionNoValidaException("alto debe estar comprendido entre "+ALTO_MINIMO+" y "+ALTO_MAXIMO);
		}
	}
	private void setAncho(int ancho)
	{
		if ( devolverLongitudColumnaMasGrande(array2D) >= ANCHO_MINIMO && devolverLongitudColumnaMasGrande(array2D) <= ANCHO_MAXIMO )
		{
			this.ancho = ancho;
		}
		else
		{
			throw new BitmapDimensionNoValidaException("ancho debe estar comprendido entre "+ANCHO_MINIMO+" y "+ANCHO_MAXIMO);
		}
	}

	public void setArray2D(char[][] array2D) 
	{
		if ( (array2D.length >= ALTO_MINIMO && array2D.length <= ALTO_MAXIMO) &&
		     (devolverLongitudColumnaMasGrande(array2D) >= ANCHO_MINIMO && devolverLongitudColumnaMasGrande(array2D) <= ANCHO_MAXIMO) )
		{
			this.array2D   = array2D;	
		}
		else
		{
			throw new BitmapDimensionNoValidaException("alto y ancho deben ser acordes con la longitud del array bidimensional");
		}
	}

	//------------------------------- FIN METODOS MODIFICADORES ----------------------------------//   

	//------------------------------- METODOS HEREDADOS ------------------------------------------// 
	//------------------------------- FIN METODOS HEREDADOS --------------------------------------// 
	 
	//------------------------------- METODOS AÑADIDOS -------------------------------------------// 
	public int devolverLongitudColumnaMasGrande(char[][] array)
	{
		int contadorColumnasValidas = 0;
		int columnaMasGrande = 0;
	
		//Recorremos todas las columnas
		for (int fila = 0; fila < array.length; fila++ )
		{
			for (int columna = 0; columna < array[fila].length; columna++ )
			{
				//Si la longitud de cada columna esta en el rango permitido
				if (array[fila].length >= ANCHO_MINIMO && array[fila].length <= ANCHO_MAXIMO)
				{
					contadorColumnasValidas++;

					//Si la columna actual es mayor que la columna mas grande del array
					if (array[fila].length > columnaMasGrande )
					{
						//Asiganmos la longitud de esa columna como la columna mas grande del array
						columnaMasGrande = array[fila].length;
					}
				}	
			}
		}
		return columnaMasGrande;
	}

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
	        for (int x = 0; x < getAncho(); x++)
	        {
	            System.out.print(array2D[y][x]);
	        }
	        System.out.println();
	    }
	}
	    
	public void limpiarBitmap()
	{
	    for (int y = 0; y < getAlto(); y++)  
	    {
	        for (int x = 0; x < getAncho(); x++)
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
