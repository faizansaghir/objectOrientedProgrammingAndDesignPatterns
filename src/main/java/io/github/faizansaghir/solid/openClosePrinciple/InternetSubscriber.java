package io.github.faizansaghir.solid.openClosePrinciple;

public class InternetSubscriber extends Subscriber{
    private final Float monthlyRent;
    private final Float freeUsageLimit;
    private final SubscriberUsageRegistry subscriberUsageRegistry;

    public InternetSubscriber(Long id, Float monthlyRent, Float freeUsageLimit, SubscriberUsageRegistry subscriberUsageRegistry) {
        super(id);
        this.monthlyRent = monthlyRent;
        this.freeUsageLimit = freeUsageLimit;
        this.subscriberUsageRegistry = subscriberUsageRegistry;
    }

    @Override
    public Float calculateBill() {
        Float totalUsage = subscriberUsageRegistry.getUsage(this);
        if(totalUsage<=freeUsageLimit){
            return 0.0f;
        }
        return (totalUsage-freeUsageLimit)*monthlyRent;
    }
}
