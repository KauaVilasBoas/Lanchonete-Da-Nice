FROM maven:3.8.5-openjdk-17
ARG JAR_FILE=out/artifacts/lanchonete_da_Nice_jar/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]