# Brave Talent Java 

Java Project for Brave Talent developer test.

## REST API 

The `host` and `port` for the Java API is `188.226.159.24:8080`

### API Documentation

Copy [the contents](https://github.com/nigelnindo/brave_talent_java/blob/master/swagger.yaml) of the Swagger YAML file into a Swagger Editor of your choice. If you don't have one, use the online editor found [here](https://editor2.swagger.io/). This it will then auto-generate the formatted documentation for you.

### Examples

```shell
# Extract a number plate from a sentence 
$ curl -X GET "http://188.226.159.24:8080/api/extractor?sentence=Ken%20had%20a%20KCA%20001a%20yesterday." -H "accept: application/json"

# JSON result from API call
{"result":"KCA 001A"}

# Get the Difference between two number plates
$ curl -X GET "http://188.226.159.24:8080/api/difference?firstPlate=KAZ%20999Z&secondPlate=KBA%20001A" -H "accept: application/json"

# JSON result from API call
{"result":1}

```

## Docker

This project can be run as a Docker container.

### Run with Docker

[Install](https://docs.docker.com/engine/installation/) Docker for you Operating System. Beyond the scope of this document.

```shell
# Pull latest image from the public repository
$ docker pull nigelnindo/brave-talent

# Run the image and bind ports
docker run -d -p 8080:8080 nigelnindo/brave-talent
```

Visit localhost:8080 on your browser.

## Build from Source

Requires [Maven](https://maven.apache.org/).

```shell
# Compile the project 
mvn compile

# Run tests and package into jar file in your local /target folder
mvn package
```

## Test

```shell
mvn test
```

## Class diagram

[Open](https://github.com/nigelnindo/brave_talent_java/blob/develop/Class_Diagram.png) `Class_Diagram.png`

## Deployment

[Deployment 1](https://github.com/nigelnindo/brave_talent_java/blob/develop/deployment_1.png) outlines the build process from local to DockerHub, and [Deployment 2](https://github.com/nigelnindo/brave_talent_java/blob/develop/deplyoment_2.png) outlines the build process from DockerHub to the a client connection.
