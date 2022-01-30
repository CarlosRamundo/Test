# TestTelecom
Pregunta 1Implementar el siguiente ejercicio practico de forma nativa en Android o iOS, 
utilizando las mejores practicas y librerias/framework que conozca. No hay que sobredimensionar ni reducir el tamaño del proyecto. 
Indicar los pasos necesarios para levantar dicha app y poder probarla.
Debemos desarrollar una aplicacion donde mostramos un catalogo de celulares disponibles para ser comprados. 
Para ellos debemos llamar al servicio A el cual nos retornara toda la lista dispositivos disponibles, de toda esta informacion debemos mostrar mainImage, name, installmentsTag, topTag.Al selecciona alguno de los dispositivos el mismo debera llamar al Servicio B y actualizar la pantalla para que muestre informacion adicional, sin dejar de verse el listado de dispositivos. Dentro de la informacion adicional debemos ver un carrousel con las imagenes y los legales del mismo.
Servicio A  https://61967289af46280017e7e0c0.mockapi.io/devicesServicio 
         B  https://61967289af46280017e7e0c0.mockapi.io/devices/:idDonde 
         el id, solo por ser un mock deberia ser la posicion de elemento en la lista (no el id del producto). 
Siempre va a devolver el mismo valor, pero se debe hacer un nuevo llamado.
En el campo respuesta poner el repositorio donde se encuentra publico el codigo, de modo solo lectura
