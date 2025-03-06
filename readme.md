# FashionMap - Plataforma de Gestión de Marcas de Moda
🚀 **FashionMap** es una plataforma diseñada para gestionar marcas de moda, permitiendo a los usuarios explorar tiendas, productos, reseñas y clasificaciones de marcas dentro de un ecosistema centralizado.

## 📌 Índice
1. [Características](#características)
2. [Arquitectura](#arquitectura)
3. [Tecnologías Utilizadas](#tecnologías-utilizadas)
4. [Requisitos Previos](#requisitos-previos)
5. [Instalación y Configuración](#instalación-y-configuración)
6. [Estructura del Proyecto](#estructura-del-proyecto)
7. [Uso de GraphQL](#uso-de-graphql)
8. [Contribuir](#contribuir)
9. [Licencia](#licencia)

---

## ✨ Características
✅ **Gestión de Marcas:** Permite a los administradores agregar, editar y eliminar marcas de moda.  
✅ **Gestión de Tiendas:** Las marcas pueden asociarse con múltiples tiendas.  
✅ **Clasificación Avanzada:** Cada marca y producto puede tener categorías, estilos, universos y características especiales.  
✅ **Sistema de Reseñas:** Usuarios pueden dejar reseñas en productos, tiendas y marcas.  
✅ **Soporte para Imágenes:** Almacenamiento centralizado de imágenes para productos, tiendas y usuarios.  
✅ **GraphQL API:** Backend basado en **GraphQL** para consultas eficientes.  
✅ **Arquitectura Hexagonal:** Mantiene la separación clara entre capas.

---

## 🏗 Arquitectura
FashionMap sigue el **modelo de arquitectura hexagonal**, separando la lógica de dominio, la aplicación y la infraestructura.
```
src/main/java/com/co/fashion
├── application/               # Lógica de aplicación (casos de uso)
│   ├── dto/                   # Objetos de transferencia de datos
│   ├── exception/             # Excepciones personalizadas 
│   ├── mapper/                # Conversión entre entidades y DTOs
│   ├── port/                  
│   │   ├── input/             # Interfaces para la capa de aplicación
│   │   ├── output/            # Interfaces para repositorios y servicios externos
│
├── domain/                    # Entidades y lógica de negocio
│   ├── model/                 # Modelos de datos principales
│
├── infrastructure/             # Implementación técnica
│   ├── adapter/
│   │   ├── input/graphql/      # Controladores GraphQL
│   │   ├── output/persistence/ # Implementación de persistencia
│   │   ├── output/storage/     # Gestión de almacenamiento de imágenes
│
└── resources/                  # Configuración y esquemas GraphQL
    ├── graphql/                

```

---
### Capas de la Arquitectura
1. **Dominio:** Contiene la lógica de negocio y el modelo de dominio.
2. **Aplicación:** Contiene la lógica de negocio y la capa de acceso a datos.
3. **Infraestructura:** Contiene la infraestructura tecnológica y la capa de acceso a datos.

--- 

## 🛠 Tecnologías Utilizadas en el Proyecto
- **Spring Boot**: Framework de Java para el desarrollo de aplicaciones web.    
- **GraphQL**: Framework para el desarrollo de APIs basadas en consultas.    
- **PostgreSQL**: Base de datos relacional.    
- **MapStruct**: Herramienta de mapeo de objetos.    
- **OpenAPI**: Framework para la documentación de APIs.
- **Docker**: Herramienta para el despliegue de aplicaciones en contenedores.

## ⚙️ Requisitos Previos
Antes de ejecutar el proyecto, asegúrate de tener instalados los siguientes requisitos:

- **Java 21**
- **Maven 3.8+**
- **PostgreSQL 14+**
- **Docker (Opcional, para contenedores de la BD)**
- **IntelliJ IDEA o VS Code**

---

## 🚀 Instalación y Configuración

### 🔹 1. Clonar el Repositorio
```bash
git clone https://github.com/nick130920/fashion-map-back.git
cd fashion-map-back
```