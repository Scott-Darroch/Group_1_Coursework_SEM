FROM openjdk:latest
COPY ./target/Group_1_Coursework_SEM-0.1.0.10-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Group_1_Coursework_SEM-0.1.0.10-jar-with-dependencies.jar", "db:3306"]