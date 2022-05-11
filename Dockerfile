FROM maven AS BUILDER
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN mvn clean install

FROM openjdk:11
WORKDIR /usr/src/myapp
COPY --from=BUILDER /usr/src/myapp/target/learning-0.0.1-SNAPSHOT.war .
EXPOSE 8080
CMD ["java", "-jar", "learning-0.0.1-SNAPSHOT.war"]
