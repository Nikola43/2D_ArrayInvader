@echo off

javac LeerTeclasUsandoCPP.java
echo Compilacion fichero ".java" completada correctamente
echo.

javah LeerTeclasUsandoCPP
echo Generacion del fichero ".h" completada correctamente
echo.

C:\mingw-w64\x86_64-5.4.0-win32-seh-rt_v5-rev0\g++ leerTeclasCPP.cpp -o leerTeclasCPP.dll -LD -Fe -m64 -shared -I "C:\Program Files\Java\jdk1.8.0_121\include" -I "C:\Program Files\Java\jdk1.8.0_121\include\win32"
echo Compilacion de la libreria ".dll" completada correctamente
echo.

