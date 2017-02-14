

public class Main
{
	public static void main(String[] Args)
	{
		final int ANCHO_PANTALLA = 64;
		final int ALTO_PANTALLA = 32;
		
		BitMap pantalla = new BitMap(ALTO_PANTALLA , ANCHO_PANTALLA);
		pantalla.rellenarBitMap('1');
		pantalla.pintarPantalla();
	}
}
