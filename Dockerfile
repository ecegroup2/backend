FROM openjdk:17-alpine

WORKDIR /app

COPY src/ src/
COPY mvnw .
COPY pom.xml .
COPY .mvn/ .mvn/

RUN chmod +x mvnw
RUN ./mvnw clean install

EXPOSE 9080

CMD [ "./mvnw" ,"spring-boot:run" ]