FROM ubuntu

EXPOSE 9020

RUN apt-get update
RUN apt-get install -y wget
RUN apt-get install -y nano
RUN apt-get install -y net-tools
RUN apt-get install -y default-jre

WORKDIR /opt

RUN wget https://www-eu.apache.org/dist/kafka/2.2.0/kafka_2.11-2.2.0.tgz
RUN tar -xvzf *.tgz
COPY server.properties /opt/kafka_2.11-2.2.0/config/server.properties
COPY kafka_server_jaas.conf /opt/kafka_2.11-2.2.0/config/kafka_server_jaas.conf

ENV KAFKA_OPTS=-Djava.security.auth.login.config=/opt/kafka_2.11-2.2.0/config/kafka_server_jaas.conf

ENTRYPOINT /opt/kafka_2.11-2.2.0/bin/kafka-server-start.sh /opt/kafka_2.11-2.2.0/config/server.properties 