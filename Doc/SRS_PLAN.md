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


![Clases de dominio](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/Clases.png)
##### Nota #####
Un modelo de Dominio se representa con un conjunto de diagramas de clases en los que no se define ninguna operación. Por lo tanto, se considera al Modelo de Dominio como un Diccionario visual de las abstracciones relevantes, vocabulario de dominio e información del dominio. 

#### Modelo de casos de uso ####
![Casos de uso](https://github.com/kleinermatias/BITSoftware/blob/master/Doc/Diagramas/CasosUso.png)
Breve descripcion de los casos de uso
- #### Eleccion de origen y destino: ####
Esta accion se realiza cuando el cliente solicita un pasaje al proveedor de viajes. El vendedor de boletos asociado a la empresa debera registrar mediante la aplicacion BITicket el origen y el destino de viaje provisto por el cliente.
- #### Fecha de viaje: ####
Mediante la aplicacion BITicket se registra la fecha de viaje requerida por el cliente.
- #### Cantidad de pasajes a adquirir: #### 
Se registra la cantidad de pasajes a adquirir por parte del cliente.
- #### Horario y tipo de micro: #### 
Mediante el itinerario, la aplicacion BITicket debera mostrar en pantalla los horarios y los diferentes tipos de colectivos disponibles (coche cama, semi-cama, suit, etc).
- #### Seleccion de lugar disponible: #### 
Se debera mostrar en pantalla los lugares que se encuentran disponibles para la eleccion.
- #### Registro de datos del cliente: #### 
Se registra en la aplicacion BITicket los datos del cliente. (Nombre y Apellido, DNI, edad, sexo)
- #### Forma de pago: #### 
Se muestran en pantalla las diferentes formas de pago disponibles para el cliente.
- #### Verificacion de pago e impresion de comprobante de pago y boleto: ####
Por ultimo se verifican los datos del cliente junto con los datos de pago y de ser validas, se imprimen los comprobantes de pago y el pasaje del viaje del cliente.	

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
