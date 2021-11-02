FROM openjdk:17
EXPOSE 8080
ADD target/test_app.jar test_app.jar
ENTRYPOINT ["java","-jar","/test_app.jar"]