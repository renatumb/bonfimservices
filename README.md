
# Bonfim Services

Project designed to explore and implement microservices architecture.


## 🛠 Skills
Spring boot, Spring Cloud( OpenFeign, Eureka, API Gateway, Sleuth), Zipkin , AMQP(Advanced Message Queuing Protocol), RabbitMq, Docker, Docker Compose, Lombok, Jib, Spring Boot Maven Plugin. 


## ⚙️ Installation

Build the project with

```bash
  mvn clean package
```

To generate docker images use the profile **build-docker-image-xxx**
- It will generate and push the generated docker images to docker hub using the **jib-maven-plugin**


```bash
  mvn clean package -P build-docker-image-xxx
```

## 🔨 Deployment

To deploy this project run

```bash
  docker compose -d
```


## 🪪 Authors

- [@renatumb](https://github.com/renatumb)  
- 🌐 https://renatobonfim.com  

