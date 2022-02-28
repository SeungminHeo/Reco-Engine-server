FROM java:8

EXPOSE 8080

ARG JAR_FILE=build/libs/Reco-Engine-Server-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} Reco-Engine-Server.jar

RUN touch /tmp/healthy  # To control readiness of container

ENTRYPOINT ["java","-jar","-Xms256M", "-Xmx1536M", "/Reco-Engine-Server.jar"]
