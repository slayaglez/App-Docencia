<img src="img/docencia_header.png">

> *Un expositor de mis habilidades en Java orientado a objetos*

<hr>

## ¿Por qué este proyecto?

Esta aplicación es el resumen perfecto de todo lo aprendido en Java hasta ahora de forma limpia y compacta. Algunos métodos no son la forma más óptima de conseguir el objetivo planteado pero decidí hacerlo en la forma en la que lo hice para practicar, pues métodos como la recursividad no tienen cabida en una aplicación como esta.

<hr>

## La app

Es una aplicación para registrar usuarios, como alumnos o profesores, y buscar cada uno siguiendo diferentes patrones de búsqueda. De momento los datos se guardan en una lista que evita duplicados, así que los datos se borrarán al cerrar el programa.

### Características
- [ ] Registro de personas
- [ ] Búsqueda de personas por id, documento, prefijo o límite de edad
- [ ] Prevención de duplicados con listas Set

<hr>

## Stack técnico

| Herramienta | Versión | Uso |
|-------------|---------|-----|
| Java | 17 | Lenguaje principal |
| Maven | latest | entorno de ejecución |
| VisualStudioCode | latest | IDE / entorno de creación |


<hr>


## Estructura del proyecto

```
.
├── pom.xml
├── README.md
├── src
│   └── main
│       └── java
│           └── com
│               └── docencia
│                   ├── app
│                   │   └── Main.java
│                   ├── model
│                   │   ├── Alumno.java
│                   │   ├── Persona.java
│                   │   └── Profesor.java
│                   ├── service
│                   │   └── CentroEducativo.java
│                   └── util
│                       └── Validaciones.java
├── target
│   └── classes
│       └── com
│           └── docencia
│               ├── app
│               ├── model
│               ├── service
│               └── util
│   
└── tools

```




<hr>

*Proyecto desarrollado como ejercicio personal de bajo nivel. 100% ensamblador, 0% librerías externas.*
