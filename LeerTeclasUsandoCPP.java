
public class LeerTeclasUsandoCPP
{
	//Teclas que usaremos
	public static final int STOP = 0;
    public static final int ARRIBA = 119;
    public static final int ABAJO = 115;
    public static final int IZQUIERDA = 97;
    public static final int DERECHA = 100;

	//metodos nativos en c++
    public native int     leerTecla();
    public native boolean hayTeclaPulsada();

    //Cargamos la libreria compilada 'leerTeclasCPP' que contiene los metodos escritos en c++
    static 
    {
        System.loadLibrary("leerTeclasCPP");
    }
}
