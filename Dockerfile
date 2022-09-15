FROM maven:3.6.1-jdk-8-alpine
COPY pom.xml .
RUN mvn verify clean