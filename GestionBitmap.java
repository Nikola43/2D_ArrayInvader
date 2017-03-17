
public class GestionBitmap
{
	public static void refrescarPantalla(int tasaRefresco)
	{
	    pausarEjecucion(tasaRefresco);
	    limpiarConsola();
	}

	public static void pausarEjecucion(int tiempo)
	{
	    try 
	    {
	        Thread.sleep(tiempo);               
	    } 
	    catch(InterruptedException e) 
	    {
	       Thread.currentThread().interrupt();
	    }
	}

	public static final void limpiarConsola()
	{
	    try
	    {
	        final String sistemaOperativoActual = System.getProperty("os.name");

	        if (sistemaOperativoActual.contains("Windows"))
	        {
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        System.out.println("Error: No se pudo limpiar la consola. "+e);
	    }
	}

	public static  void pintarPantallaGameOver()
	{
		System.out.println(" #####                          #######                      ");
		System.out.println("#     #   ##   #    # ######    #     # #    # ###### #####  ");
		System.out.println("#        #  #  ##  ## #         #     # #    # #      #    # ");
		System.out.println("#  #### #    # # ## # #####     #     # #    # #####  #    # ");
		System.out.println("#     # ###### #    # #         #     # #    # #      #####  ");
		System.out.println("#     # #    # #    # #         #     #  #  #  #      #   #  ");
		System.out.println(" #####  #    # #    # ######    #######   ##   ###### #    # ");
	}
}