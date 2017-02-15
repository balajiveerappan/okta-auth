# Spring Boot OAuth2 Okta Micro servcie

Spring Boot OAuth2 Micro servcie - Resource Server integrated with Okta Authorization server.

## Pre-requisite

  - Install Docker Toolbar - [Windows Installation].
  - Install Java 8 and Maven and GIT

## Source
Get source code:
```sh
https://git-codecommit.us-east-1.amazonaws.com/v1/repos/okta-auth-service
```

## Local
Run the application locally:

```sh
cd okta-auth-service
mvn spring-boot:run
```

## Docker

##### Build Docker image :

Start docker deamon via Docker Quickstart Terminal shortcut.

```sh
cd okta-auth-service
mvn package docker:build
```

This will create the **wb-docker-repo/okta-auth-service** Docker image. 

##### Run Docker image :

Once done, run the Docker image and map the port to whatever you wish on your host. In this example, we simply map port 8000 of the host to port 80 of the Docker (or whatever port was exposed in the Dockerfile):

```sh
docker run -d -p 8000:8080 wb-docker-repo/okta-auth-service
```

Verify the deployment by navigating to your server address in your preferred browser.

```sh
<docker-machine-ip-address>:8000
```

where ***docker-machine-ip-address*** is the IP Address of the VM which is running docker deamon. You can find the IP in Docker Quickstart Terminal when docker is started.


## API 

##### End-points

1. Secured Dummy URL - This requires Access Token - http://okta-auth-service/api/
2. Unsecured Token URL - This is used to POST Okta User credentials and get Access Token - http://192.168.99.100:8082/api/public/token

##### Usage - Curl commands

1. Get Access Token:
```sh
curl -X POST http://okta-auth-service/api/public/token -d '{"username":"okta-user-email", "password":"okta-user-password"}' -H "Content-Type:application/json"
```

2. Use above access Token to access secured endpoints:
   Copy **access_token** from above response to use in below request.
```sh
curl -vi -H "Authorization: Bearer **access_token**" http://okta-auth-service/api/
```

where ***okta-auth-service*** is the IP Address of the VM which is running docker deamon.


[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [Windows Installation]: <https://docs.docker.com/toolbox/toolbox_install_windows>
