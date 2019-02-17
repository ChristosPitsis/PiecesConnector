FROM alpine/git
WORKDIR /myapp
RUN git clone https://github.com/ChristosPitsis/PiecesConnector.git

FROM maven:3.5-jdk-8-alpine
WORKDIR /myapp
COPY --from=0 /myapp/PiecesConnector /myapp
RUN mvn clean install

FROM openjdk:8-jre-alpine
WORKDIR /myapp
COPY --from=1 /myapp/target/PiecesConnector.jar /myapp
COPY --from=1 /myapp/target/lib/hipster-all-1.0.0-rc2.jar /myapp/lib/
COPY --from=1 /myapp/testFile /myapp
CMD java -jar PiecesConnector.jar testFile
