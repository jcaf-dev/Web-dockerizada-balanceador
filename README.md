# 🐳 Web Dockerizada con Balanceador de Carga

## 📌 Índice
1. [Descripción General](#descripcion-general)
2. [Entidades Principales](#entidades-principales)
3. [Servicio Público](#servicio-publico)
4. [Servicio Privado](#servicio-privado)
5. [Autor](#autor)
6. [Diagramas](#diagramas)
7. [Despliegue de la Aplicación](#despliegue-de-la-aplicacion)
8. [Arquitectura Docker + Balanceador](#arquitectura-docker--balanceador)
9. [Despliegue con Docker Compose](#despliegue-con-docker-compose)

---

## 1. 💻 Descripción General <a name="descripcion-general"></a>

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

## 2. 👥 Entidades Principales <a name="entidades-principales"></a>

- **Item**: Producto con identificador único, descripción, precio y stock.
- **Client**: Usuario con identificador único, datos personales y dirección. Puede realizar de 0 a N pedidos.
- **Order**: Pedido asociado a un cliente e items, con coste total.
- **Author**: Autor con identificador único, asociado de 0 a N items.

---

## 3. 🔓 Servicio Público <a name="servicio-publico"></a>

Funciones accesibles sin autenticación:
- Navegar por las páginas HTML
- Buscar y visualizar cuadros
- Consultar autores y obras

---

## 4. 🔒 Servicio Privado <a name="servicio-privado"></a>

Funciones que requieren autenticación:
- Ver precios
- Añadir productos al carrito
- Realizar pedidos
- Pago online
- Envío automático de email con PDF resumen del pedido

---

## 5. 👤 Autor <a name="autor"></a>

**Carlos Angulo**  
- 📧 juancarlos@jcaf.es
- GitHub: [jcaf-devl](https://github.com/jcaf-dev)

---

## 6. ✏️ Diagramas <a name="diagramas"></a>

### 6.1 Diagrama de Navegación
<img src="https://user-images.githubusercontent.com/63256402/111155399-b4ce3900-8594-11eb-9b67-b85410215d90.jpeg" width="750" alt="diagrama-navegacion">

Diagrama que muestra la navegación entre las distintas pantallas.

### 6.2 Diagrama de Clases UML
<img src="https://user-images.githubusercontent.com/63256402/111155385-ad0e9480-8594-11eb-95e8-1c5bc60e4101.jpeg" width="750" alt="uml">

Diagrama UML con composición y agregación de clases.

### 6.3 Diagrama Entidad/Relación
<img src="https://user-images.githubusercontent.com/63256402/111155357-a2ec9600-8594-11eb-80ba-5b55af13e005.jpeg" width="750" alt="er">

Diagrama E/R con relaciones entre entidades.

---

## 7. 🚀 Despliegue de la Aplicación <a name="despliegue-de-la-aplicacion"></a>

### 1) Crear una máquina virtual
Crear una VM en VirtualBox e instalar **Ubuntu**.

### 2) Instalar Java
```bash

sudo apt update
sudo apt upgrade
sudo apt install openjdk-11-jdk
