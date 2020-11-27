# SpringWebflux_MongoDB
Microservicio reactivo desarrollado en Spring Webflux realizando conexión a una base de datos MongoDB (Lectura/Escritura)

    Para ejecutar el proyecto via docker se debe hacer lo siguiente:
     
     Limpiar y construir el jar:
     - `./gradlew clean build`
     
     Construir imagenes docker
     - `docker-compose build`
     
     Iniciar contenedores MongoDB y Spring
     - `docker-compose up`
        
   **Endpoint**
   - GET http://localhost:8082/actuator/health
   - GET http://localhost:8082/v1/users
   - GET http://localhost:8082/v1/users/{id}
   - POST http://localhost:8082/v1/users
   - PUT http://localhost:8082/v1/users/{id}
   - DELETE http://localhost:8082/v1/users/{id}
   
   
   
