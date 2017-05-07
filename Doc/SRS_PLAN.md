# Especificacion de requerimientos de sistema #

### Prefacio ###
El documento se dirige a desarrolladores, clientes y cualquier otra persona interesada en el proyecto. El mismo abarca aspectos del sistema como proposito, contexto, requerimientos de usuario y de sistema, arquitectura del sistema, modelo del mismo, especificacion de los requerimientos, etc. El mismo servira como contrato entre el cliente y los desarrolladores y es base del desarrollo de todo el proyecto.

- Control de Versiones
	- **Version 0.1** -  Autor/es: Cavanagh Juan, Casabella Martin, Kleiner Matias - Fecha: 07/05/2017 - Descripcion: primera version del documento SRS.

### 1. Introducción  ### 

#### 1.1 Propósito  ####
El propósito de este documento es describir las funciones y los requerimientos del proyecto. El mismo surge de la necesidad del cliente de poder realizar las ventas de viajes en colectivos de su empresa.

#### 1.2 Alcance ####
Sera una aplicacion en java que ofrece, entre otras cosas, la eleccion de destino, colectivo, cantidad de pasajes, numeros de asientos, horario de viaje, formas de pago, etc. Para el proposito la aplicacion requerira de conexion a internet. 
 
### 2. Glosario  ###
 A continuacion se definen los terminos que son usado a lo largo de todo el documento.
 
 SRS: Especificacion de requerimientos del sistema.

### 3. Requerimientos de usuario ###
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


![Clases de dominio](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/Clases.png)
##### Nota #####
Un modelo de Dominio se representa con un conjunto de diagramas de clases en los que no se define ninguna operación. Por lo tanto, se considera al Modelo de Dominio como un Diccionario visual de las abstracciones relevantes, vocabulario de dominio e información del dominio. 

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

A continuacion, se muestra un diagrama de secuencia de uso de la aplicacion
![Diagrama de secuencia](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/Sequence%20Diagram1.jpg)

#### 3.1 Servicios provistos al cliente ####
La aplicacion deberá ser capaz de ofrecer al interesado en adquirir un boleto de viaje en colectivo de la empresa XXXXX la posibilidad de eleccion de la fecha de su viaje, el origen y destino del mismo, el horario conveniente, el/los numero/s de asiento/s, la forma de pago y la verificacion del mismo.

#### 3.2 Estandares a seguir ####
COMPLETAR ESTANDARES A SEGUIR

### 4. Arquitectura del sistema ###
El proyecto será guardado bajo el directorio <BITSoftware> (repositorio de github).
 
### 5. Modelos del sistema ###

### 6. Evolucion del sistema ###

### 7. Apendices ###
En que nos basamos para hacer el documento, etc.

### 8. Indice ###
