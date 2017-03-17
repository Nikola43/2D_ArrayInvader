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

	
	public static void main(String[] Args)
	{		
		int teclaPulsada = 0;
		boolean gameOver = false;
		char opcionJugador = 'n';
		char opcionMenuPrincipal;

		GestionMain gestionMain = new GestionMain();

		//Declaramos los asteroides
		Asteroide asteroide1, asteroide2, asteroide3, asteroide4, asteroide5;

		//Declaramos las frutas
		Fruta fruta1, fruta2, fruta3, fruta4, fruta5;

		//Declaramos scanner para leer por teclado las opciones del usuario
		Scanner scanner = new Scanner(System.in);

		//Declaramos un objeto teclas que usa metodos en c para leer las teclas mientras juega
		LeerTeclasUsandoCPP teclas = new LeerTeclasUsandoCPP();

		//Random para los movimientos de los objetos
		Random rand = new Random();

		//Declaramos una pantalla
		Bitmap pantalla = new Bitmap(Bitmap.ALTO_MAXIMO, Bitmap.ANCHO_MAXIMO, new char[Bitmap.ALTO_MAXIMO][Bitmap.ANCHO_MAXIMO]);

		//Declaramos un jugador
		Jugador jugador = new Jugador(28,18,10,0,true, new Bitmap(3, 3, Bitmap.BITMAP_JUGADOR_ARRIBA));

		//Tiempo que dura una partida
		long duracionPartida;

		do
		{
			System.out.print("Desea jugar a 2D_ArrayInvader(s/n): ");
			opcionJugador = Character.toLowerCase(scanner.next().charAt(0));
		} while ( opcionJugador != 's' && opcionJugador != 'n');

		if ( opcionJugador == 's' )
		{
			gestionMain.mostrarMenuPrincipal();
			do
			{
				System.out.print("Que desea hacer?: ");
				opcionMenuPrincipal = Character.toLowerCase(scanner.next().charAt(0));
			} while ( opcionMenuPrincipal < '1' && opcionMenuPrincipal > '3');

			switch (opcionJugador)
			{
				case '1': jugar(); break;
				case '2': gestionMain.verMejorJugador(); break;
				case '3': gestionMain.verPeorJugador(); break;
			}
		}

		if ( opcionJugador == 's' )
		{
			do
			{
				System.out.print("Desea jugar a 2D_ArrayInvader(s/n): ");
				opcionJugador = Character.toLowerCase(scanner.next().charAt(0));
			} while ( opcionJugador != 's' && opcionJugador != 'n');
		}

	}

	public static void jugar()
	{
		duracionPartida = System.currentTimeMillis();
		try
		{
			asteroide1 = new Asteroide(10, 10, 5, new Bitmap(2, 2, Bitmap.BITMAP_ASTEROIDE));
			asteroide2 = new Asteroide(10, 10, 5, new Bitmap(2, 2, Bitmap.BITMAP_ASTEROIDE));
			asteroide3 = new Asteroide(10, 10, 5, new Bitmap(2, 2, Bitmap.BITMAP_ASTEROIDE));
			asteroide4 = new Asteroide(10, 10, 5, new Bitmap(2, 2, Bitmap.BITMAP_ASTEROIDE));
		}
		catch (AsteroideDimensionNoValidaException e)
		{
			e.printStackTrace();
		}
		catch (AsteroideCapacidadDestruccionNoValidaException e)
		{
			e.printStackTrace();
		}
		catch (AsteroidePosicionNoValidaException e)
		{
			e.printStackTrace();
		}


		Fruta fruta1 = new Fruta(10, 10, new Bitmap(2,2, Bitmap.BITMAP_FRUTA));
		Fruta fruta2 = new Fruta(10, 10, new Bitmap(2,2, Bitmap.BITMAP_FRUTA));
		Fruta fruta3 = new Fruta(10, 10, new Bitmap(2,2, Bitmap.BITMAP_FRUTA));
		Fruta fruta4 = new Fruta(10, 10, new Bitmap(2,2, Bitmap.BITMAP_FRUTA));
		Fruta fruta5 = new Fruta(10, 10, new Bitmap(2,2, Bitmap.BITMAP_FRUTA));



		do
		{
			do
			{
				System.out.print("\t Vida: "+jugador.getVida()+"\t"+"Puntuacion: "+jugador.getPuntuacion()+"\t"+"Posicion X: "+jugador.getPosicionX()+"\t"+"Posicion Y: "+jugador.getPosicionY()+"\t"+"fruta X: "+fruta1.getPosicionX()+"\t"+"fruta Y: "+fruta1.getPosicionY()+"\n");		        

		   		fruta1.setPosicionYX(8,  5 + rand.nextInt((10 - 5) + 1));
		   		try
				{
					asteroide1.setPosicionYX(16, 5 + rand.nextInt((10 - 5) + 1));

					fruta2.setPosicionYX(24, 5 + rand.nextInt((10 - 5) + 1));
					asteroide2.setPosicionYX(8,  15 + rand.nextInt((20 - 15) + 1));

					fruta3.setPosicionYX(16, 15 + rand.nextInt((20 - 15) + 1));
					asteroide3.setPosicionYX(24, 15 + rand.nextInt((20 - 15) + 1));

					fruta4.setPosicionYX(8, 25 + rand.nextInt((30 - 25) + 1));
					asteroide4.setPosicionYX(16, 25 + rand.nextInt((30 - 25) + 1));

					fruta5.setPosicionYX(24, 25 + rand.nextInt((30 - 25) + 1));
				}
				catch ( AsteroidePosicionNoValidaException e)
				{
					e.printStackTrace();
				}



		        pantalla.insertarBitmap(fruta1.getBitmap(), fruta1.getPosicionY(), fruta1.getPosicionX());
		        pantalla.insertarBitmap(asteroide1.getBitmap(), asteroide1.getPosicionY(), asteroide1.getPosicionX());

		        pantalla.insertarBitmap(fruta2.getBitmap(), fruta2.getPosicionY(), fruta2.getPosicionX());
		        pantalla.insertarBitmap(asteroide2.getBitmap(), asteroide2.getPosicionY(), asteroide2.getPosicionX());

		        pantalla.insertarBitmap(fruta3.getBitmap(), fruta3.getPosicionY(), fruta3.getPosicionX());
		        pantalla.insertarBitmap(asteroide3.getBitmap(), asteroide3.getPosicionY(), asteroide3.getPosicionX());

		        pantalla.insertarBitmap(fruta4.getBitmap(), fruta4.getPosicionY(), fruta4.getPosicionX());
		        pantalla.insertarBitmap(asteroide4.getBitmap(), asteroide4.getPosicionY(), asteroide4.getPosicionX());
		        pantalla.insertarBitmap(fruta5.getBitmap(), fruta5.getPosicionY(), fruta5.getPosicionX());


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

				if ( jugador.detectarColision(fruta1,fruta2,fruta3,fruta4,fruta5) == true )
				{
					jugador.setPuntuacion(jugador.getPuntuacion() + 10 );
				}
				if ( jugador.detectarColision(asteroide1,asteroide2,asteroide3,asteroide4) == true )
				{
					jugador.setVida(jugador.getVida() - 1);
				}
				if ( jugador.getVida() <= 0)
				{
					System.out.println("HAS PERDIDO");
					gameOver = true;
				}
				if ( jugador.getPuntuacion() == 50 )
				{
					gameOver = true;
					System.out.println("HAS GANADO");
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
					jugador.setPosicionX(18);
					jugador.setVida(10);
					jugador.setPuntuacion(0);
					fruta1.setBitMap(new Bitmap(2, 2, Bitmap.BITMAP_FRUTA));
					fruta2.setBitMap(new Bitmap(2, 2, Bitmap.BITMAP_FRUTA));
					fruta3.setBitMap(new Bitmap(2, 2, Bitmap.BITMAP_FRUTA));
					fruta4.setBitMap(new Bitmap(2, 2, Bitmap.BITMAP_FRUTA));
					fruta5.setBitMap(new Bitmap(2, 2, Bitmap.BITMAP_FRUTA));
				}
			}
		} while ( opcionJugador == 's' ) ;	
	}
}

