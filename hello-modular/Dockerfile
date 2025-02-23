FROM eclipse-temurin:21.0.6_7-jdk-noble

RUN apt-get update && apt install -y make fakeroot

USER ubuntu:ubuntu
WORKDIR /home/ubuntu

RUN mkdir -p /home/ubuntu/target

COPY --chown=ubuntu:ubuntu ./Makefile /home/ubuntu

CMD [ "make", "all" ]
