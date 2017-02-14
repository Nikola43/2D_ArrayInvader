/*
    CLASE Jugador
    
    PROPIEDADES
        BASICAS
            posicionY  : tipo entero   : consultable
            posicionX  : tipo entero   : consultable
            direccionY : tipo entero   : consultable
            direccionX : tipo entero   : consultable
            vida       : tipo entero   : consultable y modificable
            vivo       : tipo booleano : consultable y modificable
            puntuacion : tipo entero   : consultable y modificable
            miBitMap   : tipo Bitmap   : consultable 

        DERIVADAS
            NINGUNA

        COMPARTIDAS
            NINGUNA

    RESTRICCIONES
        posicionY  debe estar comprendida en un rango de entre 0 y 64
        posicionX  debe estar comprendida en un rango de entre 0 y 64
        direccionY debe estar comprendida en un rango de entre 0 y 64
        direccionX debe estar comprendida en un rango de entre 0 y 64
        vida       debe estar comprendida en un rango de entre 0 y 100
        puntuacion debe ser mayor o igual que 0

    INTERFAZ
        METODOS CONSULTORES
	        public int getPosicionY()
	        public int getPosicionX() 
	        public int getDireccionY() 
	        public int getDireccionX() 
	        public int getVida() 
	        public boolean getVivo() 
	        public int getPuntuacion() 
	        public BitMap getMyBitMap() 

        METODOS MODIFICADORES
            public void setPosicionY(int posicionY) 
	        public void setPosicionX(int posicionX) 
	        public void setDireccionX(int direccionX)
	        public void setDireccionY(int direccionY) 
	        public void setVida(int vida) 
	        public void setVivo(boolean vivo) 
	        public void setPuntuacion(int puntuacion)
	        public void setMyBitMap(BitMap myBitMap)
            
        METODOS HEREDADOS
            public String toString()
            public int hashCode()
            public Jugador clone()
            public boolean equals(Object object)
            public int compareTo(Jugador jugador)
        
        METODOS AÑADIDOS
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
	private int direccionY;
	private int direccionX;
	private int vida;
	private boolean vivo;
	private int puntuacion;
	private BitMap myBitMap;

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
	direccionY = 1;
	direccionX = 1;
	vida = 1;
	vivo = true;
	puntuacion = 1;
}

//CONSTRUCTOR SOBRECARGADO
public Jugador(int posicionY, int posicionX, int direccionX, int direccionY, int vida, boolean vivo, int puntuacion, BitMap miBitMap)
{
	this.posicionY  = posicionY;
	this.posicionX  = posicionX;
	this.direccionX = direccionY;
	this.direccionY = direccionX;
	this.vida = vida;
	this.vivo = vivo;
	this.puntuacion = puntuacion;
	this.miBitMap = miBitMap;
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
	
public int getDireccionY() 
{
	return direccionY;
}
	
public int getDireccionX() 
{
	return direccionX;
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
	
public BitMap getMiBitMap() 
{
	return miBitMap;
}
//------------------------------- FIN METODOS CONSULTORES ------------------------------------//

//------------------------------- METODOS MODIFICADORES --------------------------------------//
private void setPosicionY(int posicionY) 
{
	this.posicionY = posicionY;
}

private void setPosicionX(int posicionX) 
{
	this.posicionX = posicionX;
}

private void setDireccionX(int direccionX)
{
	this.direccionX = direccionX;
}
	
private void setDireccionY(int direccionY) 
{
	this.direccionY = direccionY;
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
	
private void setMiBitMap(BitMap miBitMap)
{
	this.miBitMap = miBitMap;
}
//------------------------------- FIN METODOS MODIFICADORES ----------------------------------//   

//------------------------------- METODOS HEREDADOS ------------------------------------------// 
//------------------------------- FIN METODOS HEREDADOS --------------------------------------// 
 
//------------------------------- METODOS AÑADIDOS -------------------------------------------// 
public void moverArriba(int numeroPosiciones)
{
	if ( posicionY - numeroPosiciones > 0 )
	{
		setPosicionY(posicionY -= numeroPosiciones);
	}
}
	
public void moverAbajo(int numeroPosiciones) 
{
	if ( posicionY + numeroPosiciones < BitMaps.pantallaBitMap.getMAX_Y() - 2 )
	{
		setPosicionY(posicionY +=  numeroPosiciones);
	}	
}
	
	
public void moverIzquierda(int numeroPosiciones)
{
	if ( posicionX - numeroPosiciones > 0 )
	{
		setPosicionX(posicionX -= numeroPosiciones);
	}
}
	
public void moverDerecha(int numeroPosiciones) 
{
	if ( posicionX + numeroPosiciones < BitMaps.pantallaBitMap.getMAX_X() - 2 )
	{
		setPosicionX(posicionX += numeroPosiciones);
	}
}
//------------------------------- FIN METODOS AÑADIDOS ---------------------------------------// 
