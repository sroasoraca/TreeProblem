# TreeProblem
This is an example of Tree Problem that i did in the university

Problema A
Descripción del problema
Los estudiantes de Estructuras de datos son amantes de los árboles. Su profesor
quiere motivarlos y ha decidido pedirles que solucionen un problema bastante
interesante.
El problema consiste en realizar una serie de comandos sobre la creación de un
árbol genealógico muy particular. Cada nodo del árbol está identificado con un
número entero que indica el identificador de una persona. Tenga en cuenta que
cada persona puede tener 0, 1 o 2 hijos. La forma en que se organizan las personas
en el árbol es mediante la siguientes reglas:
● Para cada persona, todos los descendientes que se agreguen y tengan un
identificador mayor deben ir a la derecha. De igual manera, todos los
descendientes que lleguen y tengan un identificador menor deben ir a la
izquierda.
● La estructura del árbol nunca debe ser cambiada. Es decir, al momento de
agregar un nueva persona, ésta debe ser agregada teniendo en cuenta la
primera condición pero sin cambiar la estructura del resto del árbol.
Los comandos que se deben implementar son los siguientes:
● Agregar X: Permite agregar una persona con identificador X en el árbol.
● Distancia X Y: Se debe imprimir la distancia entre la persona X y la persona Y
dentro del árbol. La distancia es el número de aristas del árbol por las que se
tiene que pasar para llegar de X a Y. En caso de que no exista alguno de los
2 nodos se debe imprimir ­1.
● Ancestro U V: Se debe imprimir el menor ancestro común entre la persona U
y la persona V. El menor ancestro se define como la persona que se
encuentra más cerca de U y V tal que U y V son descendientes de esta. En
caso de no existir alguna de las personas (U, V) se debe imprimir ­1.
Para mayor claridad veamos un ejemplo:
­ El menor ancestro en común entre los nodos 36 y 49 es 40.
­ En el caso especial, donde U sea el padre de V, la respuesta de Ancestro U
V será el identificador de U.
­ En este caso la distancia entre 36 y 49 es igual a 5.
Entrada
La primera línea es un número T que representa la cantidad de casos de prueba.
Cada caso de prueba inicia con una línea con un entero Q que representa el
número de comandos que siguen. Las siguientes Q líneas contienen un comando
de los descritos anteriormente.
Restricciones/Consideraciones
● 0 < Q < 10000
● 0 < X,Y ,U,V < 1000000
Salida
Por cada comando Distancia y Ancestro se debe imprimir según la descripción y la
salida mostrada a continuación.
Ejemplo de Entrada Ejemplo de Salida
1
12
agregar10
agregar20
agregar5
agregar3
distancia320
ancestro320
agregar8
ancestro38
distancia83
distancia511
ancestro2010
ancestro55

Caso#1:
distancia:3
ancestro:10
ancestro:5
distancia:2
distancia:­1
ancestro:10
ancestro:5
