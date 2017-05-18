# Especificacion de requerimientos de sistema #

### Prefacio ###
El documento se dirige a desarrolladores, clientes y cualquier otra persona interesada en el proyecto. El mismo abarca aspectos del sistema como proposito, contexto, requerimientos de usuario y de sistema, arquitectura del sistema, modelo del mismo, especificacion de los requerimientos, etc. El mismo servira como contrato entre el cliente y los desarrolladores y es base del desarrollo de todo el proyecto.

- Control de Versiones
	- **Version 0.1.0** -  Autor/es: Cavanagh Juan, Casabella Martin, Kleiner Matias - Fecha: 07/05/2017 - Descripción: primera version del documento SRS.
	- **Version 0.1.1** -  Autor/es: Cavanagh Juan, Casabella Martin, Kleiner Matias - Fecha: 07/05/2017 - Descripción: se agregaron diagramas de casos de uso y requerimientos no funcionales.
	- **Version 0.2.0** -  Autor/es: Cavanagh Juan, Casabella Martin, Kleiner Matias - Fecha: 08/05/2017 - Descripción: se agregaron diagramas de casos de prueba, matrices de trazabilidad.
	- **Version 0.2.1** -  Autor/es: Kleiner Matias - Fecha: 17/05/2017 - Descripción: correccion de errores ortograficos.
### 1. Introducción  ### 

#### 1.1 Propósito  ####
El propósito de este documento es describir las funciones y los requerimientos del proyecto. El mismo surge de la necesidad del cliente de poder ofrecer a sus usuarios, la posibilidad de reservar una entrada para el cine.

#### 1.2 Alcance ####
Sera una aplicacion en java que ofrece, entre otras cosas, la eleccion de pelicula a ver, cantidad de boletos, numeros de asientos, horarios, etc. Para el proposito la aplicacion requerira de conexion a internet. 
 
### 2. Glosario  ###
 A continuacion se definen los terminos que son usado a lo largo de todo el documento.
 
 - SRS: Especificacion de requerimientos del sistema.
 - CU: Casos de uso.
 - CP: Casos de prueba.
 - UML: Lenguaje unificado de modelado. 
 - Rx: Requerimiento numero x.
 
### 3. Descripcion general ###

#### 3.1 Clases de usuario y descripcion de los mismos ####
Se espera que la aplicacion la usen dos tipos de usuario. El/los usuarios administradores, que seran los encargados de gestionar las peliculas en cartelera, los horarios de las mismas asi como las salas donde se brindara la funcion. Ademas, se espera que tambien la usen los usuarios consumidores para poder adquirir su reserva. Para el caso del primer tipo de usuario, se espera que este tenga una minima capacitacion en el ambito de la informatica. 

#### 3.2 Ambiente de Operacion ####
El software correra en compuratodas con sistemas operativos Windows, Linux o Mac que soporte la maquina virtual de JAVA.

#### 3.3 Restricciones de diseño e implementación ####

#### Limitaciones software: ####
- El sistema necesitara la version JAVA 6 o superior.
- Eclipse JAVA sera el IDE usado para la programacion.

#### Limitaciones Hardware: ####
El sistema necesitara de una computadora con sistemas operativos Windows, Linux o Mac que soporte la maquina virtual de JAVA.
Ademas, tendra que tener conexion a internet e impresora para emitir comprobante de reserva (en el caso de seleccionar la opcion de imprimir comprobante de reserva).

### 4. Requerimientos de usuario ###
Se detalla a continuacion de manera informativa las funciones de la aplicacion de forma general.

![Requisitos](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Imagenes/requisitos.PNG)

Lista de requisitos.

R1. La aplicacion debera poder mostrar las peliculas disponibles en cartelera al momento de la consulta, ademas del precio de la funcion.

R2. La aplicacion debera mostrar los horarios disponibles para la pelicula seleccionada. 

R3. La aplicacion debera mostrar en pantalla el tipo (3D O 2D) y numero de sala donde se realizara la funcion.

R4. La aplicacion debera consultar al cliente la cantidad de reservas que desea adquirir.

R5. La aplicacion debera consultar y mostrar los asientos disponibles para eleccion del cliente.

R6. La aplicacion debera registrar datos e informacion del cliente (correo electronico, nombre y apellido del titular de la reserva, DNI, fecha de nacimiento).

R7. La aplicacion debera generar el comprobante de la reserva una vez que el usuario confirme su eleccion.

Ademas, debera contar con los siguientes requisitos para los usuarios administradores:

R8. La aplicacion debera ser capaz de gestionar las peliculas disponibles (agregar, modificar o quitar peliculas).

R9. La aplicacion debera ser capaz de gestionar las salas disponibles (agregar o quitar salas).

R10. La aplicacion debera ser capaz de gestionar los horarios (modificar y/o setear horarios de la funcion).

R11. La aplicacion debera ser capaz de gestionar el precio de la funcion (modificar y/o setear precios para la funcion).

#### Modelo de casos de uso ####
![Casos de uso](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CasosUso.PNG)

Breve descripcion de los casos de uso

![CU1](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CU1.PNG)
![CU2](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CU2.PNG)
![CU3](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CU3.PNG)
![CU4](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CU4.PNG)
![CU5](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CU5.PNG)
![CU6](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CU6.PNG)
![CU7](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CU7.PNG)
![CU8](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CU8.PNG)
![CU9](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CU9.PNG)
![CU10](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CU10.PNG)
![CU11](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CU11.PNG)

A continuacion, se muestra un diagrama de secuencia de uso tipico de la aplicacion para el usuario Cliente:

![Diagrama de secuencia cliente](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/SecuenciaCliente.jpg)

Diagrama de secuencia de uso tipico de la aplicacion para el usuario Administrador:

![Diagrama de secuencia administrador](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/SecuenciaAdministrador.jpg)

### 5. Requerimientos no funcionales ###

Performance:
- El sistema debera ser capaz de realizar cualquiera de las operaciones de consulta en menos de 4 segundos.
- El sistema debera cambiar de ventanas en un tiempo menor a 2 segundos.
- El tiempo para iniciar o reiniciar el sistema debera ser inferior a 1 minuto.
- La aplicacion no podra superar el peso de 50 megas.

Confiabilidad:
- El sistema debe estar disponible un 95% de las veces que el usuario lo intente usar.
- La tasa de tiempo de fallas del sistema no podra ser mayor a 0,5% de tiempo de operacion total.

Portabilidad:
- El sistema sólo debe ser portable a otros dispositivos que corran el mismo sistema operativo.

Facilidad de uso: 
- El sistema no debe requerir entrenamiento especial para ser operado por un usuario promedio.
- El sistema debe requerir entrenamiento de no más de una sesión de 10 minutos para ser operado por un administrador, que sera un usuario con bajo nivel de manejo de aplicaciones.
- El sistema debe poseer una sola ventana de ayuda, más un link a un manual de usuario on-line.
- El sistema debe poseer interfaz grafica bien formada e intuitiva.

### 6. Casos de prueba del sistema ###

CP 1: 
- El cliente inicia la aplicacion.
- Resultado esperado: El sistema muestra la pantalla inicial de la aplicacion.

CP2:
- El cliente selecciona una pelicula.
- Resultado esperado: El sistema muestra en pantalla horarios disponibles.

CP3:
- El cliente selecciona un horario .
- Resultado esperado: El sistema muestra en pantalla la sala en donde se proyecta la pelicula.

CP4:
- El cliente solicita la cantidad de asientos deseados.
- Resultado esperado: el sistema muestra en pantalla los asientos.

CP5:
- El cliente seleciona asientos deseados en base a los disponibles.
- Resultado esperado: el sistema solicita datos del cliente.

CP6:
- Se ingresan los datos del comprador y se presiona en siguiente.
- Resultado esperado: el sistema emite comprobante con datos impresos.

CP7:
- El administrador gestiona para agregar una pelicula.
- Resultado esperado: La aplicacion solocita agregar/modificar/quitar pelicula de la base de datos.

CP8:
- El administrador indica en que sala sera la funcion.
- Resultado esperado: la aplicacion muestra horarios disponibles de la sala.

CP9:
- El administrador selecciona horario entre los disponibles.
- Resultado esperado: la aplicacion consulta en pantalla precio de funcion.

CP10:
- El administrador ingresa el precio de funcion y confirma operacion.
- Resultado esperado: se agrega/modifica o en su defecto elimina la pelicula.


### 7. Pruebas de aceptacion por el cliente ###
Todos los casos de pruebas tendran que pasar exitosamente para la aceptacion del cliente.

### 8. Matriz de trazabilidad ###

#### 8.1 Matriz de trazabilidad en funcion de los casos de uso ####

![Matriz de trazabilidad en función de los CU](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Imagenes/MATRIZcasoUSO.PNG)

#### 8.2 Matriz de trazabilidad en funcion de los casos de prueba ####

![Matriz de trazabilidad en función de los CP](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Imagenes/MATRIZcasoPRUEBA.PNG)

### 9. Evolucion del sistema ###
- Este software puede contar con actualizaciones referidas a la optimizacion del funcionamiento de la aplicacion BITicket y la implementacion de nuevas funcionalidades en la Interfaz del usuario.
- Ademas se podrán realizar cambios en el software segun lo establecido en el [Plan de Configuraciones](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/CM_PLAN.md) en la seccion 3: Administracion de cambios.

### 10. Apendices ###

#### Bibliografia ####
- Ingeniería del software. Novena edición. IAN SOMMERVILLE.
- Pagina web de la catedra [Sitio web de la catedra](https://sites.google.com/view/ingenieria-software-unc)

[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[TP2]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]


### Diseño de la aplicacion ###

#### 1. Bocetos ####

Se confeccionaron los siguientes bocetos de la aplicacion, siguiendo los requerimientos propuestos por el cliente. 
- Nota: La aplicacion final no necesariamente tendra este diseño, tanto los requerimientos como el diseño de la misma podran sufrir modificaciones a lo largo del proyecto.

![Boceto1](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Imagenes/BocetoPrincipal.PNG)
![Boceto1](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Imagenes/BocetoSegunda.PNG)
![Boceto1](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Imagenes/BocetoTercera.PNG)
![Boceto1](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Imagenes/BocetoCuarta.PNG)
![Boceto1](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Imagenes/BocetoQuinta.PNG)
