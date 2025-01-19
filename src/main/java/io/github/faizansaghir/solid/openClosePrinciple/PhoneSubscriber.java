package io.github.faizansaghir.solid.openClosePrinciple;

public class PhoneSubscriber extends Subscriber{
    private final Float baseRate;
    private final SubscriberUsageRegistry subscriberUsageRegistry;

    public PhoneSubscriber(Long id, Float baseRate, SubscriberUsageRegistry subscriberUsageRegistry) {
        super(id);
        this.baseRate = baseRate;
        this.subscriberUsageRegistry = subscriberUsageRegistry;
    }

    @Override
    public Float calculateBill() {
        return subscriberUsageRegistry.getUsage(this)*baseRate;
    }
}
