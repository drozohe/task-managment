

### CRUD con Spring Boot y Cloud Firestore
Creación de un servicio web **RESTful** con un CRUD básico completo, con un modelo de autenticación **OAUTH2**, bajo el framework de **Spring Boot.**

## Modelo de datos

![image info](./images/imageFirebase1.png)

# Creación del proyecto en Cloud Firestore
Agregar un nuevo proyecto en la plataforma de Firebase, indicando nombre del proyecto, aceptando las opciones por defecto y seleccioando la cuenta por defecto de **Google Analytics**
Al terminar estos pasos estará listo el proyecto en Cloud Firestore

![image info](./images/imageFirebase2.png)

Luego procedo a crear la clave privada de la aplicacion, guardandola un un archivo .json dentro del proyecto, en el direcotorio de recursos del mismo.

![image info](./images/imageFirebase3.png)

![image info](./images/imageFirebase4.png)

Por último, de acuerdo con la documentación de Firebase, incluyo las sentencias correspondientes para cargar la clave privada de la aplicación, incluyendo ademas
la ruta de la base de datos (ver imagen)

![image info](./images/imageFirebase5.png)


