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
		char opcionJugador = 's';

		Scanner scanner = new Scanner(System.in);
		Bitmap pantalla = new Bitmap(ALTO_PANTALLA , ANCHO_PANTALLA, new char[ALTO_PANTALLA][ANCHO_PANTALLA]);
		Jugador jugador = new Jugador(5,5,1,1,true, new Bitmap(3, 3, Bitmap.BITMAP_JUGADOR_ARRIBA));
		Fruta fruta = new Fruta(10, 10, new Bitmap(2,2, Bitmap.BITMAP_FRUTA));
		
		LeerTeclasUsandoCPP teclas = new LeerTeclasUsandoCPP();

		do
		{
			if ( gameOver == false )
			{
				System.out.print("\t Vida: "+jugador.getVida()+"\t"+"Posicion X: "+jugador.getPosicionX()+"\t"+"Posicion Y: "+jugador.getPosicionY()+"\n");
		        pantalla.insertarBitmap(fruta.getBitmap(), 10, 10);
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
				gameOver = jugador.detectarColision(fruta);

			} 
			else 
			{
				System.out.println("GAME OVER");
				do
				{
					System.out.print("Desea jugar de nuevo(s/n)?: ");
					opcionJugador = Character.toLowerCase(scanner.next().charAt(0));
				} while ( opcionJugador != 's' && opcionJugador != 'n');
			}
		} while ( opcionJugador != 'n' && teclaPulsada != LeerTeclasUsandoCPP.ESC ) ;
			
		
	}
}
