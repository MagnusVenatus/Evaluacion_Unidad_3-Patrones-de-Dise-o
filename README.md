# 🛍️ Sistema de Catálogo de Productos - Patrones de Diseño en Java

## 📋 Resumen del Proyecto

El sistema es un catálogo de productos para una tienda virtual, desarrollado en Java y operado completamente por consola. Permite al usuario agregar, listar, clonar, adaptar productos externos, actualizar y eliminar productos, gestionando toda la información de manera sencilla e interactiva.

Se busca facilitar la administración de productos en una tienda virtual, permitiendo un manejo eficiente y flexible del catálogo, incluyendo la integración de productos de fuentes externas y la creación de variantes de productos existentes.

---

## 🧠 Patrones Implementados

### 🔒 Patrón Creacional Singleton (`ControlCatalogo`)
Se usa para asegurar que solo exista una instancia del catálogo de productos durante toda la ejecución del programa, centralizando la gestión y evitando inconsistencias.

### 🔁 Patrón de Comportamiento Iterator (`Iterador`)
Permite recorrer la lista de productos de manera ordenada y sin exponer la estructura interna de la colección, facilitando la visualización y manipulación de los productos desde el menú.

### 🧬 Patrón Extra a elección Prototype (`Producto`)
Se implementa para poder clonar productos fácilmente, lo que permite crear variantes a partir de productos ya existentes sin tener que ingresar toda la información de nuevo.

### 🔌 Patrón Estructural Adapter (`Adapter`)
Se utiliza para adaptar productos provenientes de una clase externa (`ClaseExterna`) y convertirlos en objetos compatibles con el sistema (`Producto`), permitiendo así integrar productos de otras fuentes de manera sencilla.

---

## 🛠️ Instrucciones para Compilar

### 1. Abre la terminal

Acceder a Consola de Sistema: Presionar `Win + R`, escribir `cmd` y presionar Enter.

### 2. Navega a la carpeta del proyecto

```bash
cd "C:\Users\**USUARIO**\Desktop\ProyectoPatrones"
```

### 3. Compilar todos los archivos `.java`

```bash
javac models\*.java App.java
```

Esto compilará todas las clases dentro de la carpeta `models` y la clase principal `App.java`.

### 4. Ejecutar la clase principal

```bash
java App
```

### 5. Para eliminar todos los archivos `.class` del proyecto

```bash
del /s *.class
```
