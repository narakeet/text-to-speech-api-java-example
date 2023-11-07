DOCKER_IMAGE_NAME ?= narakeet.com/docker-java-dev
MAKE_DIR := $(dir $(abspath $(lastword $(MAKEFILE_LIST))))
DOCKER_RUN := docker run --rm -v $(MAKE_DIR):/work -w /work -v $(MAKE_DIR).m2:/root/.m2 -v $(MAKE_DIR)output:/tmp -e NARAKEET_API_KEY
RUN := $(DOCKER_RUN) $(DOCKER_IMAGE_NAME)

execute: target/tts-streaming-example-1.0.0.jar
	$(RUN) mvn compile exec:java

init:
	docker build docker-java-dev -t $(DOCKER_IMAGE_NAME)

bootstrap:
	$(RUN) mvn install

shell:
	$(DOCKER_RUN) -it $(DOCKER_IMAGE_NAME)

target/tts-streaming-example-1.0.0.jar: src/main/java/com/narakeet/*.java pom.xml
	$(RUN) mvn compile

.PHONY: shell bootstrap init execute
