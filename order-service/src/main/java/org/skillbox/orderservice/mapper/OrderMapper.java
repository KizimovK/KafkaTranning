package org.skillbox.orderservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.skillbox.orderservice.model.Order;
import org.skillbox.event.OrderEvent;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    OrderEvent toOrderEvent(Order order);
}
