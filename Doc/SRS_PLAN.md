# Especificacion de requerimientos de sistema #

### Prefacio ###
El documento se dirige a desarrolladores, clientes y cualquier otra persona interesada en el proyecto. El mismo abarca aspectos del sistema como proposito, contexto, requerimientos de usuario y de sistema, arquitectura del sistema, modelo del mismo, especificacion de los requerimientos, etc. El mismo servira como contrato entre el cliente y los desarrolladores y es base del desarrollo de todo el proyecto.

- Control de Versiones
	- **Version 0.1.0** -  Autor/es: Cavanagh Juan, Casabella Martin, Kleiner Matias - Fecha: 07/05/2017 - Descripción: primera version del documento SRS.
	- **Version 0.1.1** -  Autor/es: Cavanagh Juan, Casabella Martin, Kleiner Matias - Fecha: 07/05/2017 - Descripción: se agregaron diagramas de casos de uso y requerimientos no funcionales.
	- **Version 0.2.0** -  Autor/es: Cavanagh Juan, Casabella Martin, Kleiner Matias - Fecha: 08/05/2017 - Descripción: se agregaron diagramas de casos de prueba, matrices de trazabilidad.
### 1. Introducción  ### 

#### 1.1 Propósito  ####
El propósito de este documento es describir las funciones y los requerimientos del proyecto. El mismo surge de la necesidad del cliente de poder realizar las ventas de viajes en colectivos de (NOMBRE DE LA EMPRESA).

#### 1.2 Alcance ####
Sera una aplicacion en java que ofrece, entre otras cosas, la eleccion de destino, colectivo, cantidad de pasajes, numeros de asientos, horario de viaje, formas de pago, etc. Para el proposito la aplicacion requerira de conexion a internet. 
 
### 2. Glosario  ###
 A continuacion se definen los terminos que son usado a lo largo de todo el documento.
 
 - SRS: Especificacion de requerimientos del sistema.
 - CU: Casos de uso.
 - CP: Casos de prueba.
 - UML: Lenguaje unificado de modelado. 
 - Rx: Requerimiento numero x.
 
### 3. Descripcion general ###

#### 3.1 Clases de usuario y descripcion de los mismos ####
Se espera que la aplicacion la use un solo grupo de usuarios que serian los vendedores de los pasajes de colectivos de la empresa (NOMBRE DE LA EMPRESA). Los mismos deberan tener una minima capacitacion en el ambito de la informatica. 

#### 3.2 Ambiente de Operacion ####
El software correra en compuratodas con sistemas operativos Windows, Linux o Mac que soporte la maquina virtual de JAVA.

#### 3.3 Restricciones de diseño e implementación ####

#### Limitaciones software: ####
- El sistema necesitara la version JAVA 6 o superior.
- Eclipse JAVA sera el IDE usado para la programacion.

#### Limitaciones Hardware: ####
El sistema necesitara de una computadora con sistemas operativos Windows, Linux o Mac que soporte la maquina virtual de JAVA.
Ademas, tendra que tener conexion a internet e impresora para emitir comprobantes de pago y boleto.

### 4. Requerimientos de usuario ###
Se detalla a continuacion de manera informativa las funciones de la aplicacion de forma general.

![Requisitos](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Imagenes/requisitos.png)

Lista de requisitos.

R1. La aplicacion debera poder consultar los servicios disponibles cuando el vendedor de boletos lo solicite. Esto es, listar las distintas opciones de viaje disponibles: Provinciales e interprovinciales.

R2. La aplicacion debera consultar los destinos disponibles cuando el vendedor de boletos lo solicite. 

R3. La aplicacion debera consultar las horas de salida disponibles que se encuentran en el itinerario y mostrarlas en pantalla para eleccion del cliente.

R4. La aplicacion debera consultar los distintos tipos de micros disponibles (coche cama, semi-cama o suit) y mostrarlas en pantalla para eleccion del cliente.

R5. La aplicacion debera consultar los asientos disponibles en el itinerario y mostrarlas en pantalla para eleccion del cliente.

R6. La aplicacion debera mostrar en pantalla las diferentes formas de pago para adquirir el pasaje en base a lo seleccionado.

R7. La aplicacion debera registrar y guardar la informacion del cliente (Nombre y Apellido, sexo, DNI, datos de tarjeta de credito) para su posterior verificacion y efectuar la compra del pasaje.

R8. La aplicacion debera verificar los datos ingresados en el R7.

R9. La aplicacion debera imprimir boleto y comprobante de pago una vez verificado y validado los datos del cliente.


#### Modelo de casos de uso ####
![Casos de uso](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CasosUso.png)

Breve descripcion de los casos de uso

![CU1](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CU1.png)
![CU2](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CU2.png)
![CU3](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CU3.png)
![CU4](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CU4.png)
![CU5](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CU5.png)
![CU6](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CU6.png)
![CU7](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CU7.png)

A continuacion, se muestra un diagrama de secuencia de uso tipico de la aplicacion:

![Diagrama de secuencia](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/Sequence%20Diagram1.jpg)

### 5. Requerimientos no funcionales ###

Performance:
- El sistema debera ser capaz de consultar el itinerario en menos de 3 segundos.
- El sistema debera cambiar de ventanas en un tiempo menor a 1 segundo.
- El tiempo para iniciar o reiniciar el sistema debera ser inferior a 1 minuto.
- La aplicacion no podra superar el peso de 100 megas.

Confiabilidad:
- El sistema debe estar disponible un 95% de las veces que el usuario lo intente usar.
- La tasa de tiempo de fallas del sistema no podra ser mayor a 0,5% de tiempo de operacion total.

Portabilidad:
- El sistema sólo debe ser portable a otros dispositivos que corran el mismo sistema operativo.

Facilidad de uso: 
- El sistema no debe requerir entrenamiento especial para ser operado por un usuario promedio.
- El sistema debe requerir entrenamiento de no más de una sesión de 10 minutos para ser operado por un usuario con bajo nivel de manejo de aplicaciones.
- El sistema debe poseer una sola ventana de ayuda, más un link a un manual de usuario on-line.
- El sistema debe poseer interfaz grafica bien formada e intuitiva.

### 6. Casos de prueba del sistema ###

CP 1: 
- El cliente solicita un pasaje para un destino X, el operario de la aplicacion BITicket ingresa por teclado el destino deseado por el cliente.
- Resultado esperado: El sistema muestra en pantalla si el destino seleccionado se encuentra disponible en la base de datos.

CP2:
- El cliente solicita un pasaje para una fecha y hora X, el operario de la aplicacion BITicket ingresa la eleccion al sistema.
- Resultado esperado: El sistema muestra en pantalla las fechas de viaje y horarios disponibles para eleccion del cliente.

CP3:
- El operario consulta que tipo de micros hay disponibles para un destino X con fecha y hora de viaje X.
- Resultado esperado: El sistema muestra en pantalla los distintos tipos micros disponibles para eleccion del cliente.

CP4:
- Solicitar al servidor los distintos asientos disponibles del micro.
- Resultado esperado: El sistema muestra en pantalla los distintos asientos disponibles para eleccion del cliente.

CP5:
- El operario presiona el boton "formas de pago".
- Resultado esperado: El sistema muestra en pantalla las diferentes formas de pago disponibles para eleccion del cliente.

CP6:
- Se ingresan los datos del comprador y se presiona en siguiente.
- Resultado esperado: El sistema registra exitosamente los datos del cliente.

CP7:
- Se verifican los datos del cliente ingresados por el personal operario.
- Resultado esperado: Validacion de datos del cliente.

CP8:
- Se cargan los datos de cliente, una vez validados y verificados se hace click en imprimir boleto de viaje.
- Resultado esperado: La aplicacion imprime el boleto de viaje de manera exitosa.

CP10:
- Se cargan los datos de cliente, una vez validados y verificados se hace click en imprimir comprobante de pago.
- Resultado esperado: La aplicacion imprime el comprobante de pago de manera exitosa.

### 7. Pruebas de aceptacion por el cliente ###
Todos los casos de pruebas tendran que pasar exitosamente para la aceptacion del cliente.

### 8. Matriz de trazabilidad ###

#### 8.1 Matriz de trazabilidad en funcion de los casos de uso ####

![Matriz de trazabilidad en función de los CU](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Imagenes/MATRIZcasoUSO.png)

#### 8.2 Matriz de trazabilidad en funcion de los casos de prueba ####

![Matriz de trazabilidad en función de los CP](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Imagenes/matrizCASOprueba.png)

### 9. Evolucion del sistema ###
- Este software puede contar con actualizaciones referidas a la optimizacion del funcionamiento de la aplicacion BITicket y la implementacion de nuevas funcionalidades en la Interfaz del usuario.
- Ademas se podrán realizar cambios en el software segun lo establecido en el [Plan de Configuraciones](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/CM_PLAN.md) en la seccion 3: Administracion de cambios.

### 10. Apendices ###

#### Bibliografia ####
- Ingeniería del software. Novena edición. IAN SOMMERVILLE.
- Pagina web de la catedra [Sitio web de la catedra](https://sites.google.com/view/ingenieria-software-unc)
