/*
 * PROGRAMADOR 
 *     Paulo
 * 
 * FUNCIONAMIENTO 
 *  
 * REQUISITOS
 * 
 * ANALISIS
 * 
 * ENTRADAS
 * 
 * SALIDAS
 * 
 * RESTRICCIONES
 * 
 * SUPOSICIONES 
 * 
 * PSUDOCODIGO GENERALIZADO
 * 
 * 
 */ 


public class Main
{
	public static void main(String[] Args)
	{
		final int ANCHO_PANTALLA = 64;
		final int ALTO_PANTALLA = 32;
		
		Bitmap pantalla = new Bitmap(ALTO_PANTALLA , ANCHO_PANTALLA, new char[ALTO_PANTALLA][ANCHO_PANTALLA]);
		Jugador jugador = new Jugador(1,1,1,1,1,true,1, new Bitmap(11, 5, Bitmap.BITMAP_JUGADOR));
		
		
		
		pantalla.insertarBitmap(new Bitmap(11, 5, Bitmap.BITMAP_JUGADOR));
		pantalla.pintarPantalla();
	}
}
