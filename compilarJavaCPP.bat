@echo off

javac LeerTeclasUsandoCPP.java
echo Compilacion fichero ".java" completada correctamente
echo.

javah LeerTeclasUsandoCPP
echo Generacion del fichero ".h" completada correctamente
echo.

g++ leerTeclasCPP.cpp -o leerTeclasCPP.dll -LD -Fe -m64 -shared -I "C:\Program Files\Java\jdk1.7.0_07\include" -I "C:\Program Files\Java\jdk1.7.0_07\include\win32"
echo Compilacion de la libreria ".dll" completada correctamente
echo.

java LeerTeclasUsandoCPP
