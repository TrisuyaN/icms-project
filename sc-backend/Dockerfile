FROM openjdk:17
ADD /target/sc-backend-0.0.1-SNAPSHOT.jar //
ENV SPRING_PROFILES_ACTIVE=dc
ENTRYPOINT ["java", "-jar", "/sc-backend-0.0.1-SNAPSHOT.jar"]
