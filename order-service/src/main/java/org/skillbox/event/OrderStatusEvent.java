package org.skillbox.event;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class OrderStatusEvent implements Serializable {

    private OrderStatus orderStatus;
    private Instant date;


}
