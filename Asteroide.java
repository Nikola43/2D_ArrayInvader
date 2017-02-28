/*
    CLASE Asteroide
    
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
            public Asteroide clone()
            public boolean equals(Object object)
            public int compareTo(Asteroide Asteroide)
        
        //METODOS AÑADIDOS
*/

public class Asteroide
{
	//------------------------------- PROPIEDADES -----------------------------------------------//
		//BASICAS
		private int posicionY;
		private int posicionX;
		private Bitmap bitmap;
		private int capacidadDestruccion;

		//DERIVADAS
			//NINGUNA

		//COMPARTIDAS
			//NINGUNA

	//------------------------------- FIN PROPIEDADES --------------------------------------------//
		
	//------------------------------- CONSTRUCTORES ----------------------------------------------//
	//CONSTRUCTOR POR DEFECTO
	public Asteroide()
	{
		posicionY  = 1;
		posicionX  = 1;
		capacidadDestruccion = 1;
	}

	//CONSTRUCTOR SOBRECARGADO
	public Asteroide(int posicionY, int posicionX, Bitmap bitmap, int capacidadDestruccion)
	{
		this.posicionY  = posicionY;
		this.posicionX  = posicionX;
		this.bitmap = bitmap;
		this.capacidadDestruccion = capacidadDestruccion;
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
	public Bitmap getBitmap() 
	{
		return bitmap;
	}
	public int capacidadDestruccion() 
	{
		return capacidadDestruccion;
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
	public void setBitMap(Bitmap bitmap)
	{
		this.bitmap = bitmap;
	}
	public void setPosicionYX(int posicionY, int posicionX)
	{
		this.posicionY = posicionY;
		this.posicionX = posicionX;
	}
	public void  setCapacidadDestruccion(int capacidadDestruccion)
	{
		this.capacidadDestruccion = capacidadDestruccion;
	}
	//------------------------------- FIN METODOS MODIFICADORES ----------------------------------//   

	//------------------------------- METODOS HEREDADOS ------------------------------------------// 
	//------------------------------- FIN METODOS HEREDADOS --------------------------------------// 
	 
	//------------------------------- METODOS AÑADIDOS -------------------------------------------//
	//------------------------------- FIN METODOS AÑADIDOS ---------------------------------------// 
}
