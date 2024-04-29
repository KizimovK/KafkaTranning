package org.skillbox.orderstatusevent.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.skillbox.event.OrderStatus;
import org.skillbox.event.OrderStatusEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderStatusEventService {

    @Value("${app.kafka.kafkaTopicSend}")
    private String topicSend;

    private final KafkaTemplate kafkaTemplate;

    public void send(UUID key) {

        OrderStatusEvent orderStatusEvent = new OrderStatusEvent();
        orderStatusEvent.setOrderStatus(OrderStatus.CREATED);
        orderStatusEvent.setDate(Instant.now());
        log.info("Send message in topic {}: {}", topicSend, orderStatusEvent);
        kafkaTemplate.send(topicSend, key, orderStatusEvent);
    }
}
