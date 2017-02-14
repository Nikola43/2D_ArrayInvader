//Inclumimos librerias basicas
#include <jni.h>
#include "LeerTeclasUsandoCPP.h"
#include <iostream>
#include <conio.h>
using namespace std;


#define ESC 27
#define ENTER 13
#define FLECHA_ARRIBA 72
#define FLECHA_ABAJO 80
#define FLECHA_IZQUIERDA 75
#define FLECHA_DERECHA 77



JNIEXPORT jint JNICALL Java_LeerTeclasUsandoCPP_leerTecla(JNIEnv * env, jobject jobj)
{
    //Guardaremos la tecla pulsada en un int
    int teclaPulsada;


   		teclaPulsada = _getch();
    return ((int)teclaPulsada);
}

JNIEXPORT jboolean JNICALL Java_LeerTeclasUsandoCPP_hayTeclaPulsada(JNIEnv * env, jobject jobj)
{
	jboolean teclaPulsada = false;
    if ( _kbhit() )
    {
    	teclaPulsada = true;
    }
    return (teclaPulsada);
}
