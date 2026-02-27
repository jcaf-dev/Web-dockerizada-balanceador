# Web Dockerizada mas Balanceador
## [1 - Descripcion General](#Descripcion)
## [2 - Entidades Principales](#Entidades)
## [3 - Descripción Servicio Público](#ServicioPublico)
## [4 - Descripción Servicio Privado](#ServicioPrivado)
## [5 - Autor](#Autor)
## [6 - Capturas De Pantalla](#Capturas)
## [7 - Diagramas](#Diagramas)
## [8 - Despliegue de la aplicacion](#Despliegue)
## [9 - Diagrama de la aplicación dockerizada + balanceador](#Diagrama2)
## [10 - Despliegue de la aplicacion, balanceada y dockerizada](#docker)

## 1 - :computer: Descripción general <a name="Descripcion">
Se desarrollará una aplicación web destinada a la venta de cuadros en una galería de arte, los usuarios podrán navegar por las diferentes categorías de la galería sin necesidad de registrarse. Para formalizar el pedido deberán iniciar sesión y completar su compra.

## 2 - :busts_in_silhouette: Entidades principales <a name="Entidades">
- Items: Cada producto llevará asociado un identificador único, y contendrá datos específicos que lo describan junto al número de stock. 
- Client: Cada ususario tendrá su propio identificador que será unico y otros datos como su dirección y datos personales. El usuario podrá realizar de 0 a N Orders.
- Orders: esta entidad tendrá asociada un número de items y un usuario. Tambien contendrá el coste final total.
- Author: esta entidad llevará asosciado un identificador único y contendrá de 0 a N items que se recojan en ella.
## 3 - :unlock: Descripción Servicio Público <a name="ServicioPublico">
- Los usuarios podrán navegar por las distintatas plantillas html y buscar cuadros.
## 4 - :lock: Descripción Servicio Privado <a name="ServicioPrivado">
  - Para ver el precio y realizar un pedido, el usuario deberá acceder con sus credenciales.
  - Cuando un usuario realiza un pedido se le enviará un correo electrónico con un pdf donde se incluirá el resumen de su pedido.
  - Servicio de pago online.
## 5 - :trollface: Autor <a name="Autor">
#### Juan Carlos Flores Angulo
- jc.flores@alumnos.urjc.es
- GII + GIC 135
- ##### Github: [FinalBossRel](https://github.com/jcaf-dev)
## 6 - :book: Capturas De Pantalla <a name="Capturas">
### Home.html
  ![home](https://user-images.githubusercontent.com/63256402/111153803-ada62b80-8592-11eb-9ed2-d8ede9d6e978.png)
  Página principal donde se exponen algunos cuadros y se muestra un pequeño resumen.
### Contact.html
  ![contact](https://user-images.githubusercontent.com/63256402/111153896-cf071780-8592-11eb-8e38-8013229fe057.png)
  Página donde el usuario puede comunicarse con los administradores de la web(en progreso).
### ArtGallery.html  
  ![artgallery](https://user-images.githubusercontent.com/63256402/111154018-f958d500-8592-11eb-8e99-1db1e929be6c.png)
  Página en la que se exponen los autores y sus obras.
### Shoppingcart.html
  ![cart](https://user-images.githubusercontent.com/63256402/111154248-4d63b980-8593-11eb-9d0a-04614a82a5ef.png)
  Pagina que muestra el carrito de compra con los productos añadidos por el cliente.
  ![cartWithThings](https://user-images.githubusercontent.com/63256402/111154313-64a2a700-8593-11eb-95d1-4e6ba69849c4.png)
  Una vez que el cliente se registre podrá añadir productos al carrito.
### Singin.html
![singIn](https://user-images.githubusercontent.com/63256402/111154371-72582c80-8593-11eb-9326-3f5ed419737a.png)
Página que permite acceder al usuario con sus credecianles a su cuenta personal.
 ### Createaccount.html
  ![createAccount](https://user-images.githubusercontent.com/63256402/111154595-adf2f680-8593-11eb-8c4b-61cfb4bd97b8.png)
  Página para nuevos usuarios en la que se piden datos del cliente.
### DatosClient.html
  ![dataClient](https://user-images.githubusercontent.com/63256402/111154696-cd8a1f00-8593-11eb-9ad2-d3de76678644.png)
  Página que enseña los datos del cliente
## 7 - :pencil: Diagramas <a name="Diagramas">
## 7.1 Diagrama De Navegación
  ![Diagrama de navegacion](https://user-images.githubusercontent.com/63256402/111155399-b4ce3900-8594-11eb-9b67-b85410215d90.jpeg)
  Diagrama que muestra la navegación entre las distintas pantallas de la página web.
## 7.2 Diagrama de clases UML
  ![uml](https://user-images.githubusercontent.com/63256402/111155385-ad0e9480-8594-11eb-95e8-1c5bc60e4101.jpeg)
  Diagrama UML en el que se muestra la composición y agregación de las clases.
## 7.3 Diagrama E/R
  ![ER](https://user-images.githubusercontent.com/63256402/111155357-a2ec9600-8594-11eb-80ba-5b55af13e005.jpeg)
  Diagrama en el que se muestra la realación estre las entidades de la pagina web.
  
## 8 - :computer: Despliegue de la aplicacion <a name="Despliegue">
#### 1 - Tenemos que crear una máquina virtual usando Virtual Box, instalaremos el sistema operativo Ububtu en él.
#### 2 - Tendremos que instalar java en este nuevo sistema operativo, para ello podemos usar el siguiente comando.
       sudo apt install openjdk-11-jdk
#### 3 - También tendremos que instalar MySql
       sudo apt-get install mysql-server
       Para seguir debemos realizar una actualización de nuestros paquetes,  por lo que debemos de abrir una terminal y en
       ella vamos a ejecutar los siguientes comandos
       sudo apt update
       sudo apt upgrade
 #### 4 - Hecho esto ahora es necesario que instalemos algunos paquetes necesarios para la instalación de Docker, usando el
 #### comando siguiente:
          sudo apt-get install apt-transport-https ca-certificates curl gnupg software-properties-common 
 #### 5 - Despues vamos a añadir la clave gpg al sistema, para ello debemos descargarla:  
          curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add –
 #### 6 - Añadimos el repositorio al sistema: 
          sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu cosmic nightly "
          sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu bionic stable"    
 #### 7 - Y finalmente podemos instalar la aplicación con:
          sudo apt install docker-ce 
 ####  ¿Cómo utilizar Docker?
        sudo systemctl enable docker
        sudo systemctl start docker
 ####  Para saber si docker esta funcionando, ejecutar el siguiente comando:
        sudo systemctl status docker    
 ####  Tambien podemos ver la versión del Docker que tenemos.
        docker -v
 #### 8 - Ejecutamos el docker mediante el comando:
        docker run --rm -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=relDesigns -p 3306:3306 -d mysql:8.0.22
 #### 9 - Por último ejecutamos los jars descargados usando los comandos:
        java -jar ServicioInternoDesigns.jar
        java -jar relDesigns.jar
  
## 9 - :computer: Diagrama de la aplicación dockerizada + balanceador <a name="Diagrama2">
  
  ![Diagrama en blanco](https://user-images.githubusercontent.com/63256402/124998943-8990bd80-e04d-11eb-8d31-9ca0045e0069.jpg)
  
## 10 - :computer: Despliegue de la aplicacion, balanceada y dockerizada <a name="docker">
  
  1- Se crean los ficheros .jar
  
  2- Se usará docker compose
  
  3- Se crean los ficheros dickerfile para dockerizar cada aplicación
  
  4- Se crea el fichero docker-compose.yml
  
  5- Se crean los balanceadores para la aplicación web y el servicio interno
  
  6- Se indican las caracteristicas en el fichero del balanceador, el frontend y backend
  
![Screenshot 2021-07-09 015655](https://user-images.githubusercontent.com/63256402/125004348-9fa47b00-e059-11eb-99c1-7614634160ca.png)
  
  ![Screenshot 2021-07-09 015721](https://user-images.githubusercontent.com/63256402/125004352-a206d500-e059-11eb-8b75-2f476dc04d98.png)

