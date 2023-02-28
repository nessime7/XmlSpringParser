# XmlSpringParser

## Description:  
Service, which is parsing xml file into json response.

Key points:
- Gradle - build automation system, optionally there is also Gradle wrapper
- Java 11
- Spring Boot
- REST API

To build project, please use:
```
gradle build
```

To execute tests:
```
gradle test
```

To run program after build:
```
gradle run
```

After above execution, service will start at port 8080.

## Requests:

Example file: [users.xml](users.xml)

### Upload file:

Request:
```
curl --location --request POST 'http://localhost:8080/upload' \
--form 'file=@"/C:/PATH_TO_FILE/users.xml"'
```
Response:
```
200 OK

[
    {
        "name": "Kalle Anka",
        "email": "donald@email.dt",
        "username": "donaldd"
    },
    {
        "name": "Joakim von Anka",
        "email": "scrooge@email.dt",
        "username": "onkelscrooge"
    },
    {
        "name": "Arne Anka",
        "email": "arne@email.com",
        "username": "arneanka"
    }
]
```