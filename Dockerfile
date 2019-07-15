FROM java:8
WORKDIR /usr
VOLUME /temp
COPY /target/docker-0.0.1-SNAPSHOT.jar /usr/docker.jar
EXPOSE 10086
CMD java -jar docker.jar