package io.github.faizansaghir.solid.openClosePrinciple;

import java.util.HashMap;
import java.util.Map;

public class SubscriberUsageRegistry {
    private Map<Long, Float> subscriberUsage;
    public SubscriberUsageRegistry() {
        subscriberUsage = new HashMap<>();
    }
    public Float recordUsage(Float duration, Subscriber subscriber) {
        Long subscriberId = subscriber.getId();
        Float previousUsage = subscriberUsage.getOrDefault(subscriberId, 0.0f);
        subscriberUsage.put(subscriberId, previousUsage + duration);
        return subscriberUsage.get(subscriberId);
    }

    public Float getUsage(Subscriber subscriber) {
        return subscriberUsage.getOrDefault(subscriber.getId(), 0.0f);
    }

    public void clearUsage() {
        subscriberUsage.clear();
    }
}
