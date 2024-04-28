package org.skillbox.orderservice.service;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.skillbox.event.OrderEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final KafkaTemplate kafkaTemplate;

    @Value("${app.kafka.kafkaTopicSend}")
    private String topicSend;

    public void sendKafkaTopic(OrderEvent orderEvent) {
        UUID key  = UUID.randomUUID();
        log.info("Send in topic order-event {}", orderEvent);
        kafkaTemplate.send(topicSend, key, orderEvent);
    }

}
