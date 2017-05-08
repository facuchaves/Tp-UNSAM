# EjercicioAlMundo

#Diagramas

#Diagrama de clases.

![alt text](https://github.com/facuchaves/EjercicioAlMundo/blob/master/Images/DiagramaDeClases.png)

#Diagrama de secuencia.

![alt text](https://github.com/facuchaves/EjercicioAlMundo/blob/master/Images/DiagramaDeSecuencia.png)

#Diagrama de estado.

![alt text](https://github.com/facuchaves/EjercicioAlMundo/blob/master/Images/DiagramaDeEstados.png)

La solución planteada consiste en un CallCenter con una lista de empleados. Cuando llega una llamada, se busca en esa lista un empleado que esté libre para atender la llamada, respetando el orden de primero buscar operadores, luego supervisores y finalmente directores. Si no hubiese empleados para atender la llamada, se lanza una excepción. Desde el dispatcher, se captura esta excepción y se encola esta llamada, para que la aplicación no falle y sea más robusta. Una vez que se halla desocupado algún empleado, la llamada se recibira.

Si llegan más de 10 llamadas concurrentemente, se empiezan a encolar las llamadas para atenderlas en el futuro.

# Consideraciones:

Mi idea original fue usar Futures para atender las llamadas apenas un empleado se desocupe, pero tuve inconvenientes con esto entonces la solución fue que cuando llegue una llamada, primero corroborar si hay una llamada en espera y darle prioridad a esta llamada. Esta no es la mejor solución porque las llamadas pendientes se van a quedar a la espera de que llegue una nueva llamada para poder ser atendidas, pero fue la solución parcial que pude codificar para no demorar más la entrega de este ejercicio.
