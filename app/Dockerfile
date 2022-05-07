FROM adoptopenjdk/openjdk11:latest

WORKDIR /code

COPY . /code

RUN apt-get update && apt-get -y upgrade

RUN apt install -y maven

#RUN mvn clean package

EXPOSE 8080

RUN mvn clean install
CMD mvn spring-boot:run

#ENTRYPOINT ["java", "-jar", "target/*.jar"] 
