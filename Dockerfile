FROM openjdk:22-jdk-slim

LABEL maintainer="freddievaneijsden" \
      version="1.0" \
      description="A Java SPI application for cooking different cuisines."

WORKDIR /app

COPY Consumer/target/Consumer-1.0-SNAPSHOT.jar consumer.jar
COPY Interface/target/Interface-1.0-SNAPSHOT.jar interface.jar
COPY Provider/target/Provider-1.0-SNAPSHOT.jar provider.jar

EXPOSE 8080

ENTRYPOINT ["java", "--module-path", "consumer.jar:interface.jar:provider.jar", "-m", "com.example.consumer/com.example.consumer.Main"]
