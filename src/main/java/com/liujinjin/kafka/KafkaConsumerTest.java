package com.liujinjin.kafka;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

/**
 * Created by liuxin on 2022/7/20.
 */
public class KafkaConsumerTest {

  public static void main(String[] args) {
    Properties props = new Properties();
    props.put("bootstrap.servers", "master:9092,slave1:9092,slave2:9092");
    props.put("group.id", "");
    props.put("enable.auto.commit", "true");
    props.put("auto.commit.interval.ms", "1000");
    props.put("session.timeout.ms", "30000");
    props.put("max.poll.records", 1000);
    props.put("auto.offset.reset", "earliest");
    props.put("key.deserializer", StringDeserializer.class.getName());
    props.put("value.deserializer", StringDeserializer.class.getName());
    KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
    consumer.subscribe(Arrays.asList(""));

    ConsumerRecords<String, String> msgList = consumer.poll(Duration.ofMillis(1000));


  }
}
