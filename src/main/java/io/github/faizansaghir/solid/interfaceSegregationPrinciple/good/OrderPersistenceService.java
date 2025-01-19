package io.github.faizansaghir.solid.interfaceSegregationPrinciple.good;

import io.github.faizansaghir.solid.interfaceSegregationPrinciple.common.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderPersistenceService implements EntityPersistenceService<Order> {
    Map<Integer, Order> orderMap;

    public OrderPersistenceService() {
        orderMap = new HashMap<>();
    }

    @Override
    public void save(Order entity) {
        synchronized (this) {
            orderMap.put(entity.getId(), entity);
        }
    }

    @Override
    public Order getById(Integer id) {
        return orderMap.getOrDefault(id, null);
    }
}
