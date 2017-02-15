
public class TestBitmap
{
	public static void main(String[] Args)
	{
		int ALTO_PANTALLA = 16;
		int ANCHO_PANTALLA = 32;
		
		Bitmap pantalla = new Bitmap(ALTO_PANTALLA , ANCHO_PANTALLA, new char[ALTO_PANTALLA][ANCHO_PANTALLA]);
		Jugador jugador = new Jugador(1,1,1,1,1,true,1, new Bitmap(11, 5, Bitmap.BITMAP_JUGADOR));
		
		
		Bitmap p2 = new Bitmap(5, 5, new char[5][5]);
		p2.rellenarBitmap('#');
		
		pantalla.insertarBitmap(p2, 0, 0);
		pantalla.pintarMiBitmap();
		
		
		

	}
}
