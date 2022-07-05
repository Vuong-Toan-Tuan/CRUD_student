FROM gradle:7.4.2-jdk18 AS build
COPY --chown=gradle:gradle . extracted
WORKDIR extracted
# ADD ./target/*.jar app.jar
ADD ${JAR_FILE} app.jar
RUN gradle build --no-daemon
# RUN java -Djarmode=layertools -jar app.jar extract


FROM openjdk:18-jdk-slim
WORKDIR application
# COPY --from=build extracted/dependencies/ ./
# COPY --from=build extracted/spring-boot-loader/ ./
# COPY --from=build extracted/snapshot-dependencies/ ./
# COPY --from=build extracted/application/ ./
COPY --from=build extracted/build/libs/*.jar /application/spring-boot-application.jar

EXPOSE 8083

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]