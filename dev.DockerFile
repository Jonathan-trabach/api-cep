FROM maven:3.6.3-jdk-11 AS packager

RUN mkdir -p /api-cep

RUN cd /api-cep

WORKDIR /api-cep

ADD ./pom.xml .
ADD ./docker-entrypoint.sh /

RUN mvn clean install -X -f ./pom.xml

COPY ./ .


RUN mvn package -Dmaven.test.skip=true && \
    mv ./target/*.jar /run/api-cep-docker.jar

FROM openjdk:11

COPY --from=packager /run/api-cep-docker.jar /var/api-cep/api-cep-docker.jar
COPY --from=packager /docker-entrypoint.sh /docker-entrypoint.sh

RUN chmod +x /docker-entrypoint.sh

EXPOSE 8080

ENTRYPOINT [ "bash", "/docker-entrypoint.sh" ]