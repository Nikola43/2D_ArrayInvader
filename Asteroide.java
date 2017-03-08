/*
    CLASE Asteroide
    
    PROPIEDADES
        BASICAS
            posicionY            : tipo entero   : consultable y modificable
            posicionX            : tipo entero   : consultable y modificable
            capacidadDestruccion : tipo entero   : consultable y modificable
            bitMap               : tipo BitMap   : consultable

        DERIVADAS
            NINGUNA

        COMPARTIDAS
            NINGUNA

    RESTRICCIONES
        posicionY debe estar entre 0 y el alto maximo del bitmap donde se desea posicionar
        posicionX debe estar entre 0 y el alto maximo del bitmap donde se desea posicionar
        capacidadDestruccion no puede ser menor que 1 ni mayor que 10
        bitmap debe ser un array bidimensinal que debe tener dos columnas y dos filas

    INTERFAZ
        //METODOS CONSULTORES
	        public int getPosicionY()
	        public int getPosicionX() 
	        public int getCapacidadDestruccion()
	        public BitMap getBitMap() 

        //METODOS MODIFICADORES
            public void setPosicionY(int posicionY) 
	        public void setPosicionX(int posicionX)
	        public void setCapacidadDestruccion(int capacidadDestruccion)
	        private void setBitMap(Bitmap bitmap)
            
        //METODOS HEREDADOS
            public String toString()
            public int hashCode()
            public Asteroide clone()
            public boolean equals(Object object)
            public int compareTo(Asteroide Asteroide)
        
        //METODOS AÑADIDOS
*/

public class Asteroide implements Cloneable, Comparable<Asteroide>
{
	//------------------------------- PROPIEDADES -----------------------------------------------//
		//BASICAS
		private int posicionY;
		private int posicionX;
		private int capacidadDestruccion;
		private Bitmap bitmap;
		
		//DERIVADAS
			//NINGUNA

		//COMPARTIDAS
			//NINGUNA

	//------------------------------- FIN PROPIEDADES --------------------------------------------//
		
	//------------------------------- CONSTRUCTORES ----------------------------------------------//
	//CONSTRUCTOR POR DEFECTO
	public Asteroide()
	{
		posicionY            = 0;
		posicionX            = 0;
		capacidadDestruccion = 0;
		bitmap               = null;
	}
	//CONSTRUCTOR SOBRECARGADO
	public Asteroide(int posicionY, int posicionX, int capacidadDestruccion, Bitmap bitmap) throws AsteroidePosicionNoValidaException, AsteroideCapacidadDestruccionNoValidaException, AsteroideDimensionNoValidaException
	{
		if ( posicionY >= 0 && posicionY < Bitmap.ALTO_MAXIMO)
		{
			this.posicionY = posicionY;
		}
		else
		{
			throw new AsteroidePosicionNoValidaException("posicionY debe estar entre 0 y el alto maximo del bitmap donde se desea posicionar");
		}
		if ( posicionX >= 0 && posicionX < Bitmap.ANCHO_MAXIMO)
		{
			this.posicionX = posicionX;
		}
		else
		{
			throw new AsteroidePosicionNoValidaException("posicionX debe estar entre 0 y el alto maximo del bitmap donde se desea posicionar");
		}
		if ( capacidadDestruccion >= 1 && capacidadDestruccion <= 10)
		{
			this.capacidadDestruccion = capacidadDestruccion;
		}
		else
		{
			throw new AsteroideCapacidadDestruccionNoValidaException("capacidadDestruccion debe estar entre 1 y 10");
		}
		if ( bitmap.getAlto() == Bitmap.ALTO_MINIMO && bitmap.getAncho() == Bitmap.ANCHO_MINIMO )
		{
			this.bitmap = bitmap;
		}
		else
		{
			throw new AsteroideDimensionNoValidaException("El bitmap debe tener 2 filas y 2 columnas");
		}
	}
	//CONSTRUCTOR DE COPIA
	public Asteroide(Asteroide asteroide)
	{
		this.posicionY            = asteroide.getPosicionY();
		this.posicionX            = asteroide.getPosicionX();
		this.capacidadDestruccion = asteroide.getCapacidadDestruccion();
		this.bitmap               = asteroide.getBitmap();
	}
	//------------------------------- FIN CONSTRUCTORES ------------------------------------------//

	//------------------------------- METODOS CONSULTORES ----------------------------------------//
	public int getPosicionY() 
	{
		return posicionY;
	}
	public int getPosicionX() 
	{
		return posicionX;
	}
	public int getCapacidadDestruccion()
	{
		return capacidadDestruccion;
	}
	public Bitmap getBitmap() 
	{
		return bitmap;
	}
	//------------------------------- FIN METODOS CONSULTORES ------------------------------------//

	//------------------------------- METODOS MODIFICADORES --------------------------------------//
	public void setPosicionY(int posicionY) throws AsteroidePosicionNoValidaException
	{
		if ( posicionY > 0 && posicionY < Bitmap.ALTO_MAXIMO)
		{
			this.posicionY = posicionY;
		}
		else
		{
			throw new AsteroidePosicionNoValidaException("posicionY debe estar entre 0 y el alto maximo del bitmap donde se desea posicionar");
		}
	}
	public void setPosicionX(int posicionX) throws AsteroidePosicionNoValidaException
	{
		if ( posicionX > 0 && posicionX < Bitmap.ANCHO_MAXIMO)
		{
			this.posicionX = posicionX;
		}
		else
		{
			throw new AsteroidePosicionNoValidaException("posicionX debe estar entre 0 y el alto maximo del bitmap donde se desea posicionar");
		}
	}
	public void setCapacidadDestruccion(int capacidadDestruccion) throws AsteroideCapacidadDestruccionNoValidaException
	{
		if ( capacidadDestruccion >= 1 && capacidadDestruccion <= 10)
		{
			this.capacidadDestruccion = capacidadDestruccion;
		}
		else
		{
			throw new AsteroideCapacidadDestruccionNoValidaException("capacidadDestruccion debe estar entre 1 y 10");
		}
	}
	private void setBitMap(Bitmap bitmap) throws AsteroideDimensionNoValidaException
	{
		if ( bitmap.getAlto() == Bitmap.ALTO_MINIMO && bitmap.getAncho() == Bitmap.ANCHO_MINIMO )
		{
			this.bitmap = bitmap;
		}
		else
		{
			throw new AsteroideDimensionNoValidaException("El bitmap debe tener 2 filas y 2 columnas");
		}
	}
	//------------------------------- FIN METODOS MODIFICADORES ----------------------------------//   

	//------------------------------- METODOS HEREDADOS ------------------------------------------//
	@Override
	public String toString()
	{
		String toString;
		toString = posicionY+", "+posicionX+", "+capacidadDestruccion+", "+bitmap.toString();
		return toString;
	}
	@Override
	public int hashCode()
	{
		int hashCode;
		hashCode = posicionY * capacidadDestruccion / posicionX * bitmap.getArray2D()[1][0] * 13;
		return hashCode;
	}
	@Override
	public Asteroide clone()
	{
		Asteroide clonAsteroide = null;
		try
		{
			clonAsteroide = (Asteroide) super.clone();
		}
		catch (CloneNotSupportedException error)
		{
			System.out.println("Error: No se pudo clonar el objeto Asteroide");
		}
		return clonAsteroide;
	}
	/* INTERFAZ
     * Cabecera:
     *     public boolean equals(Object object)
     *
     * Descripcion:
     *     Comprueba si el objeto pasado por parametro es igual que el objeto que
     *     lanza el metodo
     *
     * Precondiciones:
     *     Ninguna
     *
     * Entradas:
     *     Un objeto
     *
     * Salidas:
     *     Un booleano
     *
     * Postcondiciones:
     *     Devolvera VERDADERO si los objetos son iguales y FALSO cuando no lo sean
     *     Los objetos seran iguales cuando tengan la misma capacidad de destruccion y el mismo bitmap
     */
	@Override
	public boolean equals(Object object)
	{
		boolean sonIguales = false;

		if (object != null && object instanceof Asteroide)
		{
			Asteroide asteroide = (Asteroide) object;

			if (capacidadDestruccion == asteroide.getCapacidadDestruccion() && bitmap == asteroide.getBitmap())
			{
				sonIguales = true;
			}
		}
		return sonIguales;
	}
	/* INTERFAZ
     * Cabecera:
     *     public int compareTo(Asteroide asteroide)
     *
     * Descripcion:
     *     Compara un objeto con otro
     *
     * Precondiciones:
     *     Ninguna
     *
     * Entradas:
     *     Un objeto tipo Asteroide
     *
     * Salidas:
     *     Un entero
     *
     * Postcondiciones:
     *     Devolvera -1 cuando sea menor, 0 cuando sean iguales, 1 cuando sea mayor
     *     Se comparara la posicionY y la posicionX
     *     Sera menor cuando las posiciones sean menores
     *     Sera igual cuando las posiciones sean iguales
     *     Sera mayor cuando las posiciones sean mayores
    */
	@Override
	public int compareTo(Asteroide asteroide)
	{
		int comparacion = -1;


		if (posicionY == asteroide.getPosicionY() && posicionX == asteroide.getPosicionX()) //Iguales
		{
			comparacion = 0;
		}
		else if (posicionY > asteroide.getPosicionY() && posicionX > asteroide.getPosicionX() ||
				 posicionY > asteroide.getPosicionY() && posicionX == asteroide.getPosicionY()||
				 posicionY == asteroide.getPosicionY() && posicionX > asteroide.getPosicionY())
		{
			comparacion = 1;
		}
		else if (posicionY < asteroide.getPosicionY() && posicionX < asteroide.getPosicionX() ||
				 posicionY < asteroide.getPosicionY() && posicionX == asteroide.getPosicionX()||
				 posicionY == asteroide.getPosicionY() && posicionX < asteroide.getPosicionX())
		{
			comparacion = -1;
		}
		else if (posicionY > asteroide.getPosicionY() && posicionX < asteroide.getPosicionY()  )
	    {
			comparacion = 1;
	    }
	    else if (posicionY < asteroide.getPosicionY() && posicionX > asteroide.getPosicionX()  )
	    {
			comparacion = -1;
	    }
		return comparacion;
	}
	//------------------------------- FIN METODOS HEREDADOS --------------------------------------//
	//------------------------------- METODOS AÑADIDOS -------------------------------------------//
	public void setPosicionYX(int posicionY, int posicionX) throws AsteroidePosicionNoValidaException
	{
		if (posicionY > 0 && posicionY < Bitmap.ALTO_MAXIMO &&
			posicionX > 0 && posicionX < Bitmap.ANCHO_MAXIMO)
		{
			this.posicionX = posicionX;
		}
		else
		{
			throw new AsteroidePosicionNoValidaException("posicionY debe estar entre 0 y el alto maximo del bitmap donde se desea posicionar"+"\n"+
					                                     "posicionX debe estar entre 0 y el alto maximo del bitmap donde se desea posicionar");
		}
	}
	//------------------------------- FIN METODOS AÑADIDOS ---------------------------------------// 
}
