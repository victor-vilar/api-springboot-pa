FROM amazoncorretto:17-alpine3.17
WORKDIR /app
COPY ./src ./src && pom.xml .
RUN ./mvnw clean package
CMD ["java","-cp","./target/"]
