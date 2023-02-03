FROM openjdk:8
EXPOSE 8083
ADD target/billing-apps.jar billing-apps.jar
ENTRYPOINT ["java","-jar","/billing-apps.jar"]