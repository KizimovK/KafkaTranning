package org.skillbox.orderservice.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.skillbox.event.OrderStatusEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaMessageListener {

    @KafkaListener(
            topics = "${app.kafka.kafkaTopicReceive}",
            groupId = "${app.kafka.kafkaGroupId}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listener(@Payload OrderStatusEvent orderStatusEvent,
                         @Header(value = KafkaHeaders.RECEIVED_KEY, required = false) UUID key,
                         @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                         @Header(KafkaHeaders.RECEIVED_PARTITION) Integer partition,
                         @Header(KafkaHeaders.RECEIVED_TIMESTAMP) Long timestamp){
        log.info("Received message order-status-topic: {}", orderStatusEvent);
        log.info("Key: {}; Partition: {}; Topic: {}; Timestamp: {}", key, partition, topic, timestamp);
    }
}
