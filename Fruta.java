/*
    CLASE Fruta
    
    PROPIEDADES
        BASICAS
            posicionY  : tipo entero   : consultable
            posicionX  : tipo entero   : consultable
            bitMap     : tipo BitMap   : consultable 

        DERIVADAS
            NINGUNA

        COMPARTIDAS
            NINGUNA

    RESTRICCIONES
        posicionY  debe estar comprendida en un rango de entre 0 y 64
        posicionX  debe estar comprendida en un rango de entre 0 y 64

    INTERFAZ
        //METODOS CONSULTORES
	        public int getPosicionY()
	        public int getPosicionX() 
	        public BitMap getBitMap() 

        //METODOS MODIFICADORES
            public void setPosicionY(int posicionY) 
	        public void setPosicionX(int posicionX) 
	        public void setBitMap(BitMap myBitMap)
            
        //METODOS HEREDADOS
            public String toString()
            public int hashCode()
            public Fruta clone()
            public boolean equals(Object object)
            public int compareTo(Fruta Fruta)
        
        //METODOS AÑADIDOS
*/
public class Fruta
{
	//------------------------------- PROPIEDADES -----------------------------------------------//
		//BASICAS
		private int posicionY;
		private int posicionX;
		private Bitmap bitmap;

		//DERIVADAS
			//NINGUNA

		//COMPARTIDAS
			//NINGUNA

	//------------------------------- FIN PROPIEDADES --------------------------------------------//
		
	//------------------------------- CONSTRUCTORES ----------------------------------------------//
	//CONSTRUCTOR POR DEFECTO
	public Fruta()
	{
		posicionY  = 0;
		posicionX  = 0;
		bitmap = null;
	}

	//CONSTRUCTOR SOBRECARGADO
	public Fruta(int posicionY, int posicionX, Bitmap bitmap)
	{
		if ( posicionY >= 0 && posicionY < Bitmap.ALTO_MAXIMO &&
			 posicionX >= 0 && posicionX < Bitmap.ANCHO_MAXIMO)
		{
			this.posicionY = posicionY;
			this.posicionX  = posicionX;
		}
		else
		{
			throw new FrutaPosicionNoValidaException("posicionY debe estar entre 0 y el alto maximo del bitmap donde se desea posicionar");
		}

		if ( (bitmap.getAlto() >= ALTO_MINIMO && bitmap.getAlto() <= ALTO_MAXIMO) &&
		     (bitmap.getAncho() >= ANCHO_MINIMO && bitmap.getAncho() <= ANCHO_MAXIMO) )
		{
			this.bitmap = bitmap;
		}
		else
		{
			throw new FrutaDimensionNoValidaException("alto debe estar comprendido entre "+ALTO_MINIMO+" y "+ALTO_MAXIMO + "\n"+"ancho debe estar comprendido entre "+ANCHO_MINIMO+" y "+ANCHO_MAXIMO);
		}
	}
	//CONSTRUCTOR DE COPIA
	public Fruta(Fruta fruta)
	{
		posicionY  = fruta.getPosicionY();
		posicionX  = fruta.getPosicionX();
		bitmap     = fruta.getBitmap();
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
	public Bitmap getBitmap() 
	{
		return bitmap;
	}
	//------------------------------- FIN METODOS CONSULTORES ------------------------------------//

	//------------------------------- METODOS MODIFICADORES --------------------------------------//
	public void setPosicionY(int posicionY) 
	{
		if ( posicionY >= 0 && posicionY < Bitmap.ALTO_MAXIMO )
		{
			this.posicionY = posicionY;
		}
		else
		{
			throw new FrutaPosicionNoValidaException("posicionY debe estar entre 0 y el alto maximo del bitmap donde se desea posicionar");
		}
	}
	public void setPosicionX(int posicionX) 
	{
		if (posicionX >= 0 && posicionX < Bitmap.ANCHO_MAXIMO)
		{
			this.posicionX = posicionX;
		}
		else
		{
			throw new FrutaPosicionNoValidaException("posicionX debe estar entre 0 y el alto maximo del bitmap donde se desea posicionar");
		}	
	}
	private void setBitMap(Bitmap bitmap)
	{
		if ( (bitmap.getAlto() >= ALTO_MINIMO && bitmap.getAlto() <= ALTO_MAXIMO) &&
		     (bitmap.getAncho() >= ANCHO_MINIMO && bitmap.getAncho() <= ANCHO_MAXIMO) )
		{
			this.bitmap = bitmap;
		}
		else
		{
			throw new FrutaDimensionNoValidaException("alto debe estar comprendido entre "+ALTO_MINIMO+" y "+ALTO_MAXIMO + "\n"+"ancho debe estar comprendido entre "+ANCHO_MINIMO+" y "+ANCHO_MAXIMO);
		}
	}
	//------------------------------- FIN METODOS MODIFICADORES ----------------------------------//   

	//------------------------------- METODOS HEREDADOS ------------------------------------------// 
	//------------------------------- FIN METODOS HEREDADOS --------------------------------------// 
	 
	//------------------------------- METODOS AÑADIDOS -------------------------------------------//
	public void setPosicionYX(int posicionY, int posicionX)
	{
		if ( posicionY >= 0 && posicionY < Bitmap.ALTO_MAXIMO &&
		     posicionX >= 0 && posicionX < Bitmap.ANCHO_MAXIMO )
		{
			this.posicionY = posicionY;
			this.posicionX = posicionX;
		}
		else
		{
			throw new FrutaPosicionNoValidaException("posicionY debe estar entre 0 y el alto maximo del bitmap donde se desea posicionar"+"\n"+"posicionY debe estar entre 0 y el alto maximo del bitmap donde se desea posicionar"));
		}
	}
	//------------------------------- FIN METODOS AÑADIDOS ---------------------------------------// 
}
