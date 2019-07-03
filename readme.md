# Securing Kafka

## Configuring Kafka Security

https://kafka.apache.org/documentation/#security_sasl_plain

## Connecting Clients to Secured Kafka

You can use the bat/sh utilities under your local Kafka install to test connection to a secured Kafka instance.

First, you need to create a file that contains the connection protocol settings, called `kafka_client_jaas.conf`:

```
KafkaClient {
	org.apache.kafka.common.security.plain.PlainLoginModule required
	username="alice" 
	password="alice-secret";
};
```

Then, you need to open a console where you will run a consument, and in that console export a `KAFKA_OPTS` environment variable that contains a jvm property that points to this file (windows):

```
set KAFKA_OPTS=-Djava.security.auth.login.config=C:\kafka_2.11-2.2.0\bin\windows\kafka_client_jaas.conf
```

You also need a `producer.properties` file, that specifies what connection protocol should be used:

```
security.protocol=SASL_PLAINTEXT
sasl.mechanism=PLAIN
```

Now you can run the producer:

```
kafka-console-producer.bat --broker-list localhost:9095 --topic test --producer.config producer.properties
```

On the consumer side you will need to perform the same steps. Open a console and set the `KAFKA_OPTS` environment variable pointing to the same file. And when invoking the consumer you can actually use the `producer.properties` file:

```
kafka-console-consumer.bat --bootstrap-server localhost:9095 --topic test --from-beginning --consumer.config producer.properties
```

## Connect Spark Streaming to secured Kafka

After many attempts, I managed to find the correct way to configure spark to read from the authenticated kafka.

https://community.hortonworks.com/questions/6332/how-to-read-from-a-kafka-topic-using-spark-streami.html
https://elephant.tech/spark-2-0-streaming-from-ssl-kafka-with-hdp-2-4/