
/*
    CLASE Jugador
    
    PROPIEDADES
        BASICAS
            posicionY  : tipo entero   : consultable
            posicionX  : tipo entero   : consultable
            vida       : tipo entero   : consultable y modificable
            vivo       : tipo booleano : consultable y modificable
            puntuacion : tipo entero   : consultable y modificable
            bitMap     : tipo BitMap   : consultable 

        DERIVADAS
            NINGUNA

        COMPARTIDAS
            NINGUNA

    RESTRICCIONES
        vida       debe estar comprendida en un rango de entre 0 y 5
        puntuacion debe ser mayor o igual que 0

    INTERFAZ
        //METODOS CONSULTORES
	        public int getPosicionY()
	        public int getPosicionX() 
	        public int getVida() 
	        public boolean getVivo() 
	        public int getPuntuacion() 
	        public BitMap getBitMap() 

        //METODOS MODIFICADORES
            public void setPosicionY(int posicionY) 
	        public void setPosicionX(int posicionX) 
	        public void setVida(int vida) 
	        public void setVivo(boolean vivo) 
	        public void setPuntuacion(int puntuacion)
	        public void setBitMap(BitMap myBitMap)
            
        //METODOS HEREDADOS
            public String toString()
            public int hashCode()
            public Jugador clone()
            public boolean equals(Object object)
            public int compareTo(Jugador jugador)
        
        //METODOS AÑADIDOS
	        public void moverArriba(int numeroPosiciones)
	        public void moverAbajo(int numeroPosiciones) 
	        public void moverIzquierda(int numeroPosiciones)
	        public void moverDerecha(int numeroPosiciones) 
*/


public class Jugador
{
	//------------------------------- PROPIEDADES -----------------------------------------------//
		//BASICAS
		private int posicionY;
		private int posicionX;
		private int vida;
		private boolean vivo;
		private int puntuacion;
		private Bitmap bitmap;

		//DERIVADAS
			//NINGUNA

		//COMPARTIDAS
			//NINGUNA

	//------------------------------- FIN PROPIEDADES --------------------------------------------//
		
	//------------------------------- CONSTRUCTORES ----------------------------------------------//
	//CONSTRUCTOR POR DEFECTO
	public Jugador()
	{
		posicionY  = 1;
		posicionX  = 1;
		vida = 1;
		puntuacion = 1;
		vivo = true;
	}

	//CONSTRUCTOR SOBRECARGADO
	public Jugador(int posicionY, int posicionX, int vida, int puntuacion, boolean vivo, Bitmap bitmap)
	{
		this.posicionY  = posicionY;
		this.posicionX  = posicionX;
		this.vida = vida;
		this.vivo = vivo;
		this.bitmap = bitmap;
		this.puntuacion = puntuacion;
	}
	//CONSTRUCTOR DE COPIA

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
	public int getVida() 
	{
		return vida;
	}
	public boolean getVivo() 
	{
		return vivo;
	}
	public int getPuntuacion() 
	{
		return puntuacion;
	}	
	public Bitmap getBitmap() 
	{
		return bitmap;
	}
	//------------------------------- FIN METODOS CONSULTORES ------------------------------------//

	//------------------------------- METODOS MODIFICADORES --------------------------------------//
	public void setPosicionY(int posicionY) 
	{
		this.posicionY = posicionY;
	}
	public void setPosicionX(int posicionX) 
	{
		this.posicionX = posicionX;
	}
	public void setVida(int vida) 
	{
		this.vida = vida;
	}	
	public void setVivo(boolean vivo) 
	{
		this.vivo = vivo;
	}
	public void setPuntuacion(int puntuacion)
	{
		this.puntuacion = puntuacion;
	}	
	public void setBitMap(Bitmap bitmap)
	{
		this.bitmap = bitmap;
	}
	//------------------------------- FIN METODOS MODIFICADORES ----------------------------------//   

	//------------------------------- METODOS HEREDADOS ------------------------------------------// 
	//------------------------------- FIN METODOS HEREDADOS --------------------------------------// 
	 
	//------------------------------- METODOS AÑADIDOS -------------------------------------------// 
	public void moverArriba(int numeroPosiciones)
	{
		if ( posicionY - numeroPosiciones > 0 )
		{
			setBitMap(new Bitmap(3, 3, Bitmap.BITMAP_JUGADOR_ARRIBA));
			setPosicionY(posicionY -= numeroPosiciones);
		}
	}
		
	public void moverAbajo(int numeroPosiciones) 
	{
		if ( posicionY + numeroPosiciones < Bitmap.ALTO_MAXIMO - 2 )
		{
			setBitMap(new Bitmap(3, 3, Bitmap.BITMAP_JUGADOR_ABAJO));
			setPosicionY(posicionY +=  numeroPosiciones);
		}	
	}
		
		
	public void moverIzquierda(int numeroPosiciones)
	{
		if ( posicionX - numeroPosiciones > 0 )
		{
			setBitMap(new Bitmap(3, 3, Bitmap.BITMAP_JUGADOR_IZQUIERDA));
			setPosicionX(posicionX -= numeroPosiciones);
		}
	}
		
	public void moverDerecha(int numeroPosiciones) 
	{
		if ( posicionX + numeroPosiciones < Bitmap.ANCHO_MAXIMO - 2 )
		{
			setBitMap(new Bitmap(3, 3, Bitmap.BITMAP_JUGADOR_DERECHA));
			setPosicionX(posicionX += numeroPosiciones);
		}
	}

	public boolean detectarColision(Object... object)
	{
		boolean hayColision = false;
		for(int i=0; i < object.length; i++)
		{
			if (object[i] != null && object[i] instanceof Asteroide || object[i] instanceof Fruta)
			{
				if ( object[i] instanceof Fruta )
				{
					Fruta fruta = (Fruta) object[i];
					if (fruta.getPosicionX() + 1 == this.getPosicionX() && fruta.getPosicionY() == this.getPosicionY() + 1)
					{
						fruta.setBitMap(new Bitmap(2, 2, Bitmap.BITMAP_FRUTA_NO_COMESTIBLE));
						hayColision = true;
					}
				}

				if ( object[i] instanceof Asteroide )
				{
					Asteroide asteroide = (Asteroide) object[i];
					if (asteroide.getPosicionX() + 1 == this.getPosicionX() && asteroide.getPosicionY() == this.getPosicionY() + 1 )
					{
						hayColision = true;
					}
				}
			}
		}
		return hayColision;
	}
	//------------------------------- FIN METODOS AÑADIDOS ---------------------------------------// 
}
