# 🐳 Web Dockerizada con Balanceador de Carga

## 📌 Índice
1. [Descripción General](#descripcion-general)
2. [Entidades Principales](#entidades-principales)
3. [Servicio Público](#servicio-publico)
4. [Servicio Privado](#servicio-privado)
5. [Autor](#autor)
6. [Capturas de Pantalla](#capturas-de-pantalla)
7. [Diagramas](#diagramas)
8. [Despliegue de la Aplicación](#despliegue-de-la-aplicacion)
9. [Arquitectura Docker + Balanceador](#arquitectura-docker--balanceador)
10. [Despliegue con Docker Compose](#despliegue-con-docker-compose)

---

## 💻 Descripción General <a name="descripcion-general"></a>

Aplicación web destinada a la venta de cuadros en una galería de arte online.

Los usuarios pueden navegar por las distintas categorías sin necesidad de registrarse.  
Para formalizar un pedido deberán iniciar sesión y completar la compra.

Incluye:
- Carrito de compra
- Autenticación de usuarios
- Generación de PDF con el resumen del pedido
- Envío de correo electrónico con el PDF
- Servicios dockerizados y balanceados

---

## 👥 Entidades Principales <a name="entidades-principales"></a>

- **Item**: Producto con identificador único, descripción, precio y stock.
- **Client**: Usuario con identificador único, datos personales y dirección. Puede realizar de 0 a N pedidos.
- **Order**: Pedido asociado a un cliente e items, con coste total.
- **Author**: Autor con identificador único, asociado de 0 a N items.

---

## 🔓 Servicio Público <a name="servicio-publico"></a>

Funciones accesibles sin autenticación:
- Navegar por las páginas HTML
- Buscar y visualizar cuadros
- Consultar autores y obras

---

## 🔒 Servicio Privado <a name="servicio-privado"></a>

Funciones que requieren autenticación:
- Ver precios
- Añadir productos al carrito
- Realizar pedidos
- Pago online
- Envío automático de email con PDF resumen del pedido

---

## 👤 Autor <a name="autor"></a>

**Carlos Angulo**  
- 📧 juancarlos@jcaf.es
- GitHub: [jcaf-devl](https://github.com/jcaf-dev)

---

## 🖼️ Capturas de Pantalla <a name="capturas-de-pantalla"></a>

> Nota: Para evitar imágenes gigantes en GitHub, se usan etiquetas HTML con `width`.

### Home.html
<img src="https://user-images.githubusercontent.com/63256402/111153803-ada62b80-8592-11eb-9ed2-d8ede9d6e978.png" width="650" alt="home">

Página principal donde se exponen algunos cuadros y se muestra un pequeño resumen.

### Contact.html
<img src="https://user-images.githubusercontent.com/63256402/111153896-cf071780-8592-11eb-8e38-8013229fe057.png" width="650" alt="contact">

Página donde el usuario puede comunicarse con los administradores de la web (en progreso).

### ArtGallery.html
<img src="https://user-images.githubusercontent.com/63256402/111154018-f958d500-8592-11eb-8e99-1db1e929be6c.png" width="650" alt="artgallery">

Página en la que se exponen los autores y sus obras.

### ShoppingCart.html
<img src="https://user-images.githubusercontent.com/63256402/111154248-4d63b980-8593-11eb-9d0a-04614a82a5ef.png" width="650" alt="cart">

Página que muestra el carrito de compra vacío.

<img src="https://user-images.githubusercontent.com/63256402/111154313-64a2a700-8593-11eb-95d1-4e6ba69849c4.png" width="650" alt="cartWithThings">

Una vez que el cliente se registre podrá añadir productos al carrito.

### SignIn.html
<img src="https://user-images.githubusercontent.com/63256402/111154371-72582c80-8593-11eb-9326-3f5ed419737a.png" width="650" alt="signIn">

Página que permite acceder al usuario con sus credenciales.

### CreateAccount.html
<img src="https://user-images.githubusercontent.com/63256402/111154595-adf2f680-8593-11eb-8c4b-61cfb4bd97b8.png" width="650" alt="createAccount">

Página para nuevos usuarios en la que se piden datos del cliente.

### DatosClient.html
<img src="https://user-images.githubusercontent.com/63256402/111154696-cd8a1f00-8593-11eb-9ad2-d3de76678644.png" width="650" alt="dataClient">

Página que enseña los datos del cliente.

---

## ✏️ Diagramas <a name="diagramas"></a>

### 7.1 Diagrama de Navegación
<img src="https://user-images.githubusercontent.com/63256402/111155399-b4ce3900-8594-11eb-9b67-b85410215d90.jpeg" width="750" alt="diagrama-navegacion">

Diagrama que muestra la navegación entre las distintas pantallas.

### 7.2 Diagrama de Clases UML
<img src="https://user-images.githubusercontent.com/63256402/111155385-ad0e9480-8594-11eb-95e8-1c5bc60e4101.jpeg" width="750" alt="uml">

Diagrama UML con composición y agregación de clases.

### 7.3 Diagrama Entidad/Relación
<img src="https://user-images.githubusercontent.com/63256402/111155357-a2ec9600-8594-11eb-80ba-5b55af13e005.jpeg" width="750" alt="er">

Diagrama E/R con relaciones entre entidades.

---

## 🚀 Despliegue de la Aplicación <a name="despliegue-de-la-aplicacion"></a>

### 1) Crear una máquina virtual
Crear una VM en VirtualBox e instalar **Ubuntu**.

### 2) Instalar Java
```bash

sudo apt update
sudo apt upgrade
sudo apt install openjdk-11-jdk
