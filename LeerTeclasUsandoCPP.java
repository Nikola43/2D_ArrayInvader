public class LeerTeclasUsandoCPP
{
	//Teclas que usaremos
	final static int STOP = 0;
	final static int ARRIBA = 119;
	final static int ABAJO = 115;
	final static int IZQUIERDA = 97;
	final static int DERECHA = 100;

	//metodos nativos en c
    native int leerTecla();
    native boolean hayTeclaPulsada();

    //Cargamos la libreria compilada 'leerTeclasCPP' que contiene los metodos escritos en c
    static 
    {
        System.loadLibrary("leerTeclasCPP");
    }
}
