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
	public static int ALTO_PANTALLA  = 32;
	public static int ANCHO_PANTALLA = 64;
	
	public static void main(String[] Args)
	{		
		int teclaPulsada = 0;
		
		Bitmap pantalla = new Bitmap(ALTO_PANTALLA , ANCHO_PANTALLA, new char[ALTO_PANTALLA][ANCHO_PANTALLA]);
		Jugador jugador = new Jugador(5,5,1,1,true, new Bitmap(3, 3, Bitmap.BITMAP_JUGADOR_ARRIBA));
		
		LeerTeclasUsandoCPP teclas = new LeerTeclasUsandoCPP();
				
		while( teclaPulsada != LeerTeclasUsandoCPP.ESC )
        {
			System.out.print("\t Vida: "+jugador.getVida()+"\t"+"Posicion X: "+jugador.getPosicionX()+"\t"+"Posicion Y: "+jugador.getPosicionY()+"\n");
            pantalla.insertarBitmap(new Bitmap(4,6, Bitmap.BITMAP_ASTEROIDE), 10, 10);
            pantalla.insertarBitmap(jugador.getBitmap(), jugador.getPosicionY(), jugador.getPosicionX());
			pantalla.refrescarPantalla();
			
			if ( teclas.hayTeclaPulsada() == true )
            {
            	//leemos la tecla usando el metodo escrito en c que esta dentro de la libreria que compilamos
            	teclaPulsada = teclas.leerTecla(); 
            }  
            switch ( teclaPulsada )
			{
				case LeerTeclasUsandoCPP.ARRIBA    : jugador.moverArriba(1); break;
				case LeerTeclasUsandoCPP.ABAJO     : jugador.moverAbajo(1); break;
				case LeerTeclasUsandoCPP.IZQUIERDA : jugador.moverIzquierda(1); break;
				case LeerTeclasUsandoCPP.DERECHA   : jugador.moverDerecha(1); break;
			}
			teclaPulsada = LeerTeclasUsandoCPP.STOP;
        }
	}
}
