/*
    CLASE BitMap
    
    PROPIEDADES
        BASICAS
            ANCHO        : tipo entero   : consultable
            ALTO         : tipo entero   : consultable
            miBitMap[][] : tipo caracter : consultable

        DERIVADAS
            NINGUNA

        COMPARTIDAS
            NINGUNA

    RESTRICCIONES
        NINGUNA

    INTERFAZ
        METODOS CONSULTORES
            public int getMAX_Y() 	
	        public int getMAX_X() 
	        public char[][] getMyBitMap()

        METODOS MODIFICADORES
            public void setMAX_Y(int MAX_Y) 
	        public void setMAX_X(int MAX_X) 
	        public void setMyBitMap(char[][] myBitMap) 
	                  
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
        private int MAX_Y, MAX_X;
	    char myBitMap[][] = new char[MAX_Y][MAX_Y];

    //DERIVADAS
        //NINGUNA

    //COMPARTIDAS
        //NINGUNA
//------------------------------- FIN PROPIEDADES --------------------------------------------//
	
//------------------------------- CONSTRUCTORES ----------------------------------------------//
//CONSTRUCTOR POR DEFECTO
public BitMap()
{
	MAX_Y = 1;
	MAX_X = 1;
	myBitMap[0][0] = 0;
}
//CONSTRUCTOR SOBRECARGADO
public BitMap(int MAX_Y, int MAX_X, char [][] bitMap)
{
	this.MAX_Y    = MAX_Y;
	this.MAX_X    = MAX_X;
	this.myBitMap = bitMap;
}
//CONSTRUCTOR DE COPIA
public BitMap(BitMap bitMap)
{
	this.MAX_Y    = bitMap.MAX_Y;
	this.MAX_X    = bitMap.MAX_X;
	this.myBitMap = bitMap.myBitMap;
}
//------------------------------- FIN CONSTRUCTORES ------------------------------------------//

//------------------------------- METODOS CONSULTORES ----------------------------------------//
public int getMAX_Y() 
{
	return MAX_Y;
}
	
public int getMAX_X() 
{
	return MAX_X;
}
	
public char[][] getMyBitMap() 
{
	return myBitMap;
}
//------------------------------- FIN METODOS CONSULTORES ------------------------------------//

//------------------------------- METODOS MODIFICADORES --------------------------------------//
public void setMAX_Y(int MAX_Y) 
{
	this.MAX_Y = MAX_Y;
}

public void setMAX_X(int MAX_X) 
{
	this.MAX_X = MAX_X;
}
	
public void setMyBitMap(char[][] myBitMap) 
{
	this.myBitMap = myBitMap;
}
//------------------------------- FIN METODOS MODIFICADORES ----------------------------------//   

//------------------------------- METODOS HEREDADOS ------------------------------------------// 
//------------------------------- FIN METODOS HEREDADOS --------------------------------------// 
 
//------------------------------- METODOS AÑADIDOS -------------------------------------------// 
//------------------------------- FIN METODOS AÑADIDOS ---------------------------------------//
