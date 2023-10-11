# TP3_ArquitecturaWeb
Trabajo entregable 3 de la materia Arquitectura Web: Servicios REST y SpringBoot

## Obtener un estudiante por su DNI
**Method:** GET  
**URL:** /api/students/dni/:dni  
**Response:** 200 OK  
**Example:** `localhost:8080/api/students/dni/3929710`  
## Obtener todos los estudiantes ordenados por DNI
**Method:** GET  
**URL:** /api/students/dni  
**Response:** 200 OK  
**Example:** `localhost:8080/api/students/dni`  
## Obtener estudiantes según su género
**Method:** GET  
**URL:** /api/students/:genre  
**Response:** 200 OK  
**Example:** `localhost:8080/api/students/m`  
## Obtener estudiante por su número de libreta universitaria
**Method:** GET  
**URL:** /api/students/:studentId  
**Response:** 200 OK   
**Example:** `localhost:8080/api/students/studentID/23798`  
## Buscar estudiantes según ciudad y carrera
**Method:** GET  
**URL:** /api/students/search/:careerName/:city  
**Response:** 200 OK   
**Example:** `localhost:8080/api/students/search/tuari/tandil`  
## Obtener carreras ordenadas por cantidad de inscriptos
**Method:** GET  
**URL:** /api/careers/orderBy/quantity  
**Response:** 200 OK  
**Example:** `localhost:8080/api/careers/orderBy/quantity`  
## Obtener un reporte de las carreras
**Method:** GET  
**URL:** /api/enrolled/report  
**Response:** 200 OK  
**Example:** `localhost:8080/api/enrolled/report`  

