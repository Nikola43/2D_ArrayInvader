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

import java.util.*;

public class Main
{
	public static int ALTO_PANTALLA  = 32;
	public static int ANCHO_PANTALLA = 64;
	
	public static void main(String[] Args)
	{		
		int teclaPulsada = 0;
		boolean gameOver = false;
		char opcionJugador = 'n';

		Scanner scanner = new Scanner(System.in);
		Bitmap pantalla = new Bitmap(ALTO_PANTALLA , ANCHO_PANTALLA, new char[ALTO_PANTALLA][ANCHO_PANTALLA]);
		Jugador jugador = new Jugador(28,30,10,1,true, new Bitmap(3, 3, Bitmap.BITMAP_JUGADOR_ARRIBA));
		Fruta fruta1 = new Fruta(10, 10, new Bitmap(2,2, Bitmap.BITMAP_FRUTA));
		Fruta fruta2 = new Fruta(10, 20, new Bitmap(2,2, Bitmap.BITMAP_FRUTA));
		Fruta fruta3 = new Fruta(10, 30, new Bitmap(2,2, Bitmap.BITMAP_FRUTA));
		Fruta fruta4 = new Fruta(20, 10, new Bitmap(2,2, Bitmap.BITMAP_FRUTA));
		Fruta fruta5 = new Fruta(20, 20, new Bitmap(2,2, Bitmap.BITMAP_FRUTA));
		Fruta fruta6 = new Fruta(20, 30, new Bitmap(2,2, Bitmap.BITMAP_FRUTA));

		LeerTeclasUsandoCPP teclas = new LeerTeclasUsandoCPP();
		Random rand = new Random();
		int n = 5 + rand.nextInt((10 - 5) + 1);

		do
		{
			do
			{
				System.out.print("\t Vida: "+jugador.getVida()+"\t"+"Posicion X: "+jugador.getPosicionX()+"\t"+"Posicion Y: "+jugador.getPosicionY()+"\n");
		        pantalla.insertarBitmap(fruta1.getBitmap(), 8,  5 + rand.nextInt((10 - 5) + 1));
		        pantalla.insertarBitmap(fruta2.getBitmap(), 16, 5 + rand.nextInt((10 - 5) + 1));
		        pantalla.insertarBitmap(fruta3.getBitmap(), 24, 5 + rand.nextInt((10 - 5) + 1));
		        pantalla.insertarBitmap(fruta4.getBitmap(), 8,  15 + rand.nextInt((20 - 15) + 1));
		        pantalla.insertarBitmap(fruta5.getBitmap(), 16, 15 + rand.nextInt((20 - 15) + 1));
		        pantalla.insertarBitmap(fruta6.getBitmap(), 24, 15 + rand.nextInt((20 - 15) + 1));

		        pantalla.insertarBitmap(jugador.getBitmap(), jugador.getPosicionY(), jugador.getPosicionX());
		        pantalla.pintarMiBitmap();
		        pantalla.limpiarBitmap();
		        GestionBitmap.refrescarPantalla(50);

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

				if ( jugador.detectarColision(fruta1,fruta2,fruta3,fruta4,fruta5,fruta6) == true )
				{
					jugador.setVida(jugador.getVida() - 1);
				}
				if ( jugador.getVida() <= 0)
				{
					gameOver = true;
				}
			} while( gameOver == false );

			if (gameOver == true)
			{
				do
				{
					System.out.print("Desea jugar de nuevo(s/n)?: ");
					opcionJugador = Character.toLowerCase(scanner.next().charAt(0));
				} while ( opcionJugador != 's' && opcionJugador != 'n');

				if ( opcionJugador == 's')
				{
					gameOver = false;
					jugador.setPosicionY(28);
					jugador.setPosicionX(30);
					jugador.setVida(10);
				}
			}
		} while ( opcionJugador == 's' ) ;	
	}
}
