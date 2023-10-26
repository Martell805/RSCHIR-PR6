FROM openjdk:17-oracle

COPY target/RSCHIR-PR6-1.0.jar app.jar
CMD ["java","-jar","/app.jar"]
