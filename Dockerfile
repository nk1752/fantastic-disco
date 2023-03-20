FROM openjdk:17-alpine

# set timezone in docker container
ENV TZ=America/Chicago
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#.crt file in the same folder as your Dockerfile
# COPY . /etc/ssl/certs/

RUN addgroup -S ned && adduser -S ned -G ned
USER ned:ned

EXPOSE 8080

# configure ARG with --build-arg jar=
# ARG project
# ARG branch
# ARG commit
# ARG job
# ARG build
# ARG date
ARG jar

# LABEL project=$project
# LABEL branch=$branch
# LABEL commit=$commit
# LABEL job=$job
# LABEL build=$build
# LABEL date=$date

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} apiserver.jar
# ENTRYPOINT ["java","-jar","/nk-poc.jar"]
ENTRYPOINT exec java -jar /apiserver.jar