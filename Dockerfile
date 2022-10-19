FROM openjdk:18.0.2.1-jdk
ADD . /src
WORKDIR /src
RUN sed -i 's/\r$//' mvnw
RUN ./mvnw clean package -DskipTests
EXPOSE 8080
ENTRYPOINT ["java","-jar","target/soapUserService-0.0.1-SNAPSHOT.jar"]