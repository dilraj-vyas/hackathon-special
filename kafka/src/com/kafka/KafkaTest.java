package com.kafka;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.ProducerConfig;
import kafka.producer.KeyedMessage;

public class KafkaTest {

	public static void main(String[] args) throws InterruptedException {
		Properties props=new Properties();
		props.put("zk.connect", "localhost:2181");
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		props.put("metadata.broker.list", "localhost:9092");
		ProducerConfig config=new ProducerConfig(props);
		Producer producer=new Producer(config);
//		Producer producer=new Producer(config);
		String msg="hellow brother";
		for (int i = 0; i < 100; i++) {
			
			producer.send(new KeyedMessage("javainuse-topic",msg+i));
			Thread.sleep(1000);
		}
		
//		producer.send(new KeyedMessage("javainuse-topic", message));
		
	}
}
