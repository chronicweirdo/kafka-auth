FROM ubuntu

EXPOSE 2181

RUN apt-get update
RUN apt-get install -y wget
RUN apt-get install -y nano
RUN apt-get install -y net-tools
RUN apt-get install -y default-jre

WORKDIR /opt

RUN wget https://www-eu.apache.org/dist/zookeeper/zookeeper-3.5.5/apache-zookeeper-3.5.5-bin.tar.gz
RUN tar -xvzf *.tar.gz
RUN cp apache-zookeeper-3.5.5-bin/conf/zoo_sample.cfg apache-zookeeper-3.5.5-bin/conf/zoo.cfg

ENTRYPOINT apache-zookeeper-3.5.5-bin/bin/zkServer.sh start-foreground