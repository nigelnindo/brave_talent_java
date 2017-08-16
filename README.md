# Brave Talent Java 

Java Project for Brave Talent developer test.

## REST API documentation

Copy [the](https://github.com/nigelnindo/brave_talent_java/blob/develop/swagger.yaml) contents of the Swagger YAML file into s Swagger Editor of your choice. If you don't have one, use the online editor found [here](https://editor2.swagger.io/). This it will then auto-generate the formatted documentation for you.

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

Requires that you have [Maven](https://maven.apache.org/).

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
