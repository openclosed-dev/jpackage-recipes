FROM eclipse-temurin:21.0.6_7-jdk-noble

RUN apt update && apt install -y fakeroot

USER ubuntu:ubuntu
WORKDIR /home/ubuntu

RUN mkdir -p /home/ubuntu/target

COPY --chown=ubuntu:ubuntu ./package-deb.sh /home/ubuntu

CMD [ "/bin/bash", "/home/ubuntu/package-deb.sh" ]
