# Country Service
A Spring Boot Application that will convert REST calls to SOAP


## Requirements
- Java 21
- Maven

## Setup

1. Create a Keystore to enable SSL

```bash
keytool -genkey -keystore src/main/resources/keystore.p12 -storetype PKCS12 -storepass changeit -alias ssl -keyalg RSA -sigalg SHA256withRSA -validity 365 -keysize 4096
```

2. Compile the project
```bash
mvn clean package
```

3. Run the Project
```bash
mvn spring-boot:run
```

4. Access the API from here
- [REST](https://localhost:8443/restapi/v1/swagger-ui/index.html) 
