####
# This Dockerfile is used in order to build a container that runs the Spring Boot application
#
# Build the image with:
#
# docker build -f docker/Dockerfile -t springboot/sample-demo .
#
# Then run the container using:
#
# docker run -i --rm -p 8081:8081 springboot/sample-demo
####
FROM ubi8/openjdk-17
USER root
WORKDIR /deployments
RUN echo -e '#!/bin/bash\nmvn clean fabric8:deploy -Popenshift" > run-java.sh'

# Build dependency offline to streamline build
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src src
#RUN mvn package -Dmaven.test.skip=true
RUN mvn clean fabric8:deploy -Popenshift
