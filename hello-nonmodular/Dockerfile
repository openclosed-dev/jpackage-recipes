FROM eclipse-temurin:21.0.6_7-jdk-noble

RUN apt update && apt install -y fakeroot

WORKDIR /home/ubuntu

COPY ./package-deb.sh /home/ubuntu
RUN mkdir -p /home/ubuntu/target

USER 1000:1000

CMD [ "/home/ubuntu/package-deb.sh" ]
