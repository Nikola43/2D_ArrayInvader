#!/bin/bash

javac LeerTeclasUsandoCPP.java
echo "Compilacion fichero .java completada correctamente"
echo ""

javah LeerTeclasUsandoCPP
echo "Generacion del fichero .h completada correctamente"
echo ""

g++ leerTeclasCPP.cpp -o leerTeclasCPP.so -LD -Fe -m64 -shared -I "/usr/lib/jvm/java-8-openjdk-amd64/include/" -I "/usr/lib/jvm/java-8-openjdk-amd64/include/linux/"
echo "Compilacion de la libreria .dll completada correctamente"
echo ""

echo "Ejecutando programa..."
echo ""
java LeerTeclasUsandoCPP
